layui.use(['table','layer','jquery'], function(){
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.$;
    //第一个实例
    table.render({
        elem: '#demo'
        ,url: '/sc' //数据接口
        ,page: true //开启分页
        ,limit:5 //默认每一页显示的条数
        ,limits:[1,2,3,5,10,20,30,50]//提示的每页条数的列表
        ,toolbar:"#addDemo" //显示工具栏
        ,title:"学员信息汇总" //设置导出文件时的标题
        ,loading:true
        ,cols: [[ //表头

            {field: 'no',type:'checkbox', width:"5%",fixed: 'left',align:"center"}
            ,{field: 'supplierId', title: '供货商编号', width:"20%", sort: true, fixed: 'left',align:"center"}
            ,{field: 'supplierName', title: '供货商名称', width:"20%",align:"center"}
            ,{field: 'supplierContacts', title: '联系人', width:"10%", align:"center"}
            ,{field: 'supplierCreditiimit', title: '信用额度', width:"20%",align:"center"}
            ,{field: 'cz', title: '操作', width: "20%",align:"center",toolbar:"#barDemo"}

        ]]
    });

    $("#search").click(function(){

        //获得输入框的内容
        var mysearchsupplierId = $("#searchsupplierId").val();

        table.reload('demo', {
            where: { //设定异步数据接口的额外参数，任意设
                searchsupplierId:mysearchsupplierId
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        }); //只重载数据
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
                    title:"添加供应商",
                    content: '/cg8',
                    zIndex: layer.zIndex, //重点1
                    success: function(layero){
                        layer.setTop(layero); //重点2
                    }
                });
                break;
        };
    });
    /*******给搜索按钮绑定事件*************/
    $("#search").click(function(){

        //获得输入框的内容
        var mySearchMatterCheckId = $("#searchMatterCheckId").val();

        table.reload('demo', {
            where: { //设定异步数据接口的额外参数，任意设
                searchMatterCheckId:mySearchMatterCheckId
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        }); //只重载数据
    });

    //监听行工具条
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'detail'){ //查看
            alert('显示详情');
        } else if(layEvent === 'del'){ //删除

            layer.confirm('确定要删除', function(index){
                $.ajax({
                    //几个参数需要注意一下
                    type: "post",//方法类型
                    url: "/delSupplier",//url
                    data:{"supplierId":data.supplierId},
                    dataType:"json",
                    async:false,
                    success: function (result) {

                        if (0==result ) {
                            alert("删除失败");

                        }else{
                            layer.msg("成功!!!",function(){
                                // 准备让父窗口刷新，并且关闭当前弹出的窗体
                                window.parent.location.reload();
                            })
                        };
                    }
                })
            });
            } else if(layEvent === 'edit'){     /******修改数据********/
        layer.open({
            type: 2,
            shade: true,
            area: ['1000px', '440px'],
            maxmin: false,
            anim: 1,
            title: "修改供应商信息",
            content: '/cg8',
            zIndex: layer.zIndex, //重点1
            success: function (layero) {
                layer.setTop(layero); //重点2
                /*********弹出新窗体以后，给新窗中的控件赋值**********************/
                    //-------------获得弹出层页面的body部份
                var body = layui.layer.getChildFrame("body");

                //给弹出层body中的表单控件赋值
                body.find("[name='supplierId']").val(data.supplierId);
                body.find("[name='supplierName']").val(data.supplierName);
                body.find("[name='supplierPwd']").val(data.supplierPwd);
                body.find("[name='supplierContacts']").val(data.supplierContacts);
                body.find("[name='supplierCreditiimit']").val(data.supplierCreditiimit);
                body.find("[name='supplierShortname']").val(data.supplierShortname);
                body.find("[name='supplierTelephone']").val(data.supplierTelephone);
                body.find("[name='supplierEmail']").val(data.supplierEmail);
                body.find("[name='supplierAddress']").val(data.supplierAddress);
            }
        });
        }
        });
});//layui.use结束标记