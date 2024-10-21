package Ej2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ej2 {
    public static void main(String[] args) {
        Path inputPath = Paths.get("input.txt");
        Path enterosPath = Paths.get("integer.txt");
        Path floatPath = Paths.get("float.txt");
        Path stringPath = Paths.get("string.txt");


        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter intWriter = Files.newBufferedWriter(enterosPath);
             BufferedWriter floatWriter = Files.newBufferedWriter(floatPath);
             BufferedWriter stringWriter = Files.newBufferedWriter(stringPath)){

            String linea;
            while ((linea = reader.readLine()) != null){
                String[] tokens = linea.split(" ");
                for (String token: tokens){
                    if(token.matches("-?\\d+")){
                        intWriter.write(token + "\n");

                    }else if(token.matches("-?\\d+.\\d+")){
                        floatWriter.write(token + "\n");
                    }else
                        stringWriter.write(token + "\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
