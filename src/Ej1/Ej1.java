package Ej1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ej1 {
    public static void main(String[] args) {
        Path logsDir = Paths.get("Logs");
        Path processedDir= Paths.get("Processed");
        Path errorDir = Paths.get("Error");

        List<String> processedList = new ArrayList<>();
        List<String> errorList = new ArrayList<>();

        createDirIfNotExist(processedDir);
        createDirIfNotExist(errorDir);

        try(Stream<Path> pathStream = Files.walk(logsDir)){
            pathStream.filter(Files::isRegularFile).forEach(file -> {
                System.out.println(file.getFileName());
                try {
                    boolean hasError = Files.lines(file).anyMatch(line -> line.contains("error"));
                    if(hasError){
                        System.out.println("Tiene error " + file.getFileName());
                        Files.move(file, errorDir.resolve(file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                        errorList.add(String.valueOf(file.getFileName()));
                    }else {
                        System.out.println("No tiene error " + file.getFileName());
                        Files.move(file, processedDir.resolve(file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                        processedList.add(String.valueOf(file.getFileName()));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        generaReporte(processedList, errorList);
    }

    private static void generaReporte(List <String> processedList, List<String> errorList) {

        System.out.println("Log processing report: ");
        System.out.println("-Processed: " + processedList);
        System.out.println("-Error: " + errorList);

    }

    private static void createDirIfNotExist(Path dir) {
        if(!Files.exists(dir)){
            try {
                Files.createDirectory(dir);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
