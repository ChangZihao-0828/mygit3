layui.use(['table','layer','jquery'], function(){
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    table.render({
        elem: '#demo'
        ,url: '/orderPeocessing' //数据接口
        ,page: true //开启分页
        ,limit:5 //默认每一页显示的条数
        ,limits:[1,2,3,5,10,20,30,50]//提示的每页条数的列表
        ,toolbar:"#addDemo" //显示工具栏
        ,title:"学员信息汇总" //设置导出文件时的标题
        ,loading:true
        ,cols: [[ //表头

            {field: 'customerOrderId', title: '订单编号', width:"20%", sort: true, fixed: 'left',align:"center"}
            ,{field: 'customerOrderNameId', title: '客户名称', width:"10%",align:"center"}
            ,{field: 'customerOrderType', title: '订单类型', width:"10%", align:"center"}
            ,{field: 'customerOrderTime', title: '订单日期', width:"15%",align:"center" ,sort: true,templet:'<div>{{ layui.util.toDateString(d.customerOrderTime, "yyyy-MM-dd") }}</div>'}
            ,{field: 'customerOrderPrice', title: '订单价格', width: "10%",align:"center"}
            ,{field: 'customerOrderTaskid', title: '任务编号', width: "10%",align:"center"}
            ,{field: 'processinstanceId', title: '流程实例', width: "10%",align:"center"}
            ,{field: 'customerOrderState', title: '状态', width: "10%",align:"center"}
            ,{field: 'cz', title: '操作', width: "15%",align:"center",toolbar:"#barDemo"}
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

        if(layEvent === 'outGoods'){ //出库

            layer.open({
                type: 2,
                shade: true,
                area: ['1000px', '440px'],
                maxmin: false,
                anim: 1,
                title: "添加出库作业",
                content: '/stock/add_Delivery_Receiving',
                zIndex: layer.zIndex, //重点1
                success: function (layero) {
                    layer.setTop(layero); //重点2
                    /*********弹出新窗体以后，给新窗中的控件赋值**********************/
                        //-------------获得弹出层页面的body部份
                    var body = layui.layer.getChildFrame("body");

                    //给弹出层body中的表单控件赋值
                    body.find("[name='customerOrderId']").val(data.customerOrderId);
                    body.find("[name='outGoodsTaskid']").val(data.customerOrderTaskid);
                    body.find("[name='processinstanceId']").val(data.processinstanceId);
                }
            });

        } else if(layEvent === 'dispatching'){ //配送

            layer.open({
                type: 2,
                shade: true,
                area: ['1000px', '440px'],
                maxmin: false,
                anim: 1,
                title: "添加配送任务",
                content: '/deliver/add',
                zIndex: layer.zIndex, //重点1
                success: function (layero) {
                    layer.setTop(layero); //重点2
                    /*********弹出新窗体以后，给新窗中的控件赋值**********************/
                        //-------------获得弹出层页面的body部份
                    var body = layui.layer.getChildFrame("body");

                    //给弹出层body中的表单控件赋值
                    body.find("[name='customerOrderId']").val(data.customerOrderId);
                    body.find("[name='deliverGoodsTaskid']").val(data.customerOrderTaskid);
                    body.find("[name='processinstanceId']").val(data.processinstanceId);

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

});//layui.use结束标记