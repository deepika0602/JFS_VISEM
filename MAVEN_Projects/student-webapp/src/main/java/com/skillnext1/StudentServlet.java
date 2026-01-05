package com.skillnext1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("StudentServlet triggered...");

        String name = req.getParameter("name");
        int sem = Integer.parseInt(req.getParameter("sem"));
        String dept = req.getParameter("dept");

        Student student = new Student();
        student.setName(name);
        student.setSem(sem);
        student.setDept(dept);

        StudentDAO.save(student);

        resp.sendRedirect("success.jsp");
    }
}
