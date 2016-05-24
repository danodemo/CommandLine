package tiy.clinterpreter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Created by danarchy on 5/24/16.
 */
public class CLBroBoard {

    public static Scanner linescanner = new Scanner(System.in);

    public static String user;

    public static void main (String[] args) {
        welcome();
        greeting(user);
        menu();
    }

    public static String userPrompt() {
        print("Type your command now:");
        System.out.print(">");
        String userInput = linescanner.next();
        return userInput;
    }

    public static String greeting(String userName) {
        print("Greetings and salutations, " + userName + ", and welcome to the Iron Interpreter!");
        return userName;
    }

    public static void menu() {
        print(" ");
        print("*************************************************");
        print("Type the following commands to do stuff:");
        print("-----------------------------------------");
        print("greetings - Display the greeting message again");
        print("time - Display the current time");
        print("date - Display the current date");
        print("day - Display the current day of the week");
        print("monkey dance - Take a wild guess...");
        print("exit - exit the program");
        print("*************************************************");
        print(" ");
        System.out.print(">");
        String userChoice = userPrompt();
        if (userChoice.toLowerCase().equals("greetings")){
            greeting(user);
            menu();
        } else if (userChoice.toLowerCase().equals("time")){
            LocalDateTime now = LocalDateTime.now();
            getTime(now);
            menu();
        } else if (userChoice.toLowerCase().equals("date")){
            LocalDateTime now = LocalDateTime.now();
            getDate(now);
            menu();
        } else if (userChoice.toLowerCase().equals("day")){
            LocalDateTime now = LocalDateTime.now();
            getDay(now);
            menu();
        } else if (userChoice.toLowerCase().equals("exit")){
            print("See you later, gator!");
            System.exit(0);
        } else {
            print("That is not a valid command, please choose again!");
        }
    }

    public static String getDay(LocalDateTime now) {
        DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("EEEE");
        String dayString =("Today is " + now.format(dayFormat) + "!");
        print(" ");
        print(dayString);
        print(" ");
        return dayString;
    }

    public static String getDate(LocalDateTime now) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, y");
        String dateString = now.format(dateFormat);
        print(" ");
        print(dateString);
        print(" ");
        return dateString;
    }

    public static String getTime(LocalDateTime now) {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:m:s a");
        String timeString = now.format(timeFormat);
        print(" ");
        print(timeString);
        print(" ");
        return timeString;
    }

    public static void welcome() {
        print("Welcome to the Command Line!  Please enter your name!");
        System.out.print(">");
        user = linescanner.next();
    }

    private static void print(String message){
        System.out.println(message);
    }

}
