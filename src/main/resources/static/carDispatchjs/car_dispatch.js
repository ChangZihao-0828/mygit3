layui.use(['table', 'layer', 'jquery'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    //第一个实例
    table.render({
        elem: '#demo'
        , url: '/carDispatch' //数据接口
        , page: true //开启分页
        , limit: 5 //默认每一页显示的条数
        , limits: [1, 2, 3, 5, 10, 20, 30, 50]//提示的每页条数的列表
        , toolbar: "#addDemo" //显示工具栏
        , title: "车辆调度单" //设置导出文件时的标题
        , loading: true
        , cols: [
            [ //表头

                {field: "deliverGoodsId", title: '配送任务单编号', width: "15%", sort: true, fixed: 'left', align: "center"}
                , {field: 'userId', title: '配送员编号', width: "15%", align: "center"}
                , {field: 'customerOrderId', title: '订单编号', width: "15%", align: "center"}
                , {field: 'customerId', title: '客户编号', width: "15%", align: "center"}
                , {
                field: 'deliverDate',
                title: '配送日期',
                width: "10%",
                sort: true,
                align: "center",
                templet: '<div>{{ layui.util.toDateString(d.deliverDate, "yyyy-MM-dd") }}</div>'
            }
                ,{field: 'deliverGoodsTaskid', title: '任务编号', width:"10%",align:"center"}
                ,{field: 'processinstanceId', title: '流程实例编号', width:"10%",align:"center"}
                , {field: 'deliverGoodsStatus', title: '状态', width: "10%", align: "center", sort: true}
                , {field: 'op', title: '操作', width: "10%", align: "center", toolbar: "#barDemo"}
            ]
        ]
    });


    /******监听工具条事件************/
    //监听表的工具条
    //监听头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                layer.open({
                    type: 2,
                    shade: true,
                    area: ['500px', '500px'],
                    maxmin: false,
                    anim: 1,
                    title: "添加车辆调度",
                    content: '/carDispatch/add',
                    zIndex: layer.zIndex, //重点1
                    success: function (layero) {
                        layer.setTop(layero); //重点2
                    }
                });
                break;
        }
        ;
    });


    //监听行工具条
    table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if (layEvent === 'detail') { //查看
            /******显示详情********/
            layer.open({
                type: 2,
                shade: true,
                area: ['500px', '500px'],
                maxmin: false,
                anim: 1,
                title: "车辆调度作业",
                content: '/carDispatch/add',
                zIndex: layer.zIndex, //重点1
                success: function (layero) {
                    layer.setTop(layero); //重点2
                    /*********弹出新窗体以后，给新窗中的控件赋值**********************/
                        //-------------获得弹出层页面的body部份
                    var body = layui.layer.getChildFrame("body");

                    //给弹出层body中的表单控件赋值
                    body.find("[name='carDispatchTaskid']").val(data.deliverGoodsTaskid);
                    body.find("[name='deliverGoodsId']").val(data.deliverGoodsId);
                    body.find("[name='processinstanceId']").val(data.processinstanceId);

                }
            });
        } else if (layEvent === 'del') { //删除

            layer.confirm('真的删除行么', function (index) {

                $.post("/carDispatch/dispatchDel", {"carDispatchId": data.carDispatchId}, function () {

                    table.reload('demo', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                    }); //只重载数据
                    layer.close(index);
                });
                //
            });
        } else if (layEvent === 'edit') { //编辑
            /******修改数据********/
            layer.open({
                type: 2,
                shade: true,
                area: ['500px', '500px'],
                maxmin: false,
                anim: 1,
                title: "修改调度",
                content: '/carDispatch/update',
                zIndex: layer.zIndex, //重点1
                success: function (layero) {
                    layer.setTop(layero); //重点2
                    /*********弹出新窗体以后，给新窗中的控件赋值**********************/
                        //-------------获得弹出层页面的body部份
                    var body = layui.layer.getChildFrame("body");

                    //给弹出层body中的表单控件赋值
                    body.find("[name='carDispatchId']").val(data.carDispatchId);
                    body.find("[name='carId']").val(data.carId);
                    body.find("[name='deliverGoodsId']").val(data.deliverGoodsId);
                    body.find("[name='customerId']").val(data.customerId);
                    body.find("[name='carGoDate']").val(format(data.carGoDate, 'yyyy-MM-dd'));
                    body.find("[name='carBackDate']").val(format(data.carBackDate, 'yyyy-MM-dd'));
                    body.find("[value='" + data.carDispatchStatus + "']").attr("checked", true);//选中指定状态的单选按钮
                }
            });
        }
    });

    /***********指定日期格式**********************/
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


    /*******给搜索按钮绑定事件*************/
    $("#search").click(function(){

        //获得输入框的内容
        var myname = $("#carDispatchId").val();

        table.reload('demo', {
            where: { //设定异步数据接口的额外参数，任意设
                carDispatchId:myname
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        }); //只重载数据
    });



    /********给重置按钮绑定事件**************/
    $("#reset").click(function(){
        $("input").val("");
    });



});//layui.use结束标记