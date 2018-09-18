/*
    #author     lut000
    #date       2018/07/25
    #porpuse    联系人详情
*/
require(['vue','msg','general','base-info','layui'], function (Vue,msg,general,global_info) {
    $(function () {
        var def={
            loading_ele:$('.js-loading-div'),
            ajax_port:global_info.api_url,
        };
        var vm = new Vue({
            el: '#app',
            data() {
                return {
                    user_info:{},                                                       //联系人信息
                    customer_info:{},                                                   //账户信息
                    service_info:{},                                                    //客服信息
                    management_info:{},                                                 //用户管理信息
                    location_obj:general.fn.getLocationParameter(),                     //浏览器参数
                    feedback_list:[],                                                   //回访记录
                    get_opt:{                                                           //回访列表参数
                        contactId:'',
                        customerId:'',
                        size:10,
                        page:1
                    },
                    is_first:true
                }
            },
            components:{
                'feedback-template':{                                                   //回复记录模板
                    props:['feedback_data'],
                    template:'#feedback-table'
                }
            },
            methods:{
                getUserData:function(opt){                                                          //请求用户信息
                    var self=this;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/contact/info',
                        data:opt,
                        success:function(data){
                            if(data && data.data){
                                self.user_info=data.data.contactInfo || {};
                                self.customer_info=data.data.customerInfo || {};
                                self.management_info=data.data.manager || {};

                            }else{
                                msg.msg({'txt':'未请求到数据'},1200);
                            }
                            def.loading_ele.fadeOut(400);
                        },
                        error:function(){
                            def.loading_ele.fadeOut(400);
                        }
                    });
                },
                getfeedbackData:function(opt){                                                          //请求回访列表数据
                    var self=this;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/feedBack/list',
                        data:opt,
                        success:function(data){
                            if(data && data.data){
                                self.feedback_list=data.data || [];
                                // 分页
                                self.setPage(data.extra.count);
                            }else{
                                msg.msg({'txt':'未请求到数据'},1200);
                            }
                        }
                    });
                },
                setPage:function(count){
                    var self=this;
                    if(self.is_first==true){
                        self.is_first=false;
                        layui.use('laypage', function(){
                            var laypage = layui.laypage;
                            //执行一个laypage实例
                            laypage.render({
                                elem: 'laypage-section'
                                ,count: count
                                ,layout: [ 'prev', 'page', 'next','limit','count', 'skip']
                                ,jump: function(obj,first){
                                    if(obj.count*1<=obj.limit){
                                        $('#laypage-section').hide();
                                    }else{
                                        $('#laypage-section').show();
                                    }
                                    if(!first){
                                        self.get_opt.size=obj.limit;
                                        self.get_opt.page=obj.curr;
                                        self.getfeedbackData(self.get_opt);
                                    }
                                    
                                }
                            });
                        });
                    }
                },
                saveFunc:function(e){
                    var data=this.detail_info;
                    data.btn_save=false;
                    var txt='';
                    if(data.is_name==''){
                        txt='用户不能为空';
                        data.msg=txt;
                        msg.msg({txt:data.msg},1000);
                        return;
                    }else if(data.is_company==''){
                        txt='所属客户不能为空！';
                        data.msg=txt;
                        msg.msg({txt:data.msg},1000);
                        return;
                    }else if(data.is_linkman==''){
                        txt='主联系人不能为空！';
                        data.msg=txt;
                        msg.msg({txt:data.msg},1000);
                        return;
                    }else if(data.is_position==''){
                        txt='公司职务不能为空！';
                        data.msg=txt;
                        msg.msg({txt:data.msg},1000);
                        return;
                    }else if(data.is_role==''){
                        txt='角色不能为空！';
                        data.msg=txt;
                        msg.msg({txt:data.msg},1000);
                        return;
                    }else if(data.is_status==''){
                        txt='客户状态不能为空！';
                        data.msg=txt;
                        msg.msg({txt:data.msg},1000);
                        return;
                    }else if(data.is_is_impression==''){
                        txt='客户印象不能为空！';
                        data.msg=txt;
                        msg.msg({txt:data.msg},1000);
                        return;
                    }
                    console.log(data)
                    msg.msg({txt:'保存成功'},1000);
                    setTimeout(function(){
                        // window.location.href='../../views/workbench/userdetail.html'
                    },1000)
                },
                init:function(){
                    this.getUserData({id:this.location_obj.contactid});
                    this.get_opt.contactId=this.location_obj.contactid;
                    this.get_opt.customerId=this.location_obj.customerid;
                    this.getfeedbackData(this.get_opt);
                    this.bindFunc();
                },
                bindFunc:function(){
                    $('.js-slide-btn').on('click', function () {
                        var status=$(this).attr('data-slide') || 2;
                        if(status==2){
                            $(this).attr('data-slide',1);
                            $(this).children('button').text('+');
                            $(this).addClass('slide-up');
                        }else{
                            $(this).attr('data-slide',2);
                            $(this).children('button').text('-');
                            $(this).removeClass('slide-up');
                        }
                        $(this).parent().next().toggle();
                    });
                }
            },
            mounted:function(){
                
                this.init();
            }
        });
    })
})