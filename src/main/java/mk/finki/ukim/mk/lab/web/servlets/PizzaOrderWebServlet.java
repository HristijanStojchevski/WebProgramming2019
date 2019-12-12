package mk.finki.ukim.mk.lab.web.servlets;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="order-pizza-web-servlet" ,urlPatterns = "/PizzaOrder.do")
public class PizzaOrderWebServlet extends HttpServlet {
    private OrderService orderService;
    private WebContext webContext;
    private SpringTemplateEngine springTemplateEngine;

    public PizzaOrderWebServlet(OrderService orderService, SpringTemplateEngine springTemplateEngine) {
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.webContext = new WebContext(req,resp,req.getServletContext());
        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");
        this.webContext.setVariable("order",order);
        this.springTemplateEngine.process("deliveryInfo.html",webContext,resp.getWriter());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        Order fullOrder = orderService.updateOrder(order.getOrderId(),order.getPizzaType(),order.getPizzaSize(),clientName,clientAddress);
        session.setAttribute("order",fullOrder);
        resp.sendRedirect("/ConfirmationInfo.do");
    }

}
