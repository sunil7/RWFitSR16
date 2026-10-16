package u0;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public int f18666a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f18667b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f18668c = null;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f18669d;

    public static float f(Number number) {
        return number instanceof Float ? ((Float) number).floatValue() : Float.parseFloat(number.toString());
    }

    public abstract void a(HashMap hashMap);

    public abstract c b();

    public abstract void c(HashSet hashSet);

    public abstract void d(Context context, AttributeSet attributeSet);

    public void e(HashMap hashMap) {
    }
}
