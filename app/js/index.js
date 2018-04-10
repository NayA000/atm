vue_app = new Vue({
	el: "#vue-app",
	data: {
		showPage: 1, // 显示页面，0：登录页面，1：账户首页
		cardNumber: "",
		passwd: ""
	},
	methods: {
		login: function() {
			$.ajax({
				type: "post",
				url: server + "sign_in",
				data: {
					ATM_ID: ATM_ID,
					cardNumber: this.cardNumber,
					passwd: this.passwd
				},
				success: function(data) {
					console.log(data);
				}
			});
		}
	}
});