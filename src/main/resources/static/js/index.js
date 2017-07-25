var name;
$(".configSwitch").click(function() {
	$.ajax({
		type : "post",
		cache : false,
		async : true,
		dataType : "json",
		url : '/config-switch',
		data : {
			name : this.name,
			value : this.value
		},
		success : function(data) {
			if (data.status == 200) {
				swal({
					title : "操作成功",
					text : data.message,
					showCancelButton : false,
					closeOnConfirm : true,
					confirmButtonText : "OK",
					confirmButtonColor : "#ec6c62"
				}, function() {
					window.location.reload();
				});
			} else {
				swal({
					title : "操作失败",
					text : data.message
				});
			}
		},
		error : function() {
			console.log('出错了')
		}
	})
});
$('.configModify').click(function() {
	name = this.name;
	$('#configCount').val(this.value);
})
function editConfig() {
	var count = $('#configCount').val();
	$.ajax({
		type : "post",
		cache : false,
		async : true,
		dataType : "json",
		url : '/config-modify',
		data : {
			name : name,
			value : count
		},
		success : function(data) {
			if (data.status == 200) {
				$("#editConfigModal").modal('hide');
				swal({
					title : "配置数量修改成功",
					showCancelButton : false,
					closeOnConfirm : true,
					confirmButtonText : "OK",
					confirmButtonColor : "#ec6c62"
				}, function() {
					window.location.reload();
				});
			} else {
				swal({
					title : "配置数量修改失败",
					text : data.message
				});
			}

		},
		error : function() {
			console.log('出错了')
		}
	})
	return false;
}