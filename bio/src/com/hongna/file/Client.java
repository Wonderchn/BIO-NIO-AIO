package com.hongna.file;

import java.io.*;
import java.net.Socket;

/**
 *
 * 目标：实现客户端上传任意类型的文件数据给服务端保存起来
 * 支持上传任意类型的文件
 *
 */
public class Client {
    public static void main(String[] args) {
        try {
            //1.请求与服务端的socket编程
            Socket socket = new Socket("127.0.0.1",8888);
            //2.把字节输出流包装成一个数据输出流
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //3.先发送上传文件的后缀给服务端
            dos.writeUTF(".png");
            //4.把文件数据发送给服务端进行接收
            InputStream is = new FileInputStream("C:\\Users\\a1073\\Desktop\\test (2)\\client\\女2.jpg");
            byte[] buffer = new byte[1024];
            int len ;
            while ((len = is.read(buffer))>0){
                dos.write(buffer,0,len);

            }
            dos.flush();
            socket.shutdownOutput();//通知服务端这边资源已经发送完毕

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {

        }
    }
}
