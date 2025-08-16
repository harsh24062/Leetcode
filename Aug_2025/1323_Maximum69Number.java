class Solution {
    public int maximum69Number (int num) {
      Stack<Integer> stack=new Stack<>();

      while(num>0){
        stack.push(num%10);
        num/=10;
      }

      boolean flag=false;
      while(!stack.isEmpty()){
        int n =stack.pop();
        if(!flag && n!=9){
            num=(num*10)+9;
            flag=true;
        }else num=(num*10)+n;
      }

        return num;
    }
}
