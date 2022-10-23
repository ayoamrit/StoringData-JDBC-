import java.util.Scanner;
//details of current students.
public class CurrentStudent {

    //scanner to get input
    Scanner input = new Scanner(System.in);

    public String promptLoginEmail(){

        System.out.print("Enter Your Email: ");

        //returning currentStudent email
        return input.nextLine();
    }

    public String promptLoginPassword(){

        System.out.print("Enter Your Password: ");

        //returning currentStudent password
        return input.nextLine();

    }
}

