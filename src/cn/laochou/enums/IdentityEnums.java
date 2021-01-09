package cn.laochou.enums;

/**
 * 身份信息枚举
 */
public enum  IdentityEnums {

    NOT_EXIST("0", "不存在"),
    PC("1", "个人电脑客户端"),
    PHONE("2", "手机客户端"),
    SERVER("3", "服务器");

    String code;
    String message;

    IdentityEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
