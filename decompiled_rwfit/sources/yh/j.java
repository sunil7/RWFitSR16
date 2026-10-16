package yh;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList f20164d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public Object f20165a;

    /* renamed from: b, reason: collision with root package name */
    public o f20166b;

    /* renamed from: c, reason: collision with root package name */
    public j f20167c;

    public static j a(o oVar, Object obj) {
        ArrayList arrayList = f20164d;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                if (size <= 0) {
                    j jVar = new j();
                    jVar.f20165a = obj;
                    jVar.f20166b = oVar;
                    return jVar;
                }
                j jVar2 = (j) arrayList.remove(size - 1);
                jVar2.f20165a = obj;
                jVar2.f20166b = oVar;
                jVar2.f20167c = null;
                return jVar2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
