layui.use(['table','layer','jquery'], function(){
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    table.render({
        elem: '#demo'
        ,url: '/initPurchaseOrder' //数据接口
        ,page: true //开启分页
        ,limit:5 //默认每一页显示的条数
        ,limits:[1,2,3,5,10,20,30,50]//提示的每页条数的列表
        ,toolbar:"#addDemo" //显示工具栏
        ,title:"学员信息汇总" //设置导出文件时的标题
        ,loading:true
        ,cols: [[ //表头

            {field: 'no',type:'checkbox', width:"5%",fixed: 'left',align:"center"}
            ,{field: 'purchaseOrderId', title: '采购订单编号', width:"10%", sort: true, fixed: 'left',align:"center"}
            ,{field: 'purchaseSupplierId', title: '供货商名称', width:"10%",align:"center"}
            ,{field: 'purchaseOrderBegintime', title: '采购日期', width:"10%", align:"center",sort: true,templet:'<div>{{ layui.util.toDateString(d.purchaseOrderBegintime, "yyyy-MM-dd") }}</div>'}
            ,{field: 'purchaseUserId', title: '采购员', width:"10%",align:"center"}
            ,{field: 'purchaseType', title: '状态', width:"10%",align:"center"}
            ,{field: 'purchasePrice', title: '价格', width:"10%", align:"center"}
            ,{field: 'purchaseTaskid', title: '任务编号', width:"10%", align:"center"}
            ,{field: 'cz', title: '操作', width: "20%",align:"center",toolbar:"#barDemo"}
        ]]
    });



    /******监听工具条事件************/
    //监听表的工具条
    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                layer.open({
                    type: 2,
                    shade: true,
                    area: ['500px','400px'],
                    maxmin: false,
                    anim: 1,
                    title:"添加用户",
                    content: '/customer/Customer_Add',
                    zIndex: layer.zIndex, //重点1
                    success: function(layero){
                        layer.setTop(layero); //重点2
                    }
                });
                break;
        };
    });

    //监听行工具条
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'detail'){ //查看
            alert('显示详情');
        } else if(layEvent === 'agree'){ //删除

                layer.confirm('真的提交吗？', function (index) {

                    $.post("/agreePurchaseOrder", {"purchaseTaskid": data.purchaseTaskid,"purchasePrice":data.purchasePrice}, function () {

                        table.reload('demo', {
                            page: {
                                curr: 1 //重新从第 1 页开始
                            }
                        }); //只重载数据
                        layer.close(index);
                    });
                });
        } else if(layEvent === 'edit'){ //编辑
        }
        });

    //指定日期转换格式
    var format = function (time, format) {
        var t = new Date(time);
        var tf = function (i) {
            return (i < 10 ? '0' : '') + i
        };
        return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function (a) {
            switch (a) {
                case 'yyyy':
                    return tf(t.getFullYear());
                    break;
                case 'MM':
                    return tf(t.getMonth() + 1);
                    break;
                case 'mm':
                    return tf(t.getMinutes());
                    break;
                case 'dd':
                    return tf(t.getDate());
                    break;
                case 'HH':
                    return tf(t.getHours());
                    break;
                case 'ss':
                    return tf(t.getSeconds());
                    break;
            }
        })

    }

});
