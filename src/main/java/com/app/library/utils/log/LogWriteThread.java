package com.app.library.utils.log;

/**
 * 写日志线程类
 *
 * @author hebin
 */
class LogWriteThread extends Thread {

    public static boolean isWriteThreadLive = false;// 写日志线程是否已经在运行了

    @Override
    public void run() {
        isWriteThreadLive = true;
        while (!L.getLogQueue().isEmpty()) {// 对列不空时
            try {
                LogInfo logInfo = L.getLogQueue().poll();
                if (logInfo != null) {
                    L.writeFile(logInfo.getContent(), logInfo.getFileName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        isWriteThreadLive = false;// 队列中的日志都写完了，关闭线程（也可以常开 要测试下）
    }
}
