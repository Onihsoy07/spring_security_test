<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ include file = "../layout/header.jsp"%>

    <div class="container">
        <button class="btn btn-secondary" onclick="location.href='/'">목록</button>
        <c:if test="${board.users.userId == principal.users.userId}">
          <a href="/board/updateForm/${board.id}" class="btn btn-warning">수정</a>
          <button id="btn-delete" class="btn btn-danger">삭제</button>
        </c:if>
        <div>
            작성자 : <span><i>${board.users.username}</i></span>&nbsp;&nbsp;
            글 번호 : <span id="id"><i>${board.id}</i></span>&nbsp;&nbsp;
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

        <br><hr><br>

        <div class="form-group">
          <label for="comment">Comment:</label>
          <textarea class="form-control" rows="1" id="comment"></textarea>
        </div>
        <button id="btn-reply" class="btn btn-primary">댓글</button>


        <br><br>

        <div class="card">
            <div class="card-header">댓글</div>
            <c:forEach var="reply" items="${board.replyList}">
                <div class="card d-flex">
                    <div class="d-flex">
                        ${reply.comment}
                    </div>
                    <div class="d-flex">
                        <i>작성자 : ${reply.users.username}</i>
                    </div>
                    <div class="d-flex">
                        ${reply.createdDate}
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>

    <script src="/js/board.js"></script>

<%@ include file = "../layout/footer.jsp"%>