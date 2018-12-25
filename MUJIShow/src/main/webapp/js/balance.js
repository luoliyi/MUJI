$(function(){

    /*
    * 选择更多地址
    * */
    $(".chooseMoreAddress").click(function () {
        $("#maxdivcontainer").css("display","none");
        $("#gotobuy").css("display","none");
        $("#controlMyplace").css("display","block");
    });
    $(".btnColse").click(function () {
        $("#maxdivcontainer").css("display","block");
        $("#controlMyplace").css("display","none");
        $("#addAndEditPlace").css("display","none");
        $("#gotobuy").css("display","block");
    });
    $("#btnAddNewPlace").click(function () {
        $("#controlMyplace").css("display","none");
        $("#addAndEditPlace").css("display","block");
    });

	$(".chooseOtherPaytype").click(function(){
		$("#CoveringLayer").css("display","block");
		$("#payfordiv").css("z-index",99999).fadeIn(300);
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
        $("#CoveringLayer").css("display","none");
		$("#payfordiv").fadeOut(300);
		$("#gotobuy").fadeIn()
	})
	/*去付款*/
	$("#gotobuy").click(function(){

        /*
		* 调用生成订单的方法
		* */
        $.ajax({
            url:"admin/createOrdersController/initOneCreateOrders",
            type:"post",
        }).done(function (msg) {
            if(msg=="success"){
               // $("#CoveringLayer").css("display","none");
               // $("#qrcodebox").css("display","none");
				console.log("createorder success!")
            }
        });
		
		/*弹出遮罩层*/
		$("#CoveringLayer").css("display","block");
		$("#qrcodebox").css("display","block");
		$(".qrcodetype").html("请使用"+$("#paytype").html()+"扫描支付");

        var url = location.search;
		//生成二维码
 	    var qrCode = document.getElementById("qrcode");
          // var txtContent = jsdata;
           var qrcode=new QRCode(qrCode,{
        	      render : "canvas",
        	      width:150,
                  height:150,
                  text:"http://172.20.10.5:8080/paysuccess.html",
                  correctLevel:QRCode.CorrectLevel.L,
              });
                   
          function getCode() {
              qrcode.makeCode();
          } 
	})
})