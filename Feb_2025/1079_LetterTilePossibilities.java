class Solution {

    Set<String> set=new HashSet<>();
 
    void func(String tiles, String ans,boolean visit[]){

        if(set.contains(ans))return;
        set.add(ans);
      
      for(int i=0;i<tiles.length();i++){
        if(!visit[i]){
            visit[i]=true;
            func(tiles,ans+tiles.charAt(i),visit);
            visit[i]=false;
        }
      }

    }

    public int numTilePossibilities(String tiles) {

       boolean visited[]=new boolean[tiles.length()];
        func(tiles,"",visited);
        return set.size()-1;
    }
}



// shashcode  using frequency
class Solution {

   int func(int freq[]){
     int count=0;
     
     for(int i=0;i<26;i++){
      if(freq[i]==0)continue;
      count++;
      freq[i]--;
      count+=func(freq);
      freq[i]++;
     }

     return count;
   }

    public int numTilePossibilities(String tiles) {
       int freq[]=new int[26];

       for(char i:tiles.toCharArray()){
        freq[i-'A']++;
       } 

       return func(freq);
    }
}
