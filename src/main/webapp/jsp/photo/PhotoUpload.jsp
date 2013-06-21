<!DOCTYPE>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function loadXMLDoc()
	{
		var xmlhttp;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.open("GET","ajax_info.txt",true);
		xmlhttp.send();
				  
	}
</script>
<title>Photo Upload Page</title>
<html:base />
</head>
<body bgcolor="white">
<html:form action="/photo/uploadPhoto.do" method="post"
	enctype="multipart/form-data">
	<table>
		<tr>
			<td align="center" colspan="2"><font size="4">Please
			Enter the Following Details</font>
		</tr>
		<tr>
			<td align="left" colspan="2"><font color="red"><html:errors /></font>
		</tr>
		<tr>
			<td align="right">File Name</td>
			<td align="left"><html:file property="uploadFile" /></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><html:submit>Upload File</html:submit>
			</td>
		</tr>
	</table>
	<div id="thumbContainer">
	<div id="nav"><a href="#">Prev</a> <a href="#">Next</a></div>
	<div id="thumb">
	<logic:iterate id="imageThumb" name="photoForm"	property="uploadedFiles" scope="request">
		<html:link action="/photo/photoHome.do">
			<image
				src='<bean:write name="imageThumb" property="imgLocation"/>/
					<bean:write name="imageThumb" property="imgName"/>'
				alt='<bean:write name="imageThumb" property="caption"/>' />
		</html:link>
	</logic:iterate></div>
	</div>

</html:form>

<br />
<br />
<g:plusone annotation="inline"></g:plusone>
<script type="text/javascript"> 
  (function() {
    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
    po.src = 'https://apis.google.com/js/plusone.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
  })();
</script>

<br />
<br />

<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) {return;}
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>


</body>
</html:html>
