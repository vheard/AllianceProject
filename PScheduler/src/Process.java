/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Libtech
 */
public class Process implements Comparable<Process>{
    public int getTotalExecutedTime() {
       return totalExecutedTime;
   }

   public void setTotalExecutedTime(int totalExecutedTime) {
       this.totalExecutedTime = totalExecutedTime;
   }

   public int getPriority() {
       return priority;
   }

   public void setPriority(int priority) {
       this.priority = priority;
   }

   public String getProcessName() {
       return processName;
   }

   public void setProcessName(String processName) {
       this.processName = processName;
   }

   public Process(String processName, int priority, int arrivalTime, int serviceTime) {
       super();
       this.processName = processName;
       this.arrivalTime = arrivalTime;
       this.serviceTime = serviceTime;
       this.priority = priority;
   }

   public int getArrivalTime() {
       return arrivalTime;
   }

   public void setArrivalTime(int arrivalTime) {
       this.arrivalTime = arrivalTime;
   }

   public int getServiceTime() {
       return serviceTime;
   }

   public void setServiceTime(int serviceTime) {
       this.serviceTime = serviceTime;
   }

   private String processName;
   private int arrivalTime;
   private int serviceTime;
   private int priority;
   private int totalExecutedTime = 0;

   @Override
   public int compareTo(Process o) {
       return this.serviceTime - o.getServiceTime();
   }
}

