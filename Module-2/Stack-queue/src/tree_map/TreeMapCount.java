package tree_map;

import java.util.Arrays;
import java.util.TreeMap;

public class TreeMapCount {
    public static void main(String[] args) {
        String str = "HelloCodeGym";
        String upStr = str.toUpperCase();
        String[] strings = upStr.split("");
        System.out.println(Arrays.toString(strings));
        int value;
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String key : strings) {
            if (treeMap.containsKey(key)) {
                value = treeMap.get(key);
                treeMap.remove(key);
                treeMap.put(key, value + 1);
            } else {
                treeMap.put(key, 1);
            }
        }
        System.out.println(treeMap);
    }
}
