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
import servlets.dao.HabitRecordDao;
import servlets.pojo.Habit;
import servlets.pojo.HabitRecord;

public class TrackProgressServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
		System.out.println("TrackProgress called");
		HabitDao habitDao = applicationContext.getBean("habitDaoImpl", HabitDao.class);
		HabitRecordDao habitRecordDao = applicationContext.getBean("habitRecordDaoImpl", HabitRecordDao.class);
		List<Habit> habits = habitDao.getAllTrackedHabits();
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<hr><hr>");
		for(int i = 0 ; habits!= null && i < habits.size(); i++) {
			List<HabitRecord> habitRecords = habitRecordDao.getHabitRecords(habits.get(i).getHabit_id());
			writer.println("<h3>You have stuck to : " + habits.get(i).getHabit_name() + " for " + habitRecords.size() + 
					" days starting from " + habits.get(i).getEffective_start_date() + "</h3>");
		}
		writer.println("<hr><hr>");
	}
}
