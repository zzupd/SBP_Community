<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="headerWrap" class="wrap">
	<header id="header">
		<nav id="gnb">
			<ul id="mainMenu" class="dFlex">
				<li class="mainLi"><a href="/">메인</a></li>

<c:if test="${sessionScope.sid == null }">
		<li class="mainLi"><a href="/join">회원가입</a></li>
		<li class="mainLi"><a href="/login">로그인</a></li>
		<!--  
		<li class="mainLi"><a href="javascript:alert('로그인이 필요합니다.')">글쓰기</a></li>
		-->
</c:if>				
<c:if test="${sessionScope.sid != null }">
		<li class="mainLi"><a href="/logout">로그아웃</a></li>
</c:if>	
		<li class="mainLi"><a href="/write">글쓰기</a></li>
		<li class="mainLi"><a href="/list">글목록</a></li>
				
				
			</ul>
		</nav>
	</header>  <!-- header#header -->
</div> 	<!-- div#headerWrap -->
