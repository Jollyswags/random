class Solution {
public static int solve(int arr[],int k)
{
int ans=0;
HashMap<Integer,Integer> hm=new HashMap<>();
int i;
hm.put(0,1);
int sum=0;
for(i=0;i<arr.length;i++)
{
sum+=arr[i];
if(hm.containsKey(sum-k))
ans+=hm.get(sum-k);
if(hm.containsKey(sum))
hm.put(sum,hm.get(sum)+1);
else
hm.put(sum,1);
}
return ans;
}
public int numSubmatrixSumTarget(int[][] matrix, int target) {
int r=matrix.length;
int c=matrix[0].length;
int ans=0;
for(int i=0;i<r;i++)
{
int arr[]=new int[c];
for(int j=i;j<r;j++)
{
for(int k=0;k<c;k++)
arr[k]+=matrix[j][k];
ans+=solve(arr,target);
}
}
return ans;
}
}