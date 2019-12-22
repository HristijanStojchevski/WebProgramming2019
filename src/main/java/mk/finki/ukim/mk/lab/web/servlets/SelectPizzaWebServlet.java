package mk.finki.ukim.mk.lab.web.servlets;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="select-pizza-web-servlet" ,urlPatterns = "/selectPizza.do")
public class SelectPizzaWebServlet extends HttpServlet {
    private OrderService orderService;
    private SpringTemplateEngine springTemplateEngine;
    public SelectPizzaWebServlet(OrderService orderService,SpringTemplateEngine springTemplateEngine) {
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        HttpSession session = req.getSession(); // create order with attr from session
        String pizza = (String) session.getAttribute("pizzaName");
        if (pizza.length() > 2) {
            Order order = orderService.addOrder(pizza, "", "", "");
            session.setAttribute("order", order);
            webContext.setVariable("order", order);
            this.springTemplateEngine.process("selectPizzaSize.html", webContext, resp.getWriter());
        } else resp.sendRedirect("/");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");
        String pizzaSize = req.getParameter("pizza_size")!=null?req.getParameter("pizza_size"):"";
        if(pizzaSize.length()>1) {
            Order orderWithSize = orderService.updateOrder(order.getOrderId(), order.getPizzaType(), pizzaSize, "", "");
            session.setAttribute("order", orderWithSize);
            resp.sendRedirect("/PizzaOrder.do");
        }
        else resp.sendRedirect("/selectPizza.do");
    }

}
