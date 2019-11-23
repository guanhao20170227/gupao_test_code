package com.haohao.designpatterns.f_delegate.demo2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyDispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        // doDispatch(req, resp);
    }

    /**
     *  这一块也将在完成 策略模式的之后进行整改;
     * @param req
     * @param resp
     * @throws IOException
     */
    /*private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");

        if (uri.contains("getMemberById")) {
            new MemberController().getMemberById(mid);
        } else if (uri.contains("getOrderById")) {
            new OrderController().getOrderById(mid);
        } else if (uri.contains("logout")) {
            new SystemController().logout();
        } else {
            resp.getWriter().write("404, Not Found My.");
        }
    }*/
}
