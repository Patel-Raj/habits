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

public class InsertRecordServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
		System.out.println("InsertRecordServlet called");
		HabitRecordDao habitRecordDao = applicationContext.getBean("habitRecordDaoImpl", HabitRecordDao.class);
		System.out.println("doGet called");
		String habitId = req.getParameter("habit_id");
		String habitDate = req.getParameter("habit_date");
		
		HabitRecord habitRecord = new HabitRecord(habitRecordDao.getMaxId()+1, Date.valueOf(habitDate) , Integer.parseInt(habitId));
		System.out.println(habitRecord);
		habitRecordDao.insert(habitRecord);
	}
}
