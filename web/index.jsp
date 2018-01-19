<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<table>
    <form action="ServletController" method="POST">
        <tr>
            <td><input type="text" name="sureName" value=${richest.name}></td>
            <td><input type="submit" name="button" value="getRichest"/></td>
        </tr>
        <tr>
            <td><input type="text" name="accounts sum" value=${sum}></td>
            <td><input type="submit" name="button" value="getSum"/></td>
        </tr>
    </form>
</table>
</body>
</html>
