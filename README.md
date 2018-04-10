# 注意
* 忽略上传target目录和log目录
* 如果用google-Chrome调试，为了解决以下问题[stackoverflow](https://stackoverflow.com/questions/8456538/origin-null-is-not-allowed-by-access-control-allow-origin) or [csdn](https://blog.csdn.net/dandanzmc/article/details/31344267/)
	```Origin null is not allowed by Access-Control-Allow-Origin```
	请在启动Chrome之前，加上选项``--allow-file-access-from-files``，FireFox不需要;
	Linux在启动命令行后带上选项即可
