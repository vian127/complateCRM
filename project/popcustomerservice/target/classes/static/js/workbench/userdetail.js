require.config({
  paths: {
    'city':'common/city',
    'easy-checkbox':'common/easy-checkbox'
  },
 
  shim: {
    
  }
});
  
require(['jquery','vue','general','msg','layui','city','base-info','easy-checkbox'], function (jquery,Vue,general,msg,layui,citys,global_info,easy_checkbox) {
    $(function (){

        var def={
            loading_ele:$('.js-loading-div'),
            ajax_port:global_info.api_url,
            msg_time:1200,                                                              //弹出框隐藏时间
        };
        var vm = new Vue({
            el: '#app',
            data() {
                return {
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
                    location_obj:general.fn.getLocationParameter(),                     //浏览器参数

                    visit:{
                        contact_type:'feedbtagval0000000053',
                        remark:'',
                        result:'',
                        recommend:''
                    },

                    account_info:{},                                                    //账号信息
                    customer_info:{},                                                   //客户基本信息
                    contact_list:{},                                                    //联系人列表
                    service_info:{},                                                    //客服信息
                    customer_tag:{},                                                    //用户标签
                    service_tag:{                                                       //客户服务详情
                        results:{
                            'feedbtagval0000000053':[{'id':"feedbtagval0000000055",'name':'完成'},{'id':"feedbtagval0000000056",'name':'跟进'}],
                            'feedbtagval0000000054':[{'id':"feedbtagval0000000057",'name':'稍后联络'},{'id':"feedbtagval0000000058",'name':'无人接听'},{'id':"feedbtagval0000000059",'name':'空号/错号'}]
                        },
                        cutomer_tags:{
                            invoice:{
                                'feedbtagval0000000006':[{'id':'feedbtagval0000000012',name:'完成','is_checked':false},{'id':'feedbtagval0000000013',name:'缺税号','is_checked':false},{'id':'feedbtagval0000000014',name:'缺委托书','is_checked':false}],
                                'feedbtagval0000000007':[{'id':'feedbtagval0000000015',name:'完成','is_checked':false},{'id':'feedbtagval0000000016',name:'缺开票资料','is_checked':false},{'id':'feedbtagval0000000017',name:'缺委托书','is_checked':false}]
                            },
                        },
                        contact_tags:{
                            products_origin:[
                                {'productId':1,'productName':'APM','productStatusId':0,'status':0},
                                {'productId':2,'productName':'书籍','productStatusId':0,'status':0},
                                {'productId':3,'productName':'总裁班','productStatusId':0,'status':0},
                                {'productId':4,'productName':'云图','productStatusId':0,'status':0},
                                {'productId':5,'productName':'韩国行','productStatusId':0,'status':0},
                                {'productId':6,'productName':'展会','productStatusId':0,'status':0}   
                            ]
                        },
                    },                                                     
 
                    feedback_list:[],                                                   //回访记录列表
                    province:citys,                                                     //当前省份数据                                       
                    citys:[],                                                          //当前城市数据                                       
                    districts:[],                                                       //当前地区数据    

                    get_opt:{                                                           //回访信息参数
                        contactId:'',
                        page:1,
                        size:10
                    },                         
                    is_first:true,
                    def:{
                        is_set_checkbox:false,
                        trees_data:{},
                        tags:{},
                        select_data:{
                            customer_origin:[]
                        },
                    },
                
                }
            },
            computed:{
                new_result:{
                    get:function(){
                        var val=this.service_tag.results[this.visit.contact_type][0].id || '';
                        this.visit.result=val;
                        return val;
                    },
                    set: function (newValue) {
                        this.visit.result=newValue;
                    }
                }
            },   
            methods:{
                getUserData:function(){                                                          //请求客户信息
                    var self=this;
                    console.time('加载客户信息');
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/customer/info',
                        data:{id:self.location_obj.id},
                        success:function(data){
                            if(data && data.data){
                                console.timeEnd('加载客户信息');
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
                getServiceInfo:function(){                                                          //请求客服详情
                    var self=this;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/tag/feedbselects',
                        // url:def.ajax_port+'/api/tag/feedbmulselects',
                        data:{'id':'','type':'1'},
                        success:function(data){
                            if(data && data.data){
                                // self.customer_info=data.data.customerInfo || {};

                                
                            }else{
                                msg.msg({'txt':'未请求到数据'},def.msg_time);
                            }
                        }
                    });
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/tag/feedbmulselects',
                        // url:def.ajax_port+'/api/tag/feedbmulselects',
                        data:{'id':'','type':'0'},
                        success:function(data){
                            if(data && data.data){
                                // self.customer_info=data.data.customerInfo || {};

                                
                            }else{
                                msg.msg({'txt':'未请求到数据'},def.msg_time);
                            }
                        }
                    });
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
                                    var ndata=data.data;
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

                    // this.def.tags.attention=JSON.stringify(this.service_info.attention) || '[]';
                    
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
                        // url:def.ajax_port+'/api/tag/selects',
                        url:def.ajax_port+'/api/tag/selects/detail',
                        // data:{type:0,id:self.location_obj.id},
                        data:{type:0,id:self.location_obj.id,typeids:'tag00020'},
                        success:function(data){
                            var ndata=data.data || [];
                            self.def.select_data.customer_origin=ndata[0].children || [];
                        }
                    });

                    self.getServiceInfo();

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
                setPage:function(count){                                                        //设置分页
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
                getTabData:function(opt){                                                                //请求tab数据
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
                changeContactUser:function(){                                                           //切换服务对象
                    var self=this;
                    var now_contact=self.setCheckbox(self.contact_list,self.visit.contactId) || {};
                    self.visit.mobile=now_contact.mobile!=undefined?now_contact.mobile:'';
                },
                checkFunc:function(e,index){                                                            //选择多产品数据
                    var tag=e.target,is_checked=tag.checked;
                    this.service_tag.contact_tags.products_origin[index]['status']=is_checked==true?1:0;
                },
               
                // 保存资料
                saveMaterial:function(){
                    var return_data={
                        id:this.location_obj.id
                    };
                    this.setObj(this.customer_info,return_data,['accountName','companyName','id','email','bank','province','city','district','address','phone']);

                    var ids=[],narr=[];
                    for(var key in this.def.tags){
                        if(key=='tradeType'){
                            if(this.def.tags[key]!=''){
                                ids.push({
                                    id:this.def.tags[key],
                                    tagId:'tag00010'
                                })
                            }
                        }else if(key=='attention'){

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
                        type:'post',
                        data:return_data,
                        success:function(data){
                            msg.msg({'txt':'保存成功！'},def.msg_time);
                            def.loading_ele.fadeOut(400);
                        },
                        error:function(){
                            def.loading_ele.fadeOut(400);
                        }
                    });
                },   
                
                visitRecord:function(){                                                                 //保存回访记录
                    var self=this;
                    var return_data={
                        customerId:self.location_obj.id,
                        contactId:self.visit.contactId,
                        productParams:[],
                        customerTags:[],
                        contactTags:[]
                    };
                    
                    if(self.visit.remark!='' && self.visit.remark!=null && self.visit.remark!=undefined){
                        return_data.remark=self.visit.remark
                    }
                    if(self.visit.attention!='' && self.visit.attention!=null && self.visit.attention!=undefined){
                        return_data.attention=self.visit.attention
                    }

                    if(self.visit.contactId=='' || self.visit.contactId==null || self.visit.contactId==undefined){
                        msg.msg({'txt':'请选择服务对象'},def.msg_time);
                        return;
                    }else if(self.visit.serviceWay=='' || self.visit.serviceWay==null || self.visit.serviceWay==undefined){
                        msg.msg({'txt':'请选择服务方式'},def.msg_time);
                        return;
                    }else if(self.visit.impress=='' || self.visit.impress==null || self.visit.impress==undefined){
                        msg.msg({'txt':'请选择用户印象'},def.msg_time);
                        return;
                    }
     
                    var contact_checked_ids=[];
                    $('.js-feedback-select').each(function(){
                        var tag_id=$(this).attr('data-id');
                        var id=$(this).val();
                        if(id!='' && id!=null && id!=undefined){
                            contact_checked_ids.push({
                                id:$(this).val(),
                                tagId:tag_id
                            })
                        }
                    });
                    return_data.contactTags=contact_checked_ids;
                    // 多产品
                    var product_params=[];
                    self.service_tag.contact_tags.products_origin.forEach(function(item){
                        product_params.push({
  
                            productId:item.productId,
                            productStatusId:item.productStatusId,
                            status:item.status!=undefined?item.status:0
                        })
                    });
                    return_data.productParams=product_params;



                    // 服务详情
                    var customer_checked_ids=[];
                    $('.js-feedback-check1').each(function(){
                        var pid=$(this).attr('data-id');
                        var is_checked=this.checked;
                        if(is_checked==true){
                            $(this).parents('.js-checked-section').find('.js-feedback-check2').each(function(){
                                var this_checked=this.checked;
                                var id=$(this).attr('data-id');
                                if(this_checked==true){
                                    customer_checked_ids.push({'id':id,'tagId':pid});
                                }
                            });
                            $(this).parents('.js-checked-section').find('.js-service-select').each(function(){
                                var val=$(this).val() || '';
                                var id=$(this).attr('data-id');
                                if(val!=''){
                                    customer_checked_ids.push({'id':val,'tagId':id});
                                }
                            });
                        }
                    });
                    if(self.def.tags.attention!=undefined && JSON.parse(self.def.tags.attention).length>0){
                        customer_checked_ids=customer_checked_ids.concat(JSON.parse(self.def.tags.attention));
                    }
                    return_data.customerTags=customer_checked_ids;
                    
                    console.log(return_data);
                   
                    def.loading_ele.fadeIn(200);
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/feedBack/add',
                        type:'post',
                        data:return_data,
                        success:function(data){
                            msg.msg({'txt':'保存成功！'},function(){
                                window.location.reload(true);
                            },def.msg_time);
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
                bindFunc:function(){                                                        //事件绑定
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
        
                    // 监听选择事件
                    $('.service-section').on('change','.js-feedback-check2',function(){
                        var _ischeck=$(this).parents('.js-checked-section').find('.js-feedback-check2');
                        if(_ischeck.is(':checked')){
                            $(this).parents('.js-checked-section').find('.js-feedback-check1').prop('checked',true);
                        }else{
                            $(this).parents('.js-checked-section').find('.js-feedback-check1').prop('checked',false);
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
                },
            },
            mounted:function(){
                this.getUserData();
                this.getCheckboxData();
                this.bindFunc();
                this.get_opt.customerId=this.location_obj.id;
                this.getFeedbackData(this.get_opt);
            }
        }); 
    });
})


      