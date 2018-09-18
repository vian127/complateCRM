require.config({
    paths: {
        
    },

    shim: {

    }
});

require(['vue','msg','layui'], function (Vue,msg) {
    $(function () {
        var vm = new Vue({
            el: '#app',
            data() {
                return {
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
                    detail_info:{
                      is_name:'123',
                      is_company:'123',
                      is_linkman:'1',
                      is_position:'1',
                      is_role:'123',
                      is_status:'1',
                      is_phone:'123',
                      is_tel:'123',
                      is_ext:'123',
                      is_qq:'123',
                      is_wx:'123',
                      is_addwx:'1',
                      is_impression:'1',
                      is_attention:'123',
                      is_remark:'123',
                      is_apm:'ture',
                      is_hasapm:'1',
                      is_book:'true',
                      is_hasbook:'1',
                      is_ceo:'true',
                      is_hasceo:'1',
                      is_cloud:'true',
                      is_hascloud:'1',
                      is_seoul:'true',
                      is_hasseoul:'1',
                      is_exhibition:'true',
                      is_hasexhibition:'1',
                      is_source:'123',
                      is_creater:'123',
                      is_amend:'123',
                      is_lasttime:'123',
                      is_lastlink:'123',
                      is_order:'123',
                      msg:''
                    }
                  }
                },
                methods:{
                    saveFunc:function(e){
                        var data=this.detail_info;
                        data.btn_save=false;
                        var txt='';
                        if(data.is_name==''){
                            txt='用户不能为空';
                            data.msg=txt;
                            msg.msg({txt:data.msg},1000);
                            return;
                        }else if(data.is_company==''){
                            txt='所属客户不能为空！';
                            data.msg=txt;
                            msg.msg({txt:data.msg},1000);
                            return;
                        }else if(data.is_linkman==''){
                            txt='主联系人不能为空！';
                            data.msg=txt;
                            msg.msg({txt:data.msg},1000);
                            return;
                        }else if(data.is_position==''){
                            txt='公司职务不能为空！';
                            data.msg=txt;
                            msg.msg({txt:data.msg},1000);
                            return;
                        }else if(data.is_role==''){
                            txt='角色不能为空！';
                            data.msg=txt;
                            msg.msg({txt:data.msg},1000);
                            return;
                        }else if(data.is_status==''){
                            txt='客户状态不能为空！';
                            data.msg=txt;
                            msg.msg({txt:data.msg},1000);
                            return;
                        }else if(data.is_is_impression==''){
                            txt='客户印象不能为空！';
                            data.msg=txt;
                            msg.msg({txt:data.msg},1000);
                            return;
                        }
                        console.log(data)
                        msg.msg({txt:'保存成功'},1000);
                        setTimeout(function(){
                            // window.location.href='../../views/workbench/userdetail.html'
                        },1000)
                    },
                }
        })


        $('.open').on('click', function () {
            $(this).parent().next().toggle();
        })
        //  分页
        // 分页
        function page() {
            layui.use('laypage', function () {
                var laypage = layui.laypage;
                //执行一个laypage实例
                laypage.render({
                    elem: 'test1',
                    count: 50,
                    layout: ['prev', 'page', 'next', 'limit', 'count', 'skip'],
                    jump: function (obj) {
                        console.log(obj)
                        var curr = obj.curr;
                    }
                });
            });
        }
        page();
    })
})