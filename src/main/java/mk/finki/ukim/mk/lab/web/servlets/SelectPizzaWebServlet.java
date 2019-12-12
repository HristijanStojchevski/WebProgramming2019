package mk.finki.ukim.mk.lab.web.servlets;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="select-pizza-web-servlet" ,urlPatterns = "/selectPizza.do")
public class SelectPizzaWebServlet extends HttpServlet {
    private final OrderService orderService;

    public SelectPizzaWebServlet(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String pizzaType = req.getParameter(); //vrska nemam
        //orderService.placeOrder(pizzaType,"","","");

        Order temp = new Order(); //Is this allowed ?
        //temp.setPizzaType(pizzaType);

    }
}
