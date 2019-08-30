layui.use(['table','layer','jquery'], function() {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    //第一个实例
    table.render({
        elem: '#demo'
        , url: '/initPurchaseAppllyOrder' //数据接口
        , page: true //开启分页
        , limit: 5 //默认每一页显示的条数
        , limits: [1, 2, 3, 5, 10, 20, 30, 50]//提示的每页条数的列表
        , toolbar: "#addDemo" //显示工具栏
        , title: "采购单" //设置导出文件时的标题
        , loading: true
        , cols: [[ //表头

            {field: 'no', type: 'checkbox', width: "5%", fixed: 'left', align: "center"}
            , {field: 'supplierId', title: '采购申请单编号', width: "45%", sort: true, fixed: 'left', align: "center"}
            , {field: 'supplierName', title: '申请人', width: "45%", align: "center"}

        ]]
    });
});