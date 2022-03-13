package com.example.networktest;

import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable {
    private static final int SERVER_PORT = 53212;
    private static final String SERVER_IP = "143.205.174.165";

    private String matrNum;
    private String modifiedMatrNum;

    public ClientThread() {}

    public ClientThread(String matrNum) {
        this.matrNum = matrNum;
    }

    public void run() {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            Log.i("info", "run method works");
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outToServer.writeBytes(matrNum + '\n');
            modifiedMatrNum = inFromServer.readLine();
            Log.i("info","FROM Server: " + modifiedMatrNum);
            socket.close();
        }
        catch (Exception e) {
            System.err.println(e.getStackTrace());
        }
    }

    public String getMatrNum() {
        return modifiedMatrNum;
    }

}
