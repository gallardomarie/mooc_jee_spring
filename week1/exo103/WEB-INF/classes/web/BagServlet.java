package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

// TODO: this class should extends something to be a usable servlet.
// TODO: add an annotation here to map your servlet on an URL.
@WebServlet(urlPatterns={"/bag"})
public class BagServlet extends HttpServlet {

	Bag myBag = new Bag();

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		res.setContentType( "text/html" );
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		out.println("<form action='bag' method='post'>");
		out.println("Référence <input name='ref'><p>");
		out.println("Quantity <input name='qty'><p>");
		out.println("<input type='submit' value='Valider'/>");
		out.println("</form>");
		out.println("</body></html>");
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType( "text/html" );
		String ref = req.getParameter("ref");
		String qty = req.getParameter("qty");

		try{
			int qtyInt = Integer.parseInt(qty);
			if((ref==null) || (qty==null) || ref.equals("") || qty.equals("")){
				out.println("<html><body>");
				out.println("Une erreur a été rencontrée !!");
				out.println("</body></html>");
				res.setStatus(400);
			}
			else{
				out.println("<html><body>");
				out.println("<p>"+ref+"</p>");
				out.println("<p>"+qty+"</p>");
				out.println("</body></html>");
			}
		}
		catch (Exception e) {
			out.println("<html><body>");
			out.println("Une erreur a été rencontrée !!");
			out.println("</body></html>");
			res.setStatus(400);
		}

		// TODO : Get parameters, check null

		// TODO : print reference and quantity

	}




}
