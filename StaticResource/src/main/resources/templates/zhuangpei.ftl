<!DOCTYPE html>
	<head>
	    <!-- Http Header Infomation -->
	    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	    <meta http-equiv="Content-Language" content="zh-cn" />
        <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache" content="no-cache">
	    <meta name="author" content="fxstudio.com.cn" />
	    <meta name="description" content="fx-tech.cn" />
	    <meta name="keywords" content="fx-tech.cn,Management,FXStudio"/>
	    <meta name="Copyright" content="Copyright fx-tech.cn All Rights Reserved."/>
	    <title>LDPlatform</title>

	    <link href="css/wh_zhuangpei.min.css" rel="stylesheet"></head>
  	<body>
		<div id='root' class="container-fluid"></div>
		
  		<script src="javascript/views/frond/zhuangpei/vendor.20535c792573cf8571e7.js"></script>
  		<script src="javascript/views/frond/zhuangpei/bootstrap.20535c792573cf8571e7.js"></script>
  		<script src="javascript/views/frond/zhuangpei/main.20535c792573cf8571e7.js"></script>
        <script src="javascript/libs/jquery/jquery.min.js"></script>
  		<script>
  			$(document).ready(function() {
		  			$(document).bind({
			  				"contextmenu": function(e) {
					    		 $(":text:first").focus();
					       		 return false;
					    	},
					    	"click": function(){
					    			if ($(this).context.activeElement.className === 'fx-select-box fx-select'){
					    				  return true;
					    			}
					    		    $(":text:first").focus();
					    	}
		  			});
				    
				    $(":text").bind({
				    		click: function() {
						    		var txt = $(this);
						    		setTimeout(function() { txt.select(); }, 10);
						    },
						    keypress: function(e) {
						    	if(13 === e.keyCode) {
						    		$('.fade').remove();
						    	}
						    }
				    });				    
  			});
  		</script>
	</body>
</html>
