package controller;

import model.bean.User;
import model.repository.UserRepository;
import model.service.IUserService;
import model.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/users"})
public class UserServlet extends HttpServlet {
    IUserService iUserService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                add(request, response);
                break;
            case "edit":
                update(request, response);
                break;
            case "search":
                searchByCountry(request, response);
                break;
            case "sort":
                sortByName(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                remove(request, response);
                break;
            case "permision":
                addUserPermision(request, response);
                break;
            case "test-without-tran":
                testWithoutTran(request, response);
                break;
                case "test-use-tran":
                    testUseTran(request, response);
                    break;
            default:
                showUserList(request, response);
                break;

        }
    }

    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {

        iUserService.insertUpdateUseTransaction();

    }
    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {

        iUserService.insertUpdateWithoutTransaction();

    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {

        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");
        User user1 = new User("quan1111", "quan.nguyen@codegym.vn", "vn");

        int[] permision = {1, 2, 4};

        iUserService.addUserTransaction(user1, permision);

    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = iUserService.deleteUserStore(id);
        if (check) {
            request.setAttribute("message", "Xóa thành công");

        } else {
            request.setAttribute("message", "Xóa không thành công");
        }
        showUserList(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        iUserService.insertUserStore(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/user/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        boolean check = iUserService.updateUserStore(id, user);
        user = iUserService.getUserById(id);
        if (check) {
            request.setAttribute("message", "Chỉnh sữa đã thành công");

        } else {
            request.setAttribute("message", "Chỉnh sửa không thành công");
        }
        request.setAttribute("user", user);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/user/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        List<User> listSort = iUserService.sortByName();
        request.setAttribute("user", listSort);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) {

        String country = request.getParameter("search");
        List<User> list = iUserService.findByCountry(country);
        request.setAttribute("user", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/user/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUserList(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = iUserService.showUserStore();
        request.setAttribute("user", userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/user/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = iUserService.getUserById(id);
        RequestDispatcher requestDispatcher;
        if (user == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            request.setAttribute("user", user);
            requestDispatcher = request.getRequestDispatcher("/view/user/edit.jsp");
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
