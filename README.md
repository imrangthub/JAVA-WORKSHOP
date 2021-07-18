

#Create a Servlet

            import javax.servlet.http.*;
            import javax.servlet.*;
            import java.io.*;
            public class SimpleServlet extends HttpServlet{

              public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

                System.out.println("====================  Get Request ================================");
                  System.out.println();
                  System.out.println("ReqObj:"+req.toString());
                  System.out.println();
                res.setContentType("text/html");//setting the content type  
                PrintWriter pw=res.getWriter();//get the stream to write the data  
                String name = req.getParameter("name");
                if(name != null) {
                    System.out.println("ParamVal: "+name);
                  pw.println("<html><body>");  
                  pw.println("Message from simple servlet !");  
                    pw.println("Welcome: "+name);  
                  pw.println("</body></html>");  
                }else {
                    System.out.println("ParamVal: No Param found !");
                  pw.println("<html><body>");  
                  pw.println("Message from simple servlet !");  
                  pw.println("</body></html>");  
                }
                pw.close();//closing the stream 
                  System.out.println();
                  System.out.println("ResObj:"+res.toString());
              }

            }
            
            
# Compile java file

          javac -classpath "C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar" SimpleServlet.java
