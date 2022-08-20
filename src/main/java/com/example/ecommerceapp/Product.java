package com.example.ecommerceapp;

import dao.ProductDao;
import model.ProductModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddProduct")
public class Product extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

       PrintWriter out = response.getWriter();

        int productId = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("pname");
        String status = request.getParameter("status");
        String attachImage = request.getParameter("attachimage");
        String imageName = request.getParameter("imagename");
        Double price = Double.parseDouble(request.getParameter("price"));
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("qty"));

        ProductModel productModel = new ProductModel(productId, productName, status, attachImage, imageName, price, category, quantity);
        ProductDao productDao = new ProductDao();
        if (productDao.addProduct(productModel)) {
            request.setAttribute("message", "Product added succesffully");
            response.sendRedirect("product.jsp?msg=valid");
        }else {
            response.sendRedirect("product.jsp?msg=invalid");
        }

    }


}
