/*
    #author     lut000
    #date       2018/08/07
    #porpuse    全局变量
*/
define([], function(){
    var global_info={
        api_url:'http://localhost:8081',                                        //api接口
        user_info:{                                                             //当前用户信息
            user_token:''
        },
        msg_time:1200,															//弹出提示层 时长
        local_storage_info:getLocalSto('global_storage') || {}                        //本地存储
    };   
    if(global_info.local_storage_info.user!=undefined){
        global_info.user_info.user_token=global_info.local_storage_info.user.token || '';
    }

    
    function getLocalSto(sto_name){                  //获取本地存储
        if(window.localStorage){
            // 支持localStorage
            var val=localStorage.getItem(sto_name);
            if(val==="undefined"){
                return undefined;
            }else if(typeof val === "number"){
                return val;
            }else if(val){
                return JSON.parse(val)?JSON.parse(val):"";
            }
        }else{
            return undefined;
        }
    };
    return global_info;
});