/*
    #author     gaofeng
    #date       2018/07/23
    #purpose   收件箱
*/

require(['vue', 'msg', 'layui'], function (Vue, msg) {
    $(function () {
        var def = {
            loading_ele: $('.js-loading-div')
        };
        def.loading_ele.fadeOut(400);
        
        var vm = new Vue({
            el: '#app',
            data() {
              return {
                    list_data:[],                                       //页面当前数据
                    receiveCount:null,                                  //接收数量            
                    collect:{                                           //筛选数据
                        tel:'',
                    }
                  }
                },
                methods:{
                    getData:function(){
                        this.list_data=[
                            {id:1,tel:'13667898899',receivetime:'2018-12-12 12:12:00',content:'世界那么大我想出去走走'},
                            {id:2,tel:'13667898899',receivetime:'2018-12-12 12:12:00',content:'世界那么大我想出去走走'},
                            {id:3,tel:'13667898899',receivetime:'2018-12-12 12:12:00',content:'世界那么大我想出去走走'},
                            {id:4,tel:'13667898899',receivetime:'2018-12-12 12:12:00',content:'世界那么大我想出去走走'},
                            {id:5,tel:'13667898899',receivetime:'2018-12-12 12:12:00',content:'世界那么大我想出去走走'},
                            {id:6,tel:'13667898899',receivetime:'2018-12-12 12:12:00',content:'世界那么大我想出去走走'},
                            {id:7,tel:'13667898899',receivetime:'2018-12-12 12:12:00',content:'世界那么大我想出去走走'},
                        ]
                        this.receiveCount=111;
                    },
                    filterFunc:function(){                            //确认筛选                      
                        console.log(this.collect)
                    },
                    page:function(){                                  //分页
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
                mounted(){
                  this.getData();
                  this.page();
                }
            })
          })
  })