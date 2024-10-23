package Ej5;

import Ej5.model.Product;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ej5 {
    public static void main(String[] args) {

        Path inputPath = Paths.get("products.txt");
        Path outputPath = Paths.get("updated_inventory.txt");

        try{
            List<String> lines = Files.readAllLines(inputPath);

            List<Product> productList = lines.stream().skip(1)
                    .map(line -> {
                        String[] partes = line.split(";");
                        Product product = new  Product (Integer.parseInt(partes[0]),
                                partes[1],
                                Double.parseDouble(partes[2]),
                                Integer.parseInt(partes[3]),
                                Integer.parseInt(partes[4]));
                        return product;
                    }).toList();

            List<Product> expiringProduct = productList.stream().filter(filtro -> filtro.getDiasParaCaducar() <= 7 && filtro.getPrecio() > 1.0)
                    .toList();

            expiringProduct.forEach(p -> p.setCantidad((int) Math.round(p.getCantidad()* 0.8)));

            double totalInventario = productList.stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();

            System.out.println(totalInventario);

            try(BufferedWriter bw = Files.newBufferedWriter(outputPath)){
                for (Product product : expiringProduct){
                    bw.write(product.toString() +"\n");
                }
            }

            System.out.println("El valor total del inventario es: " + totalInventario);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
