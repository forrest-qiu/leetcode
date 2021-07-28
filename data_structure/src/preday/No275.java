package preday;

import org.junit.Test;

public class No275 {

    public int hIndex(int[] citations) {
        if(citations.length==0){
            return 0;
        }
        int ans = 0,count = 0;
        for (int i = citations.length-1; i >=1 ; i--) {
            ans = citations[i];
            count++;
            if(ans==count&&citations[i-1]<citations[i]){
                break;
            }
            if(citations[i-1]<(count+1)){
                break;
            }
        }
        if(citations[0]>=(count+1)){
            count++;
            ans = citations[0];
        }
        return Math.min(count,ans);
    }

    @Test
    public void test(){
//        int[] x  = {0,1,3,5,6};
        int[] x  = {1};
        System.out.println(hIndex(x));
    }

}
