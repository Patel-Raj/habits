package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddHabit extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
		BinarySearch bs = applicationContext.getBean("binarySearch", BinarySearch.class);
		bs.pintVal();
		System.out.println("doGet called");
		String habitName = req.getParameter("habit_name");
		String habitStartDate = req.getParameter("habit_start_date");
		System.out.println(habitName + " " + habitStartDate);
	}
}
