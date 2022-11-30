package com.springboot.callback.impl;

import org.springframework.stereotype.Component;

/**
 * @Author:zdd
 * @Date： 2022/11/30 8:57
 */
public class Client implements CallBack{



    private Server mServer = null;

    public Client() {
        // TODO Auto-generated constructor stub
    }

    public void download(String url) {
        mServer = new Server(Client.this, url);
        mServer.Run();
    }

    @Override
    public void startDownload() {
        // TODO Auto-generated method stub
        System.out.println("startDownload");
    }

    @Override
    public void stopDownload() {
        // TODO Auto-generated method stub
        System.out.println("stopDownload");
    }

    @Override
    public void showDownloadURL(String url) {
        // TODO Auto-generated method stub
        System.out.println("Download URL: " + url);
    }

    @Override
    public void showDownloadProgress(int progress) {
        // TODO Auto-generated method stub
        System.out.println("DownloadProgress: " + progress + "%");
    }
}
