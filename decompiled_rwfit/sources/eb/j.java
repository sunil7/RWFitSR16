package eb;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class j implements c {

    /* renamed from: a, reason: collision with root package name */
    public final float f12527a;

    public j(float f2) {
        this.f12527a = f2;
    }

    @Override // eb.c
    public final float a(RectF rectF) {
        return rectF.height() * this.f12527a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.f12527a == ((j) obj).f12527a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f12527a)});
    }
}
