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
      <label for="password">Password</label>
      <input type="password" class="form-control" placeholder="Enter password" id="password">
    </div>

    <div class="form-group">
      <label for="email">Email</label>
      <input value="${principal.users.email}" type="email" class="form-control" placeholder="Enter email" id="email">
    </div>

  </form>

  <button id="btn-update" class="btn btn-primary" >회원 정보 수정 완료</button>

</div>

<script src="/js/user.js"></script>
<%@ include file = "../layout/footer.jsp"%>