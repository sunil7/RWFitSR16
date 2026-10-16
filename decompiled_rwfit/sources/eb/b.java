package eb;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f12483a;

    /* renamed from: b, reason: collision with root package name */
    public final float f12484b;

    public b(float f2, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f12483a;
            f2 += ((b) cVar).f12484b;
        }
        this.f12483a = cVar;
        this.f12484b = f2;
    }

    @Override // eb.c
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f12483a.a(rectF) + this.f12484b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f12483a.equals(bVar.f12483a) && this.f12484b == bVar.f12484b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12483a, Float.valueOf(this.f12484b)});
    }
}
