<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta name="description" content="free website template" />
	<meta name="keywords" content="enter your keywords here" />
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<mytags:style />
	<mytags:jquery />
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>
	<div id="main">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<!--close header-->
		
		<div id="menu_container">
			<div id="menubar">
				<tiles:insertAttribute name="menu" />
			</div><!--close menubar-->	
		</div><!--close menu_container-->	

		<tiles:insertAttribute name="body" />

	</div><!--close main-->

	<div id="footer_container">
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div><!--close footer-->  
	</div><!--close footer_container-->  

</body>
</html>