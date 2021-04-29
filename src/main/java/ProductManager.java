import java.util.List;

/**
 * interfaz que implementa las operaciones
 */
public interface ProductManager {

    public List<Product> getProductoByPrecio();
    public void newOrder(Order o);
    public Order processOrder();
    public List<Order> getOrdersByUser(String idUser);
    public List<Product> getProductBySales()
}
