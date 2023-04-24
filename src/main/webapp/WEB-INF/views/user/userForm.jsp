<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ include file = "../layout/header.jsp"%>

<div class="container">
  <form>

    <input type="hidden" id="id" value="${principal.users.userId}">

    <div class="form-group">
      <label for="username">Username</label>
      <input value="${principal.users.username}" type="username" class="form-control" placeholder="Enter username" id="username" readonly>
    </div>

    <div class="form-group">
      <label for="email">Email</label>
      <input value="${principal.users.email}" type="email" class="form-control" placeholder="Enter email" id="email" readonly>
    </div>

  </form>

  <span>
    <a href="/user/updateForm" class="btn btn-primary">회원 정보 수정하기</a>
    <button id="btn-delete" class="btn btn-warning" >회원 탈퇴</button>
  </span>

</div>

<script src="/js/user.js"></script>
<%@ include file = "../layout/footer.jsp"%>