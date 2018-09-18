/*
    #author     lut000
    #date       2017/07/16
    #porpuse    任务类型列表
*/
require(['vue','layui'], function (Vue,layui) {
    $(function () {
        var vm = new Vue({
            el: '#app',
            data:{
                list:[
                    {id: 1,check: '编辑',name: '调查问卷1',status: '启用',stime: '2018-6-6',etime: '2018-9-1',creator:'lut000',editor:'lut000'},
                    {id: 2,check: '编辑',name: '调查问卷1',status: '启用',stime: '2018-6-6',etime: '2018-9-1',creator:'lut000',editor:'lut000'},
                    {id: 3,check: '编辑',name: '调查问卷1',status: '启用',stime: '2018-6-6',etime: '2018-9-1',creator:'lut000',editor:'lut000'},
                    {id: 4,check: '编辑',name: '调查问卷1',status: '启用',stime: '2018-6-6',etime: '2018-9-1',creator:'lut000',editor:'lut000'},
                    {id: 5,check: '编辑',name: '调查问卷1',status: '启用',stime: '2018-6-6',etime: '2018-9-1',creator:'lut000',editor:'lut000'},
                    {id: 6,check: '编辑',name: '调查问卷1',status: '启用',stime: '2018-6-6',etime: '2018-9-1',creator:'lut000',editor:'lut000'},
                ],
                thead:[{name:'任务类型',id:3,is_show:true},
                       {name:'状态',id:4,is_show:true},
                       {name:'创建时间',id:5,is_show:true},
                       {name:'创建人',id:6,is_show:true},
                       {name:'最后修改时间',id:7,is_show:true},
                       {name:'最后修改人',id:8,is_show:true}],
                collect:{
                    name:'',
                    status:1
                },
                list_info:{
                    is_show_select:false,
                    checked_all:true
                }
            },
            methods:{
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
                    console.log(this.collect);
                }
            }
        });

        // 分页
        function page(){
            layui.use('laypage', function(){
                var laypage = layui.laypage;
                //执行一个laypage实例
                laypage.render({
                    elem: 'laypage-section'
                    ,count: 50
                    ,layout: [ 'prev', 'page', 'next','limit','count', 'skip']
                    ,jump: getNewData
                });
            });
        }
        page();

        function getNewData(obj){
            console.log(obj);

        };

    })
})