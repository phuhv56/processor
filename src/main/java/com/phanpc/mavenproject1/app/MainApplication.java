/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanpc.mavenproject1.app;

import com.phanpc.mavenproject1.business.fileInputParser.FileInputProcessor;
import com.phanpc.mavenproject1.communication.aws_service.AWSS3FileDownloader;
import com.phanpc.mavenproject1.config.AppConfig;

/**
 *
 * @author phanp
 */
public class MainApplication {
    private AWSS3FileDownloader awsFileDownloader = new AWSS3FileDownloader();
    private FileInputProcessor fileInputProcessor;
    
    public void init(String cfgPath, String logPath) {
        AppConfig.instance().readCfg(cfgPath);
        
        fileInputProcessor = new FileInputProcessor(AppConfig.instance().getReadingFileWorkerSize(), 20000);
                
        fileInputProcessor.init();
        awsFileDownloader.init(fileInputProcessor);
    }
    
    public void uninit() {
        
    }
    
    public static void main(String [] args) {
        MainApplication app = new  MainApplication();
        app.init("config.xml", "log4j.xml");
    }
}
