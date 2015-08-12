<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="/resources/head.jsp" flush="true" />
		<script type="text/javascript">
			$(function(){
				//如果当前用户分享数超过20
				var _shareCount = 19;
				if (_shareCount>=20){
					$('#forbidSell').attr('title', '');
					$('#btnSeller').removeClass('disabled');
				}else{
					$('#forbidSell').attr('title', '分享超过20个商品后才能使用, 你还需分享 ' + (20-_shareCount) + ' 个商品');
					$('#forbidSell').tooltip();
				}
				
				$('#btnVender').click(function(){
					location.href = SystemKeys.contextPath + "/vender/view.do";
				});
				$('#btnSeller').click(function(){
					location.href = SystemKeys.contextPath + "/seller/view.do";
				});
				$('#btnPiazza').click(function(){
					location.href = SystemKeys.contextPath + "/piazza/view.do";
				});
			});
		</script>
	</head>

	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-right">
					<a href="javascript:void(0)"><small>个人中心</small></a>
					|
					<a href="${pageContext.request.contextPath }/spring_security_logout"><small>登出</small></a>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12">
					<div class="page-header">
						<h2>欢迎你 <small>${sessionScope.CURRENTUSER.userinfo.username }</small></h2>
					</div>						
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12 column">
					<div class="carousel slide" id="carousel-588983">
						<ol class="carousel-indicators">
							<li class="active" data-slide-to="0" data-target="#carousel-588983">
							</li>
							<li data-slide-to="1" data-target="#carousel-588983">
							</li>
							<li data-slide-to="2" data-target="#carousel-588983">
							</li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img alt="" src="${pageContext.request.contextPath }/resources/themes/images/1.jpg" />
								<div class="carousel-caption">
									<h4>
										First Thumbnail label
									</h4>
									<p>
										Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="${pageContext.request.contextPath }/resources/themes/images/2.jpg" />
								<div class="carousel-caption">
									<h4>
										Second Thumbnail label
									</h4>
									<p>
										Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="${pageContext.request.contextPath }/resources/themes/images/3.jpg" />
								<div class="carousel-caption">
									<h4>
										Third Thumbnail label
									</h4>
									<p>
										Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
									</p>
								</div> 
							</div>
						</div> 
						<a class="left carousel-control" href="#carousel-588983" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> 
						<a class="right carousel-control" href="#carousel-588983" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
					</div>
				</div>
			</div>
			
			<div class="row" style="margin-top:20px;">
				<div class="page-footer">
					<div class="col-md-5 text-center">
						<input class="btn btn-default btn-info" type="button" id="btnVender" value="我是厂商">
					</div>
					<div class="col-md-2 text-center">
						<div id="forbidSell" data-toggle="tooltip" data-placement="top">
							<button class="btn btn-default btn-info disabled" id="btnSeller">我是卖家</button>
						</div>
					</div>
					<div class="col-md-5 text-center">
						<input class="btn btn-default btn-info" type="button" id="btnPiazza" value="购物中心">
					</div>
				</div>
			</div>
			
		</div>
	</body>
</html>
