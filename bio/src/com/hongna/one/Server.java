package com.hongna.one;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：客户端发送消息 服务端接收消息
 */
public class Server  {
    public static void main(String[] args) {
        try {
            //1.定义一个ServerSocket对象进行服务端的端口注册
            ServerSocket ss = new ServerSocket(9999);
//            2.监听客户端的socket连接请求
            Socket socket = ss.accept();
//            3.在socket管道中得到一个字节输入流对象
            InputStream is = socket.getInputStream();
            //4.把字节输入流包装成一个缓冲字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while( (msg = br.readLine())!=null){
                System.out.println("服务端接收到" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
