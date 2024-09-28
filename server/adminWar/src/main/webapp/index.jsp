<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.net.URLConnection" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.util.Date" %>

<html>
<!--
  Admin Console demo page.
-->
<head>
    <meta charset="utf-8">
    <title>Modulith Demo Admin Console</title>
    <style>
        img {
            height: 100px;
            float: left;
        }
    </style>
</head>

<body>
    <h1>Admin Console</h1>
    <p>
        <%
        String recieve;
        StringBuilder buffer = new StringBuilder();
        URL jsonpage = new URL("http://127.0.0.1:8181/cxf/admin/status");
        URLConnection urlcon = jsonpage.openConnection();
        BufferedReader buffread = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
        while ((recieve = buffread.readLine()) != null)
            buffer.append(recieve);
        buffread.close();
        %>
        <%= "Game State: " + buffer %>
        <!--Placeholder code  -->
    </p>
</body>

</html>
