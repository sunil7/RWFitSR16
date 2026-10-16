package wa;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class j implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f19556a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f19557b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f19558c = new Matrix();

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n f19559d;

    public j(n nVar) {
        this.f19559d = nVar;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f2, Object obj, Object obj2) {
        this.f19559d.r = f2;
        float[] fArr = this.f19556a;
        ((Matrix) obj).getValues(fArr);
        float[] fArr2 = this.f19557b;
        ((Matrix) obj2).getValues(fArr2);
        for (int i3 = 0; i3 < 9; i3++) {
            float f10 = fArr2[i3];
            float f11 = fArr[i3];
            fArr2[i3] = l0.a(f10, f11, f2, f11);
        }
        Matrix matrix = this.f19558c;
        matrix.setValues(fArr2);
        return matrix;
    }
}
