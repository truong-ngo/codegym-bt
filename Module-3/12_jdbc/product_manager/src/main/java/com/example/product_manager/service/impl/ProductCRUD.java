package com.example.product_manager.service.impl;

import com.example.product_manager.dao.impl.BrandDAO;
import com.example.product_manager.dao.impl.ProductDAO;
import com.example.product_manager.model.Brand;
import com.example.product_manager.model.Product;
import com.example.product_manager.service.IProductCRUD;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProductCRUD implements IProductCRUD {
    private static ProductCRUD instance;
    private final String path = "product/product.jsp";
    private final String view = "product/view.jsp";
    private final ProductDAO productDAO = ProductDAO.getInstance();
    private final BrandDAO brandDAO = BrandDAO.getInstance();
    private ProductCRUD() {

    }

    public static ProductCRUD getInstance() {
        if (instance == null) {
            instance = new ProductCRUD();
        }
        return instance;
    }

    @Override
    public void search(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void view(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Product product = productDAO.select(id);
        renderProduct(request, response, product);
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Product> products = productDAO.selectAll();
        Product product = getProduct(request, response);
        Long id = products.get(products.size() - 1).getId() + 1;
        product.setId(id);
        productDAO.insert(product);
        products = productDAO.selectAll();
        render(request, response, products);
    }

    @Override
    public void render(HttpServletRequest request, HttpServletResponse response, List<Product> products) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String username = request.getParameter("username");
        List<Brand> brands = brandDAO.selectAll();
        request.setAttribute("products", products);
        request.setAttribute("brands", brands);
        request.setAttribute("username", username);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Product product = getProduct(request, response);
        productDAO.update(id, product);
        List<Product> products = productDAO.selectAll();
        render(request, response, products);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        productDAO.delete(id);
        List<Product> products = productDAO.selectAll();
        render(request, response, products);
    }

    @Override
    public void renderProduct(HttpServletRequest request, HttpServletResponse response, Product product) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String username = request.getParameter("username");
        List<Brand> brands = brandDAO.selectAll();
        request.setAttribute("product", product);
        request.setAttribute("brands", brands);
        request.setAttribute("username", username);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }

    public Product getProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int brandId = Integer.parseInt(request.getParameter("brand"));
        Brand brand = brandDAO.select((long) brandId);
        return new Product(name, price, description, brand);
    }
}
