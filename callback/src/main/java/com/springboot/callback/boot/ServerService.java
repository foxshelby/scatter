package com.springboot.callback.boot;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author:zdd
 * @Date： 2022/11/30 9:26
 * 服务端的类
 */
@Component
public class ServerService {

    /**
     * @author zdd
     * @createTime 2022/11/30 9:28
     * @desc 服务端需要将进行回调任务的对象作为属性
     * @Param
     * @return
     */
    private CallBack callBack;

    /**
     * @return void
     * @author zdd
     * @createTime 2022/11/30 9:31
     * @desc 正式调用任务的入口
     * @Param []
     */
    public void run() throws InterruptedException {
        callBack.startTask();

        for (int i = 0; i < 10; i++) {
            callBack.showProcess(i + "");
            Thread.sleep(10000);
        }
        callBack.stopProcess();
    }

    public CallBack getCallBack() {
        return callBack;
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
