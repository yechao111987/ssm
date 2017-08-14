<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/vue/2.2.2/vue.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>
<script>
	window.onload = function() {

		var vm = new Vue({

			el : '#test',
			data : {
				msg : 'Hello World!',
				item : ''
			},
			methods : {
				get : function() {
					//发送get请求
					this.$http.get('/ssm/user/showUser1', {
						params : {
							id : "1",
							pageNum : 1,
							pageLimit : 8
						}
					}).then(function(res) {
						//alert(res.body);
						this.$set('item', res.body);
					}, function() {
						console.log('请求失败处理');
					});
				}
			},
			data : {
				item : ''
			},

		});

	}
</script>
</head>
<body>
	<h1>jsp H1</h1>
	<div id='test'>
		<input type="button" @click="get()" value="按钮">
		<p>aa</p>
		<p>{{item.name}}</p>
	</div>
	<h1>jsp H2</h1>
	<div class="indexContent" v-for="item in xin_body">
		<div class="indexContentTitle">
			<div>{{ item11.article_id }}</div>
		</div>
	</div>


</body>
</html>