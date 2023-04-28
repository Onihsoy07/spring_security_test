let index = {
  init: function() {
    $("#btn-save").on("click", ()=>{
      this.save();
    });

    $("#btn-delete").on("click", ()=>{
      this.deleteById();
    });

    $("#btn-update").on("click", ()=>{
      this.update();
    });

  },

//  document.getElementById("btn-save").addEventListener('click',save);
//  document.getElementById("btn-delete").addEventListener('click',deleteById);

  save: function() {
    let data = {
      title: $('#title').val(),
      content: $('#content').val()
    };

    $.ajax({
      type : "POST",
      url : "/api/board",
      contentType: "application/json;charset=utf-8",
      dataType:"json",
      data : JSON.stringify(data)
      }).done(function (res) {
        alert("글쓰기 완료");
        location.href="/";
      }).fail(function (error){
        alert("글쓰기 실패");
      });
  },

  deleteById: function() {
    let id = $("#id").text();

    $.ajax({
      type : "DELETE",
      url : "/api/board/" + id,
      dataType:"json"
      }).done(function (res) {
        alert("삭제 완료");
        location.href="/";
      }).fail(function (error){
        alert("삭제 실패");
      });
  },

  update: function() {
    let id = $("#id").val();

    let data = {
      title: $('#title').val(),
      content: $('#content').val()
    };

    $.ajax({
      type : "PUT",
      url : "/api/board/" + id,
      contentType: "application/json;charset=utf-8",
      dataType:"json",
      data : JSON.stringify(data)
      }).done(function (res) {
        alert("수정 완료");
        location.href="/";
      }).fail(function (error){
        alert("수정 실패");
      });
  }

};

index.init();