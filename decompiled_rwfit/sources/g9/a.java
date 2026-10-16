package g9;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a implements j2.w {

    /* renamed from: b, reason: collision with root package name */
    public static Class f13898b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f13899c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f13900d;
    public static boolean e;

    /* renamed from: f, reason: collision with root package name */
    public static Method f13901f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f13902g;

    /* renamed from: a, reason: collision with root package name */
    public final View f13903a;

    public static void b() {
        if (f13899c) {
            return;
        }
        try {
            f13898b = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e10) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e10);
        }
        f13899c = true;
    }

    @Override // j2.w
    public void a(ViewGroup viewGroup, View view) {
    }

    @Override // j2.w
    public void setVisibility(int i3) {
        this.f13903a.setVisibility(i3);
    }
}
