<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul id="menu">
	<li class="current"><a href="${pageContext.request.contextPath}/homePage/welcome.htm">Home</a></li>
	<li><a href="${pageContext.request.contextPath}/protected/investments.htm">Investments</a></li>
	<li><a href="${pageContext.request.contextPath}/protected/projects.htm">Projects</a></li>
	<li><a href="${pageContext.request.contextPath}/homePage/contact.htm">Contact Us</a></li>
	<li><a href="${pageContext.request.contextPath}/homePage/faq.htm">FAQ</a></li>
    <c:choose>
	    <c:when test="${not empty sessionScope['userIsAuthenticated']}">
	    	<li><a href="${pageContext.request.contextPath}/protected/initCreateUser.htm">Create User</a></li>
	    	<li><a href="${pageContext.request.contextPath}/protected/logout.htm">Logout</a></li>
	    </c:when>
	    <c:otherwise>
	    	<li><a href="${pageContext.request.contextPath}/homePage/initLogin.htm">Login</a></li>
	    </c:otherwise>
	</c:choose>
</ul>