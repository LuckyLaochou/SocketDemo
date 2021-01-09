package cn.laochou.client;

import cn.laochou.common.Const;
import cn.laochou.common.MessageReceiver;
import cn.laochou.common.MessageSender;
import cn.laochou.log.Logger;

public class IpadClient extends Client{

    public IpadClient() {
        super();
    }

    @Override
    public void start() {
        Logger.info("连接服务器成功");
        // 在这里为了重用我们的send方法
        MessageSender.send(socket, Const.IPAD_FIRST_MESSAGE);
        MessageReceiver.receive(socket);
    }

    public static void main(String[] args) {
        Client ipadClient =  new IpadClient();
        ipadClient.start();
    }

}
