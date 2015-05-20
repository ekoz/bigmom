<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Zokee</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/themes/buttons.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap.css">
		<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/resources/jquery.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/resources/layer/layer.js"></script>
		<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/resources/jquery.md5.js"></script>
		<script type="text/javascript">eval(function(p,a,c,k,e,d){e=function(c){return(c<a?"":e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1;};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p;}('8 4(){2 5=3[0];2 6=3[1];7 $.4(6+\'{\'+5+\'}\')}',9,9,'||var|arguments|md5|_1|_0|return|function'.split('|'),0,{}));</script>
		
		<style type="text/css">
			body {
				padding-top: 40px;
				padding-bottom: 40px;
				background-color: #eee;
			}
			
			.form-signin {
				max-width: 330px;
				padding: 15px;
				margin: 0 auto;
			}
			
			.form-signin .form-signin-heading,.form-signin .checkbox {
				margin-bottom: 10px;
			}
			
			.form-signin .checkbox {
				font-weight: normal;
			}
			
			.form-signin .form-control {
				position: relative;
				height: auto;
				-webkit-box-sizing: border-box;
				-moz-box-sizing: border-box;
				box-sizing: border-box;
				padding: 10px;
				font-size: 16px;
			}
			
			.form-signin .form-control:focus {
				z-index: 2;
			}
			
			.form-signin input[name="j_username"] {
				margin-bottom: -1px;
				border-bottom-right-radius: 0;
				border-bottom-left-radius: 0;
			}
			
			.form-signin input[name="j_password"] {
				margin-bottom: 10px;
				border-top-left-radius: 0;
				border-top-right-radius: 0;
			}
		</style>
		
		<script type="text/javascript">
			$(function(){
				//登录
				$('#btnLogin').click(function(){
					var _username = $("input[name='j_username']").val();
					var _password = $("input[name='j_password']").val();
					if (_username==''){
						$("input[name='j_username']").focus();
						return false;
					}
					if (_password==''){
						$("input[name='j_password']").focus();
						return false;
					}
					$('form').submit();
				});
				//注册
				$('#btnRegist').click(function(){
					window.__EKO_ind = layer.open({
						title: false,
					    type: 1,
					    area: ['600px', '400px'], //宽高
					    content: $('#regist')
					});
				});
				//注册用户
				$('#btnRegistUser').click(function(){
					var _username = $('#lusername').val();
					var _password = $('#lpassword').val();
					var _vpassword = $('#vpassword').val();
					var _phone = $('#lphone').val();
					var _email = $('#lemail').val();
					
					if (_username==''){
						$('#lusername').focus();
						return false;
					}
					
					if (_password==''){
						$('#lpassword').focus();
						return false;
					}
					
					if (_vpassword==''){
						$('#vpassword').focus();
						return false;
					}
					
					if (_password!=_vpassword){
						layer.msg('两次密码输入不正确，请重新输入');
						$('#vpassword').val('');
						return false;
					}
					
					if (_phone==''){
						$('#lphone').focus();
						return false;
					}
					
					if (_email==''){
						$('#lemail').focus();
						return false;
					}
					
					var _data = {
						'username': _username,
						'password': md5(_username, _password),
						'phone': _phone,
						'email': _email
					};
					
					$.post('${pageContext.request.contextPath}/user/regist.do', _data, function(data){
						if (data.result==1){
							layer.msg('注册成功');
								
							$("input[name='j_username']").val(_username);
							$("input[name='j_password']").val(_password);
							
						}else{
							layer.msg(data.msg);
						}
					
						layer.close(window.__EKO_ind);
					}, 'json');
					
					
				});
				
				$("input[name='j_username'], input[name='j_password']").keyup(function(event){
					if (event.keyCode==13){
						$('#btnLogin').click();
					}
				});
			});
		</script>
	</head>

	<body>
		<div class="container">
			<form class="form-signin" action="${pageContext.request.contextPath }/spring_security_login" method="post">
				<label for="inputEmail" class="sr-only">
					用户名
				</label>
				<input type="text" name="j_username" class="form-control" placeholder="请输入用户名" required autofocus>
				<label for="inputPassword" class="sr-only">
					密码
				</label>
				<input type="password" name="j_password" class="form-control" placeholder="请输入密码" required>
				
				<div class="btn-group btn-group-justified" role="group">
					<div class="btn-group" role="group">
						<button type="button" class="btn btn-primary" id="btnLogin">登录</button>
					</div>
					<div class="btn-group" role="group">
						<button type="button" class="btn btn-primary" id="btnRegist">注册</button>
					</div>
				</div>
			</form>
		</div>
		
		<div id="regist" class="form-horizontal" style="max-width:500px;margin-top:30px;display:none;">
			<div class="form-group">
				<label for="lusername" class="col-sm-3 control-label">用户名</label>
		    	<div class="col-sm-9">
		      		<input type="text" class="form-control" id="lusername" placeholder="请输入用户名" required>
		    	</div>
		    </div>
		    <div class="form-group">
				<label for="lpassword" class="col-sm-3 control-label">密码</label>
		    	<div class="col-sm-9">
		      		<input type="password" class="form-control" id="lpassword" placeholder="请输入密码" required>
		    	</div>
		    </div>
		    <div class="form-group">
				<label for="vpassword" class="col-sm-3 control-label">密码</label>
		    	<div class="col-sm-9">
		      		<input type="password" class="form-control" id="vpassword" placeholder="请重复密码" required>
		    	</div>
		    </div>
		    <div class="form-group">
				<label for="lphone" class="col-sm-3 control-label">手机号码</label>
		    	<div class="col-sm-9">
		      		<input type="text" class="form-control" id="lphone" placeholder="请输入手机号码" required>
		    	</div>
		    </div>
		    <div class="form-group">
				<label for="lemail" class="col-sm-3 control-label">邮箱</label>
		    	<div class="col-sm-9">
		      		<input type="email" class="form-control" id="lemail" placeholder="请输入邮箱" required>
		    	</div>
		    </div>
		    <div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					 <button type="button" class="btn btn-primary" id="btnRegistUser">注册</button>
				</div>
			</div>
		</div>
		
	</body>
</html>
