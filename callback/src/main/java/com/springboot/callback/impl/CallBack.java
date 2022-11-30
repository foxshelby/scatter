package com.springboot.callback.impl;

/**
 * @Author:zdd
 * @Date： 2022/11/30 8:53
 * 回调接口
 */
public interface CallBack {
    /**
     * @author zdd
     * @createTime 2022/11/30 8:55
     * @desc 开始具体事务
     * @Param []
     * @return void
     */
    void startDownload();

    /**
     * @author zdd
     * @createTime 2022/11/30 8:56
     * @desc 查看过程数据
     * @Param []
     * @return void
     */
    void showDownloadProgress(int progress);

    /**
     * @author zdd
     * @createTime 2022/11/30 8:57
     * @desc 停止具体事务
     * @Param []
     * @return void
     */
    void stopDownload();


    void showDownloadURL(String url);
}
