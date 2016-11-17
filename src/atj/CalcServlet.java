package atj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String base = "/";
        String url = base + "calc.jsp";

        HttpSession session = request.getSession();
        Calc obiekt = (Calc)session.getAttribute("obiekt");
        if(obiekt ==null) {
            obiekt = new Calc();
            session.setAttribute("obiekt",obiekt);
            obiekt.setValue("0");
        }

        if(request.getParameterMap().containsKey("btn")) {
            String s = request.getParameter("btn");
            if(s.contains("C")) {
                obiekt.setValue("0");
                obiekt.setPrevious(null);
                obiekt.setSign(null);
                obiekt.setPreviousNumber(null);
                obiekt.setCurrentNumber(null);
            }
            else
                    obiekt.handleButton(s);
        }
        RequestDispatcher requestDispatcher =
                getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }
}