package controller;

import model.bean.Category;
import model.bean.Customer;
import model.bean.Product;
import model.bean.TypeCustomer;
import model.service.IProductService;

import model.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    IProductService iProductService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "search":
                search(request,response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showFormEdit(request,response);
                break;
            case "add":
                showFormCreate(request,response);
                break;
            default:
                showProductrList(request, response);
                break;

        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("nameSearch");
        List<Product> productList = iProductService.findByName(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/list.jsp");
        request.setAttribute("product", productList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int productId=Integer.parseInt(request.getParameter("id"));
        String productName=request.getParameter("name");
        int productCost= Integer.parseInt(request.getParameter("cost"));
        int productAmount=Integer.parseInt(request.getParameter("amount"));
        String productColor=request.getParameter("color");
        String productDescription=request.getParameter("description");
        int productCategory=Integer.parseInt(request.getParameter("category"));
        Product product=new Product(productName,productCost,productAmount,productColor,productDescription,productCategory);
        boolean check= iProductService.updateProduct(productId,product);
        if (check) {
            request.setAttribute("message", "Edit is success");

        } else {
            request.setAttribute("message", "Edit is fail, something is wrong!!!");
        }
        request.setAttribute("product", product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product= iProductService.getProductById(productId);
        List<Category> categoryList= iProductService.findByAllCategory();
        RequestDispatcher requestDispatcher;
        if(product==null){
            requestDispatcher=request.getRequestDispatcher("/view/error-404.jsp");
        }else {
            requestDispatcher=request.getRequestDispatcher("/view/product/edit.jsp");
            request.setAttribute("product",product);
            request.setAttribute("categoryList",categoryList);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("productId"));
        boolean check;
        check= iProductService.deleteProduct(id);
        if(check)
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String productName=request.getParameter("name");
        int productCost= Integer.parseInt(request.getParameter("cost"));
        int productAmount=Integer.parseInt(request.getParameter("amount"));
        String productColor=request.getParameter("color");
        String productDescription=request.getParameter("description");
        int productCategory=Integer.parseInt(request.getParameter("category"));
        String message;
        boolean check;
        RequestDispatcher requestDispatcher;
        Product product=new Product(productName,productCost,productAmount,productColor,productDescription,productCategory);
        check=iProductService.addNewProduct(product);
        if(check){
            message="Create is success";
        }else {
            message="Create is fail,something wrong!!!";
        }
        request.setAttribute("message",message);
        requestDispatcher=request.getRequestDispatcher("/view/product/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList= iProductService.findByAllCategory();
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductrList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = iProductService.findByAll();
        List<Category> categoryList = iProductService.findByAllCategory();
        request.setAttribute("product", productList);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
