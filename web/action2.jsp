<%-- 
    Document   : action2
    Created on : Jun 3, 2016, 7:47:45 PM
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
        <h1>Hello Welcome To Get Cars!</h1>
    <%-- start web service invocation --%><hr/>
    <%
          String a=request.getParameter("getid");
        int b=Integer.parseInt(a);
    try {
	webservice.Hotels_Service service = new webservice.Hotels_Service();
	webservice.Hotels port = service.getHotelsPort();
	 // TODO initialize WS operation arguments here
	int id = b;
	// TODO process result here
	java.lang.String result = port.findCar(id);
	out.println("Car Found = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
