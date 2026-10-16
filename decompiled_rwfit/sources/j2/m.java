package j2;

import android.view.View;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final float f15256a;

    /* renamed from: b, reason: collision with root package name */
    public final float f15257b;

    /* renamed from: c, reason: collision with root package name */
    public final float f15258c;

    /* renamed from: d, reason: collision with root package name */
    public final float f15259d;
    public final float e;

    /* renamed from: f, reason: collision with root package name */
    public final float f15260f;

    /* renamed from: g, reason: collision with root package name */
    public final float f15261g;

    /* renamed from: h, reason: collision with root package name */
    public final float f15262h;

    public m(View view) {
        this.f15256a = view.getTranslationX();
        this.f15257b = view.getTranslationY();
        WeakHashMap weakHashMap = z0.f15748a;
        this.f15258c = l1.n0.l(view);
        this.f15259d = view.getScaleX();
        this.e = view.getScaleY();
        this.f15260f = view.getRotationX();
        this.f15261g = view.getRotationY();
        this.f15262h = view.getRotation();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar.f15256a == this.f15256a && mVar.f15257b == this.f15257b && mVar.f15258c == this.f15258c && mVar.f15259d == this.f15259d && mVar.e == this.e && mVar.f15260f == this.f15260f && mVar.f15261g == this.f15261g && mVar.f15262h == this.f15262h;
    }

    public final int hashCode() {
        float f2 = this.f15256a;
        int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
        float f10 = this.f15257b;
        int floatToIntBits2 = (floatToIntBits + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
        float f11 = this.f15258c;
        int floatToIntBits3 = (floatToIntBits2 + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
        float f12 = this.f15259d;
        int floatToIntBits4 = (floatToIntBits3 + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0)) * 31;
        float f13 = this.e;
        int floatToIntBits5 = (floatToIntBits4 + (f13 != 0.0f ? Float.floatToIntBits(f13) : 0)) * 31;
        float f14 = this.f15260f;
        int floatToIntBits6 = (floatToIntBits5 + (f14 != 0.0f ? Float.floatToIntBits(f14) : 0)) * 31;
        float f15 = this.f15261g;
        int floatToIntBits7 = (floatToIntBits6 + (f15 != 0.0f ? Float.floatToIntBits(f15) : 0)) * 31;
        float f16 = this.f15262h;
        return floatToIntBits7 + (f16 != 0.0f ? Float.floatToIntBits(f16) : 0);
    }
}
