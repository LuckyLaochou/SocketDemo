package cn.laochou.common;

import cn.laochou.enums.IdentityEnums;
import cn.laochou.util.IdentityUtil;

import java.io.*;
import java.net.Socket;

/**
 * 消息发送者
 */
public class MessageSender {



    public static void send(Socket socket, String receiveMessage, IdentityEnums oneself) {
        // 判断消息格式是否合法
        boolean legal = IdentityUtil.isLegal(receiveMessage);
        if(legal) {
            // 由消息发送者，根据我们的身份信息，选择发送
            MessageSender.judge(receiveMessage, socket, oneself);
        }
        // 给身份违法的客户端发送数据
        MessageSender.sendMessageToIllegalClient(socket, IdentityEnums.SERVER);
    }

    public static void judge(String message, Socket socket, IdentityEnums from) {
        if(message == null || socket == null) return ;
        IdentityEnums identity = IdentityUtil.getIdentity(message);
        switch (identity) {
            case PC:sendMessageToPC(socket, from); break;
            case PHONE:sendMessageToPhone(socket, from); break;
            case SERVER:sendMessageToServer(socket, from); break;
            default:sendMessageToIllegalClient(socket, from); break;
        }
    }


    public static void sendMessageToPC(Socket socket, IdentityEnums from) {
        String message = String.format(MessageFormat.MESSAGE_FORMAT, from.getCode(), Const.SERVER_TO_PCCLIENT);
        send(socket, message);
    }

    public static void sendMessageToPhone(Socket socket, IdentityEnums from) {
        String message = String.format(MessageFormat.MESSAGE_FORMAT, from.getCode(), Const.SERVER_TO_PHONECLIENT);
        send(socket, message);
    }

    public static void sendMessageToIllegalClient(Socket socket, IdentityEnums from) {
        String message = String.format(MessageFormat.MESSAGE_FORMAT, from.getCode(), Const.SERVER_TO_ILEGAL);
        send(socket, message);
    }

    public static void sendMessageToServer(Socket socket, IdentityEnums from) {
        String message = String.format(MessageFormat.MESSAGE_FORMAT, from.getCode(), Const.COMMON_FIRST_MESSAGE);
        send(socket, message);
    }



    public static void send(Socket socket, String responseMessage) {
        OutputStream os;
        try {
            os = socket.getOutputStream();
            os.write(responseMessage.getBytes());
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            bufferedWriter.write(String.format(MessageFormat.MESSAGE_FORMAT, from.getCode(), responseMessage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
