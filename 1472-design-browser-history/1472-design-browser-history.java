class BrowserHistory {
    Stack<String> history=new Stack<>();
    Stack<String> backed=new Stack<>();
    public BrowserHistory(String homepage) {
        history.push(homepage);
    }
    
    public void visit(String url) {
        history.push(url);
        backed.clear();
    }
    
    public String back(int steps) {
        while(steps-- >0)
        {
            if(history.size()>1)
            {
               
               backed.push(history.pop());
                
            }
            else
                break;
        }
        return history.peek();
    }
    
    public String forward(int steps) {
        while(steps-- >0)
        {
            if(!backed.isEmpty())
            {
               
               history.push(backed.pop());
                
            }
            else
                break;
        }
        return history.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */