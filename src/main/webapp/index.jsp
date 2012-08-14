<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Mercy Seat Choir CD Project</title>
        <!-- CSS -->
        <link href="css/structure.css" rel="stylesheet">
        <link href="css/form.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <style type="text/css">
            <!--
            -->
            iframe, p, h2, div.marginal{
                margin-left:30px;
            }

            #slidenav {
                margin-left:0px;
                width:auto;
                height:auto;
                padding:5px 5px;
                display:none;
            }
            #open {
                visibility:hidden;
                margin-left:30px;
                text-align:left;
                padding:5px;
                font-size:25px;
            }
            input.currency 
            {
                text-align:right;
            }
            #footer {
                margin: 0px;
                position:absolute;
                top:950px;
                width:860px;
                height:40px;   /* Height of the footer */
            }
            #container {
                height:100%;
                margin: 0 auto 10px;
                width: 860px
            }
        </style>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
        <script type="text/javascript">
            var timeDelayToShowBuyLink = 141000;  // 1000 = 1 sec
            $(window).load(function() {
                // Make link appear after some predetermined time
                if(document.getElementById("open")) {
                    setTimeout(function() { document.getElementById("open").style.visibility = "visible"; }, timeDelayToShowBuyLink);
                }
                
                
            });

            $(document).ready(function() {
                $('#slidenav').animate({
                    marginTop: '-380px'
                }, 200);
                $('#open a').toggle(
                function(){
                    $('#slidenav').attr("style", "display:block");
                    $("#open").attr("style", "display:none");
                    $('#slidenav').animate({
                        marginTop: '0'
                    }, 50);
                },
                function(){
                    $('#slidenav').animate({
                        marginTop: '-380px'
                    }, 50);
                });
                //reload footer
                document.getElementById("footer").style.visibility = "hidden";
                document.getElementById("footer").style.visibility = "visible";
            });
            
            function dual_submit(){
                var f = document.forms[0];
                /*f.setAttribute('target','_myHidFrame');
                f.setAttribute('action', 'your url');
                f.submit();*/
                f.setAttribute('target','_self');
                f.setAttribute('action','https://www.paypal.com/cgi-bin/webscr');
                f.submit();

            }
        </script>
        <script language="JavaScript" type="text/JavaScript">
            <!--
            function MM_swapImgRestore() { //v3.0
                var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
            }

            function MM_preloadImages() { //v3.0
                var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
                    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
                        if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
                }

                function MM_findObj(n, d) { //v4.01
                    var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
                        d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
                    if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
                    for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
                    if(!x && d.getElementById) x=d.getElementById(n); return x;
                }

                function MM_swapImage() { //v3.0
                    var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
                        if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
                }
                //-->
        </script>
        <script>
                <!--
                function setAmountInput()
                {
                    var dollar = isNaN($('#Field0').val())?0:Number($('#Field0').val());
                    var cents = isNaN($('#Field0-1').val())?0:Number($('#Field0-1').val());
                    $('#AMOUNT').val((dollar + cents/100).toFixed(2));
                }
                function validateForm(){
                    var amount = document.getElementById("AMOUNT").value;  
                    var firstName = document.getElementById("FIRST_NAME").value;
                    var lastName = document.getElementById("LAST_NAME").value;
                    var email = document.getElementById("EMAIL").value;  
  
                    if (amount < 1 || firstName == "" || lastName == "" || email == "" ) {
                        generalError("Please enter all fields marked with an '*'");
                        return false;
                    } else {
                        if (checkEmail(email) != true) {
                            generalError("Please enter a valid email address so that we can contact you."); 
                            return false;
                        }
                        else {
                            dual_submit();
                        }
                    }		
                    
                }
                function checkEmail(emailaddr) {
                    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(emailaddr)){
                        return true;
                    }
                    return false;
                }
                // Added .style to this document of: errorMsg
                // Also added DIV tag for error_General
                function generalError(msg) { drawShow( document.getElementById('error_General'), msg); }

                function generalErrorClear() { 
                    var ele = document.getElementById('error_General')
                    ele.style.visibility = 'hidden'; 
                    ele.innerHTML = '';
                }

                function drawShow(ele,msg) { if(msg) {ele.innerHTML=msg;} ele.style.visibility = 'visible'; }

                function drawHide(ele) { 
                    ele.style.visibility = 'hidden'; 
                    ele.innerHTML = '';
                }
                //-->
        </script>
        <link href="wvstyle.css" tppabs="wvstyle.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            <!--
            a:link {
                color: #007520;
            }
            a:visited {
                color: #007520;
            }
            a:hover {
                color: #00BD20;
            }
            a:active {
                color: #00BD20;
            }
            .style2 {font-size: small}
            .errorMsg {
                font-weight: bold;
                color: #C00;
            }
            -->
        </style>
    </head>
    <body id="container">
        <Br/><BR/>
        <iframe width="800" height="400" src="http://www.youtube.com/embed/2wNKv0GqWpg?autoplay=1" frameborder="0" allowfullscreen></iframe>

        <div id="slidenav" class="ltr">
            <p class="Plain style2">
                <span class="TextHeading">
                    <h2>ONLINE DONATION FORM</h2>
                </span><br>
            <div class="marginal">
                Please fill out the form below to make a donation today <br>

                Support Mercy Seat Chapel choir with the 2013 CD Project! <BR>(It's secure, quick and easy!)
            </div>
        </p>
        <p align="left" class="Plain style2">Note: All donations of $2 or more are tax deductible. Fields marked with a <span id="req_1" class="req">*</span> are required. </p>
        <form id="form62" name="form62" class="wufoo topLabel page" autocomplete="off" action="javascript:validateForm()" method="post" >
            <ul>
                <li id="foli1" class="notranslate      ">
                    <label class="desc" id="title1" for="FIRST_NAME">
                        Name
                        <span id="req_1" class="req">*</span>
                    </label>
                    <span>
                        <input id="FIRST_NAME" name="FIRST_NAME" type="text" class="field text fn" value="" size="8" tabindex="1" required />
                        <label for="FIRST_NAME">First</label>
                    </span>
                    <span>
                        <input id="LAST_NAME" name="LAST_NAME" type="text" class="field text ln" value="" size="14" tabindex="2" required />
                        <label for="LAST_NAME">Last</label>
                    </span>
                </li>
                <li id="foli0" class="notranslate      ">
                    <label class="desc" id="title0" for="Field0">
                        Donation Amount
                        <span id="req_0" class="req">*</span>
                    </label>
                    <span class="symbol">$</span>
                    <span>
                        <input id="Field0" onchange="setAmountInput()" name="Field0" type="text" class="field text currency nospin" value="" size="10" tabindex="4" required />
                        <label for="Field0">Dollars</label>
                    </span>
                    <span class="symbol radix">.</span>
                    <span class="cents">
                        <input id="Field0-1" onchange="setAmountInput()" name="Field0-1" type="text" class="field text currency nospin" value="" size="2" maxlength="2" tabindex="5" />
                        <label for="Field0-1">Cents</label>
                    </span>
                    <input id="AMOUNT" type="hidden" name="amount" value="222">
                </li><li id="foli112" class="notranslate      ">
                    <label class="desc" id="title112" for="EMAIL">
                        Email
                    </label>
                    <div>
                        <input id="EMAIL" name="EMAIL" type="email" spellcheck="false" class="field text medium" value="" maxlength="255" tabindex="6" /> 
                    </div>
                </li>
                <li id="foli10" class="notranslate      ">
                    <fieldset>
                        <![if !IE | (gte IE 8)]>
                        <legend id="title10" class="desc">
                        </legend>
                        <![endif]>
                        <!--[if lt IE 8]>
                        <label id="title10" class="desc">
                        </label>
                        <![endif]-->

                    </fieldset>
                </li><li class="buttons ">
                    <div>
                        <input type="hidden" name="cmd" value="_s-xclick">
                        <input type="hidden" name="hosted_button_id" value="VL56U8GGT9J7Q">
                        <input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
                        <img alt="donate button" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
                    </div>
                </li>

            </ul>
        </form>
    </div>
    <div id="open">
        <a href="#">Support Mercy Seat Chapel Choir</a>
    </div>
    <div id="footer">Copyright&nbsp;&copy;&nbsp;2005&nbsp;-&nbsp;2012&nbsp;<a href="http://www.mercyseatchapel.org">Mercy Seat Chapel</a>.&nbsp;All Rights Reserved. <div>WEBSOLUTIONS PROVIDED BY: <a href="mailto:ayodeji@babaniyi.ws">FAB VENTURES, Inc.</a></div></div>

</body>
</html>
