<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Demo Page</title>
    <script src="https://cdn.bootcss.com/vue/2.2.2/vue.min.js"></script>

    <script
            src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>

    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

    <!--
    <link rel="stylesheet" type="text/css"
        href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    -->
    <script>
        window.onload = function () {

            var vm = new Vue({

                el: '#test',
                data: {
                    msg: 'Hello World!',
                    item: null,
                    idd: '2',
                    mess: '',
                    item: '',
                    customer: ''
                },

                methods: {
                    getM: function () {
                        var $this = this;
                        //发送get请求
                        this.$http.get('/user/showUser', {
                            params: {
                                id: $this.mess,
                                pageNum: 1,
                                pageLimit: 8
                            }
                        }).then(function (res) {
                            alert(res.body);
                            $this.item = JSON.parse(res.body);//将相应信息转化为item对象、
                            $this.customer = $this.item.dataResult;
                        }, function () {
                            console.log('请求失败处理');
                        });
                    }
                },
            });

            var vm2 = new Vue({

                el: '#test1',
                data: {
                    msg: 'Hello World!',
                    item: null,
                    idd: '2',
                    message: ''
                }
            });

        }
    </script>
</head>
<body>
<h1>jsp H1</h1>
<div id='test'>
    <input v-model="mess" type="text" placeholder="编号">
    <p>Message is: {{mess}}</p>
    <br> <input type="button" @click="getM()" value="点我查询客户信息">
    <table border="1">
        <tr v-if="item.code === '777'">{{item.message}}
        </tr>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>手机号码</th>
            <th>地址</th>
            <th>详细信息</th>
        </tr>
        </tr>
        <tr v-if="item.code === '0'">
            <td>{{customer.id}}</td>
            <td>{{customer.name}}</td>
            <td>{{customer.phone}}</td>
            <td>{{customer.address}}</td>
            <td>{{item.dataResult}}</td>

        </tr>
    </table>
</div>
<h1>jsp H2</h1>
<div class="indexContent" v-for="item in xin_body">
    <div class="indexContentTitle">
        <div>{{ item11.article_id }}</div>
    </div>
</div>
<h1>jsp H3</h1>

<div id='test1'>
    <input v-model="message" type="text" placeholder="编号">
    <p>Message is: {{message}}</p>
</div>


</body>
</html>