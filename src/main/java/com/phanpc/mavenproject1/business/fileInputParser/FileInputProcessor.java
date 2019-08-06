/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanpc.mavenproject1.business.fileInputParser;

import com.phanpc.mavenproject1.communication.aws_service.S3FileDownloadedCallback;
import com.phanpc.mavenproject1.processing.TaskProcessor;

/**
 *
 * @author phanp
 */
public class FileInputProcessor extends TaskProcessor implements S3FileDownloadedCallback{
    
    public FileInputProcessor(int numOfProcessing, int taskSize) {
        super("FileInputProcessor", numOfProcessing, taskSize);
    }

    @Override
    public void onDownloaded(String filePath) {
        //read file
        String line = "";
        //convert eachline into obj FileParserItem
        FileParserItem obj = new FileParserItem(line);
        
        queue.put(obj, 0);
    }    
      
}
