class Solution {
  public int hIndex(int[] citations) 
{
    int maximalIndex = 0;
    int hIndex = 1;
    
    
    // Handle the singleton case
    if(citations.length == 1)
    {
        if(citations[0] != 0) return 1;
        else return 0;
    }
    
    Arrays.sort(citations);

    // Parition : (n-h):(h) papers - h/n have at least h citations
    int low = 0;
    int high = citations.length - 1;
    while(low <= high)
    {
        int mid = ( low + high ) / 2; // low + ((high-low)/2);
        hIndex = citations.length - mid;
        if(citations[mid] >= hIndex)
        {
            if(mid == 0) // can not grow hIndex any more here
            {
                maximalIndex = hIndex;
                break;
            }
            if(mid != 0 && citations[mid-1] <= hIndex) // the other (n-h) have no more values
            {
                maximalIndex = hIndex;
                high = mid - 1; // check above now
            }
            else
            {
                high = mid - 1;
            }
        }
        else
        {
            low = mid + 1; // any ( array indices <= mid ) fail already ; no greater h-index works
        }
        
    }
    return maximalIndex;
}
}