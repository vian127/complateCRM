/*
    #author     gaofeng
    #date       2018/07/18
    #purpose    新增任务客户页
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
                    {id:3,is_show:true,name:'主账号'},
                    {id:4,is_show:true,name:'公司名称'},
                    {id:5,is_show:true,name:'未回访天数'},
                    {id:6,is_show:true,name:'未登录天数'},
                    {id:7,is_show:true,name:'领用人'},
                    {id:8,is_show:true,name:'领用时间'}
                ],
                taskTb:[
                    {id:1,account:'skyblue',company:'上海服装服务有限公司',visit:'5',login:'5',receive:'6',time:'2018-12-12 12:12:12'},
                    {id:2,account:'skyblue',company:'上海服装服务有限公司',visit:'5',login:'5',receive:'6',time:'2018-12-12 12:12:12'},
                    {id:3,account:'skyblue',company:'上海服装服务有限公司',visit:'5',login:'5',receive:'6',time:'2018-12-12 12:12:12'},
                    {id:4,account:'skyblue',company:'上海服装服务有限公司',visit:'5',login:'5',receive:'6',time:'2018-12-12 12:12:12'},
                    {id:5,account:'skyblue',company:'上海服装服务有限公司',visit:'5',login:'5',receive:'6',time:'2018-12-12 12:12:12'},
                    {id:6,account:'skyblue',company:'上海服装服务有限公司',visit:'5',login:'5',receive:'6',time:'2018-12-12 12:12:12'},
                    {id:7,account:'skyblue',company:'上海服装服务有限公司',visit:'5',login:'5',receive:'6',time:'2018-12-12 12:12:12'},
                ],
                taskFilter:{
                    title:'客服',
                    type:'1',
                    timeStart:'2017-12-11',
                    timeEnd:'2017-12-12',
                    limitStart:'2018-01-01',
                    limitEnd:'2018-02-02',
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
                    console.log(this.thead);
                    this.toggleSelect();
                },

                filterFunc: function () {                                //确认筛选列表
                    console.log(this.collect);
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