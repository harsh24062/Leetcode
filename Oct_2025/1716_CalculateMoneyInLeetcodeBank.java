class Solution {
    public int totalMoney(int n) {
        int money=1;
        int monday=1;
        int total=0;
        for(int i=0;i<n;i++){
            if(i%7==0){
                money=monday;
                monday++;
            }
            total+=money;
            money++;
        }
        return total;
    }
}
