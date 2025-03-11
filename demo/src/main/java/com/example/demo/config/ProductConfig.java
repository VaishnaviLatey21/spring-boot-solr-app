package com.example.demo.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    private static final String SOLR_URL = "http://localhost:8983/solr/products";

    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient.Builder(SOLR_URL).build();
    }
}
