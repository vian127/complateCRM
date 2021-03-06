/*
    #author     gaofeng
    #date       2018/08/13
    #purpose    群发短信
*/

require(['vue', 'msg', 'general', 'base-info', 'layui'], function (Vue, msg, general, global_info) {
    $(function () {
        var def = {
            loading_ele: $('.js-loading-div'),
            ajax_port: global_info.api_url,
            msg_time: global_info.msg_time,
            tag_scroll_val:$('.js-topfixed-ele').eq(0).offset().top,
        };
        
        var vm = new Vue({
            el: '#app',
            data: {
                get_opt: {                            //请求参数
                    templateId: "",
                    typeId: "",
                    content: "",
                    paramVos: [
                        {
                            phoneNumber: "",
                            customerName: "",
                            contactName: ""
                        }
                    ]
                },
                location_obj:general.fn.getLocationParameter(),              //浏览器参数
                template_all: [],                                            //模板下拉数据
                template_id: '',                                             //当前模板
                is_check_all: false,                                         //是否全选
                list_type: 'customer',                                       //发送对象类型
                list_data: [],                                               //当前列表数据
                now_list: [],                                                //当前显示数据

                has_checked_list:{                                           //已选中的数据
                    'customer':[],
                    'user':[],
                    'import':[],
                },


                customer_data:{                                              //客户数据
                    'customer':[],
                    'user':[],
                    'import':[],
                },
                user_data:{                                                  //用户数据
                    'customer':[],
                    'user':[],
                    'import':[],
                },
                checked_user_data:{                                          //已选中的用户数据
                    'customer':[],
                    'user':[],
                    'import':[],
                },
                start_num:0,                                                 //起始index
                pase_size:10,                                                //每页条数
                new_add_customer_ids:[],                                     //新添加的客户
                new_add_mobiles:[]                                           //新上传的的手机号

            },
            mounted:function(){
                
                
                this.getTemplate();
                this.bindFunc();

                layui.use('layer',function(){
                    var layer=layui.layer;
                    layer.config({
                        extend: '../../myskin/style.css', //加载您的扩展样式
                        skin: 'layer-page-ele'
                    })
                });
                
            },
            computed:{
                
            },
            methods: {
                getTemplate:function(){                                                        //请求短信模板数据
                    var self = this;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/msgTemplate/getSelectList',
                        type:'get',
                        success:function (data) {
                            if (data && data.data) {
                                self.template_all = data.data;
                            } else {
                                msg.msg({
                                    'txt': '未请求到数据'
                                }, def.msg_time);
                            }
                            def.loading_ele.fadeOut(400);
                        },
                        error: function () {
                            def.loading_ele.fadeOut(400);
                        }
                    })
                },
                changeTempalte: function () {                                                  //切换模板内容
                    var self = this
                    var id = self.template_id;
                    self.get_opt.templateId = id;
                    if(id !== '') {
                        for(var i=0,len=self.template_all.length;i<len;i++){
                            if(self.template_all[i].id==id){
                                self.get_opt.content = self.template_all[i].content;
                                break;
                            }
                        }
                        
                    }else{
                        self.get_opt.content = ''
                    }
                },
                changeType: function (e) {                                                      //切换发送对象类型
                    // this.list_data = this.user_data[this.list_type];
                    var self=this;
                    self.customer_data[self.list_type]=[];
                    self.new_add_customer_ids=[];
                    self.new_add_mobiles=[];
                    self.checked_user_data[self.list_type]=[];
                    self.list_data = [];
                    self.start_num=0;
                    self.pase_size=10;

                    self.page(self.list_data.length);
                },
                sendMessage: function () {                                                      //确认发送
                    var self = this;
                    var type_id='';
                    var opt = self.get_opt;
                    if (opt.templateId == '') {
                        msg.msg({'txt': '请选择模板'}, def.msg_time);
                        return
                    }
                    if(self.list_type=='customer'){
                        type_id=1;
                    }else if(self.list_type=='user'){
                        type_id=2;
                    }else if(self.list_type=='import'){
                        type_id=3;
                    }
                    opt.typeId = type_id;

                    self.getCheckedData();
                    if (self.user_data[self.list_type].length <1) {
                        msg.msg({'txt': '请添加收件人'}, def.msg_time);
                        return
                    }

                    var send_data=[];
                    self.user_data[self.list_type].forEach(function(item){
                        send_data.push({'phoneNumber':(item.mobile || ''),'customerId':(item.customerId || ''),'contactId':(item.id || '')})
                    });

                    opt.paramVos=send_data;
                    def.loading_ele.fadeIn(200);
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/msg/send',
                        data:opt, 
                        success:function(){
                            msg.msg({'txt':'发送成功！'},def.msg_time);
                            def.loading_ele.fadeOut(400);
                        },
                        error:function(){
                            def.loading_ele.fadeOut(400);
                        }
                    })

                },
                showListBox:function(type){                                                   //弹出层
                    var self=this;
                    var layer=layui.layer;
                    var url=type==1?'/api/web/customer/client?type=2':'/api/web/customer/userlist?type=2';

                    layer.open({
                        title:'',
                        type: 2, 
                        area:['80%','80%'],
                        content: url,
                        shadeClose:true,
                        closeBtn:1,
                        fixed:false,
                        btn: ['取消', '确认添加'],
                        btn1:function(index,layero){
                            layer.close(index); //如果设定了yes回调，需进行手工关闭
                        },
                        btn2:function(index,layero){
                            var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                            if(self.list_type=='user'){
                                self.addUserData(iframeWin.check_list);
                            }else{
                                self.addCustomer(iframeWin.check_list,1);
                            }
                        },
                        anim:1,
                        success:function(){
                        }
                    });
                },
                getUserList:function(opt){                                                        //获取用户列表
                    var self=this;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/customer/getContacts',
                        data:opt,
                        success:function(data){
                            var ndata=data.data || [];
                            var arr=[];
                            ndata.forEach(function(item){
                                arr=arr.concat(item.contacts);
                            });
                            self.new_add_customer_ids=[];
                            self.addUserData(arr);
                        },
                        error:function(){
                            def.loading_ele.fadeOut(400);
                        }
                    })
                },
                addCustomer: function (data,type) {                                                 //添加客户列表
                    var self=this;
                    // self.new_add_customer_ids=[];
                    def.loading_ele.fadeIn(200);
                    if(type==1){
                        data.forEach(function(item){
                            if(self.isExist(self.customer_data[self.list_type],item.id,1,'id')==false){
                                self.customer_data[self.list_type].push(item);
                            }
                            self.new_add_customer_ids.push(item.id);
                        });
                        self.getUserList({
                            ids:self.new_add_customer_ids.join(',')
                        })
                    }else{
                        data.forEach(function(item){
                            if(self.isExist(self.customer_data[self.list_type],item,2)==false){
                                self.customer_data[self.list_type].push(item);
                                self.new_add_mobiles.push(item);
                            }
                        });
                       
                        self.getUserByMobile({
                            phones:self.new_add_mobiles.join(',')
                        })
                    }
                    
                },
                isExist:function(data,tag_val,type,key){                                         //检测是否存在数据里
                    var is_exist=false;
                    if(data.length>0){
                        for(var i=0,len=data.length;i<len;i++){
                            var now_val=type==1?data[i][key]:data[i];
                            if(now_val==tag_val && now_val!=undefined){
                                is_exist=true;
                                break;
                            }
                        }
                    }
                    return is_exist;
                },
                delExistData:function(data,tag_val,type,key){                                   //检测删除数据里值
                    if(data.length>0){
                        for(var i=0,len=data.length;i<len;i++){
                            var now_val=type==1?data[i][key]:data[i];
                            if(now_val==tag_val && now_val!=undefined){
                                data.splice(i,1);
                                break;
                            }
                        }
                    }
                },
                uploadFunc: function () {
                    var self=this;
                    var layer = layui.layer;
                    layer.open({
                        type: 1,
                        title: '',
                        shadeClose:true,
                        closeBtn:1,
                        area: ['50%', 'auto'],
                        fixed:false,
                        btn: ['取消', '确认上传'],
                        content: $('.js-upload'),
                        btn2: self.uploadUser
                    });
                },
                uploadUser:function(index, layero){
                    var self=this;
                    var tag=$('.js-upload-user');
                    var val=tag.val();
                    if(val!=''){
                        var re=/1\d{10}/g;
                        
                        var mobile_arr=val.match(re) || [];
                        
                        if(mobile_arr.length>0){
                            self.addCustomer(mobile_arr,2);
                        }else{
                            msg.msg({'txt':'请输入正确的号码'},def.msg_time);
                            return false;
                        }
                    }else{
                        msg.msg({'txt':'请输入要上传的号码'},def.msg_time);
                        return false;
                    }
                   
                },
                getUserByMobile:function(opt){                                                        //通过手机号获取用户列表
                    var self=this;
                    general.fn.subAjax({
                        url:def.ajax_port+'/api/contact/send/list',
                        data:opt,
                        success:function(data){
                            var ndata=data.data || [];
                            self.addUserData(ndata);
                        },
                        error:function(){
                            def.loading_ele.fadeOut(400);
                        }
                    })
                },
                addUserData:function(data){
                    var self=this;
                    data.forEach(function(item){
                        var nkey=item.id!=undefined?'id':'mobile';
                        if(self.isExist(self.user_data[self.list_type],item[nkey],1,nkey)==false){
                            item.is_checked=false;
                            self.user_data[self.list_type].push(item);
                        }
                        
                    })
                    def.loading_ele.fadeOut(400);
                    self.list_data=self.user_data[self.list_type];
                    // self.checked_user_data[self.list_type]=self.user_data[self.list_type];
                    self.page(self.list_data.length);
                },
                page: function (count) {                                                             //设置分页
                    var self=this;
                    layui.use('laypage', function(){
                        var laypage = layui.laypage;
                        //执行一个laypage实例
                        laypage.render({
                            elem: 'laypage-section',
                            count: count,
                            layout: ['prev', 'page', 'next', 'limit', 'count', 'skip'],
                            jump: function(obj,first){
                                if(obj.count*1<=obj.limit){
                                    $('#laypage-section').hide();
                                }else{
                                    $('#laypage-section').show();
                                }
                                self.pase_size=obj.limit;
                                if(!first){
                                    self.start_num=(obj.curr-1)*self.pase_size;
                                }
                                // 更新数据
                                self.now_list=self.list_data.slice(self.start_num,self.start_num+self.pase_size);
                                // 检测全选
                                self.setAllCheckEle();
                                self.getCheckedData();
                            }
                        });
                    });
                },


                checkAllList:function(e){                                                       //全选
                    var tag=e.target,val=false;
                    if(tag.checked==true){
                        val=true;
                    }
                    this.setChecked(this.now_list,val);
                    this.getCheckedData();
                },
                checkOne:function(e,id){                                                        //单选
                    var tag=e.target;
                    var is_no_checked=false;
                    if(tag.checked==true){
                        if(this.is_check_all==false){
                            for(var i=0,len=this.now_list.length;i<len;i++){
                                if(this.now_list[i].is_checked==false){
                                    is_no_checked=true;
                                    break;
                                }
                            }
                            if(is_no_checked==false){
                                this.is_check_all=true;
                            }
                        }
                        
                    }else{
                        if(this.is_check_all==true){
                            for(var i=0,len=this.now_list.length;i<len;i++){
                                if(this.now_list[i].is_checked==false){
                                    is_no_checked=true;
                                    break;
                                }
                            }
                            if(is_no_checked==true){
                                this.is_check_all=false;
                            }
                        }
                        
                        
                    }
                    this.setCheckedList(id,tag.checked);
                    this.getCheckedData();
                },
                setAllCheckEle:function(){                                                       //检测是否全选
                    var is_checked=true;
                    for(var i=0,len=this.now_list.length;i<len;i++){
                        if(this.now_list[i].is_checked==false){
                            is_checked=false;
                            break;
                        }
                    }
                    if(this.now_list.length>0){
                        this.is_check_all=is_checked;
                    }else{
                        this.is_check_all=false;
                    }
                    
                },
                setChecked:function(data,val){                                                   //设置选中
                    var self=this;
                    data.forEach(function(item){
                        item.is_checked=val;
                        self.setCheckedList(item.id,val);
                    });
                },
                setCheckedList:function(id,type){                                                //设置已经选中
                    for(var i=0,len=this.list_data.length;i<len;i++){
                        if(this.list_data[i].id==id){
                            this.list_data[i].is_checked=type;
                            break;
                        }
                    }
                },
                getCheckedData:function(){                                                       //读取当前选中的数据
                    var self=this;
                    self.checked_user_data[self.list_type]=[];
                    self.list_data.forEach(function(item){
                        if(item.is_checked==false){
                            self.checked_user_data[self.list_type].push({'contactId':item.id,'phoneNumber':item.mobile,'customerId':item.customerId});
                        }
                    });
                },
                delData:function(){                                                             //删除数据
                    var self=this;
                    var flag=true;
                    var i=self.list_data.length;
                    if(i<=0){
                        msg.msg({'txt':'请添加列表数据！'},def.msg_time);
                        return false;
                    }
                    for(var j=0,len=self.list_data.length;j<len;j++){
                        if(self.list_data[j].is_checked!=false){
                            flag=false
                            break;
                        }
                    }
                    if(flag){
                        msg.msg({'txt':'请选择要删除的数据！'},def.msg_time);
                        return false;
                    }
                    while(i--){
                        if(self.list_data[i].is_checked==true){
                            var mobile=self.list_data[i]['mobile'] || '';
                            self.delExistData(self.customer_data[self.list_type],mobile,2);
                            self.delExistData(self.new_add_mobiles,mobile,2);
                            self.list_data.splice(i,1); 
                        }
                    }
                    msg.msg({'txt':'删除成功！'},def.msg_time);
                    self.page(self.list_data.length);
                },
                bindFunc:function(){
                    setFixedEle($(window).scrollTop());
                    $(window).on('scroll',function(){
                        setFixedEle($(this).scrollTop());
                    });



                    function setFixedEle(now_scroll){                                                       //设置固定位置
                        if(now_scroll>def.tag_scroll_val){
                            $('.js-topfixed-ele').addClass('fixed-status');
                        }else{
                            $('.js-topfixed-ele').removeClass('fixed-status');
                        }
                    }
                }
            },

        });
    })
})