package cn.laochou.client;

import cn.laochou.common.Const;
import cn.laochou.common.MessageReceiver;
import cn.laochou.common.MessageSender;
import cn.laochou.log.Logger;

import java.io.IOException;


/**
 * 个人电脑客户端
 */
public class PCClient extends Client{

    public PCClient() {
        super();
    }

    @Override
    public void start() {
        Logger.info("连接服务器成功");
        // 在这里为了重用我们的send方法
        MessageSender.send(socket, Const.PCCLIENT_FIRST_MESSAGE);
        MessageReceiver.receive(socket);
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PCClient pcClient =  new PCClient();
        pcClient.start();
    }


}
