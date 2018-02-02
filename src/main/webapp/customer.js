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
                axios.get('/customer/showCustomer', {
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

    var vmlist = new Vue({
        el: '#list',
        data: {
            pageNum: '',
            resp: '',
            customer: ''
        },
        computed: {
            getList: function () {
                var $this = this;
                //发送get请求
                axios.get('/customer/list', {
                    params: {
                        current: 1,
                        size: 2,
                    }
                }).then(function (res) {
                    $this.resp = res.body;
                    $this.customer = res.body.dataResult;
                    console.info(res.body);
                }, function (reason) {
                    console.error(reason.body);
                    console.error("处理失败！");
                })
            }

        }

    });


}




