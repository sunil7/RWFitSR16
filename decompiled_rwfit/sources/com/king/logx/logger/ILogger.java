package com.king.logx.logger;

/* loaded from: classes.dex */
public interface ILogger {
    void d(String str, Object... objArr);

    void d(Throwable th2);

    void d(Throwable th2, String str, Object... objArr);

    void e(String str, Object... objArr);

    void e(Throwable th2);

    void e(Throwable th2, String str, Object... objArr);

    void i(String str, Object... objArr);

    void i(Throwable th2);

    void i(Throwable th2, String str, Object... objArr);

    void log(int i3, String str);

    void log(int i3, Throwable th2);

    void log(int i3, Throwable th2, String str);

    ILogger offset(int i3);

    ILogger tag(String str);

    void v(String str, Object... objArr);

    void v(Throwable th2);

    void v(Throwable th2, String str, Object... objArr);

    void w(String str, Object... objArr);

    void w(Throwable th2);

    void w(Throwable th2, String str, Object... objArr);

    void wtf(String str, Object... objArr);

    void wtf(Throwable th2);

    void wtf(Throwable th2, String str, Object... objArr);
}
