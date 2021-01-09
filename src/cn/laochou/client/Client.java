package cn.laochou.client;

import cn.laochou.config.SocketConfig;
import cn.laochou.log.Logger;

import java.io.IOException;
import java.net.Socket;

public abstract class Client {

    protected Socket socket;

    public Client() {
        try {
            socket = new Socket(SocketConfig.HOST, SocketConfig.PORT);
        } catch (IOException e) {
            e.printStackTrace();
            Logger.info("连接服务器异常，还请查明原因");
        }
        if(socket == null) {
            Logger.info("连接服务器异常，还请查明原因");
        }
    }

    public abstract void start();

}
