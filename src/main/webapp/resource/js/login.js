

$("#loginForm").form({
	url: realpath + '/login',
	 onSubmit :function() {
	var loginname = $.trim($("#loginname").val());
	var password = $.trim($("#password").val());
	if(loginname==null || loginname==''){
		$.messager.show({
			title: '提示',
			msg: '账号不可为空!',
			showType: 'slide',
		});
		return false;
	} 
	if(password==null || password==''){
		$.messager.show({
			title: '提示',
			msg: '密码不可为空!',
			showType: 'slide',
		});
		return false;
	} 
	 },
	success:function(data){
		data = $.parseJSON(data);
		 if (data.success) {
             window.location.href = realpath + '/index';
         }else{
             $.messager.show({
                 title:'提示',
                 msg:data.msg,
                 showType:'show'
             });
         }
		}
});

$("body").keyup(function(event) {
	 if (event.keyCode == 13){
         event.returnValue=false;
         event.cancel = true;
         $('#loginForm').submit();
     }
    });


