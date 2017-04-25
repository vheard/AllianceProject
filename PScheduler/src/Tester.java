import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Queue;
import java.util.Scanner;

public class Tester {

    
   
     
     public static void main(String[] args) throws FileNotFoundException{
         
             FileRead f = new FileRead();
             //Scanner in = new Scanner(System.in);
             //File file = new File(in);
             //Scanner input = new Scanner(new BufferedReader(new FileReader("*.csv")));
             
             Queue <Process> qp = f.read("‪input.txt");
             Processor p = new Processor(qp);
             p.priorityFirst();
         
     }
}