import java.util.*;

/**
 * Fachada que implementa la interfaz (singleton)
 */

public class ProductManagerImpl implements ProductManager{
    HashMap<String, User> users;
    List<Order> pendingOrders = new LinkedList<Order>();
    List<Product> productList = new ArrayList<Product>();
    HashMap<String, User> hmUsers= new HashMap<String, User>();
    int cont=0;

    private  static ProductManagerImpl instance;

    public  static  ProductManagerImpl getInstance(){
        if (instance==null) instance=new ProductManagerImpl();
        return instance;
    }

    @Override
    public List<Product> getProductoByPrecio() {
        Collections.sort(this.productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.precio, o1.precio);
            }
        });
        return this.productList;
    }

    @Override
    public void newOrder(Order o) {
        User user=hmUsers.get(o.getUserName());
        if (user==null)
            System.out.println("El usuario "+o.getUserName()+"no existe.");
        user.AddOrder(o);
        pendingOrders.add(o);
        o.setId(cont);
        cont++;
    }

    @Override
    public Order processOrder() {
        Order o =pendingOrders.remove(pendingOrders.size());
        User user=hmUsers.get(o.getUserName());
        user.AddOrderAcabada(o);

        List<String> p=o.getProductNames();
        for (int i=0; i<p.size();i++)
        {
            for (int j=0;j<productList.size();j++)
            {
                if (p.get(i)==productList.get(j).getNombre_producto())
                    productList.get(j).addVenta();
            }
        }
        return o;
    }

    @Override
    public List<Order> getOrdersByUser(String idUser) {
        return hmUsers.get(idUser).getOrders_done();
    }

    @Override
    public List<Product> getProductBySales() {
        Collections.sort(this.productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getVentas(), o1.getVentas());
            }
        });
        return this.productList;
    }

    public void  productoNuevo (String nombreProducto, double Precio)
    {
        Product p= new Product(nombreProducto,Precio);
    }
    public void clear() {
        productList.clear();
        hmUsers.clear();
        pendingOrders.clear();
    }
    public User getUser(String ID_user) {
        return hmUsers.get(ID_user);
    }
    public void addProduct(Product p) {
        productList.add(p);
    }

}
