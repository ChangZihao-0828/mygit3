layui.use(['table','layer','jquery'], function(){
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    //第一个实例
    table.render({
        elem: '#demo'
        ,url: '/deliveryReceiving2' //数据接口
        ,page: true //开启分页
        ,limit:10 //默认每一页显示的条数
        ,limits:[1,2,3,5,10,20,30,50]//提示的每页条数的列表
        ,toolbar:"#addDemo"//显示工具栏
        ,title:"出库作业单记录汇总" //设置导出文件时的标题
        ,loading:true
        ,cols: [[ //表头
            {field: 'outGoodsId', title: '出库作业单', width:"30%", sort: true, fixed: 'left',align:"center"}
            ,{field: 'outGoodsTime', title: '出库时间', width:"10%",align:"center", sort: true,templet:'<div>{{ layui.util.toDateString(d.outGoodsTime, "yyyy-MM-dd") }}</div>'}
            ,{field: 'customerOrderId', title: '仓管员', width:"30%",align:"center", sort: true}
            ,{field: 'outGoodsTaskid', title: '任务编号', width:"10%",align:"center"}
            ,{field: 'outGoodsStatus', title: '状态', width:"10%",align:"center"}
            , {field: 'op', title: '操作', width: "10%", align: "center", toolbar: "#barDemo"}
        ]]
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
                    area: ['1000px', '440px'],
                    maxmin: false,
                    anim: 1,
                    title: "添加出库作业单",
                    content: '/stock/add_Delivery_Receiving',
                    zIndex: layer.zIndex, //重点1
                    success: function (layero) {
                        layer.setTop(layero); //重点2
                    }
                });

                break;
        };
    });

    /*******给搜索按钮绑定事件*************/
    $("#search").click(function(){

        //获得输入框的内容
        var searchDeliveryReceivingId = $("#searchDeliveryReceivingId").val();

        table.reload('demo', {
            where: { //设定异步数据接口的额外参数，任意设
                searchDeliveryReceivingId:searchDeliveryReceivingId
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        }); //只重载数据
    });

    //监听行工具条
    table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

       if (layEvent === 'edit') { //编辑
            /******修改数据********/
            layer.confirm('是否进行出库作业？', function (index) {

                $.post("/submitOutGoodsOrder", {"outGoodsTaskid": data.outGoodsTaskid,"outGoodsId":data.outGoodsId}, function () {

                    table.reload('demo', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                    }); //只重载数据
                    layer.close(index);
                });
                //
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

});