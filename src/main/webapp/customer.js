window.onload = function () {
    var vmlist = new Vue({
        el: '#list',
        data: {
            pageNum: '',
            resp: '',
            cur: '',
            customers: ',',
            pageInfo: '',
            mydata: [],
        },
        methods: {
            getList: function (page) {
                var $this = this;
                //发送get请求
                axios.get('/customer/list', {
                    params: {
                        current: page,
                        size: 10,
                    }
                }).then(function (res) {
                    console.info(res);
                    // console.info(JSON.parse(res.body));
                    console.info(res.data);
                    $this.resp = res.data.totalPage;
                    console.info('111' + res.data.totalPage);
                    $this.customers = res.data.list;
                    $this.cur = res.data.pageNum;
                    console.info("cur:"+$this.cur);
                }, function (reason) {
                    console.error(reason.body);
                    console.error("处理失败！");
                })
            },
            init: function () {
                this.getList(1);
            }

        }

    });
    Vue.component("page", {
        template: "#page1",
        data: {
            customers1: '',
        },
        props: ['current', 'showitem', 'allpage'],
        // watch: {
        //     "current": function (val, oldval) {
        //         this.$dispatch('page-to', val);
        //     }
        // },
        computed: {
            pages: function () {
                var pag = [];
                console.info('allpage' + this.allpage);
                console.info('current' + this.current);
                console.info('sbowitem' + this.showitem);
                if (this.current < this.showitem) { //如果当前的激活的项 小于要显示的条数
                    //总页数和要显示的条数那个大就显示多少条
                    var i = Math.min(this.showitem, this.allpage);
                    console.info(i);
                    while (i) {
                        pag.unshift(i--);
                    }
                } else { //当前页数大于显示页数了
                    var middle = this.current - Math.floor(this.showitem / 2),//从哪里开始
                        i = this.showitem;
                    if (middle > (this.allpage - this.showitem)) {
                        middle = (this.allpage - this.showitem) + 1
                    }
                    while (i--) {
                        pag.push(middle++);
                    }
                }
                return pag
            }
        },
        methods: {
            goto: function (index) {
                if (index == this.current) return;
                console.info("当前的index：" + index);
                this.current = index;
                // vmlist.current = index;
                // vmlist.current = index;
                console.info("当前的：" + this.current);
                //这里可以发送ajax请求
                axios.get("customer/list", {
                    params: {
                        current: index,
                        size: 10,
                    }
                }).then(function (res) {
                    console.info(res);
                    console.info(res.data);
                    // vmlist.customers = res.data.list;
                    vmlist.customers = res.data.list;
                    // console.info(customers);
                })
            }
        }
    });


    vmlist.init();


}




