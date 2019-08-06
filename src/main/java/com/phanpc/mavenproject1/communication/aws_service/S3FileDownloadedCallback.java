/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phanpc.mavenproject1.communication.aws_service;

/**
 *
 * @author phanp
 */
public interface S3FileDownloadedCallback {
    void onDownloaded(String filePath);
}
