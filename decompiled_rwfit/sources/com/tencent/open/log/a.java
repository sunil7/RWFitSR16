package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes2.dex */
public class a extends Tracer implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private b f12032a;

    /* renamed from: b, reason: collision with root package name */
    private FileWriter f12033b;

    /* renamed from: c, reason: collision with root package name */
    private FileWriter f12034c;

    /* renamed from: d, reason: collision with root package name */
    private File f12035d;
    private File e;

    /* renamed from: f, reason: collision with root package name */
    private char[] f12036f;

    /* renamed from: g, reason: collision with root package name */
    private volatile f f12037g;

    /* renamed from: h, reason: collision with root package name */
    private volatile f f12038h;

    /* renamed from: i, reason: collision with root package name */
    private volatile f f12039i;

    /* renamed from: j, reason: collision with root package name */
    private volatile f f12040j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f12041k;

    /* renamed from: l, reason: collision with root package name */
    private HandlerThread f12042l;

    /* renamed from: m, reason: collision with root package name */
    private Handler f12043m;

    public a(b bVar) {
        this(c.f12054b, true, g.f12073a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.f12042l && !this.f12041k) {
            this.f12041k = true;
            j();
            try {
                try {
                    this.f12040j.a(g(), this.f12036f);
                } catch (IOException e) {
                    SLog.e("FileTracer", "flushBuffer exception", e);
                }
                this.f12041k = false;
            } finally {
                this.f12040j.b();
            }
        }
    }

    private Writer[] g() {
        File[] a3 = c().a();
        if (a3 != null && a3.length >= 2) {
            File file = a3[0];
            if ((file != null && !file.equals(this.f12035d)) || (this.f12033b == null && file != null)) {
                this.f12035d = file;
                h();
                try {
                    this.f12033b = new FileWriter(this.f12035d, true);
                } catch (IOException unused) {
                    this.f12033b = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() old log file permission denied");
                }
            }
            File file2 = a3[1];
            if ((file2 != null && !file2.equals(this.e)) || (this.f12034c == null && file2 != null)) {
                this.e = file2;
                i();
                try {
                    this.f12034c = new FileWriter(this.e, true);
                } catch (IOException unused2) {
                    this.f12034c = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
                }
                a(file2);
            }
        }
        return new Writer[]{this.f12033b, this.f12034c};
    }

    private void h() {
        try {
            FileWriter fileWriter = this.f12033b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f12033b.close();
            }
        } catch (IOException e) {
            SLog.e(SLog.TAG, "-->closeFileWriter() exception:", e);
        }
    }

    private void i() {
        try {
            FileWriter fileWriter = this.f12034c;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f12034c.close();
            }
        } catch (IOException e) {
            SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e);
        }
    }

    private void j() {
        synchronized (this) {
            try {
                if (this.f12039i == this.f12037g) {
                    this.f12039i = this.f12038h;
                    this.f12040j = this.f12037g;
                } else {
                    this.f12039i = this.f12037g;
                    this.f12040j = this.f12038h;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a() {
        if (this.f12043m.hasMessages(1024)) {
            this.f12043m.removeMessages(1024);
        }
        this.f12043m.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        i();
        this.f12042l.quit();
    }

    public b c() {
        return this.f12032a;
    }

    @Override // com.tencent.open.log.Tracer
    public void doTrace(int i3, Thread thread, long j4, String str, String str2, Throwable th2) {
        a(e().a(i3, thread, j4, str, str2, th2));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i3, boolean z5, g gVar, b bVar) {
        super(i3, z5, gVar);
        this.f12041k = false;
        a(bVar);
        this.f12037g = new f();
        this.f12038h = new f();
        this.f12039i = this.f12037g;
        this.f12040j = this.f12038h;
        this.f12036f = new char[bVar.d()];
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.f12042l = handlerThread;
        handlerThread.start();
        if (!this.f12042l.isAlive() || this.f12042l.getLooper() == null) {
            return;
        }
        this.f12043m = new Handler(this.f12042l.getLooper(), this);
    }

    private void a(String str) {
        this.f12039i.a(str);
        if (this.f12039i.a() >= c().d()) {
            a();
        }
    }

    private boolean b(File file) {
        if (file == null) {
            return false;
        }
        String name = file.getName();
        SLog.d("FileTracer", "name=" + name);
        return !TextUtils.isEmpty(name) && name.length() == 47 && name.startsWith("com.tencent.mobileqq_connectSdk.") && name.endsWith(".log");
    }

    private void a(File file) {
        File[] listFiles;
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists() || !parentFile.isDirectory() || (listFiles = parentFile.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (b(file2)) {
                String name = file2.getName();
                if (b.a(System.currentTimeMillis() - (Tencent.USE_ONE_HOUR ? Const.L_WIFI_EXP : Const.MIN_TIME_AGPS_REQUEST)).compareTo(name.substring(32, 43)) > 0) {
                    SLog.d("FileTracer", "delete name=" + name + ", success=" + file2.delete());
                }
            }
        }
    }

    public void a(b bVar) {
        this.f12032a = bVar;
    }
}
