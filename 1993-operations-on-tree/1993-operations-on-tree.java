class LockingTree {

    ArrayList<Integer> [] decendants = null;
    int[] lockStatus = null;
    int[] parent = null;
    
    public LockingTree(int[] parent) {
        int n = parent.length;
        
        this.parent = parent;
        decendants = new ArrayList[n];
        lockStatus = new int[n];
        
        for(int i=0; i<n; i++)
        decendants[i] =  new ArrayList<>();            
        
        fillDecendants();
    }
    
    private void fillDecendants(){
        for(int i=1; i<parent.length; i++){
            decendants[parent[i]].add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(lockStatus[num]!=0) return false;
        
        lockStatus[num] = user;
        
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(lockStatus[num]!=user) return false;
        
        lockStatus[num] = 0;
        
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if(lockStatus[num]!=0 || hasLockedAncestors(num) || !hasLockedDecendants(num)) return false;
        
        lockStatus[num] = user;
        unlockDecendants(num);
        
        return true;
        
    }
    
    private void unlockDecendants(int num){
        
         for(int i=0; i<decendants[num].size(); i++){
             int decendant = decendants[num].get(i);
             lockStatus[decendant] = 0;
             unlockDecendants(decendant);
        }
    }
    
    private boolean hasLockedDecendants(int num){
        if(lockStatus[num] != 0) return true;
        
        for(int i=0; i<decendants[num].size(); i++){
            if(hasLockedDecendants(decendants[num].get(i))) return true;
        }
        
        return false;
    }
    
    private boolean hasLockedAncestors(int num){
        int n = num;
        while(parent[n]!=-1){
            n = parent[n];
            if(lockStatus[n] != 0) return true;
        }
        
        return false;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */