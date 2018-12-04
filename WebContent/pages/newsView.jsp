<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="domain.news.model.*" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<fmt:bundle basename="resources.View">	
	<article>
	<h2><c:out value="${newsItem.title}"/></h2><br/>
	<p><c:out value="${newsItem.body}"/></p><br/>
	<p><c:out value="${newsItem.date}"/></p><br/>
	<p><c:out value="${newsItem.lang}"/></p><br/>
	<a href="UserInfo?userId=${newsItem.author.userId}"><c:out value="${newsItem.author.getUsername()}"/></a><br/>
	</article>
	<c:if test="${requestScope.newsItem.author.userId==sessionScope.user.userId}"> <%-- requesScope of newsItem is optional, works with and without --%>
		<form action="NewsEdit" method="post">
			<input type="hidden" name="newsItemId" value="${requestScope.newsItem.newsItemId}"/>
			<button type="Submit" name="action" value="edit"><fmt:message key="action.edit"/></button>
			<button type="Submit" name="action" value="delete"><fmt:message key="action.delete"/></button>
		</form>
	</c:if>
</fmt:bundle>
<jsp:include page="../includes/footer.jsp"></jsp:include>