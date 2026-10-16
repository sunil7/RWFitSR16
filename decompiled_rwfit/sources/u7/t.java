package u7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class t extends a {

    /* renamed from: h, reason: collision with root package name */
    public final n7.h f18992h;

    /* renamed from: i, reason: collision with root package name */
    public final Path f18993i;

    /* renamed from: j, reason: collision with root package name */
    public float[] f18994j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f18995k;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f18996l;

    public t(v7.i iVar, n7.h hVar, de.i iVar2) {
        super(iVar, iVar2, hVar);
        this.f18993i = new Path();
        this.f18994j = new float[2];
        this.f18995k = new RectF();
        this.f18996l = new float[2];
        new RectF();
        new Path();
        this.f18992h = hVar;
        this.e.setColor(-16777216);
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setTextSize(v7.h.c(10.0f));
    }

    @Override // u7.a
    public void j(float f2, float f10) {
        v7.i iVar = (v7.i) this.f78a;
        if (iVar.f19202b.width() > 10.0f && !iVar.a()) {
            RectF rectF = iVar.f19202b;
            float f11 = rectF.left;
            float f12 = rectF.top;
            de.i iVar2 = this.f18931c;
            v7.c j4 = iVar2.j(f11, f12);
            RectF rectF2 = iVar.f19202b;
            v7.c j10 = iVar2.j(rectF2.right, rectF2.top);
            float f13 = (float) j4.f19179b;
            float f14 = (float) j10.f19179b;
            v7.c.c(j4);
            v7.c.c(j10);
            f2 = f13;
            f10 = f14;
        }
        k(f2, f10);
    }

    @Override // u7.a
    public final void k(float f2, float f10) {
        super.k(f2, f10);
        l();
    }

    public void l() {
        n7.h hVar = this.f18992h;
        String d5 = hVar.d();
        Paint paint = this.e;
        paint.setTypeface(null);
        paint.setTextSize(hVar.f16409d);
        v7.a b3 = v7.h.b(paint, d5);
        float f2 = b3.f19176b;
        float a3 = v7.h.a(paint, "Q");
        v7.a f10 = v7.h.f(f2, a3);
        Math.round(f2);
        Math.round(a3);
        hVar.F = Math.round(f10.f19176b);
        hVar.G = Math.round(f10.f19177c);
        v7.a.f19175d.c(f10);
        v7.a.f19175d.c(b3);
    }

    public void m(Canvas canvas, float f2, float f10, Path path) {
        v7.i iVar = (v7.i) this.f78a;
        path.moveTo(f2, iVar.f19202b.bottom);
        path.lineTo(f2, iVar.f19202b.top);
        canvas.drawPath(path, this.f18932d);
        path.reset();
    }

    public final void n(Canvas canvas, String str, float f2, float f10, v7.d dVar) {
        Paint paint = this.e;
        Paint.FontMetrics fontMetrics = v7.h.f19200k;
        float fontMetrics2 = paint.getFontMetrics(fontMetrics);
        paint.getTextBounds(str, 0, str.length(), v7.h.f19199j);
        float f11 = 0.0f - r4.left;
        float f12 = (-fontMetrics.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (dVar.f19182b != 0.0f || dVar.f19183c != 0.0f) {
            f11 -= r4.width() * dVar.f19182b;
            f12 -= fontMetrics2 * dVar.f19183c;
        }
        canvas.drawText(str, f11 + f2, f12 + f10, paint);
        paint.setTextAlign(textAlign);
    }

    public void o(Canvas canvas, float f2, v7.d dVar) {
        n7.h hVar = this.f18992h;
        hVar.getClass();
        int i3 = hVar.f16392l * 2;
        float[] fArr = new float[i3];
        for (int i10 = 0; i10 < i3; i10 += 2) {
            fArr[i10] = hVar.f16391k[i10 / 2];
        }
        this.f18931c.p(fArr);
        for (int i11 = 0; i11 < i3; i11 += 2) {
            float f10 = fArr[i11];
            v7.i iVar = (v7.i) this.f78a;
            if (iVar.g(f10)) {
                int i12 = i11 / 2;
                String formattedValue = hVar.e().getFormattedValue(hVar.f16391k[i12], hVar);
                if (hVar.H) {
                    int i13 = hVar.f16392l;
                    int i14 = i13 - 1;
                    Paint paint = this.e;
                    if (i12 == i14 && i13 > 1) {
                        DisplayMetrics displayMetrics = v7.h.f19191a;
                        float measureText = (int) paint.measureText(formattedValue);
                        float f11 = iVar.f19203c;
                        if (measureText > (f11 - iVar.f19202b.right) * 2.0f && f10 + measureText > f11) {
                            f10 -= measureText / 2.0f;
                        }
                    } else if (i11 == 0) {
                        DisplayMetrics displayMetrics2 = v7.h.f19191a;
                        f10 += ((int) paint.measureText(formattedValue)) / 2.0f;
                    }
                }
                n(canvas, formattedValue, f10, f2, dVar);
            }
        }
    }

    public RectF p() {
        RectF rectF = this.f18995k;
        rectF.set(((v7.i) this.f78a).f19202b);
        rectF.inset(-this.f18930b.f16388h, 0.0f);
        return rectF;
    }

    public void q(Canvas canvas) {
        n7.h hVar = this.f18992h;
        if (hVar.f16406a && hVar.f16399t) {
            float f2 = hVar.f16408c;
            Paint paint = this.e;
            paint.setTypeface(null);
            paint.setTextSize(hVar.f16409d);
            paint.setColor(hVar.e);
            v7.d b3 = v7.d.b(0.0f, 0.0f);
            XAxis$XAxisPosition xAxis$XAxisPosition = hVar.I;
            XAxis$XAxisPosition xAxis$XAxisPosition2 = XAxis$XAxisPosition.TOP;
            v7.i iVar = (v7.i) this.f78a;
            if (xAxis$XAxisPosition == xAxis$XAxisPosition2) {
                b3.f19182b = 0.5f;
                b3.f19183c = 1.0f;
                o(canvas, iVar.f19202b.top - f2, b3);
            } else if (xAxis$XAxisPosition == XAxis$XAxisPosition.TOP_INSIDE) {
                b3.f19182b = 0.5f;
                b3.f19183c = 1.0f;
                o(canvas, iVar.f19202b.top + f2 + hVar.G, b3);
            } else if (xAxis$XAxisPosition == XAxis$XAxisPosition.BOTTOM) {
                b3.f19182b = 0.5f;
                b3.f19183c = 0.0f;
                o(canvas, iVar.f19202b.bottom + f2, b3);
            } else if (xAxis$XAxisPosition == XAxis$XAxisPosition.BOTTOM_INSIDE) {
                b3.f19182b = 0.5f;
                b3.f19183c = 0.0f;
                o(canvas, (iVar.f19202b.bottom - f2) - hVar.G, b3);
            } else {
                b3.f19182b = 0.5f;
                b3.f19183c = 1.0f;
                o(canvas, iVar.f19202b.top - f2, b3);
                b3.f19182b = 0.5f;
                b3.f19183c = 0.0f;
                o(canvas, iVar.f19202b.bottom + f2, b3);
            }
            v7.d.c(b3);
        }
    }

    public void r(Canvas canvas) {
        Canvas canvas2;
        n7.h hVar = this.f18992h;
        if (hVar.f16398s && hVar.f16406a) {
            Paint paint = this.f18933f;
            paint.setColor(hVar.f16389i);
            paint.setStrokeWidth(hVar.f16390j);
            paint.setPathEffect(null);
            XAxis$XAxisPosition xAxis$XAxisPosition = hVar.I;
            XAxis$XAxisPosition xAxis$XAxisPosition2 = XAxis$XAxisPosition.TOP;
            v7.i iVar = (v7.i) this.f78a;
            if (xAxis$XAxisPosition == xAxis$XAxisPosition2 || xAxis$XAxisPosition == XAxis$XAxisPosition.TOP_INSIDE || xAxis$XAxisPosition == XAxis$XAxisPosition.BOTH_SIDED) {
                RectF rectF = iVar.f19202b;
                float f2 = rectF.left;
                float f10 = rectF.top;
                canvas2 = canvas;
                canvas2.drawLine(f2, f10, rectF.right, f10, paint);
            } else {
                canvas2 = canvas;
            }
            XAxis$XAxisPosition xAxis$XAxisPosition3 = hVar.I;
            if (xAxis$XAxisPosition3 == XAxis$XAxisPosition.BOTTOM || xAxis$XAxisPosition3 == XAxis$XAxisPosition.BOTTOM_INSIDE || xAxis$XAxisPosition3 == XAxis$XAxisPosition.BOTH_SIDED) {
                RectF rectF2 = iVar.f19202b;
                float f11 = rectF2.left;
                float f12 = rectF2.bottom;
                canvas2.drawLine(f11, f12, rectF2.right, f12, paint);
            }
        }
    }

    public final void s(Canvas canvas) {
        n7.h hVar = this.f18992h;
        if (hVar.r && hVar.f16406a) {
            int save = canvas.save();
            canvas.clipRect(p());
            if (this.f18994j.length != this.f18930b.f16392l * 2) {
                this.f18994j = new float[hVar.f16392l * 2];
            }
            float[] fArr = this.f18994j;
            for (int i3 = 0; i3 < fArr.length; i3 += 2) {
                float[] fArr2 = hVar.f16391k;
                int i10 = i3 / 2;
                fArr[i3] = fArr2[i10];
                fArr[i3 + 1] = fArr2[i10];
            }
            this.f18931c.p(fArr);
            Paint paint = this.f18932d;
            paint.setColor(hVar.f16387g);
            paint.setStrokeWidth(hVar.f16388h);
            paint.setPathEffect(hVar.f16400u);
            Path path = this.f18993i;
            path.reset();
            for (int i11 = 0; i11 < fArr.length; i11 += 2) {
                m(canvas, fArr[i11], fArr[i11 + 1], path);
            }
            canvas.restoreToCount(save);
        }
    }

    public void t() {
        ArrayList arrayList = this.f18992h.f16401v;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        float[] fArr = this.f18996l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        if (arrayList.size() > 0) {
            throw android.support.v4.media.session.e.c(0, arrayList);
        }
    }
}
