/**
 * Created by K550jk on 2017/4/1.
 */
$(
    function(){
        $(".input-name").on("blur",function(){
            if(!(/^[\w]+$/.test($(this).val()))){
                $(this).siblings(".input-help").html("请输入正确的用户名");
            }else{
                $(this).siblings(".input-help").html("");
            }
        });
        $(".input-pass").on("blur",function(){
            if(!(/^[\w]+$/.test($(this).val()))){
                $(this).siblings(".input-help").html("请输入合法的密码");
            }else{
                $(this).siblings(".input-help").html("");
            }
        })
        $(".login").on("click",function(e){
            var flag = false;
                $(".input-name").trigger("blur");
                $(".input-pass").trigger("blur");
                if($(".input-help").map(function(){
                      if(/\W+/.test($(this).html())) {
                          flag = true;
                    }
                    }));
                if(flag){
                    e.preventDefault();
                }
        })

    }
);
$(function(){
    $(".leftnav h2").click(function(){
        $(this).next().slideToggle(200);
        $(this).toggleClass("on");
    });
    $(".leftnav ul li a").click(function(){
        $("#a_leader_txt").text($(this).text());
        $(".leftnav ul li a").removeClass("on");
        $(this).addClass("on");
    })
});

$(function(){




});
