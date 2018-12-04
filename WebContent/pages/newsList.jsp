<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="domain.news.model.*" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<fmt:bundle basename="resources.View">	
<c:choose>
	<c:when test="${not empty requestScope.news}">
	<fmt:bundle basename="resources.View">
	<h2><fmt:message key="header.news"/></h2>
	<c:if test="${not empty sessionScope.user.userId}">
		<form action="NewsEdit" method="post">
				<button type="Submit" name="action" value="add"><fmt:message key="action.newNewsItem"/></button>
		</form>
	</c:if>
	<form id="newsForm" action="NewsInfo" method="get"></form>
	<c:forEach items="${requestScope.news}" var="newsItem">
		
			<article>
				<h2>
					<a href="NewsInfo?newsItemId=${newsItem.newsItemId}">
					<c:out value="${newsItem.title}"/>
					</a></h2><br/>
				<p><c:out value="${newsItem.body}"/></p><br/>
				<p><c:out value="${newsItem.date}"/></p><br/>
				<p><c:out value="${newsItem.lang}"/></p><br/>
				<a href="UserInfo?userId=${newsItem.author.userId}"><c:out value="${newsItem.author.getUsername()}"/></a><br/>
			</article>
		</c:forEach>
	</fmt:bundle>
	</c:when>
	<c:otherwise>
		<fmt:bundle basename="resources.Errors">
		<p><fmt:message key="newsList.mainSection"/></p>
		</fmt:bundle>
	</c:otherwise>
	
</c:choose>
</fmt:bundle>
<jsp:include page="../includes/footer.jsp"></jsp:include>