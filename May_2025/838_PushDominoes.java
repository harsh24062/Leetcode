class Solution {

    class Pair{
      int index;
      char direction;
      Pair(int index,char direction){
        this.index=index;
        this.direction=direction;
      }
    }

    public String pushDominoes(String dominoes) {

        char ch[]=dominoes.toCharArray();
        int n = ch.length;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,Character> dots = new HashMap<>();

        for(int i=0;i<n;i++){
          if(ch[i]!='.') queue.offer(new Pair(i,ch[i]));
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Pair pair = queue.poll();
                int index=pair.index;
                char dir=pair.direction;
                if(dir=='L')index--;
                else index++;
                
                if(index>=0 && index<n && ch[index]=='.'){
                   if(dots.containsKey(index)){
                    dots.remove(index);
                   }else{
                    dots.put(index,dir);
                   }
                }
            }

            for(Map.Entry<Integer,Character> k:dots.entrySet()){
                int index=k.getKey();
                char dir = k.getValue();
                ch[index]=dir;
                queue.offer(new Pair(index,dir));
            }
            dots.clear();
        }

        return new String(ch);

    } 
}




// optimized

class Solution {
    public String pushDominoes(String dominoes) {
        char ch[]=dominoes.toCharArray();
        int n=dominoes.length();

        int rightPush[] = new int[n]; //iterate left to right 
        int leftPush[] = new int[n]; //iterate right to left

        // find rightPush 
        int lastRight=-1;
        for(int i=0;i<n;i++){
         if(ch[i]=='R'){
           lastRight=i;
         }else if(ch[i]=='L')lastRight=-1;
         else{
           rightPush[i]=lastRight;
         }
        }

          // find leftPush 
        int lastLeft=-1;
        for(int i=n-1;i>=0;i--){
         if(ch[i]=='L'){
           lastLeft=i;
         }else if(ch[i]=='R')lastLeft=-1;
         else{
           leftPush[i]=lastLeft;
         }
        }


        for(int i=0;i<n;i++){
            if(ch[i]=='.'){
                if(rightPush[i]!=-1 && leftPush[i]!=-1){
                    int right=i-rightPush[i];
                    int left=leftPush[i]-i;
                    if(left<right)ch[i]='L';
                    else if(right<left)ch[i]='R';
                }else if(rightPush[i]!=-1)ch[i]='R';
                else if(leftPush[i]!=-1)ch[i]='L';
            }
        }

      return new String(ch);
    }
}
