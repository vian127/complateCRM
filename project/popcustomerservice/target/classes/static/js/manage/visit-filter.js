/*
    #author     lut000
    #date       2018/08/16
    #porpuse    用户高级筛选
*/
require.config({
    paths: {
        'easy-checkbox':'common/easy-checkbox',
    },
    shim: {
        
    }  
});

require(['vue','jquery','msg','general','layui','base-info','easy-checkbox'], function (Vue,jquery,msg,general,layui,global_info,easy_checkbox) {
    $(function () {
        var def={
            loading_ele:$('.js-loading-div'),
            ajax_port:global_info.api_url,
            msg_time:global_info.msg_time,
        };
        var vm = new Vue({
            el: '#visit_app',
            data:{
                is_set_date:false,
                collect:{
                    
                },
                def:{
                    is_set_checkbox:false,
                    trees_data:{},
                    tags:{},
                    select_trees:{
                      
                    }
                },
            },
            mounted:function(){
                layui.use('layer',function(){
                    var layer=layui.layer;
                    layer.config({
                        extend: '../../myskin/style.css', //加载您的扩展样式
                        skin: 'layer-page-ele'
                    })
                });
                this.getfilterData();
                this.bindFunc();
                window.global_filter_tags=this.def.tags;
            },
            methods:{
                getfilterData:function(){                                                             //获取选项数据
                    var self=this,d=self.def;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/tag/feedbselects',
                        data:{type:1,id:''},
                        success:function(data){
                            var ndata=data.data || [];
                            $('.js-filter-div').each(function(){
                                var key=$(this).attr('data-id');
                                var check_data=self.setCheckbox(ndata,key);
                                if(key=='feedbtag00007'){
                                    check_data={
                                        data:[
                                            {id:"feedbtagval0000000055",name:"完成"},
                                            {id:"feedbtagval0000000056",name:"跟进"},
                                            {id:"feedbtagval0000000057",name:"稍后联络"},
                                            {id:"feedbtagval0000000058",name:"无人接听"},
                                            {id:"feedbtagval0000000059",name:"空号/错号"}
                                        ]
                                    }
                                }
                                self.setCheckboxDom(check_data,$(this));
                            });
                            d.trees_data=ndata;
                        }
                    })
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/tag/feedbmulselects',
                        data:{type:0,id:''},
                        success:function(data){
                            if(data && data.data){
                                data.data.push({
                                    id:'feedbtag00008',
                                    name:'推荐项'
                                })
                                self.setCheckboxDom(data,$('.js-filter-serviceType'))
                            }
                        }
                    })
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
               
                bindFunc:function(){
                    var self=this,d=self.def,has_checked_id=[],has_checked_txt=[];
                    // 点击获取焦点
                    $('.visit-filter-box .js-checked-list').on('click',function(e){
                        var $self=$(this),tag_ele=$self.siblings('.js-filter-div');
                        $(".js-filter-div").hide();
                        tag_ele.show();
                        e.stopPropagation();
                    });

                    // checkbox选中事件处理
                    $('.visit-filter-box .js-filter-div').on('change','.js-trees-list>li>input',function(){
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
                    $('.visit-filter-box .js-filter-div').on('click',function(e){
                        e.stopPropagation();
                    });
                    $('.visit-filter-box').on('click',function(){
                        $('.js-filter-div').hide();
                    });
                  
                    
                    // 确定筛选项
                    $('.visit-filter-box .js-add-checked').on('click',function(){
                        var id=$(this).parents('.js-filter-div').attr('data-id') || '';
                        var tag=$(this).parent().siblings('.js-checkbox-container');
                        $(this).parents('.js-filter-div').hide();
                        has_checked_id=[];
                        has_checked_txt=[];
                        forTreeDom(tag);
                        setFilterDom($(this).parents('.js-filter-div').siblings('.js-checked-list'),has_checked_id,has_checked_txt);
                    });
                    // 取消筛选项
                    $('.visit-filter-box .js-cancel-checked').on('click',function(){
                        $(this).parents('.js-filter-div').hide();
                    });
                    // 收起子集
                    $('.visit-filter-box .js-filter-div').on('click','.js-trees-list>li>span',function(){
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
                                    has_checked_id.push({id:id,value:txt});
                                    has_checked_txt.push(txt);
                                }
                                forTreeDom($(this));
                            }else{
                                if(is_checked){
                                    has_checked_id.push({id:id,value:txt});
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
                        d.tags[key]=id_arr;
                        // console.log(id_arr)
                        // self.collect[key]=id_arr;
                        // tag.attr('data-checkid',JSON.stringify(id_arr));
                    };
                }
            }
        });

    })
})