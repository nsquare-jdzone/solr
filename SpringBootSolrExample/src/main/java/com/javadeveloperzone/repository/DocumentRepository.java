package com.javadeveloperzone.repository;

import java.util.List;

import com.javadeveloperzone.model.Document;
import org.springframework.data.solr.repository.SolrCrudRepository;


public interface DocumentRepository extends SolrCrudRepository<Document, String> {
	List<Document> findByDocTitleEndsWith(String name);
	List<Document> findByDocTitleStartsWith(String name);
	List<Document> findByDocTypeEndsWith(String name);
	List<Document> findByDocTypeStartsWith(String name);
}
