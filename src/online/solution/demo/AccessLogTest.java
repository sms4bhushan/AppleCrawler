package online.solution.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import online.solution.accessLog.AccessLogData;
import online.solution.database.MongoConnection;

import org.springframework.data.document.mongodb.MongoOperations;

/**
 * Servlet implementation class AccessLogTest
 */
@WebServlet("/AccessLogTest")
public class AccessLogTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccessLogTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		try {
			/*
						String path = request.getSession().getServletContext().getRealPath("Files");

						AccessLogReader aceessLog = new AccessLogReader();

						String line = "";

						AddToDB dB = new AddToDB();
						BufferedReader bufferedReader;
						bufferedReader = new BufferedReader(new FileReader(path + File.separator + "Sample.log"));
						while ((line = bufferedReader.readLine()) != null) {
							if (!line.trim().isEmpty()) {
								writer.println("line -> " + line);

								AccessLogData logData = aceessLog.readLine(line);
								if (logData != null) {
									// dB.addLogData(logData);
								}
							}
						}// End of while loop

						bufferedReader.close();
			*/
			MongoOperations mongoOperation = MongoConnection.startConnection();

			List<AccessLogData> list = mongoOperation.getCollection(AccessLogData.class);// find(query,
																							// Student.class);

			for (Iterator<AccessLogData> it = list.iterator(); it.hasNext();) {
				AccessLogData log = it.next();
				writer.println("</br></br>" + "IP -> " + log.getClientIpAddress() + "<br/><br/> Status -> "
						+ log.getResponseStatus());
			}

		}
		catch (Exception exception) {
			writer.println("Exception -> ....." + exception);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}
}
