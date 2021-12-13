<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 12/13/2021
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%!
    public String getBrowserInfo(String information) {
        String browserName = "";
        String browserVersion = "";

        if (information == null) {
            return "MSIE";
        } else {
            String info[] = information.split(",")[2].split(";");
            browserName = info[0].split("\"")[1];
            browserVersion = info[1].split("\"")[1];
        }

        return browserName + " - version " + browserVersion;
    }
%>
<%= getBrowserInfo(request.getHeader("sec-ch-ua")) %>
</body>
</html>
