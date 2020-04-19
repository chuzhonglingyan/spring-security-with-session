new Vue({
    el: '#app',
    data: {
        loginUrl: baseURL+"auth/login",
        errors: [],
        userName: '',
        passWord: '',
        rememberMe: false,
        validate:{}
    },
    methods: {
        login: function () {
            if (this.validate.form()) {
                const params = $("#loginForm").serialize();
                postFormFull(this.loginUrl, params, function (data) {
                    console.debug("登录成功了");
                    top.location.href= baseURL+'index';
                }, function (msg) {
                    layer.msg(msg);
                });
            }
        },
        initValidForm() {
            return $("#loginForm").validate({
                rules: {
                    userName: {
                        required: true,
                        minlength: 2
                    },
                    passWord: {
                        required: true,
                        minlength: 6,
                        maxlength: 20
                    }
                },
                messages: {
                    username: {
                        required: "请输入用户名",
                        minlength: "用户名必需由两个字母组成"
                    },
                    passWord: {
                        required: "请输入密码",
                        minlength: "密码长度不能小于 6 个字符",
                        maxlength: "密码长度不能大于 20 个字符"
                    }
                }
            });
        }
    },
    mounted: function () {
        this.validate=this.initValidForm();
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        });
    }
});

