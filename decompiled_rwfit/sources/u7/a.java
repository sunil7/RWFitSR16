package u7;

import android.graphics.Paint;
import android.graphics.RectF;

/* loaded from: classes.dex */
public abstract class a extends a4.a {

    /* renamed from: b, reason: collision with root package name */
    public final n7.a f18930b;

    /* renamed from: c, reason: collision with root package name */
    public final de.i f18931c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f18932d;
    public final Paint e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f18933f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f18934g;

    public a(v7.i iVar, de.i iVar2, n7.a aVar) {
        super(iVar);
        this.f18931c = iVar2;
        this.f18930b = aVar;
        if (iVar != null) {
            this.e = new Paint(1);
            Paint paint = new Paint();
            this.f18932d = paint;
            paint.setColor(-7829368);
            paint.setStrokeWidth(1.0f);
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            paint.setAlpha(90);
            Paint paint2 = new Paint();
            this.f18933f = paint2;
            paint2.setColor(-16777216);
            paint2.setStrokeWidth(1.0f);
            paint2.setStyle(style);
            Paint paint3 = new Paint(1);
            this.f18934g = paint3;
            paint3.setStyle(style);
        }
    }

    public void j(float f2, float f10) {
        v7.i iVar = (v7.i) this.f78a;
        if (iVar != null && iVar.f19202b.width() > 10.0f && !iVar.b()) {
            RectF rectF = iVar.f19202b;
            float f11 = rectF.left;
            float f12 = rectF.top;
            de.i iVar2 = this.f18931c;
            v7.c j4 = iVar2.j(f11, f12);
            RectF rectF2 = iVar.f19202b;
            v7.c j10 = iVar2.j(rectF2.left, rectF2.bottom);
            float f13 = (float) j10.f19180c;
            float f14 = (float) j4.f19180c;
            v7.c.c(j4);
            v7.c.c(j10);
            f2 = f13;
            f10 = f14;
        }
        k(f2, f10);
    }

    public void k(float f2, float f10) {
        int i3;
        float f11 = f2;
        n7.a aVar = this.f18930b;
        int i10 = aVar.f16394n;
        double abs = Math.abs(f10 - f11);
        if (i10 == 0 || abs <= 0.0d || Double.isInfinite(abs)) {
            aVar.f16391k = new float[0];
            aVar.f16392l = 0;
            return;
        }
        double h4 = v7.h.h(abs / i10);
        if (aVar.f16396p) {
            double d5 = aVar.f16395o;
            if (h4 < d5) {
                h4 = d5;
            }
        }
        double h10 = v7.h.h(Math.pow(10.0d, (int) Math.log10(h4)));
        if (((int) (h4 / h10)) > 5) {
            double d8 = h10 * 10.0d;
            if (Math.floor(d8) != 0.0d) {
                h4 = Math.floor(d8);
            }
        }
        if (aVar.f16397q) {
            h4 = ((float) abs) / (i10 - 1);
            aVar.f16392l = i10;
            if (aVar.f16391k.length < i10) {
                aVar.f16391k = new float[i10];
            }
            for (int i11 = 0; i11 < i10; i11++) {
                aVar.f16391k[i11] = f11;
                f11 = (float) (f11 + h4);
            }
        } else {
            double ceil = h4 == 0.0d ? 0.0d : Math.ceil(f11 / h4) * h4;
            double g10 = h4 == 0.0d ? 0.0d : v7.h.g(Math.floor(f10 / h4) * h4);
            if (h4 == 0.0d || g10 == ceil) {
                i3 = g10 == ceil ? 1 : 0;
            } else {
                i3 = 0;
                for (double d10 = ceil; d10 <= g10; d10 += h4) {
                    i3++;
                }
            }
            aVar.f16392l = i3;
            if (aVar.f16391k.length < i3) {
                aVar.f16391k = new float[i3];
            }
            for (int i12 = 0; i12 < i3; i12++) {
                if (ceil == 0.0d) {
                    ceil = 0.0d;
                }
                aVar.f16391k[i12] = (float) ceil;
                ceil += h4;
            }
        }
        if (h4 < 1.0d) {
            aVar.f16393m = (int) Math.ceil(-Math.log10(h4));
        } else {
            aVar.f16393m = 0;
        }
    }
}
