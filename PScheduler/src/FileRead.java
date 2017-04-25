
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Libtech
 */
public class FileRead {
    
     public Queue<Process> read(String fileName) {
       BufferedReader br = null;
       java.io.FileReader fr = null;
       Queue<Process> processQueue = null;
       try {
           String sCurrentLine;
           fr = new java.io.FileReader(new File(fileName));
           br = new BufferedReader(fr);
           processQueue = new LinkedList<Process>();
           while ((sCurrentLine = br.readLine()) != null) {
               System.out.println(sCurrentLine);
               String line[] = sCurrentLine.split(",");

               Process p = new Process(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                       Integer.parseInt(line[3]));
               processQueue.add(p);
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               if (br != null)
                   br.close();
               if (fr != null)
                   fr.close();
           } catch (IOException ex) {
               ex.printStackTrace();
           }
       }
       return processQueue;
}}
