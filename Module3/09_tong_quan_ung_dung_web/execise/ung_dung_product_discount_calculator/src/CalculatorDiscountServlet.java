import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorDiscountServlet",value="/display-discount")
public class CalculatorDiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            float listPrice= Float.parseFloat(request.getParameter("List Price"));
            float discountPercent=Float.parseFloat(request.getParameter("Discount Percent"));
            double discountAmount= listPrice*discountPercent*0.01;
            double discountPrice= listPrice - discountAmount;
            request.setAttribute("discountPrice",discountPrice);
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("result.jsp");
            requestDispatcher.forward(request,response);
//        PrintWriter printWriter=response.getWriter();
//        printWriter.println("Discount Amount: " + discountAmount + "Discount Price: "+ discountPrice );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
