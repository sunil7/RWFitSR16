package com.example.baselibrary.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.XXApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: h, reason: collision with root package name */
    public static final a f7256h;

    /* renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f7257a;

    /* renamed from: b, reason: collision with root package name */
    public XXApplication f7258b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f7259c;

    /* renamed from: d, reason: collision with root package name */
    public SimpleDateFormat f7260d;
    public SimpleDateFormat e;

    /* renamed from: f, reason: collision with root package name */
    public String f7261f;

    /* renamed from: g, reason: collision with root package name */
    public String f7262g;

    static {
        a aVar = new a();
        aVar.f7259c = new HashMap();
        aVar.f7260d = new SimpleDateFormat("yyyy-MM-dd");
        aVar.e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f7256h = aVar;
    }

    public static void a(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.exists() && (listFiles = file.listFiles()) != null && file.length() > 10) {
            for (File file2 : listFiles) {
                Date date = new Date(file2.lastModified());
                Calendar calendar = Calendar.getInstance();
                int i3 = calendar.get(6);
                calendar.setTime(date);
                if (i3 - calendar.get(6) > 10) {
                    file2.delete();
                }
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th2) {
        if (th2 == null) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7257a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
                return;
            }
        } else {
            new ca.e().start();
            XXApplication xXApplication = this.f7258b;
            HashMap hashMap = this.f7259c;
            try {
                PackageInfo packageInfo = xXApplication.getPackageManager().getPackageInfo(xXApplication.getPackageName(), 1);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (str == null) {
                        str = "null";
                    }
                    String str2 = packageInfo.versionCode + "";
                    hashMap.put("versionName", str);
                    hashMap.put("versionCode", str2);
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("CrashHandlerUtil", "an error occured when collect package info", e);
            }
            for (Field field : Build.class.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    hashMap.put(field.getName(), field.get(null).toString());
                    Log.d("CrashHandlerUtil", field.getName() + " : " + field.get(null));
                } catch (Exception e10) {
                    Log.e("CrashHandlerUtil", "an error occured when collect crash info", e10);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry entry : hashMap.entrySet()) {
                stringBuffer.append(((String) entry.getKey()) + "=" + ((String) entry.getValue()) + "\n");
            }
            stringBuffer.append("date=" + this.e.format(new Date()));
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th2.printStackTrace(printWriter);
            for (Throwable cause = th2.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            stringBuffer.append(stringWriter.toString());
            try {
                String str3 = "crash_log_" + this.f7260d.format(new Date()) + ".txt";
                if (Environment.getExternalStorageState().equals("mounted")) {
                    if (TextUtils.isEmpty(this.f7262g)) {
                        this.f7262g = this.f7261f;
                    } else {
                        a(this.f7262g);
                    }
                    File file = new File(this.f7262g);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f7262g, str3), true);
                    fileOutputStream.write(stringBuffer.toString().getBytes());
                    fileOutputStream.close();
                }
            } catch (Exception e11) {
                Log.e("CrashHandlerUtil", "an error occured while writing url...", e11);
            }
        }
        try {
            Thread.sleep(Const.L_MAX_WAIT_WIFI);
        } catch (InterruptedException e12) {
            Log.e("CrashHandlerUtil", "error : ", e12);
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
