// import axios from 'axios.min.js'
// Vue.prototype.$ajax = axios
Vue.config.debug = true

window.onload = function () {
    var vm1 = new Vue({
        el: '#register',
        data: {
            msg: 'Hello World!',
            item: null,
            name: '',
            password: '',
            phone: '',
            address: '',
            message: ''
        },

        methods: {
            register: function () {
                var $this = this;
                var md5hash;
                if (this.password!==null && this.password!=='' && this.password!==undefined){
                    md5hash = md5(this.password);
                    console.log(md5hash);
                }else{
                    alert("password为空")
                }
                //发送get请求
                axios.get('/user/register', {
                    params: {
                        name: $this.name,
                        password: md5hash,
                        phone: $this.phone,
                        address: $this.address
                    }
                }).then(function (res) {
                    console.info(res);
                    // alert(res.request.status);
                    console.info("响应code：" + res.request.status);
                    // $this.item = JSON.parse(res.data);//将相应信息转化为item对象
                    if (res.data.code == "0") {
                        alert("注册用户成功");
                    } else {
                        console.info(res.data.message);
                        $this.message = res.data.message;
                    }
                    // console.info(JSON.parse(res.data));
                    console.info(res.data);
                }, function () {
                    console.log('请求失败处理');
                    alert('请求处理失败：');
                    $this.message='请求处理失败';
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
