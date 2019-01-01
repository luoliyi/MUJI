layui.use('carousel', function(){
  var carousel = layui.carousel;
  //建造实例
  carousel.render({
    elem: '#test1'
    ,width: '100%' //设置容器宽度
	,height:'500px'
    ,arrow: 'always' //始终显示箭头
    //,anim: 'updown' //切换动画方式
  });
});
layui.use('element', function(){
  var element = layui.element;
});

$("#loginandregeist").click(function(){
	$("#login").css({"position":"absolute","top":"10px"}).fadeIn();
	$("#center_container_details").css("display","none");
	//$("#center_container").css("position","absolute");
	
	/*子窗体也隐藏*/
	$("#center_container iframe:eq(0)").css("display","none");
});
$("#userregeist").click(function(){
	$("#login").fadeOut();
	$("#regeistreadme").css({"position":"absolute","top":"55px"}).fadeIn();
});
$("#loginclose").click(function(){
	$("#login").fadeOut();
	$("#center_container_details").css("display","block");
});
$("#iagreebutton").click(function(){
	$("#regeistreadme").fadeOut();
	$("#regeist").css({"position":"absolute","top":"10px"}).fadeIn();
});
$("#gotologin").click(function(){
	$("#regeistreadme").fadeOut();
	$("#login").show();
});
$("#gotoreadme").click(function(){
	$("#regeist").fadeOut();
	$("#regeistreadme").fadeIn();
});


var shortMessage="";

//登录
$("#buttonlogin").click(function(){

	/*
	* 判断是否是数字
	* */
	if(isNaN($("#loginPassword").val())) {

        if ($("#loginPhone").val() == "" || $("#loginPassword").val() == "") {
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.msg("账号密码不能为空", {time: 1500});
            });
            return false;
        } else {
            /*
            * 发起ajax请求登录判断
            * */
            var loginList = new Array();
            loginList.push($("#loginPhone").val());
            loginList.push($("#loginPassword").val());

            $.ajax({
                url: "userloginController/login",
                data: JSON.stringify(loginList),
                contentType: "application/json;charset=utf-8",
                type: "POST"
            }).done(function (msg) {
                console.log(msg);

                if (msg == "success") {

                    $("#checkIfSignIn").val($("#loginPhone").val());
                    $("#login").fadeOut();
                    $("#center_container_details").css("display", "block");

                    /*赋值*/
                    $("#loginandregeist").css("border", "none").html($("#checkIfSignIn").val() + ",欢迎您");
                    /*小标题样式,电话号码*/
                    $(".userdetailscontent").css("left", "192px");
                    /*下载移动端隐藏*/
                    $("#downLoadApp").css("display", "none");

                } else {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.msg("账号或者密码错误！", {time: 1500});
                    });
                    return false;
                }
            })
        }
    }else {
		/*
		* 短信判断
		* */
		if($("#loginPassword").val()!=shortMessage){
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.msg("验证码错误！", {time: 1500});
            });
            return false;
		}
        /*
        * 短信登录
        * */
        var loginList=new Array();
        loginList.push($("#loginPhone").val());
        $.ajax({
            url: "userloginController/shortMessageLogin",
            data: JSON.stringify(loginList),
            contentType: "application/json;charset=utf-8",
            type: "POST"
        }).done(function (msg) {
        	if(msg=="success"){

                $("#checkIfSignIn").val($("#loginPhone").val());
                $("#login").fadeOut();
                $("#center_container_details").css("display", "block");
                /*赋值*/
                $("#loginandregeist").css("border", "none").html($("#checkIfSignIn").val() + ",欢迎您");
                /*小标题样式,电话号码*/
                $(".userdetailscontent").css("left", "192px");
                /*下载移动端隐藏*/
                $("#downLoadApp").css("display", "none");
			}
		})
    }
});

//短信登陆
$("#shortMessageLogin").click(function () {
	if($("#loginPhone").val()==""){
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.msg("您还未填写手机号码",{time: 1500});
        });
		return false;
	}
	var time=59;
	var that=$(this);
	var timer=window.setInterval(function () {
		if(time<=0){
			$(that).html("重新发送");
			window.clearInterval(timer);
			return false;
		}else {
		}
		$(that).html(time+"秒");
		time-=1;
    },1000,false);
	/*
	* 查询短信
	* */
	var objects=new Array();
	objects.push($("#loginPhone").val());

	$.ajax({
		url:"admin/qcloudSendMessage/sendMessage",
		data:JSON.stringify(objects),
		contentType:"application/json;charset=utf-8",
		type:"post"
	}).done(function (msg) {
		console.log(msg);
		shortMessage=msg;
    })
});

//男装
$(".productwrap_ul").on("click","li",function(){
	$("#center_container_details").css("display","none");
	$("#topguide #closeFrame").css("display","block");
	$("#center_container iframe:eq(0)").css("display","block").attr("src","showType3.html");

	/*
	* 保存图片tid
	* */
	$("#saveTid").val($(this).data("tid"));

});

//关闭，返回主页面
$("#topguide #closeFrame").click(function(){
	$("#center_container iframe:eq(0)").css("display","none").attr("src","");
	$("#center_container_details").css("display","block");
	$(this).css("display","none");
});

//短信登录
$("#shortMessageLogin").click(function(){
	$("#loginPassword").attr("placeholder","请输入短信");
});

//新到商品
$("#MuSectionWrapper_details").on("click",".arriveOne",function(){
	$("#center_container_details").css("display","none");
	/*
	* 保存gid
	* */
	$("#saveGid").val($(this).data("gid"));

	$("#center_container iframe:eq(0)").css("display","block").attr("src","goodDetails.html");
	$("#topguide #closeFrame").css("display","block");
});


//购物车
$("#buyCar").click(function(){
	
	if($("#checkIfSignIn").val()==""){
		layui.use('layer', function(){
			  var layer = layui.layer;
			  layer.msg("客官, 请先登录~",{time: 1500});
		});
		return false;
	}
	
	$("#center_container_details").css("display","none");
	$("#center_container iframe:eq(0)").css("display","block").attr("src","buyCar.html");
	$("#topguide #closeFrame").css("display","block");
})

$(".PageHomePartNewArrivals img").lazyload({
	"effect":"fadeIn",
	"effectspeed":1000
});

$("#userdetails").hover(function(){
	$(".userdetailscontent").css("display","block");
})
$(".userdetailscontent").hover(function(){
	$(".userdetailscontent").css("display","block");
})
$(".userdetailscontent").mouseleave(function(){
	$(this).css("display","none");
})
$(".myinfo").click(function(){
		if($("#checkIfSignIn").val()==""){
		layui.use('layer', function(){
			  var layer = layui.layer;
			  layer.msg("客官, 请先登录~",{time: 1500});
		});
		return false;
	}
	$("#center_container iframe:eq(0)").css("display","block").attr("src","myInfo.html");
	$("#topguide #closeFrame").css("display","block");
	$("#center_container_details").css("display","none");
});
