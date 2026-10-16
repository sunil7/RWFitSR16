package pe;

import android.text.TextUtils;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final c f17544a;

    /* renamed from: b, reason: collision with root package name */
    public final c f17545b;

    /* renamed from: c, reason: collision with root package name */
    public int f17546c;

    /* renamed from: d, reason: collision with root package name */
    public final String f17547d;
    public String e;

    /* renamed from: f, reason: collision with root package name */
    public String f17548f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f17549g;

    /* renamed from: h, reason: collision with root package name */
    public p f17550h;

    /* renamed from: k, reason: collision with root package name */
    public final Object f17553k;

    /* renamed from: i, reason: collision with root package name */
    public volatile int f17551i = 0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f17552j = false;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f17554l = false;

    public b(String str) {
        this.f17547d = str;
        Object obj = new Object();
        this.f17553k = obj;
        c cVar = new c(this, obj);
        this.f17544a = cVar;
        this.f17545b = cVar;
    }

    public final int a() {
        int i3 = this.f17546c;
        if (i3 != 0) {
            return i3;
        }
        if (TextUtils.isEmpty(this.e)) {
            return 0;
        }
        String str = this.f17547d;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String str2 = this.e;
        boolean z5 = this.f17549g;
        int i10 = ye.e.f20123a;
        com.liulishuo.filedownloader.download.c.f11405a.g().getClass();
        int a3 = com.google.android.gms.internal.mlkit_common.o.a(str, str2, z5);
        this.f17546c = a3;
        return a3;
    }

    public final String b() {
        String str = this.e;
        boolean z5 = this.f17549g;
        String str2 = this.f17548f;
        int i3 = ye.e.f20123a;
        if (str == null) {
            return null;
        }
        if (!z5) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return ye.e.c(str, str2);
    }

    public final void c(String str, boolean z5) {
        this.e = str;
        this.f17549g = z5;
        if (z5) {
            this.f17548f = null;
        } else {
            this.f17548f = new File(str).getName();
        }
    }

    public final void d() {
        if (this.f17552j) {
            throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
        }
        e();
    }

    public final int e() {
        if (this.f17544a.f17558d != 0) {
            ArrayList arrayList = p.f17581a.c().f17586a;
            if ((arrayList.isEmpty() || !arrayList.contains(this)) && this.f17544a.f17558d <= 0) {
                throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.f17544a.toString());
            }
            int a3 = a();
            int i3 = ye.e.f20123a;
            Locale locale = Locale.ENGLISH;
            throw new IllegalStateException(l0.k(a3, "This task is running ", ", if you want to start the same task, please create a new one by FileDownloader.create"));
        }
        if (this.f17551i == 0) {
            p pVar = this.f17550h;
            this.f17551i = pVar != null ? pVar.hashCode() : hashCode();
        }
        c cVar = this.f17544a;
        synchronized (cVar.f17556b) {
            try {
                if (cVar.f17558d != 0) {
                    o6.b(cVar, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(cVar.a()), Byte.valueOf(cVar.f17558d));
                } else {
                    cVar.f17558d = (byte) 10;
                    b bVar = cVar.f17557c;
                    bVar.getClass();
                    try {
                        cVar.c();
                        n6.a aVar = n.f17578a;
                        synchronized (aVar) {
                            ((ThreadPoolExecutor) ((mc.g) aVar.f16381b).f16022b).execute(new o(cVar, 0));
                        }
                    } catch (Throwable th2) {
                        e.f17562a.a(bVar);
                        e.f17562a.i(bVar, cVar.d(th2));
                    }
                }
            } finally {
            }
        }
        return a();
    }

    public final String toString() {
        int a3 = a();
        String obj = super.toString();
        int i3 = ye.e.f20123a;
        Locale locale = Locale.ENGLISH;
        return a3 + "@" + obj;
    }
}
