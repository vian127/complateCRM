/*
    #author     gaofeng
    #date       2018/07/23
    #purpose    群发-选择客户
*/



require(['vue','jquery','general','layui','base-info'], function (Vue,jquery,general,layui,global_info) {
    $(function () {
        var def={
            loading_ele:$('.js-loading-div'),
            ajax_port:global_info.api_url,
        };

        var vm = new Vue({
            el: '#app',
            data:{
                ownerid:'000101WD',                                                      //用户id
                location_obj:general.fn.getLocationParameter(),                 //浏览器参数
                get_opt:{},
                task_count:{                        //任务数量对象
                    addCount:222,
                    selectCount:333
                },
                list:[],
                thead:[{name:'主账号',id:3,is_show:true},
                       {name:'公司名称',id:4,is_show:true},
                       {name:'未回访天数',id:5,is_show:true},
                       {name:'未登录时间',id:6,is_show:true},
                       {name:'领用人',id:7,is_show:true},
                       {name:'领用时间',id:8,is_show:true}],
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
                list_info:{
                    is_show_select:false,
                    checked_all:true
                },
                is_first:true,                                                          //是否第一次调用加载数据
                is_set_date:false,                                                      //是否已经建立时间控件
                layer_index:null,                                                       //弹出层对象
                layer:null,                                                             //构造方法
            },
            mounted:function(){
                this.getNewData({
                    ownerId:this.ownerid,
                    page:1,
                    size:10
                });
            },
            methods:{
                getNewData:function(opt){
                    def.loading_ele.fadeIn(200);
                    this.get_opt=opt;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/customer/list',
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
                changeCol:function(event,id){                                               //单选
                    var tag=event.target;
                    var is_check=tag.checked;
                    if(is_check==true){
                        $('.js-list-table').find('.js-col'+id+'-ele').show();
                    }else{
                        $('.js-list-table').find('.js-col'+id+'-ele').hide();
                    }
                    var checked_len=0;
                    this.thead.forEach(function(item){
                        if(id==item.id){
                            item.is_show=is_check;
                        }
                        item.is_show==true?checked_len++:checked_len;
                    });

                    // 全选判断
                    if(is_check==true){
                        if(this.list_info.checked_all==false && checked_len==this.thead.length){
                            this.list_info.checked_all=true;
                        }
                    }else{
                        if(checked_len==this.thead.length-1 && this.list_info.checked_all==true){
                            this.list_info.checked_all=false;
                        }
                    }

                },
                changeAll:function(e){                                                      //全选
                    var tag = e.target;
                    var is_check = tag.checked;
                    if(is_check==true){
                        $('.js-list-table').find('.js-can-hide').show();
                        this.thead.forEach(item=>item.is_show=true);
                    }else{
                        $('.js-list-table').find('.js-can-hide').hide();
                        this.thead.forEach(item=>item.is_show=false);
                    }

                },
                toggleSelect:function(){                                                    //显示隐藏
                    this.list_info.is_show_select=!this.list_info.is_show_select;
                },
                saveSelect:function(){                                                      //确认提交选择
                    console.log(this.thead);
                    this.toggleSelect();
                },

                filterFunc:function(){                                                      //确认筛选列表
                    var opt={};
                    for(var key in this.collect){
                        if(this.collect[key]!=""){
                            opt[key]=this.collect[key];
                        }
                    }
                    opt.ownerId=this.ownerid;
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
                            area:['80%'],
                            content: $('.js-advanced-filter-box'),
                            shadeClose:true,
                            closeBtn:1,
                            fixed:false,
                            btn: ['重置', '取消', '确认筛选'],
                            yes:function(){
                                console.log($(".js-advanced-filter-box form").eq(0));
                                $(".js-advanced-filter-box form")[0].reset();
                            },
                            btn3:self.advancedFilterFunc,
                            anim:1,
                            success:function(){
                                if(self.is_set_date==false){
                                    layui.use('laydate', function(){
                                        var laydate = layui.laydate;
                                        laydate.render({
                                            elem: '.js-date-area1'
                                        });
                                        laydate.render({
                                            elem: '.js-date-area2'
                                        });
                                    });
                                }
                            }
                        });
                    });
                },

                advancedFilterFunc:function(){                                                //确认高级筛选
                    return false;
                },

                resetFunc:function(type){                                                     //重置数据
                    if(type==1){
                        for(var key in this.collect){
                            this.collect[key]='';
                        }
                    }
                },
            }
        });

    })
})
