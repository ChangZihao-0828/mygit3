layui.use(['table', 'layer', 'jquery'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    //第一个实例
    table.render({
        elem: '#demo'
        , url: '/initCarDeployLine' //数据接口
        , page: true //开启分页
        , limit: 5 //默认每一页显示的条数
        , limits: [1, 2, 3, 5, 10, 20, 30, 50]//提示的每页条数的列表
        , toolbar: "#addDemo" //显示工具栏
        , title: "车辆配线表" //设置导出文件时的标题
        , loading: true
        , cols: [
            [ //表头

                {field: 'no', type: 'checkbox', width: "3%", fixed: 'left', align: "center"}
                , {field: 'carDeployLineId', title: '编号', width: "10%", sort: true, fixed: 'left', align: "center"}
                , {field: 'carId', title: '车辆编号', width: "10%", align: "center"}
                , {field: 'deliverGoodsId', title: '配送任务单编号', width: "10%", align: "center"}
                , {field: 'carFromSite', title: '始发站', width: "20%", align: "center"}
                , {field: 'carMap', title: '始发站地图', width: "10%", align: "center", toolbar: "#barMap"}
                , {field: 'carToSite', title: '目的站', width: "20%", align: "center"}
                , {field: 'carMapIn', title: '目的站地图', width: "10%", align: "center", toolbar: "#barMapIn"}
                , {
                field: 'carDispatchDate',
                title: '配线日期',
                width: "11%",
                sort: true,
                align: "center",
                templet: '<div>{{ layui.util.toDateString(d.deliverDate, "yyyy-MM-dd") }}</div>'
            }
                , {field: 'carMileage', title: '里程', width: "10%", sort: true, align: "center"}
                , {field: 'carPrice', title: '单价', width: "10%", sort: true, align: "center"}
                , {field: 'op', title: '操作', width: "15%", align: "center", toolbar: "#barDemo"}
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
                    content: '/carDeployLine/add',
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
                title: "车辆调度详情",
                content: '/carDeployLine/detail',
                zIndex: layer.zIndex, //重点1
                success: function (layero) {
                    layer.setTop(layero); //重点2
                    /*********弹出新窗体以后，给新窗中的控件赋值**********************/
                        //-------------获得弹出层页面的body部份
                    var body = layui.layer.getChildFrame("body");

                    //给弹出层body中的表单控件赋值
                    body.find("[name='carDeployLineId']").val(data.carDeployLineId);
                    body.find("[name='carId']").val(data.carId);
                    body.find("[name='deliverGoodsId']").val(data.deliverGoodsId);
                    body.find("[name='carFromSite']").val(data.carFromSite);
                    body.find("[name='carToSite']").val(data.carToSite);
                    body.find("[name='carDispatchDate']").val(format(data.carDispatchDate, 'yyyy-MM-dd'));
                    body.find("[name='carMileage']").val(data.carMileage);
                    body.find("[name='carPrice']").val(data.carPrice);
                }
            });
        } else if (layEvent === 'del') { //删除

            layer.confirm('真的删除行么', function (index) {

                $.post("/carDeployLine/dispatchDel", {"carDeployLineId": data.carDeployLineId}, function () {

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
                content: '/carDeployLine/update',
                zIndex: layer.zIndex, //重点1
                success: function (layero) {
                    layer.setTop(layero); //重点2
                    /*********弹出新窗体以后，给新窗中的控件赋值**********************/
                        //-------------获得弹出层页面的body部份
                    var body = layui.layer.getChildFrame("body");

                    //给弹出层body中的表单控件赋值
                    body.find("[name='carDeployLineId']").val(data.carDeployLineId);
                    body.find("[name='carId']").val(data.carId);
                    body.find("[name='deliverGoodsId']").val(data.deliverGoodsId);
                    body.find("[name='carFromSite']").val(data.carFromSite);
                    body.find("[name='carToSite']").val(data.carToSite);
                    body.find("[name='carDispatchDate']").val(format(data.carDispatchDate, 'yyyy-MM-dd'));
                    body.find("[name='carMileage']").val(data.carMileage);
                    body.find("[name='carPrice']").val(data.carPrice);
                }
            });
        }else if

              (layEvent === 'map') { //地图
                /******地图弹出层********/
                layer.open({
                    type: 2,
                    shade: true,
                    area: ['700px', '480px'],
                    maxmin: false,
                    anim: 1,
                    title: "地图",
                    content: '/carDeployLine/carBaiDuMap',
                    zIndex: layer.zIndex, //重点1
                    success: function (layero) {
                        layer.setTop(layero); //重点2
                        /*********弹出新窗体以后，给新窗中的控件赋值**********************/
                            //-------------获得弹出层页面的body部份
                        var body = layui.layer.getChildFrame("body");

                        //给弹出层body中的表单控件赋值
                        body.find("[name='carDeployLineId']").val(data.carDeployLineId);
                        body.find("[name='carId']").val(data.carId);
                        body.find("[name='deliverGoodsId']").val(data.deliverGoodsId);
                        body.find("[name='carFromSite']").val(data.carFromSite);
                        body.find("[name='carToSite']").val(data.carToSite);
                        body.find("[name='carDispatchDate']").val(format(data.carDispatchDate, 'yyyy-MM-dd'));
                        body.find("[name='carMileage']").val(data.carMileage);
                        body.find("[name='carPrice']").val(data.carPrice);
                    }
                });
            }else if

        (layEvent === 'mapIn') { //地图
            /******地图弹出层********/
            layer.open({
                type: 2,
                shade: true,
                area: ['700px', '480px'],
                maxmin: false,
                anim: 1,
                title: "地图",
                content: '/carDeployLine/carBaiDuMapIn',
                zIndex: layer.zIndex, //重点1
                success: function (layero) {
                    layer.setTop(layero); //重点2
                    /*********弹出新窗体以后，给新窗中的控件赋值**********************/
                        //-------------获得弹出层页面的body部份
                    var body = layui.layer.getChildFrame("body");

                    //给弹出层body中的表单控件赋值
                    body.find("[name='carDeployLineId']").val(data.carDeployLineId);
                    body.find("[name='carId']").val(data.carId);
                    body.find("[name='deliverGoodsId']").val(data.deliverGoodsId);
                    body.find("[name='carFromSite']").val(data.carFromSite);
                    body.find("[name='carToSite']").val(data.carToSite);
                    body.find("[name='carDispatchDate']").val(format(data.carDispatchDate, 'yyyy-MM-dd'));
                    body.find("[name='carMileage']").val(data.carMileage);
                    body.find("[name='carPrice']").val(data.carPrice);
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
        $("#search").click(function () {

            //获得输入框的内容
            var myname = $("#carDeployLineId").val();

            table.reload('demo', {
                where: { //设定异步数据接口的额外参数，任意设
                    carDeployLineId: myname
                }
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            }); //只重载数据
        });


        /********给重置按钮绑定事件**************/
        $("#reset").click(function () {
            $("input").val("");
        });



});//layui.use结束标记