class Task {
    int index;
    int startTime;
    int endTime;
    
    public Task(int index, int st, int et) {
        this.index = index;
        startTime= st;
        endTime = et;
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        Task[] wrapperTask = new Task[tasks.length];
        for(int i=0;i<tasks.length;i++){
            wrapperTask[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        int[] ans = new int[tasks.length];
        Arrays.sort(wrapperTask, (a, b) -> a.startTime - b.startTime);
        
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> a.endTime != b.endTime ? a.endTime - b.endTime : a.index - b.index);
        
        int idx=0, taskId=0, current=0;
        
        while(idx < wrapperTask.length){
            while(taskId < tasks.length && wrapperTask[taskId].startTime <= current){
                pq.add(wrapperTask[taskId++]);
            }
            if(pq.size() == 0){
                current = wrapperTask[taskId].startTime;
                continue;
            }
            
            Task runningTask = pq.remove();
            ans[idx++] = runningTask.index;
            current += runningTask.endTime;   
        }
        
        return ans;
    }
}