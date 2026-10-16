package h2;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import androidx.startup.R$string;
import androidx.startup.StartupException;
import com.google.android.gms.internal.mlkit_vision_barcode.lc;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f14256d;
    public static final Object e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f14259c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f14258b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f14257a = new HashMap();

    public a(Context context) {
        this.f14259c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f14256d == null) {
            synchronized (e) {
                try {
                    if (f14256d == null) {
                        f14256d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f14256d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f14259c.getString(R$string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f14258b;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e10) {
                throw new StartupException(e10);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object obj;
        if (lc.b()) {
            try {
                Trace.beginSection(lc.d(cls.getSimpleName()));
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap hashMap = this.f14257a;
        if (hashMap.containsKey(cls)) {
            obj = hashMap.get(cls);
        } else {
            hashSet.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> dependencies = bVar.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class cls2 : dependencies) {
                        if (!hashMap.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                obj = bVar.create(this.f14259c);
                hashSet.remove(cls);
                hashMap.put(cls, obj);
            } catch (Throwable th3) {
                throw new StartupException(th3);
            }
        }
        Trace.endSection();
        return obj;
    }
}
