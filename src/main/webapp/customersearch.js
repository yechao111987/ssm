window.onload = function () {
    var vm = new Vue({
        el: '#test',
        data: {
            msg: 'Hello World!',
            item: null,
            idd: '2',
            mess: '',
            item: '',
            customer: '',
            caddress: '',
            message: '',
        },
        methods: {
            updateCustomer: function () {
                var cadress = document.getElementById("caddress").value
                console.info("address:" + cadress);
                var cname = document.getElementById("cname").value
                console.info("name:" + cname);
                var cphone = document.getElementById("cphone").value
                console.info("phoen:" + cphone);
                var cid = document.getElementById("cid").value
                console.info("id:" + cid);
                axios.get('/customer/updateCustomer', {
                    params: {
                        id: cid,
                        name: cname,
                        address: cadress,
                        phone: cphone
                    }
                }).then(function (response) {
                    console.info(response.data);
                    if (response.data.code == '0') {
                        // alert("客户修改成功！");
                        console.info("客户修改成功！");
                    } else {
                        alert("修改失败");
                    }
                }, function (reason) {
                    console.error(reason);
                    console.error("请求错误");
                })
            },
            deleteCustomer: function () {
                var cid = document.getElementById("cid").value;
                console.info("id:" + cid);
                axios.get('/customer/delete', {
                    params: {
                        id: cid,
                    }
                }).then(function (response) {
                    console.info(response.data);
                    if (response.data.code == '0') {
                        alert("客户删除成功！");
                    }
                }, function (reason) {
                    console.error(reason);
                    console.error("请求错误");
                })
            },
            getM: function () {
                var $this = this;
                //发送get请求
                axios.get('/customer/showCustomer', {
                    params: {
                        id: this.mess,
                    }
                }).then(function (res) {
                    alert(res.data);
                    console.info(res.data);
                    $this.item = res.data;//将相应信息转化为item对象
                    console.info($this.item);
                    $this.customer = $this.item.dataResult;
                    console.info($this.customer);
                    if (null != $this.customer) {
                        console.info($this.customer.message);
                    }
                    $this.message = res.data.message;
                    console.info($this.mess);
                }, function () {
                    console.log('请求失败处理');
                });
            }
        },
    });
}