package controller;

import model.bean.Product;
import model.service.IProductService;
import model.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/product"})
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request,response);
                break;
            case "edit":
                update(request, response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "search":
                search(request,response);
            default:
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name= request.getParameter("name");
        List<Product> productList = productService.findByAll();
        List<Product> products = new ArrayList<>();
        for(Product product: productList) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        request.setAttribute("product",products);
        try {
            request.getRequestDispatcher("view/product/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void view(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product= productService.findById(id);
        RequestDispatcher requestDispatcher;
        if(product == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product",product);
            requestDispatcher=request.getRequestDispatcher("/view/product/view.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        String id =request.getParameter("id");
        Product product = productService.findById(id);
        RequestDispatcher requestDispatcher;
        if(product == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            productService.remove(id);
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        Product product = new Product(id, name, price, description, producer);
        productService.create(id,product);
        request.setAttribute("message","Thêm mới sản phẩm thành công");
        request.setAttribute("product",product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        Product product = new Product(id, name, price, description, producer);
        productService.update(id, product);
        product = productService.findById(id);
        request.setAttribute("message", "Chỉnh sữa đã thành công");
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request,response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                showFormDelete(request,response);
                break;
            case "view":
                view(request,response);
            default:
                showProductList(request, response);
                break;
        }
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productService.findById(id);
        RequestDispatcher requestDispatcher;
        if(product == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product",product);
            requestDispatcher= request.getRequestDispatcher("/view/product/delete.jsp");
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("/view/product/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/product/edit.jsp");
            request.setAttribute("product", product);
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> product = productService.findByAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/list.jsp");
        request.setAttribute("product", product);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
