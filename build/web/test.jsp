<%-- 
    Document   : test
    Created on : 17.04.2012, 10:11:23
    Author     : rainer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="wuerfel" class="model.Cube" scope="session"/>
<jsp:setProperty name="wuerfel" property="title" value="Test"/>
<jsp:setProperty name="wuerfel" property="src" value="img/wuerfel1.png"/>
<jsp:setProperty name="wuerfel" property="number" value="1" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <img name="wuerfel" title="<%= wuerfel.getTitle() %>" src="<%= wuerfel.getSrc() %>" alt="<%= wuerfel.getAlt() %>" onclick="callServlet()"/>
				
    </body>
</html>
