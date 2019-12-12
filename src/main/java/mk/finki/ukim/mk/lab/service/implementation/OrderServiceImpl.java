package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidOrderSlotId;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(int orderId,String pizzaType,String pizzaSize, String clientName, String address) {
         Order order = orderRepository.findById(orderId).orElseThrow(InvalidOrderSlotId::new);
         return this.orderRepository.updateOrder(order);
    }

    @Override
    public Order updateOrder(int orderId, String pizzaType, String pizzaSize, String clientName, String address) {
        Order order = orderRepository.findById(orderId).orElseThrow(InvalidOrderSlotId::new);
        order.setPizzaSize(pizzaSize);
        order.setClientName(clientName);
        order.setClientAddress(address);
        return order;
    }

    @Override
    public Order addOrder(String pizzaType, String pizzaSize, String clientName, String address) {
        Order order = this.orderRepository.addOrder(pizzaType, pizzaSize, clientName, address);
        return order;
    }

}
