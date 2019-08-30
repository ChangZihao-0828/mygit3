layui.use(['table','layer','jquery'], function(){
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    table.render({
        elem: '#demo'
        ,url: '/initPurchaseAppllyOrder' //数据接口
        ,page: true //开启分页
        ,limit:10 //默认每一页显示的条数
        ,limits:[1,2,3,5,10,20,30,50]//提示的每页条数的列表
        ,toolbar:"#addDemo" //显示工具栏
        ,title:"采购申请" //设置导出文件时的标题
        ,loading:true
        ,cols: [[ //表头
            ,{field: 'purchaseAppllyOrderId', title: '采购申请单编号', width:"20%", sort: true,align:"center"}
            ,{field: 'purchaseAppllyOrderBeginTime', title: '申请日期', width:"10%",align:"center",sort: true,templet:'<div>{{ layui.util.toDateString(d.purchaseAppllyOrderBeginTime, "yyyy-MM-dd") }}</div>'}
            ,{field: 'purchaseAppllyUserName', title: '申请人', width:"10%", align:"center"}
            ,{field: 'purchaseAppllyPrice', title: '价格', width:"10%", align:"center"}
            ,{field: 'purchaseAppllyTaskid', title: '任务编号', width:"20%", align:"center"}
            ,{field: 'cz', title: '操作', width: "30%",align:"center",toolbar:"#barDemo"}

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

        if(layEvent === 'agree'){ //

            layer.confirm('真的提交吗？', function (index) {

                $.post("/agreePurchaseApplyOrder", {"purchaseAppllyTaskid": data.purchaseAppllyTaskid,"purchaseAppllyPrice":data.purchaseAppllyPrice}, function () {

                    table.reload('demo', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                    }); //只重载数据
                    layer.close(index);
                });
            });
        } else if(layEvent === 'del'){ //删除

            alert("删除");

        } else if(layEvent === 'edit'){ //编辑
            layer.open({
                type: 2,
                shade: true,
                area: ['1000px', '440px'],
                maxmin: false,
                anim: 1,
                title: "修改供应商信息",
                content: '/cg7',
                zIndex: layer.zIndex, //重点1
                success: function (layero) {
                    layer.setTop(layero); //重点2
                    /*********弹出新窗体以后，给新窗中的控件赋值**********************/
                        //-------------获得弹出层页面的body部份
                    var body = layui.layer.getChildFrame("body");

                    //给弹出层body中的表单控件赋值
                    body.find("[name='purchaseAppllyOrderId']").val(data.purchaseAppllyOrderId);
                    body.find("[name='purchaseAppllyOrderBegintime']").val(format(data.purchaseAppllyOrderBegintime, 'yyyy-MM-dd'));
                    body.find("[name='purchaseAppllyOrderEndtime']").val(format(data.purchaseAppllyOrderEndtime, 'yyyy-MM-dd'));
                    body.find("[name='purchaseAppllyUserName']").val(data.purchaseAppllyUserName);
                    body.find("[name='purchaseAppllyRemark']").val(data.purchaseAppllyRemark);
                    body.find("[name='purchaseAppllyPrice']").val(data.purchaseAppllyPrice);
                    body.find("[name='purchaseAppllyTaskid']").val(data.purchaseAppllyTaskid);

                }
            });
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
                    title:"添加采购申请",
                    content: '/cg7',
                    zIndex: layer.zIndex, //重点1
                    success: function(layero){
                        layer.setTop(layero); //重点2
                    }
                });
                break;
        };
    });

});