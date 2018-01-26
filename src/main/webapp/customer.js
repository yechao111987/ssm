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
                this.$http.get('/customer/showCustomer', {
                    params: {
                        id: $this.mess,
                        pageNum: 1,
                        pageLimit: 8
                    }
                }).then(function (res) {
                    $this.item = JSON.parse(res.body);//将相应信息转化为item对象、
                    $this.customer = $this.item.dataResult;
                }, function () {
                    console.log('请求失败处理');
                });
            }
        },
    });
}

