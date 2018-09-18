/*
    #author     gaofeng
    #date       2018/07/23
    #purpose    发件箱
*/

require(['vue', 'msg','general', 'base-info','layui'], function (Vue, msg,general, global_info) {
    $(function () {
        var def = {
            loading_ele: $('.js-loading-div'),
            ajax_port: global_info.api_url,
        };
        var vm = new Vue({
            el: '#app',   
            data:{
                list_data:[],                                               //当前列表数据
                select_info:[],                                             //缓存下拉选项
                get_opt:{
                    page:1,
                    size:10
                },
                count:{                                                     //发送数量
                    surplusCount:111,
                    sendCount:222,
                },
                collect:{                                                  //确认筛选数据对象
                    phoneNumber:'',
                    templateId:'',
                    status:'',
                    creatorroleid:'',
                    batchId:'',
                },
                is_first:true,
            },
            mounted(){
                this.selectData()
                this.getSendData(this.get_opt)
            },
            methods:{
                selectData:function(){
                    var self = this
                    general.fn.subAjax({
                        url: def.ajax_port + '/api/msgTemplate/getSelectList',
                        type: 'get',
                        success: function (data) {
                            if (data && data.data) {
                                self.select_info= data.data;
                            } else {
                                msg.msg({
                                    'txt': '未请求到数据'
                                }, def.msg_time);
                            }
                            def.loading_ele.fadeOut(400);
                        },
                        error: function () {
                            def.loading_ele.fadeOut(400);
                        }
                    });
                },
                getSendData:function(opt){
                    def.loading_ele.fadeIn(200);
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/msg/sendList',
                        data:opt, 
                        success:this.setData,
                        error:function(){
                            def.loading_ele.fadeOut(400);
                        }
                    });
                },
                setData:function(data){
                    console.log(data)
                    var self=this;
                    if(data!=undefined && data.data!=undefined){
                        self.list_data=data.data;
                        if(self.is_first==true){
                            self.is_first=false;
                            layui.use('laypage', function(){
                                var laypage = layui.laypage;
                                //执行一个laypage实例
                                laypage.render({
                                    elem: 'laypage-section'
                                    ,count: data.extra.count
                                    ,layout: [ 'prev', 'page', 'next','limit','count', 'skip']
                                    ,jump: function(obj,first){
                                        if(obj.count<=obj.limit){
                                            $('#laypage-section').hide();
                                        }else{
                                            $('#laypage-section').show();
                                        }
                                        if(!first){
                                            self.get_opt.size=obj.limit;
                                            self.get_opt.page=obj.curr;
                                            self.getSendData(self.get_opt);
                                        } 
                                    }
                                });
                            });
                        }
                    }
                    def.loading_ele.fadeOut(400);
                },

                resetFunc:function(){
                    for(var key in this.collect) {
                        this.collect[key] = ""
                    }
                },
                filterFunc:function(){                                              //确认筛选
                    var opt={};
                    for(var key in this.collect){
                        if(this.collect[key]!=""){
                            opt[key]=this.collect[key];
                        }
                    }
                    opt.page=1;
                    opt.size=this.get_opt.size;
                    this.is_first=true;
                    this.getSendData(opt)
                }
            },
           
        });
     })
  })