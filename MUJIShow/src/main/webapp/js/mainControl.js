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
//登录
$("#buttonlogin").click(function(){
	if($("#loginPhone").val()==""||$("#loginPassword").val()==""){
				layui.use('layer', function(){
			  var layer = layui.layer;
			  layer.msg("账号密码不能为空",{time: 1500});
		});
		return false;
	}else {
		/*
		* 发起ajax请求登录判断
		* */
		var loginList=new Array();
		loginList.push($("#loginPhone").val());
        loginList.push($("#loginPassword").val());

		$.ajax({
			url:"userloginController/login",
			data:JSON.stringify(loginList),
			contentType:"application/json;charset=utf-8",
			type:"POST"
		}).done(function (msg) {
			console.log(msg);

			if(msg=="success"){

                $("#checkIfSignIn").val($("#loginPhone").val());
                $("#login").fadeOut();
                $("#center_container_details").css("display","block");

                /*赋值*/
                $("#loginandregeist").css("border","none").html($("#checkIfSignIn").val()+",欢迎您");
                /*小标题样式,电话号码*/
                $(".userdetailscontent").css("left","192px");
                /*下载移动端隐藏*/
                $("#downLoadApp").css("display","none");

			}else {
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg("账号或者密码错误！",{time: 1500});
                });
                return false;
			}
        })
    }
});

//男装
$("#manClost").click(function(){
	$("#center_container_details").css("display","none");
	$("#topguide #closeFrame").css("display","block");
	$("#center_container iframe:eq(0)").css("display","block").attr("src","showType.html?id=1");
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
	$("#center_container iframe:eq(0)").css("display","block").attr("src","myInfo.html?id=1");
	$("#topguide #closeFrame").css("display","block");
	$("#center_container_details").css("display","none");
});