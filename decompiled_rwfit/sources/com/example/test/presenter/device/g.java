package com.example.test.presenter.device;

import com.example.test.XXApplication;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class g extends d {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7429b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7430c;

    public g(p5.a aVar) {
        super(aVar);
        this.f7429b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.BaseFilePresenter$downloadListener$2
            {
                super(0);
            }

            @Override // oh.a
            public final f invoke() {
                return new f(g.this);
            }
        });
        this.f7430c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.BaseFilePresenter$dialTransferCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final e invoke() {
                return new e(g.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public void i() {
        u();
    }

    public final e l() {
        return (e) this.f7430c.getValue();
    }

    public final void m(int i3, String dialPath, String dialThumbPath) {
        kotlin.jvm.internal.e.f(dialPath, "dialPath");
        kotlin.jvm.internal.e.f(dialThumbPath, "dialThumbPath");
        e fileTransferCallback = l();
        kotlin.jvm.internal.e.f(fileTransferCallback, "fileTransferCallback");
        r5.c h4 = r5.c.h();
        CopyOnWriteArrayList copyOnWriteArrayList = h4.f18079f;
        copyOnWriteArrayList.size();
        if (!h4.k(fileTransferCallback)) {
            copyOnWriteArrayList.add(new WeakReference(fileTransferCallback));
        }
        if (!r5.b.k().f18054c) {
            r5.c.h().n(true, new byte[]{14, 2, Byte.MIN_VALUE});
        } else {
            if (dialPath.length() == 0) {
                return;
            }
            r5.c.h().u(i3, dialPath, dialThumbPath);
        }
    }

    public final void n(String dialPath) {
        kotlin.jvm.internal.e.f(dialPath, "dialPath");
        e fileTransferCallback = l();
        kotlin.jvm.internal.e.f(fileTransferCallback, "fileTransferCallback");
        r5.c h4 = r5.c.h();
        CopyOnWriteArrayList copyOnWriteArrayList = h4.f18079f;
        copyOnWriteArrayList.size();
        if (!h4.k(fileTransferCallback)) {
            copyOnWriteArrayList.add(new WeakReference(fileTransferCallback));
        }
        if (!r5.b.k().f18054c) {
            r5.c.h().n(true, new byte[]{14, 2, -9});
        } else {
            if (dialPath.length() == 0) {
                return;
            }
            r5.c.h().u(7, dialPath, "");
        }
    }

    public abstract void o();

    public abstract void p(float f2);

    public abstract void q(String str);

    public abstract void r(int i3);

    public abstract void s(float f2);

    public abstract void t();

    public final void u() {
        e fileTransferCallback = l();
        kotlin.jvm.internal.e.f(fileTransferCallback, "fileTransferCallback");
        r5.c h4 = r5.c.h();
        if (h4.k(fileTransferCallback)) {
            CopyOnWriteArrayList copyOnWriteArrayList = h4.f18079f;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null && weakReference.get() == fileTransferCallback) {
                    weakReference.clear();
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
        }
    }

    public final void v(String str) {
        pe.b bVar = new pe.b(str);
        XXApplication xXApplication = XXApplication.f7400h;
        bVar.c(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getCacheDir().getAbsolutePath(), true);
        bVar.f17550h = (f) this.f7429b.getValue();
        bVar.d();
    }
}
