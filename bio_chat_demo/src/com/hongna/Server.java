package com.hongna;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * bio模式下 的端口转发思想-服务端实现
 * 服务端实现的需求：
 * 1.注册端口
 * 2.接受客户端的socket，交给一个独立的线程来处理
 * 3.把当前连接的客户端socket存入到一个所谓的在线socket集合来保存
 * 4.接受客户端的消息，然后推送给当前所有在限额的socket接受
 */
public class Server {
    //定义一个静态集合
    public static List<Socket> allSocketOnline = new ArrayList();
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            while (true){
                //嘻嘻嘻
                //这里可以收到客户端的连接
                Socket socket = ss.accept();
                //把登录的客户端socket存入到一个在线集合中去，连接一个socket就存储到socket集合中去
                allSocketOnline.add(socket);
                //为当前登录成功的socket分配一个独立的线程处理与之通信
                //代码更新
                //emmmm
                new ServerReaderThread(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
