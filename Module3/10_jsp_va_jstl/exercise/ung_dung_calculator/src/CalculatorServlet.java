import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double result = 0;
        try {
            double firstOperand = Double.parseDouble(request.getParameter("First operand"));
            double secondOperand = Double.parseDouble(request.getParameter("Second operand"));
            String operator = request.getParameter("Operator");
            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    try {
                        if (secondOperand == 0) {
                            throw new Exception("Lỗi chia cho 0");
                        }
                        result = firstOperand / secondOperand;
                    } catch (Exception e) {
                        request.setAttribute("result", e.getMessage());
                        request.getRequestDispatcher("result.jsp").forward(request, response);
                    }

            }
        } catch (Exception e) {
            request.setAttribute("result", e.getMessage());
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
