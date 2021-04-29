import java.util.ArrayList;
import java.util.List;

/**
 * clase dedicada a los usuarios
 */
public class User {
    private String ID_usr;
    private int ordenes_acabadas;
    private String lista;
    private List<Order> orders_done= new ArrayList<Order>();
    private List<Order> orders= new ArrayList<Order>();

    public User (String nombre){
        this.ID_usr=nombre;
    }

    public void AddOrder (Order o){
        orders.add(o);
    }

    public void AddOrderAcabada(Order o){
        orders_done.add(o);
        ordenes_acabadas++;
    }

    public List<Order> getOrders_done() {
        return orders_done;
    }

    public void setOrders_done(List<Order> orders_done) {
        this.orders_done = orders_done;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public  int getOrdenes_acabadas() {
        return ordenes_acabadas;
    }

    public String getID_usr() {
        return ID_usr;
    }

    public void setID_usr(String ID_usr) {
        this.ID_usr = ID_usr;
    }

    public void setOrdenes_acabadas(int ordenes_acabadas) {
        this.ordenes_acabadas = ordenes_acabadas;
    }

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }
}
