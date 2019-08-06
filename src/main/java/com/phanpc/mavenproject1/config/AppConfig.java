/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanpc.mavenproject1.config;

/**
 *
 * @author phanp
 */
public class AppConfig {
    protected static  AppConfig _instance;
    
    public static AppConfig instance() {
        if (_instance == null)
            _instance = new AppConfig();
        
        return _instance;
    }
    
    public int getS3ScanningInterval() {
        return 0;
    }
    
    public void readCfg(String cfgPath) {
        //read all configs ....
    }
    
    public int getReadingFileWorkerSize() {
        return 4;
    }    
}
