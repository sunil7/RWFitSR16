package u7;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: g, reason: collision with root package name */
    public final BarLineChartBase f18935g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f18936h;

    /* renamed from: i, reason: collision with root package name */
    public l7.a[] f18937i;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f18938j;

    /* renamed from: k, reason: collision with root package name */
    public final Paint f18939k;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f18940l;

    /* JADX WARN: Multi-variable type inference failed */
    public b(r7.a aVar, k7.a aVar2, v7.i iVar) {
        super(aVar2, iVar);
        this.f18936h = new RectF();
        this.f18940l = new RectF();
        this.f18935g = (BarLineChartBase) aVar;
        Paint paint = new Paint(1);
        this.f18950d = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f18950d.setColor(Color.rgb(0, 0, 0));
        this.f18950d.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.f18938j = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.f18939k = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.a] */
    @Override // u7.h
    public final void k(Canvas canvas) {
        o7.a barData = this.f18935g.getBarData();
        for (int i3 = 0; i3 < barData.c(); i3++) {
            o7.b bVar = (o7.b) barData.b(i3);
            if (bVar.f16819n) {
                t(canvas, bVar, i3);
            }
        }
    }

    @Override // u7.h
    public final void l(Canvas canvas) {
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.a] */
    @Override // u7.h
    public final void m(Canvas canvas, q7.c[] cVarArr) {
        float d5;
        float f2;
        ?? r72 = this.f18935g;
        o7.a barData = r72.getBarData();
        for (q7.c cVar : cVarArr) {
            o7.b bVar = (o7.b) barData.b(cVar.f17801f);
            if (bVar != null && bVar.e) {
                BarEntry barEntry = (BarEntry) bVar.h(cVar.f17797a, cVar.f17798b, DataSet$Rounding.CLOSEST);
                if (r(barEntry, bVar)) {
                    de.i s7 = r72.s(bVar.f16810d);
                    this.f18950d.setColor(bVar.f16824t);
                    this.f18950d.setAlpha(bVar.f16805x);
                    int i3 = cVar.f17802g;
                    if (i3 < 0 || !barEntry.p()) {
                        d5 = barEntry.d();
                        f2 = 0.0f;
                    } else {
                        if (!r72.c()) {
                            q7.g gVar = barEntry.n()[i3];
                            throw null;
                        }
                        d5 = barEntry.m();
                        f2 = -barEntry.l();
                    }
                    u(barEntry.j(), d5, f2, barData.f16801j / 2.0f, s7);
                    RectF rectF = this.f18936h;
                    v(cVar, rectF);
                    canvas.drawRect(rectF, this.f18950d);
                } else {
                    continue;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [u7.b, u7.h] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.a] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.a] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // u7.h
    public void o(Canvas canvas) {
        ArrayList arrayList;
        float f2;
        boolean z5;
        v7.d dVar;
        int i3;
        int i10;
        Object obj;
        float[] fArr;
        int i11;
        float[] fArr2;
        int i12;
        BarEntry barEntry;
        int i13;
        float f10;
        float f11;
        float[] fArr3;
        Object obj2;
        int i14;
        boolean z6;
        ArrayList arrayList2;
        float f12;
        boolean z8;
        l7.a aVar;
        v7.d dVar2;
        v7.i iVar;
        int i15;
        BarEntry barEntry2;
        float[] fArr4;
        ?? r02 = this;
        ?? r9 = r02.f18935g;
        if (r02.q(r9)) {
            ArrayList arrayList3 = r9.getBarData().f16833i;
            float c9 = v7.h.c(4.5f);
            boolean b3 = r9.b();
            int i16 = 0;
            b bVar = r02;
            ?? r92 = r9;
            while (i16 < r92.getBarData().c()) {
                o7.b bVar2 = (o7.b) arrayList3.get(i16);
                if (c.s(bVar2)) {
                    bVar.j(bVar2);
                    YAxis$AxisDependency yAxis$AxisDependency = bVar2.f16810d;
                    r92.t(yAxis$AxisDependency);
                    float a3 = v7.h.a(bVar.e, Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
                    float f13 = b3 ? -c9 : a3 + c9;
                    float f14 = b3 ? a3 + c9 : -c9;
                    l7.a aVar2 = bVar.f18937i[i16];
                    bVar.f18948b.getClass();
                    v7.d dVar3 = bVar2.f16817l;
                    v7.d dVar4 = (v7.d) v7.d.f19181d.b();
                    float f15 = dVar3.f19182b;
                    dVar4.f19182b = f15;
                    dVar4.f19183c = dVar3.f19183c;
                    dVar4.f19182b = v7.h.c(f15);
                    dVar4.f19183c = v7.h.c(dVar4.f19183c);
                    boolean o3 = bVar2.o();
                    v7.i iVar2 = (v7.i) bVar.f78a;
                    boolean z10 = bVar2.f16816k;
                    if (o3) {
                        arrayList = arrayList3;
                        f2 = c9;
                        z5 = b3;
                        dVar = dVar4;
                        i3 = i16;
                        de.i s7 = r92.s(yAxis$AxisDependency);
                        int i17 = 0;
                        int i18 = 0;
                        r92 = r92;
                        while (i17 < bVar2.f16820o.size() * 1.0f) {
                            BarEntry barEntry3 = (BarEntry) bVar2.g(i17);
                            float[] o8 = barEntry3.o();
                            float[] fArr5 = aVar2.f15834b;
                            float f16 = (fArr5[i18] + fArr5[i18 + 2]) / 2.0f;
                            int k10 = bVar2.k(i17);
                            if (o8 != null) {
                                i10 = i17;
                                obj = r92;
                                fArr = o8;
                                int length = fArr.length * 2;
                                float[] fArr6 = new float[length];
                                float f17 = -barEntry3.l();
                                float f18 = 0.0f;
                                int i19 = 0;
                                int i20 = 0;
                                while (i19 < length) {
                                    float f19 = fArr[i20];
                                    if (f19 == 0.0f && (f18 == 0.0f || f17 == 0.0f)) {
                                        float f20 = f17;
                                        f17 = f19;
                                        f11 = f20;
                                    } else if (f19 >= 0.0f) {
                                        f18 += f19;
                                        f11 = f17;
                                        f17 = f18;
                                    } else {
                                        f11 = f17 - f19;
                                    }
                                    fArr6[i19 + 1] = f17 * 1.0f;
                                    i19 += 2;
                                    i20++;
                                    f17 = f11;
                                }
                                s7.p(fArr6);
                                int i21 = 0;
                                while (i21 < length) {
                                    int i22 = i21 / 2;
                                    float f21 = fArr[i22];
                                    float f22 = fArr6[i21 + 1] + (((f21 > 0.0f ? 1 : (f21 == 0.0f ? 0 : -1)) == 0 && (f17 > 0.0f ? 1 : (f17 == 0.0f ? 0 : -1)) == 0 && (f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1)) > 0) || (f21 > 0.0f ? 1 : (f21 == 0.0f ? 0 : -1)) < 0 ? f14 : f13);
                                    if (!iVar2.e(f16)) {
                                        break;
                                    }
                                    if (iVar2.h(f22) && iVar2.d(f16)) {
                                        i11 = length;
                                        if (bVar2.f16815j) {
                                            int i23 = i3;
                                            float f23 = f16;
                                            i12 = i21;
                                            fArr2 = fArr6;
                                            n(canvas, bVar2.j(), fArr[i22], barEntry3, i23, f23, f22, k10);
                                            i13 = k10;
                                            f10 = f23;
                                            i3 = i23;
                                        } else {
                                            fArr2 = fArr6;
                                            i12 = i21;
                                            i13 = k10;
                                            f10 = f16;
                                        }
                                        barEntry = barEntry3;
                                        if (barEntry.b() != null && z10) {
                                            Drawable b10 = barEntry.b();
                                            v7.h.d(canvas, b10, (int) (f10 + dVar.f19182b), (int) (f22 + dVar.f19183c), b10.getIntrinsicWidth(), b10.getIntrinsicHeight());
                                        }
                                    } else {
                                        i11 = length;
                                        fArr2 = fArr6;
                                        i12 = i21;
                                        barEntry = barEntry3;
                                        i13 = k10;
                                        f10 = f16;
                                    }
                                    i21 = i12 + 2;
                                    barEntry3 = barEntry;
                                    f16 = f10;
                                    length = i11;
                                    fArr6 = fArr2;
                                    k10 = i13;
                                }
                            } else {
                                if (!iVar2.e(f16)) {
                                    break;
                                }
                                int i24 = i18 + 1;
                                float[] fArr7 = aVar2.f15834b;
                                if (iVar2.h(fArr7[i24]) && iVar2.d(f16)) {
                                    if (bVar2.f16815j) {
                                        int i25 = i3;
                                        fArr3 = fArr7;
                                        obj = r92;
                                        i10 = i17;
                                        fArr = o8;
                                        n(canvas, bVar2.j(), barEntry3.d(), barEntry3, i25, f16, fArr7[i24] + (barEntry3.d() >= 0.0f ? f13 : f14), k10);
                                        f16 = f16;
                                        i3 = i25;
                                    } else {
                                        i10 = i17;
                                        fArr3 = fArr7;
                                        obj = r92;
                                        fArr = o8;
                                    }
                                    if (barEntry3.b() != null && z10) {
                                        Drawable b11 = barEntry3.b();
                                        v7.h.d(canvas, b11, (int) (f16 + dVar.f19182b), (int) (fArr3[i24] + (barEntry3.d() >= 0.0f ? f13 : f14) + dVar.f19183c), b11.getIntrinsicWidth(), b11.getIntrinsicHeight());
                                    }
                                } else {
                                    obj = r92;
                                    i17 = i17;
                                    r92 = obj;
                                }
                            }
                            i18 = fArr == null ? i18 + 4 : (fArr.length * 4) + i18;
                            i17 = i10 + 1;
                            r92 = obj;
                        }
                    } else {
                        int i26 = 0;
                        while (true) {
                            float f24 = i26;
                            float[] fArr8 = aVar2.f15834b;
                            if (f24 >= fArr8.length * 1.0f) {
                                break;
                            }
                            float f25 = (fArr8[i26] + fArr8[i26 + 2]) / 2.0f;
                            if (!iVar2.e(f25)) {
                                break;
                            }
                            int i27 = i26 + 1;
                            if (iVar2.h(fArr8[i27]) && iVar2.d(f25)) {
                                int i28 = i26 / 4;
                                BarEntry barEntry4 = (BarEntry) bVar2.g(i28);
                                v7.i iVar3 = iVar2;
                                float d5 = barEntry4.d();
                                int i29 = i26;
                                if (bVar2.f16815j) {
                                    l7.a aVar3 = aVar2;
                                    p7.d j4 = bVar2.j();
                                    float f26 = d5 >= 0.0f ? fArr8[i27] + f13 : fArr8[i29 + 3] + f14;
                                    float f27 = c9;
                                    dVar2 = dVar4;
                                    barEntry2 = barEntry4;
                                    f12 = f27;
                                    z6 = z10;
                                    float f28 = f26;
                                    i14 = i29;
                                    z8 = b3;
                                    iVar = iVar3;
                                    fArr4 = fArr8;
                                    arrayList2 = arrayList3;
                                    aVar = aVar3;
                                    n(canvas, j4, d5, barEntry2, i16, f25, f28, bVar2.k(i28));
                                } else {
                                    float f29 = c9;
                                    dVar2 = dVar4;
                                    barEntry2 = barEntry4;
                                    f12 = f29;
                                    z8 = b3;
                                    iVar = iVar3;
                                    fArr4 = fArr8;
                                    arrayList2 = arrayList3;
                                    i14 = i29;
                                    aVar = aVar2;
                                    z6 = z10;
                                }
                                i15 = i16;
                                if (barEntry2.b() != null && z6) {
                                    Drawable b12 = barEntry2.b();
                                    v7.h.d(canvas, b12, (int) (f25 + dVar2.f19182b), (int) ((d5 >= 0.0f ? fArr4[i27] + f13 : fArr4[i14 + 3] + f14) + dVar2.f19183c), b12.getIntrinsicWidth(), b12.getIntrinsicHeight());
                                }
                            } else {
                                i14 = i26;
                                z6 = z10;
                                arrayList2 = arrayList3;
                                f12 = c9;
                                z8 = b3;
                                aVar = aVar2;
                                dVar2 = dVar4;
                                iVar = iVar2;
                                i15 = i16;
                            }
                            i26 = i14 + 4;
                            i16 = i15;
                            aVar2 = aVar;
                            dVar4 = dVar2;
                            iVar2 = iVar;
                            c9 = f12;
                            b3 = z8;
                            z10 = z6;
                            arrayList3 = arrayList2;
                        }
                        i3 = i16;
                        arrayList = arrayList3;
                        f2 = c9;
                        z5 = b3;
                        dVar = dVar4;
                    }
                    obj2 = r92;
                    v7.d.c(dVar);
                } else {
                    i3 = i16;
                    obj2 = r92;
                    arrayList = arrayList3;
                    f2 = c9;
                    z5 = b3;
                }
                i16 = i3 + 1;
                bVar = this;
                c9 = f2;
                b3 = z5;
                arrayList3 = arrayList;
                r92 = obj2;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.a] */
    @Override // u7.h
    public void p() {
        o7.a barData = this.f18935g.getBarData();
        this.f18937i = new l7.a[barData.c()];
        for (int i3 = 0; i3 < this.f18937i.length; i3++) {
            o7.b bVar = (o7.b) barData.b(i3);
            l7.a[] aVarArr = this.f18937i;
            int size = bVar.f16820o.size() * 4;
            int i10 = bVar.o() ? bVar.f16802u : 1;
            barData.c();
            aVarArr[i3] = new l7.a(size * i10, bVar.o());
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.a] */
    public void t(Canvas canvas, o7.b bVar, int i3) {
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
                RectF rectF = this.f18940l;
                rectF.left = j4 - f2;
                rectF.right = j4 + f2;
                ((Matrix) s7.f12357b).mapRect(rectF);
                ((v7.i) s7.f12359d).f19201a.mapRect(rectF);
                ((Matrix) s7.f12358c).mapRect(rectF);
                if (iVar.d(rectF.right)) {
                    if (!iVar.e(rectF.left)) {
                        break;
                    }
                    RectF rectF2 = iVar.f19202b;
                    rectF.top = rectF2.top;
                    rectF.bottom = rectF2.bottom;
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
        int i12 = 0;
        while (i10 < fArr.length) {
            int i13 = i10 + 2;
            if (!iVar.d(fArr[i13])) {
                canvas2 = canvas;
            } else {
                if (!iVar.e(fArr[i10])) {
                    return;
                }
                if (!z5) {
                    ArrayList arrayList = bVar.f16807a;
                    paint3.setColor(((Integer) arrayList.get(i12 % arrayList.size())).intValue());
                }
                canvas2 = canvas;
                canvas2.drawRect(fArr[i10], fArr[i10 + 1], fArr[i13], fArr[i10 + 3], paint3);
            }
            i10 += 4;
            i12++;
            canvas = canvas2;
        }
    }

    public void u(float f2, float f10, float f11, float f12, de.i iVar) {
        float f13 = f2 - f12;
        float f14 = f2 + f12;
        RectF rectF = this.f18936h;
        rectF.set(f13, f10, f14, f11);
        this.f18948b.getClass();
        iVar.getClass();
        rectF.top *= 1.0f;
        rectF.bottom *= 1.0f;
        ((Matrix) iVar.f12357b).mapRect(rectF);
        ((v7.i) iVar.f12359d).f19201a.mapRect(rectF);
        ((Matrix) iVar.f12358c).mapRect(rectF);
    }

    public void v(q7.c cVar, RectF rectF) {
        float centerX = rectF.centerX();
        float f2 = rectF.top;
        cVar.f17804i = centerX;
        cVar.f17805j = f2;
    }
}
