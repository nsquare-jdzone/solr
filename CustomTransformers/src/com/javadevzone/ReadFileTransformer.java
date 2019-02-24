package com.javadevzone;

import org.apache.solr.handler.dataimport.Context;
import org.apache.solr.handler.dataimport.DataImporter;
import org.apache.solr.handler.dataimport.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


/**
 * Created by JavaDeveloperZone on 7/27/2017.
 */

public class ReadFileTransformer extends Transformer {

    private static Logger LOGGER = LoggerFactory.getLogger(ReadFileTransformer.class);

    @Override
    public Object transformRow(Map<String, Object> row, Context context) {
        List<Map<String, String>> fields = context.getAllEntityFields();

        for (Map<String, String> field : fields) {
            // Check if this field has readFile="true" specified in the data-config.xml
            String trim = field.get("readFile");
            if ("true".equals(trim)){
                String columnName = field.get(DataImporter.COLUMN);
                // Get this field's value from the current row
                Object filePath = row.get(columnName);
                // Read file content and put the updated value back in the current row
                if (filePath != null) {
                    try {
                        Path path = Paths.get(filePath.toString());
                        if (Files.exists(path) && !Files.isDirectory(path)) {
                            byte[] fileContent = Files.readAllBytes(path);
                            row.put(columnName, new String(fileContent,0,fileContent.length));
                        }
                    }catch (Exception e){
                        LOGGER.error("Error while reading file!!! ",e);
                    }

                }
            }
        }

        return row;
    }
}
