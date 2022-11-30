package com.springboot.callback.boot;

/**
 * @Author:zdd
 * @Date： 2022/11/30 9:23
 * 自定义的回调接口
 */
public interface CallBack {

    /**
     * @author zdd
     * @createTime 2022/11/30 9:23
     * @desc 启动某个具体事务
     * @Param []
     * @return void
     */
    void startTask();

    /**
     * @author zdd
     * @createTime 2022/11/30 9:24
     * @desc 展示某个具体事务的进程
     * @Param []
     * @return void
     */
    String showProcess(String process);

    /**
     * @author zdd
     * @createTime 2022/11/30 9:25
     * @desc 停止某个具体事务
     * @Param []
     * @return void
     */
    void stopProcess();
}
