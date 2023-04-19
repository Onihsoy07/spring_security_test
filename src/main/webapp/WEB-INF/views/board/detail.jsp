<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ include file = "../layout/header.jsp"%>

    <div class="container">
        <button class="btn btn-secondary" onclick="location.href='/'">목록</button>
        <c:if test="${board.users.userId == principal.users.userId}">
          <a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
          <button id="btn-delete" class="btn btn-danger">삭제</button>
        </c:if>
        <div>
            작성자 : <span><i>${board.users.username}</i>&nbsp;&nbsp;</span>
            글 번호 : <span><i>${board.id}</i>&nbsp;&nbsp;</span>
            조회수 : <span><i>${board.viewCount}</i></span>
        </div>
        <br>
        <div>
            <div style="font-size:3em;">${board.title}</div>
        </div>

        <br><hr><br>

        <div>
            <div style="font-size:2em;">${board.content}</div>
        </div>
    </div>

<script src="/js/board.js"></script>
<%@ include file = "../layout/footer.jsp"%>
