package eb;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final float f12482a;

    public a(float f2) {
        this.f12482a = f2;
    }

    @Override // eb.c
    public final float a(RectF rectF) {
        return this.f12482a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f12482a == ((a) obj).f12482a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f12482a)});
    }
}
