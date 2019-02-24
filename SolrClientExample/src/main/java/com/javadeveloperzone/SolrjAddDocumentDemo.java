package com.javadeveloperzone;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JavaDeveloperZone on 1/14/2018.
 */
public class SolrjAddDocumentDemo {
    public void addDocuments() throws IOException, SolrServerException {
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder("http://localhost:8983/solr/SpringBoot_DocumentExample").build();


        List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        for(int i=10101;i<100101;i++) {
            SolrInputDocument solrInputFields = new SolrInputDocument();
            solrInputFields.addField("id", ""+i);
            solrInputFields.addField("name", "name:"+i);
            docs.add(solrInputFields);

        }
        httpSolrClient.add(docs);
        httpSolrClient.commit();
        httpSolrClient.close();

    }

    public static void main(String[] args) throws IOException, SolrServerException {
        SolrjAddDocumentDemo addDocumentDemo = new SolrjAddDocumentDemo();
        addDocumentDemo.addDocuments();
    }
}
