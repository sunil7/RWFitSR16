package eb;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public float f12579a;

    /* renamed from: b, reason: collision with root package name */
    public float f12580b;

    /* renamed from: c, reason: collision with root package name */
    public float f12581c;

    /* renamed from: d, reason: collision with root package name */
    public float f12582d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f12583f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f12584g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f12585h = new ArrayList();

    public w() {
        e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public final void a(float f2, float f10, float f11, float f12, float f13, float f14) {
        s sVar = new s(f2, f10, f11, f12);
        sVar.f12573f = f13;
        sVar.f12574g = f14;
        this.f12584g.add(sVar);
        q qVar = new q(sVar);
        float f15 = f13 + f14;
        boolean z5 = f14 < 0.0f;
        if (z5) {
            f13 = (f13 + 180.0f) % 360.0f;
        }
        float f16 = z5 ? (180.0f + f15) % 360.0f : f15;
        b(f13);
        this.f12585h.add(qVar);
        this.e = f16;
        double d5 = f15;
        this.f12581c = (((f11 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d5)))) + ((f2 + f11) * 0.5f);
        this.f12582d = (((f12 - f10) / 2.0f) * ((float) Math.sin(Math.toRadians(d5)))) + ((f10 + f12) * 0.5f);
    }

    public final void b(float f2) {
        float f10 = this.e;
        if (f10 == f2) {
            return;
        }
        float f11 = ((f2 - f10) + 360.0f) % 360.0f;
        if (f11 > 180.0f) {
            return;
        }
        float f12 = this.f12581c;
        float f13 = this.f12582d;
        s sVar = new s(f12, f13, f12, f13);
        sVar.f12573f = this.e;
        sVar.f12574g = f11;
        this.f12585h.add(new q(sVar));
        this.e = f2;
    }

    public final void c(Matrix matrix, Path path) {
        ArrayList arrayList = this.f12584g;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((u) arrayList.get(i3)).a(matrix, path);
        }
    }

    public final void d(float f2, float f10) {
        t tVar = new t();
        tVar.f12575b = f2;
        tVar.f12576c = f10;
        this.f12584g.add(tVar);
        r rVar = new r(tVar, this.f12581c, this.f12582d);
        float b3 = rVar.b() + 270.0f;
        float b10 = rVar.b() + 270.0f;
        b(b3);
        this.f12585h.add(rVar);
        this.e = b10;
        this.f12581c = f2;
        this.f12582d = f10;
    }

    public final void e(float f2, float f10, float f11, float f12) {
        this.f12579a = f2;
        this.f12580b = f10;
        this.f12581c = f2;
        this.f12582d = f10;
        this.e = f11;
        this.f12583f = (f11 + f12) % 360.0f;
        this.f12584g.clear();
        this.f12585h.clear();
    }
}
