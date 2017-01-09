$(document).ready(function(){

    var glb_ValidNum = 0 ,glb_invalidNum = 0;

    //init Loading...
    $(function(){
        $.ajax({
            url:'/CIS/custQuery/searchCustomer',
            type:'POST',
            dataType:'json',
            // contentType:'application/json',
            data:{cust:"",code:""},
            success: function(result){
                // alert('hi');
                var res = JSON.parse(result);
                console.log(res.data);
                console.log(res.showNum);
                console.log(res.allNum);
                fillTable(res.data);
                updatePage(res.allNum,res.showNum);
                updateValidNum();
            }
        })
    });

    $("#btn_search").click(function(){
        var name = $("#custName").val() ;
        var code = $("#custCode").val() ;
        if(name =='' && code == ''){
            alert("客户名称、代码至少输入一个");
            return;
        }
        $.ajax({
            url:'/CIS/custQuery/searchCustomer',
            type:'POST',
            dataType:'json',
            // contentType:'application/json',
            data:{cust:name,code:code},
            success: function(result){
                // alert('hi');
                var res = JSON.parse(result);
                console.log(res.data);
                console.log(res.showNum);
                console.log(res.allNum);
                fillTable(res.data);
                updatePage(res.allNum,res.showNum);
                updateValidNum();
            }
        })

    });
    $("#btn_reset").click(function(){
        $("#custName").val(null);
        $("#custCode").val(null);
    });

    $("#btn_checkEmail").click(function(){
        $("td.for_email").each(function(){
            var email = $(this).html();
            if(!CheckMail(email)){
                $(this).addClass("alert alert-danger");
            }
        })
    });

    //filter the unsafe char in HTML
    function esc(text){
        return text
            .replace('&','&amp;')
            .replace('<','&lt')
            .replace('>','&gt');
    }

    function fillTable(names){
        var e=esc;

        var html = [],h=-1;
        html[++h] = '';
        for (var name ,i =-1; name = names[++i];){
            html[++h] = '<tr><td>';
            html[++h] = e(name.custName);
            html[++h] = '</td><td>';
            html[++h] = e(name.custCode);
            html[++h] = '</td><td>';
            html[++h] = e(name.custCity);
            html[++h] = '</td><td>';
            html[++h] = e(name.contactPerson);
            html[++h] = '</td><td>';
            html[++h] = e(name.tel);
            html[++h] = '</td><td class="for_email">';
            html[++h] = e(name.email);
            html[++h] = '</td><td class="for_state">';
            html[++h] = e(name.stat);
            html[++h] = '</td></tr>';
        }
        html[++h] = '';
        $('#contents')[0].innerHTML = html.join('');
    }

    function updatePage(allNum,showNum){
        $('#id_tipsForTable').show();
        $('#id_allListNum').html(allNum);
        $('#id_showListNum').html(showNum);
        updateValidNum();
    }
    function updateValidNum(){
        glb_ValidNum = 0 ;
        glb_invalidNum = 0;
        $("td.for_state").each(function(){
            var state = $(this).html();
            if(state === '有效地'){
                glb_ValidNum ++;
            }else if(state === '无效的'){
                glb_invalidNum++;
            }
        });
        $('#id_validNum').html(glb_ValidNum);
        $('#id_invalidNum').html(glb_invalidNum);
    }

    function CheckMail(mail) {
        var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (filter.test(mail)) return true;
        else    return false;
    }
});