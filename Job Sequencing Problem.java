class Solution
{
    public static class MyComparator implements Comparator<Job>{
        public int compare(Job obj1, Job obj2)
        {
            if(obj1.profit != obj2.profit)
            {
                return obj2.profit - obj1.profit; //other - this 
            }
            return obj2.deadline - obj1.deadline;
        }
    }
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, new MyComparator());
        int maxDeadline = 0;
        for(int i = 0; i < n; i++)
        {
            maxDeadline = Math.max(arr[i].deadline, maxDeadline);
        }
        boolean slot[] = new boolean [maxDeadline];
        int maxProfit = 0;
        int jobsAllocated = 0;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = arr[i].deadline - 1; j >= 0; j--)
            {
                if(slot[j] == false)
                {
                    slot[j] = true;
                    jobsAllocated ++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        return new int[] {jobsAllocated , maxProfit};
    }
}
