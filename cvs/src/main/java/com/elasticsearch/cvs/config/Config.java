package com.elasticsearch.cvs.config;

import com.elasticsearch.cvs.remote.SiteCV;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients(basePackageClasses = SiteCV.class)
@EnableScheduling
public class Config {
}
