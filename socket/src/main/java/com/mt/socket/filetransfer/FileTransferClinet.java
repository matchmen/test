package com.mt.socket.filetransfer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * author: liqm
 * 2019-10-23
 */
public class FileTransferClinet {

    private static String path = "/Users/ktjr/Desktop/back.txt";

    private static void getFile() throws IOException {

        Socket socket = new Socket("127.0.0.1",8080);

        InputStream inputStream = socket.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream(path);

        byte[] b = new byte[1024];

        int length = 0;

        while ((length = inputStream.read(b)) != -1) {

            fileOutputStream.write(b, 0, length);
        }

        fileOutputStream.flush();

        inputStream.close();

        socket.close();
    }

    public static void main(String[] args) throws IOException {
        getFile();
    }


}
