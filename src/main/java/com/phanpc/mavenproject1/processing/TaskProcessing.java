/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanpc.mavenproject1.processing;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phanp
 */
public class TaskProcessing implements Runnable {
    private Thread _instance;
    private TaskQueue queue;
    private boolean bRunning = false;
    private int procId;
    
    public TaskProcessing(int id, TaskQueue queue_) {
        queue = queue_;
        procId = id;
    }
    
    public void start() {
        _instance = new Thread(this);
        bRunning = true;
        _instance.start();
    }
    
    public void stop() {
        bRunning = false;
        try {
            _instance.wait();
        } catch (InterruptedException ex) {
            //logign
        }
    }
    
    @Override
    public void run() {
        System.out.println("processing Id=" + procId + " is running");
        while(bRunning) {
            TaskItem item = queue.get(0);
            item.process();
        }
    }
    
}
