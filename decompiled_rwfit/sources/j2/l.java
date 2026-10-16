package j2;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f15249a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public final View f15250b;

    /* renamed from: c, reason: collision with root package name */
    public final float[] f15251c;

    /* renamed from: d, reason: collision with root package name */
    public float f15252d;
    public float e;

    public l(View view, float[] fArr) {
        this.f15250b = view;
        float[] fArr2 = (float[]) fArr.clone();
        this.f15251c = fArr2;
        this.f15252d = fArr2[2];
        this.e = fArr2[5];
        a();
    }

    public final void a() {
        float f2 = this.f15252d;
        float[] fArr = this.f15251c;
        fArr[2] = f2;
        fArr[5] = this.e;
        Matrix matrix = this.f15249a;
        matrix.setValues(fArr);
        o0.f15272a.d(this.f15250b, matrix);
    }
}
