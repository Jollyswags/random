/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

      LinkedList<Integer> nestedIt;
    Iterator it;

    int rIdx;
    int len;
    
    public NestedIterator(List<NestedInteger> nestedList) 
    {
        nestedIt = new LinkedList<Integer>();
        dfs(nestedIt, nestedList);
        rIdx = 0;
        len = nestedIt.size();
        // for(Integer x : nestedIt)
            // System.out.printf("x = %d\n", x.intValue());
        it = nestedIt.iterator();
    }
    
    public void dfs(LinkedList<Integer> nestedIt, List<NestedInteger> nestedList)
    {
        for(NestedInteger x : nestedList)
        {
            if(x.isInteger())
                nestedIt.addLast(x.getInteger());
            else
                dfs(nestedIt, x.getList());
        }
        
    }

    @Override
    public Integer next() 
    {
        return (Integer)it.next();
    }

    @Override
    public boolean hasNext() 
    {
        return it.hasNext();
    }
}


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */