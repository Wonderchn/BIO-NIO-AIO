package com.hongna.two;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1.创建Socket对象请求服务端的线程
        Socket socket = new Socket("127.0.0.1",9999);
        //2.从socket对象中获取一个字节输出流
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        Scanner sc = new Scanner(System.in);
       while (true){
           System.out.println("请说:");
           String msg = sc.nextLine();
           ps.println(msg);
           ps.flush();
       }

    }
}
