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
				xhrFields: {withCredentials: true},
			    crossDomain: true,
			   /* headers:{
		            "Access-Control-Allow-Headers":"X-Requested-With,If-Modified-Since,Pragma,Last-Modified,Cache-Control,Expires,Content-Type,X-E4M-With,userId,token",
		            "Content-Type" : "multipart/form-data,application/x-www-form-urlencoded; charset=UTF-8",
		            "X-Requested-With":"XMLHttpRequest"
		        },*/
				success: function(data) {
					console.log(data);
				}
			})
		}
	}
});