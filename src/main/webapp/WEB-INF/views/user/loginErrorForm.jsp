<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ include file = "../layout/header.jsp"%>

<div class="container">
  <form action="/auth/loginProc" method="POST">

    <div class="my-box">
        <div style="margin:10px;">
            Incorrect username or password.
        </div>
    </div>

    </br>


    <div class="form-group">
      <label for="username">Username</label>
      <input type="username" class="form-control" placeholder="Enter username" id="username" name="username">
    </div>

    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
    </div>

    <button id="btn-login" class="btn btn-primary">로그인</button>
  </form>
</div>

<style type="text/css">
    .my-box {
        font-size:20px;
        border:1px solid;
        width:310px;
        padding:20px;
        background-color:#FFB6C1;
    }
</style>

<script src="/js/user.js"></script>
<%@ include file = "../layout/footer.jsp"%>