package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final j0 f530a = new j0(new k0());

    /* renamed from: b, reason: collision with root package name */
    public static final int f531b = -100;

    /* renamed from: c, reason: collision with root package name */
    public static h1.i f532c = null;

    /* renamed from: d, reason: collision with root package name */
    public static h1.i f533d = null;
    public static Boolean e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f534f = false;

    /* renamed from: g, reason: collision with root package name */
    public static final m0.c f535g = new m0.c(0);

    /* renamed from: h, reason: collision with root package name */
    public static final Object f536h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static final Object f537i = new Object();

    public static boolean c(Context context) {
        if (e == null) {
            try {
                int i3 = AppLocalesMetadataHolderService.f403a;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) AppLocalesMetadataHolderService.class), h0.a() | 128).metaData;
                if (bundle != null) {
                    e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                e = Boolean.FALSE;
            }
        }
        return e.booleanValue();
    }

    public static void g(c0 c0Var) {
        synchronized (f536h) {
            try {
                Iterator it = f535g.iterator();
                while (true) {
                    m0.g gVar = (m0.g) it;
                    if (gVar.hasNext()) {
                        p pVar = (p) ((WeakReference) gVar.next()).get();
                        if (pVar == c0Var || pVar == null) {
                            gVar.remove();
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void e();

    public abstract void f();

    public abstract boolean h(int i3);

    public abstract void i(int i3);

    public abstract void j(View view);

    public abstract void l(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void m(CharSequence charSequence);
}
