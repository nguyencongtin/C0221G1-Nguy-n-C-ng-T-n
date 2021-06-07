package controller;

import model.bean.AttachService;
import model.bean.Customer;
import model.service.ICustomerUsingServiceService;
import model.service.impl.CustomerUsingServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerUsingServiceServlet", urlPatterns = "/customerUsing")
public class CustomerUsingServiceServlet extends HttpServlet {
    ICustomerUsingServiceService iCustomerUsingServiceService = new CustomerUsingServiceServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "deleteAttachService":
                deleteAttachService(request, response);
                break;

        }
    }

    private void deleteAttachService(HttpServletRequest request, HttpServletResponse response) {
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        List<AttachService> attachServiceList = iCustomerUsingServiceService.findByAllAttachService(idCustomer);
        request.setAttribute("attachService", attachServiceList);
        request.setAttribute("idCustomer", idCustomer);
        int idContract = Integer.parseInt(request.getParameter("conTractId"));
        boolean check = iCustomerUsingServiceService.deleteContract(idContract);
        RequestDispatcher requestDispatcher;
        String message;
        if (check) {
            message = "Delete is success";
        } else {
            message = "Delete is fail,something wrong!!!";
        }
        request.setAttribute("message", message);
        showAttachService(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
//                showFormEdit(request,response);
                break;
            case "add":
//                showFormCreate(request,response);
                break;
            case "showAttachService":
                showAttachService(request, response);
                break;
            default:
                showCustomerUsingList(request, response);
                break;

        }
    }

    private void showAttachService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<AttachService> attachServiceList = iCustomerUsingServiceService.findByAllAttachService(id);
        request.setAttribute("attachService", attachServiceList);
        request.setAttribute("idCustomer", id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer_using_service/listAttachService.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerUsingList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = iCustomerUsingServiceService.findByAllCustomerUsingService();
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer_using_service/listCustomerUsingService.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
