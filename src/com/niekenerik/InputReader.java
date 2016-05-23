package com.niekenerik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    private BufferedReader bufferedReader;

    public InputReader(){
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readInput(){
        String input = "";
        try {
            input =  bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

}
