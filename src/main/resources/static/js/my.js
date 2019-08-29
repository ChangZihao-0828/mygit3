layui.use(['form','jquery','layer'], function(){
    var form = layui.form;
    var $ = layui.$;
    var layer = layui.layer;

    $.ajax({
    url:"/findMotorcade",
    type:"get",
    dataType:"json",//返回类型
    success:function(data){
        //data，即为返回的json,它本身的类型是map
        //如果json的类型是map,循环取到的内容分别为：key(对应map中的键),value(对应map中的值)

        $.each(data,function(index,m){
            $("#motorcadeId").append(new Option(m.name,m.id));
        });

        layui.form.render("select");
        }
    });
});