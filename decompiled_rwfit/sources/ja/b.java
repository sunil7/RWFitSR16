package ja;

import android.animation.TypeEvaluator;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class b implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    public static final b f15387a = new b();

    public static Integer a(float f2, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f10 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = num2.intValue();
        float f11 = ((intValue2 >> 24) & 255) / 255.0f;
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float pow5 = (float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d);
        float pow6 = (float) Math.pow((intValue2 & 255) / 255.0f, 2.2d);
        float a3 = l0.a(f11, f10, f2, f10);
        float a10 = l0.a(pow4, pow, f2, pow);
        float a11 = l0.a(pow5, pow2, f2, pow2);
        float a12 = l0.a(pow6, pow3, f2, pow3);
        float pow7 = ((float) Math.pow(a10, 0.45454545454545453d)) * 255.0f;
        float pow8 = ((float) Math.pow(a11, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(a12, 0.45454545454545453d)) * 255.0f) | (Math.round(pow7) << 16) | (Math.round(a3 * 255.0f) << 24) | (Math.round(pow8) << 8));
    }

    @Override // android.animation.TypeEvaluator
    public final /* bridge */ /* synthetic */ Object evaluate(float f2, Object obj, Object obj2) {
        return a(f2, (Integer) obj, (Integer) obj2);
    }
}
