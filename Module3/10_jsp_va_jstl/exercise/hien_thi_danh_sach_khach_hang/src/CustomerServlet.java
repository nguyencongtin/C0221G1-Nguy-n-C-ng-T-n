import model.Customer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ArrayList<Customer> list = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        list.add(new Customer("Nguyễn Công Tín","1997-05-15","Đà Nẵng","https://img.thuthuatphanmem.vn/uploads/2018/09/24/anh-doremon-yeu_054126296.jpg"));
        list.add(new Customer("Nguyễn Công ","1995-05-15","Đà Lạt","https://img.thuthuatphanmem.vn/uploads/2018/09/24/anh-doremon-yeu_054126296.jpg"));
        list.add(new Customer("Nguyễn ","2000-05-10","Huế","https://img.thuthuatphanmem.vn/uploads/2018/09/24/anh-doremon-yeu_054126296.jpg"));
        list.add(new Customer("Nguyễn Công Tínnnnn","1990-05-15","Sài Gòn","https://img.thuthuatphanmem.vn/uploads/2018/09/24/anh-doremon-yeu_054126296.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList",list);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
