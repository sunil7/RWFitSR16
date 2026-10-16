package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class e1 {

    /* renamed from: a, reason: collision with root package name */
    public static final j1 f2172a = new j1();

    /* renamed from: b, reason: collision with root package name */
    public static final k1 f2173b;

    static {
        k1 k1Var = null;
        try {
            k1Var = (k1) j2.v.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f2173b = k1Var;
    }

    public static void a(Fragment fragment, Fragment fragment2, boolean z5) {
        if (z5) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    public static void b(int i3, ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i3);
        }
    }
}
