class Solution {
    
    private Map<String,Boolean> dp;
    private Set<String> set;

    boolean func(int index, String bottom, String top){
       if(bottom.length()==1)return true;

       String key = index+"_"+bottom+"_"+top;

       if(dp.containsKey(key))return dp.get(key);
       
       if(index==bottom.length()-1){
        boolean result = func(0,top,"");
        dp.put(key,result);
        return result;
       }
        
        String s= ""+bottom.charAt(index)+bottom.charAt(index+1);
         for(char ch='A';ch<='F';ch++){
            String str = s+ch;
            if(set.contains(str)){
                //System.out.println(str);
                if(func(index+1,bottom,top+ch)){
                     dp.put(key,true);
                    return true;}
                }
            } 
    
        dp.put(key,false);
        return false;
        
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        set = new HashSet<>();
        dp = new HashMap<>();
        for(String s:allowed) set.add(s);

        return func(0,bottom,"");
    }
}
