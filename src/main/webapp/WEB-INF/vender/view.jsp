<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="/resources/head.jsp" flush="true" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/ztree/css/metroStyle/metroStyle.css">
		<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/resources/ztree/js/jquery.ztree.all-3.5.min.js"></script>
		<script type="text/javascript">
			var cateSetting = {
				view: {
					selectedMulti: false
				},
				async: {
					enable: true,
					url:"${pageContext.request.contextPath}/cate/getnodes.do",
					autoParam:["id", "name=n", "level=lv"]
				},
				callback: {
					
				}
			};
			
			$(function(){
				$.fn.zTree.init($("#catetree"), cateSetting);
				
				$('#btnPublish').click(function(){
					window.__EKO_ind = layer.open({
						title: false,
					    type: 1,
					    area: ['800px', '480px'], //宽高
					    content: $('#wareinfo')
					});
				});
			});
		</script>
	</head>

	<body>
		<div class="container" style="padding-top:10px;">
			<div class="row">
				<div class="col-md-12 column">
					<div class="btn-group">
						<button class="btn btn-primary" type="button" id="btnPublish">发布产品</button>
						<!-- 
						<button class="btn btn-default" type="button"><em>按钮2</em></button>
						<button class="btn btn-default" type="button"><em>按钮3</em></button>
						 -->
					</div>
				</div>
			</div>
			
			<div class="row">
				<table class="table">
					<thead>
						<tr><th></th></tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			
			
		</div>
		
		<!-- 商品信息输入框 -->
		<div id="wareinfo" class="container" style="width:800px;padding-top:15px;display:none;">
			<div class="row">
				<div class="col-md-4 column">
					<div id="catetree" class="ztree" style="height:400px;border:1px solid #CCC;overflow:auto;"></div>
				</div>
				<div class="col-md-8 column">
					<div class="form-horizontal">
						<div class="form-group">
							<label for="lusername" class="col-sm-3 control-label">名称</label>
					    	<div class="col-sm-9">
					      		<input type="text" class="form-control" id="lusername" placeholder="请输入商品名称" required>
					    	</div>
					    </div>
					    <div class="form-group">
							<label for="lusername" class="col-sm-3 control-label">规格</label>
					    	<div class="col-sm-9">
					      		<input type="text" class="form-control" id="lusername" placeholder="请输入商品规格" required>
					    	</div>
					    </div>
					    <div class="form-group">
							<label for="lusername" class="col-sm-3 control-label">卖点</label>
					    	<div class="col-sm-9">
					      		<input type="text" class="form-control" id="lusername" placeholder="请输入商品卖点" required>
					    	</div>
					    </div>
					    <div class="form-group">
							<label for="lusername" class="col-sm-3 control-label">描述</label>
					    	<div class="col-sm-9">
					      		<input type="text" class="form-control" id="lusername" placeholder="请输入商品描述" required>
					    	</div>
					    </div>
					    <div class="form-group">
							<label for="lusername" class="col-sm-3 control-label">货号</label>
					    	<div class="col-sm-9">
					      		<input type="text" class="form-control" id="lusername" placeholder="请输入货号" required>
					    	</div>
					    </div>
					    <div class="form-group">
							<label for="lusername" class="col-sm-3 control-label">品牌</label>
					    	<div class="col-sm-9">
					      		<input type="text" class="form-control" id="lusername" placeholder="请输入品牌" required>
					    	</div>
					    </div>
					    <div class="form-group">
							<label for="lusername" class="col-sm-3 control-label">库存</label>
					    	<div class="col-sm-9">
					      		<input type="text" class="form-control" id="lusername" placeholder="请输入库存" required>
					    	</div>
					    </div>
					    <div class="form-group">
							<label for="lusername" class="col-sm-3 control-label">一口价</label>
					    	<div class="col-sm-9">
					      		<input type="text" class="form-control" id="lusername" placeholder="请输入价格" required>
					    	</div>
					    </div>
					    <div class="form-group">
					    	<div class="col-sm-offset-3 col-sm-9">
					    		<button type="button" class="btn btn-primary">发布</button>
					    	</div>
					    </div>
					</div>
				</div>
			</div>
		</div>
		<!-- 商品信息输入框 -->
		
	</body>
</html>