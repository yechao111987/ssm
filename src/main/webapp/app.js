const vm = new Vue({
    el: '#app',
    data: {
        results: []
    },
    mounted() {
        axios.get("http://localhost:8080/customer/showCustomer?id=2&pageNum=1&pageLimit=8")
            .then(response = > {
            alert(response.body);
        this.results = response.data.results;
    })
    }
});

/* 开启错误提示 */
Vue.config.debug = true