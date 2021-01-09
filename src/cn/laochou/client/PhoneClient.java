package cn.laochou.client;

import cn.laochou.common.Const;
import cn.laochou.common.MessageReceiver;
import cn.laochou.common.MessageSender;
import cn.laochou.log.Logger;

/**
 * 手机客户端
 */
public class PhoneClient extends Client{

    public PhoneClient() {
        super();
    }

    @Override
    public void start() {
        Logger.info("连接服务器成功");
        // 在这里为了重用我们的send方法
        MessageSender.send(socket, Const.PHONECLIENT_FIRST_MESSAGE);
        MessageReceiver.receive(socket);
    }

    public static void main(String[] args) {
        PhoneClient phoneClient = new PhoneClient();
        phoneClient.start();
    }

}
