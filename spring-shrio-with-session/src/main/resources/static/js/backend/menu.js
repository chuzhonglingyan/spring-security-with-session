new Vue({
    el: '#app',
    data: {
        menuAddUrl: baseURL + "menu/add",
        errors: [],
        validate: {}
    },
    methods: {
        addMenu: function () {
            const params = $("#addForm").serialize();
            postFormFull(this.menuAddUrl, params, function (data) {
                console.debug("新增成功");
            }, function (msg) {
                layer.msg(msg);
            });
        },
    },
    mounted: function () {

    }
});

