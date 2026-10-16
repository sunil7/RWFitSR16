package n7;

import android.graphics.Paint;
import android.util.DisplayMetrics;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;

/* loaded from: classes.dex */
public final class i extends a {
    public final YAxis$AxisDependency L;
    public final boolean F = true;
    public final boolean G = true;
    public float H = 10.0f;
    public final float I = 10.0f;
    public YAxis$YAxisLabelPosition J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
    public float K = 0.0f;
    public final float M = Float.POSITIVE_INFINITY;

    public i(YAxis$AxisDependency yAxis$AxisDependency) {
        this.L = yAxis$AxisDependency;
        this.f16408c = 0.0f;
    }

    @Override // n7.a
    public final void a(float f2, float f10) {
        if (f2 > f10 && this.f16405z) {
            f10 = (f2 < 0.0f ? 0.5f : 1.5f) * f2;
        }
        if (Math.abs(f10 - f2) == 0.0f) {
            f10 += 1.0f;
            f2 -= 1.0f;
        }
        float abs = Math.abs(f10 - f2);
        float f11 = this.f16405z ? this.B : f2 - ((abs / 100.0f) * this.I);
        this.B = f11;
        float f12 = ((abs / 100.0f) * this.H) + f10;
        this.A = f12;
        this.C = Math.abs(f11 - f12);
    }

    public final float i(Paint paint) {
        paint.setTextSize(this.f16409d);
        return (this.f16408c * 2.0f) + v7.h.a(paint, d());
    }

    public final float j(Paint paint) {
        paint.setTextSize(this.f16409d);
        String d5 = d();
        DisplayMetrics displayMetrics = v7.h.f19191a;
        float measureText = (this.f16407b * 2.0f) + ((int) paint.measureText(d5));
        float f2 = this.M;
        if (f2 > 0.0f && f2 != Float.POSITIVE_INFINITY) {
            f2 = v7.h.c(f2);
        }
        if (f2 <= 0.0d) {
            f2 = measureText;
        }
        return Math.max(0.0f, Math.min(measureText, f2));
    }

    public final boolean k() {
        return this.f16406a && this.f16399t && this.J == YAxis$YAxisLabelPosition.OUTSIDE_CHART;
    }
}
