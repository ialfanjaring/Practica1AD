package Ej4;

import Ej4.model.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class Ej4 {
    public static void main(String[] args) {

        Path inputPath = Paths.get("employees.txt");
        Path outputPath = Paths.get("filtered_employees.txt");

        try {
            List<String> lines = Files.lines(inputPath).skip(1).toList();
            List<Employee> employees = lines.stream().map(line -> {
                String [] parts = line.split(",");
                return new Employee(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[2]));
            }).filter(employee -> (employee.getEdad() <= 40 && employee.getEdad()>=20 && employee.getSalario() > 50000))
                    .sorted(Comparator.comparing(Employee::getSalario).reversed()).toList();

            employees.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
