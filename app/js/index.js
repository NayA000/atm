$(function(){
})
vue_app = new Vue({
	el: "#vue-app",
	data: {
		showPage: 0, // 显示页面，0：登录页面，1：账户首页
		cardNumber: "",
		passwd: ""
	},
	methods: {
		sign_in: function() {
			console.log(server + "/sign_in")
			$.ajax({
				type: "post",
				dataType: "json",
				url: server + "/sign_in",
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