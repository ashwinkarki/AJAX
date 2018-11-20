 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping-${title}</title>
	<script>
	
		window.menu='${title}';
		//setting context root at global object window
		window.contextRoot='${contextRoot}'
	</script>
	
    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <!-- new theme pachi haleko-->
    <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
    
    <!-- to beautify datatable-->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet"> 
    
    
    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">
	<style>
ul.breadcrumb {
    padding: 10px 16px;
    list-style: none;
    background-color: #eee;
}
ul.breadcrumb li {
    display: inline;
    font-size: 18px;
}
ul.breadcrumb li+li:before {
    padding: 8px;
    color: black;
    content: "/\00a0";
}
ul.breadcrumb li a {
    color: #0275d8;
    text-decoration: none;
}
ul.breadcrumb li a:hover {
    color: #01447e;
    text-decoration: underline;
}
</style>
  </head>

  <body>

    <!-- Navigation -->
    <%@include file="./shared/navbar.jsp" %> 

    <!-- Page Content -->
    <c:if test="${userClickHome== true}">
    <%@include file="home.jsp" %>
    </c:if>
    <!-- /.container -->
	<c:if test="${userClickAbout== true}">
    <%@include file="about.jsp" %>
    </c:if>
    
    <c:if test="${userClickContact== true}">
    <%@include file="contact.jsp" %>
    </c:if>
    
    <c:if test="${userClickAllProducts== true or userClickCategoryProducts== true }">
    <%@include file="listProducts.jsp" %>
    </c:if>
    
    <c:if test="${userClickShowProduct== true}">
    <%@include file="singleProduct.jsp" %>
    </c:if>
    
    <c:if test="${userClickManageProducts== true}">
    <%@include file="manageProducts.jsp" %>
    </c:if>
    
    <!-- Footer -->
   <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    
    <!-- datatable plugin -->
    <script src="${js}/jquery.dataTables.js"></script>
    
    <%--   <!-- datatable beautifuy -->
    <script src="${js}/dataTables.bootstrap.js"></script> --%>
    
    <!-- self coded js -->
    <script src="${js}/myapp.js"></script>

  </body>

</html>
