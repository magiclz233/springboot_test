package com.cnpc.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class FastDFSClients {

   private static Logger logger = LoggerFactory.getLogger(FastDFSClients.class);
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
        }catch (Exception e){
            logger.error("FastDFS Client Init Fail!",e);
        }
    }
}
