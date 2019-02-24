package com.javadevzone.solr;

import org.apache.solr.handler.component.ResponseBuilder;
import org.apache.solr.handler.component.SearchComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by JavaDeveloperZone on 5/7/2017.
 */
public class CustomQueryComponent extends SearchComponent{

    private static final Logger LOG = LoggerFactory.getLogger(CustomQueryComponent.class);
    @Override
    public void prepare(ResponseBuilder responseBuilder) throws IOException {
        LOG.info("prepare method of CustomQueryComponent");
    }

    @Override
    public void process(ResponseBuilder responseBuilder) throws IOException {
        LOG.info("process method of CustomQueryComponent");
    }

    @Override
    public String getDescription() {
        return "CustomQueryComponent";
    }
}
