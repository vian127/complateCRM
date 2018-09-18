require.config({
    paths: {
     
    },

    shim: {

    }
  });
  
  require(['vue'], function (Vue) {
    $(function () {
        var vm = new Vue({
            el: '#app',
            data:{
                list:[
                      {id: 1,account:'dfsafgsf',stage: '主账号',phone: '42232323',unline: '5',register:'021-344545345',lastlogin:'2018-01-01 12:00:15',code:'111'},
                      {id: 1,account:'dfsafgsf',stage: '主账号',phone: '42232323',unline: '5',register:'021-344545345',lastlogin:'2018-01-01 12:00:15',code:'111'},
                    ],
                record:[
                    {id:1,created:'2017-01-16 14:10:20',session:'张三',tel:'13875875687',selation:'来电',stage:'有效',result:'成功',impress:'较好',content:'网站的推荐',detail:'法撒旦',contact:'钉钉'},
                    {id:2,created:'2017-01-16 14:10:20',session:'张三',tel:'13875875687',selation:'来电',stage:'有效',result:'成功',impress:'较好',content:'网站的推荐',detail:'法撒旦',contact:'钉钉'},
                    {id:3,created:'2017-01-16 14:10:20',session:'张三',tel:'13875875687',selation:'来电',stage:'有效',result:'成功',impress:'较好',content:'网站的推荐',detail:'法撒旦',contact:'钉钉'},
                    {id:4,created:'2017-01-16 14:10:20',session:'张三',tel:'13875875687',selation:'来电',stage:'有效',result:'成功',impress:'较好',content:'网站的推荐',detail:'法撒旦',contact:'钉钉'},
                    {id:5,created:'2017-01-16 14:10:20',session:'张三',tel:'13875875687',selation:'来电',stage:'有效',result:'成功',impress:'较好',content:'网站的推荐',detail:'法撒旦',contact:'钉钉'},
                    {id:6,created:'2017-01-16 14:10:20',session:'张三',tel:'13875875687',selation:'来电',stage:'有效',result:'成功',impress:'较好',content:'网站的推荐',detail:'法撒旦',contact:'钉钉'},
                    {id:7,created:'2017-01-16 14:10:20',session:'张三',tel:'13875875687',selation:'来电',stage:'有效',result:'成功',impress:'较好',content:'网站的推荐',detail:'法撒旦',contact:'钉钉'},
                    {id:8,created:'2017-01-16 14:10:20',session:'张三',tel:'13875875687',selation:'来电',stage:'有效',result:'成功',impress:'较好',content:'网站的推荐',detail:'法撒旦',contact:'钉钉'}
                ], 
                }
             })


             $('.open').on('click',function(){
                 $(this).parent().next().toggle();
             })
            //  分页
              // 分页
        function page(){
            layui.use('laypage', function(){
                var laypage = layui.laypage;
                //执行一个laypage实例
                laypage.render({
                    elem: 'test1'
                    ,count: 50
                    ,layout: [ 'prev', 'page', 'next','limit','count', 'skip']
                    ,jump: function(obj){
                      console.log(obj)
                      var curr = obj.curr;

                    }
                });
            });
        }
       page();
        })  
    })

       