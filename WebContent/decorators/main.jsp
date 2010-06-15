<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<head>
  <title>
    Lumidant.com - <decorator:title default="SiteMesh Tutorial Example" />
  </title>
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