class Solution {

    String res;
    Set<String> set;

    boolean func(int n, String ans){
        if(n==0){
           if(!set.contains(ans)){
            res=ans;
            return true;
           }
           return false;
        }

        if(func(n-1,ans+"1"))return true;
        if(func(n-1,ans+"0"))return true;
        return false;
    }

    public String findDifferentBinaryString(String[] nums) {
        res="";
        set=new HashSet<>();
        
        for(String i:nums){
            set.add(i);
        }

        func(nums.length,"");
        
        return res;
    }
}


//  0(N)
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<nums.length;i++){
            sb.append(((nums[i].charAt(i)=='0')?'1':'0'));
        }
        return sb.toString();
    }
}
