var data=[];
$(function(){

//时间选择器
laydate.render({
  elem: '#beginTime'
  ,type: 'datetime'
});
//时间选择器
laydate.render({
  elem: '#endTime'
  ,type: 'datetime'
});


   var obj =  buildRequestParameter();
   requestAndRender(obj)

   $("#search").on('click',function(){
        var param = {};
         param.start = $("#beginTime").val();
            param.end = $("#endTime").val();
            if(!param.start) {
                layer.alert('请选择开始时间',1000);
                return false;
            }

            if(!param.end) {
                layer.alert('请选择结束时间',1000);
                return false;
            }

            requestAndRender(param);
   })

   $('#error_list').on('click','.param',function(){
       var i =  $(this).data('p');
       layer.open({
         type: 1,
         title: '开票参数',
         shadeClose: true,
         shade: 0.8,
         area: ['680px', '90%'],
         content: data[i].issueParam
       });
   })
})

function requestAndRender(obj) {
 var json = JSON.stringify(obj);
    $.ajax({
        url:"/api/records/list",
        async:false,
         contentType: 'application/json;charset=utf-8',
        type: 'POST',
        data:json,
        dataType:"json",
        success:function(ret) {
            console.log(ret);
           renderErrorLists(ret);
            data=ret;
        },
        error:function(ret){
            console.log(ret);
        }
    })
}

function buildRequestParameter(){
    var param = {};
    param.start = $("#beginTime").val();
    param.end = $("#endTime").val();
    return param;
}

function tableHtml() {
    return `<table border="1">
                                <tr>
                                    <th>id</th>
                                    <th>票号</th>
                                    <th>票代码</th>
                                    <th>开票类型</th>
                                    <th>错误原因</th>
                                    <th>错误日期</th>
                                    <th>补偿次数</th>
                                    <th>版本号</th>
                                    <th>参数详情</th>
                                </tr>
                           `
}

function renderErrorLists(arr) {
    var l;
    if(arr&&(l=arr.length)>0) {
        var table = tableHtml();
        for(var i =0;i<l;i++) {
            table+=rowOf(arr[i],i);
        }
        table+="</table>";
        $("#error_list").html(table);
    }else{
         $("#error_list").html("<h1>暂无数据！</h1>");
    }
}

function rowOf(o,i) {
    if(o) {
        var row = "<tr>";
        row+=tdOf(o.id);
        row+=tdOf(o.eInvoiceNumber);
        row+=tdOf(o.eInvoiceCode);
        row+=tdOf(issueTypeOf(o.issueType));
        row+=tdOf(o.cause);
        row+=tdOf(o.errorTime);
        row+=tdOf(o.compensationCount);
        row+=tdOf(o.versionNumber|0);

        row+='<td class="param .button" data-p="'+i+'">点击查看参数</td>';
        return row+"</tr>"
    }

    return "";
}

function issueTypeOf(type) {
    if('1'==type) {
        return '开正常票失败';
    }
    if('2'==type) {
        return '开红票失败';
    }

    if('3'==type) {
            return '打印失败';
        }

    if('4'==type) {
            return '取消打印失败';
        }

        return "未知类型"+type;
}

function tdOf(o) {
    return '<td>'+o+'</td>'
}