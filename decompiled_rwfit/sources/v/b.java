package v;

import android.util.Rational;
import android.util.Size;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Rational f19106a = new Rational(4, 3);

    /* renamed from: b, reason: collision with root package name */
    public static final Rational f19107b = new Rational(3, 4);

    /* renamed from: c, reason: collision with root package name */
    public static final Rational f19108c = new Rational(16, 9);

    /* renamed from: d, reason: collision with root package name */
    public static final Rational f19109d = new Rational(9, 16);

    public static boolean a(Rational rational, Size size) {
        Size size2 = b0.a.f3042b;
        if (rational != null) {
            if (rational.equals(new Rational(size.getWidth(), size.getHeight()))) {
                return true;
            }
            if (size.getHeight() * size.getWidth() >= b0.a.a(size2)) {
                int width = size.getWidth();
                int height = size.getHeight();
                Rational rational2 = new Rational(rational.getDenominator(), rational.getNumerator());
                int i3 = width % 16;
                if (i3 == 0 && height % 16 == 0) {
                    if (b(Math.max(0, height - 16), width, rational) || b(Math.max(0, width - 16), height, rational2)) {
                        return true;
                    }
                } else {
                    if (i3 == 0) {
                        return b(height, width, rational);
                    }
                    if (height % 16 == 0) {
                        return b(width, height, rational2);
                    }
                }
            }
        }
        return false;
    }

    public static boolean b(int i3, int i10, Rational rational) {
        pd.b(i10 % 16 == 0);
        double numerator = (rational.getNumerator() * i3) / rational.getDenominator();
        return numerator > ((double) Math.max(0, i10 + (-16))) && numerator < ((double) (i10 + 16));
    }
}
