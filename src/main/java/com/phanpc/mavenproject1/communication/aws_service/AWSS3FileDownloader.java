/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanpc.mavenproject1.communication.aws_service;

import com.phanpc.mavenproject1.config.AppConfig;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phanp
 */
public class AWSS3FileDownloader extends Thread {
    private ArrayList<String> ntfQueue = new ArrayList();
    private int s3ScanningInteval = 1000;
    private boolean bRunning = false;
    HttpFileDownloader fileDownloader = new HttpFileDownloader();
    S3FileDownloadedCallback fileDownloeaderCallback;
    
    public void init(S3FileDownloadedCallback fileDownloeaderCallback_) {
        System.out.println("AWSS3FileDownloader.init()");
        
        fileDownloeaderCallback = fileDownloeaderCallback_;
        //start queue scanner
        s3ScanningInteval = AppConfig.instance().getS3ScanningInterval();
        
        //start scanning thread
        this.start();
    }
    
    private String getUriPathFromNtfObject(String ntf) {
        return "";
    }
    
    @Override
    public void run() {
        System.out.println("AWSS3FileDownloader.run() is running");
        bRunning = true;
        while(bRunning) {
            //check ntfQueue
            if (ntfQueue.size() > 0) {
                String ntfStr = ntfQueue.remove(0);
                
                String remotPath = getUriPathFromNtfObject(ntfStr);
                //synchronous downloading
                String localPath = fileDownloader.download(remotPath);
                // notify to file reader worker
                fileDownloeaderCallback.onDownloaded(localPath);
            }   
            else {
                try {
                    Thread.sleep(s3ScanningInteval);
                } catch (InterruptedException ex) {
                    //loggin
                }                
            }
        }
    }
    
    public void uninit() {
        
    }
}
