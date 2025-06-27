import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaskManager {
    public static void newNote(){
        try{
        Scanner sc=new Scanner(System.in);
        FileWriter writer=new FileWriter("notes.txt",true);
        String content;
        System.out.println("enter the content:");
        content=sc.nextLine();
        writer.write(" "+content+"\n");
        writer.close();
        System.out.println("added successfully");
        
        }
        catch(IOException e){
            System.out.println("error has occured");
            e.printStackTrace();
        }
    }
public static void viewNote(){
        try{
       BufferedReader reader=new BufferedReader((new FileReader("notes.txt")));
       String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); 
            }
            reader.close();
        }
        catch(IOException e){
             System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        while(true){
            System.out.println(" ");
        System.out.println("Task Manager");
        System.out.println("1: Add note");
        System.out.println("2: view note");
    
        System.out.println("3:EXIT");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your choice:");
        int a=sc.nextInt();


        
            switch (a) {
                case 1:
                    newNote();
                    
                    break;
                case 2:
                    viewNote();
                    break;
                
                case 3:
                break;
                default:
                System.out.println("Invalid choice");
                    break;
            }

    }
    }
    }
