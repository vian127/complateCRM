/*
	#author		lut000
	#date 		2018/07/12
    #porpuse    共用入口
*/
require(['jquery','general','vue','msg','base-info'],function(jquery,general,Vue,msg,global_info){

	var def={
        ajax_port:global_info.api_url,
    };
	var app=new Vue({
		el:'#app',
		data(){
			return {
				login_info:{
					account:'',
					password:'',
					// code:'',
					is_account:false,
					is_password:false,
					// is_code:false,
					msg:'',
					btntxt:'登录',
					is_submitting:false
				},
				box:{
					top:150
				}
			}
		},
		methods:{
			init:function(){														//初始化
				this.bindFunc();
			},
			bindFunc:function(){													//事件绑定
				var self=this,$box=$(".js-login-box");
				setPosition();
				$(window).on('resize',function(){
					general.fn.throttle(setPosition,self,[]);
				});

				function setPosition(){												//设置框位置
					var oh=document.documentElement.clientHeight;
					self.box.top=(oh-$box.height())/2;
				};
			},
			subFunc:function(e){													//提交数据
				var tag=e.target;
				var data=this.login_info;

				if(data.is_submitting==true){return};
				var txt='',p_ele=null,is_next=false;
				data.is_account=false;
				data.is_password=false;
				data.is_code=false;
				if(data.account==''){
					txt='请输入用户名';
					data.msg=txt;
					data.is_account=true;
				}else if(data.account.length<4){
					txt='用户名至少4位字符';
					data.is_account=true;
				}else if(data.password==''){
					txt='请输入密码';
					data.is_password=true;
				}else if(data.password.length<6){
					txt='密码至少6位字符';
					data.is_password=true;
				}else{
					is_next=true;
				}
				if(is_next==true){
					data.is_submitting=true;
					data.btntxt='登录中...';
					general.fn.subAjax({
                        url:def.ajax_port+'/api/login',
                        data:{'userName':data.account,'password':data.password},
                        success:function(rdata){
							data.is_submitting=false;
							data.btntxt='登录';
							var local_obj=general.fn.setLocalSto('global_storage') || {};
							if(local_obj.user!=undefined){
								local_obj.user.token=rdata.data.userToken;
								local_obj.user.name=rdata.data.userName;
							}else{
								local_obj.user={
									token:rdata.data.userToken,
									name:rdata.data.userName
								};
							}
							general.fn.setLocalSto('global_storage',local_obj);
							msg.msg({txt:'登录成功！'},function(){
								window.location.href='/api/welcome';
							},1200);

							
						},
                        error:function(){
                            data.is_submitting=false;
							data.btntxt='登录';
                        }
                    });
					
				}else{
					data.msg=txt;
				}
			}
		},
		mounted:function(){
			this.init();
		}
	})
});