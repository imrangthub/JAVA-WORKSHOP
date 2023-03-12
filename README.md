

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
          
# web.xml

            <web-app>

            <servlet>
            <servlet-name>imranServlet</servlet-name>
            <servlet-class>SimpleServlet</servlet-class>
            </servlet>
            
            <servlet-mapping>
            <servlet-name>imranServlet</servlet-name>
            <url-pattern>/user-info</url-pattern>
            </servlet-mapping>

            </web-app>
          
          



#java-executable-jar-creating


Class
---------------------------
    import java.util.ArrayList;
    import java.util.List;

    public class MyMainCls {
      public static void main(String[] args ){
        System.out.println("MyMain Start successfully done !");
        System.out.println();
        List<String> strList = new ArrayList<String>();

        strList.add("MyValue1");
        strList.add("MyValue2");
        strList.add("MyValue3");

        for(String val:strList) {
          System.out.println(val);
        }
        
      }
    }
    
    
Comment:
------------------
=>javac MyMainCls.java
=>java MyMainCls




# java-executable-jar-creating
Different way an Executable Java Jar creation.

In Java, it is common to combine several classes in one .jar ("java archive") file.  Library classes are stored that way.  Larger projects use jar files.  You can create your own jar file combining several classes, too. 

jar files are created using the jar.exe utility program from the JDK.  You can make your jar file runnable by telling jar.exe which class has main.  To do that, you need to create a manifest file.  A manifest is a one-line text file with a "Main-Class" directive.  For example:

Main-Class: Craps
This line must end with a newline. 

A jar file created with a main class manifest can be used both as a library and a runnable jar.  If you use it as a library, you can edit and compile any of the classes included in the jar, and add it to your project.  Then it will override the one in the jar file.

You can create a manifest file in any text editor, or even by using the MS-DOS echo command.  You can give your manifest file any name, but it's better to use something standard, such as manifest.txt. 

Once you have a manifest and all your classes have been compiled, you need to run JDK's jar.exe utility.  It is located in the JDK’s bin folder, the same place where javac.exe and java.exe are.  jar.exe takes command-line arguments; if you run it without any arguments, it will display the usage information and examples.  You need

C\mywork> jar cvfm MyJarName.jar manifest.txt *.class
cvfm means "create a jar; show verbose output; specify the output jar file name; specify the manifest file name."  This is followed by the name you wish to give to your jar file, the name of your manifest file, and the list of .class files that you want included in the jar.  *.class means all class files in the current directory.

Actually, if your manifest contains only the Main-Class directive, you can specify the main class directly on the jar.exe's command line, using the e switch, instead of m.  Then you do not need a separate manifest file; jar will add the required manifest to your jar file for you. For example:

             => jar cvef MyMainCls MyMainCls.jar *.class
             =>java -jar MyMainCls.jar
             
OR with a manifiest file

            =>jar -cvfm MyMainCls.jar manifest.txt *.class
            
            
 manifest.txt
 
            Main-Class: MyMainCls
            
 
 



View sources of used Java classes in IntelliJ Idea
--------------------------------------------------------

In order to add sources choose:

        File | Project Structure
        Click Libraries tab
        Pick library and click + icon
        Find a JAR file containing sources.
        
        
   Docker
   =====================
       =>docker pull imranmadbar/hello-world-java-maven-web-spring-boot
       =>docker run --name SpringBootWebApp -p 8080:8080 -d imranmadbar/hello-world-java-maven-web-spring-boot
