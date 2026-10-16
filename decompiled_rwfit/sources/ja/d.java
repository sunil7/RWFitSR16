package ja;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class d extends Property {

    /* renamed from: a, reason: collision with root package name */
    public static final d f15389a;

    static {
        d dVar = new d(Integer.class, "drawableAlphaCompat");
        new WeakHashMap();
        f15389a = dVar;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        return Integer.valueOf(((Drawable) obj).getAlpha());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ((Drawable) obj).setAlpha(((Integer) obj2).intValue());
    }
}
