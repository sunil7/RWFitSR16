package pe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;
import n.m0;

/* loaded from: classes2.dex */
public final class q {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f17582c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final Object f17583d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public Object f17584a;

    /* renamed from: b, reason: collision with root package name */
    public Object f17585b;

    public static void a(s sVar) {
        q qVar = d.f17561a;
        LinkedList linkedList = (LinkedList) ((HashMap) qVar.f17585b).get("event.service.connect.changed");
        if (linkedList == null) {
            synchronized ("event.service.connect.changed".intern()) {
                try {
                    linkedList = (LinkedList) ((HashMap) qVar.f17585b).get("event.service.connect.changed");
                    if (linkedList == null) {
                        HashMap hashMap = (HashMap) qVar.f17585b;
                        linkedList = new LinkedList();
                        hashMap.put("event.service.connect.changed", linkedList);
                    }
                } finally {
                }
            }
        }
        synchronized ("event.service.connect.changed".intern()) {
            linkedList.add(sVar);
        }
    }

    public void b(m0 m0Var) {
        ((ThreadPoolExecutor) this.f17584a).execute(new ia.j(16, this, m0Var));
    }

    public s c() {
        if (((s) this.f17585b) == null) {
            synchronized (f17583d) {
                try {
                    if (((s) this.f17585b) == null) {
                        s sVar = new s();
                        this.f17585b = sVar;
                        a(sVar);
                    }
                } finally {
                }
            }
        }
        return (s) this.f17585b;
    }

    public m0 d() {
        if (((m0) this.f17584a) == null) {
            synchronized (f17582c) {
                try {
                    if (((m0) this.f17584a) == null) {
                        this.f17584a = new m0(9);
                    }
                } finally {
                }
            }
        }
        return (m0) this.f17584a;
    }
}
