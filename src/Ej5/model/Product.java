package Ej5.model;

public class Product {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;
    private int diasParaCaducar;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", diasParaCaducar=" + diasParaCaducar +
                '}';
    }

    public Product(int id, String nombre, double precio, int cantidad, int diasParaCaducar) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.diasParaCaducar = diasParaCaducar;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDiasParaCaducar() {
        return diasParaCaducar;
    }

    public void setDiasParaCaducar(int diasParaCaducar) {
        this.diasParaCaducar = diasParaCaducar;
    }
}
