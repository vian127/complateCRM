/*
    #author     gaofeng
    #date       2018/07/23
    #purpose    回访管理
*/
require.config({
    paths: {
        'visit-filter':'manage/visit-filter'
    },

    shim: {
        
    }
});
require(['vue','jquery','general','layui','base-info'], function (Vue,jquery,general,layui,global_info) {
    $(function () {
        var def = {
            loading_ele: $('.js-loading-div'),
            ajax_port:global_info.api_url,
        };
       
        var vm = new Vue({
            el: '#app',
            data:{
                list:[],
                get_opt:{},                                                              //请求数据
                thead:[                                                                 //表头内容
                    {id:2,is_show:true,name:'创建日期'},
                    {id:3,is_show:true,name:'创建人'},
                    {id:4,is_show:true,name:'主账号'},
                    {id:5,is_show:true,name:'客户'},
                    {id:6,is_show:true,name:'服务方式'},
                    {id:7,is_show:true,name:'用户角色'},
                    {id:8,is_show:true,name:'用户职位'},
                    {id:9,is_show:true,name:'服务对象'},
                    {id:10,is_show:true,name:'手机号码'},
                    {id:11,is_show:true,name:'联络类型'},
                    {id:12,is_show:true,name:'联络结果'},
                    {id:13,is_show:true,name:'服务类型'},
                    // {id:14,is_show:true,name:'最后修改时间'},
                    // {id:15,is_show:true,name:'最后修改人'},
                ],
                collect:{                                                               //筛选数据对象
                    accountName:'',
                    companyName:'',
                    phone:'',
                    ownerName:'',
                    startDate:'',
                    endDate:'',
                    role:''
                },
                select_role:[],
                list_info:{
                    is_show_select:false,
                    checked_all:true
                },
                is_first:true,                                                          //是否第一次调用加载数据
                is_set_date:false,                                                      //是否已经建立时间控件
                layer:null,                                                             //构造方法
            },
            mounted() {
                this.getNewData({
                    page:1,
                    size:10,
                })
                this.getRole();
                this.dateTime();
            },
            methods: {
                getNewData:function(opt){
                    def.loading_ele.fadeIn(200);
                    this.get_opt=opt;
                    general.fn.subAjax({
                       // url:' http://192.168.1.38:8081/api/feedBack/list',
                       url:def.ajax_port+'/api/feedBack/list',
                       data:opt,
                       success:this.setData,
                       error:function(){
                            def.loading_ele.fadeOut(400);
                       }
                    })
                },
                setData:function(data){
                    var self=this;
                    if(data!=undefined && data.data!=undefined){
                        this.list=data.data;
                        if(this.is_first==true){
                            this.is_first=false;
                            layui.use('laypage', function () {
                                var laypage = layui.laypage;
                                //执行一个laypage实例
                                laypage.render({
                                    elem: 'laypage-section',
                                    count: data.extra.count,
                                    layout: ['prev', 'page', 'next', 'limit', 'count', 'skip'],
                                    jump: function (obj,first) {
                                      if(obj.count*1<=obj.limit){
                                        $('#laypage-section').hide();
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
                    }
                   def.loading_ele.fadeOut(400);
                },
                getRole:function(){
                    var self=this;
                    general.fn.subAjax({
                        // url:def.ajax_port+'/api/tag/mulselects',
                        url:def.ajax_port+'/api/tag/mulselects/detail',
                        data:{type:1,id:'',typeids:'tag00018'},
                        success:function(data){
                            var ndata=data.data || [];
                            self.select_role=ndata[0]['children'] || [];
                        }
                    });
                },
                resetFunc:function(){                                       //重置
                    for(var key in this.collect) {
                        this.collect[key] = ""
                    }
                },
                dateTime: function () {                                      //时间控件
                    var self = this
                    if(self.is_set_date==false){
                        layui.use('laydate', function () {
                            var laydate = layui.laydate;
                            laydate.render({
                                elem: '.js-timeStart',
                                done: function(value){
                                   self.collect.startDate=value
                                  }
                            });
                            laydate.render({
                                elem: '.js-timeEnd',
                                done: function(value){
                                    self.collect.endDate=value
                                   }
                            });  
                       })
                    }
                },
                toggleSelect: function () {                                 //显示隐藏
                    this.list_info.is_show_select = !this.list_info.is_show_select;
                },
                changeCol: function (event, id) {                           //单选
                    var tag = event.target;
                    var is_check = tag.checked;
                    if (is_check == true) {
                        $('.js-list-table').find('.js-col' + id + '-ele').show();
                    } else {
                        $('.js-list-table').find('.js-col' + id + '-ele').hide();
                    }
                    var checked_len = 0;
                    this.thead.forEach(function (item) {
                        if (id == item.id) {
                            item.is_show = is_check;
                        }
                        item.is_show == true ? checked_len++ : checked_len;
                    });

                    // 全选判断
                    if (is_check == true) {
                        if (this.list_info.checked_all == false && checked_len == this.thead.length) {
                            this.list_info.checked_all = true;
                        }
                    } else {
                        if (checked_len == this.thead.length - 1 && this.list_info.checked_all == true) {
                            this.list_info.checked_all = false;
                        }
                    }
                },
                changeAll: function (e) {                                 //全选
                    var tag = e.target;
                    var is_check = tag.checked;
                    if (is_check == true) {
                        $('.js-list-table').find('.js-can-hide').show();
                        this.thead.forEach(item => item.is_show = true);
                    } else {
                        $('.js-list-table').find('.js-can-hide').hide();
                        this.thead.forEach(item => item.is_show = false);
                    }
                },

                filterFunc: function () {                                //确认筛选列表
                    var opt={};
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

                showFilterBox:function(){                                                   //弹出层
                    var self=this;
                    layui.use('layer', function(){
                        var layer=layui.layer;
                        layer.open({
                            title:'',
                            type: 1, 
                            area:['60%'],
                            content: $('.js-visit-filter-box'),
                            shadeClose:true,
                            closeBtn:1,
                            fixed:false,
                            btn: ['取消', '确认筛选'],
                            yes:function(index){
                                layer.close(index);
                            },
                            btn2:self.advancedFilterFunc,
                            anim:1,
                            success:function(){
                                require(['visit-filter']);
                            }
                        });
                    });
                },
                advancedFilterFunc:function(){                                                //确认高级筛选
                    var opt={},_ids=[];
                    for(var key in global_filter_tags){
                        for(var i=0,len=global_filter_tags[key].length;i<len;i++){
                            _ids.push(global_filter_tags[key][i].id)
                        }
                        opt[key]=_ids.join(',');
                        _ids=[];
                    }
                     
                    opt.page=1;
                    opt.size=this.get_opt.size;
                    this.is_first=true;
                    this.getNewData(opt)
                },
              
            }
        })
    })
})  