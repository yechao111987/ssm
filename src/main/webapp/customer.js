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
                    console.info(res);
                    $this.item = res.data;//将相应信息转化为item对象、
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
            customers: ',',
            pageInfo: ''
        },
        methods: {
            getList: function () {
                var $this = this;
                //发送get请求
                axios.get('/customer/list', {
                    params: {
                        current: 1,
                        size: 2,
                    }
                }).then(function (res) {
                    console.info(res);
                    // console.info(JSON.parse(res.body));
                    console.info(res.data);
                    $this.resp = res.data;
                    $this.customers = res.data.list;
                    console.info($this.resp);
                }, function (reason) {
                    console.error(reason.body);
                    console.error("处理失败！");
                })
            }

        }

    });


}




