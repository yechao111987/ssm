// import axios from 'axios.min.js'
// Vue.prototype.$ajax = axios
Vue.config.debug = true

window.onload = function () {
    var vm1 = new Vue({
        el: '#login',
        data: {
            msg: 'Hello World!',
            item: null,
            name: '',
            password: '',
            message: ''
        },

        methods: {
            login: function () {
                var $this = this;
                //发送get请求
                axios.get('/user/login', {
                    params: {
                        name: $this.name,
                        password: $this.password,
                    }
                }).then(function (res) {
                    console.info(res);
                    alert(res.request.status);
                    console.info("响应code：" + res.request.status);
                    // $this.item = JSON.parse(res.data);//将相应信息转化为item对象
                    if (res.data.code == "1") {
                        window.location.href = "/user";
                    } else {
                        $this.message = res.data.message;
                    }
                    console.info(JSON.parse(res.data.id));
                }, function () {
                    console.log('请求失败处理');
                });
            }
        }
    });
}

function aa() {
    //js提交
    $("#jsBtn").click(function () {
        document.myform.action = "RegisterAction.action";
        document.myform.onsubmit;
    })
}

function sumbitTest() {
    return true; //return false则不会提交
}
