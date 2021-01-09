package cn.laochou.common;

/**
 * 发送信息的格式
 */
public interface MessageFormat {


    String MESSAGE_SEPARATOR = ":";

    // 发送消息的格式
    // %s 身份(使用代号)
    // %s 消息体
    String MESSAGE_FORMAT = "%s" + MESSAGE_SEPARATOR + "%s";


}
