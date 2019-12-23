package mk.finki.ukim.mk.lab.repository.inMemoryRepos;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class inMemOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();
    @Override
    public List<Order> getAllOrders() {
        return orders;
    }
    public Order addOrder (String pizzaType,String pizzaSize, String clientName, String address){
        Order order = Order.createOrder(pizzaType,pizzaSize,clientName,address);
        DataHolder.orders.add(order);
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        this.findById(order.getOrderId()).ifPresent(DataHolder.orders::remove);
        DataHolder.orders.add(order);
        return order;
    }

    @Override
    public Optional<Order> findById(int orderId) {
        return DataHolder.orders.stream().filter(order -> order.getOrderId()==orderId).findFirst();
    }
    /*public void createOrder(){
        Order order=new Order();
    }*/
}
