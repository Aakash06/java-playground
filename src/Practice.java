import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Practice {

    static int minCharacterToRemove(String S) {
        HashMap<Character, Integer> mp = new HashMap<>();

        PriorityQueue<Integer> queueToStoreUniqueCount = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        int minCharacterToRemove = 0;

        for (int i = 0; i < S.length(); i++) {
            if (mp.containsKey(S.charAt(i))) {
                mp.put(S.charAt(i), mp.get(S.charAt(i)) + 1);
            } else {
                mp.put(S.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> it : mp.entrySet()) {
            queueToStoreUniqueCount.add(it.getValue());
        }

        while (!queueToStoreUniqueCount.isEmpty()) {
            int peek = queueToStoreUniqueCount.peek();
            queueToStoreUniqueCount.remove();
            if (queueToStoreUniqueCount.isEmpty()) {
                return minCharacterToRemove;
            }
            if (peek == queueToStoreUniqueCount.peek()) {
                if (peek > 1) {
                    queueToStoreUniqueCount.add(peek - 1);
                }
                minCharacterToRemove++;
            }
        }
        return minCharacterToRemove;
    }

    public static void main(String[] args) {

        String str = "ccaaffddecee";

        int N = str.length();

        System.out.println(minCharacterToRemove(str));
    }
}
