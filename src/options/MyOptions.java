/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package options;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author matheusdiniz
 */
public class MyOptions {
    
    /**
     * 
     * @param queryResults inputs into the method to display the query to the user and if there is an error it also shows them.
     * @param flag check either if the query is empty or not.
     * @return return the booleanFlag value to keep running the loop if the query is equal to null or if it could get some result from it.
     * @throws SQLException 
     */
    public boolean firstOption(ResultSet queryResults, boolean flag) throws SQLException {
        
        while (queryResults.next()){
            flag = false;
            System.out.println("TITLE: " + queryResults.getString(1) + " \tSALARY: " + queryResults.getDouble(2));               
        } 
        if (flag) {
            System.out.println("\nTitle not found on the Company's database, please type a valid title.");
        }         

        return flag;
    }
    /**
     * 
     * @param queryResults inputs into the method to display the query to the user and if there is an error it also shows them.
     * @param flag check either if the query is empty or not.
     * @return return the booleanFlag value to keep running the loop if the query is equal to null or if it could get some result from it.
     * @throws SQLException 
     */
    public boolean secondOption(ResultSet queryResults, boolean flag) throws SQLException {
        
        while (queryResults.next()){
            flag = false;
            System.out.println("GENDER: " + queryResults.getString(3) + "\tNAME: " + queryResults.getString(1) + " " + queryResults.getString(2));               
        } 
        if (flag) {
            System.out.println("\nGender not found on the Company's database, please type a valid Gender.");
        }          

        return flag;
    }
    /**
     * 
     * @param queryResults inputs into the method to display the query to the user and if there is an error it also shows them.
     * @param flag check either if the query is empty or not.
     * @return return the booleanFlag value to keep running the loop if the query is equal to null or if it could get some result from it.
     * @throws SQLException 
     */
    public boolean tirdOption(ResultSet queryResults, boolean flag) throws SQLException {
        
        while (queryResults.next()){
            flag = false;
            System.out.println("NUMB OF TITLES: " + queryResults.getInt(3) + "\tNAME: " + queryResults.getString(1) + " " + queryResults.getString(2));               
        } 
        if (flag) {
            System.out.println("\nNumber of titles out of range on the Company's database, please type a valid range beteween 0 and 3.");
        }         

        return flag;
    }
    /**
     * 
     * @param queryResults inputs into the method to display the query to the user and if there is an error it also shows them.
     * @param flag check either if the query is empty or not.
     * @return return the booleanFlag value to keep running the loop if the query is equal to null or if it could get some result from it.
     * @throws SQLException 
     */
    public boolean fourthOption(ResultSet queryResults, boolean flag) throws SQLException {
        
        while (queryResults.next()){
            flag = false;
            System.out.println("TITLE: " + queryResults.getString(3) + "\tNAME: " + queryResults.getString(1) + " " + queryResults.getString(2));               
        } 
        if (flag) {
            System.out.println("\nTitle not found on the Company's database, please type a valid title.");
        }         

        return flag;
    }
    /**
     * 
     * @param queryResults inputs into the method to display the query to the user and if there is an error it also shows them.
     * @param flag check either if the query is empty or not.
     * @return return the booleanFlag value to keep running the loop if the query is equal to null or if it could get some result from it.
     * @throws SQLException 
     */
    public boolean fifthOption(ResultSet queryResults, boolean flag) throws SQLException {
        
        while (queryResults.next()){
            flag = false;
            System.out.println("HIRE DATE: " + queryResults.getString(3) + "\tNAME: " + queryResults.getString(1) + " " + queryResults.getString(2));               
        } 
        if (flag) {
            System.out.println("\nDate not found on the Company's database, please type a valid date format.");
        }         

        return flag;
    }
    /**
     * 
     * @param queryResults inputs into the method to display the query to the user and if there is an error it also shows them.
     * @param flag check either if the query is empty or not.
     * @return return the booleanFlag value to keep running the loop if the query is equal to null or if it could get some result from it.
     * @throws SQLException 
     */
    public boolean sixthOption(ResultSet queryResults, boolean flag) throws SQLException {
        
        while (queryResults.next()){
            flag = false;
            System.out.println("EMP NUMB: " + queryResults.getInt(1) + " \tSALARY: " + queryResults.getInt(4) + "\tNAME: " + queryResults.getString(2) +" "+ queryResults.getString(3));               
        } 
        if (flag) {
            System.out.println("\nSalary Range not found on the Company's database, please type a valid Range.");
        }         

        return flag;
    }
    /**
     * 
     * @param queryResults inputs into the method to display the query to the user and if there is an error it also shows them.
     * @param flag check either if the query is empty or not.
     * @return return the booleanFlag value to keep running the loop if the query is equal to null or if it could get some result from it.
     * @throws SQLException 
     */
    public boolean seventhOption(ResultSet queryResults, boolean flag) throws SQLException {
        
        while (queryResults.next()){
            flag = false;
            System.out.println("SALARY: " + queryResults.getInt(4) + "\tNAME: " + queryResults.getString(3) +" "+ queryResults.getString(2));               
        } 
        if (flag) {
            System.out.println("\nSalary amount not found on the Company's database, please type a valid Salary amount.");
        }         

        return flag;
    }
    
}
