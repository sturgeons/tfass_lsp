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
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" href="themes/css/ext-all-neptune.css" />
        <link rel="stylesheet" href="css/style.css" />
    </head>

    <body>
 		<input type="hidden" value="${model["sysid"]}" id="em_id"/>
    
        <!-- Load Javascript lib -->
        <script src="javascript/libs/extjs/ext-all.js"></script>
        <script src="javascript/libs/extjs/locale/ext-lang-zh_CN.js"></script>
        <script src="javascript/plugins/ZeroClipboard.min.js"></script>
        <script src="javascript/config/environment.js"></script>
	    <script src="javascript/utils/require.js"></script>
        <script src="javascript/config/require.config.js"></script>
        
        <#if model["modelName"]??>
            <script src="javascript/views/backward/${model["modelName"]}/app.js"></script>
        </#if>
    </body>
</html>
