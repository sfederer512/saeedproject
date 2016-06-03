<%-- 
    Document   : action4
    Created on : Jun 3, 2016, 9:25:52 PM
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
        <h1>Hello World!</h1>
        
    <%-- start web service invocation --%><hr/>
    <%
                  String a=request.getParameter("getname");
                  String b=request.getParameter("getname2");

    try {
	webservice.Hotels_Service service = new webservice.Hotels_Service();
	webservice.Hotels port = service.getHotelsPort();
	 // TODO initialize WS operation arguments here
	java.lang.String name = a;
	java.lang.String hotel = b;
	// TODO process result here
	java.lang.String result = port.bookhotel(name, hotel);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
