$(function() {
	$(".listitem-content li").click(function() {
		var that = $(this);
		layui.use('layer', function() {
			var layer = layui.layer;
			layer.msg($(that).find("p:eq(0)").html(), {
				time: 1500
			});
		});
		/*
		* 弹出详细界面
		* */

		$("#myorderInforation").css("display","block");
		/*$(".listitem-wrap").css("display","none");
        $(".has-title").css("display","none");*/

	});
	$("#lookallmyorders").click(function() {
		$("#center_container iframe:eq(0)", parent.document).css("display", "block").attr("src", "myOrders.html?id=1");
	});
	$("#gotoCloseFrame", parent.document).click(function() {
		$("#center_container iframe:eq(0)", parent.document).attr("src", "myInfo.html");

	});

	/*点击，查看更多内容
	 该流程由js控制
	 
	 * */
	
	$("#lookmoremyinfo").click(function(){
		$("#myorder").css("display","none");
		$("#myinformation").css("display","block");
	});
	$("#morePlace").click(function(){
		$("#myinformation").css("display","none");
		$("#controlMyplace").css("display","block");
	});
	$("#btnAddNewPlace").click(function(){
		$("#controlMyplace").css("display","none");
		$("#addAndEditPlace").css("display","block");
	});
	$("#btnSaveNewPlace").click(function(){
		$("#addAndEditPlace").css("display","none");
		$("#myorder").css("display","block");
	});
	/*编辑*/
	$("#editMyPlace").click(function(){
		$("#controlMyplace").css("display","none");
		$("#addAndEditPlace").css("display","block");
	});
	$(".divClose").click(function(){
		$(this).parent().css("display","none");
		$("#myorder").css("display","block");
	});
})