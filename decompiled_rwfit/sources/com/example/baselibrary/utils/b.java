package com.example.baselibrary.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import ch.f;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.XXApplication;
import eh.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import rg.l;
import rg.x;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f7263a;

    /* renamed from: b, reason: collision with root package name */
    public static String f7264b;

    /* renamed from: c, reason: collision with root package name */
    public static String f7265c;

    /* renamed from: d, reason: collision with root package name */
    public static String f7266d;
    public static String e;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0041 -> B:12:0x0050). Please report as a decompilation issue!!! */
    public static void A(String str, String str2) {
        File file;
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                try {
                    File file2 = new File(str2);
                    file = new File(str);
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                } catch (IOException e10) {
                    e = e10;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        try {
            if (file.isFile()) {
                B(zipOutputStream, file, "");
            } else {
                for (File file3 : file.listFiles()) {
                    kotlin.jvm.internal.e.e(file3, "get(...)");
                    B(zipOutputStream, file3, "");
                }
            }
            zipOutputStream.close();
        } catch (IOException e12) {
            e = e12;
            zipOutputStream2 = zipOutputStream;
            e.printStackTrace();
            if (zipOutputStream2 != null) {
                zipOutputStream2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                try {
                    zipOutputStream2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void B(ZipOutputStream zipOutputStream, File file, String str) {
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    if (file.isDirectory()) {
                        for (File file2 : file.listFiles()) {
                            kotlin.jvm.internal.e.e(file2, "get(...)");
                            B(zipOutputStream, file2, str + file.getName() + "/");
                        }
                    } else {
                        byte[] bArr = new byte[4096];
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    zipOutputStream.write(bArr, 0, read);
                                }
                            }
                            zipOutputStream.closeEntry();
                            fileInputStream = fileInputStream2;
                        } catch (IOException e10) {
                            e = e10;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e12) {
                e = e12;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (IOException e13) {
            e13.printStackTrace();
        }
    }

    public static long a(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(str);
            if (parse != null) {
                return parse.getTime() / 1000;
            }
            return 0L;
        } catch (Exception e10) {
            o(f7264b, r5.a.c(str, " date translate error ", e10.getMessage()));
            return 0L;
        }
    }

    public static void b(String path) {
        kotlin.jvm.internal.e.f(path, "path");
        File file = new File(path);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static File c(String path, Date date) {
        kotlin.jvm.internal.e.f(path, "path");
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(date);
        File[] listFiles = new File(path).listFiles();
        if (listFiles != null && listFiles.length >= 7) {
            if (listFiles.length > 1) {
                androidx.viewpager2.widget.a aVar = new androidx.viewpager2.widget.a(1);
                if (listFiles.length > 1) {
                    Arrays.sort(listFiles, aVar);
                }
            }
            File file = listFiles[0];
            kotlin.jvm.internal.e.e(file, "get(...)");
            e(file);
        }
        return new File(path, android.support.v4.media.session.e.l(format, ".log"));
    }

    public static File d(String path, Date date) {
        kotlin.jvm.internal.e.f(path, "path");
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA).format(date);
        File[] listFiles = new File(path).listFiles();
        if (listFiles != null && listFiles.length >= 7) {
            if (listFiles.length > 1) {
                androidx.viewpager2.widget.a aVar = new androidx.viewpager2.widget.a(2);
                if (listFiles.length > 1) {
                    Arrays.sort(listFiles, aVar);
                }
            }
            File file = listFiles[0];
            kotlin.jvm.internal.e.e(file, "get(...)");
            e(file);
        }
        return new File(path, android.support.v4.media.session.e.l(format, ".log"));
    }

    public static void e(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.isFile()) {
                    file.delete();
                    return;
                }
                return;
            }
            File[] listFiles = file.listFiles();
            kotlin.jvm.internal.e.c(listFiles);
            for (File file2 : listFiles) {
                kotlin.jvm.internal.e.c(file2);
                e(file2);
            }
            file.delete();
        }
    }

    public static int f(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Object g(String str, Type type) {
        return new com.google.gson.e().b(str, type);
    }

    public static List h(String str, Type type) {
        return !(str == null || "".equals(str.trim())) ? (List) new com.google.gson.e().b(str, type) : new ArrayList();
    }

    public static long i() {
        return TimeZone.getDefault().getOffset(System.currentTimeMillis());
    }

    public static int j(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static long k() {
        Calendar calendar = Calendar.getInstance();
        TimeZone.getDefault().useDaylightTime();
        calendar.add(14, TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? 3600000 : 0));
        return calendar.getTimeInMillis();
    }

    public static long l() {
        return TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L);
    }

    public static void m(XXApplication xXApplication) {
        f7263a = xXApplication.getFilesDir() + "/logger/";
        f7264b = r5.a.f(new StringBuilder(), f7263a, "app/");
        f7265c = r5.a.f(new StringBuilder(), f7263a, "network/");
        f7266d = r5.a.f(new StringBuilder(), f7263a, "devices/");
        e = r5.a.f(new StringBuilder(), f7263a, "product/");
        b(f7264b);
        b(f7265c);
        b(f7266d);
        b(e);
        a aVar = a.f7256h;
        aVar.f7258b = xXApplication;
        aVar.f7257a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(aVar);
        aVar.f7261f = xXApplication.getFilesDir() + "/crash/";
        String str = f7264b;
        aVar.f7262g = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static boolean n(XXApplication xXApplication) {
        BluetoothAdapter adapter = ((BluetoothManager) xXApplication.getSystemService("bluetooth")).getAdapter();
        if (adapter == null) {
            return false;
        }
        return adapter.isEnabled();
    }

    public static void o(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : objArr) {
            sb2.append(obj);
            sb2.append(' ');
        }
        String sb3 = sb2.toString();
        if (str.equalsIgnoreCase(e)) {
            try {
                FileWriter fileWriter = new FileWriter(c(str, new Date()).getAbsolutePath(), false);
                fileWriter.write(sb3 + "\n");
                fileWriter.flush();
                fileWriter.close();
                return;
            } catch (IOException e10) {
                e10.printStackTrace();
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                o(f7264b, android.support.v4.media.session.e.p(th2, new StringBuilder("写入日志出错: ")));
                return;
            }
        }
        try {
            FileWriter fileWriter2 = new FileWriter(c(str, new Date()).getAbsolutePath(), true);
            fileWriter2.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA).format(new Date()) + ":" + sb3 + "\n");
            fileWriter2.flush();
            fileWriter2.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (Throwable th3) {
            th3.printStackTrace();
            o(f7264b, android.support.v4.media.session.e.p(th3, new StringBuilder("写入日志出错: ")));
        }
    }

    public static String p(long j4) {
        try {
            return new SimpleDateFormat("HH", Locale.ENGLISH).format(Long.valueOf(j4));
        } catch (Exception e10) {
            o(f7264b, android.support.v4.media.session.e.h(j4, " date translate error ", e10.getMessage()));
            return null;
        }
    }

    public static String q(long j4) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Long.valueOf(j4));
        } catch (Exception e10) {
            o(f7264b, android.support.v4.media.session.e.h(j4, " date translate error ", e10.getMessage()));
            return null;
        }
    }

    public static String r(long j4) {
        try {
            return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).format(Long.valueOf(j4));
        } catch (Exception e10) {
            o(f7264b, android.support.v4.media.session.e.h(j4, " date translate error ", e10.getMessage()));
            return null;
        }
    }

    public static void s(XXApplication xXApplication) {
        BluetoothAdapter adapter = ((BluetoothManager) xXApplication.getSystemService("bluetooth")).getAdapter();
        if (adapter == null) {
            return;
        }
        adapter.enable();
    }

    public static final l t(l lVar) {
        l subscribeOn = lVar.subscribeOn(f.f3507d);
        tg.d dVar = tg.b.f18629a;
        if (dVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        l observeOn = subscribeOn.observeOn(dVar);
        kotlin.jvm.internal.e.e(observeOn, "observeOn(...)");
        return observeOn;
    }

    public static final l u(l lVar) {
        x xVar = f.f3505b;
        l observeOn = lVar.subscribeOn(xVar).observeOn(xVar);
        kotlin.jvm.internal.e.e(observeOn, "observeOn(...)");
        return observeOn;
    }

    public static int v(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static final l w(l lVar) {
        l subscribeOn = lVar.subscribeOn(f.f3505b);
        tg.d dVar = tg.b.f18629a;
        if (dVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        l observeOn = subscribeOn.observeOn(dVar);
        kotlin.jvm.internal.e.e(observeOn, "observeOn(...)");
        return observeOn;
    }

    public static void x(Object obj, oh.l runBlock, final oh.l backBlock) {
        kotlin.jvm.internal.e.f(runBlock, "runBlock");
        kotlin.jvm.internal.e.f(backBlock, "backBlock");
        l create = l.create(new com.example.baselibrary.preseneter.a(runBlock, obj, 1));
        kotlin.jvm.internal.e.e(create, "create(...)");
        t(create).subscribe(new androidx.camera.lifecycle.d(new oh.l() { // from class: com.example.baselibrary.utils.TaskUtils$startAsyncTask$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                m53invoke(obj2);
                return g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m53invoke(Object obj2) {
                oh.l.this.invoke(obj2);
            }
        }, 8), new androidx.camera.lifecycle.d(new oh.l() { // from class: com.example.baselibrary.utils.TaskUtils$startAsyncTask$3
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((Throwable) obj2);
                return g.f12633a;
            }

            public final void invoke(Throwable th2) {
                new StringBuilder("startAsyncTask error : ").append(b.z(th2));
            }
        }, 9));
    }

    public static void y(oh.l runBlock, final oh.l backBlock) {
        kotlin.jvm.internal.e.f(runBlock, "runBlock");
        kotlin.jvm.internal.e.f(backBlock, "backBlock");
        l create = l.create(new af.a(runBlock));
        kotlin.jvm.internal.e.e(create, "create(...)");
        u(create).subscribe(new androidx.camera.lifecycle.d(new oh.l() { // from class: com.example.baselibrary.utils.TaskUtils$startIOTask$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m54invoke(obj);
                return g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m54invoke(Object obj) {
                oh.l.this.invoke(obj);
            }
        }, 6), new androidx.camera.lifecycle.d(new oh.l() { // from class: com.example.baselibrary.utils.TaskUtils$startIOTask$3
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return g.f12633a;
            }

            public final void invoke(Throwable th2) {
                new StringBuilder("startAsyncTask error : ").append(b.z(th2));
            }
        }, 7));
    }

    public static String z(Object obj) {
        try {
            return new com.google.gson.e().e(obj);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
