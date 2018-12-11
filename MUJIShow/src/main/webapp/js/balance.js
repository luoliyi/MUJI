$(function(){
	$(".chooseOtherPaytype").click(function(){
		$("#payfordiv").fadeIn(300);
		$("#gotobuy").fadeOut()
	})
	$("#weixinpay").click(function(){
		$(this).attr("class","layui-icon layui-icon-radio");
		$("#zbfpay").attr("class","layui-icon layui-icon-circle");
		$("#paytype").html($(this).data("type"));
		
	})
	$("#zbfpay").click(function(){
		$(this).attr("class","layui-icon layui-icon-radio");
		$("#weixinpay").attr("class","layui-icon layui-icon-circle");
		$("#paytype").html($(this).data("type"));
	})
	$("#muclose").click(function(){
		$("#payfordiv").fadeOut(300);
		$("#gotobuy").fadeIn()
	})
	/*去付款*/
	$("#gotobuy").click(function(){
		
		/*弹出遮罩层*/
		$("#CoveringLayer").css("display","block");
		$("#qrcodebox").css("display","block")
		
		$(".qrcodetype").html("请使用"+$("#paytype").html()+"扫描支付");
		//生成二维码
 	    var qrCode = document.getElementById("qrcode");
          // var txtContent = jsdata;
           var qrcode=new QRCode(qrCode,{
        	      render : "canvas",
        	      width:150,
                  height:150,
                  text:"good afternoon!",
                  correctLevel:QRCode.CorrectLevel.L,
              });
                   
          function getCode(content) {
              qrcode.makeCode(content);
          } 
	})
})