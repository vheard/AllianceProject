import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Processor {
   public Queue<Process> getWaitingQueue() {
       return (Queue<Process>) waitingQueue;
   }

   public void setWaitingQueue(Queue<Process> waitingQueue) {
       this.waitingQueue = waitingQueue;
   }

   public int getCurrentTime() {
       return currentTime;
   }

   public void setCurrentTime(int currentTime) {
       this.currentTime = currentTime;
   }

   public Queue<Process> getProcesses() {
       return processes;
   }

   public void setProcesses(Queue<Process> processes) {
       this.processes = processes;
   }

   public String getProcessorName() {
       return processorName;
   }

   public void setProcessorName(String processorName) {
       this.processorName = processorName;
   }

   public int getNumberOfProcesses() {
       return numberOfProcesses;
   }

   public void setNumberOfProcesses(int numberOfProcesses) {
       this.numberOfProcesses = numberOfProcesses;
   }

   public int getQuantumTime() {
       return quantumTime;
   }

   public void setQuantumTime(int quantumTime) {
       this.quantumTime = quantumTime;
   }

   public Processor(String processorName, int numberOfProcesses, int quantumTime) {
       super();
       this.processorName = processorName;
       this.numberOfProcesses = numberOfProcesses;
       this.quantumTime = quantumTime;
   }

   private String processorName;
   private int numberOfProcesses;
   private int quantumTime = 50;
   private Queue<Process> processes;

   // public void initProcessor(Queue<Process1> p) {
   // Process1 process1 = p.poll();
   // this.setProcessorName(process1.getProcessName());
   // this.setNumberOfProcesses(process1.getArrivalTime());
   // this.setQuantumTime(process1.getServiceTime());
   // this.setProcesses(p);
   // }

   public Processor() {
       super();
   }

   public Processor(Queue<Process> qp) {
       this.processes = qp;
   }

   private int currentTime = 0;

   public void FCFS() {
       Queue<Process> processes = this.getProcesses();
       int waitingTime = 0;
       int turnAroundTime = 0;
       int processCount = processes.size();
       System.out.println("Output :\nProcessName:SubmissionTime->BustTime");
       while (!processes.isEmpty()) {
           Process p = processes.poll();
           System.out.println(p.getProcessName() + ":" + currentTime + "->" + (currentTime + p.getServiceTime()));
           turnAroundTime += currentTime + p.getServiceTime() - p.getArrivalTime();
           waitingTime += currentTime - p.getArrivalTime();
           currentTime += p.getServiceTime();
       }
       System.out.println("Average Waiting Time: " + waitingTime / processCount);
       System.out.println("Average Turn Around Time: " + turnAroundTime / processCount);
   }

   private Queue<Process> waitingQueue = new LinkedList<Process>();

   public void RR() {
       Queue<Process> processes = this.getProcesses();
       int waitingTime = 0;
       int turnAroundTime = 0;
       int processCount = processes.size();
       while (!processes.isEmpty() || !waitingQueue.isEmpty()) {
           Iterator<Process> iter = this.getProcesses().iterator();
           while (iter.hasNext()) {
               Process process1 = iter.next();
               if (process1.getArrivalTime() <= currentTime) {
                   waitingQueue.add(process1);
                   iter.remove();
               }
           }
           Process p = waitingQueue.poll();
           int executionTime = (p.getServiceTime() < this.quantumTime) ? p.getServiceTime() : this.quantumTime;
           System.out.println(p.getProcessName() + ":" + currentTime + "->" + (currentTime + executionTime));
           p.setServiceTime(p.getServiceTime() - executionTime);
           p.setTotalExecutedTime(p.getTotalExecutedTime() + executionTime);
           currentTime += executionTime;
           if (p.getServiceTime() > 0) {
               waitingQueue.add(p);
           } else if (p.getServiceTime() == 0) {
               turnAroundTime += currentTime + p.getServiceTime() - p.getArrivalTime();
               waitingTime += currentTime - p.getArrivalTime() - p.getTotalExecutedTime();
           }
       }
       System.out.println("Average Waiting Time: " + waitingTime / processCount);
       System.out.println("Average Turn Around Time: " + turnAroundTime / processCount);
   }

   public void SJF() {
       Queue<Process> processes = this.getProcesses();
       int waitingTime = 0;
       int turnAroundTime = 0;
       int processCount = processes.size();
       while (!processes.isEmpty() || !waitingQueue.isEmpty()) {
           Iterator<Process> iter = this.getProcesses().iterator();
           while (iter.hasNext()) {
               Process process1 = iter.next();
               if (process1.getArrivalTime() <= currentTime) {
                   waitingQueue.add(process1);
                   iter.remove();
               }
           }
           Collections.sort((List<Process>) waitingQueue);
           Process p = waitingQueue.poll();
           int executionTime = p.getServiceTime();
           System.out.println(p.getProcessName() + ":" + currentTime + "->" + (currentTime + executionTime));
           p.setServiceTime(p.getServiceTime() - executionTime);
           p.setTotalExecutedTime(p.getTotalExecutedTime() + executionTime);
           currentTime += executionTime;
           if (p.getServiceTime() > 0) {
               waitingQueue.add(p);
           } else if (p.getServiceTime() == 0) {
               turnAroundTime += currentTime + p.getServiceTime() - p.getArrivalTime();
               waitingTime += currentTime - p.getArrivalTime() - p.getTotalExecutedTime();
           }
       }
       System.out.println("Average Waiting Time: " + waitingTime / processCount);
       System.out.println("Average Turn Around Time: " + turnAroundTime / processCount);
   }

   public void priorityFirst() {
       Queue<Process> processes = this.getProcesses();
       int waitingTime = 0;
       int turnAroundTime = 0;
       int processCount = processes.size();
       while (!processes.isEmpty() || !waitingQueue.isEmpty()) {
           Iterator<Process> iter = this.getProcesses().iterator();
           while (iter.hasNext()) {
               Process process1 = iter.next();
               if (process1.getArrivalTime() <= currentTime) {
                   waitingQueue.add(process1);
                   iter.remove();
               }
           }
           Priority ps = new Priority();
           Collections.sort((List<Process>) waitingQueue, ps);
           Process p = waitingQueue.poll();
           int executionTime = p.getServiceTime();
           System.out.println(p.getProcessName() + ":" + currentTime + "->" + (currentTime + executionTime));
           p.setServiceTime(p.getServiceTime() - executionTime);
           p.setTotalExecutedTime(p.getTotalExecutedTime() + executionTime);
           currentTime += executionTime;
           if (p.getServiceTime() > 0) {
               waitingQueue.add(p);
           } else if (p.getServiceTime() == 0) {
               turnAroundTime += currentTime + p.getServiceTime() - p.getArrivalTime();
               waitingTime += currentTime - p.getArrivalTime() - p.getTotalExecutedTime();
           }
       }
       System.out.println("Average Waiting Time: " + waitingTime / processCount);
       System.out.println("Average Turn Around Time: " + turnAroundTime / processCount);
   }
   
}

