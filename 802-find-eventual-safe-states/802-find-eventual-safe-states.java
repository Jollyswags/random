class Solution {
 public List<Integer> eventualSafeNodes(int[][] graphList) {

int n  = graphList.length;
int []degree = new int[n];
boolean isSafe[] = new boolean[n];
Queue<Integer> q = new LinkedList<>();
HashSet<Integer>[]  neighbour= new HashSet[n];
for(int i=0;i<n;i++){
    neighbour[i] = new HashSet<Integer>();
}
for(int i=0;i<n;i++){
    
    if(graphList[i].length==0){
        isSafe[i] = true;
        q.offer(i);
    }
    for(int v:graphList[i]){
     neighbour[v].add(i);   
    }        
    degree[i] = graphList[i].length;
}
    
while(!q.isEmpty()){
    
    int curr = q.poll();
    isSafe[curr] = true;
    
    for(int v:neighbour[curr]){
     
        degree[v]--;
        if(degree[v]==0){
            q.offer(v);
        }            
    }        
}
ArrayList<Integer> res = new ArrayList<>();
for(int i=0;i<n;i++){
    if(isSafe[i])res.add(i);
}  
return res;
}
}


