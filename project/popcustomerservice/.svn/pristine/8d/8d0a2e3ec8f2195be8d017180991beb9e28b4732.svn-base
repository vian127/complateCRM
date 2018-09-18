/*
    #author     gaofeng
    #date       2018/07/23
    #purpose    批次短信
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
                message_count:{                          //发送信息数量对象
                    surplus:1222,
                    send:333,
                    receive:666
                }
                },
                methods:{
                    page:function(){
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
                  this.page();
                }
            })
          })
  })