

#Create a Servlet

            import javax.servlet.http.*;
            import javax.servlet.*;
            import java.io.*;
            public class SimpleServlet extends HttpServlet{

              public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                System.out.println("====================  Get Request ================================");
                System.out.println("ParamVal: "+name);
              }

            }
            
            
# Compile java file

          javac -classpath "C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar" SimpleServlet.java
