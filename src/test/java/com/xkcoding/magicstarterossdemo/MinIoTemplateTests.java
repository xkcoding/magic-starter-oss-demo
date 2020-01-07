package com.xkcoding.magicstarterossdemo;

import com.xkcoding.magic.oss.model.OssFile;
import com.xkcoding.magic.oss.support.minio.MinIoTemplate;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;

/**
 * <p>
 * MinIO测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020/1/7 17:40
 */
@Slf4j
public class MinIoTemplateTests extends MagicStarterOssDemoApplicationTests {
    @Autowired
    private MinIoTemplate minIoTemplate;

    @Test
    public void testCreateBucket() {
        minIoTemplate.createBucket(BUCKET);
    }

    @Test
    public void testExistBucket() {
        final boolean exists = minIoTemplate.bucketExists(BUCKET);
        Assert.assertTrue(exists);
    }

    @Test
    public void testDeleteBucket() {
        minIoTemplate.deleteBucket(BUCKET);
    }

    @Test
    @SneakyThrows
    public void testUploadFile() {
        @Cleanup FileInputStream inputStream = new FileInputStream(FILE);
        OssFile ossFile = minIoTemplate.uploadFile(BUCKET, FILE_NAME, inputStream);
        log.debug("【ossFile】= {}", ossFile);
    }

    @Test
    public void testDeleteFile() {
        minIoTemplate.deleteFile(BUCKET, "upload/2020-01-07/b839d25b276246e2b1869f50b31a893d.jpeg");
    }

}
