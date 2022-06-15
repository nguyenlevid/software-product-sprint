package com.google.sps.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact-form")
public class ContactServlet extends HttpServlet {
    private String name;
    private String email;
    private String message;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
        // Get the input from the form
        name = getParameter(request, "name", "John Doe");
        email = getParameter(request, "email", "null@null.com");
        message = getParameter(request, "message", "No message");

        response.setContentType("text/html;");
        response.getWriter().print("Name: " + name + "\n" +
                                    "Email: " + email + "\n" +
                                    "Message: " + message);

        response.sendRedirect("/pages/thankyou.html");
    }


  private String getParameter(HttpServletRequest request, String name, String defaultValue) {
      String value = request.getParameter(name);
      if (value == null) {
          return defaultValue;
      }
      return value;
  }
}
