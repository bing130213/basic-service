package me.wang.basicService.file;

import org.springframework.http.codec.multipart.FilePart;

import java.awt.image.DataBuffer;

/**
 * @author wangbing
 * @date 2021/1/8
 * @description
 */
public interface FileService {
    void upload(FilePart filePart);
    void singleFileUpload(String fileName, String mediaType, DataBuffer dataBuffer);

    void download();

}
