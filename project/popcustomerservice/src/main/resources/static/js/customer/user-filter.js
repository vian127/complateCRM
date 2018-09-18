/*
    #author     lut000
    #date       2018/08/16
    #porpuse    用户高级筛选
*/
require.config({
    paths: {
        
    },
    shim: {
        
    }
});






define(['vue','jquery','msg','general','layui','base-info','easy-checkbox'], function (Vue,jquery,msg,general,layui,global_info,easy_checkbox) {
    var def={
        loading_ele:$('.js-loading-div'),
        ajax_port:global_info.api_url,
        msg_time:global_info.msg_time,
    };
    var vm = new Vue({
        el: '#filter-app',
        data:{
            collect:{
                status:'',
                main:'',
            },
            user_info:{
                status:[]
            },
            is_set_date:false,
        },
        mounted:function(){
            layui.use('layer',function(){
                var layer=layui.layer;
                layer.config({
                    extend: '../../myskin/style.css', //加载您的扩展样式
                    skin: 'layer-page-ele'
                })
            });
            this.getNewData();
            this.bindFunc();
            this.setDateFunc();
        },
        methods:{
            getNewData:function(opt){                                                        //获取列表
                var self=this;
                general.fn.subAjax({
                    // url:def.ajax_port+'/api/tag/mulselects',
                    url:def.ajax_port+'/api/tag/mulselects/detail',
                    data:{type:1,id:'',typeids:'tag00018'},
                    success:function(data){
                        var ndata=data.data || [];
                        
                        $('.js-user-filter-box .js-filter-div').each(function(){
                            var key=$(this).attr('data-id');
                            
                            var check_data=self.setCheckbox(ndata,key);
                            self.setCheckboxDom(check_data,$(this));
                        });
                    }
                });

                general.fn.subAjax({
                    url:def.ajax_port+'/api/tag/selects/detail',
                    data:{type:1,id:'',typeids:'tag00012'},
                    success:function(data){
                        var ndata=data.data || [];
                        
                        self.user_info.status=ndata[0].children || [];
                        // self.def.select_data.customer_origin=ndata;
                    }
                });
            },
            resetFilter:function(){                                                 //重置弹层内容
                for(var key in this.collect){
                    this.collect[key]='';
                }
                $('#filter-app input').prop('checked',false);
                $('#filter-app .js-checked-list').text('请选择角色')
            },
            setCheckbox:function(data,key){                                            //取到复选框数据
                var return_data=null;
                for(var i=0,len=data.length;i<len;i++){
                    if(data[i]['id']==key){
                        return_data=data[i];
                        break;
                    }
                }
                return return_data;
            },
            setCheckboxDom:function(data,tag){                                         //生成checkbox的dom
                if(data!=null){
                    easy_checkbox.init({
                        data:data,
                        tag:tag.children('.js-checkbox-container').eq(0)[0],
                        ele:tag.siblings('.js-checked-list').eq(0)[0]
                    });
                }
            },
            setDateFunc:function(){                                                     //设置高级筛选时间
                var self=this;
                if(self.is_set_date==false){
                    layui.use('laydate', function(){
                        var laydate = layui.laydate;
                        laydate.render({
                            elem: '.js-date-area1',
                            done:function(val){
                                self.collect.startContactTime=val;
                            }
                        });
                        laydate.render({
                            elem: '.js-date-area2',
                            done:function(val){
                                self.collect.endContactTime=val;
                            }
                        });
                    });
                }
            },
            bindFunc:function(){
                var self=this,d=self.def,has_checked_id=[],has_checked_txt=[];
                // 点击获取焦点
                $('.js-user-filter-box .js-checked-list').on('click',function(e){
                    var $self=$(this),tag_ele=$self.siblings('.js-filter-div');
                    $(".js-filter-div").hide();
                    tag_ele.show();
                    e.stopPropagation();
                });

                // checkbox选中事件处理
                $('.js-user-filter-box .js-filter-div').on('change','.js-trees-list>li>input',function(){
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
                    }else{
                        if($self.parent().parent().parent('li')){
                            $self.parent().parent().parent('li').children('input').prop('checked',false);
                        }
                    }
                });
                // 隐藏下拉选择层
                $('.js-user-filter-box .js-filter-div').on('click',function(e){
                    e.stopPropagation();
                });
                $('.js-user-filter-box').on('click',function(){
                    $('.js-filter-div').hide();
                });
                
                
                // 确定筛选项    
                $('.js-user-filter-box .js-add-checked').on('click',function(){
                    var id=$(this).parents('.js-filter-div').attr('data-id') || '';
                    var tag=$(this).parent().siblings('.js-checkbox-container');
                    $(this).parents('.js-filter-div').hide();
                    has_checked_id=[];
                    has_checked_txt=[];
                    forTreeDom(tag);
                    setFilterDom($(this).parents('.js-filter-div').siblings('.js-checked-list'),has_checked_id,has_checked_txt);
                });
                // 取消筛选项
                $('.js-user-filter-box .js-cancel-checked').on('click',function(){
                    $(this).parents('.js-filter-div').hide();
                });
                // 收起子集
                $('.js-user-filter-box .js-filter-div').on('click','.js-trees-list>li>span',function(){
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
                                has_checked_id.push(id);
                                has_checked_txt.push(txt);
                            }
                            forTreeDom($(this));
                        }else{
                            if(is_checked){
                                has_checked_id.push(id);
                                has_checked_txt.push(txt);
                            }
                        }
                    });
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
                    // tag.attr('data-checkid',JSON.stringify(id_arr));
                    self.collect[key]=id_arr.join(',');
                };
            }
        }
    });
    return vm
})