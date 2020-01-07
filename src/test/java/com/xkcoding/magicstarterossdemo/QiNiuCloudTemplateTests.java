package com.xkcoding.magicstarterossdemo;

import com.xkcoding.magic.oss.model.OssFile;
import com.xkcoding.magic.oss.support.qiniu.QiNiuCloudTemplate;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;

/**
 * <p>
 * 七牛云测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020/1/7 17:40
 */
@Slf4j
public class QiNiuCloudTemplateTests extends MagicStarterOssDemoApplicationTests {
    @Autowired
    private QiNiuCloudTemplate qiNiuCloudTemplate;

    @Test
    public void testCreateBucket() {
        qiNiuCloudTemplate.createBucket(BUCKET);
    }

    @Test
    public void testExistBucket() {
        final boolean exists = qiNiuCloudTemplate.bucketExists(BUCKET);
        Assert.assertTrue(exists);
    }

    @Test
    public void testDeleteBucket() {
        // 七牛云 SDK 未提供删除 存储桶 API
    }

    @Test
    @SneakyThrows
    public void testUploadFile() {
        @Cleanup FileInputStream inputStream = new FileInputStream(FILE);
        OssFile ossFile = qiNiuCloudTemplate.uploadFile(BUCKET, FILE_NAME, inputStream);
        log.debug("【ossFile】= {}", ossFile);
    }

    @Test
    public void testDeleteFile() {
        qiNiuCloudTemplate.deleteFile(BUCKET, "upload/2020-01-07/8a7a07a33c5c47f0af2e460eda5dc4ec.jpeg");
    }

}
