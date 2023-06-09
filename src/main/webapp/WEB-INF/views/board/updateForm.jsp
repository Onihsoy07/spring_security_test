<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ include file = "../layout/header.jsp"%>

<div class="container">
  <input type="hidden" value="${board.id}" id="id">
  <div class="form-group">
    <label for="title">Title</label>
    <input value="${board.title}" type="text" class="form-control" placeholder="Enter title" id="title" name="title">
  </div>

  <div class="form-group">
    <label for="content">Content</label>
    <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
  </div>

  <button id="btn-update" class="btn btn-primary">수정하기</button>

</div>

<script>
  $('.summernote').summernote({
    placeholder: 'content',
    tabsize: 2,
    height: 300
  });
</script>
<script src="/js/board.js"></script>
<%@ include file = "../layout/footer.jsp"%>