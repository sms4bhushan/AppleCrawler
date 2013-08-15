/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import online.solution.url.generator.HtmlLink;
import online.solution.url.generator.HtmlLinkExtractor;
import online.solution.url.utility.UrlUtil;

/**
 * 
 * @author Bhushankumar
 */
@WebServlet(name = "Test1", urlPatterns = {
	"/Test1"
})
public class LinkGenerate extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<h3>Servlet Test1 at " + request.getContextPath());
			// String webSite = request.getParameter("txtWebsite");
			String webSite = "http://www.uvpce.ac.in";
			// String webSite = "http://www.w3schools.in";
			// String webSite = "http://www.w3schools.com";
			// String webSite = "http://www.scvshortsalecenter.com/";
			// String webSite = "http://www.wethinksolutions.com";
			// String webSite = "http://www.onepagerapp.com";
			// String webSite = "http://localhost/www.w3schools.com/";
			// String webSite="http://www.iwillstudy.com/";
			webSite = UrlUtil.removeSingleSlash(webSite);
			if (UrlUtil.urlValidator(webSite)) {
				HtmlLinkExtractor extractor = new HtmlLinkExtractor(webSite);
				ArrayList<HtmlLink> fatchedList = extractor.generateLink();
				int i = 1;
				for (Iterator<HtmlLink> it1 = fatchedList.iterator(); it1.hasNext();) {
					HtmlLink htmlLink = it1.next();
					out.println("<br/>" + i + "  Link - >" + htmlLink.getLink());
					out.println("<br/>" + "Contain - >" + htmlLink.getLinkText());
					out.println("<br/><br/>");
					i++;
				}
				out.println("All execution completed...");
			}
			else {
				out.println("Invalid url...");
			}
		}
		catch (Exception exception) {
			out.println("Exception Test1 -> " + exception);
			exception.printStackTrace(out);
		}
		finally {
			out.println("</h3>");
			out.close();
		}
	}

	// <editor-fold defaultstate="collapsed"
	// desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * 
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
