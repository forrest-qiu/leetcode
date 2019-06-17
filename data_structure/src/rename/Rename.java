package rename;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Rename {
	
	private static int num = 0; // 计数变量
    public static void main(String[] args) {
        String filePath = "D:\\workspace\\ruoyi\\backup-rename";
        String srcStr = "ruoyi";   //需要替换的字符串
        String desStr = "franchisee";   //用于替换的字符串

//        editProperties(filePath, srcStr, desStr);
        System.out.println("总共文件数：" + num);
        
        ReplacementChain replacementChain = new ReplacementChain();
        replacementChain.addRegulation(srcStr, desStr);
        Rename.multiRename(filePath, replacementChain);
        System.out.println("恭喜，批量重命名成功！共替换"+sum+"个！");

    }

    public static void editProperties(String filePath, String srcStr, String desStr) {
        File file = new File(filePath);
//        处理目录情况
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            for (File subFile : subFiles) {
//                子文件如果是目录进行递归
                if (subFile.isDirectory()) {
                    editProperties(subFile.getAbsolutePath(), srcStr, desStr);
                } else {
//                    子文件如果是文件，通过后缀名进行过滤
                    if (subFile.getName().endsWith(".java") || subFile.getName().endsWith(".xml")) {
                        System.out.println(subFile.getAbsolutePath());
                        EditFile.propertiesChange(subFile.getAbsolutePath(), srcStr, desStr);
                        num++;
                    } else {
                        continue;
                    }
                }
            }
        } else {
            // 处理单个文件情况
            if (file.getName().endsWith(".properties")) {
                System.out.println(file.getAbsolutePath());
                EditFile.propertiesChange(file.getAbsolutePath(), srcStr, desStr);
                num++;
            }
        }
    }
    
    
    static int sum = 0;
    /**
     * 批量重命名
     * @param path
     * @param replacementChain
     */
    public static void multiRename(String path,ReplacementChain replacementChain){

        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        File [] filesArr = file.listFiles();
        for(File filesa : filesArr){
            if(isDirectory&&file.list()!=null&&file.list().length>0){
                multiRename(filesa.getPath(), replacementChain);
             }
        }

        String[] files = file.list();
        File f = null;
        String filename = "";
        String oldFileName = ""; //之前的名字
        /** 循环遍历所有文件* */
        for(String fileName : files){
            oldFileName = fileName;
            Map<String, String> map = replacementChain.getMap();
            for (Entry<String, String> entry : map.entrySet()) {
                 if(fileName.contains(entry.getKey())){
                  sum++;   
                 }
                fileName = fileName.replace(entry.getKey(), entry.getValue());

            }

            f = new File(path + "\\" + oldFileName); //输出地址和原路径保持一致
            f.renameTo(new File(path + "\\" +  fileName));
        }

    }
}


class ReplacementChain{
    private Map<String,String> map;


    public ReplacementChain() {
        this.map = new HashMap<String, String>();
    }

    public Map<String, String> getMap() {
        return map;
    }

    // 添加新的替换规则(字符串替换)
    public ReplacementChain  addRegulation(String oldStr , String newStr){
        this.map.put(oldStr, newStr);
        return this;
    }

}
