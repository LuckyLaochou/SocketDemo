package cn.laochou.server;

import cn.laochou.common.MessageReceiver;
import cn.laochou.common.MessageSender;
import cn.laochou.config.SocketConfig;
import cn.laochou.enums.IdentityEnums;
import cn.laochou.log.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 */
public class Server {


    private ServerSocket serverSocket;


    public Server() {
        try {
            serverSocket = new ServerSocket(SocketConfig.PORT);
            Logger.info("服务器正常启动");
        } catch (IOException e) {
            Logger.info("服务器启动失败");
            e.printStackTrace();
        }
    }

    /**
     * 开启服务
     */
    public void start(){
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                Logger.info("服务器接收请求失败，自动终止");
                e.printStackTrace();
                // 直接退出
                System.exit(0);
            }
            Logger.info("服务器开始等待接收数据");
            Socket finalSocket = socket;
            String message = MessageReceiver.receive(socket);
            MessageSender.send(finalSocket, message, IdentityEnums.SERVER);
        }
    }



    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }

}
