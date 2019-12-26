package cn.dgkj.other;

import lombok.Cleanup;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Collection;

/**
 * @author mawt
 * @description
 * @date 2019/12/5
 */
public class SearchUtil {

    public static void main(String[] args) {
        try {
            search("step", "G:\\梦创双杨相关\\源码");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void search(String target, String path) throws IOException {
        Collection<File> files = FileUtils.listFiles(new File(path), null, true);
        for (File file : files) {
            @Cleanup BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            boolean exist = false;
            while ((line = reader.readLine()) != null) {
                if (file.getName().endsWith(".java") && line.contains(target) && line.contains("STEP_LENGTH")) {
                    System.out.println(line);
                    exist = true;
                }
            }
            if (exist) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

}
