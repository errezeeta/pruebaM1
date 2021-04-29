public class Product {
    private String nombre_producto;
    double precio;
    private int ventas=0;

    /**
     * clase dedicada a los productos
     * @return
     */
    //Getters
    public String getNombre_producto() {
        return nombre_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public int getVentas() {
        return ventas;
    }
    //Setters

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public Product (String nombre, double precio)
    {
        this.nombre_producto=nombre;
        this.precio=precio;
    }
    public void addVenta (){
        this.ventas++;
    }

    public String toString() {
        return "Product{" +
                "nombre_producto='" + nombre_producto + '\'' +
                ", precio=" + precio +
                '}';
    }
}
