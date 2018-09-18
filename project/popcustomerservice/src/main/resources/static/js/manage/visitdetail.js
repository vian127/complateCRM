/*
    #author     gaofeng
    #date       2018/07/24
    #purpose    回访详情页 
*/
require.config({
    paths: {
      'easy-checkbox':'common/easy-checkbox'
    },
   
    shim: {
      
    }
  });

require(['vue', 'msg', 'general','base-info','easy-checkbox','layui'], function (Vue, msg, general,global_info,easy_checkbox) {
    $(function () {
        var def = {
            loading_ele: $('.js-loading-div'),
            ajax_port: global_info.api_url
        };

        var vm = new Vue({
            el: '#app',
            data() {
                return {
                    get_opt: {},
                    location_obj: general.fn.getLocationParameter(),
                    feedback_info:{},
                    manage_info:{},
                    service_info:{                                                      //服务信息和多产品数据    
                        impression:{},
                        products:[]
                    },
                    visit:{                                                            //联络数据
                        contact_type:'feedbtagval0000000053',
                        remark:'',
                        invoice:'',
                        login:'',
                        introduce:'',
                        result:1
                    },
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
                    },                                                     
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
            mounted() {
                this.getRecordData({id:this.location_obj.id})
                this.getCheckboxData();
                this.bindFunc();
            },
            methods: {
                getRecordData: function (opt) {                                     //回访详情数据
                    var self = this;
                    general.fn.subAjax({
                        url: def.ajax_port+'/api/feedBack/info',
                        data: opt,
                        success:function(data){
                            console.log(data)
                            if(data && data.data){
                                self.feedback_info=data.data.feedBackInfo || {};
                                self.manage_info=data.data.manage || {};
                              if(self.feedback_info.serviceInfo!=undefined){
                                self.service_info.impression=self.feedback_info.serviceInfo.impression || {};
                                self.service_info.products=self.feedback_info.serviceInfo.products || [];
                              }  
                              
                                self.setCheckboxAll();
                                self.feedBackChecked();

                            }else{
                                msg.msg({'txt':'未请求到数据'},def.msg_time);
                            }
                            def.loading_ele.fadeOut(400);
                        },
                        error:function(){
                            def.loading_ele.fadeOut(400);
                        }
                    })  
                },
                getCheckboxData:function(){                                                             //获取选项数据
                    var self=this,d=self.def;
                    general.fn.subAjax({
                        // url:def.ajax_port+'/api/tag/mulselects',
                        url:def.ajax_port+'/api/tag/mulselects/detail',
                        data:{type:0,id:self.location_obj.id,typeids:'tag00014'},
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
                getServiceInfo:function(){                                                          //请求客服联络信息
                    var self=this;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/tag/feedbselects',
                        // url:def.ajax_port+'/api/tag/feedbmulselects',
                        data:{'id':'','type':1},
                        success:function(data){
                            if(data && data.data){
                                // self.customer_info=data.data.customerInfo || {};

                                
                            }else{
                                msg.msg({'txt':'未请求到数据'},def.msg_time);
                            }
                        }
                    });
                },
                setCheckboxAll:function(){                                              //设置服务详情选中
                    var self=this;
                    $('.js-checked-section .js-feedback-check2').each(function(){
                        var id=$(this).attr('data-id');
                        if(self.feedback_info.login.indexOf(id)!=-1){
                            $(this).prop('checked','true');
                        }
                        if(self.feedback_info.feedback.indexOf(id)!=-1){
                            $(this).prop('checked','true');
                        }
                        if(self.feedback_info.invoice.indexOf(id)!=-1){
                            $(this).prop('checked','true');
                        }
                        if(self.feedback_info.webService.indexOf(id)!=-1){     
                            $(this).prop('checked','true');
                        }
                        if(self.feedback_info.complimentary.indexOf(id)!=-1){
                            $(this).prop('checked','true');
                        }
                    });
                    $('.js-checked-section .js-service-select').each(function(){
                        var id=$(this).attr('data-id');
                        if(self.feedback_info.invoice!=''){                                             //发票项
                            if(id=='feedbtag00002'){
                                $(this).find('option').each(function(){
                                    var key=$(this).val();
                                    if(self.feedback_info.invoice.indexOf(key)!=-1){
                                        self.visit.invoice=key;
                                    }
                                });
                                if(self.visit.invoice=='feedbtagval0000000006' || self.visit.invoice=='feedbtagval0000000007'){
                                    self.service_tag.cutomer_tags.invoice[self.visit.invoice].forEach(function(item){
                                        if(self.feedback_info.invoice.indexOf(item.id)!=-1){
                                            item.is_checked=true;
                                        }
                                    })
                                }
                            }  
                        }
                        if(self.feedback_info.webService!=''){                                          //网站服务项
                            if(id=='feedbtag00005'){
                                var pid=$(this).parents().siblings().children('.js-feedback-check2').attr('data-id');
                                if(pid=='feedbtagval0000000031'){
                                    $(this).find('option').each(function(){
                                        var key=$(this).val();
                                        if(self.feedback_info.webService.indexOf(key)!=-1){
                                            self.visit.login=key;
                                        }
                                    })
                                }
                                if(pid=='feedbtagval0000000032'){
                                    $(this).find('option').each(function(){
                                        var key=$(this).val();
                                        if(self.feedback_info.webService.indexOf(key)!=-1){
                                            self.visit.introduce=key;
                                        }
                                    })
                                }  
                            }
                        }
                    })
                },
                // 服务详情大类选中
                feedBackChecked:function(){
                   $('.js-feedback-check2').each(function(){
                        if($(this).is(':checked')){
                            $(this).parents('.js-checked-section').find('.js-feedback-check1').prop('checked',true)
                        }
                   })
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

                    $("input[type=checkbox]").each(function(){                                  //禁止checkbox
                        $(this).attr("disabled",true);
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
                }
            },
        })
    })
})