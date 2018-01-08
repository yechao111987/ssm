<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表页</title>
<script src="https://cdn.bootcss.com/vue/2.2.2/vue.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
		/* 		var vm = new Vue({
		 el : '#box',
		 data : {
		 msg : 'Hello World!',
		 },
		 methods : {
		 get : function() {
		 //发送get请求
		 this.$http.get('/ssm/user/list4').then(function(res) {
		 alert(res.body);
		 }, function() {
		 console.log('请求失败处理');
		 });
		 }
		 }
		 }); */
		var vm1 = new Vue({
			el : '#box1',
			data : {
				msg : 'Hello World!111',
			},
			methods : {
				get : function() {
					//发送get请求
					this.$http.get('/ssm/user/showUser', {
						id : 2,
						b : 2
					}).then(function(res) {
						alert(res.body);
					}, function(res) {
						console.log(res.status);
					});
				}
			}
		});
		var vm2 = new Vue({
			el : '#box2',
			data : {
				msg : 'Hello World!111',
			},
			methods : {
				get2 : function() {
					//发送get请求
					this.$http.get('/ssm/user/showUser1', {
						'id' : 2
					}).then(function(res) {
						alert(res.body);
					}, function(res) {
						//console.log(res.status);
						console.log('1111');
					});
				}
			}
		});
	}
</script>
<%--<script type="text/javascript">--%>
<%--new Vue({--%>
    <%--ready: function () {--%>
        <%--// POST请求--%>
        <%--this.$http({--%>
            <%--url: '',--%>
            <%--method: 'get',--%>
            <%--// 请求体重发送的数据--%>
            <%--data: {--%>
                <%--cat: 1--%>
            <%--},--%>
            <%--// 设置请求头--%>
            <%--headers: {--%>
                <%--'Content-Type': 'x-www-from-urlencoded'--%>
            <%--}--%>
        <%--}).then(function () {--%>
            <%--// 请求成功回调--%>
        <%--}, function () {--%>
            <%--// 请求失败回调--%>
        <%--});--%>
    <%--}})--%>
<%--</script>--%>



</head>
<body>
	<h1>Hello Baby!</h1>
	<h2>This is List Page</h2>
	${yechao}
	<div id="list">
		<form action="showUser">
			<input type="text" v-model="info"> <input type="submit"
				value="submit">
			<p>{{info}}</p>
		</form>
		<a href="showUser?id=1111">A标签</a> <a v-bind:href="info">B标签</a>
	</div>
	</div>
	<div id="box">
		<input type="button" @click="get()" value="按钮">
	</div>

	<div id="box1">
		<input type="button" @click="get()" value="按钮1">
	</div>

	<div id="box2">
		<input type="button" @click="get2()" value="按钮2">
	</div>

	<h1>part Two</h1>
	<div>
		<ul>
			<li v-for="item in alllist" v-if="item.istop == false"><a
				v-link="{ name: 'getReceiptDetail',params:{knowledgeId: item.id }}">
					<div class='fl know-info'>
						<!-- | limit 和 | timer是filter 在后续会说到-->
						<!--字段含义: -->
						<p class='font-normal nomal-height'>{{item.title | limit 30 }}</p>
						<p class='co9a9a9a'>
							<span style='margin-right: 1rem;'>{{item.viewTimes}}K</span><span>{{item.publishTime
								| timer }}</span>
						</p>
						<!--viewTimes:有多少人查看 , publishTime:发布时间-->
					</div>
					<div class='fr know-img'>
						<img v-bind:src=item.coverImage />
					</div>
					<div class='clearfix'></div>
			</a></li>
	</div>





	<!--  
	<script>
		new Vue({
			el : '#list',
			data : {
				info : 'enter info',
			}
		})
	</script>
	-->
</body>
</html>