/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanpc.mavenproject1.processing;

import com.phanpc.mavenproject1.config.AppConfig;

/**
 *
 * @author phanp
 */
public class TaskProcessor {
    private TaskProcessing [] procLst;
    protected TaskQueue queue;
    private String procName;
    
    public TaskProcessor(String procName_, int numOfProcessing, int taskSize) {
        if (numOfProcessing < 0)
            numOfProcessing = 1;
        
        procName = procName_;
        queue = new TaskQueue(taskSize);
        
        procLst = new TaskProcessing[numOfProcessing];
        for (int i = 0; i < procLst.length; i++)
            procLst[i] = new TaskProcessing(i, queue);
    }
    
    public void init() {
        System.out.print("TaskProcessor.init(), name=" + procName);
        for(TaskProcessing processing: procLst)
            processing.start();
    }
    
    public void uninit() {
        System.out.print("TaskProcessor.uninit(), name=" + procName);
    }
}
