package com.hongna.three;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        try {
            // 1.请求与服务端的socket对象链接
            Socket socket = new Socket("127.0.0.1", 9999);
            //2.得到一个打印流
            PrintStream ps = new PrintStream(socket.getOutputStream());
            //3.使用循环不断的发送消息给服务端接受
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("话说：");
                String msg = sc.nextLine();
                ps.print(msg);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
