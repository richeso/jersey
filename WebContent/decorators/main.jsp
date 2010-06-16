<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<head>
  <title>
    Lumidant.com - <decorator:title default="SiteMesh Tutorial Example" />
  </title>
  	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>jQuery UI Example Page</title>
	<link type="text/css" href="jqueryui/css/start/jquery-ui-1.8.2.custom.css" rel="stylesheet" />	
	<script type="text/javascript" src="jqueryui/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="jqueryui/js/jquery-ui-1.8.2.custom.min.js"></script>
  	<style type="text/css">@import "css/global.css";</style>
  <decorator:head />
  <body>
    <div id="header">
      <h1>Header for Web Site - in main.jsp</h1>
    </div>
    <div id="content">
      <decorator:body />
    </div>
    <%@ include file="footer.jsp" %>
  </body>
</html>