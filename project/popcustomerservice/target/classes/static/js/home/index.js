/*
    #author     lut000
    #date       2018/08/23
    #porpuse    首页
*/
require.config({
    paths: {
    },
    shim: {
    }
});
require([], function(){
    var oDiv1=document.body.querySelector('.js-clock-div');
    var oH=oDiv1.querySelector('.h');
    var oM=oDiv1.querySelector('.m');
    var oS=oDiv1.querySelector('.s');

    // 写刻度
    for(var i=0;i<60;i++){
        var oSpan=document.createElement("span");
        oSpan.className="spn";
        if(i%5==0){
            var oEm=document.createElement("em");
            i==0?oEm.innerHTML=12:oEm.innerHTML=i/5;
            oEm.className="word_sty";
            oSpan.appendChild(oEm);
            oSpan.className="spn h_spn";
            oEm.style.transform="rotate("+(-6*i)+"deg)";
        }
        oDiv1.appendChild(oSpan);
        oSpan.style.transform="rotate("+(6*i)+"deg)";
    }
    oDiv1.querySelectorAll('.word_sty')[0].style.left=-8+'px';
    oDiv1.querySelectorAll('.word_sty')[11].style.left=-8+'px';
    oDiv1.querySelectorAll('.word_sty')[10].style.left=-8+'px';
    // 安装指针
    function getTime(){
        var data=new Date();
        var h=data.getHours();
        var m=data.getMinutes();
        var s=data.getSeconds();
        var now_s=s*6;
        var now_m=m*6+s*0.1;
        var now_h=0;
        h<12?now_h=h:now_h=h-12;

        oS.style.transform="rotate("+(-90+now_s)+"deg)";
        oM.style.transform="rotate("+(-90+now_m)+"deg)";
        oH.style.transform="rotate("+(-90+now_h*30+m*0.5+s/120)+"deg)";

        myShadow(now_s,oS);
        myShadow(now_m,oM);
        myShadow(now_h*30+m*0.5+s/120,oH);
        // 添加效果
        function myShadow(num,obj){
            var lut_sx=num>180?(180-(num-180)):num;
            var lut_sy=0;
            if(num<=180){
                lut_sy=num<90?num*8/90:(180-num)/90;
            }
            else{
                lut_sy=num>270?-(360-num)*8/90:-(num-180)*8/90;
            }
            obj.style.boxShadow=lut_sx*6/180+"px "+lut_sy+"px 5px #000";
        }   
    }
    setInterval(getTime,1000);
});