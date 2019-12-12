package mk.finki.ukim.mk.lab.web.servlets;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="pizza-web-Servlet",urlPatterns = "/")
public class ShowPizzaWebServlet extends HttpServlet {
    private final PizzaService pizzaService;

    public ShowPizzaWebServlet(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ipAddress = req.getRemoteHost();
        String clientAgent = req.getHeader("User-Agent");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        List<Pizza> pizzas = pizzaService.listPizzas();
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>Pizza Order page -  Welcome and choose pizza</title>");
        writer.write("<style type=\"text/css\">\n" +
                "        body {\n" +
                "            width: 800px;\n" +
                "            margin: auto;\n" +
                "        }\n" +
                "    </style>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<header>\n" +
                "    <h1>Welcome to our Pizza Delivery App</h1>\n" +
                "</header>");
        writer.write("<main>");
        writer.write("<h2>Choose pizza:</h2>");
        pizzas.forEach(pizza ->
                writer.write("<input type=\"radio\" name=\"pizza\" value=\"" + pizza.getName() +
                        "\"> " + pizza.getName() +"("+ pizza.getDescription() +")<br/>"));
        writer.write("<br/>");
        writer.write("<a href=\"/selectPizzaSize.html\">Submit</a>");
        writer.write("</main>");
        writer.write("</body>");
        writer.write("</html>");
    }
}
