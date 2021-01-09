package cn.laochou.common;

import cn.laochou.log.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MessageReceiver {

    /**
     * 接收客户端发来的数据
     */
    public static String receive(Socket socket) {
        Logger.info("开始获取客户端发送的数据");
        InputStream is;
        try {
            is = socket.getInputStream();
            byte[] arr = new byte[1024];
            int len = is.read(arr);
            String message = new String(arr, 0, len);
            System.out.println("内容为-------------->" + message);
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String line = bufferedReader.readLine();
//            System.out.println("内容为-------------->" + line);
            return  message;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
