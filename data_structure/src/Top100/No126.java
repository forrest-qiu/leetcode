package Top100;

import org.junit.Test;

import java.util.*;

/**
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * <p>
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 */
public class No126 {
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> graph = new HashMap<>();//建图

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return ans;
        }
        Set<String> set = new HashSet<>(wordList);
        set.add(beginWord);
        buildGraph(set); //构图
        LinkedList<String> path = new LinkedList<>();
        dfs(wordList, beginWord, endWord, path);
        return ans;
    }

    public void dfs(List<String> wordList, String beginWord, String endWord, LinkedList<String> path) {
        int size = path.size();
        if (size == wordList.size()) {
            return;
        }
        String word;
        if (size == 0) {
            word = beginWord;
        } else {
            word = path.get(size - 1);
        }
        if (changeOne(word, endWord)) {
            LinkedList<String> strings = new LinkedList<>(path);
            strings.addFirst(beginWord);
            strings.addLast(endWord);
            if (ans.size() > 0) {
                if (ans.get(0).size() > strings.size()) {
                    ans.clear();
                    ans.add(strings);
                } else if (ans.get(0).size() == strings.size()) {
                    ans.add(strings);
                }
            } else {
                ans.add(strings);
            }
            return;
        }
        List<String> next = graph.get(word);
        for (int i = 0; i < next.size(); i++) {
            String s = next.get(i);
            if (!path.contains(s)&&graph.containsKey(s)) {
                path.addLast(s);
                dfs(wordList, beginWord, endWord, path);
                path.removeLast();
            }
        }
    }

    public boolean changeOne(String word, String dest) {
        if (word.length() != dest.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == dest.charAt(i)) {
                count++;
            }
        }
        return count == word.length() - 1;
    }

    public void buildGraph(Set<String> words) {
        for (String word : words) {
            graph.put(word, new ArrayList<>());
        }
        for (String word : words) {
            Set<String> key = graph.keySet();
            for (String s : key) {
                if (changeOne(s, word)) {
                    List<String> list = graph.get(s);
                    list.add(word);
                }
            }
        }

    }

    @Test
    public void test() {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> strings = Arrays.asList(wordList);
        System.out.println(findLadders(beginWord, endWord, strings));
    }

}
