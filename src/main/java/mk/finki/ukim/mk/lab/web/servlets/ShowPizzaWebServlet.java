package mk.finki.ukim.mk.lab.web.servlets;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.OrderService;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="pizza-web-Servlet",urlPatterns = "/")
public class ShowPizzaWebServlet extends HttpServlet {
    private PizzaService pizzaService;
    private OrderService orderService;
    private SpringTemplateEngine springTemplateEngine;
    private WebContext webContext;

    public ShowPizzaWebServlet(PizzaService pizzaService,OrderService orderService, SpringTemplateEngine springTemplateEngine) {
        this.pizzaService = pizzaService;
        this.orderService = orderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.webContext = new WebContext(req,resp,req.getServletContext());
        List<Pizza> pizzas = pizzaService.listPizzas();
        this.webContext.setVariable("pizzas",pizzas);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("listPizzas.html",this.webContext,resp.getWriter());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String pizza = req.getParameter("pizza");
        Order order = orderService.addOrder(pizza,"","","");
        session.setAttribute("order",order);
        resp.sendRedirect("/selectPizza.do");
        //orderService.placeOrder(pizzaType,"","","");

        Order temp = new Order(); //Is this allowed ?
        //temp.setPizzaType(pizzaType);

    }
}
