/*------------------------------------------------------
    Author : www.webthemez.com
    License: Commons Attribution 3.0
    http://creativecommons.org/licenses/by/3.0/
---------------------------------------------------------  */

(function ($) {
    "use strict";
    var mainApp = {

        initFunction: function () {
            $("#sidebar").niceScroll({styler:"fb",cursorcolor:"#e08585", cursorwidth: '3', cursorborderradius: '10px', background: '#F7F7F7', cursorborder: ''});
            /*MENU 
            ------------------------------------*/
            $('#main-menu').metisMenu();
			
            $(window).bind("load resize", function () {
                if ($(this).width() < 768) {
                    $('div.sidebar-collapse').addClass('collapse')
                } else {
                    $('div.sidebar-collapse').removeClass('collapse')
                }
            });


            this.bindFunc();
        },

        initialization: function () {
            mainApp.initFunction();

        },

        bindFunc:function(){                                                        //事件绑定
            // 展开左侧
            $("#sideNav").on('click',function(){
                if($(this).hasClass('closed')){
                    $('.navbar-side').animate({left: '0px'});
                    $(this).removeClass('closed');
                    $('#page-wrapper').animate({'margin-left' : '260px'});
                    
                }
                else{
                    $(this).addClass('closed');
                    $('.navbar-side').animate({left: '-260px'});
                    $('#page-wrapper').animate({'margin-left' : '0px'}); 
                }
            });
            // 返回上页
            $('.js-back-btn').on('click',function(){
                window.history.back(-1);
            });
        }

    }
    // Initializing ///

    $(document).ready(function () {
        mainApp.initFunction();
    });

}(jQuery));
