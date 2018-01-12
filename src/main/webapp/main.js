// import axios from 'axios.min.js'
// Vue.prototype.$ajax = axios
Vue.config.debug = true

window.onload = function () {
    var vm1 = new Vue({
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
                axios.get('/customer/addCustomer', {
                    params: {
                        name: $this.name,
                        address: $this.address,
                        phone: $this.phone
                    }
                }).then(function (res) {
                    console.info(res);
                    alert(res.request.status);
                    console.info("响应code："+res.request.status);
                    $this.item = JSON.parse(res.data.address);//将相应信息转化为item对象、
                    console.info(JSON.parse(res.data.id));
                }, function () {
                    console.log('请求失败处理');
                });
            }
        },
    });
}
