package com.springboot.callback.boot;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:zdd
 * @Date： 2022/11/30 9:25
 */
@Component
@RestController
public class TaskClient implements CallBack {

    /**
     * @author zdd
     * @createTime 2022/11/30 9:54
     * @desc 这是用来保存当前任务的进程信息，正式场所可以保存在 ThreadLocal中
     * @Param
     * @return
     */
    private String process;
    /**
     * @author zdd
     * @createTime 2022/11/30 9:44
     * @desc 装载实现这个任务的具体实现类的对象   这个任务的具体实现代码是写在这个类中的   实际上ServerService中的run方法才是真正的业务逻辑代码
     * @Param
     * @return
     */
    @Resource
    private ServerService server;

    /**
     * @return void
     * @author zdd
     * @createTime 2022/11/30 9:26
     * @desc 具体事务的入口
     * @Param []
     */
    @GetMapping("/callback")
    public void task() throws InterruptedException {
        server.setCallBack(this);
        server.run();
    }

    @GetMapping("/process")
    public String showProcess() {
        return this.process;
    }

    /**
     * @return void
     * @author zdd
     * @createTime 2022/11/30 9:43
     * @desc 这个类是具体的某个事务的对应类，执行具体的事务，实现回调接口   展示当前任务的回调信息
     * @Param []
     */
    @Override
    public void startTask() {
        System.out.println("开启任务");
    }

    @Override
    public String showProcess(String process) {
        System.out.println("任务进行到" + process);
        this.process = "任务进行到" + process;
        return "任务进行到" + process;
    }

    @Override
    public void stopProcess() {
        System.out.println("任务停止");
    }
}
