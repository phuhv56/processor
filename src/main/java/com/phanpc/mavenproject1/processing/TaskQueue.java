/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanpc.mavenproject1.processing;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phanp
 */
public class TaskQueue {

    private final ArrayList<TaskItem> queue = new ArrayList<>();
    private int maxItems = 1000;

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    public TaskQueue(int maxItems_) {
        maxItems = maxItems_;
    }

    public boolean put(TaskItem item, int waitTime) {
        lock.lock();
        try {
            if (queue.size() >= maxItems) {
                try {
                    if (waitTime > 0) {
                        notFull.await(waitTime, TimeUnit.MILLISECONDS);
                    }
                    else {
                        notFull.await();
                    }
                } catch (InterruptedException ex) {
                    //loggin
                }
            }
            
            if (queue.size() >= maxItems) {
                return false;
            }

            queue.add(item);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }

        return true;
    }

    //get at head
    public TaskItem get(int waitTime) {
        lock.lock();
        try {
            if (queue.isEmpty()) {
                try {
                    if (waitTime > 0) {
                        notEmpty.await(waitTime, TimeUnit.MILLISECONDS);                    
                    }
                    else 
                        notEmpty.await();
                } catch (InterruptedException ex) {
                    //loggin
                }
            }            
            
            if (queue.isEmpty())
                return null;
            
            TaskItem item = queue.remove(0);  
            
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }
}
