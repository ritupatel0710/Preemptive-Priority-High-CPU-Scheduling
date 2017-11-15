public class PCB{
	public int AT=0,CPU_Burst=0,priority=0,processNum = 0;
	public PCB(int A,int C,int processnum){
		AT = A;
		CPU_Burst = C;
		processNum=processnum;
		System.out.println("AT= "+AT+"CPU_Burst :"+CPU_Burst);
		//priority = priority;
	}
	public PCB(int a,int c,int p,int processn){
		AT = a;
		CPU_Burst = c;
		priority = p;
		processNum=processn;
		System.out.println("AT= "+AT+"CPU_Burst :"+CPU_Burst+"Pri: "+priority+"processNum : "+processNum);
	}
}