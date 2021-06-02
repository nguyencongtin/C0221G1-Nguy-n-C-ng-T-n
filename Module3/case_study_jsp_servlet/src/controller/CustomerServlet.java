package controller;

import model.bean.Customer;
import model.service.ICustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService iCustomerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(request, response);
                break;
            case "edit":
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

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("nameSearch");
        List<Customer> customerList = iCustomerService.findByName(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/list.jsp");
        request.setAttribute("customer", customerList);
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
            case "edit":
                showFormEdit(request,response);
            default:
                showCustomerList(request, response);
                break;

        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/customer/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Đang bị lỗi ở chỗ edit
    private void update(HttpServletRequest request, HttpServletResponse response) {
        int idCustomer=Integer.parseInt(request.getParameter("id"));
        int idTypeCustomer= Integer.parseInt(request.getParameter("idTypeCustomer"));
        String name=request.getParameter("name");
        String dateOfBirth=request.getParameter("dateOfBirth");
        String sex=request.getParameter("sex");
        String idCard=request.getParameter("idCard");
        String phoneNumber=request.getParameter("phoneNumber");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        Customer customer = new Customer(idTypeCustomer, name, dateOfBirth,sex,idCard,phoneNumber,email,address);
        boolean check = iCustomerService.updateCustomer(idCustomer, customer);
        customer = iCustomerService.getCustomerById(idCustomer);
        if (check) {
            request.setAttribute("message", "Edit is success");

        } else {
            request.setAttribute("message", "Edit is fail, something is wrong!!!");
        }
        request.setAttribute("customer", customer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/user/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
         int idTypeCustomer=Integer.parseInt(request.getParameter("id"));
         String name=request.getParameter("name");
         String dateOfBirth=request.getParameter("birthday");
         String sex=request.getParameter("sex");
         String idCard=request.getParameter("idCard");
         String phoneNumber=request.getParameter("phone");
         String email=request.getParameter("email");
         String address=request.getParameter("adress");
         String message;
         boolean check;
         RequestDispatcher requestDispatcher;
         Customer customer=new Customer(idTypeCustomer,name,dateOfBirth,sex,idCard,phoneNumber,email,address);
         check=iCustomerService.addNewCustomer(customer);
         if(check){
             message="Create is success";
         }else {
             message="Create is fail,something wrong!!!";
         }
         request.setAttribute("message",message);
         requestDispatcher=request.getRequestDispatcher("/view/customer/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// Bị dư không cần thiết
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/create.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idCustomer"));
        boolean check;
        check= iCustomerService.deleteCustomer(id);
        if(check)
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = iCustomerService.findByAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/list.jsp");
        request.setAttribute("customer", customerList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

