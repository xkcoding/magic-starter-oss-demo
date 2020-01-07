package com.xkcoding.magicstarterossdemo;

import com.xkcoding.magic.oss.model.OssFile;
import com.xkcoding.magic.oss.support.ali.AliOssTemplate;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;

/**
 * <p>
 * 阿里云测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020/1/7 17:40
 */
@Slf4j
public class AliOssTemplateTests extends MagicStarterOssDemoApplicationTests {
    @Autowired
    private AliOssTemplate aliOssTemplate;

    @Test
    public void testCreateBucket() {
        aliOssTemplate.createBucket(BUCKET);
    }

    @Test
    public void testExistBucket() {
        final boolean exists = aliOssTemplate.bucketExists(BUCKET);
        Assert.assertTrue(exists);
    }

    @Test
    public void testDeleteBucket() {
        aliOssTemplate.deleteBucket(BUCKET);
    }

    @Test
    @SneakyThrows
    public void testUploadFile() {
        @Cleanup FileInputStream inputStream = new FileInputStream(FILE);
        OssFile ossFile = aliOssTemplate.uploadFile(BUCKET, FILE_NAME, inputStream);
        log.debug("【ossFile】= {}", ossFile);
    }

    @Test
    public void testDeleteFile() {
        aliOssTemplate.deleteFile(BUCKET, "upload/2020-01-07/13b6bbe8d75e475982ee9c02bd006507.jpeg");
    }

}
