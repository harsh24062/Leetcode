class Solution {
    public String clearStars(String s) {
        TreeMap<Character,Stack<Integer>> map=new TreeMap<>();
        boolean check[]=new boolean[s.length()]; // mark true those are removed

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
               char ch=map.firstKey();
              check[map.get(ch).pop()]=true;

               if(map.get(ch).size()==0)map.remove(ch);
            }else{
              map.computeIfAbsent(s.charAt(i),k->new Stack<>()).push(i);
            }
        }

       StringBuilder sb=new StringBuilder();
       
       for(int i=0;i<s.length();i++){
          if(!check[i] && s.charAt(i)!='*'){
            sb.append(s.charAt(i));
          }
       }

       return sb.toString();

    }
}
