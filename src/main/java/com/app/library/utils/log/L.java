package com.app.library.utils.log;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;


import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;

public class L {

    /**
     * 输出log级别
     */

    private static boolean isDebug = true;
    private static boolean sIsSave = true;
    private static String sFileName = "";
    private static String sFilePath = Environment.getExternalStorageDirectory().getAbsolutePath();

    public static void setIsDebug(boolean isDebug) {
        L.isDebug = isDebug;
    }

    public static void init(boolean isSave, String path, String name) {
        sIsSave = isSave;
        sFilePath = path;
        if (!TextUtils.isEmpty(name)) {
            sFileName = name;
        }
    }

    public static void init(boolean isSave, String path) {
        init(isSave, path, "");
    }

    /**
     * 线程队列
     */
    private final static ConcurrentLinkedQueue<LogInfo> logQueue = new ConcurrentLinkedQueue<>();

    /**
     * 获取消息队列
     */
    public final synchronized static ConcurrentLinkedQueue<LogInfo> getLogQueue() {
        return logQueue;
    }

    /**
     * 记录日志信息
     *
     * @param content  日志内容
     * @param fileName 文件名
     */
    private static synchronized void addLog(String content, String fileName) {
        logQueue.add(new LogInfo(content, fileName));
        if (!LogWriteThread.isWriteThreadLive) {
            new LogWriteThread().start();
        }
    }

    /**
     * 以级别为 i 的形式输出LOG
     */

    public static void i(String msg) {
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);//自动生成TAG
        i(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            msg = Thread.currentThread().getName() + "/" + msg;
            Log.i(tag, msg);
            if (sIsSave) {
                writeLog(msg, sFileName);
            }
        }
    }


    private static void writeLog(String content, String name) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss SSS", Locale.CHINESE);
        String time = formatter.format(new Date());
        String result = time + "->" + content + "\r\n";// 日志文本  加上记录日志的时间
        addLog(result, name);
    }

    synchronized static void writeFile(String content, String name) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss SSS", Locale.CHINESE);
        try {
            String time = formatter.format(new Date());
            String result = time + "  " + content + "\r\n";// 日志文本加上实际写入日志的时间
            String path = sFilePath;
            String fileName = (TextUtils.isEmpty(name) ? new SimpleDateFormat("yyyyMMdd", Locale.CHINESE).format(new Date()) : "default") + ".txt";
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(path + "/" + fileName, true);
                fos.write(result.getBytes());
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }

    private static String generateTag(StackTraceElement caller) {
        String tag = "%s.%s(Line:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName
                .lastIndexOf(".") + 1);
        tag = String.format(Locale.CHINA, tag, callerClazzName, caller.getMethodName(),
                caller.getLineNumber());
        return tag;
    }
}
