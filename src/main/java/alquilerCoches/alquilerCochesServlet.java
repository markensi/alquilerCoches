package alquilerCoches;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class alquilerCochesServlet
 */
public class alquilerCochesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alquilerCochesServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		ServletContext context = config.getServletContext();
		context.setAttribute("base", config.getInitParameter("base"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String base = "/JSP/";
		String url = base + "index.jsp";
		
		String peticion = request.getParameter("peticion");
		
		if(peticion != null) {
			switch (peticion) {
			case "alquiler":
				url = base + "alquiler.jsp";
				break;
				
			case "vehiculos":
				url = base + "vehiculos.jsp";
				break;
				
			case "clientes":
				
				url = base + "clientes.jsp";
				break;
			}
		}
		System.out.println("URL "+url);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
