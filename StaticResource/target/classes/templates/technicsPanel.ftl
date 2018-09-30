<!DOCTYPE html>
<html>

    <head>
        <!-- Http Header Infomation -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Language" content="zh-cn" />
        <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache" content="no-cache">
        <meta name="author" content="fxstudio.com.cn" />
	    <meta name="description" content="fx-tech.cn" />
	    <meta name="keywords" content="fx-tech.cn,LDPlatform,FXStudio"/>
	    <meta name="Copyright" content="Copyright fx-tech.cn All Rights Reserved."/>
	    <title>LDPlatform</title>

        <!-- WebPage Style Desc -->
        <link rel="shortcut icon" type="images/x-icon" href="images/favicon.ico" />
        <#if model["modelName"] == "monitor">
        	<link rel="stylesheet" href="themes/css/ext-all-neptune.css" />
        <#else>
	        <link rel="stylesheet" href="themes/css/ext-all.css" />
        </#if>
	    <link rel="stylesheet" href="/css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/technicsPanel.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/keyboard-dark.css" />
    </head>
    
    <body scroll="no" id="docs">
        <!-- 系统等待视窗-->
        <div id="loading-mask"></div>
        <div id="loading">
            <div class="loading-indicator">
                 页面加载中，请稍后&hellip;
            </div>
        </div>
        <!-- 页面头样式-->
        <div id="header">
            <span class="banner"></span>
            <a href="systemLogout" tooltip="退出系统"><div class="logout"></div></a>
            <a href="#"><div class="t_bar"></div></a>
        </div>
        
        <ul id="userInfo" class="list-group">
		         <li class="list-group-item"><span class="badge">1</span><span class="label label-primary">姓名</span> ${model["EM_NAME"]}</li>
		         <li class="list-group-item"><span class="badge">2</span><span class="label label-info">工号</span> ${model["EM_NO"]}</li>
		         <li class="list-group-item"><span class="badge">3</span><span class="label label-success">登录时间</span> ${model["LOGIN_DATE"]}</li>
		         <li class="list-group-item"><span class="badge">4</span><span class="label label-success">岗位</span>
		         	 <#if model["EM_MONITOR"]="1">
			                 班长
					 <#else>
					      员工
			          </#if>
		         </li>
        </ul>
        
 		<input type="hidden" value="${model["SYSID"]}" id="em_id"/>
 		
		<!-- keyboard input -->
		<input id="keyboard" style="width:100%;font-size:45pt;text-align:center"/>

        <!-- Load Javascript lib -->
        <script src="javascript/libs/extjs/ext-all.js"></script>
        <script src="javascript/libs/extjs/locale/ext-lang-zh_CN.js"></script>
        <script src="javascript/libs/jquery/jquery.min.js"></script>
        <script src="javascript/libs/jquery/jquery.keyboard.js"></script>
        <script src="javascript/libs/jquery/jquery.keyboard.extension-all.js"></script>
        <script src="javascript/config/environment.js"></script>
	    <script src="javascript/utils/require.js"></script>
        <script src="javascript/config/require.config.js"></script>
        
        <#if model["modelName"]??>
            <script src="javascript/views/technics/${model["modelName"]}/app.js"></script>
        </#if>
    </body>

</html>
