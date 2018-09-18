/*
	#author		lut000
	#date 		2018/07/05
    #porpuse    共用入口
*/
require.config({
  baseUrl: "http://localhost:8081/api/js",
  urlArgs: "r=" + (new Date()).getTime(),
  // urlArgs:"t="+static_change_time,
  paths: {
    "jquery": ["lib/jquery/jquery-1.11.3.min"],
    "jquery.metisMenu": ["lib/jquery/jquery.metisMenu"],
    "nicescroll": ["lib/jquery/jquery.nicescroll"],
    "common": ["common/common"],
    "bootstrap": ["lib/bootstrap/bootstrap.min"],
    "bootstrappaginator": ["lib/bootstrap/bootstrap-paginator"],
    "layui":["lib/layui/layui"],

    "vue": ["lib/vue/vue.min"],
    "general": ["common/general-1.0"],
    "msg": ["common/pop-msg-1.0"],
        "base-info": ["common/base-info"],
  },
  map: {
    '*': {
      "css": "lib/require/css-min"
    }

  },
  waitSeconds: 10000,
  shim: {
    "general": {
      deps: ["jquery",'base-info'],
      exports: "general"
    },
    "msg": {
      deps: ["jquery"],
      exports: "msg"
    },

    "bootstrap": {
      deps: ["jquery"]
    },
    "jquery.metisMenu": {
      deps: ["jquery"]
    },
    "layui":{
        exports:"layui",
        deps:["css!../js/lib/layui/css/layui.css"]
    },
    "nicescroll": {
      deps: ["jquery"],
    },
    "common": {
      deps: ["jquery", 'jquery.metisMenu', 'nicescroll']
    },
    'bootstrappaginator': {
      deps: ["jquery", "bootstrap"]
    }

  }
});






require(["jquery", "general",'base-info',"bootstrap", 'common'], function (jquery, general,global_info) {
    var def={
        ajax_port:global_info.api_url,
        msg_time:1200,                                                              //弹出框隐藏时间
        local_obj:general.fn.getLocalSto('global_storage') || {}
    };
    $(function (){
        console.log("ok!");
        var tag_url='/api/index';
        if(def.local_obj.user==undefined){
            if(window.location.href.indexOf(tag_url)==-1){
                window.location.href=tag_url;
            }
        }else{
            
            if(def.local_obj.user.token==undefined && window.location.href.indexOf(tag_url)==-1){
                window.location.href=tag_url;
            }
            if(def.local_obj.user.name!=undefined){
                $('.js-user-name').text(def.local_obj.user.name);
            }
        }
        
        // 退出登录
        $('.js-sign-out').on('click',function(){
            
            general.fn.subAjax({
                url:def.ajax_port+'/api/login/out',
                data:{},
                success:function(){
                    if(def.local_obj.user!=undefined){
                        def.local_obj.user.token='';
                        general.fn.setLocalSto('global_storage',def.local_obj);
                    }
                    window.location.href='/api/login';
                },
                error:function(){
                }
            });
            
        });
    });

    urlStatus();

    function urlStatus(){
        var tag_str=window.location.pathname;
        $('.js-main-nav>li').each(function(){
            var str=$(this).attr('data-str');
            if(tag_str.indexOf('/'+str+'/')!=-1){

                $(this).addClass('active');
                $(this).children('.js-second-nav').removeClass('collapse').addClass('in');
                return false;
            }
        });
    };

});