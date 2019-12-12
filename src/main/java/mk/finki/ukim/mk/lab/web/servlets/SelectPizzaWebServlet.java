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
    private WebContext webContext;
    private SpringTemplateEngine springTemplateEngine;
    public SelectPizzaWebServlet(OrderService orderService,SpringTemplateEngine springTemplateEngine) {
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.webContext = new WebContext(req,resp,req.getServletContext());
        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");
        this.webContext.setVariable("order",order);
        this.springTemplateEngine.process("selectPizzaSize.html",webContext,resp.getWriter());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");
        String pizzaSize = req.getParameter("pizza_size");
        Order orderWithSize = orderService.updateOrder(order.getOrderId(),order.getPizzaType(),pizzaSize,"","");
        session.setAttribute("order",orderWithSize);
        resp.sendRedirect("/PizzaOrder.do");

    }

}
