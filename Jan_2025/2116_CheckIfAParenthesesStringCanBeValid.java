class Solution {
    // https://www.youtube.com/watch?v=-MCMu4FKDe0 shashcode
    public boolean canBeValid(String s, String locked) {
         
         if(s.length()%2!=0) return false;


        Stack<Integer> stack=new Stack<>(); // it will store '(' index
        Stack<Integer> unlock=new Stack<>(); // it will store index where locked is 0
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            char islock=locked.charAt(i);

            
             if(islock=='0') unlock.push(i);
             else if(ch=='(') stack.push(i);
            else{
                if(!stack.isEmpty()) stack.pop();
                else if(!unlock.isEmpty())unlock.pop();
                else return false;
            }
        }  

        while(!stack.isEmpty() && !unlock.isEmpty() && stack.peek()<unlock.peek()){
            stack.pop();
            unlock.pop();
        }

        return stack.isEmpty();
    }
}
