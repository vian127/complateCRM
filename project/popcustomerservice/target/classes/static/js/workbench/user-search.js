/*
    #author     lut000
    #date       2018/07/16
    #porpuse    客户列表
*/
require.config({
    paths: {
        
    },
    shim: {
          
    }
});
require(['vue','jquery','general','layui','base-info'], function (Vue,jquery,general,layui,global_info) {
    $(function () {
        var def={
            loading_ele:$('.js-loading-div'),
            ajax_port:global_info.api_url,
        };
        def.loading_ele.fadeOut(400);
        var vm = new Vue({
            el: '#app',
            data:{
                get_opt:{
                    page:1,
                    size:10
                },
                search_list:[],
                collect:{
                    account:'',
                    companyName:'',
                    contactPhone:'',
                    serviceStage:'',
                    receiveName:'',
                    id:'',
                    qq:'',
                    webSource:'',
                },
                is_first:true,                                                          //是否第一次调用加载数据
                is_set_date:false,                                                      //是否已经建立时间控件
                layer_index:null,                                                       //弹出层对象
                layer:null,                                                             //构造方法
            },
            mounted:function(){
               
            },
            methods:{
                getNewData:function(opt){                                                   //获取列表数据
                    def.loading_ele.fadeIn(200);
                    this.get_opt=opt;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/customer/list',
                        data:opt,
                        success:this.setData,
                        error:function(){
                            def.loading_ele.fadeOut(400);
                        }
                    });
                },
                setData:function(data){                                                     //设置数据
                    var self=this;
                    if(data!=undefined && data.data!=undefined){
                        for(var key in this.collect){
                            if(this.collect[key]!=""){
                                this.search_list=data.data;
                                this.setPage(data.extra.count);
                                break;
                            }
                        }
                    }
                   
                    def.loading_ele.fadeOut(400);
                },
                setPage:function(count){                                                         //设置分页
                    var self=this;
                    if(this.is_first==true){
                        this.is_first=false;
                        layui.use('laypage', function(){
                            var laypage = layui.laypage;
                            //执行一个laypage实例
                            laypage.render({
                                elem: 'laypage-section'
                                ,count: count
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
                                        self.getNewData(self.get_opt);
                                    }
                                    
                                }
                            });
                        });
                    }
                },
                filterFunc:function(){                                                      //确认筛选列表
                    var opt={},_ids=[];
                    for(var key in this.collect){
                        if(this.collect[key]!=""){
                            opt[key]=this.collect[key];
                        }
                    }
                    opt.page=1;
                    opt.size=this.get_opt.size;
                    this.is_first=true;
                    this.getNewData(opt);       
                },
                resetFunc:function(type){                                                     //重置数据
                    for(var key in this.collect){
                        this.collect[key]='';
                    }
                    this.search_list=[];
                    $('#laypage-section').css('display','none')
                },
            }
        });

    })
})