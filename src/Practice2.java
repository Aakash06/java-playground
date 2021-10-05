public class Practice2 {

    static int minCharacterToRemove(int[] A) {
        if (A.length < 5)
            return -1;
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i < A.length - 3; i++)
            for (int j = i + 2; j < A.length - 1; j++) {
                if (minSum > (A[i] + A[j])) {
                    minSum = A[i] + A[j];
                }
            }
        return minSum;
    }

    public static void main(String[] args) {

        int[] a = new int[]{5, 2, 4, 6, 3, 7};

        System.out.println(minCharacterToRemove(a));
    }
}

