class Solution
{
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        Collections.sort(a);
        long ans = Long.MAX_VALUE;
        for(int w = 0; w <= (int) (n-m); w++)
        {
            long Max = a.get(w + (int) m -1);
            long Min = a.get(w);
            
            ans = Math.min(ans, Max - Min);
        }
        return ans;
    }
}
