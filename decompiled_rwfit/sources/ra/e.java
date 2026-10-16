package ra;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public interface e {
    void c();

    void d(Canvas canvas);

    void e();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    boolean h();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i3);

    void setRevealInfo(d dVar);
}
