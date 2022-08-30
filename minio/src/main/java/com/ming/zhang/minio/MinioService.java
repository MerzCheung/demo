package com.ming.zhang.minio;

import io.minio.*;

public class MinioService {
    public static void main(String[] args) throws Exception {
        MinioClient minioClient = MinioClient.builder()
                .endpoint("http://www.merzjava.com:9000")
                .credentials("R9iiI9kIlyANQ07g","kxPAYBWhxsQLVdfaJdcSzeXaQLELXrdM")
                .build();
        boolean oss = minioClient.bucketExists(BucketExistsArgs.builder().bucket("oss").build());
        if (!oss) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket("oss")
                            .build());
        }
        ObjectWriteResponse response = minioClient.uploadObject(
                UploadObjectArgs.builder()
                        .bucket("oss").object("wallbg0.png").filename("D:\\wallbg0.png").build());
        System.out.println("etag: " + response.etag());
        System.out.println("versionId: " + response.versionId());
    }
}
