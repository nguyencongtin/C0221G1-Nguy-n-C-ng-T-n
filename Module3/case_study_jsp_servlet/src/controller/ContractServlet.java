package controller;

import model.bean.Contract;
import model.service.IContractService;
import model.service.impl.ContractServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    IContractService iContractService= new ContractServiceImpl();
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

    private void showContractList(HttpServletRequest request, HttpServletResponse response) {

    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        String contractStartDate = request.getParameter("contractStartDate");
        String contractEndDate = request.getParameter("contractEndDate");
        double contractDeposit = Double.parseDouble(request.getParameter("contractDeposit"));
        double contractTotalMoney = Double.parseDouble(request.getParameter("contractTotalMoney"));
        String message;
        boolean check;
        RequestDispatcher requestDispatcher;
        Contract contract = new Contract(employeeId,customerId,serviceId,contractStartDate,contractEndDate,contractDeposit,contractTotalMoney);
        check = iContractService.addNewContract(contract);
        if (check) {
            message = "Create is success";
        } else {
            message = "Create is fail,something wrong!!!";
        }
        request.setAttribute("message", message);
        requestDispatcher = request.getRequestDispatcher("/view/contract/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
