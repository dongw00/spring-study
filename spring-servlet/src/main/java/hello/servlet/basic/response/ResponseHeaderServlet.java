package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        res.setStatus(HttpServletResponse.SC_OK);
        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("my-header", "hello");

        content(res);
        cookie(res);
        redirect(res);

        PrintWriter writer = res.getWriter();
        writer.println("OK");
    }

    private void content(HttpServletResponse res) {
        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse res) {
        Cookie cookie = new Cookie("id", "test01");
        cookie.setMaxAge(600);
        res.addCookie(cookie);
    }

    private void redirect(HttpServletResponse res) throws IOException {
        res.sendRedirect("/basic/hello-form.html");
    }
}
