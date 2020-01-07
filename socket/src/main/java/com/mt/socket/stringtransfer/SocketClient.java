package com.mt.socket.stringtransfer;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * author: liqm
 * 2019-10-23
 */
public class SocketClient {

    private static void sendMsg(String sendMsg) throws IOException {

        Socket socket = new Socket("127.0.0.1",8080);

        OutputStream outputStream = socket.getOutputStream();

        PrintWriter printWriter = new PrintWriter(outputStream);

        printWriter.println(sendMsg);

        printWriter.flush();

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String receiveMsg = "";

        while ((receiveMsg = bufferedReader.readLine()) != null) {
            System.out.println(Thread.currentThread().getName() + "-》服务器返回信息:" + receiveMsg);
        }

        bufferedReader.close();

        inputStreamReader.close();

        inputStream.close();

        socket.close();

    }


    public static void main(String[] args) {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                try {
                    sendMsg(Thread.currentThread().getName() + "当前时间:" + LocalDateTime.now());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }, 2000L, 1000L);
    }

}
