package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weight = request.getParameter("weight");
        double w = Double.parseDouble(weight);
        String height = request.getParameter("height");
        double h = Double.parseDouble(height);
        
        //TODO: calculate bmi
        double bmi = Math.round(w/(h*h));

        //TODO: determine the built from BMI
        String bmi_result = "";

        if(bmi<18.5){
            bmi_result = "underweight";
        }
        else if(bmi < 25 && bmi >= 18.5){
            bmi_result = "normal";
        }
        else if(bmi < 30 && bmi >= 25){
            bmi_result = "overweight";
        }
        else if(bmi < 35 && bmi >= 30){
            bmi_result = "obese";
        }
        else if(bmi >= 35){
            bmi_result = "extremely obese"; 
        }

        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", bmi);
        request.setAttribute("bmi_result", bmi_result);

        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);     
        
    }
    
}
