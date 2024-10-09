package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("Hello Word!");
        ServerSocket ss = new ServerSocket(3645);
        Socket mySocket = ss.accept();
        System.out.println("qualcuno si e' collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());

        String stringaRicevuta;
        do {
            stringaRicevuta = in.readLine();
            if(stringaRicevuta == "!") {
            mySocket.close();
            ss.close();
        }
        System.out.println("La stringa ricevuta: " + stringaRicevuta);

        String stringMaiuscola = stringaRicevuta.toUpperCase();
        out.writeBytes(stringMaiuscola + "\n");
        }while(stringaRicevuta != "!");

        mySocket.close();
        ss.close();
    }
}