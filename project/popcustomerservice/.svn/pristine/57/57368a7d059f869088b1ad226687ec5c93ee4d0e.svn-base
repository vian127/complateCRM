/*
    #author     gaofeng
    #date       2018/07/24
    #purpose    模板编辑
*/

require(['vue', 'msg', 'general','base-info','layui'], function (Vue, msg, general,global_info) {
    $(function () {
        var def = {
            loading_ele: $('.js-loading-div'),
            ajax_port: global_info.api_url,
            msg_time:global_info.msg_time,
        };


        var vm = new Vue({
            el: '#app',
            data: {
                location_obj: general.fn.getLocationParameter(), //浏览器参数
                template_info: {                                 //模板数据对象        
                    name: '',
                    sign: 1,
                    content:''
                },
                // 签名
                signs:[{id:1,title:'POP资讯'}],
                collect_info:{
                    num:0,
                    alias:''
                },
                textLengths:0,                                   //签名文字长度       
                
            },
            mounted() {
                this.getNewTemplate({id: this.location_obj.id})
            },
            methods: {
                signFunc:function(){                             //设置内容签名   
                    var key = this.template_info.sign-1;
                    var titles=this.signs[key].title;
                    this.textLengths=titles.length;
                    this.template_info.content=this.template_info.content.replace(titles,'');
                },
                getNewTemplate: function (opt) {                //请求模板数据
                    def.loading_ele.fadeIn(200);
                    var self=this
                    if(opt.id!=undefined){
                        general.fn.subAjax({
                            url: def.ajax_port + '/api/msgTemplate/info',
                            data: opt,
                            success: function (data) {
                                if (data && data.data) {
                                  self.template_info = data.data || {};
                                  self.collect_info.num=data.data.num;
                                  self.signFunc();
                                } else {
                                    msg.msg({'txt': '未请求到数据'}, def.msg_time);
                                }
                                def.loading_ele.fadeOut(400);
                            },
                            error: function () {
                                def.loading_ele.fadeOut(400);
                            }
                        });
                    }
                    def.loading_ele.fadeOut(400);
                },
                saveFunc:function(){                                //保存模板
                    var self=this
                    var data=this.template_info;
                    var msg_txt={'name':'请输入模板名称','sign':'请选择模板签名','content':'请输入模板内容'};
                    var is_next=true;
                    var return_data={};
                    for(var key in data){
                        switch(key){
                            case 'name':
                            case 'sign':
                            case 'content':
                                if(data[key]==''){
                                    is_next=false;
                                    msg.msg({'txt':msg_txt[key]},def.msg_time);
                                }
                                break;
                        }
                        if(is_next==false){
                            break;
                        }
                        if(data[key]!=""){
                            return_data[key]=data[key];
                        }
                        if(key=="content"){             //设置模板签名到内容            
                            var _key = self.template_info.sign-1;
                            var titles=self.signs[_key].title
                            return_data['content']=titles+data['content'];
                        }
                    }
                  
                    if(is_next==true){
                        def.loading_ele.fadeIn(200);
                        general.fn.subAjax({
                            url:def.ajax_port+'/api/msgTemplate/update',
                            data:return_data,
                            success:function(){
                                msg.msg({'txt':'保存成功！'},def.msg_time);
                                def.loading_ele.fadeOut(400);
                            },
                            error:function(){
                                def.loading_ele.fadeOut(400);
                            }
                        });
                    }
                },
            }
        })
    })
})