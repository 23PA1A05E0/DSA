import java.util.*;

class Job {
    int profit;
    int deadline;
    int id;

    Job(int id, int profit, int deadline) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline; 
    }
}

public class JobSequencing {
    public static void maxProfit(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);  // Sort jobs by profit in descending order

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        boolean[] slots = new boolean[maxDeadline]; 
        int[] result = new int[maxDeadline];
        int totalProfit = 0;

        for (Job job : jobs) {
            for (int j = Math.min(job.deadline - 1, maxDeadline - 1); j >= 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    result[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Print selected jobs
        System.out.println("Selected Jobs:");
        for (int j : result) {
            if (j != 0) {
                System.out.print(j + " ");
            }
        }
        System.out.println("\nTotal Profit = " + totalProfit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Jobs:");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];

        System.out.println("Enter id, profit, deadline for each job:");
        for (int i = 0; i < n; i++) {  
            int id = sc.nextInt();
            int profit = sc.nextInt();
            int deadline = sc.nextInt();
            jobs[i] = new Job(id, profit, deadline);
        }

        maxProfit(jobs);
    }
}
