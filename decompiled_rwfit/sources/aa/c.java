package aa;

import android.content.Context;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f145b;

    /* renamed from: a, reason: collision with root package name */
    public b f146a;

    static {
        c cVar = new c();
        cVar.f146a = null;
        f145b = cVar;
    }

    public static b a(Context context) {
        b bVar;
        c cVar = f145b;
        synchronized (cVar) {
            try {
                if (cVar.f146a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    cVar.f146a = new b(context);
                }
                bVar = cVar.f146a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }
}
