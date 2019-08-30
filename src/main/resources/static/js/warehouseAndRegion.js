layui.use(['form','jquery','layer'], function(){
    var form = layui.form;
    var $ = layui.$;
    var layer = layui.layer;

    /***********加载省份********************/
    $.ajax({
        url:"/findWarehouse",
        type:"get",
        dataType:"json",//后台返回的是一个json格式的数据
        success:function(data){
            //data，即为返回的json,它本身的类型是map
            //如果json的类型是map,循环取到的内容分别为：key(对应map中的键),value(对应map中的值)
            $.each(data,function(index,m){
                $("#warehouseId").append(new Option(m.name,m.id));
            });
            layui.form.render("select");
        }
    });

    /*************省份发生改变时，加载城市***********************/
    //当省份发生改变时，获得它选中的值
    form.on('select(warehouseId)', function(data){
        console.log(data.value);

       var warehouseId = data.value;

        //当省份列表改变时，清空city列表中的选项，只保留标题
        $("#warehousePositionRegionId")[0].options.length=1;//只保留原有选项中的第一项，其他选项都清除

        //通过ajax请求，加载城市
        $.ajax({
            url:"/findWarehouseRegion",
            type:"get",
            data:{"warehouseId":warehouseId},
            dataType:"json",
            success:function(data){
                $.each(data,function(index,m){
                    $("#warehousePositionRegionId").append(new Option(m.name,m.id));
                });
                layui.form.render("select");
            }
        });

    });

});