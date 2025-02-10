class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack=new Stack<>();

        for(char i:s.toCharArray()){
           if(i>=97 && i<=122){
            stack.push(i);
           }
           else{
              stack.pop();
           }
        }
    
      StringBuilder sb=new StringBuilder();

      while(!stack.isEmpty()){
        sb.append(stack.pop());
      }

      sb.reverse();

      return sb.toString();
    }
}
