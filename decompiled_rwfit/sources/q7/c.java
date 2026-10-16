package q7;

import com.github.mikephil.charting.components.YAxis$AxisDependency;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public float f17797a;

    /* renamed from: b, reason: collision with root package name */
    public float f17798b;

    /* renamed from: c, reason: collision with root package name */
    public final float f17799c;

    /* renamed from: d, reason: collision with root package name */
    public final float f17800d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f17801f;

    /* renamed from: g, reason: collision with root package name */
    public int f17802g;

    /* renamed from: h, reason: collision with root package name */
    public final YAxis$AxisDependency f17803h;

    /* renamed from: i, reason: collision with root package name */
    public float f17804i;

    /* renamed from: j, reason: collision with root package name */
    public float f17805j;

    public c(float f2, float f10, float f11, float f12, int i3, YAxis$AxisDependency yAxis$AxisDependency) {
        this.e = -1;
        this.f17802g = -1;
        this.f17797a = f2;
        this.f17798b = f10;
        this.f17799c = f11;
        this.f17800d = f12;
        this.f17801f = i3;
        this.f17803h = yAxis$AxisDependency;
    }

    public final boolean a(c cVar) {
        return cVar != null && this.f17801f == cVar.f17801f && this.f17797a == cVar.f17797a && this.f17802g == cVar.f17802g && this.e == cVar.e;
    }

    public final String toString() {
        return "Highlight, x: " + this.f17797a + ", y: " + this.f17798b + ", dataSetIndex: " + this.f17801f + ", stackIndex (only stacked barentry): " + this.f17802g;
    }

    public c(float f2, float f10, float f11, float f12, int i3, YAxis$AxisDependency yAxis$AxisDependency, int i10) {
        this(f2, f10, f11, f12, i3, yAxis$AxisDependency);
        this.f17802g = -1;
    }
}
