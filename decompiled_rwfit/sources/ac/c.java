package ac;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: d, reason: collision with root package name */
    public static Class f220d;

    /* renamed from: b, reason: collision with root package name */
    public final Object f221b;

    /* renamed from: c, reason: collision with root package name */
    public final Field f222c;

    public c() {
        Object obj;
        Field field = null;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f220d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Exception unused) {
            obj = null;
        }
        this.f221b = obj;
        try {
            field = AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused2) {
        }
        this.f222c = field;
    }

    @Override // ac.b
    public final void a(AccessibleObject accessibleObject) {
        Field field;
        Object obj = this.f221b;
        if (obj != null && (field = this.f222c) != null) {
            try {
                Long l3 = (Long) f220d.getMethod("objectFieldOffset", Field.class).invoke(obj, field);
                l3.getClass();
                f220d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(obj, accessibleObject, l3, Boolean.TRUE);
                return;
            } catch (Exception unused) {
            }
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }
}
