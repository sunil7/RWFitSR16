package j2;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* loaded from: classes.dex */
public final class q implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15280a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15281b;

    public /* synthetic */ q(int i3) {
        this.f15280a = i3;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f2, Object obj, Object obj2) {
        switch (this.f15280a) {
            case 0:
                float[] fArr = (float[]) obj;
                float[] fArr2 = (float[]) obj2;
                float[] fArr3 = (float[]) this.f15281b;
                if (fArr3 == null) {
                    fArr3 = new float[fArr.length];
                }
                for (int i3 = 0; i3 < fArr3.length; i3++) {
                    float f10 = fArr[i3];
                    fArr3[i3] = com.google.android.gms.internal.mlkit_vision_barcode.l0.a(fArr2[i3], f10, f2, f10);
                }
                return fArr3;
            default:
                float floatValue = ((FloatEvaluator) this.f15281b).evaluate(f2, (Number) obj, (Number) obj2).floatValue();
                if (floatValue < 0.1f) {
                    floatValue = 0.0f;
                }
                return Float.valueOf(floatValue);
        }
    }
}
