package me.wang.basicService.file;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Base64Utils;

import java.io.*;
import java.util.Base64;

/**
 * @author wangbing
 * @date 2021/1/7
 */
@Slf4j
public class File2Base64 {
    public final ResourceLoader resourceLoader = new DefaultResourceLoader();

    /**
     * <p>将文件转成base64 字符串</p>
     * @param path 文件路径
     * @return
     * @throws Exception
     */
        public static String encodeBase64File(String path) throws Exception {
            File file = new File(path);
            FileInputStream inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int)file.length()];
            inputFile.read(buffer);
            inputFile.close();
            return Base64Utils.encodeToString(buffer);
        }
        /**
         * <p>将base64字符解码保存文件</p>
         * @param base64Code
         * @param targetPath
         * @throws Exception
         */
        public static void decoderBase64File(String base64Code,String targetPath) throws Exception {
            byte[] buffer = Base64Utils.decodeFromString(base64Code);
            FileOutputStream out = new FileOutputStream(targetPath);
            out.write(buffer);
            out.close();
        }
        /**
         * <p>将base64字符保存文本文件</p>
         * @param base64Code
         * @param targetPath
         * @throws Exception
         */
        public static void toFile(String base64Code,String targetPath) throws Exception {
            byte[] buffer = base64Code.getBytes();
            FileOutputStream out = new FileOutputStream(targetPath);
            out.write(buffer);
            out.close();
        }
        public static void main(String[] args) {
            try {
                String base64Code =encodeBase64File(".//repos//myfile.txt");
                System.out.println(base64Code);
                decoderBase64File(base64Code, "./repos/myfile_new.txt");
                toFile(base64Code, "./repos/myfile_local.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    /**
     * base64字符串转文件
     * @param base64
     * @return
     */
    public static File base64ToFile(String base64) {
        File file = null;
        String fileName = "/repos/myfile.txt";
        FileOutputStream out = null;
        try {
            // 解码，然后将字节转换为文件
            file = new File(fileName);
            if (!file.exists())
                file.createNewFile();
            byte[] bytes = Base64Utils.decodeFromString(base64); // 将字符串转换为byte数组
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            byte[] buffer = new byte[1024];
            out = new FileOutputStream(file);
            int bytesum = 0;
            int byteread = 0;
            while ((byteread = in.read(buffer)) != -1) {
                bytesum += byteread;
                out.write(buffer, 0, byteread); // 文件写操作
            }
        } catch (IOException ioe) {
            log.error("error -> {}", ioe.getMessage());
        } finally {
            try {
                if (out!= null) {
                    out.close();
                }
            } catch (IOException e) {
                log.error("error -> {}", e.getMessage());
            }
        }
        return file;
    }
}
