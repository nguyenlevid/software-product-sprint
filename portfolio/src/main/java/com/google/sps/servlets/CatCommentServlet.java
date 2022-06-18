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

@WebServlet("/comment-form")
public class CatCommentServlet extends HttpServlet {
    private String comment;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
        // Get the input from the form
        comment = getParameter(request, "comment", "No message");
        long timestamp = System.currentTimeMillis();

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Comment");
        FullEntity commentEntity =
            Entity.newBuilder(keyFactory.newKey())
                .set("comment", comment)
                .set("timestamp", timestamp)
                .build();
        datastore.put(commentEntity);

        response.sendRedirect("/pages/comments.html");
    }


  private String getParameter(HttpServletRequest request, String name, String defaultValue) {
      String value = request.getParameter(name);
      if (value == null) {
          return defaultValue;
      }
      return value;
  }
}
