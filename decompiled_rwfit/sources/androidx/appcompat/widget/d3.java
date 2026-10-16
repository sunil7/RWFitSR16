package androidx.appcompat.widget;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class d3 {

    /* renamed from: a, reason: collision with root package name */
    public Method f887a;

    /* renamed from: b, reason: collision with root package name */
    public Method f888b;

    /* renamed from: c, reason: collision with root package name */
    public Method f889c;

    public d3(Method method, Method method2, Method method3) {
        this.f887a = method;
        this.f888b = method2;
        this.f889c = method3;
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}
