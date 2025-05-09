package com.llm.llm_knowledge.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    
    public static void uploadFile(byte[] file, String filePath, String fileName) throws IOException {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();  // 如果文件夹不存在则创建
        }
        FileOutputStream out = new FileOutputStream(targetFile.getAbsolutePath() + "/" + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static String getUpLoadFilePath() {
        return "D:/Desktop/llm-vue/src/assets/img";

    }
}
