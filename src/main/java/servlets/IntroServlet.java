package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
		BinarySearch bs = applicationContext.getBean("binarySearch", BinarySearch.class);
		bs.pintVal();
		System.out.println("doGet called");
		
		
		
	}
}
