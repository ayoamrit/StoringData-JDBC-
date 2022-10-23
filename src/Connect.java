import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Connect {

    //the following variables contain url, username and password of the local SQL server
    private static final String url = "jdbc:mysql://localhost:3306/practice";
    private static final String username = "UsernameGoesHere";
    private static final String password = "PasswordGoesHere";


    //scanner to get user input
    Scanner input = new Scanner(System.in);

    //nested class to connect to FutureStudents database
    class FutureStudentConnect{

        //an object of FutureStudents class
        FutureStudent futureStudentCall = new FutureStudent();

        //ArrayList
        ArrayList<String> futureStudentArray = futureStudentCall.studentDetails();

        //constructor
        FutureStudentConnect(){

            //trying to connect to the SQL server
            try(Connection futureConn = DriverManager.getConnection(url, username, password)){

                //creating statement object to execute SQL queries
                Statement futureStat  = futureConn.createStatement();

                //checking if the Student account exist or not
                ResultSet Rs = futureStat.executeQuery(accountExist());


                if(!Rs.next()){

                    //executing INSERT query to create an account for a FutureStudent
                    futureStat.executeUpdate(createAccount());

                    System.out.println(); //leaving space

                    System.out.println("Account has been created");

                }
                else{
                    System.out.println();//leaving space
                    System.out.println("Account already exist");
                }


                //throwing exception if Java did not connect to SQL
            }catch(Exception e) {System.out.print("Unable to connect to MySQL database: "+e);}
        }

        private String accountExist(){

            //returning SELECT query
            return "select Password from userdata where Email = '"+futureStudentArray.get(2)+"'";
        }

        private String createAccount(){

            //returning INSERT query
            return "insert into userdata VALUES (" + "'" + futureStudentArray.get(0) + "', '" +
                    futureStudentArray.get(1) + "' , '" + futureStudentArray.get(2) + "', '"
                    + futureStudentArray.get(3) + "')";
        }

    }


    //nested class to connect to CurrentStudents database
    class CurrentStudentConnect{

        //object of CurrentStudent class
        CurrentStudent currentStudentCall = new CurrentStudent();

        //constructor
        CurrentStudentConnect(){

            //trying to connect to the sql server
            try(Connection currentConn = DriverManager.getConnection(url, username, password)){

                //using statement to execute SQL queries
                Statement currentStat = currentConn.createStatement();

                //calling method from CurrentStudent class
                String currentStudentEmail = currentStudentCall.promptLoginEmail();

                //executing query
                ResultSet Rs = currentStat.executeQuery(accountExist(currentStudentEmail));

                //checking if account exists or not
                if(!Rs.next()){

                    System.out.println(); //leaving space
                    System.out.println("Account does not exist");
                }
                else{

                    //calling method from CurrentStudent class
                    String promptPassword = currentStudentCall.promptLoginPassword();

                    //getting query output
                    String savedPassword = Rs.getString("Password");

                    if(savedPassword.equals(promptPassword)){

                        //executing query and calling method accountData
                        Rs = currentStat.executeQuery(accountData(currentStudentEmail));

                        //printing students first and last name using while loop
                        while(Rs.next()){

                            System.out.println(); //leaving space
                            System.out.println("Connected Successfully");
                            System.out.println("First Name: "+Rs.getString("FirstName"));
                            System.out.println("Last Name: "+Rs.getString("LastName"));
                        }
                    }

                    //if password is incorrect
                    else{

                        System.out.println(); //leaving space
                        System.out.println("Incorrect Password");
                    }
                }

                //throwing exception if Java did not connect to the local SQL server
            }catch(Exception e){
                System.out.println("Unable to connect to MySQL database: "+e);
            }
        }

        private String accountExist(String email){

            //returning SELECT query
            return "select Password from userdata where Email = '"+email+"'";
        }

        private String accountData(String email){

            //returning SELECT query
            return "select * from userdata where Email = '"+email+"'";
        }

    }


    public void startUp(){
        System.out.println("\b\b");

        System.out.println("What Is Your Status At School?\n"
                +"1. Future Student\n"
                +"2. Current Student\n"
                +"3. Quit");

        System.out.print("Your Choice: ");


    }

}
