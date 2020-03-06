package br.com.impacta.projetojavaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.projetojavaweb.models.Usuario;

@WebServlet("/coletaEmail")
public class ColetaEmailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6833737828824000905L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("ISO-8859-1");
		resp.setContentType("text/html");
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Sistema - Home</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Bem Vindo - " + usuario.getLogin() +" </h2>");
		out.println("<form action='adicionaEmailCookie' method='post'>");
		out.println("Email: <br/> <input type='text' name='email' size=80 /> <br/>");
		out.println("<input type='submit' value='Enviar' />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
