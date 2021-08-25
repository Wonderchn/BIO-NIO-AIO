package com.hongna;

import java.io.*;
import java.net.Socket;

public class ServerReaderThread extends Thread{
    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //捕获异常
        try{
            //1. 从socket中去获取当前客户端的输入流
            InputStream in;
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg = br.readLine())!=null){
                //2.服务端接受到了客户端客户端的处理之后，是需要推送给当前所有的在线socket
                sendMessageClient(msg);
                //2021年8月18日 22:35:41 后面再增加修改
            }

        }catch (Exception e){
            System.out.println("当前有人下线了");
            //在线socket集合中，移除本socket
            //代码完整
            //
            Server.allSocketOnline.remove(socket);
        }
    }

    /**
     * 把当前客户端发来的消息发送给全部在线的socket
     * 修改原有代码，代码修正
     * @param msg 当前客户端收到的消息
     *
     */
    private void sendMessageClient(String msg) throws IOException {
        for (Socket ss : Server.allSocketOnline){
            OutputStream out;
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(msg);
            ps.flush();
        }
    }
}
