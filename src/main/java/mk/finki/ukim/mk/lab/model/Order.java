package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;



@Data
public class Order {

    private static int orderCount=1;
    private int orderId;

    private String pizzaType;

    private String pizzaSize;
    private String clientName;
    private String clientAddress;

    public static synchronized Order createOrder(String pizzaType, String pizzaSize,String clientName,String clientAddress){
        Order order = new Order();
        order.orderId= orderCount;
        order.pizzaType =pizzaType;
        order.pizzaSize=pizzaSize;
        order.clientName=clientName;
        order.clientAddress=clientAddress;
        return order;
    }
}
