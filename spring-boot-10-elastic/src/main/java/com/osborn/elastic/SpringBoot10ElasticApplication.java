package com.osborn.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种技术来和ES交互
 *  1、Jest(默认不生效)
 *      需要导入Jest的工具包(io.searchbox.client.JestClient)
 *  2、SpringData ElasticSearch[ES版本不合适]
 *      版本适配说明：https://github.com/spring-projects/spring-data-elasticsearch
 *         版本不适配解决方案：
 *              1.升级SpringBoot的版本
 *              2.安装对应版本的ElasticSearch版本
 *      1)、Client结点信息 clusterNodes；clusterName
 *      2)、ElasticsearchTemplate操作ES
 *      3)、编写一个ElasticsearchRepositoriy的子接口来操作ES
 *   两种用法：https://github.com/spring-projects/spring-data-elasticsearch
 *   1)、编写一个ElasticsearchRepositoriy的子接口
 */
@SpringBootApplication
public class SpringBoot10ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot10ElasticApplication.class, args);
    }
}
