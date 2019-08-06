/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanpc.mavenproject1.business.fileInputParser;

import com.phanpc.mavenproject1.processing.TaskItem;

/**
 *
 * @author phanp
 */
public class FileParserItem extends TaskItem {
    String line;
    public FileParserItem(String line_ ){
        line = line_;
    }
    
    @Override
    public void process() {
        //process with blockchaine ...
        
        
        //after processed then put result into db
    }
    
}
