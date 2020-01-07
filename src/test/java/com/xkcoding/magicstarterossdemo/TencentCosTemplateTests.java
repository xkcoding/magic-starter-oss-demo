package com.xkcoding.magicstarterossdemo;

import com.xkcoding.magic.oss.model.OssFile;
import com.xkcoding.magic.oss.support.tencent.TencentCosTemplate;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;

/**
 * <p>
 * 腾讯云测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020/1/7 17:40
 */
@Slf4j
public class TencentCosTemplateTests extends MagicStarterOssDemoApplicationTests {
    @Autowired
    private TencentCosTemplate tencentCosTemplate;

    @Test
    public void testCreateBucket() {
        tencentCosTemplate.createBucket(BUCKET);
    }

    @Test
    public void testExistBucket() {
        final boolean exists = tencentCosTemplate.bucketExists(BUCKET);
        Assert.assertTrue(exists);
    }

    @Test
    public void testDeleteBucket() {
        tencentCosTemplate.deleteBucket(BUCKET);
    }

    @Test
    @SneakyThrows
    public void testUploadFile() {
        @Cleanup FileInputStream inputStream = new FileInputStream(FILE);
        OssFile ossFile = tencentCosTemplate.uploadFile(BUCKET, FILE_NAME, inputStream);
        log.debug("【ossFile】= {}", ossFile);
    }

    @Test
    public void testDeleteFile() {
        tencentCosTemplate.deleteFile(BUCKET, "upload/2020-01-07/35537d7ccecc4059a3de06cf708ab5a1.jpeg");
    }

}
