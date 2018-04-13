$(function(){
})
vue_app = new Vue({
	el: "#vue-app",
	data: {
		showPage: 0, // 显示页面，0：登录页面，1：账户首页
		cardNumber: "6228481174357860016",
		passwd: "123456"
	},
	methods: {
		sign_in: function() {
			$.ajax({
				type: "post",
				dataType: "json",
				url: server + "/sign_in",
				xhrFields: {withCredentials: true},
			    crossDomain: true,
				data: {
					ATM_ID: ATM_ID,
					cardNumber: this.cardNumber,
					passwd: this.passwd
				},
				success: function(data) {
					console.log(data.code);
					console.log(data.msg)
				}
			});
		},
		logout: function(){
			$.ajax({
				url: server + "/logout",
				type: "get",
				dataType: "json",
				xhrFields: {withCredentials: true},
			    crossDomain: true,
				success: function(data) {
					
				}
			})
		},
		testRq: function(){
			$.ajax({
				url: server + "/test",
				type: "get",
				dataType: "json",
				jsonpCallback: function(data){
					console.log(data);
				},
 				xhrFields: {withCredentials: true},
 			    crossDomain: true,
			   /*headers:{
		            "X-Requested-With":"XMLHttpRequest"
		        },*/
				success: function(data) {
					console.log(data);
				}
			})
		}
	}
});