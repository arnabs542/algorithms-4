package veritas;

import java.util.*;

public class Problem_2_veritas {
    static class Interval {
        int start;
        int end;
        int value;

        public Interval(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    static List<Interval> list;
    static char[] map = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static String problem2 (String s, String[] operations) {
        List<Interval> intervals = new ArrayList<>();
        for (String operation : operations) {
            String[] ops = operation.split(" ");
            int startIndex = Integer.parseInt(ops[0]), endIndex = Integer.parseInt(ops[1]);
            int value = ops[2].equals("L") ? -1 : 1;
            intervals.add(new Interval(startIndex, endIndex, value));
        }
        intervals.sort((a,b) -> a.end - b.end); // increasing order
        intervals.sort((a,b) -> a.start - b.start); // increasing order
        list = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            insert(intervals.get(i));
        }

        int[] arr = new int[s.length()];
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = intervals.get(i).start; j <= intervals.get(i).end; j++) {
                arr[j] += intervals.get(i).value;
            }
        }
        for (int i = 0; i < arr.length; i++) arr[i] = arr[i] % 26 < 0 ? arr[i] % 26 + 26 : arr[i] % 26;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[i] += (chars[i] - 'a');
            arr[i] = arr[i] % 26;
            chars[i] = map[arr[i]];
        }
        return new String(chars);
    }

    public static void insert(Interval newInterval) {
        // check for overlap
        if (list.isEmpty()) {
            list.add(newInterval);
        } else {
            Interval last = list.get(list.size() - 1);
            if (newInterval.start > last.end) list.add(newInterval); // no overlap
            else { // overlap
                int p1, p2, p3, p4; // four points to form 3 intervals if there is an overlap
                p1 = last.start;
                p2 = newInterval.start;
                p3 = Math.min(newInterval.end, last.end);
                p4 = Math.max(newInterval.end, last.end);
                if (p1 != p2) list.get(list.size() - 1).end = p2;
                if (p2 != p3) list.add(new Interval(p2, p3, last.value + newInterval.value));
                if (p3 != p4) list.add(new Interval(p3, p4, newInterval.value));
        }
        }
    }

    public static void main(String[] args) {
        String[] ops = {"0 0 L", "2 2 L", "0 2 R"};
        System.out.println(problem2("abc", ops));

    }
}
