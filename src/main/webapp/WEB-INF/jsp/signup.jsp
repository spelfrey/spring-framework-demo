<%--
  Created by IntelliJ IDEA.
  User: spelf
  Date: 7/4/2018
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="includes/header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="card border-primary">
    <div class="card-header">
        Please signup
    </div>
    <div class="card-body">
        <form:form modelAttribute="userCommand">
            <form:errors cssClass="error"/>
            <div class="form-group">
                <form:label path="email">Email address</form:label>
                <form:input path="email" type="email" class="form-control" id="exampleInputEmail1"
                            aria-describedby="emailHelp"
                            placeholder="Enter email"/>
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.
                </small>
                <form:errors path="email" cssClass="error"/>
            </div>
            <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:input path="name" type="text" class="form-control" id="exampleInputName1"
                            aria-describedby="emailHelp"/>
                <form:errors path="name" cssClass="error"/>
            </div>

            <div class="form-group">
                <form:label path="password">Password</form:label>
                <form:input path="password" type="password" class="form-control" id="exampleInputPassword1"
                            placeholder="Password"/>
                <form:errors path="password" cssClass="error"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</div>
<%@include file="includes/footer.jsp" %>
