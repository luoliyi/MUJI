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

    var qrcode=null;
    var qrCode=null;
	/*去付款*/
	$("#maxdiv").on("click",".primary",function(){

	    if($("#orderTime").val()=="") {
            /*
            * 调用生成订单的方法
            * */
            $.ajax({
                url:"admin/createOrdersController/initOneCreateOrders",
                type:"post",
            }).done(function (msg) {
               /* if(msg=="success"){
                   // $("#CoveringLayer").css("display","none");
                   // $("#qrcodebox").css("display","none");
                    console.log("createorder success!")
                }*/

                $("#orderTime").val(msg);
                $("input[name='countDown']").each(function () {
                    var time_end=this.value;
                    var con=$(this).next("span");
                    var _=this.dataset;
                    countDown(con,{
                        title:_.title,//优先级最高,填充在prefix位置
                        prefix:_.prefix,//前缀部分
                        suffix:_.suffix,//后缀部分
                        time_end:time_end//要到达的时间
                    })
                    //提供3个事件分别为:启动,重启,停止
                    .on("countDownStarted countDownRestarted  countDownEnded ",function (arguments) {
                        console.info(arguments);
                    });
                });

               console.log(msg);

            });
        }
        /*弹出遮罩层*/
		$("#CoveringLayer").css("display","block");
		$("#qrcodebox").css("display","block");
		$(".qrcodetype").html("请使用"+$("#paytype").html()+"扫描支付");
		makeCode();

	});

	function makeCode(){
        var url = location.search;
        //生成二维码
        qrCode= document.getElementById("qrcode");
        // var txtContent = jsdata;
        qrcode=new QRCode(qrCode,{
            render : "canvas",
            width:150,
            height:150,
            text:"http://172.20.10.2:8081/paysuccess2.html",
            correctLevel:QRCode.CorrectLevel.L,
        });

        function getCode() {
            qrcode.makeCode();
        }
    }

	/*
	* 支付失败
	* z*/
    $("#qrcodesuccess").css("cursor","pointer").click(function () {
       $("#CoveringLayer").css("display","none") ;
       $("#qrcodebox").css("display","none");
       $("#qrcode").html("");
       $("#qrCode").html("");

        layui.use('layer', function() {
            var layer = layui.layer;
            layer.msg("支付失败，正在转到订单页面 ", {
                time: 1500
            },function () {
                $("#gotobuy").css("display","none");
                $("#maxdivcontainer").css("display","none");
                $("#checkPay").css("display","block");

                /*
                * ajax请求查询商品
                * */
                var objects=new Array();
                objects.push(0);
                objects.push("cono");
                $.ajax({
                    url:"admin/createOrdersController/selectAllOrderByMphoneAndStateAndLimit",
                    data:JSON.stringify(objects),
                    contentType:"application/json;charset=utf-8",
                    type:"post"
                }).done(function (jsdata) {
                    console.log(jsdata);
                    $(".orderDetails .oneDetails").remove();
                    /*
                    * 渲染数据
                    * */
                    $.each(jsdata,function (index,obj) {
                        var oneDetails=$("<div class='oneDetails' />");
                        var orderNo=$("<h3 class='orderNo' />").html("<span>订单号：</span>"+obj.cono+"<span class='orderState'>待付款</span>").appendTo(oneDetails);
                        var osumprice=0;
                        $.each(obj.ordersList,function (index1,obj1) {
                            osumprice+=parseInt(obj1.osumprice);
                            $(
                               "<div class=\"order-item-items-item\">\n" +
                                "<img src='admin/img/goodsdetails/" + obj1.goods.gname + ".jpg'/>\n" +
                                "<div class=\"order-item-heading-wrap\">\n" +
                                "<div class=\"name\">"+obj1.goods.gname+"<span class=\"count\"><span>x</span><span class=\"orderCount\">"+obj1.ocount+"</span></span></div>\n" +
                                "<div class=\"options\">颜色：<span>"+obj1.goods.gcolor+" "+obj1.goods.gsize+"</span></div>\n" +
                                "<div class=\"price\"><span>￥</span><span class=\"orderPrice\">"+obj1.goods.gnowprice+"</span></div>\n" +
                                "</div>\n" +
                                "</div>"
                            ).appendTo(oneDetails);
                        });
                        $(
                            "<div class=\"order-item-total\">\n" +
                            "<div class=\"pay\">合计(含运费 ￥11)<h4 class=\"orderSumCount\">\n" +
                            "<span>￥</span><span class=\"orderSumPrice\">"+(osumprice+11)+"</span></h4></div>\n" +
                            "</div>\n" +
                            "<div class=\"MuOrderItemActions\">\n" +
                            "<a style='cursor: pointer'>删除订单</a>\n" +
                            "<a style='cursor: pointer' class=\"primary\">付款</a>\n" +
                            "</div>"
                        ).appendTo(oneDetails);
                        $(".orderDetails").append(oneDetails);
                    });
                })
            });
        });
    });

    /*
    * 返回
    * */
    $(".returnPrev").click(function () {
        $("#gotobuy").css("display","block");
        $("#maxdivcontainer").css("display","block");
        $("#checkPay").css("display","none");
    })
});