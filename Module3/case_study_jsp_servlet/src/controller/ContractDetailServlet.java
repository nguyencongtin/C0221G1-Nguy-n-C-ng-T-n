package controller;

import model.bean.ContractDetail;
import model.service.IContractDetailService;
import model.service.impl.ContractDetailServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContractDetailServlet",urlPatterns = "/contractDetail")
public class ContractDetailServlet extends HttpServlet {
    IContractDetailService iContractDetailService= new ContractDetailServiceImpl();

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
//                update(request, response);
                break;
            case "search":
//                search(request,response);
                break;
            case "delete":
//                delete(request, response);
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
//                showFormEdit(request,response);
            default:
//                showContractList(request, response);
                break;

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        int contractId = Integer.parseInt(request.getParameter("contractId"));
        int attachServiceId = Integer.parseInt(request.getParameter("attachServiceId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String message;
        boolean check;
        RequestDispatcher requestDispatcher;
        ContractDetail contractDetail = new ContractDetail(contractId,attachServiceId,quantity);
        check = iContractDetailService.addNewContractDetail(contractDetail);
        if (check) {
            message = "Create is success";
        } else {
            message = "Create is fail,something wrong!!!";
        }
        request.setAttribute("message", message);
        requestDispatcher = request.getRequestDispatcher("/view/contract_detail/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
