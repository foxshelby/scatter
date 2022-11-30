package com.springboot.callback.impl;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author:zdd
 * @Date： 2022/11/30 8:58
 */
public class Server {

    private CallBack iCallBack;
    private String mDownloadUrl = null;

    private Timer mTimer = null;

    private int mProgress = 0;

    public Server(CallBack iCallBack, String url) {
        this.iCallBack = iCallBack;
        this.mDownloadUrl = url;
        mProgress = 0;
    }

    public void Run() {
        iCallBack.showDownloadURL(mDownloadUrl); // 回调下载URL
        iCallBack.startDownload();               // 回调开始下载

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                iCallBack.showDownloadProgress(mProgress); // 回调下载进度
                if (mProgress == 100) {                    // 下载进度至100%
                    iCallBack.stopDownload();              // 回调下载结束
                    mTimer.cancel();
                }
                mProgress += 10;
            }
        }, 0, 1000);
    }

    public static final String URL = "https://www.baidu.com";
    public static void main(String[] args) {
        Client client = new Client();
        client.download(URL);
    }
}
