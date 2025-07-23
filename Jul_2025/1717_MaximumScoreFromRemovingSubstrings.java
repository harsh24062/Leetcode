class Solution {
    int AB(String s,int x,boolean flag[]){
        int score=0;
         Stack<Integer> stack=new Stack<>();

         for(int i=0;i<s.length();i++){
            if(flag[i])continue;
            if(!stack.isEmpty() && s.charAt(stack.peek())=='a' && s.charAt(i)=='b'){
                score+=x;
                flag[i]=true;
                flag[stack.pop()]=true;
            }
            else{
                stack.push(i);
            }
         }
        return score;
    }
          
            int BA(String s,int y,boolean flag[]){
        int score=0;
         Stack<Integer> stack=new Stack<>();

         for(int i=0;i<s.length();i++){
            if(flag[i])continue;
            if(!stack.isEmpty() && s.charAt(stack.peek())=='b' && s.charAt(i)=='a'){
                score+=y;
                flag[i]=true;
                flag[stack.pop()]=true;
            }
            else{
                stack.push(i);
            }
         }
        return score;
    }

    public int maximumGain(String s, int x, int y) {
        boolean flag[]=new boolean[s.length()];
        int score=0;
        if(x>y){
            score=AB(s,x,flag)+BA(s,y,flag);
        }
        else{
           score=BA(s,y,flag)+AB(s,x,flag);
        }

        return score;
    }
}
