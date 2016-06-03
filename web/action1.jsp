<%-- 
    Document   : action1
    Created on : Jun 3, 2016, 7:47:34 PM
    Author     : saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Welcome To Show Cars!</h1>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	webservice.Hotels_Service service = new webservice.Hotels_Service();
	webservice.Hotels port = service.getHotelsPort();
	// TODO process result here
	java.lang.String result = port.showCars();
	out.println("List Of Cars = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
