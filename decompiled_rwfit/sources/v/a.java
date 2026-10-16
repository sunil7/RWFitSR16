package v;

import android.graphics.RectF;
import android.util.Rational;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final RectF f19104a;

    /* renamed from: b, reason: collision with root package name */
    public final Rational f19105b;

    public a(Rational rational, Rational rational2) {
        this.f19105b = rational2 == null ? new Rational(4, 3) : rational2;
        this.f19104a = b(rational);
    }

    public static float a(RectF rectF, RectF rectF2) {
        return (rectF.width() < rectF2.width() ? rectF.width() : rectF2.width()) * (rectF.height() < rectF2.height() ? rectF.height() : rectF2.height());
    }

    public final RectF b(Rational rational) {
        float floatValue = rational.floatValue();
        Rational rational2 = this.f19105b;
        return floatValue == rational2.floatValue() ? new RectF(0.0f, 0.0f, rational2.getNumerator(), rational2.getDenominator()) : rational.floatValue() > rational2.floatValue() ? new RectF(0.0f, 0.0f, rational2.getNumerator(), (rational.getDenominator() * rational2.getNumerator()) / rational.getNumerator()) : new RectF(0.0f, 0.0f, (rational.getNumerator() * rational2.getDenominator()) / rational.getDenominator(), rational2.getDenominator());
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Rational rational = (Rational) obj;
        Rational rational2 = (Rational) obj2;
        boolean z5 = false;
        if (rational.equals(rational2)) {
            return 0;
        }
        RectF b3 = b(rational);
        RectF b10 = b(rational2);
        RectF rectF = this.f19104a;
        boolean z6 = b3.width() >= rectF.width() && b3.height() >= rectF.height();
        if (b10.width() >= rectF.width() && b10.height() >= rectF.height()) {
            z5 = true;
        }
        if (z6 && z5) {
            return (int) Math.signum((b3.height() * b3.width()) - (b10.height() * b10.width()));
        }
        if (z6) {
            return -1;
        }
        if (z5) {
            return 1;
        }
        return -((int) Math.signum(a(b3, rectF) - a(b10, rectF)));
    }
}
