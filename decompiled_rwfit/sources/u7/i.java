package u7;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.data.BarEntry;
import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i extends b {

    /* renamed from: m, reason: collision with root package name */
    public RectF f18951m;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r35v0, types: [a4.a, u7.b, u7.h, u7.i] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.a] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.a] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    @Override // u7.b, u7.h
    public final void o(Canvas canvas) {
        ArrayList arrayList;
        float f2;
        v7.d dVar;
        int i3;
        Object obj;
        boolean z5;
        de.i iVar;
        float[] fArr;
        boolean z6;
        int i10;
        float[] fArr2;
        int i11;
        int i12;
        float f10;
        float f11;
        float f12;
        Object obj2;
        boolean z8;
        int i13;
        ArrayList arrayList2;
        float f13;
        float f14;
        v7.i iVar2;
        float f15;
        v7.d dVar2;
        l7.a aVar;
        v7.i iVar3;
        Canvas canvas2 = canvas;
        ?? r72 = this.f18935g;
        if (q(r72)) {
            ArrayList arrayList3 = r72.getBarData().f16833i;
            float c9 = v7.h.c(5.0f);
            boolean b3 = r72.b();
            int i14 = 0;
            ?? r73 = r72;
            while (i14 < r73.getBarData().c()) {
                o7.b bVar = (o7.b) arrayList3.get(i14);
                if (c.s(bVar)) {
                    YAxis$AxisDependency yAxis$AxisDependency = bVar.f16810d;
                    r73.t(yAxis$AxisDependency);
                    j(bVar);
                    Paint paint = this.e;
                    float f16 = 2.0f;
                    float a3 = v7.h.a(paint, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) / 2.0f;
                    p7.d j4 = bVar.j();
                    l7.a aVar2 = this.f18937i[i14];
                    this.f18948b.getClass();
                    v7.d dVar3 = bVar.f16817l;
                    v7.d dVar4 = (v7.d) v7.d.f19181d.b();
                    float f17 = dVar3.f19182b;
                    dVar4.f19182b = f17;
                    dVar4.f19183c = dVar3.f19183c;
                    dVar4.f19182b = v7.h.c(f17);
                    dVar4.f19183c = v7.h.c(dVar4.f19183c);
                    boolean o3 = bVar.o();
                    v7.i iVar4 = (v7.i) this.f78a;
                    boolean z10 = bVar.f16816k;
                    if (o3) {
                        arrayList = arrayList3;
                        f2 = c9;
                        dVar = dVar4;
                        de.i s7 = r73.s(yAxis$AxisDependency);
                        int i15 = 0;
                        int i16 = 0;
                        while (i15 < bVar.f16820o.size() * 1.0f) {
                            BarEntry barEntry = (BarEntry) bVar.g(i15);
                            int k10 = bVar.k(i15);
                            float[] o8 = barEntry.o();
                            if (o8 == null) {
                                int i17 = i16 + 1;
                                if (!iVar4.f(aVar2.f15834b[i17])) {
                                    break;
                                }
                                float[] fArr3 = aVar2.f15834b;
                                de.i iVar5 = s7;
                                if (iVar4.g(fArr3[i16]) && iVar4.c(fArr3[i17])) {
                                    i3 = i15;
                                    String format = ((DecimalFormat) ((n6.a) j4).f16381b).format(barEntry.d());
                                    float measureText = (int) paint.measureText(format);
                                    float f18 = b3 ? f2 : -(measureText + f2);
                                    float f19 = b3 ? -(measureText + f2) : f2;
                                    if (bVar.f16815j) {
                                        float f20 = fArr3[i16 + 2] + (barEntry.d() >= 0.0f ? f18 : f19);
                                        f11 = f19;
                                        float f21 = fArr3[i17] + a3;
                                        f12 = f18;
                                        Paint paint2 = this.e;
                                        paint2.setColor(k10);
                                        canvas2.drawText(format, f20, f21, paint2);
                                    } else {
                                        f11 = f19;
                                        f12 = f18;
                                    }
                                    if (barEntry.b() == null || !z10) {
                                        obj = r73;
                                        iVar = iVar5;
                                        z5 = b3;
                                        fArr = o8;
                                    } else {
                                        Drawable b10 = barEntry.b();
                                        float f22 = fArr3[i16 + 2];
                                        float f23 = barEntry.d() >= 0.0f ? f12 : f11;
                                        float f24 = fArr3[i17];
                                        obj = r73;
                                        iVar = iVar5;
                                        z5 = b3;
                                        fArr = o8;
                                        v7.h.d(canvas2, b10, (int) (f22 + f23 + dVar.f19182b), (int) (f24 + dVar.f19183c), b10.getIntrinsicWidth(), b10.getIntrinsicHeight());
                                    }
                                } else {
                                    s7 = iVar5;
                                }
                            } else {
                                i3 = i15;
                                obj = r73;
                                z5 = b3;
                                iVar = s7;
                                fArr = o8;
                                int length = fArr.length * 2;
                                float[] fArr4 = new float[length];
                                float f25 = -barEntry.l();
                                float f26 = 0.0f;
                                int i18 = 0;
                                int i19 = 0;
                                while (i18 < length) {
                                    float f27 = fArr[i19];
                                    if (f27 == 0.0f && (f26 == 0.0f || f25 == 0.0f)) {
                                        f10 = f25;
                                        f25 = f27;
                                    } else if (f27 >= 0.0f) {
                                        f26 += f27;
                                        f10 = f25;
                                        f25 = f26;
                                    } else {
                                        f10 = f25 - f27;
                                    }
                                    fArr4[i18] = f25 * 1.0f;
                                    i18 += 2;
                                    i19++;
                                    f25 = f10;
                                }
                                iVar.p(fArr4);
                                int i20 = 0;
                                while (i20 < length) {
                                    float f28 = fArr[i20 / 2];
                                    int i21 = length;
                                    z6 = z10;
                                    i10 = i14;
                                    String format2 = ((DecimalFormat) ((n6.a) j4).f16381b).format(f28);
                                    float measureText2 = (int) paint.measureText(format2);
                                    float f29 = z5 ? f2 : -(measureText2 + f2);
                                    float f30 = z5 ? -(measureText2 + f2) : f2;
                                    boolean z11 = (f28 == 0.0f && f25 == 0.0f && f26 > 0.0f) || f28 < 0.0f;
                                    float f31 = fArr4[i20];
                                    if (z11) {
                                        f29 = f30;
                                    }
                                    float f32 = f31 + f29;
                                    float[] fArr5 = aVar2.f15834b;
                                    float f33 = (fArr5[i16 + 1] + fArr5[i16 + 3]) / 2.0f;
                                    if (!iVar4.f(f33)) {
                                        break;
                                    }
                                    if (iVar4.g(f32) && iVar4.c(f33)) {
                                        if (bVar.f16815j) {
                                            fArr2 = fArr4;
                                            Paint paint3 = this.e;
                                            paint3.setColor(k10);
                                            canvas2.drawText(format2, f32, f33 + a3, paint3);
                                        } else {
                                            fArr2 = fArr4;
                                        }
                                        if (barEntry.b() != null && z6) {
                                            Drawable b11 = barEntry.b();
                                            i11 = i20;
                                            i12 = k10;
                                            v7.h.d(canvas2, b11, (int) (f32 + dVar.f19182b), (int) (f33 + dVar.f19183c), b11.getIntrinsicWidth(), b11.getIntrinsicHeight());
                                            i20 = i11 + 2;
                                            canvas2 = canvas;
                                            k10 = i12;
                                            length = i21;
                                            i14 = i10;
                                            z10 = z6;
                                            fArr4 = fArr2;
                                        }
                                    } else {
                                        fArr2 = fArr4;
                                    }
                                    i12 = k10;
                                    i11 = i20;
                                    i20 = i11 + 2;
                                    canvas2 = canvas;
                                    k10 = i12;
                                    length = i21;
                                    i14 = i10;
                                    z10 = z6;
                                    fArr4 = fArr2;
                                }
                            }
                            z6 = z10;
                            i10 = i14;
                            i16 = fArr == null ? i16 + 4 : (fArr.length * 4) + i16;
                            i15 = i3 + 1;
                            canvas2 = canvas;
                            s7 = iVar;
                            r73 = obj;
                            b3 = z5;
                            i14 = i10;
                            z10 = z6;
                        }
                    } else {
                        int i22 = 0;
                        while (true) {
                            float f34 = i22;
                            float f35 = f16;
                            float[] fArr6 = aVar2.f15834b;
                            int i23 = i22;
                            if (f34 >= fArr6.length * 1.0f) {
                                break;
                            }
                            int i24 = i23 + 1;
                            float f36 = fArr6[i24];
                            float f37 = (f36 + fArr6[i23 + 3]) / f35;
                            if (!iVar4.f(f36)) {
                                break;
                            }
                            if (iVar4.g(fArr6[i23]) && iVar4.c(fArr6[i24])) {
                                BarEntry barEntry2 = (BarEntry) bVar.g(i23 / 4);
                                float d5 = barEntry2.d();
                                arrayList2 = arrayList3;
                                f13 = c9;
                                String format3 = ((DecimalFormat) ((n6.a) j4).f16381b).format(d5);
                                float measureText3 = (int) paint.measureText(format3);
                                float f38 = b3 ? f13 : -(measureText3 + f13);
                                float f39 = b3 ? -(measureText3 + f13) : f13;
                                int i25 = i23 + 2;
                                float f40 = fArr6[i25];
                                float f41 = f39 - (f40 - fArr6[i23]);
                                l7.a aVar3 = aVar2;
                                if (bVar.f16815j) {
                                    float f42 = f40 + (d5 >= 0.0f ? f38 : f41);
                                    f14 = d5;
                                    iVar2 = iVar4;
                                    int k11 = bVar.k(i23 / 2);
                                    f15 = f41;
                                    Paint paint4 = this.e;
                                    paint4.setColor(k11);
                                    canvas2.drawText(format3, f42, f37 + a3, paint4);
                                } else {
                                    f14 = d5;
                                    iVar2 = iVar4;
                                    f15 = f41;
                                }
                                if (barEntry2.b() == null || !z10) {
                                    dVar2 = dVar4;
                                    aVar = aVar3;
                                    iVar3 = iVar2;
                                } else {
                                    Drawable b12 = barEntry2.b();
                                    float f43 = fArr6[i25];
                                    if (f14 < 0.0f) {
                                        f38 = f15;
                                    }
                                    float f44 = f43 + f38 + dVar4.f19182b;
                                    dVar2 = dVar4;
                                    aVar = aVar3;
                                    iVar3 = iVar2;
                                    v7.h.d(canvas2, b12, (int) f44, (int) (f37 + dVar4.f19183c), b12.getIntrinsicWidth(), b12.getIntrinsicHeight());
                                }
                            } else {
                                iVar3 = iVar4;
                                arrayList2 = arrayList3;
                                f13 = c9;
                                aVar = aVar2;
                                dVar2 = dVar4;
                            }
                            i22 = i23 + 4;
                            aVar2 = aVar;
                            dVar4 = dVar2;
                            iVar4 = iVar3;
                            f16 = f35;
                            arrayList3 = arrayList2;
                            c9 = f13;
                        }
                        arrayList = arrayList3;
                        f2 = c9;
                        dVar = dVar4;
                    }
                    obj2 = r73;
                    z8 = b3;
                    i13 = i14;
                    v7.d.c(dVar);
                } else {
                    obj2 = r73;
                    arrayList = arrayList3;
                    f2 = c9;
                    z8 = b3;
                    i13 = i14;
                }
                i14 = i13 + 1;
                canvas2 = canvas;
                r73 = obj2;
                arrayList3 = arrayList;
                c9 = f2;
                b3 = z8;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.a] */
    @Override // u7.b, u7.h
    public final void p() {
        o7.a barData = this.f18935g.getBarData();
        this.f18937i = new l7.b[barData.c()];
        for (int i3 = 0; i3 < this.f18937i.length; i3++) {
            o7.b bVar = (o7.b) barData.b(i3);
            l7.a[] aVarArr = this.f18937i;
            int size = bVar.f16820o.size() * 4;
            int i10 = bVar.o() ? bVar.f16802u : 1;
            barData.c();
            aVarArr[i3] = new l7.b(size * i10, bVar.o());
        }
    }

    @Override // u7.h
    public final boolean q(BarLineChartBase barLineChartBase) {
        return ((float) barLineChartBase.getData().d()) < ((float) barLineChartBase.getMaxVisibleCount()) * ((v7.i) this.f78a).f19209j;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.a] */
    @Override // u7.b
    public final void t(Canvas canvas, o7.b bVar, int i3) {
        Canvas canvas2;
        YAxis$AxisDependency yAxis$AxisDependency = bVar.f16810d;
        ?? r12 = this.f18935g;
        de.i s7 = r12.s(yAxis$AxisDependency);
        Paint paint = this.f18939k;
        paint.setColor(bVar.f16804w);
        paint.setStrokeWidth(v7.h.c(0.0f));
        this.f18948b.getClass();
        boolean a3 = r12.a();
        v7.i iVar = (v7.i) this.f78a;
        int i10 = 0;
        if (a3) {
            Paint paint2 = this.f18938j;
            paint2.setColor(bVar.f16803v);
            float f2 = r12.getBarData().f16801j / 2.0f;
            int min = Math.min((int) Math.ceil(bVar.f16820o.size() * 1.0f), bVar.f16820o.size());
            for (int i11 = 0; i11 < min; i11++) {
                float j4 = ((BarEntry) bVar.g(i11)).j();
                RectF rectF = this.f18951m;
                rectF.top = j4 - f2;
                rectF.bottom = j4 + f2;
                ((Matrix) s7.f12357b).mapRect(rectF);
                ((v7.i) s7.f12359d).f19201a.mapRect(rectF);
                ((Matrix) s7.f12358c).mapRect(rectF);
                if (iVar.f(rectF.bottom)) {
                    if (!iVar.c(rectF.top)) {
                        break;
                    }
                    RectF rectF2 = iVar.f19202b;
                    rectF.left = rectF2.left;
                    rectF.right = rectF2.right;
                    canvas.drawRect(rectF, paint2);
                }
            }
        }
        l7.a aVar = this.f18937i[i3];
        aVar.getClass();
        YAxis$AxisDependency yAxis$AxisDependency2 = bVar.f16810d;
        r12.t(yAxis$AxisDependency2);
        aVar.f15836d = false;
        aVar.e = r12.getBarData().f16801j;
        aVar.b(bVar);
        float[] fArr = aVar.f15834b;
        s7.p(fArr);
        boolean z5 = bVar.f16807a.size() == 1;
        r12.t(yAxis$AxisDependency2);
        Paint paint3 = this.f18949c;
        if (z5) {
            paint3.setColor(bVar.e());
        }
        while (i10 < fArr.length) {
            int i12 = i10 + 3;
            if (!iVar.f(fArr[i12])) {
                return;
            }
            int i13 = i10 + 1;
            if (iVar.c(fArr[i13])) {
                if (!z5) {
                    ArrayList arrayList = bVar.f16807a;
                    paint3.setColor(((Integer) arrayList.get((i10 / 4) % arrayList.size())).intValue());
                }
                canvas2 = canvas;
                canvas2.drawRect(fArr[i10], fArr[i13], fArr[i10 + 2], fArr[i12], paint3);
            } else {
                canvas2 = canvas;
            }
            i10 += 4;
            canvas = canvas2;
        }
    }

    @Override // u7.b
    public final void u(float f2, float f10, float f11, float f12, de.i iVar) {
        float f13 = f2 - f12;
        float f14 = f2 + f12;
        RectF rectF = this.f18936h;
        rectF.set(f10, f13, f11, f14);
        this.f18948b.getClass();
        iVar.getClass();
        rectF.left *= 1.0f;
        rectF.right *= 1.0f;
        ((Matrix) iVar.f12357b).mapRect(rectF);
        ((v7.i) iVar.f12359d).f19201a.mapRect(rectF);
        ((Matrix) iVar.f12358c).mapRect(rectF);
    }

    @Override // u7.b
    public final void v(q7.c cVar, RectF rectF) {
        float centerY = rectF.centerY();
        float f2 = rectF.right;
        cVar.f17804i = centerY;
        cVar.f17805j = f2;
    }
}
