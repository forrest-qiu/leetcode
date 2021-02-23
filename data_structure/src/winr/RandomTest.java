package winr;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        int i = 10;
        StringBuilder sb = new StringBuilder();
        while (i>=0){
            i--;
            sb.append(七十()).append("\t");
        }
        System.out.println(sb.toString());

        //51	23	16	97	52	35	25	0	11	91	94
        //34	83	11	16	43	7	44	97	44	9	93
        //26	73	1	16	69	80	3	90	87	6	14
        //80%:  false	true	false	true	true	false	false	true	true	true	true  6
        //80%： true	false	true	true	true	false	true	true	true	true	true  8
        //80%： true	true	true	true	true	true	true	true	true	true	false  9
        //80%： true	true	false	true	true	true	true	false	true	false	true  7
        //70%： true	true	false	false	true	true	true	true	true	true	false  7
    }


    public static boolean 八十(){
        Random random = new Random();
        int i = random.nextInt(100);
        return i<=80;
    }

    public static boolean 七十(){
        Random random = new Random();
        int i = random.nextInt(100);
        return i<=70;
    }


}
