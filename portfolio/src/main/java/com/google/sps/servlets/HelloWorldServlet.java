package com.google.sps.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    Random rand = new Random();
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    
    String[] quotes = new String[] 
        {"You always pass failure on the way to success.",
        "It always seems impossible until it is done.",
        "Positive anything is better than negative nothing.",
        "If opportunity doesn't knock, build a door.",
        "Live life to the fullest and focus on the positive."};
    
    String quote = quotes[rand.nextInt(quotes.length)];
    
    response.getWriter().println("Your motivational quote today:");
    response.getWriter().println(quote);

  }
}
