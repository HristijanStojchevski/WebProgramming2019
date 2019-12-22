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

@WebServlet(name="confirmation-info-web-servlet" ,urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfoWebServlet extends HttpServlet {
    private OrderService orderService;
    private WebContext webContext;
    private SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoWebServlet(OrderService orderService, SpringTemplateEngine springTemplateEngine) {
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.webContext = new WebContext(req,resp,req.getServletContext());
        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");
        if(order.getPizzaType().length() >2 && order.getPizzaSize().length()>1 && order.getClientAddress().length()>2 && order.getClientName().length()>2) {
            this.webContext.setVariable("order", order);
            this.webContext.setVariable("ipAdd", req.getRemoteHost());
            this.webContext.setVariable("browserName", req.getHeader("user-agent"));
            this.springTemplateEngine.process("confirmationInfo.html", webContext, resp.getWriter());
        }
        else resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("/");
    }
}
