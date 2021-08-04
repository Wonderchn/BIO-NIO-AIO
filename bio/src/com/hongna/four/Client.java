package com.hongna.four;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            //1、请求与服务端的Socket对象链接
            Socket socket = new Socket("127.0.0.1", 9999);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("请说：");
                String msg = sc.nextLine();
                ps.print(msg);
                ps.flush();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
