package a4;

import d4.c0;
import d4.q;
import d4.r;
import d4.x;
import de.o;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class a implements r {

    /* renamed from: a, reason: collision with root package name */
    public Object f78a;

    public /* synthetic */ a(Object obj) {
        this.f78a = obj;
    }

    public abstract d9.a a();

    public abstract Object b(Object obj);

    @Override // d4.r
    public q c(x xVar) {
        return new d4.c((c0) this.f78a, 2);
    }

    public abstract com.dh.imagepick.work.a d(Object obj);

    public Object e(Object obj) {
        synchronized (((HashMap) this.f78a)) {
            try {
                if (((HashMap) this.f78a).containsKey(obj)) {
                    return ((HashMap) this.f78a).get(obj);
                }
                Object b3 = b(obj);
                ((HashMap) this.f78a).put(obj, b3);
                return b3;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract Object f();

    public void g(i iVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f78a;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(iVar);
        }
    }

    public void h(a5.a aVar) {
        synchronized (((com.dh.imagepick.work.c) this.f78a)) {
            ((com.dh.imagepick.work.c) this.f78a).f7199b.add(d(f()));
            Iterator it = ((com.dh.imagepick.work.c) this.f78a).f7199b.iterator();
            kotlin.jvm.internal.e.e(it, "iterator(...)");
            if (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.e.d(next, "null cannot be cast to non-null type com.dh.imagepick.work.Worker<Builder of com.dh.imagepick.functions.BaseFunctionBuilder, Result of com.dh.imagepick.functions.BaseFunctionBuilder>");
                ((com.dh.imagepick.work.a) next).a(null, new o(it, 21, this, aVar));
            }
        }
    }

    public com.dh.imagepick.work.c i() {
        com.dh.imagepick.work.c cVar = (com.dh.imagepick.work.c) this.f78a;
        cVar.f7199b.add(d(f()));
        return cVar;
    }

    public a(int i3) {
        switch (i3) {
            case 4:
                this.f78a = new HashMap();
                break;
            default:
                char[] cArr = t4.l.f18523a;
                this.f78a = new ArrayDeque(20);
                break;
        }
    }

    public a(com.dh.imagepick.work.c functionManager) {
        kotlin.jvm.internal.e.f(functionManager, "functionManager");
        this.f78a = functionManager;
    }
}
