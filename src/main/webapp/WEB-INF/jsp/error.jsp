<%--
  Created by IntelliJ IDEA.
  User: spelf
  Date: 7/4/2018
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp" %>
<div class="alert alert-danger" role="alert">There was an unexcpected error (type=${error},
    status=${status}): <strong>${message}</strong></div>
<%@include file="includes/footer.jsp" %>
