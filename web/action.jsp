<%-- 
    Document   : action
    Created on : Jun 3, 2016, 7:47:14 PM
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
        <h1>Hello Welcome To Show Hotels!</h1>
        
        
        
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	webservice.Hotels_Service service = new webservice.Hotels_Service();
	webservice.Hotels port = service.getHotelsPort();
	// TODO process result here
	java.lang.String result = port.showHotels();
	out.println("List Of Hotels = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    
    
    
         <form action="action4.jsp" method="post">
             Enter Your Name:            <input type="text" name="getname" ><br>
             Enter Hotel Name From List: <input type="text" name="getname2" ><br>

        <input type="submit" value="reservation"></form>
    </body>
</html>
