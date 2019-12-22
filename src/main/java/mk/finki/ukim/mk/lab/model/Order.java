package mk.finki.ukim.mk.lab.model;

import lombok.*;

import javax.persistence.*;


@Data
@Entity
//@Table(name = "ORDERS")
public class Order {
    @Transient
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static int orderCount=1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private String pizzaType;

    private String pizzaSize;
    //@Column(name = "client_Name")
    private String clientName;
    //@Column(name = "client_Address")
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
