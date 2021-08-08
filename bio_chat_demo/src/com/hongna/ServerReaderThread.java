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
            }

        }catch (Exception e){
            System.out.println("当前有人下线");
            //在线socket集合中
            Server.allSocketOnline.remove(socket);
        }
    }

    /**
     * 把当前客户端发来的消息发送给全部在线的socket
     * @param msg
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
