package controller;

import model.bean.*;
import model.service.IServiceService;
import model.service.impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
                showServiceList(request, response);
                break;

        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("nameSearch");
        List<Service> serviceList = iServiceService.findByName(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/list.jsp");
        request.setAttribute("serviceList", serviceList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idService"));
        boolean check;
        check= iServiceService.deleteService(id);
        if(check)
            try {
                response.sendRedirect("/service");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int idService = Integer.parseInt(request.getParameter("id"));
        Service service= iServiceService.getServiceById(idService);
        List<TypeRent> typeRentList= iServiceService.findByAllTypeRent();
        List<TypeService> typeServiceList=iServiceService.findByAllTypeService();
        RequestDispatcher requestDispatcher;
        if(service==null){
            requestDispatcher=request.getRequestDispatcher("/view/error-404.jsp");
        }else {
            requestDispatcher=request.getRequestDispatcher("/view/service/edit.jsp");
            request.setAttribute("service",service);
            request.setAttribute("typeRentList",typeRentList);
            request.setAttribute("typeServiceList",typeServiceList);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int idService=Integer.parseInt(request.getParameter("id"));
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
        Service service=new Service(serviceName,serviceArea,numberOfFloor,serviceMaxPeople,serviceCost,rentTypeId,serviceTypeId,standardRoom,descriptionOtherConverience,poolArea);
        boolean check = iServiceService.updateService(idService,service);
        if (check) {
            request.setAttribute("message", "Edit is success");

        } else {
            request.setAttribute("message", "Edit is fail, something is wrong!!!");
        }
        request.setAttribute("service", service);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showServiceList(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = iServiceService.findByAll();
        List<TypeService> typeServiceList=iServiceService.findByAllTypeService();
        List<TypeRent> typeRentList=iServiceService.findByAllTypeRent();
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("typeServiceList", typeServiceList);
        request.setAttribute("typeRentList", typeRentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<TypeRent> typeRentList= iServiceService.findByAllTypeRent();
        List<TypeService> typeServiceList= iServiceService.findByAllTypeService();
        request.setAttribute("typeRent",typeRentList);
        request.setAttribute("typeService",typeServiceList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
