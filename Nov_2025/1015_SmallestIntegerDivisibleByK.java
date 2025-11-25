class Solution {
    public int smallestRepunitDivByK(int K) {

        if (K % 2 == 0 )
            return -1;

        int remain = 0;

        for (int length = 1; length <= K; length++) {
            remain = (remain * 10 + 1) % K;

            if (remain == 0)
                return length;
        }

        return -1;
    }
}
