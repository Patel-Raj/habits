package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servlets.dao.HabitDao;
import servlets.pojo.Habit;

public class AddHabit extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
		HabitDao habitDao = applicationContext.getBean("habitDaoImpl", HabitDao.class);
		System.out.println("doGet called");
		String habitName = req.getParameter("habit_name");
		String habitStartDate = req.getParameter("habit_start_date");
		String habitEndDate = "4712-12-31"; 
		Habit habit = new Habit(habitDao.getMaxId()+1, Date.valueOf(habitStartDate) , Date.valueOf(habitEndDate), habitName);
		System.out.println(habit);
		habitDao.insert(habit);
	}
}
