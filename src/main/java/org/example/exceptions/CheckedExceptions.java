package org.example.exceptions;

import java.io.*;

public class CheckedExceptions {

    public static void readFile(String path){
        File myText = new File(path);
        try(BufferedReader br = new BufferedReader(new FileReader(myText))) {
            String data = br.readLine();

            while (data != null){
                System.out.println(data);
                data = br.readLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }


    }


}
