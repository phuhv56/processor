/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanpc.mavenproject1.database;

/**
 *
 * @author phanp
 */
public class BigChainDBImpl implements BigChainDBInterface{
    public static BigChainDBImpl _instance;
    
    protected BigChainDBImpl() {
        
    }
    
    public static BigChainDBImpl instance() {
        if (_instance == null)
            _instance = new BigChainDBImpl();
        
        return _instance;
    }
    
    @Override
    public void saveResidentInfo(ResidentObject obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
