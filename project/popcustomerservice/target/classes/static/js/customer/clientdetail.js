/*
    #author     lut000
    #date       2018/07/25
    #porpuse    客户详情
*/
require.config({
    paths: {
        
        'city':'common/city',
        'easy-checkbox':'common/easy-checkbox'
    },

    shim: {

    }
});
require(['vue','msg','general','city','easy-checkbox','base-info','layui'], function (Vue,msg,general,citys,easy_checkbox,global_info) {
    $(function () {
        var def={
            loading_ele:$('.js-loading-div'),
            ajax_port:global_info.api_url,
            msg_time:global_info.msg_time,
            tag_scroll_val:$('.js-topfixed-ele').eq(0).offset().top,
        };
        var vm = new Vue({
            el: '#app',
            data() {
                return {
                    account_info:{},                                                    //账号信息
                    customer_info:{},                                                   //客户基本信息
                    contact_list:{},                                                    //联系人列表
                    service_info:{},                                                    //客服信息
                    customer_tag:{},                                                    //用户标签
                    location_obj:general.fn.getLocationParameter(),                     //浏览器参数
                    province:citys,                                                     //当前省份数据
                    citys:[],                                                           //当前城市数据                                       
                    districts:[],                                                       //当前地区数据
                    feedback_list:[],                                                   //回访记录
                    get_opt:{                                                           //回访列表参数
                        contactId:'',
                        customerId:'',
                        size:10,
                        page:1
                    },
                    is_first:true,
                    tab_list:{                                                          //tab数据
                        receive:null,
                        assist:null,
                        activity:null,
                        call:{
                            callIns:null,
                            callOuts:null
                        },
                        service:null,
                        ground:null,
                        order:null,
                        invoice:null,
                        open:null,
                        shop:null,
                        info:null,
                        statistics:null
                    },
                    isWeChat:{
                        '0':'否',
                        '1':'是'
                    },
                    def:{
                        is_set_checkbox:false,
                        trees_data:{},
                        tags:{},
                        select_data:{
                            customer_origin:[]
                        }
                    },
                }
            },
            components:{
                'feedback-template':{                                                   //回复记录模板
                    props:['feedback_data'],
                    template:'#feedback-table'
                },
                'checkbox-template':{                                                   //回复记录模板
                    props:['now_checked_data'],
                    template:'#checkbox-template'
                }
            },
            methods:{
                getUserData:function(opt){                                                          //请求用户信息
                    var self=this;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/customer/info',
                        data:{id:self.location_obj.id},
                        success:function(data){
                            if(data && data.data){
                                self.account_info=data.data.accountInfo || {};
                                self.customer_info=data.data.customerInfo || {};
                                self.customer_tag=data.data.customerTag || {};
                                self.contact_list=data.data.contactList || [];
                                self.service_info=data.data.serviceInfo || {};
                                
                                self.setSityData(self.customer_info);
                                self.setTagData();

                                self.getTabData({
                                    customerId:self.location_obj.id,
                                    type:'receive'
                                });
                            }else{
                                msg.msg({'txt':'未请求到数据'},def.msg_time);
                            }
                            def.loading_ele.fadeOut(400);
                        },
                        error:function(){
                            def.loading_ele.fadeOut(400);
                        }
                    });
                },
                getCheckboxData:function(){                                                             //获取选项数据
                    var self=this,d=self.def;
                    general.fn.subAjax({
                        // url:def.ajax_port+'/api/tag/mulselects',
                        url:def.ajax_port+'/api/tag/mulselects/detail',
                        data:{type:0,id:self.location_obj.id,typeids:'tag00002,tag00003,tag00004,tag00005,tag00006,tag00007,tag00009,tag00014'},
                        success:function(data){
                            var ndata=data.data || [];
                            
                            $('.js-filter-div').each(function(){
                                var key=$(this).attr('data-id');
                                
                                var check_data=self.setCheckbox(ndata,key);
                                if(key=='tag00007'){
                                    var type=$(this).attr('data-type');
                                    check_data=type==1?check_data['children'][0]:check_data['children'][1];
                                }
                                self.setCheckboxDom(check_data,$(this));
                            });
                            
                            d.trees_data=ndata;
                        }
                    });


                    general.fn.subAjax({
                        url:def.ajax_port+'/api/tag/selects/detail',
                        data:{type:0,id:self.location_obj.id,typeids:'tag00020'},
                        success:function(data){
                            var ndata=data.data || [];
                            self.def.select_data.customer_origin=ndata[0].children || [];
                        }
                    });

                },
                setTagData:function(){                                                                  //设置标签数据
                    for(var key in this.customer_tag){
                        if(key!='tradeType'){
                            this.def.tags[key]=JSON.stringify(this.customer_tag[key].map(function(item){
                                return {id:item.id,tagId:item.tagId}
                            }));
                        }else{
                            this.def.tags.tradeType=this.customer_tag.tradeType;
                        }
                    };

                    this.def.tags.attention=JSON.stringify(this.service_info.attention) || '[]';
                    
                },
                setCheckbox:function(data,key){                                                         //取到复选框数据
                    var return_data=null;
                    for(var i=0,len=data.length;i<len;i++){
                        if(data[i]['id']==key){
                            return_data=data[i];
                            break;
                        }
                    }
                    return return_data;
                },
                setCheckboxDom:function(data,tag){                                                      //生成checkbox的dom
                    if(data!=null){
                        easy_checkbox.init({
                            data:data,
                            tag:tag.children('.js-checkbox-container').eq(0)[0],
                            ele:tag.siblings('.js-checked-list').eq(0)[0]
                        });
                    }
                },

                setSityData:function(obj){                                                              //获取城市数据
                    var self=this;
                    this.getNowProvince(this.province,obj.province);                 
                    this.getNowCity(this.citys,obj.city);                 
                    this.getNowDistricts(this.districts,obj.district);                 
                    
                },
                getNowProvince:function(data,val){                                                      //获取省份
                    if(val!=undefined){
                        for(var i=0,len=data.length;i<len;i++){
                            if(val==data[i].id){
                                this.citys=data[i]['citys'];
                                break;
                            }
                        }
                    }else{
                        this.citys=data[0]['citys'];
                    }
                },  
                getNowCity:function(data,val){                                                          //获取城市
                    if(val!=undefined){
                        for(var i=0,len=data.length;i<len;i++){
                            if(val==data[i].id){
                                this.customer_info.city=val;
                                this.districts=data[i]['districts'];
                                break;
                            }
                        }
                    }else{
                        this.customer_info.city=data[0].id;
                        this.districts=data[0]['districts'];
                    }
                },
                getNowDistricts:function(data,val){                                                     //获取地区
                    if(val!=undefined){
                        this.customer_info.district=val;
                    }else{
                        this.customer_info.district=data[0].id;
                    }
                },
                changeCitys:function(event,key){                                                        //选择城市
                    var tag=event.target;
                    var val=tag.value;
                    if(key=='province'){
                        this.getNowProvince(this.province,val);
                        this.getNowCity(this.citys);
                        this.getNowDistricts(this.districts);
                    }else{
                        this.getNowCity(this.citys,val);
                        this.getNowDistricts(this.districts);
                    }
                },
                getCity:function(){
                    function abc(opt,index){
                        $.ajax({
                            url:def.ajax_port+'/api/datadict/getArea',
                            contentType:'application/json',
                            type:'post',
                            data:JSON.stringify({'fatherid':opt.id}),
                            async:false,
                            success:function(data){
                                if(data && data.data && data.data.length>0){
                                    var ndata=data.dataa.data;
                                    var now_data=[];
                                    ndata.forEach(function(item){
                                        now_data.push({
                                            id:item.id,
                                            name:item.name
                                        });
                                    });
                                    opt['districts']=now_data;
                                }
                            }
                        });
                    };
                },

                getFeedbackData:function(opt){                                                          //请求回访列表数据
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
                                msg.msg({'txt':'未请求到数据'},def.msg_time);
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
                                        self.getFeedbackData(self.get_opt);
                                    }
                                    
                                }
                            });
                        });
                    }
                },
                getTabData:function(opt){                                                               //请求tab数据
                    var self=this;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/customer/type',
                        data:opt,
                        success:function(data){
                            console.log(data)
                            if(data && data.data){
                                if(opt.type!='info' && opt.type!='statistics'){
                                    self.tab_list[opt.type]=data.data;
                                }
                                if(opt.type=='info' && data.data.linkUrl!='' && data.data.linkUrl!=undefined){
                                    window.open(data.data.linkUrl)
                                }
                                if(opt.type=='statistics' && data.data.linkUrl!='' && data.data.linkUrl!=undefined){
                                    window.open(data.data.linkUrl)
                                }
                            }else{
                                msg.msg({'txt':'未请求到数据'},def.msg_time);
                            }
                            def.loading_ele.fadeOut(400);
                        },
                        error:function(){
                            def.loading_ele.fadeOut(400);
                        }
                    });
                },
                // 保存为主联系人
                changeMainUser:function(id){
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/contact/update',
                        data:{'id':id,'contactParam':{'main':1}},
                        success:function(data){
                            msg.msg({'txt':'修改主联系人成功！'},def.msg_time);
                        }
                    });
                },
                saveFunc:function(e){                                                                           //提交更新数据
                    var tag=e.target;
                    var return_data={
                        id:this.location_obj.id
                    };

                    this.setObj(this.customer_info,return_data,['companyName','bank','province','city','district','address','email','phone']);

                    var ids=[],narr=[];
                    for(var key in this.def.tags){
                        if(key=='tradeType'){
                            if(this.def.tags[key]!=''){
                                ids.push({
                                    id:this.def.tags[key],
                                    tagId:'tag00010'
                                })
                            }
                        }else{
                            narr=JSON.parse(this.def.tags[key]);
                            if(narr.length>0){
                                ids=ids.concat(narr);
                            }
                        }
                        
                    }

                    $('.js-select-ele').each(function(){
                        var tag_id=$(this).attr('data-id');
                        var id=$(this).val();
                        if(id!='' && id!=null && id!=undefined){
                            ids.push({
                                id:$(this).val(),
                                tagId:tag_id
                            })
                        }
                    });
                    if(this.service_info.attentionRemark!=''){
                        return_data.attentionRemark=this.service_info.attentionRemark;
                    }
                    
                    return_data.tags=ids;


                    def.loading_ele.fadeIn(200);
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/customer/update',
                        data:return_data,
                        success:function(data){
                            
                            msg.msg({'txt':'保存成功'},def.msg_time);
                            def.loading_ele.fadeOut(400);
                        },
                        error:function(){
                            def.loading_ele.fadeOut(400);
                        }
                    });

                    
                },

                setObj:function(obj,tag_obj,keys){                                                          //生成对象
                    keys.forEach(function(item){
                        // if(obj[item]!=''){
                            tag_obj[item]=obj[item];
                        // }
                    });
                },


                bindFunc:function(){
                    var self=this,d=self.def,has_checked_id=[],has_checked_txt=[];
                    // 点击获取焦点
                    $('.js-checked-list').on('click',function(e){
                        var $self=$(this),tag_ele=$self.siblings('.js-filter-div');
                        $(".js-filter-div").hide();
                        tag_ele.show();
                        e.stopPropagation();
                    });

                    // checkbox选中事件处理
                    $('.js-filter-div').on('change','.js-trees-list>li>input',function(){
                        var now_checked=$(this).prop('checked');
                        var is_checked_all=true;
                        $self=$(this),children_list=$self.parent().children('.js-trees-list');
                        $self.parent().siblings('li').each(function(){
                            if($(this).children('input').prop('checked')==false){
                                is_checked_all=false;
                                return false;
                            }
                        });
                        if(now_checked==true){
                            if(is_checked_all==true && $self.parent().parent().parent('li')){
                                $self.parent().parent().parent('li').children('input').prop('checked',true);
                            }
                            setChildrenCheck($self.parent(),true);
                        }else{
                            if($self.parent().parent().parent('li')){
                                $self.parent().parent().parent('li').children('input').prop('checked',false);
                            }
                            setChildrenCheck($self.parent(),false);
                        }
                    });
                    // 隐藏下拉选择层
                    $('.js-filter-div').on('click',function(e){
                        e.stopPropagation();
                    });
                    $('#page-wrapper').on('click',function(){
                        $('.js-filter-div').hide();
                    });
                  
                    
                    // 确定筛选项
                    $('.js-add-checked').on('click',function(){
                        var id=$(this).parents('.js-filter-div').attr('data-id') || '';
                        var tag=$(this).parent().siblings('.js-checkbox-container');
                        $(this).parents('.js-filter-div').hide();
                        has_checked_id=[];
                        has_checked_txt=[];
                        forTreeDom(tag);
                        setFilterDom($(this).parents('.js-filter-div').siblings('.js-checked-list'),has_checked_id,has_checked_txt);
                    });
                    // 取消筛选项
                    $('.js-cancel-checked').on('click',function(){
                        $(this).parents('.js-filter-div').hide();
                    });
                    // 收起子集
                    $('.js-filter-div').on('click','.js-trees-list>li>span',function(){
                        var type=$(this).attr('data-on') || 'false';
                        if(type=='false'){
                            $(this).siblings('.js-trees-list').slideDown(200);
                            $(this).attr('data-on',true);
                            $(this).text('-');
                        }else{
                            $(this).siblings('.js-trees-list').slideUp(50);
                            $(this).attr('data-on',false);
                            $(this).text('+');
                        }
                    });
                    



                    function forTreeDom(obj){                                                               //循环checkbox dom
                        obj.children('.js-trees-list').children('li').each(function(){
                            var has_child=$(this).children('.js-trees-list').length>0?true:false;
                            var is_checked=$(this).children('input').is(':checked');
                            var id=$(this).attr('data-id') || '';
                            var pid=$(this).attr('data-pid') || '';
                            var txt=$(this).children('label').text();


                            if(has_child){
                                if(is_checked){
                                    has_checked_id.push({id:id,tagId:pid});
                                    has_checked_txt.push(txt);
                                }
                                forTreeDom($(this));
                            }else{
                                if(is_checked){
                                    has_checked_id.push({id:id,tagId:pid});
                                    has_checked_txt.push(txt);
                                }
                            }
                        });
                    };

                    function setChildrenCheck(obj,val){                                                        //子集跟随父级选中
                        var children_list=obj.children('.js-trees-list');
                        if(children_list.length>0){
                            children_list.children('li').each(function(){
                                $(this).children('input').prop('checked',val);
                            });
                        }
                    };

                    function setFilterDom(tag,id_arr,txt_arr){                                                 //选中结果dom添加
                        var _html='';
                        txt_arr.forEach(function(item,index){
                            if(index==0){
                                _html+='<li>'+item+'</li>';
                            }else{
                                _html+='，<li>'+item+'</li>';
                            }
                        });
                        tag.html(_html);
                        var key=tag.attr('data-key');
                        d.tags[key]=JSON.stringify(id_arr);
                        // tag.attr('data-checkid',JSON.stringify(id_arr));
                    };


                    // tab表格栏
                    $('.js-tab-list>li.js-tab-item').on('click',function(){
                        var index = $(this).index();
                        var key=$(this).attr('data-key');
                        if(self.tab_list[key]==null){
                            def.loading_ele.fadeIn(200);
                            self.getTabData({
                                customerId:self.location_obj.id,
                                type:key
                            });
                        }else{
                            if(key=='call'){
                                if(self.tab_list[key].callIns==null && self.tab_list[key].callOuts==null){
                                    def.loading_ele.fadeIn(200);
                                    self.getTabData({
                                        customerId:self.location_obj.id,
                                        type:key
                                    });
                                }
                            }
                        }
                        $(this).addClass('stats-active').siblings().removeClass('stats-active')
                        $('.js-stats-info>div').eq(index).show().siblings().hide();
                    });


                    // 收起区域
                    $('.js-slide-btn').on('click', function () {
                        var $this=$(this);
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



                    setFixedEle($(window).scrollTop());
                    $(window).on('scroll',function(){
                        setFixedEle($(this).scrollTop());
                    });



                    function setFixedEle(now_scroll){                                                       //设置固定位置
                        if(now_scroll>def.tag_scroll_val){
                            $('.js-topfixed-ele').addClass('fixed-status');
                        }else{
                            $('.js-topfixed-ele').removeClass('fixed-status');
                        }
                    }
                }
            },
            mounted:function(){
                this.getUserData();
                this.get_opt.customerId=this.location_obj.id;
                this.getFeedbackData(this.get_opt);
                this.getCheckboxData();
                this.bindFunc();
            }
        });
    })
})