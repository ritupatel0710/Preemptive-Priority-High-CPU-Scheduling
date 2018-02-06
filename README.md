# Preemptive-Priority-High-CPU-Scheduling

## Description of Scheduling Algorithm

In preemptive priority high scheduling algorithm, priority is associated with each process, and the CPU is allocated to the process with the highest priority. Higher number means higher priority and lower number means low priority according to arrival time and burst time also given. Preemptive task that means break the execution any time. Here we are going to break execution because it might happen that the process which we are currently running at the same time there is new process coming too and priority of that new process is highest than the currently running process. So we have to stop currently running process and give the priority to highest priority process. We have given quantum value, so we execute all processes based on that quantum value with same scenario. 

## Description of Implementation

1. Read input.data and scan each value. Store number of processes in numProcess and so on.

2. Initialize PCB for each process with arrival time, burst time, priority and process number. 

3. Make array of PCB which stores the each Process.

4. Sort PCB array according to arrival time of processes.

5. Make other array readyQueue of type Object from PCB, which is also sorted according to arrival time of processes.

6. Set timer according to value of quantum.

7. Processes whose arrival time is less or equal to timer, store them into readyQuePri array.

8. Find maximum priority process from readyQuePri array. Execute that process number of times equal to the value of quantum. 

    -If that process’s cpu_burst is higher or equal to quantum value than execute that process number of times equal to the value of quantum.Adjust timer to the addition of time and process’s cpu_burst. Adjust cpu_burst of that process.

    -If that process’s cpu_burst is less than quantum value than execute that number of times equal to its cpu_burst . Adjust timer and make cpu_burst to zero.

    -If process’s cpu_burst is zero than remove that process from the readyQueue and add next higher priority process with accordance of quantum.

    -If cpu is idle at any time, adjust value of timer and do nothing.

9. Repeat step 7, 8 until readyQueue become empty.
10. When readyQueue gets empty, Write output in output.data file.
 
## Conclusion
It minimizes the average waiting time of the processes and maximizes CPU utilization. 
If a high priority process frequently arrives in the ready queue, low priority process may starve

## Helpful URLS
https://www.techopedia.com/definition/21478/priority-scheduling
http://ijcsmc.com/docs/papers/September2015/V4I9201563.pdf
