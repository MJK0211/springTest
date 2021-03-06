console.log("Reply Module......");

var replyService = (function() {

	function add(reply, callback, error) {
		console.log("add reply...............");

		$.ajax({
			type : 'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		})
	}

	function getList(param, callback, error) {

		var bno = param.bno;
		var page = param.page || 1;

		$.getJSON("/replies/pages/" + bno + "/" + page + ".json",
				function(data) {

					if (callback) {
						// callback(data); // 댓글 목록만 가져오는 경우
						callback(data.replyCnt, data.list); // 댓글 숫자와 목록을 가져오는
															// 경우
					}
				}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}

	return {
		add : add,
		getList : getList
	};
})();