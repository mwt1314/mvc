package cn.dgkj.test;

import lombok.Cleanup;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;

/**
 * @author mawt
 * @description
 * @date 2019/12/12
 */
public class XX {

    @Test
    public void main() {
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
