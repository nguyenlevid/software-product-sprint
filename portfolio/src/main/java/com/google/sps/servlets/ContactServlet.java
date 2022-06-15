package com.google.sps.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
        // Get the input from the form
        String firstName = getParameter(request, "first-name", "John");
        String lastName = getParameter(request, "last-name", "Doe");
        String age = getParameter(request, "age", "null");
        String email = getParameter(request, "email", "null");

        response.setContentType("text/html;");
        response.getWriter().print("First name: " + firstName + "\n" +
                                    "Last name: " + lastName + "\n" +
                                    "Age: " + age + "\n" +
                                    "Email: " + email );
        response.sendRedirect("/");
    }

  private String getParameter(HttpServletRequest request, String name, String defaultValue) {
      String value = request.getParameter(name);
      if (value == null) {
          return defaultValue;
      }
      return value;
  }
}
