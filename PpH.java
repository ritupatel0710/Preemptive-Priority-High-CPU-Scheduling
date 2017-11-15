import java.io.*;
import java.util.*;
public class PpH{
	public static void main(String p[]) throws UnsupportedEncodingException{
		int numProcess, preemptive,quantum, sum = 0,sumA =0,q;
		
		int arrivalTime[],burstTime[],priority[];
		Object readyQueue[],readyQueuePri[],readyQueueMaxPri[];
		PCB pcb[];
		File file = new File("input.data");

		try{
			Scanner sc = new Scanner(file);
			numProcess = sc.nextInt();
			arrivalTime = new int[numProcess];
			burstTime = new int[numProcess];
			priority = new int[numProcess];
			readyQueue = new Object[numProcess];
			readyQueuePri= new Object[numProcess];
			readyQueueMaxPri = new Object[numProcess];
			pcb = new PCB[numProcess];
			preemptive = sc.nextInt();
			quantum = sc.nextInt();
			q=quantum;
			int i=0;
			while (sc.hasNextLine()){
				arrivalTime[i] = sc.nextInt();
				burstTime[i] = sc.nextInt();
				priority[i]=sc.nextInt();
				//System.out.println(arrivalTime[i]);
				//System.out.println(burstTime[i]);
				//System.out.println(priority[i]);
				PCB p1 = new PCB(arrivalTime[i],burstTime[i],priority[i],i+1);
				pcb[i]=p1;
				//System.out.println(pcb[i].AT);
				
				i++;
			}
			for(int t=0;t<pcb.length-1;t++) {
				int index=t;
				for(int q=t+1;q<pcb.length;q++) 
					if(pcb[q].AT<pcb[index].AT)
						index= q;
				PCB smallernum = pcb[index];
				pcb[index]=pcb[t];
				pcb[t]=smallernum;
					//System.out.println(pcb[t].AT);
					//System.out.println(pcb[index].AT);	
			}
			for(int t1=0;t1<pcb.length;t1++) {
				readyQueue[t1] = pcb[t1];
				System.out.println("AT "+pcb[t1].AT+" BT "+pcb[t1].CPU_Burst+" Num "+pcb[t1].processNum);
			}
			for(int k=0;k<numProcess;k++){
				int maximumPri;
				for(int a=0;a<numProcess;a++){
					if(((PCB)readyQueue[a]).AT<=q)
						readyQueuePri[a]=(PCB)readyQueue[a];
				}
				maximumPri=max(readyQueuePri);
				if((PCB)readyQueuePri[maximumPri].CPU_Burst>=quantum){
					(PCB)readyQueuePri[maximumPri].CPU_Burst = (PCB)readyQueuePri[maximumPri].CPU_Burst - q;
					q=q+quantum;
				}
				else{
					q=q+(PCB)readyQueuePri[maximumPri].CPU_Burst;
				}
					
			}
			
			sc.close();
		} 
		catch (FileNotFoundException e){
			e.printStackTrace();
		}	
	}
	public static int max(Object[] obj){
		for(int t=0;t<obj.length-1;t++) {
				int index=t;
				for(int q=t+1;q<obj.length;q++) 
					if(obj[q].priority>obj[index].priority)
						index= q;
				//Object smallernum = obj[index];
				//obj[index]=obj[t];
				//obj[t]=smallernum;
					//System.out.println(pcb[t].AT);
					//System.out.println(pcb[index].AT);	
			}
			return index;
	}
}
