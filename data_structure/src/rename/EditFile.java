package rename;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 修改文件中的内容* 两种情况：1.修改文件中的指定内容；2.读取文件并修改指定内容，复制到另一个文件中
 * 场景举例：替换properties文件中的ip和端口
 */
public class EditFile {
    /**
     * 1.修改文件中的指定内容
     * filePath:文件路径
     * srcStr：需要替换的字符串
     * desStr：替换成的字符串
     */
    public static void propertiesChange(String filePath, String srcStr, String desStr) {
        //字符流
        FileReader fr = null;
        FileWriter fw = null;
        //缓冲流
        BufferedReader br = null;
        BufferedWriter bw = null;

        List list = new ArrayList<>();
        //读取文件内容保证在list中
        try {
            fr = new FileReader(new File(filePath));
            br = new BufferedReader(fr);   //扩容，类似加水管
            String line = br.readLine();    //逐行复制
            while (line != null) {
                //修改指定内容
                if (line.contains(srcStr)) {
                    line = line.replace(srcStr, desStr);
                }
                list.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流，顺序与打开相反
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //将list中内容输出到原文件中
        try {
            fw = new FileWriter(filePath);
            bw = new BufferedWriter(fw);
            for (Object s : list) {
                bw.write((String) s);
                bw.newLine();  //换行输出
            }
            System.out.println("文件修改成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流，顺序与打开相反
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 2.读取文件并修改指定内容，复制到另一个文件中
     * inputPath:修改的源文件
     * outputPath:修改后输出的文件路径
     * srcStr：需要替换的字符串
     * desStr：替换成的字符串
     */
    public static void propertiesChange(String inputPath, String outputPath, String srcStr, String desStr) {
        //字符流
        FileReader fr = null;
        FileWriter fw = null;
        //缓冲流
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            fr = new FileReader(new File(inputPath));
            br = new BufferedReader(fr);   //扩容，类似加水管
            fw = new FileWriter(outputPath);
            bw = new BufferedWriter(fw);

            String line = br.readLine();    //逐行复制
            while (line != null) {
                if (line.contains(srcStr)) {
                    line = line.replace(srcStr, desStr);
                }
                bw.write(line);
                bw.newLine();  //换行输出
                line = br.readLine();
            }
            System.out.println("文件修改成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流，顺序与打开相反
                bw.close();
                br.close();
                fw.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}