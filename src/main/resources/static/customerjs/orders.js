layui.use(['table','layer','jquery'], function(){
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    table.render({
        elem: '#demo'
        ,url: '/order' //数据接口
        ,page: true //开启分页
        ,limit:5 //默认每一页显示的条数
        ,limits:[1,2,3,5,10,20,30,50]//提示的每页条数的列表
        ,toolbar:"#addDemo" //显示工具栏
        ,title:"学员信息汇总" //设置导出文件时的标题
        ,loading:true
        ,cols: [[ //表头

            {field: 'customerOrderId', title: '订单编号', width:"23%", sort: true, fixed: 'left',align:"center"}
            ,{field: 'customerOrderNameId', title: '客户名称', width:"10%",align:"center"}
            ,{field: 'customerOrderType', title: '订单类型', width:"10%", align:"center"}
            ,{field: 'customerOrderTime', title: '订单日期', width:"10%",align:"center",sort: true,templet:'<div>{{ layui.util.toDateString(d.customerOrderTime, "yyyy-MM-dd") }}</div>'}
            ,{field: 'customerOrderDeclaration', title: '报关', width: "10%",align:"center"}
            ,{field: 'customerOrderLinkman', title: '联系人', width: "10%",align:"center"}
            ,{field: 'customerOrderState', title: '状态', width: "10%",align:"center"}
            ,{field: 'cz', title: '操作', width: "17%",align:"center",toolbar:"#barDemo"}

        ]]
    });



    /******监听工具条事件************/
    //监听表的工具条
    //监听头工具栏事件



    //监听行工具条
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'detail'){ //查看
            alert('显示详情');
        } else if(layEvent === 'del'){ //删除

            alert("删除");
            // layer.confirm('真的删除行么', function(index){
            //     // obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
            //     // layer.close(index);
            //     // //向服务端发送删除指令
            //
            //
            // });
        } else if(layEvent === 'edit'){ //编辑
            alert("修改");
        }
    });


});//layui.use结束标记