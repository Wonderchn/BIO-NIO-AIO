package com.hongna.four;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerRunnableTarget implements Runnable {
    public Socket socket;

    public ServerRunnableTarget(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        try {
            //            3.在socket管道中得到一个字节输入流对象
            InputStream is = socket.getInputStream();
            //4.把字节输入流包装成一个缓冲字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            if ((msg = br.readLine()) != null) {
                System.out.println("服务端接收到" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
