package group.six.atm.utils;

/**
 * 业务异常代码
 */
public interface BusCode {
	/**
	 * 未登录
	 */
    int NOT_LOGIN = 401;
    /**
     * 未授权
     */
    int NOT_AUTHORIZATION = 403;
	/**
     * 未知异常，请联系管理员
     */
    int ERR_UNKONWN = 500;

    /**
     * 存款失败
     */
    int DESPOSIT_ERR = 1000;
    
    /**
     * 取款失败
     */
    int WITHDRAW_ERR = 1001;
    
    /**
     * 转账失败
     */
    int TRANSFER_ERR = 1002;
    
    /**
     * 修改信息失败
     */
    int MODIFY_ERR = 1003;
}
