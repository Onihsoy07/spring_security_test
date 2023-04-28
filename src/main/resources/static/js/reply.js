document.getElementById("comment").addEventListener('click', saveReply);

function saveReply() {

    let data = {
      comment: $("#comment").val()
    };

    alert("aaaaaaa");

    $.ajax({
      type : "POST",
      url : "/api/reply",
      contentType: "application/json;charset=utf-8",
      dataType:"json",
      data : JSON.stringify(data)
      }).done(function (res) {
        alert("댓글 쓰기 완료");
      }).fail(function (error){
        alert("댓글 쓰기 실패");
      });
  }

}

//  saveReply: function() {
//    let data = {
//      comment: $("#comment").val()
//    };
//
//    alert("aaaaaaa");
//
//    $.ajax({
//      type : "POST",
//      url : "/api/reply",
//      contentType: "application/json;charset=utf-8",
//      dataType:"json",
//      data : JSON.stringify(data)
//      }).done(function (res) {
//        alert("댓글 쓰기 완료");
//      }).fail(function (error){
//        alert("댓글 쓰기 실패");
//      });
//  }
//
//};
//
//index.initR();