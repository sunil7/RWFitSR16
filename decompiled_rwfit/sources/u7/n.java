package u7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet$Mode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n extends o {

    /* renamed from: h, reason: collision with root package name */
    public final BarLineChartBase f18965h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f18966i;

    /* renamed from: j, reason: collision with root package name */
    public WeakReference f18967j;

    /* renamed from: k, reason: collision with root package name */
    public Canvas f18968k;

    /* renamed from: l, reason: collision with root package name */
    public final Bitmap.Config f18969l;

    /* renamed from: m, reason: collision with root package name */
    public final Path f18970m;

    /* renamed from: n, reason: collision with root package name */
    public final Path f18971n;

    /* renamed from: o, reason: collision with root package name */
    public float[] f18972o;

    /* renamed from: p, reason: collision with root package name */
    public final Path f18973p;

    /* renamed from: q, reason: collision with root package name */
    public final HashMap f18974q;
    public final float[] r;

    /* JADX WARN: Multi-variable type inference failed */
    public n(r7.g gVar, k7.a aVar, v7.i iVar) {
        super(aVar, iVar);
        this.f18969l = Bitmap.Config.ARGB_8888;
        this.f18970m = new Path();
        this.f18971n = new Path();
        this.f18972o = new float[4];
        this.f18973p = new Path();
        this.f18974q = new HashMap();
        this.r = new float[2];
        this.f18965h = (BarLineChartBase) gVar;
        Paint paint = new Paint(1);
        this.f18966i = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [androidx.recyclerview.widget.x] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.g] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.b, r7.g] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r8v25, types: [p7.c] */
    @Override // u7.h
    public final void k(Canvas canvas) {
        Bitmap bitmap;
        BarLineChartBase barLineChartBase;
        int i3;
        int i10;
        int i11;
        PathEffect pathEffect;
        Paint paint;
        de.i iVar;
        o7.k kVar;
        de.i iVar2;
        Bitmap bitmap2;
        int i12;
        int i13;
        int i14;
        PathEffect pathEffect2;
        char c9;
        int i15;
        int i16;
        int i17 = 3;
        int i18 = 4;
        int i19 = 1;
        v7.i iVar3 = (v7.i) this.f78a;
        int i20 = (int) iVar3.f19203c;
        int i21 = (int) iVar3.f19204d;
        WeakReference weakReference = this.f18967j;
        PathEffect pathEffect3 = null;
        Bitmap bitmap3 = weakReference == null ? null : (Bitmap) weakReference.get();
        if (bitmap3 == null || bitmap3.getWidth() != i20 || bitmap3.getHeight() != i21) {
            if (i20 <= 0 || i21 <= 0) {
                return;
            }
            bitmap3 = Bitmap.createBitmap(i20, i21, this.f18969l);
            this.f18967j = new WeakReference(bitmap3);
            this.f18968k = new Canvas(bitmap3);
        }
        Bitmap bitmap4 = bitmap3;
        int i22 = 0;
        bitmap4.eraseColor(0);
        ?? r32 = this.f18965h;
        Iterator it = r32.getLineData().f16833i.iterator();
        ?? r33 = r32;
        while (true) {
            boolean hasNext = it.hasNext();
            Paint paint2 = this.f18949c;
            if (!hasNext) {
                canvas.drawBitmap(bitmap4, 0.0f, 0.0f, paint2);
                return;
            }
            o7.k kVar2 = (o7.k) it.next();
            if (!kVar2.f16819n || kVar2.f16820o.size() < i19) {
                bitmap = bitmap4;
                barLineChartBase = r33;
                i3 = i17;
                i10 = i18;
                i11 = i19;
                pathEffect = pathEffect3;
            } else {
                paint2.setStrokeWidth(kVar2.f16839z);
                paint2.setPathEffect(pathEffect3);
                int i23 = l.f18961a[kVar2.B.ordinal()];
                Path path = this.f18971n;
                Path path2 = this.f18970m;
                ?? r12 = this.f18941f;
                k7.a aVar = this.f18948b;
                int i24 = i22;
                YAxis$AxisDependency yAxis$AxisDependency = kVar2.f16810d;
                if (i23 == i17) {
                    barLineChartBase = r33;
                    bitmap = bitmap4;
                    i3 = i17;
                    i10 = i18;
                    paint = paint2;
                    aVar.getClass();
                    de.i s7 = barLineChartBase.s(yAxis$AxisDependency);
                    r12.e(barLineChartBase, kVar2);
                    float f2 = kVar2.G;
                    path2.reset();
                    if (r12.f2800d >= 1) {
                        int i25 = r12.f2798b;
                        Entry g10 = kVar2.g(Math.max(i25 - 1, i24));
                        Entry g11 = kVar2.g(Math.max(i25, i24));
                        if (g11 != null) {
                            path2.moveTo(g11.j(), g11.d() * 1.0f);
                            i11 = 1;
                            int i26 = r12.f2798b + 1;
                            iVar = s7;
                            Entry entry = g11;
                            int i27 = -1;
                            while (i26 <= r12.f2800d + r12.f2798b) {
                                if (i27 != i26) {
                                    g11 = kVar2.g(i26);
                                }
                                int i28 = i26 + 1;
                                if (i28 < kVar2.f16820o.size()) {
                                    i26 = i28;
                                }
                                Entry g12 = kVar2.g(i26);
                                Path path3 = path2;
                                path3.cubicTo(entry.j() + ((g11.j() - g10.j()) * f2), (entry.d() + ((g11.d() - g10.d()) * f2)) * 1.0f, g11.j() - ((g12.j() - entry.j()) * f2), (g11.d() - ((g12.d() - entry.d()) * f2)) * 1.0f, g11.j(), g11.d() * 1.0f);
                                int i29 = i26;
                                i26 = i28;
                                i27 = i29;
                                g10 = entry;
                                path2 = path3;
                                entry = g11;
                                g11 = g12;
                            }
                        }
                    } else {
                        iVar = s7;
                        i11 = 1;
                    }
                    if (kVar2.A) {
                        path.reset();
                        path.addPath(path2);
                        kVar = kVar2;
                        iVar2 = iVar;
                        t(this.f18968k, kVar, path, iVar2, this.f18941f);
                    } else {
                        kVar = kVar2;
                        iVar2 = iVar;
                    }
                    paint.setColor(kVar.e());
                    paint.setStyle(Paint.Style.STROKE);
                    iVar2.n(path2);
                    this.f18968k.drawPath(path2, paint);
                    pathEffect = null;
                    paint.setPathEffect(null);
                    paint.setPathEffect(pathEffect);
                } else if (i23 != i18) {
                    int size = kVar2.f16820o.size();
                    int i30 = kVar2.B == LineDataSet$Mode.STEPPED ? i19 : i24;
                    int i31 = i30 != 0 ? i18 : 2;
                    de.i s8 = r33.s(yAxis$AxisDependency);
                    aVar.getClass();
                    paint2.setStyle(Paint.Style.STROKE);
                    r12.e(r33, kVar2);
                    if (!kVar2.A || size <= 0) {
                        bitmap2 = bitmap4;
                        i12 = size;
                        i13 = i30;
                        i3 = i17;
                        i10 = i18;
                        i14 = i19;
                    } else {
                        Path path4 = this.f18973p;
                        i3 = i17;
                        int i32 = r12.f2798b;
                        i10 = i18;
                        int i33 = r12.f2800d + i32;
                        bitmap2 = bitmap4;
                        i14 = i19;
                        int i34 = i24;
                        while (true) {
                            int i35 = (i34 * 128) + i32;
                            i12 = size;
                            int i36 = i35 + 128;
                            if (i36 > i33) {
                                i36 = i33;
                            }
                            i13 = i30;
                            if (i35 <= i36) {
                                float e = kVar2.H.e(kVar2, r33);
                                i15 = i32;
                                i16 = i33;
                                int i37 = kVar2.B == LineDataSet$Mode.STEPPED ? i14 : i24;
                                path4.reset();
                                Entry g13 = kVar2.g(i35);
                                int i38 = i37;
                                path4.moveTo(g13.j(), e);
                                path4.lineTo(g13.j(), g13.d() * 1.0f);
                                int i39 = i35 + 1;
                                Entry entry2 = g13;
                                Entry entry3 = null;
                                while (i39 <= i36) {
                                    entry3 = kVar2.g(i39);
                                    int i40 = i39;
                                    if (i38 != 0) {
                                        path4.lineTo(entry3.j(), entry2.d() * 1.0f);
                                    }
                                    path4.lineTo(entry3.j(), entry3.d() * 1.0f);
                                    i39 = i40 + 1;
                                    entry2 = entry3;
                                }
                                if (entry3 != null) {
                                    path4.lineTo(entry3.j(), e);
                                }
                                path4.close();
                                s8.n(path4);
                                int i41 = (kVar2.f16837x & 16777215) | (kVar2.f16838y << 24);
                                DisplayMetrics displayMetrics = v7.h.f19191a;
                                int save = canvas.save();
                                canvas.clipPath(path4);
                                canvas.drawColor(i41);
                                canvas.restoreToCount(save);
                            } else {
                                i15 = i32;
                                i16 = i33;
                            }
                            i34++;
                            if (i35 > i36) {
                                break;
                            }
                            size = i12;
                            i30 = i13;
                            i32 = i15;
                            i33 = i16;
                        }
                    }
                    if (kVar2.f16807a.size() > i14) {
                        int i42 = i31 * 2;
                        if (this.f18972o.length <= i42) {
                            this.f18972o = new float[i31 * 4];
                        }
                        int i43 = r12.f2798b;
                        int i44 = r12.f2800d + i43;
                        while (i43 < i44) {
                            Entry g14 = kVar2.g(i43);
                            if (g14 != null) {
                                this.f18972o[i24] = g14.j();
                                this.f18972o[1] = g14.d() * 1.0f;
                                if (i43 < r12.f2799c) {
                                    Entry g15 = kVar2.g(i43 + 1);
                                    if (g15 == null) {
                                        break;
                                    }
                                    if (i13 != 0) {
                                        this.f18972o[2] = g15.j();
                                        float[] fArr = this.f18972o;
                                        float f10 = fArr[1];
                                        fArr[i3] = f10;
                                        fArr[i10] = fArr[2];
                                        fArr[5] = f10;
                                        fArr[6] = g15.j();
                                        this.f18972o[7] = g15.d() * 1.0f;
                                    } else {
                                        this.f18972o[2] = g15.j();
                                        this.f18972o[i3] = g15.d() * 1.0f;
                                    }
                                    c9 = 1;
                                } else {
                                    float[] fArr2 = this.f18972o;
                                    fArr2[2] = fArr2[i24];
                                    c9 = 1;
                                    fArr2[i3] = fArr2[1];
                                }
                                float[] fArr3 = this.f18972o;
                                float f11 = fArr3[i24];
                                float f12 = fArr3[c9];
                                float f13 = fArr3[i42 - 2];
                                float f14 = fArr3[i42 - 1];
                                if (f11 != f13 || f12 != f14) {
                                    s8.p(fArr3);
                                    if (!iVar3.e(f11)) {
                                        break;
                                    }
                                    if (iVar3.d(f13) && iVar3.f(Math.max(f12, f14)) && iVar3.c(Math.min(f12, f14))) {
                                        ArrayList arrayList = kVar2.f16807a;
                                        paint2.setColor(((Integer) arrayList.get(i43 % arrayList.size())).intValue());
                                        canvas.drawLines(this.f18972o, i24, i42, paint2);
                                    }
                                }
                            }
                            i43++;
                            i24 = 0;
                        }
                        pathEffect2 = null;
                    } else {
                        int i45 = i12 * i31;
                        if (this.f18972o.length < Math.max(i45, i31) * 2) {
                            this.f18972o = new float[Math.max(i45, i31) * 4];
                        }
                        if (kVar2.g(r12.f2798b) != null) {
                            int i46 = r12.f2798b;
                            int i47 = 0;
                            while (i46 <= r12.f2800d + r12.f2798b) {
                                Entry g16 = kVar2.g(i46 == 0 ? 0 : i46 - 1);
                                Entry g17 = kVar2.g(i46);
                                if (g16 != null && g17 != null) {
                                    this.f18972o[i47] = g16.j();
                                    int i48 = i47 + 2;
                                    this.f18972o[i47 + 1] = g16.d() * 1.0f;
                                    if (i13 != 0) {
                                        this.f18972o[i48] = g17.j();
                                        this.f18972o[i47 + 3] = g16.d() * 1.0f;
                                        this.f18972o[i47 + 4] = g17.j();
                                        i48 = i47 + 6;
                                        this.f18972o[i47 + 5] = g16.d() * 1.0f;
                                    }
                                    this.f18972o[i48] = g17.j();
                                    this.f18972o[i48 + 1] = g17.d() * 1.0f;
                                    i47 = i48 + 2;
                                }
                                i46++;
                            }
                            if (i47 > 0) {
                                s8.p(this.f18972o);
                                int max = Math.max((r12.f2800d + 1) * i31, i31) * 2;
                                paint2.setColor(kVar2.e());
                                canvas.drawLines(this.f18972o, 0, max, paint2);
                                pathEffect2 = null;
                            }
                        }
                        pathEffect2 = null;
                    }
                    paint2.setPathEffect(pathEffect2);
                    barLineChartBase = r33;
                    paint = paint2;
                    bitmap = bitmap2;
                } else {
                    Bitmap bitmap5 = bitmap4;
                    i3 = i17;
                    i10 = i18;
                    aVar.getClass();
                    de.i s10 = r33.s(yAxis$AxisDependency);
                    r12.e(r33, kVar2);
                    path2.reset();
                    if (r12.f2800d >= 1) {
                        Entry g18 = kVar2.g(r12.f2798b);
                        path2.moveTo(g18.j(), g18.d() * 1.0f);
                        int i49 = r12.f2798b + 1;
                        while (i49 <= r12.f2800d + r12.f2798b) {
                            Entry g19 = kVar2.g(i49);
                            float j4 = ((g19.j() - g18.j()) / 2.0f) + g18.j();
                            path2.cubicTo(j4, g18.d() * 1.0f, j4, g19.d() * 1.0f, g19.j(), g19.d() * 1.0f);
                            i49++;
                            g18 = g19;
                        }
                    }
                    if (kVar2.A) {
                        path.reset();
                        path.addPath(path2);
                        barLineChartBase = r33;
                        paint = paint2;
                        bitmap = bitmap5;
                        t(this.f18968k, kVar2, path, s10, this.f18941f);
                        s10 = s10;
                        kVar2 = kVar2;
                    } else {
                        barLineChartBase = r33;
                        paint = paint2;
                        bitmap = bitmap5;
                    }
                    paint.setColor(kVar2.e());
                    paint.setStyle(Paint.Style.STROKE);
                    s10.n(path2);
                    this.f18968k.drawPath(path2, paint);
                    paint.setPathEffect(null);
                }
                pathEffect = null;
                i11 = 1;
                paint.setPathEffect(pathEffect);
            }
            pathEffect3 = pathEffect;
            bitmap4 = bitmap;
            r33 = barLineChartBase;
            i17 = i3;
            i18 = i10;
            i19 = i11;
            i22 = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x012c  */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.g] */
    @Override // u7.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.graphics.Canvas r24) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.n.l(android.graphics.Canvas):void");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.g] */
    @Override // u7.h
    public final void m(Canvas canvas, q7.c[] cVarArr) {
        ?? r02 = this.f18965h;
        o7.j lineData = r02.getLineData();
        for (q7.c cVar : cVarArr) {
            o7.k kVar = (o7.k) lineData.b(cVar.f17801f);
            if (kVar != null && kVar.e) {
                Entry h4 = kVar.h(cVar.f17797a, cVar.f17798b, DataSet$Rounding.CLOSEST);
                if (r(h4, kVar)) {
                    de.i s7 = r02.s(kVar.f16810d);
                    float j4 = h4.j();
                    float d5 = h4.d();
                    this.f18948b.getClass();
                    v7.c i3 = s7.i(j4, d5 * 1.0f);
                    float f2 = (float) i3.f19179b;
                    float f10 = (float) i3.f19180c;
                    cVar.f17804i = f2;
                    cVar.f17805j = f10;
                    this.f18950d.setColor(kVar.f16824t);
                    this.f18950d.setStrokeWidth(kVar.f16836w);
                    this.f18950d.setPathEffect(null);
                    v7.i iVar = (v7.i) this.f78a;
                    Path path = this.f18975g;
                    if (kVar.f16834u) {
                        path.reset();
                        path.moveTo(f2, iVar.f19202b.top);
                        path.lineTo(f2, iVar.f19202b.bottom);
                        canvas.drawPath(path, this.f18950d);
                    }
                    if (kVar.f16835v) {
                        path.reset();
                        path.moveTo(iVar.f19202b.left, f10);
                        path.lineTo(iVar.f19202b.right, f10);
                        canvas.drawPath(path, this.f18950d);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.b, r7.g] */
    @Override // u7.h
    public final void o(Canvas canvas) {
        int i3;
        int i10;
        v7.d dVar;
        int i11;
        float f2;
        Entry entry;
        n nVar = this;
        ?? r9 = nVar.f18965h;
        if (nVar.q(r9)) {
            ArrayList arrayList = r9.getLineData().f16833i;
            int i12 = 0;
            n nVar2 = nVar;
            while (i12 < arrayList.size()) {
                o7.k kVar = (o7.k) arrayList.get(i12);
                if (!c.s(kVar) || kVar.f16820o.size() < 1) {
                    i3 = i12;
                } else {
                    nVar2.j(kVar);
                    de.i s7 = r9.s(kVar.f16810d);
                    int i13 = (int) (kVar.E * 1.75f);
                    if (!kVar.I) {
                        i13 /= 2;
                    }
                    int i14 = i13;
                    androidx.recyclerview.widget.x xVar = nVar2.f18941f;
                    xVar.e(r9, kVar);
                    nVar2.f18948b.getClass();
                    int i15 = xVar.f2798b;
                    int i16 = (((int) ((xVar.f2799c - i15) * 1.0f)) + 1) * 2;
                    if (((float[]) s7.e).length != i16) {
                        s7.e = new float[i16];
                    }
                    float[] fArr = (float[]) s7.e;
                    for (int i17 = 0; i17 < i16; i17 += 2) {
                        Entry g10 = kVar.g((i17 / 2) + i15);
                        if (g10 != null) {
                            fArr[i17] = g10.j();
                            fArr[i17 + 1] = g10.d() * 1.0f;
                        } else {
                            fArr[i17] = 0.0f;
                            fArr[i17 + 1] = 0.0f;
                        }
                    }
                    Matrix matrix = (Matrix) s7.f12362h;
                    matrix.set((Matrix) s7.f12357b);
                    matrix.postConcat(((v7.i) s7.f12359d).f19201a);
                    matrix.postConcat((Matrix) s7.f12358c);
                    matrix.mapPoints(fArr);
                    v7.d dVar2 = kVar.f16817l;
                    v7.d dVar3 = (v7.d) v7.d.f19181d.b();
                    float f10 = dVar2.f19182b;
                    dVar3.f19182b = f10;
                    dVar3.f19183c = dVar2.f19183c;
                    dVar3.f19182b = v7.h.c(f10);
                    dVar3.f19183c = v7.h.c(dVar3.f19183c);
                    int i18 = 0;
                    n nVar3 = nVar2;
                    while (i18 < fArr.length) {
                        float f11 = fArr[i18];
                        float f12 = fArr[i18 + 1];
                        v7.i iVar = (v7.i) nVar3.f78a;
                        if (!iVar.e(f11)) {
                            break;
                        }
                        if (iVar.d(f11) && iVar.h(f12)) {
                            int i19 = i18 / 2;
                            Entry g11 = kVar.g(xVar.f2798b + i19);
                            if (kVar.f16815j) {
                                int k10 = kVar.k(i19);
                                entry = g11;
                                dVar = dVar3;
                                f2 = f12;
                                i10 = i18;
                                nVar3.n(canvas, kVar.j(), g11.d(), entry, i12, f11, f12 - i14, k10);
                            } else {
                                i10 = i18;
                                dVar = dVar3;
                                f2 = f12;
                                entry = g11;
                            }
                            i11 = i12;
                            if (entry.b() != null && kVar.f16816k) {
                                Drawable b3 = entry.b();
                                v7.h.d(canvas, b3, (int) (f11 + dVar.f19182b), (int) (f2 + dVar.f19183c), b3.getIntrinsicWidth(), b3.getIntrinsicHeight());
                            }
                        } else {
                            i10 = i18;
                            dVar = dVar3;
                            i11 = i12;
                        }
                        i18 = i10 + 2;
                        nVar3 = this;
                        i12 = i11;
                        dVar3 = dVar;
                    }
                    i3 = i12;
                    v7.d.c(dVar3);
                }
                i12 = i3 + 1;
                nVar2 = this;
            }
        }
    }

    @Override // u7.h
    public final void p() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.g] */
    public final void t(Canvas canvas, o7.k kVar, Path path, de.i iVar, androidx.recyclerview.widget.x xVar) {
        float e = kVar.H.e(kVar, this.f18965h);
        path.lineTo(kVar.g(xVar.f2798b + xVar.f2800d).j(), e);
        path.lineTo(kVar.g(xVar.f2798b).j(), e);
        path.close();
        iVar.n(path);
        int i3 = (kVar.f16838y << 24) | (kVar.f16837x & 16777215);
        DisplayMetrics displayMetrics = v7.h.f19191a;
        int save = canvas.save();
        canvas.clipPath(path);
        canvas.drawColor(i3);
        canvas.restoreToCount(save);
    }
}
