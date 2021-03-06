package com.google.sps.servlets;

import java.io.IOException;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

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

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Contact");
        FullEntity contactEntity =
            Entity.newBuilder(keyFactory.newKey())
                .set("name", name)
                .set("email", email)
                .set("message", message)
                .build();
        datastore.put(contactEntity);

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
