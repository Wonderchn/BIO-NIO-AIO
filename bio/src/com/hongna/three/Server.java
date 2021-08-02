package com.hongna.three;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：实现服务端可以同时接收多个客户端的socket通信需求
 * 思路：是服务器端接收到一个客户端socket请求对象之后都交给一个独立的线程来处理客户端的数据交互需求
 *
 *
 */
public class Server {
    public static void main(String[] args) {

        try {
            //1.注册端口
            ServerSocket serverSocket = new ServerSocket(9999);
            //2.定义一个死循环，负责不断地接收客户端的socket链接请求
            while (true){
                Socket socket = serverSocket.accept();
                //3.创建一个独立的线程来处理与这个客户端的socket通信
                new ServerThreadReader(socket).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
