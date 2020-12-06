package com.elasticsearch.cvs.hooks;

import com.elasticsearch.cvs.model.CV;
import com.elasticsearch.cvs.remote.SiteCV;
import com.google.gson.Gson;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import static org.elasticsearch.common.xcontent.XContentType.JSON;

@Component
public class CvIndexer {

    private static final Logger LOGGER= LoggerFactory.getLogger(SiteCV.class);

    private static final String CV_INDEX = "cvs";

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private SiteCV siteCV;

    @Autowired
    private Gson gson;

    @Scheduled(fixedDelay = 5000, initialDelay = 5000)
    public void reindex() throws IOException{

        LOGGER.info("Start reindexing...");
        List<CV> cvs = siteCV.getCVS();

        boolean exist = restHighLevelClient.indices().exists(new GetIndexRequest(CV_INDEX), RequestOptions.DEFAULT);

        if(exist){
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(CV_INDEX);
            restHighLevelClient.indices().delete(deleteIndexRequest,RequestOptions.DEFAULT);
        }

        BulkRequest bulkRequest = new BulkRequest();
        cvs.forEach(cv -> {

            IndexRequest indexRequest= new IndexRequest(CV_INDEX).
                    source(gson.toJson(cv),JSON);
            bulkRequest.add(indexRequest);
        });
        restHighLevelClient.bulk(bulkRequest,RequestOptions.DEFAULT);
        LOGGER.info("end indexing .");
    }


}
