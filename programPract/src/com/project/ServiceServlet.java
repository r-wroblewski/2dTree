package com.project;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opencsv.exceptions.CsvValidationException;

/**
 * Servlet implementation class ServiceServlet
 */
@WebServlet(
        name = "selectliquorservlet",
        urlPatterns = {"/GetNearest", "/AddPoint" }
)

public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KdTree tree = new KdTree();
//	private Point2D coord = new Point2D(0.6, 0.8);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceServlet() {
        super();
        //KdTree tree = new KdTree();
        // TODO Auto-generated constructor stub
//        System.out.println("SUPER");
//		try (
//			Reader reader = Files.newBufferedReader(Paths.get("uscities.csv"));
//			CSVReader csvReader = new CSVReader(reader);
//		) {
//			 String[] nextRecord;
//			 while ((nextRecord = csvReader.readNext()) != null) {
//				 	System.out.println(nextRecord[8]);
//				 	double lat = Double.parseDouble(nextRecord[8]);
//				 	double longi = Double.parseDouble(nextRecord[9]);
//				 	String city = nextRecord[0];
//				 	Point2D newPoint = new Point2D(lat, longi, city);
//					tree.insert(newPoint);
//				}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (CsvValidationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
    }
    
    public void init() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		KdTree tree = new KdTree();
//    	ReadFile reader = new ReadFile();
//    	try {
//			tree = reader.readCsv(tree);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	System.out.println(tree.size());
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String xC;
		String yC;
		xC = request.getParameter("xpoint1");
		yC = request.getParameter("ypoint1");
		
		
		double xCoord = Double.parseDouble(xC);
		double yCoord = Double.parseDouble(yC);
		
		System.out.println(xCoord);
		System.out.println(yCoord);
		
		Point2D newPoint = new Point2D(xCoord, yCoord);
		
		System.out.println(xCoord);
		System.out.println(yCoord);
		
		tree.insert(newPoint);
		RequestDispatcher view = request.getRequestDispatcher("/index.html");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//double xCoord = 0;
		//double yCoord = 0;
		
		String xC = null;
		String yC = null;
		xC = request.getParameter("xpoint2");
		yC = request.getParameter("ypoint2");
		
		
		double xCoord = Double.parseDouble(xC);
		double yCoord = Double.parseDouble(yC);
		
		System.out.println(xCoord);
		System.out.println(yCoord);
		
		Point2D newPoint = new Point2D(xCoord, yCoord);
		
		Point2D close = tree.nearest(newPoint);

        //Service liquorService = new Service();
        //Types l = Types.valueOf(liquorType);

        //List liquorBrands = liquorService.getAvailableBrands(l);

        //request.setAttribute("brands", liquorBrands);
        request.setAttribute("point", close);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
	}

}
