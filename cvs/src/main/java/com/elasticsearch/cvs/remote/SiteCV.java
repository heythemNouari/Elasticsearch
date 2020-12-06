package com.elasticsearch.cvs.remote;

import com.elasticsearch.cvs.model.CV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "cv-provider", url = "")
public interface SiteCV {

    @GetMapping("/api/cvs")
    List<CV> getCVS();
}
