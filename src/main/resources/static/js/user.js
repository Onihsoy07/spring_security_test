let index = {
  init: function() {
    $("#btn-save").on("click", ()=>{
      this.save();
    });
    $("#btn-update").on("click", ()=>{
          this.update();
    });
    $("#btn-delete").on("click", ()=>{
          this.broke();
    });

  },

  save: function() {
    let data = {
      username: $("#username").val(),
      password: $("#password").val(),
      email: $("#email").val()
    };

// data 확인용
//    console.log(data);
//    alert(JSON.stringify(data));

    $.ajax({
      type : "POST",
      url : "/auth/joinProc",
      contentType: "application/json;charset=utf-8",
      dataType:"json",
      data : JSON.stringify(data)
      }).done(function (res) {
        alert("회원가입이 완료되었습니다.");
        location.href="/";
      }).fail(function (error){
        alert("회원가입이 실패하였습니다.");
      });
  },

  update: function() {
    let id = $("#id").val();
    let data = {
      password: $("#password").val(),
      email: $("#email").val()
    };

    $.ajax({
      type : "PUT",
      url : "/user/" + id,
      contentType: "application/json;charset=utf-8",
      dataType:"json",
      data : JSON.stringify(data)
      }).done(function (res) {
        alert("회원 수정이 완료되었습니다.");
        location.href="/";
      }).fail(function (error){
        alert("회원 수정이 실패하였습니다.");
      });
  },

  broke: function() {
    let id = $("#id").val();

    $.ajax({
      type : "DELETE",
      url : "/user/" + id,
      dataType:"json"
      }).done(function (res) {
        alert("회원 탈퇴 완료되었습니다.");
        location.href="/";
      }).fail(function (error){
        alert("회원 탈퇴 실패되었습니다.");
      });
  }

};

index.init();