package online.solution.demo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import online.solution.database.MongoConnection;

import org.springframework.data.document.mongodb.MongoOperations;

/**
 * 
 * @author Bhushankumar
 */
@WebServlet(name = "Test4", urlPatterns = { "/Test4" })
public class StudentMongo extends HttpServlet {

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
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<h1>Servlet Test4 at " + request.getContextPath());

			MongoOperations mongoOperation = MongoConnection.startConnection();

			out.println("Excution starts");

			mongoOperation.dropCollection("myNewCollection");

			Student s1 = new Student("133", "Bhushan", "Gandhinagar");
			Student s2 = new Student("77", "Bhushi", "Rajkot");
			Student s3 = new Student("111", "WebCrawler", "Ganpat");

			List<Student> studentList = new ArrayList<Student>();

			studentList.add(s1);
			studentList.add(s2);
			studentList.add(s3);

			for (Iterator<Student> it = studentList.iterator(); it.hasNext();) {
				Student student = it.next();
				mongoOperation.insert(student);
			}

			// Query query = new Query(Criteria.where("id").is("*"));
			List<Student> list = mongoOperation.getCollection(Student.class);// find(query,
																				// Student.class);

			for (Iterator<Student> it = list.iterator(); it.hasNext();) {
				Student student = it.next();
				out.println("</br></br>" + student.getName());
			}
			/*
			 * Student s = mongoOperation.findOne(new
			 * org.springframework.data.document
			 * .mongodb.query.Query(Criteria.where( "id").is("111")),
			 * Student.class);
			 */
			// out.println("Student -> " + s.getName());

			out.println("</br>Excecution complete");

		} catch (Exception exception) {
			System.out.println("Exception -> " + exception);
			System.out.println("</br></br></br>");
			exception.printStackTrace(out);
		} finally {
			System.out.println("finally " + "</h1>");
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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
