<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.List" import ="java.util.ArrayList" import = "com.project.RandomizedQueue" import = "com.project.Point2D" %>
<!DOCTYPE html>
<html>
<body>
<h1>
    Closest Point
</h1>

<h2>
	The point closest to your desired point is

</h2>

<% 
Point2D close = (Point2D) request.getAttribute("point");
out.println("<br>Point: <br><br>");
out.println("x: ");
out.println(close.x());
out.println("y: ");
out.println(close.y());
//while(it.hasNext()){
//out.println(it.next()+"<br>");
//}
%>
</body>
</html>