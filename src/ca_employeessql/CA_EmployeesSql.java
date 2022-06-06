/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_employeessql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import myutils.MyUtils;
import options.MyOptions;

/**
 *
 * @author matheusdiniz
 */
public class CA_EmployeesSql {

      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //declare inputs to MyUtils, Myoptions, scanner and variables necessary
        MyUtils input = new MyUtils();
        MyOptions myOption = new MyOptions();
        Scanner myKB = new Scanner(System.in);
        int optionChosen;    
        boolean flag = true;
        
        //try to do the connection to the databases, and if there is some error it catches it.
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?characterEncoding=latin1","root","root"); 
        
            System.out.println("Connected to DB...");
            
            Statement stmt=con.createStatement();  // we can use stmt to run any SQL statement now
            
            //do-while to run the main code, menu and structure
            do {
                //calls the menu
                input.getMenu();
                //asks the user for an input between 1 and 8
                optionChosen = input.getUserMenu("Pick an option", 1, 8);
                
                //in each case the user chooses an option, it does the respective one
                switch(optionChosen){
            case 1: 
                //do-while to ask the user to adjust the query as they want following the option choosen
                do {
                    String query = input.getUserText("What is the title you want to see the avarage of?");
                    //does the query with the input gave by the user
                    String myQuery = "SELECT title, AVG(salary) FROM salaries s INNER JOIN employees e ON e.emp_no = s.emp_no INNER JOIN titles t ON t.emp_no=s.emp_no WHERE t.title='"+ query +"' group by t.title LIMIT 1000";
                    //store the actual query into a Set
                    ResultSet queryResults = stmt.executeQuery(myQuery);
                    //calls the table created by the carry and displays it to the user and store the boolean flag returned by it
                    flag = myOption.firstOption(queryResults, flag);
         
                } while (flag);
                flag = true;
                break;
            case 2:
                do {
                    String query = input.getUserText("What gender you want to search for?");
                    String myQuery = "SELECT first_name, last_name, gender FROM employees WHERE gender = '"+query+"' LIMIT 1000";
                    ResultSet queryResults = stmt.executeQuery(myQuery);
                    
                    flag = myOption.secondOption(queryResults, flag);
       
                } while (flag);
                flag = true;
                break;
            case 3:
                do {
//                  limits were defined hard coded, after search done to see which employee had more titles and which has less titles on the DB.
                    int query = input.getUserIntValue("Do you want to see employees who have had more than how many titles?", 1, 3);
                    String myQuery = "SELECT first_name, last_name, COUNT(title) FROM titles t INNER JOIN employees e on e.emp_no=t.emp_no GROUP BY e.emp_no having COUNT(title) >= "+query+ " LIMIT 1000";
                    ResultSet queryResults = stmt.executeQuery(myQuery);
                     
                    flag = myOption.tirdOption(queryResults, flag);
        
                } while (flag);
                flag = true;
                break;
            case 4:
                do {
                    String query = input.getUserText("Type the title that you want to see the employees who works as it");
                    String myQuery = "SELECT first_name, last_name, title FROM employees e INNER JOIN titles t ON e.emp_no=t.emp_no WHERE title LIKE '"+query+"' LIMIT 1000";
                    ResultSet queryResults = stmt.executeQuery(myQuery);
                    
                    flag = myOption.fourthOption(queryResults, flag);
       
                } while (flag);
                flag = true;
                break;
            case 5:
                try {
                    do {
                        System.out.println("Type a date you want to see employees who were hired after it, please type in this format xxxx-xx-xx (year-month-day).");
                        String query = myKB.nextLine();
                        String myQuery = "SELECT first_name, last_name, hire_date FROM employees WHERE hire_date > '"+query+"' LIMIT 1000";
                        ResultSet queryResults = stmt.executeQuery(myQuery);
                        
                        flag = myOption.fifthOption(queryResults, flag);
        
                    } while (flag);
                flag = true;
                } catch (SQLException e) {
                    System.out.println("\n error - Format of date invalid, please choose option 5 again if you want to see it and type a correct format of date.");
                }
                
                break;

            case 6:
                do {
//                  limits were defined hard coded, after search done to see which is the biggest salary and the lowest salary on the DB.
                    int query = input.getUserIntValue("Type the first range value you want to search for.", 38623, 158220);
                    int query1 = input.getUserIntValue("Type the second range value you want to search for.", 38623, 158220);
                    String myQuery = "SELECT DISTINCT e.emp_no, first_name, last_name, salary FROM salaries s INNER JOIN employees e ON e.emp_no=s.emp_no WHERE salary BETWEEN "+query+" AND "+query1+" LIMIT 1000";
                    ResultSet queryResults = stmt.executeQuery(myQuery);
                    
                    flag = myOption.sixthOption(queryResults, flag);
        
                } while (flag);
                flag = true;
                break;
            case 7:
                do {
//                  limits were defined hard coded, after search done to see which is the biggest salary and the lowest salary on the DB.
                    int query = input.getUserIntValue("Type a salary amount you want to see the employees who earn more than it.", 38623,158220);
                    String myQuery = "SELECT DISTINCT e.emp_no, first_name, last_name, salary FROM salaries s INNER JOIN employees e ON e.emp_no=s.emp_no WHERE salary > "+query+" LIMIT 1000";
                    ResultSet queryResults = stmt.executeQuery(myQuery);
                    
                    flag = myOption.seventhOption(queryResults, flag);      
        
                } while (flag);
                flag = true;
                break;
            case 8:
                System.out.println("\nYou have decided to Exit/Quit the application.");
                break;
            default:
                System.out.println("Unknown Error -- the system didn't find what you typed!");
                break;
        }
                
            } while (optionChosen != 8 );
         
            //error catched if there's some error with the query requested, on the SQL connection or even some unkown error
        }catch(SQLException e){
                    
            System.out.println("SQL Error --> ");
             System.out.println(e.getMessage());
             System.out.println(e.getSQLState());//this will print out the exact message from the DB error
         }
        catch (ClassNotFoundException e){
            
            System.out.println("Class error -- " + e.getMessage());
        }
    }
    
}
