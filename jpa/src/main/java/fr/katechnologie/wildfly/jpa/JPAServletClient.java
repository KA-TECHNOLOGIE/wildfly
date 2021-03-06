package fr.katechnologie.wildfly.jpa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * A simple servlet as client that sends several messages to a queue.
 * </p>
 *
 * <p>
 * The servlet is registered and mapped to /mdbservlet using the {@linkplain WebServlet
 * @HttpServlet}.
 * </p>
 */
@WebServlet("/jpaservlet")
public class JPAServletClient extends HttpServlet {

    private static final long serialVersionUID = -8314035702649252239L;

    private static final int MSG_COUNT = 5;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<h1>Example demonstrates the use of <strong>JMS 2.0</strong> and <strong>EJB 3.2 Message-Driven Bean</strong> in WildFly.</h1>");
        try {

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
