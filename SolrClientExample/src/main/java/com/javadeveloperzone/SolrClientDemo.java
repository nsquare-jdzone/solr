package com.javadeveloperzone;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.IOException;

/**
 * Created by JavaDevZone on 11/11/2017.
 */
public class SolrClientDemo {

    public static void setSystemProperty(){
        System.setProperty("javax.net.ssl.keyStore", "D:\\solr-7.1.0\\solr-7.1.0\\bin\\solr-ssl.keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "secret");
        System.setProperty("javax.net.ssl.trustStore", "D:\\solr-7.1.0\\solr-7.1.0\\bin\\solr-ssl.keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "secret");
    }
    public void pingRequestDemo(){

        System.setProperty("javax.net.ssl.keyStore", "D:\\solr-7.1.0\\solr-7.1.0\\bin\\solr-ssl.keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "secret");
        System.setProperty("javax.net.ssl.trustStore", "D:\\solr-7.1.0\\solr-7.1.0\\bin\\solr-ssl.keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "secret");
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder("https://localhost:8983/solr/SecureSolrTest").build();
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        solrQuery.set("fl","*");
        solrQuery.setRows(10);
        try {
            QueryRequest queryRequest = new QueryRequest(solrQuery);
            queryRequest.setBasicAuthCredentials("solr","SolrRocks");
            QueryResponse solrResponse = queryRequest.process(httpSolrClient);
            System.out.println(solrResponse);
            System.out.println("Total Documents : "+solrResponse.getResults().getNumFound());
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SolrClientDemo.setSystemProperty();
        SolrClientDemo solrClientDemo = new SolrClientDemo();
        solrClientDemo.pingRequestDemo();
    }
}
