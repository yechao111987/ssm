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
</head>
<body id="app" v-cloak>
	<h1>111111111</h1>
	<p>{{item.name}}</p>
	<script type="text/javascript">
		//var urlRode = 'coJs/vue.json';
		var app = new Vue({
			el : "#app",
			ready : function() {
				var thi=this;
				this.$http.get('/ssm/user/showUser1', {
					params : {
						id : "1",
						pageNum : 1,
						pageLimit : 8
					}
				}).then(function(response) {
					alert(response.body);
					thi.$set('item', response.body);
				}, function(data, status, request) {
					console.log('fail' + status + "," + request);
				});
			},
			data : {
				item : ''
			},
			methods : {

			}
		})
	</script>


</body>
</html>