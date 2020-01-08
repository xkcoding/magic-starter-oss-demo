# magic-starter-oss-demo

> 演示对象存储模块的使用，支持七牛云存储、阿里云OSS、腾讯云COS、MinIO。

## 配置

### 阿里云 OSS

#### 引入依赖

```xml
<dependency>
  <groupId>com.aliyun.oss</groupId>
  <artifactId>aliyun-sdk-oss</artifactId>
  <version>${aliyun.oss.version}</version>
</dependency>
```

#### 配置文件

```yaml
magic:
  oss:
    ali-oss:
      enabled: true
      access-key: LTA**************WHXtC
      secret-key: PQw*************************r3
      endpoint: oss-cn-hangzhou.aliyuncs.com
      bucket-name: test
      https: true
```

### 腾讯云 COS

#### 引入依赖

```xml
<dependency>
  <groupId>com.qcloud</groupId>
  <artifactId>cos_api</artifactId>
  <version>${qcloud.oss.version}</version>
</dependency>
```

#### 配置文件

```yaml
magic:
  oss:
    tencent-cos:
      enabled: true
      app-id: 125****51
      access-key: AK****************************at1pg
      secret-key: npJ****************************nqz
      bucket-name: test
      region: ap-shanghai
      https: true
```

### 七牛云

#### 引入依赖

```xml
<dependency>
  <groupId>com.qiniu</groupId>
  <artifactId>qiniu-java-sdk</artifactId>
  <version>${qiniu.oss.version}</version>
</dependency>
```

#### 配置文件

```yaml
magic:
  oss:
    qiniu-cloud:
      enabled: true
      access-key: 9Qx*****************9jtENhZ-sTGV**********f5Rd
      secret-key: 8izWd*****************************Ccgd
      bucket-name: test
      endpoint: http://q3**********cho.bkt.clouddn.com
      region: z0
```

### MinIO

#### 引入依赖

```xml
<dependency>
  <groupId>io.minio</groupId>
  <artifactId>minio</artifactId>
  <version>${minio.oss.version}</version>
</dependency>
```

#### 配置文件

```yaml
magic:
  oss:
    min-io:
      enabled: true
      access-key: minioadmin
      secret-key: minioadmin
      bucket-name: test
      endpoint: http://192.168.31.8:9000
```

## 使用

### 阿里云 OSS

```java
@Autowired
private AliOssTemplate aliOssTemplate;
```

### 腾讯云 COS

```java
@Autowired
private TencentCosTemplate tencentCosTemplate;
```

### 七牛云

```java
@Autowired
private QiNiuCloudTemplate qiNiuCloudTemplate;
```

### MinIO

```java
@Autowired
private MinIoTemplate minIoTemplate;
```