package Top100;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class No692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        list.sort((o1, o2) -> {
            if(o1.getValue()>o2.getValue()){
                return -1;
            }else if(o1.getValue()==o2.getValue()){
                return o1.getKey().compareTo(o2.getKey());
            }else{
                return 1;
            }
        });
        return list.subList(0, k).stream().map(t -> t.getKey()).collect(Collectors.toList());
    }

    @Test
    public void test(){
//        String[] xx = {"i", "love", "leetcode", "i", "love", "coding"}; int k = 2;
        String[] xx = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}; int k = 4;
        System.out.println(topKFrequent(xx,k));
    }
}
