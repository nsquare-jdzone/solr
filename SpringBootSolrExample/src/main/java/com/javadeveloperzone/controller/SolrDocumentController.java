package com.javadeveloperzone.controller;

import com.javadeveloperzone.model.Document;
import com.javadeveloperzone.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JavaDeveloperZone on 16-12-2017.
 */
@RestController
public class SolrDocumentController {

    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping("/")
    public String SpringBootSolrExample() {
        return "Welcome to Spring Boot solr Example";
    }

    @RequestMapping("/delete")
    public String deleteAllDocuments() {
        try {   //delete all documents from solr core
            documentRepository.deleteAll();
            return "documents deleted succesfully!";
        }catch (Exception e){
        return "Failed to delete documents";
        }
    }

    @RequestMapping("/save")
    public String saveAllDocuments() {
        //Store Documents
        documentRepository.save(Arrays.asList(new Document("1", "pdf","Java Dev Zone"),
                new Document("2", "msg", "subject:reinvetion"),
                new Document("3", "pdf", "Spring boot sessions"),
                new Document("4", "docx", "meeting agenda"),
                new Document("5", "docx", "Spring boot + solr")));
        return "5 documents saved!!!";
    }
    @RequestMapping("/getAll")
    public List<Document> getAllDocs() {
        List<Document> documents = new ArrayList<>();
        // iterate all documents and add it to list
        for (Document doc : this.documentRepository.findAll()) {
            documents.add(doc);
        }
        return documents;
    }
}
