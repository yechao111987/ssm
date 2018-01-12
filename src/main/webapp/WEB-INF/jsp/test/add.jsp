<%--
  Created by IntelliJ IDEA.
  User: yechao
  Date: 2018/1/8
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Customer</title>
    <script src="https://cdn.bootcss.com/vue/2.2.2/vue.min.js"></script>

    <script
            src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>

    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script>
        window.onload = function () {
            var vm = new Vue({
                    el: '#add',
                    data: {
                        msg: 'Hello World!',
                        item: null,
                        name: '',
                        address: '',
                        phone: '',
                        item: '',
                        customer: ''
                    },

                    methods: {
                        getM: function () {
                            var $this = this;
                            //发送get请求
                            this.$http.get('/customer/addCustomer', {
                                params: {
                                    name: $this.name,
                                    address: $this.address,
                                    phone: $this.phone
                                }
                            }).then(function (res) {
                                alert(res.body);
                                console.error(res)
;                                $this.item = JSON.parse(res.body);//将相应信息转化为item对象、
                            }, function () {
                                console.log('请求失败处理');
                            });
                        },
                        getP: function () {
                            var $this = this;
                            //发送get请求
                            this.$http.post('/customer/addCustomerByPost', {
                                params: {
                                    name: $this.name,
                                    address: $this.address,
                                    phone: $this.phone
                                }
                            }).then(function (res) {
                                alert(res.body);
                                $this.item = JSON.parse(res.body);//将相应信息转化为item对象、
                            }, function () {
                                console.log('请求失败处理');
                            });
                        },
                        getPost: function () {
                            var $this = this;
                            //发送get请求
                            this.$http.post('/customer/addCustomerByPost', {
                                name: $this.name,
                                address: $this.address,
                                phone: $this.phone

                            }).then(function (res) {
                                alert(res.body);
                                $this.item = JSON.parse(res.body);//将相应信息转化为item对象、
                            }, function () {
                                console.log('请求失败处理');
                            });
                        }

                    },
                }
                )
            ;
        }


    </script>
</head>
<body>
<h1>ADD Customer</h1>
<div id='add'>
    <input v-model="name" type="text" placeholder="用户姓名">
    <br>
    <input v-model="address" type="text" placeholder="地址">
    <br>
    <input v-model="phone" type="text" placeholder="电话号码">
    <br> <input type="button" @click="getPost()" value="点我新增客户">
    <br><a href="/demo" >去客户列表页面</a>

</div>

</body>
</html>
