/*
    #author     gaofeng
    #date       2018/07/25
    #purpose    问卷管理
*/

require(['vue', 'msg', 'layui'], function (Vue, msg) {
    $(function () {
        var def = {
            loading_ele: $('.js-loading-div')
        };
        def.loading_ele.fadeOut(400);
        
        var vm = new Vue({
            el: '#app',
            data:{
                taskTh:[
                    {id:3,is_show:true,name:'问卷名称'},
                    {id:4,is_show:true,name:'状态'},
                    {id:5,is_show:true,name:'完成数量'},
                    {id:6,is_show:true,name:'创建时间'},
                    {id:7,is_show:true,name:'创建人'},
                    {id:8,is_show:true,name:'最后修改时间'},
                    {id:9,is_show:true,name:'最后修改人'},
                ],
                taskTb:[
                    {id:1,title:'回访调查',status:'启用',num:'999',creattime:'2018-12-12 12:12:00',creater:'客服A',amendtime:'2018-12-12 12:12:00',amender:'张三'},
                    {id:2,title:'回访调查',status:'启用',num:'999',creattime:'2018-12-12 12:12:00',creater:'客服A',amendtime:'2018-12-12 12:12:00',amender:'张三'},
                    {id:3,title:'回访调查',status:'启用',num:'999',creattime:'2018-12-12 12:12:00',creater:'客服A',amendtime:'2018-12-12 12:12:00',amender:'张三'},
                    {id:4,title:'回访调查',status:'启用',num:'999',creattime:'2018-12-12 12:12:00',creater:'客服A',amendtime:'2018-12-12 12:12:00',amender:'张三'},
                    {id:5,title:'回访调查',status:'启用',num:'999',creattime:'2018-12-12 12:12:00',creater:'客服A',amendtime:'2018-12-12 12:12:00',amender:'张三'},
                    {id:6,title:'回访调查',status:'启用',num:'999',creattime:'2018-12-12 12:12:00',creater:'客服A',amendtime:'2018-12-12 12:12:00',amender:'张三'},
                    {id:7,title:'回访调查',status:'启用',num:'999',creattime:'2018-12-12 12:12:00',creater:'客服A',amendtime:'2018-12-12 12:12:00',amender:'张三'},
                ],
                taskFilter:{
                    title:'',
                    status:1,
                    creater:'',
                },
                list_info:{
                    is_show_select:false,
                    checked_all:true
                }
               
            },
            mounted() {
                this.page();
            },
            methods: {
                toggleSelect: function () {                             //显示隐藏
                    this.list_info.is_show_select = !this.list_info.is_show_select;
                },
                changeCol: function (event, id) {                       //单选
                    var tag = event.target;
                    var is_check = tag.checked;
                    if (is_check == true) {
                        $('.js-list-table').find('.js-col' + id + '-ele').show();
                    } else {
                        $('.js-list-table').find('.js-col' + id + '-ele').hide();
                    }
                    var checked_len = 0;
                    this.taskTh.forEach(function (item) {
                        if (id == item.id) {
                            item.is_show = is_check;
                        }
                        item.is_show == true ? checked_len++ : checked_len;
                    });

                    // 全选判断
                    if (is_check == true) {
                        if (this.list_info.checked_all == false && checked_len == this.taskTh.length) {
                            this.list_info.checked_all = true;
                        }
                    } else {
                        if (checked_len == this.taskTh.length - 1 && this.list_info.checked_all == true) {
                            this.list_info.checked_all = false;
                        }
                    }
                },
                changeAll: function (e) {                                  //全选
                    var tag = e.target;
                    var is_check = tag.checked;
                    if (is_check == true) {
                        $('.js-list-table').find('.js-can-hide').show();
                        this.taskTh.forEach(item => item.is_show = true);
                    } else {
                        $('.js-list-table').find('.js-can-hide').hide();
                        this.taskTh.forEach(item => item.is_show = false);
                    }
                },
                saveSelect: function () {                                 //确认提交选择
                    this.toggleSelect();
                },
                multipleFunc:function(){
                    alert(333)
                },
                filterFunc: function () {                                //确认筛选列表
                    console.log(this.taskFilter);
                    $('form')[0].reset();
                },
                page: function () {                                      //分页
                    layui.use('laypage', function () {
                        var laypage = layui.laypage;
                        //执行一个laypage实例
                        laypage.render({
                            elem: 'laypage-section',
                            count: 50,
                            layout: ['prev', 'page', 'next', 'limit', 'count', 'skip'],
                            jump: function (obj) {
                                console.log(obj)
                                var curr = obj.curr;
                            }
                        });
                    });
                },
            },
        })
    })
})