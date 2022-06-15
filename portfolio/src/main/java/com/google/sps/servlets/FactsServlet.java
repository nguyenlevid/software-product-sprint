package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /facts URL. Try running a server and navigating to /facts ! */
@WebServlet("/facts")
public class FactsServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    ArrayList<String> quotes = new ArrayList<String>
        (Arrays.asList("My first name Viet is part of my country's name - Viet Nam",
        "I'm a really good soccer player. I used to think I would go pro as a child.",
        "Java is my most favorite programming language as I learned everything about coding in Java.",
        "I can do 10 pull-ups with ease.",
        "I'm a heavily-dog person, but can do with cats."));

    String json = convertToJson(quotes);
    
    response.setContentType("application/json;");
    response.getWriter().print(json);

  }

  private String convertToJson(ArrayList<String> array) {
      Gson gson = new Gson();
      String json = gson.toJson(array);
      return json;
  }
}

