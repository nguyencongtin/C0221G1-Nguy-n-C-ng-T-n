package controller;

import model.bean.Employee;
import model.bean.Service;
import model.service.IServiceService;
import model.service.impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    IServiceService iServiceService = new ServiceServiceImpl();

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
//                showEmployeeList(request, response);
                break;

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        int numberOfFloor = Integer.parseInt(request.getParameter("numberOfFloor"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConverience = request.getParameter("descriptionOtherConverience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        String message;
        boolean check;
        RequestDispatcher requestDispatcher;
        Service service = new Service(serviceName,serviceArea,numberOfFloor,serviceMaxPeople,serviceCost,rentTypeId,serviceTypeId,standardRoom,descriptionOtherConverience,poolArea);
        check = iServiceService.addNewService(service);
        if (check) {
            message = "Create is success";
        } else {
            message = "Create is fail,something wrong!!!";
        }
        request.setAttribute("message", message);
        requestDispatcher = request.getRequestDispatcher("/view/service/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
