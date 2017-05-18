package com.cq.customview.util;

import android.util.Log;

/**
 * Wrapper API for sending log output. Log rating references to the {@link Log}.
 * <br>All levels of log will be output when the {@link #LEVEL}'s value is less
 * than 3 and will not be if the {@link #LEVEL}'s value is greater than 8.
 *
 * @author WuHonglin
 * @version 1.1.24
 * @since 1.0
 */
public final class Logger {

    private static int LEVEL = 1;

    private static StackTraceElement caller = null;

    /**
     * Priority constant for the println method; use Log.v.<br> <b>Verbose
     * should never be compiled into an application except during
     * development.</b> When development is complete and you are ready to
     * release your application to the world, you should remove all verbose
     * method calls either by commenting them out, or using ProGuard to remove
     * any verbose log statements directly from the bytecode of your compiled
     * JAR executable.
     */
    private static final int VERBOSE = 2;

    /**
     * Priority constant for the println method; use Log.d.<br> <b>Debug</b>
     * logs are compiled in but stripped at runtime.
     */
    private static final int DEBUG = 3;

    /**
     * Priority constant for the println method; use Log.i.<br> <b>Error</b>,
     * <b>warning</b>, and <b>informational</b> logs are always kept.
     */
    private static final int INFO = 4;

    /**
     * Priority constant for the println method; use Log.w.<br> <b>Error</b>,
     * <b>warning</b>, and <b>informational</b> logs are always kept.
     */
    private static final int WARN = 5;

    /**
     * Priority constant for the println method; use Log.e.<br> <b>Error</b>,
     * <b>warning</b>, and <b>informational</b> logs are always kept.
     */
    private static final int ERROR = 6;

    /**
     * Priority constant for the println method.
     */
    private static final int ASSERT = 7;

    /**
     * Specify the method that will be called is Log.v.
     */
    private static final String v = "v";

    /**
     * Specify the method that will be called is Log.d.
     */
    private static final String d = "d";

    /**
     * Specify the method that will be called is Log.i.
     */
    private static final String i = "i";

    /**
     * Specify the method that will be called is Log.w.
     */
    private static final String w = "w";

    /**
     * Specify the method that will be called is Log.e.
     */
    private static final String e = "e";

    /**
     * Specify the method that will be called is Log.wtf.
     */
    private static final String wtf = "wtf";

    private Logger() {

    }

    /**
     * Send a {@link #VERBOSE} log message.
     *
     * @param msg The message you would like logged.
     */
    public static void v(String msg) {
        if (LEVEL <= VERBOSE)
            printLog(v, msg);
    }

    /**
     * Send a {@link #VERBOSE} log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void v(String msg, Throwable thr) {
        if (LEVEL <= VERBOSE)
            printLog(v, msg, thr);
    }

    /**
     * Send a {@link #DEBUG} log message.
     *
     * @param msg The message you would like logged.
     */
    public static void d(String msg) {
        if (LEVEL <= DEBUG)
            printLog(d, msg);
    }

    /**
     * Send a {@link #DEBUG} log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void d(String msg, Throwable thr) {
        if (LEVEL <= DEBUG)
            printLog(d, msg, thr);
    }

    /**
     * Send an {@link #INFO} log message.
     *
     * @param msg The message you would like logged.
     */
    public static void i(String msg) {
        if (LEVEL <= INFO)
            printLog(i, msg);
    }

    /**
     * Send a {@link #INFO} log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void i(String msg, Throwable thr) {
        if (LEVEL <= INFO)
            printLog(i, msg, thr);
    }

    /**
     * Send a {@link #WARN} log message.
     *
     * @param msg The message you would like logged.
     */
    public static void w(String msg) {
        if (LEVEL <= WARN)
            printLog(w, msg);
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void w(String msg, Throwable thr) {
        if (LEVEL <= WARN)
            printLog(w, msg, thr);
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     *
     * @param thr An exception to log
     */
    public static void w(Throwable thr) {
        if (LEVEL <= WARN)
            printLog(w, thr);
    }

    /**
     * Send an {@link #ERROR} log message.
     *
     * @param msg The message you would like logged.
     */
    public static void e(String msg) {
        if (LEVEL <= ERROR)
            printLog(e, msg);
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void e(String msg, Throwable thr) {
        if (LEVEL <= ERROR)
            printLog(e, msg, thr);
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     *
     * @param thr An exception to log
     */
    public static void e(Throwable thr) {
        if (LEVEL <= ERROR)
            printLog(e, thr);
    }

    /**
     * What a Terrible Failure: Report a condition that should never happen. The
     * error will always be logged at level ASSERT with the call stack.
     * Depending on system configuration, a report may be added to the
     * {@link android.os.DropBoxManager} and/or the process may be terminated
     * immediately with an error dialog.<br><br>
     * You can think of this method as the equivalent of Java's assert method.
     *
     * @param msg The message you would like logged.
     */
    public static void wtf(String msg) {
        if (LEVEL <= ASSERT)
            printLog(wtf, msg);
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.<br><br>
     * You can think of this method as the equivalent of Java's assert method.
     *
     * @param thr An exception to log.
     */
    public static void wtf(Throwable thr) {
        if (LEVEL <= ASSERT)
            printLog(wtf, thr);
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.<br><br>
     * You can think of this method as the equivalent of Java's assert method.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log. May be null.
     */
    public static void wtf(String msg, Throwable thr) {
        if (LEVEL <= ASSERT)
            printLog(wtf, msg, thr);
    }

    /**
     * Print a log message.
     *
     * @param method The method that will be called. use {@link #v}, {@link #d}, {@link #i}, {@link #w}, {@link #e} and {@link #wtf}.
     * @param msg    The message you would like logged.
     */
    private static void printLog(String method, String msg) {
        caller = new Throwable().fillInStackTrace().getStackTrace()[2];
        switch (method) {
            case v:
                Log.v(caller.getClassName(), buildMessage(msg, caller));
                break;
            case d:
                Log.d(caller.getClassName(), buildMessage(msg, caller));
                break;
            case i:
                Log.i(caller.getClassName(), buildMessage(msg, caller));
                break;
            case w:
                Log.w(caller.getClassName(), buildMessage(msg, caller));
                break;
            case e:
                Log.e(caller.getClassName(), buildMessage(msg, caller));
                break;
            case wtf:
                Log.wtf(caller.getClassName(), buildMessage(msg, caller));
                break;

            default:
                Log.e(Logger.class.getSimpleName(), String.format("oh shit, you are trying to call a wrong method : %s(), the correct method name must be : v, d, i, w, e or wtf.", method));
                break;
        }
    }

    /**
     * Print a log message.
     *
     * @param method The method that will be called. use {@link #w}, {@link #e} and {@link #wtf}.
     * @param thr    An exception to log.
     */
    private static void printLog(String method, Throwable thr) {
        caller = new Throwable().fillInStackTrace().getStackTrace()[2];
        switch (method) {
            case w:
                Log.w(caller.getClassName(), buildMessage(thr.getMessage(), caller), thr);
                break;
            case e:
                Log.e(caller.getClassName(), buildMessage(thr.getMessage(), caller), thr);
                break;
            case wtf:
                Log.wtf(caller.getClassName(), buildMessage(thr.getMessage(), caller), thr);
                break;

            default:
                Log.e(Logger.class.getSimpleName(), String.format("oh shit, you are trying to call a wrong method : %s(), the correct method name must be : w, e or wtf.", method));
                break;
        }
    }

    /**
     * Print a log message.
     *
     * @param method The method that will be called. use {@link #v}, {@link #d}, {@link #i}, {@link #w}, {@link #e} and {@link #wtf}.
     * @param msg    The message you would like logged.
     * @param thr    An exception to log.
     */
    private static void printLog(String method, String msg, Throwable thr) {
        caller = new Throwable().fillInStackTrace().getStackTrace()[2];
        switch (method) {
            case v:
                Log.v(caller.getClassName(), buildMessage(msg, caller), thr);
                break;
            case d:
                Log.d(caller.getClassName(), buildMessage(msg, caller), thr);
                break;
            case i:
                Log.i(caller.getClassName(), buildMessage(msg, caller), thr);
                break;
            case w:
                Log.w(caller.getClassName(), buildMessage(msg, caller), thr);
                break;
            case e:
                Log.e(caller.getClassName(), buildMessage(msg, caller), thr);
                break;
            case wtf:
                Log.wtf(caller.getClassName(), buildMessage(msg, caller), thr);
                break;

            default:
                Log.e(Logger.class.getSimpleName(), String.format("oh shit, you are trying to call a wrong method : %s(), the correct method name must be : v, d, i, w, e and wtf.", method));
                break;
        }
    }

    /**
     * Building Message
     *
     * @param msg    The message you would like logged.
     * @param caller The representation of a single stack frame.
     *
     * @return Message String
     */
    private static String buildMessage(String msg, StackTraceElement caller) {
        // return String.format("%1s() -> [at %2s line:%3s] -> %4s", caller.getMethodName(), caller.getFileName(), caller.getLineNumber(), msg);
        return String.format("%1s() -> [at line:%3s] -> %4s", caller.getMethodName(), caller.getLineNumber(), msg);
    }

}