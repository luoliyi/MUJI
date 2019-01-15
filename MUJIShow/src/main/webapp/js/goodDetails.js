$(function () {
    layui.use('carousel', function () {
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1',
            width: '100%' //设置容器宽度
            ,
            height: '500px',
            arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });
    layui.use('element', function () {
        var element = layui.element;
    });

    /*加入购物车*/
    $("#muji_btn_add_commodity_to_cart").click(function () {

        //判断是否登陆
        if ($("#checkIfSignIn", parent.document).val() == "") {
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.msg("客官, 请先登录~", {time: 1500});
            });
            return false;
        }

        //$("#chooseAlltoCar").css("transition", "all .7s").css("height", "445px");
        $("#chooseAlltoCar").css("height", "460px").fadeIn(1000);
        $("#CoveringLayer").css("display", "block");

        $(".PageCommodityDetailPartActions").fadeOut(500);
        return false;
    });
    $("#chooseClose").click(function () {
        $("#chooseAlltoCar").fadeOut(500);
        $(".PageCommodityDetailPartActions").fadeIn(500);
        $("#CoveringLayer").css("display", "none");
    });


    $("#countAdd").click(function () {
        var value = parseInt($("#countValue").val());
        value++;
        $("#countValue").val(value);
    })
    $("#countDel").click(function () {
        var value = parseInt($("#countValue").val());
        if ($("#countValue").val() == "1") {
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.msg("不能再减啦~", {time: 1500});
            });
            return false;
        }
        value--;
        $("#countValue").val(value);
    })
});
