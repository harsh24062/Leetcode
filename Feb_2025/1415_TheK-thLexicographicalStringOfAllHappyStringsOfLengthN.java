class Solution {

    void func(int n, List<String> list,String ans, char prev){

        if(n==0){
            list.add(ans);
            return;
        }
        
        for(char ch='a';ch<='c';ch++){
            if(prev!=ch){
                func(n-1,list,ans+ch,ch);
            }
        }
    }

    public String getHappyString(int n, int k) {
        List<String> list=new ArrayList<>();
        func(n,list,"",'q');

        if(k>list.size())return "";
        return list.get(k-1);
    }
}
