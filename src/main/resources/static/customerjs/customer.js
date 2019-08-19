layui.use(['table','layer','jquery'], function(){
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;    //第一个实例
    table.render({
        elem: '#demo'
        ,url: '/op' //数据接口
        ,page: true //开启分页
        ,limit:5 //默认每一页显示的条数
        ,limits:[1,2,3,5,10,20,30,50]//提示的每页条数的列表
        ,toolbar:"#addDemo" //显示工具栏
        ,title:"学员信息汇总" //设置导出文件时的标题
        ,loading:true
        ,cols: [[ //表头

            {field: 'no',type:'checkbox', width:"5%",fixed: 'left',align:"center"}
            ,{field: 'customer_id', title: '客户编号', width:"20%", sort: true, fixed: 'left',align:"center"}
            ,{field: 'customer_shortName', title: '客户简称', width:"10%",align:"center"}
            ,{field: 'customer_vocation_id', title: '行业', width:"10%", sort: true,align:"center"}
            ,{field: 'customer_contacts', title: '联系人', width:"20%",align:"center"}
            ,{field: 'customer_creditIimit', title: '信用额度', width: "10%",align:"center",sort:true}
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
                    content: '/op6',
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
        } else if(layEvent === 'del'){ //删除

            layer.confirm('确定要删除', function (index) {

                $.post("/delCustomerId", {"customer_id": data.customer_id}, function () {

                    table.reload('demo', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                    }); //只重载数据
                    layer.close(index);
                });

            });
        } else if(layEvent === 'edit'){ //编辑
            alert("修改");
        }
    });


});//layui.use结束标记