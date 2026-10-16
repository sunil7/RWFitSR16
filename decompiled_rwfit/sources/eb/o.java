package eb;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.example.test.ui.device.activity.e0;
import com.google.android.gms.internal.mlkit_vision_barcode.qb;
import java.util.ArrayList;
import java.util.BitSet;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final w[] f12552a = new w[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f12553b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f12554c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    public final PointF f12555d = new PointF();
    public final Path e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f12556f = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final w f12557g = new w();

    /* renamed from: h, reason: collision with root package name */
    public final float[] f12558h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f12559i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f12560j = new Path();

    /* renamed from: k, reason: collision with root package name */
    public final Path f12561k = new Path();

    /* renamed from: l, reason: collision with root package name */
    public final boolean f12562l = true;

    public o() {
        for (int i3 = 0; i3 < 4; i3++) {
            this.f12552a[i3] = new w();
            this.f12553b[i3] = new Matrix();
            this.f12554c[i3] = new Matrix();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v6 */
    public final void a(m mVar, float f2, RectF rectF, e0 e0Var, Path path) {
        Matrix[] matrixArr;
        Matrix[] matrixArr2;
        w[] wVarArr;
        int i3;
        boolean z5;
        float[] fArr;
        boolean z6;
        int i10;
        path.rewind();
        Path path2 = this.e;
        path2.rewind();
        Path path3 = this.f12556f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i11 = 0;
        while (true) {
            matrixArr = this.f12554c;
            matrixArr2 = this.f12553b;
            wVarArr = this.f12552a;
            z5 = 0;
            fArr = this.f12558h;
            if (i11 >= 4) {
                break;
            }
            c cVar = i11 != 1 ? i11 != 2 ? i11 != 3 ? mVar.f12544f : mVar.e : mVar.f12546h : mVar.f12545g;
            qb qbVar = i11 != 1 ? i11 != 2 ? i11 != 3 ? mVar.f12541b : mVar.f12540a : mVar.f12543d : mVar.f12542c;
            w wVar = wVarArr[i11];
            qbVar.getClass();
            qbVar.a(wVar, f2, cVar.a(rectF));
            int i12 = i11 + 1;
            float f10 = i12 * 90;
            matrixArr2[i11].reset();
            PointF pointF = this.f12555d;
            if (i11 == 1) {
                i10 = i11;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i11 == 2) {
                i10 = i11;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i11 != 3) {
                i10 = i11;
                pointF.set(rectF.right, rectF.top);
            } else {
                i10 = i11;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i10].setTranslate(pointF.x, pointF.y);
            matrixArr2[i10].preRotate(f10);
            w wVar2 = wVarArr[i10];
            fArr[0] = wVar2.f12581c;
            fArr[1] = wVar2.f12582d;
            matrixArr2[i10].mapPoints(fArr);
            matrixArr[i10].reset();
            matrixArr[i10].setTranslate(fArr[0], fArr[1]);
            matrixArr[i10].preRotate(f10);
            i11 = i12;
        }
        int i13 = 0;
        for (i3 = 4; i13 < i3; i3 = 4) {
            w wVar3 = wVarArr[i13];
            fArr[z5] = wVar3.f12579a;
            fArr[1] = wVar3.f12580b;
            matrixArr2[i13].mapPoints(fArr);
            if (i13 == 0) {
                path.moveTo(fArr[z5], fArr[1]);
            } else {
                path.lineTo(fArr[z5], fArr[1]);
            }
            wVarArr[i13].c(matrixArr2[i13], path);
            if (e0Var != null) {
                w wVar4 = wVarArr[i13];
                Matrix matrix = matrixArr2[i13];
                h hVar = (h) e0Var.f7855b;
                BitSet bitSet = hVar.f12508d;
                wVar4.getClass();
                bitSet.set(i13, z5);
                wVar4.b(wVar4.f12583f);
                hVar.f12506b[i13] = new p(new ArrayList(wVar4.f12585h), new Matrix(matrix));
            }
            int i14 = i13 + 1;
            int i15 = i14 % 4;
            w wVar5 = wVarArr[i13];
            fArr[0] = wVar5.f12581c;
            fArr[1] = wVar5.f12582d;
            matrixArr2[i13].mapPoints(fArr);
            w wVar6 = wVarArr[i15];
            float f11 = wVar6.f12579a;
            float[] fArr2 = this.f12559i;
            fArr2[0] = f11;
            fArr2[1] = wVar6.f12580b;
            matrixArr2[i15].mapPoints(fArr2);
            Matrix[] matrixArr3 = matrixArr2;
            w[] wVarArr2 = wVarArr;
            float max = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            w wVar7 = wVarArr2[i13];
            fArr[0] = wVar7.f12581c;
            fArr[1] = wVar7.f12582d;
            matrixArr3[i13].mapPoints(fArr);
            float abs = (i13 == 1 || i13 == 3) ? Math.abs(rectF.centerX() - fArr[0]) : Math.abs(rectF.centerY() - fArr[1]);
            w wVar8 = this.f12557g;
            wVar8.e(0.0f, 0.0f, 270.0f, 0.0f);
            e eVar = i13 != 1 ? i13 != 2 ? i13 != 3 ? mVar.f12548j : mVar.f12547i : mVar.f12550l : mVar.f12549k;
            eVar.q(max, abs, f2, wVar8);
            Path path4 = this.f12560j;
            path4.reset();
            wVar8.c(matrixArr[i13], path4);
            if (this.f12562l && (eVar.p() || b(path4, i13) || b(path4, i15))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr[0] = wVar8.f12579a;
                fArr[1] = wVar8.f12580b;
                matrixArr[i13].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                wVar8.c(matrixArr[i13], path2);
            } else {
                wVar8.c(matrixArr[i13], path);
            }
            if (e0Var != null) {
                Matrix matrix2 = matrixArr[i13];
                h hVar2 = (h) e0Var.f7855b;
                z6 = false;
                hVar2.f12508d.set(i13 + 4, false);
                wVar8.b(wVar8.f12583f);
                hVar2.f12507c[i13] = new p(new ArrayList(wVar8.f12585h), new Matrix(matrix2));
            } else {
                z6 = false;
            }
            i13 = i14;
            z5 = z6;
            wVarArr = wVarArr2;
            matrixArr2 = matrixArr3;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean b(Path path, int i3) {
        Path path2 = this.f12561k;
        path2.reset();
        this.f12552a[i3].c(this.f12553b[i3], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
