package me.wang.basicService.file;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.codec.multipart.FilePart;

import java.awt.image.DataBuffer;

/**
 * @author wangbing
 * @date 2021/1/8
 * @description
 */
public class AbstractFileService implements FileService {
    public final ResourceLoader RESOURCE_LOADER = new DefaultResourceLoader();


    @Override
    public void upload(FilePart filePart) {
        String fileName = filePart.filename();
        String mediaType = filePart.headers().getContentType().toString();

    }

    @Override
    public void singleFileUpload(String fileName, String mediaType, DataBuffer dataBuffer) {

    }

    @Override
    public void download() {

    }

    public ResourceLoader getResourceLoader() {
        return RESOURCE_LOADER;
    }

}
