<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="langExt" value="en"/>
<c:if test="${param.lang!=null}">
    <c:set var="langExt" value="${param.lang}"/>
</c:if>
<fmt:setLocale value="${langExt}"/>
<fmt:setBundle basename="atj.CalcBundle" var="lang" scope="session"/>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="calc.title" bundle="${lang}"/></title>
    <link href="./style.css" rel="stylesheet" type="text/css">
</head>
<body>

<h1><fmt:message key="calc.title" bundle="${lang}"/></h1>
<h3><fmt:message key="calc.choose" bundle="${lang}"/></h3>
<a href="CalcServlet?lang=en"><fmt:message key="calc.english" bundle="${lang}"/></a>
&nbsp;
<a href="CalcServlet?lang=pl"><fmt:message key="calc.polish" bundle="${lang}"/></a>

<form action="CalcServlet">

    <table>
        <tr>
            <td class="value" colspan="4"><p>ERR</p></td>
            <td><input name="btn" type="submit" value="C" /></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" value="7"  disabled/></td>
            <td><input name="btn" type="submit" value="8" disabled/></td>
            <td><input name="btn" type="submit" value="9" disabled/></td>
            <td><input name="btn" type="submit" value="/" disabled/></td>
            <td><input name="btn" type="submit" value="sqrt" disabled/></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" value="4" disabled/></td>
            <td><input name="btn" type="submit" value="5" disabled/></td>
            <td><input name="btn" type="submit" value="6" disabled/></td>
            <td><input name="btn" type="submit" value="*" disabled/></td>
            <td><input name="btn" type="submit" value="%" disabled/></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" value="1" disabled/></td>
            <td><input name="btn" type="submit" value="2" disabled/></td>
            <td><input name="btn" type="submit" value="3" disabled/></td>
            <td><input name="btn" type="submit" value="-" disabled/></td>
            <td rowspan="2"><input class="highButton" name="btn" type="submit" value="=" disabled/></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" value="0" disabled/></td>
            <td><input name="btn" type="submit" value="." disabled/></td>
            <td><input name="btn" type="submit" value="+/-" disabled/></td>
            <td><input name="btn" type="submit" value="+" disabled/></td>
        </tr>
    </table>
</form>

</body>
</html>