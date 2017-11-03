var editContent=null;
var books=null;
var head=" <tr>\n" +
    "        <td align=\"center\"><input type=\"checkbox\"></td>\n" +
    "        <td height=\"50px\" align=\"center\">序号</td>\n" +
    "        <td align=\"center\">ID</td>\n" +
    "        <td align=\"center\">书名</td>\n" +
    "        <td align=\"center\">状态</td>\n" +
    "        <td align=\"center\">书本所属</td>\n" +
    "        <td align=\"center\">联系方式</td>\n" +
    "        <td align=\"center\">编辑</td>\n" +
    "        <td align=\"center\">删除</td>\n" +
    "    </tr>";
$('.uploadTable').append(head);
getBooks();

$(document).on('click','.pages li',function(){
    $('.pages li').css('background-color','white');
    $('.pages li').css('color','black');
    $(this).css('background-color','dodgerblue');
    $(this).css('color','white');
    var pageTotal='';
    var index=$(this).index();
    var length=10*(index+1);
    $.ajax({
    url:'/system/book/getBook',
    type:'get',
    dataType: "json", // 返回JSON格式的数据
    success:function(data){
        books = data;
        if(books.length<10*(index+1)){
            length=books.length;
        }
        for(var i=index*10;i<length;i++){
            var tr="<tr>" +"<td align='center'><input type='checkbox'></td>"+
                "<td align='center'>"+i+"</td>"+
                "<td align='center'>"+books[i].bookId+"</td>"+
                "<td align='center'>"+books[i].bookName+"</td>"+
                "<td align='center'>"+books[i].bookState+"</td>"+
                "<td align='center'>"+books[i].uploadAuthor+"</td>"+
                "<td align='center'>"+books[i].phoneNumber+"</td>"+
                "<td align='center' class='edit'>编辑</td>" +
                "<td align='center' class='remove'>删除</td></tr>";
            pageTotal+=tr;
        }
        $('.uploadTable').html('');
        $('.uploadTable').append(head);
        $('.uploadTable').append(pageTotal);
    },
    error:function(){
        console.log('lkijiji');
    }
});
});
$(document).on('click','.add',function(){
    var add='<div class="backgroundTable">\n' +
        '    <div class="addTable">\n' +
        '        <div class="header">编辑<span class="tips"></span></div>\n' +
        '        <table>\n' +
        '            <tr>\n' +
        '                <td align="right">ID</td>\n' +
        '                <td><input type=\'text\' id="bookId" required="required"/></td>\n' +
        '            </tr>\n' +
        '            <tr>\n' +
        '                <td align="right">书名</td>\n' +
        '                <td><input type=\'text\' id="bookName" required="required"/></td>\n' +
        '            </tr>\n' +
        '            <tr>\n' +
        '                <td align="right">状态</td>\n' +
        '                <td><input type=\'text\' id="bookState" required="required"/></td>\n' +
        '            </tr>\n' +
        '            <tr>\n' +
        '                <td align="right">姓名</td>\n' +
        '                <td><input type=\'text\' id="uploadAuthor" required="required"/></td>\n' +
        '            </tr>\n' +
        '            <tr>\n' +
        '                <td align="right">手机</td>\n' +
        '                <td><input type=\'text\' id="phoneNumber" required="required"/></td>\n' +
        '            </tr>\n' +
        '        </table>\n' +
        '        <div class="footer">\n' +
        '            <ul>\n' +
        '                <li class="addSure">确定</li>\n' +
        '                <li class="addCancle">取消</li>\n' +
        '            </ul>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</div>';
    $(document.body).append(add);
});
$(document).on('click','.addCancle',function(){
    $('.backgroundTable').remove();
});
$(document).on('click','.addSure',function(){
    if($('#bookId').val()==''||$('#bookName').val()==''||$('#uploadAuthor').val()==''||$('#phoneNumber').val()==''){
        $(".tips").html('信息不全！！');
        $(".tips").css('color','red');
        return false;
    }
    else{
        $.ajax({
            url:'/system/book/saveBook',
            type:'get',
            data:{'bookId':$('#bookId').val(),'bookName':$('#bookName').val(),
                'bookState':$('#bookState').val(),'uploadAuthor':$('#uploadAuthor').val(),
                'phoneNumber':$('#phoneNumber').val()
            },
            success:function(){
                $(".tips").html('保存成功！！');
                $(".tips").css('color','red');
                setTimeout(function(){
                    $('.backgroundTable').remove();
                    var addTr="<tr>" +"<td align='center'><input type='checkbox'></td>"+
                        "<td align='center'>"+$(".uploadTable tr").length+"</td>"+
                        "<td align='center'>"+$('#bookId').val()+"</td>"+
                        "<td align='center'>"+$('#bookName').val()+"</td>"+
                        "<td align='center'>"+'1本'+"</td>"+
                        "<td align='center'>"+$('#uploadAuthor').val()+"</td>"+
                        "<td align='center'>"+$('#phoneNumber').val()+"</td>"+
                        "<td align='center' class='edit'>编辑</td>" +
                        "<td align='center' class='remove'>删除</td></tr>";
                   // $('.uploadTable').append(addTr);
                    $('.backgroundTable').remove();
                    $('#bookId').val('');$('#bookName').val('');
                    $('#uploadAuthor').val('');$('#phoneNumber').val('');
                },2000)
            },
            error:function(){
                console.log('lkijiji');
            }
        });

    }

});
$(document).on('click','.remove',function(){
    $(this).parent().remove();
});
var editIndex;
$(document).on('click','.edit',function(){
    editContent=$(this).parent();
    editIndex=$(this).parent().index();
    var edit="<div class='backgroundTables'>\n" +
        "    <div class='addTables'>\n" +
        "        <div class=\"header\">编辑<span class=\"tips\"></span></div>\n" +
        "        <table>\n" +
        "            <tr>\n" +
        "                <td align=\"right\">ID</td>\n" +
        "                <td><input type='text' id=\"bookId\" required=\"required\" value='"+editContent.find('td:eq(2)').text()+"'/></td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td align=\"right\">书名</td>\n" +
        "                <td><input type='text' id=\"bookName\" required=\"required\" value='"+editContent.find('td:eq(3)').text()+"'/></td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td align=\"right\">状态</td>\n" +
        "                <td><input type='text' id=\"bookState\" required=\"required\" value='"+editContent.find('td:eq(4)').text()+"'/></td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td align=\"right\">姓名</td>\n" +
        "                <td><input type='text' id=\"uploadAuthor\" required=\"required\" value='"+editContent.find('td:eq(5)').text()+"'/></td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td align=\"right\">手机</td>\n" +
        "                <td><input type='text' id=\"phoneNumber\" required=\"required\" value='"+editContent.find('td:eq(6)').text()+"'/></td>\n" +
        "            </tr>\n" +
        "        </table>\n" +
        "        <div class=\"footer\">\n" +
        "            <ul>\n" +
        "                <li class=\"editSures\">确定</li>\n" +
        "                <li class='editCancles'>取消</li>\n" +
        "            </ul>\n" +
        "        </div>\n" +
        "    </div>\n" +
        "</div>";
    $(document.body).append(edit);
});
$(document).on('click','.editCancles',function(){
    $('.backgroundTables').remove();
});
$(document).on('click','.editSures',function(){
    var bookId=$(this).parent().parent().prev().find($('#bookId'))[0].value;
    var bookName=$(this).parent().parent().prev().find($('#bookName'))[0].value;
    var bookState=$(this).parent().parent().prev().find($('#bookState'))[0].value;
    var uploadAuthor=$(this).parent().parent().prev().find($('#uploadAuthor'))[0].value;
    var phoneNumber=$(this).parent().parent().prev().find($('#phoneNumber'))[0].value;
    $.ajax({
        url:'/system/book/updateBook',
        type:'get',
        data:{'id':editIndex,'bookId':$('#bookId').val(),'bookName':$('#bookName').val(),
            'bookState':$('#bookState').val(),'uploadAuthor':$('#uploadAuthor').val(),
            'phoneNumber':$('#phoneNumber').val()
        },
        success:function(){
            $(".tips").html('编辑成功！！');
            $(".tips").css('color','red');
            setTimeout(function(){
                $('.backgroundTables').remove();
                var selectId=$('.uploadTable').find('tr:eq('+editIndex+')');
                selectId.find('td:eq(2)').html(bookId);
                selectId.find('td:eq(3)').html(bookName);
                selectId.find('td:eq(4)').html(bookState);
                selectId.find('td:eq(5)').html(uploadAuthor);
                selectId.find('td:eq(6)').html(phoneNumber);
            },2000);
        },
        error:function(){

        }
    });

});


function getBooks(){
    $.ajax({
        url:'/system/book/getBook',
        type:'get',
        dataType: "json", // 返回JSON格式的数据
        success:function(data){
            console.log(data);
            var pagesNum=Math.ceil(data.length/10);
             books=data;
            var trTotal='',liTotal='',length=10;
            if(books.length<10){
                length=books.length;
            }
            for(var i=0;i<length;i++){
                var tr="<tr>" +"<td align='center'><input type='checkbox'></td>"+
                    "<td align='center'>"+i+"</td>"+
                    "<td align='center'>"+books[i].bookId+"</td>"+
                    "<td align='center'>"+books[i].bookName+"</td>"+
                    "<td align='center'>"+books[i].bookState+"</td>"+
                    "<td align='center'>"+books[i].uploadAuthor+"</td>"+
                    "<td align='center'>"+books[i].phoneNumber+"</td>"+
                    "<td align='center' class='edit'>编辑</td>" +
                    "<td align='center' class='remove'>删除</td></tr>";
                trTotal+=tr;
            }
            $('.uploadTable').append(trTotal);
            for(var j=1;j<pagesNum+1;j++){
                var li='<li>'+j+'</li>';
                liTotal+=li;
            }
            $('.pages').append(liTotal);
        },
        error:function(){
            console.log('lkijiji');
        }
    });

}