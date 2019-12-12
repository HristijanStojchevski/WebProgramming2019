package mk.finki.ukim.mk.lab.repository.inMemoryRepos;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class inMemOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();
    @Override
    public List<Order> getAllOrders() {
        return orders;
    }
    public void addOrder (String pizzaType,String pizzaSize, String clientName, String address){
        Order order = new Order(pizzaType, pizzaSize, clientName, address);
        orders.add(order);
    }
    public void createOrder(){
        Order order=new Order();
    }
}
