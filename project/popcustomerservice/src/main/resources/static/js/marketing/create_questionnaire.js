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
                taskTb:[
                    {id:1,title:'擅长风格',types:'单选,多选',option:'是,否',required:'是',explain:'是否接受回访调研'},
                    {id:2,title:'擅长风格',types:'单选,多选',option:'是,否',required:'是',explain:'是否接受回访调研'},
                    {id:3,title:'擅长风格',types:'单选,多选',option:'是,否',required:'是',explain:'是否接受回访调研'},
                    {id:4,title:'擅长风格',types:'单选,多选',option:'是,否',required:'是',explain:'是否接受回访调研'},
                    {id:5,title:'擅长风格',types:'单选,多选',option:'是,否',required:'是',explain:'是否接受回访调研'},
                    {id:6,title:'擅长风格',types:'单选,多选',option:'是,否',required:'是',explain:'是否接受回访调研'},
                    {id:7,title:'擅长风格',types:'单选,多选',option:'是,否',required:'是',explain:'是否接受回访调研'},
                ],
                taskFilter:{
                    title:'',
                    status:1,
                    creater:'',
                },
            },
            mounted() {
                this.page();
            },
            methods: {
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