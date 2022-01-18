package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servlets.dao.HabitDao;
import servlets.pojo.Habit;

public class AddRecordServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
		System.out.println("AddRecordServlet called");
		HabitDao habitDao = applicationContext.getBean("habitDaoImpl", HabitDao.class);
		List<Habit> habits = habitDao.getAllTrackedHabits();
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<hr><hr>");
		writer.println("<h2>Habits being tracked are : </h2>");
		writer.println("<h4>Habit Id => Habit Name</h4>");
		if(habits != null && habits.size() > 0) {
			for(int i = 0 ; i <habits.size(); i++) {
				writer.println("<h4>" + habits.get(i).getHabit_id() + " => " + habits.get(i).getHabit_name() + "</h4>");
			}
			writer.println("<hr><hr>");
			writer.println("<form action=\"insertRecord\" method = \"get\">");
			writer.println("Habit Id : <input type=\"number\" name=\"habit_id\" placeholder=\"Enter Id\"><br><br>");
			writer.println("Date : <input type=\"date\" name=\"habit_date\" placeholder=\"Enter Date\"><br><br>");
			writer.println("<input type=\"submit\"> <input type=\"Reset\">");
			writer.println("</form>");
			writer.println("<a href=\".\">Back to home</a>");
		} else {
			writer.println("<h3>No habits are tracked</h3>");
		}	
	}
}

/*<a href="addHabitRecord">click me</a>
 * 
 * 
 * 
 * 
 * <form action="addHabit" method = "post">
		 Habit Name : <input type="text" name="habit_name" placeholder="Enter Habit"><br><br>
		 Start Date : <input type="date" name="habit_start_date" placeholder="Enter Date"><br><br>
		<input type="submit"> <input type="Reset">
		</form>
 */
