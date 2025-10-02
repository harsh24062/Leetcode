class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        int emptyBottle = numBottles;

        while(numExchange<=emptyBottle){
            emptyBottle-=numExchange;
            ans++;
            emptyBottle++;
            numExchange++;
        }

        return ans;
    }
}
