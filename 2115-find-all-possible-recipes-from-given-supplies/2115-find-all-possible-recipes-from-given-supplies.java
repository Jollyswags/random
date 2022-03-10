class Solution {
   public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        
        
        List<String> allRecipes= new ArrayList();
        Map<String, Integer> map = new HashMap();
        List<String> supplyList = new ArrayList();
        
        for(String supply: supplies){
            supplyList.add(supply);
        }
        
        for(int i = 0;i<recipes.length;i++){
            map.put(recipes[i], i);
        }
        Queue<Integer> queue = new LinkedList();
        int [] degree = new int[recipes.length];
        ArrayList<String> [] recipeEdges = new ArrayList[recipes.length];
        
        for(int i = 0;i<recipes.length;i++){
            recipeEdges[i] = new ArrayList<String>();
        }
		
		 // Create the adjacency list representation of the graph
        for(int i = 0;i<ingredients.size();i++){
            List<String> currIngredients = ingredients.get(i);
            for(int j = 0;j<currIngredients.size();j++){
                if(map.containsKey(currIngredients.get(j))){
				      // Record in-degree of each vertex
                    degree[i]++;
                    recipeEdges[map.get(currIngredients.get(j))].add(recipes[i]);
                    
                }
            }
        }
        
        // Add all vertices with 0 in-degree to the queue
       for(int i = 0;i<degree.length;i++){
           if(degree[i] == 0){
               queue.add(i);
           }
       }
        
		 // Process until the Q becomes empty
        while(!queue.isEmpty()){
            
            int currRecipe = queue.poll();
            //If indegree is 0 check if supplyList contains all ingredients for the recipe, if it does add the recipe itself to the supply            chain
            if(supplyList.containsAll(ingredients.get(currRecipe))){
               supplyList.add(recipes[currRecipe]);
               allRecipes.add(recipes[currRecipe]);
            }
			 // Reduce the in-degree of each neighbor by 1  and If in-degree of a neighbor becomes 0, add it to the Q
            for(String node : recipeEdges[currRecipe]){
                if(--degree[map.get(node)] == 0){
                    queue.add(map.get(node));                    
          
                }
            }
            
        }
                                
       return allRecipes;
    }
}