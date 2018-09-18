require.config({
  paths: {
    'ztree-core':'lib/ztree/jquery.ztree.core.min',
    'ztree-excheck':'lib/ztree/jquery.ztree.excheck.min',
    'ztree-exhide':'lib/ztree/jquery.ztree.exhide.min',
  },

  shim: {
    'ztree-excheck':{
      deps:['css!lib/ztree/zTreeStyle.css','jquery','ztree-core']
    },
    'ztree-exhide':{
      deps:['jquery','ztree-core']
    }
  }
});
  
require(['vue','ztree-excheck','ztree-exhide'], function (Vue) {
  $(function () {
      var vm = new Vue({
          el: '#app',
          data:{
              list:[
                    {id: 1,name:'张天一',role: '决策者,领导者',position: '总经理',status: '在职',mobile: '138883228323',telephone:'021-344545345',wx:'232545545',judge:'是',ext:'111',qq:'4546546456',email:'22222@qq.com',source:'注册'},
                    {id: 2,name:'张天一',role: '决策者',position: '总经理',status: '在职',mobile: '1233312',telephone:'021-344545345',wx:'232545545',judge:'是',ext:'111',qq:'4546546456',email:'22222@qq.com',source:'注册'},
                    {id: 3,name:'张天一',role: '决策者',position: '总经理',status: '在职',mobile: '1233312',telephone:'021-344545345',wx:'232545545',judge:'是',ext:'111',qq:'4546546456',email:'22222@qq.com',source:'注册'},
                    {id: 4,name:'张天一',role: '决策者',position: '总经理',status: '在职',mobile: '1233312',telephone:'021-344545345',wx:'232545545',judge:'是',ext:'111',qq:'4546546456',email:'22222@qq.com',source:'注册'},
                    {id: 5,name:'张天一',role: '决策者',position: '总经理',status: '在职',mobile: '1233312',telephone:'021-344545345',wx:'232545545',judge:'是',ext:'111',qq:'4546546456',email:'22222@qq.com',source:'注册'},
                    {id: 6,name:'张天一',role: '决策者',position: '总经理',status: '在职',mobile: '1233312',telephone:'021-344545345',wx:'232545545',judge:'是',ext:'111',qq:'4546546456',email:'22222@qq.com',source:'注册'},
                    {id: 7,name:'张天一',role: '决策者',position: '总经理',status: '在职',mobile: '1233312',telephone:'021-344545345',wx:'232545545',judge:'是',ext:'111',qq:'4546546456',email:'22222@qq.com',source:'注册'},
                    {id: 8,name:'张天一',role: '决策者',position: '总经理',status: '在职',mobile: '1233312',telephone:'021-344545345',wx:'232545545',judge:'是',ext:'111',qq:'4546546456',email:'22222@qq.com',source:'注册'}
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

                datas:{
                  pro:[
                    {id:1,name:'上海'},
                    {id:2,name:'北京'},
                    {id:3,name:'广州'},
                    {id:4,name:'深圳'}
                  ],
                  city:[
                    {id:1,name:'黄石'},
                    {id:2,name:'武汉'},
                    {id:3,name:'随州'},
                    {id:4,name:'黄冈'}
                  ]
                },
               
              material:{
                    account:'333',
                    id:'33333333',
                    brand:'sdff',
                    company:'33',  
                    email:'5555',
                    pro:'1',
                    city:'1',
                    district:'',
                    addr:'1',
                    telephone:'',
                    genre:'1',

                    trade:'1',
                    sex:'1',
                    pattern:'1',
                    single:'1',
                    season:'1',
                    texture:'1',
                    craft:'1',
                    stage:'1',
                    state:'1', 
                    invoice:'1',
                    limit:'',
              }
            },
            methods:{
              infoDetail:function(id){            //根据ID查看详情
               window.location.href='../../views/workbench/adduser.html';
              }
            }
          })

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

     $('.basic-sure').on('click',function(){
      var count = vm.material;
      console.log(count);
    })

    // tab表格栏
    $('.stats li').on('click',function(){
      var index = $(this).index();
      $(this).addClass('stats-active').siblings().removeClass('stats-active')
      $('.stats-info>div').eq(index).show().siblings().hide();
    })


  });
    // 共用对象
    var def={
      trees:{
        industry:[
          { id:1, pId:0, name:'材质', open:false},
          { id:11, pId:1, name:'棉麻'},
          { id:12, pId:1, name:'丝绸'},
          { id:2, pId:0, name:'配饰', open:false},
          { id:21, pId:2, name:'手链'},
          { id:22, pId:2, name:'戒指'},
        ],
        style:[
          { id:1, pId:0, name:'流行', open:false},
          { id:11, pId:1, name:'坎肩'},
          { id:12, pId:1, name:'短袖'},
          { id:2, pId:0, name:'经典', open:false},
          { id:21, pId:2, name:'牛仔'},
          { id:22, pId:2, name:'麦子'},
        ],
        single:[
          { id:1, pId:0, name:'流行', open:false},
          { id:11, pId:1, name:'坎肩'},
          { id:12, pId:1, name:'短袖'},
          { id:2, pId:0, name:'经典', open:false},
          { id:21, pId:2, name:'牛仔'},
          { id:22, pId:2, name:'麦子'},
        ],
        season:[
          { id:1, pId:0, name:'流行', open:false},
          { id:11, pId:1, name:'坎肩'},
          { id:12, pId:1, name:'短袖'},
          { id:2, pId:0, name:'经典', open:false},
          { id:21, pId:2, name:'牛仔'},
          { id:22, pId:2, name:'麦子'},
        ],
        material:[
          { id:1, pId:0, name:'流行', open:false},
          { id:11, pId:1, name:'坎肩'},
          { id:12, pId:1, name:'短袖'},
          { id:2, pId:0, name:'经典', open:false},
          { id:21, pId:2, name:'牛仔'},
          { id:22, pId:2, name:'麦子'},
        ],
        process:[
          { id:1, pId:0, name:'流行', open:false},
          { id:11, pId:1, name:'坎肩'},
          { id:12, pId:1, name:'短袖'},
          { id:2, pId:0, name:'经典', open:false},
          { id:21, pId:2, name:'牛仔'},
          { id:22, pId:2, name:'麦子'},
        ],

      },
      trees_setting:{
        check: {
          enable: true
        },
        data: {
          simpleData: {
            enable: true
          }
        }
      }
    };
    



    // 事件绑定

    bindFunc();










    function bindFunc(){
      // 点击获取焦点
      $('.js-checked-list').on('click',function(e){
        var $self=$(this),tag_ele=$self.siblings('.js-filter-div');
        var id=tag_ele.attr('data-id');
        if(def.trees[id]==undefined){
          var key=$self.attr('data-key') || '';
          if(key!=''){
            $.fn.zTree.init(tag_ele.children('.js-trees-ele'), def.trees_setting, def.trees[key]);
            def.trees[id]=$.fn.zTree.getZTreeObj(id);
          }
        }
        tag_ele.show();
        e.stopPropagation();
      });


      // 隐藏下拉选择层
      $('.js-filter-div').on('click',function(e){
        e.stopPropagation();
      });
      $('#page-wrapper').on('click',function(){
        $('.js-filter-div').hide();
      });
      
      // 搜索筛选项
      $('.js-search-trees').on('keyup',function(e){
        var id=$(this).parent().attr('data-id') || '';
        var txt=$(this).val() || '';
        var ztree_obj=def.trees[id];
        var hide_obj=ztree_obj.getNodesByParamFuzzy('name',txt);
        if(hide_obj.length>0){
          ztree_obj.hideNodes(ztree_obj.getNodes());
          ztree_obj.showNodes(hide_obj);
        }else{
          ztree_obj.showNodes(ztree_obj.getNodes());
        }
          
      });
      // 确定筛选项
      $('.js-add-checked').on('click',function(){
        var id=$(this).parents('.js-filter-div').attr('data-id') || '';
        var ztree_obj=def.trees[id];
        var checked_obj=ztree_obj.getCheckedNodes();
        $(this).parents('.js-filter-div').hide();
        setFilterDom($(this).parents('.js-filter-div').siblings('.js-checked-list'),checked_obj);
      });
      // 取消筛选项
      $('.js-cancel-checked').on('click',function(){
        $(this).parents('.js-filter-div').hide();
      });



      function setFilterDom(tag,data){
        var _html='';
        data.forEach(function(item,index){
          if(index==0){
            _html+='<li>'+item.name+'</li>';
          }else{
            _html+=',<li>'+item.name+'</li>';
          }
          
        });
        console.log(tag)
        tag.html(_html);
      };

    }
    // $.fn.zTree.init($('.js-trees-ele'), def.setting, def.trees['industry']);

    function setTrees(){                                          // 统一生成树结构
      


    }

})

      