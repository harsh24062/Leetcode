// brute force
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        List<String> ans=new ArrayList<>();
 
        int n=recipes.length;

        Set<String> set=new HashSet<>();
        for(String s:supplies)set.add(s);

        for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
           if(ans.contains(recipes[i]))continue;
          boolean flag=true;
          for(int j=0;j<ingredients.get(i).size();j++){
              if(!set.contains(ingredients.get(i).get(j))){
                flag=false;
                break;
              }
          }
          if(flag){
            ans.add(recipes[i]);
            set.add(recipes[i]);
          }
        }
        }

        return ans;
    }
}


//topological sort

class Solution {
    // using topologicaL SORT
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        List<String> ans=new ArrayList<>();
 
        int n=recipes.length;

        Set<String> set=new HashSet<>();
        for(String s:supplies)set.add(s);

        int indegree[]=new int[n];

        Map<String,List<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
          for(String s:ingredients.get(i)){
            if(!set.contains(s)){
               if(!map.containsKey(s)) map.put(s,new ArrayList<>());
               map.get(s).add(i);
               indegree[i]++;
            }
          }
        }


        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)queue.offer(i);
        }

        while(!queue.isEmpty()){
            String s=recipes[queue.poll()];
            ans.add(s);

            if(map.containsKey(s)){
                for(int i:map.get(s)){
                    indegree[i]--;
                    if(indegree[i]==0)queue.offer(i);
                }
            }

        }

        return ans;
    }
}

//logic- codestorywithmik  
