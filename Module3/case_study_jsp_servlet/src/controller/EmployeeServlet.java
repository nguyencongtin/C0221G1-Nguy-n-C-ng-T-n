package controller;

import model.bean.Employee;
import model.service.IEmployeeService;
import model.service.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService iEmployeeService = new EmployeeServiceImpl();

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
            default:
                showEmployeeList(request, response);
                break;

        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("nameSearch");
        List<Employee> employeeList = iEmployeeService.findByName(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/list.jsp");
        request.setAttribute("employee", employeeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee= iEmployeeService.getEmployeeById(employeeId);
        RequestDispatcher requestDispatcher;
        if(employee==null){
            requestDispatcher=request.getRequestDispatcher("/view/error-404.jsp");
        }else {
            requestDispatcher=request.getRequestDispatcher("/view/employee/edit.jsp");
            request.setAttribute("employee",employee);
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
        int employeeId=Integer.parseInt(request.getParameter("id"));
        String employeeName=request.getParameter("employeeName");
        String employeeBirthday=request.getParameter("employeeBirthday");
        String employeeIdCard=request.getParameter("employeeIdCard");
        String employeeSalary=request.getParameter("employeeSalary");
        String employeePhone=request.getParameter("employeePhone");
        String employeeEmail=request.getParameter("employeeEmail");
        String employeeAddress=request.getParameter("employeeAddress");
        int positionId=Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId=Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId=Integer.parseInt(request.getParameter("divisionId"));
        String userName=request.getParameter("userName");
        Employee employee = new Employee(employeeName,employeeBirthday,employeeIdCard,employeeSalary,employeePhone,employeeEmail,employeeAddress,positionId,educationDegreeId,divisionId,userName);
        boolean check = iEmployeeService.updateEmployee(employeeId, employee);
        if (check) {
            request.setAttribute("message", "Edit is success");

        } else {
            request.setAttribute("message", "Edit is fail, something is wrong!!!");
        }
        request.setAttribute("employee", employee);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("employeeId"));
        boolean check;
        check= iEmployeeService.deleteEmployee(id);
        if(check)
            try {
                response.sendRedirect("/employee");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = iEmployeeService.findByAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/list.jsp");
        request.setAttribute("employee", employeeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String employeeName=request.getParameter("employeeName");
        String employeeBirthday=request.getParameter("employeeBirthday");
        String employeeIdCard=request.getParameter("employeeIdCard");
        String employeeSalary=request.getParameter("employeeSalary");
        String employeePhone=request.getParameter("employeePhone");
        String employeeEmail=request.getParameter("employeeEmail");
        String employeeAddress=request.getParameter("employeeAddress");
        int positionId=Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId=Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId=Integer.parseInt(request.getParameter("divisionId"));
        String userName=request.getParameter("userName");
        String message;
        boolean check;
        RequestDispatcher requestDispatcher;
        Employee employee=new Employee(employeeName,employeeBirthday,employeeIdCard,employeeSalary,employeePhone,employeeEmail,employeeAddress,positionId,educationDegreeId,divisionId,userName);
        check=iEmployeeService.addNewEmployee(employee);
        if(check){
            message="Create is success";
        }else {
            message="Create is fail,something wrong!!!";
        }
        request.setAttribute("message",message);
        requestDispatcher=request.getRequestDispatcher("/view/employee/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
