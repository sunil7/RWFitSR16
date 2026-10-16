package ac;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f219a;

    static {
        f219a = d.f11179a < 9 ? new a() : new c();
    }

    public abstract void a(AccessibleObject accessibleObject);
}
