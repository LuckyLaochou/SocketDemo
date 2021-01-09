package cn.laochou.common;

import cn.laochou.enums.IdentityEnums;

// 定义一些常量
public interface Const {

    String ASSUME_FIRST_MESSAGE = String.format(MessageFormat.MESSAGE_FORMAT,
            IdentityEnums.SERVER.getCode(),  "已开启");

    String IPAD_FIRST_MESSAGE = "我是Ipad，呼叫服务器";

    String COMMON_FIRST_MESSAGE = "我知道你是服务器，我想对你说：“我来了”";

    String PCCLIENT_FIRST_MESSAGE = String.format(MessageFormat.MESSAGE_FORMAT, IdentityEnums.PC.getCode(), COMMON_FIRST_MESSAGE);

    String PHONECLIENT_FIRST_MESSAGE = String.format(MessageFormat.MESSAGE_FORMAT, IdentityEnums.PHONE.getCode(), COMMON_FIRST_MESSAGE);

    String SERVER_TO_PCCLIENT = "我知道你是PC客户端，我想对你说：“有朋自远方来，不亦乐乎”";

    String SERVER_TO_PHONECLIENT = "我知道你是Phone客户端，我想对你说：“有朋自远方来，不亦乐乎”";

    String SERVER_TO_ILEGAL = "我知道你是违法客户端，我想对你说：“你最好别来骚扰我”";


}
