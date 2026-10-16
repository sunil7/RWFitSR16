package og;

import android.view.View;
import android.widget.OverScroller;

/* loaded from: classes2.dex */
public final class h extends androidx.emoji2.text.g {
    @Override // androidx.emoji2.text.g
    public final void a(OverScroller overScroller, int i3, int i10) {
        overScroller.startScroll(-Math.abs(i3), 0, Math.abs(i3), 0, i10);
    }

    @Override // androidx.emoji2.text.g
    public final void b(OverScroller overScroller, int i3, int i10) {
        overScroller.startScroll(Math.abs(i3), 0, ((View) this.f2030b).getWidth() - Math.abs(i3), 0, i10);
    }

    @Override // androidx.emoji2.text.g
    public final g c(int i3, int i10) {
        g gVar = (g) this.f2031c;
        gVar.f16942a = i3;
        gVar.f16943b = i10;
        gVar.f16944c = false;
        if (i3 == 0) {
            gVar.f16944c = true;
        }
        if (i3 >= 0) {
            gVar.f16942a = 0;
        }
        int i11 = gVar.f16942a;
        View view = (View) this.f2030b;
        if (i11 <= (-view.getWidth())) {
            gVar.f16942a = -view.getWidth();
        }
        return gVar;
    }

    @Override // androidx.emoji2.text.g
    public final boolean r(float f2, int i3) {
        return f2 > ((float) ((View) this.f2030b).getWidth());
    }
}
