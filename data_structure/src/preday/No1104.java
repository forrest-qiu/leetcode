package preday;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 *
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 *
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *。
 */
public class No1104 {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        if(label==1){
            ans.add(1);
            return ans;
        }
        //判断label接近2的多少次方
        int i = Integer.highestOneBit(label);
        //获取当前层数据
        int offset = label - i;
        if(offset > 0 ){

        }

        return ans;
    }

    @Test
    public void test(){
        System.out.println(Integer.highestOneBit(8));
    }
}
