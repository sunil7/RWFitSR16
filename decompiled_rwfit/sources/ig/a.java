package ig;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.xb;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.WeakHashMap;
import ka.c;
import ka.d;
import ka.h;
import l1.h0;
import l1.x1;
import l1.z0;

/* loaded from: classes2.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14430a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14431b;

    public /* synthetic */ a(Object obj, int i3) {
        this.f14430a = i3;
        this.f14431b = obj;
    }

    @Override // ka.a
    public final void a(AppBarLayout appBarLayout, int i3) {
        Object obj = this.f14431b;
        switch (this.f14430a) {
            case 0:
                boolean z5 = i3 >= 0;
                boolean z6 = appBarLayout.getTotalScrollRange() + i3 <= 0;
                jg.a aVar = (jg.a) obj;
                aVar.f15446g = z5;
                aVar.f15447h = z6;
                break;
            default:
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) obj;
                collapsingToolbarLayout.f10211w = i3;
                x1 x1Var = collapsingToolbarLayout.f10213y;
                int d5 = x1Var != null ? x1Var.d() : 0;
                int childCount = collapsingToolbarLayout.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = collapsingToolbarLayout.getChildAt(i10);
                    d dVar = (d) childAt.getLayoutParams();
                    h b3 = CollapsingToolbarLayout.b(childAt);
                    int i11 = dVar.f15574a;
                    if (i11 == 1) {
                        b3.b(xb.a(-i3, 0, ((collapsingToolbarLayout.getHeight() - CollapsingToolbarLayout.b(childAt).f15588b) - childAt.getHeight()) - ((FrameLayout.LayoutParams) ((d) childAt.getLayoutParams())).bottomMargin));
                    } else if (i11 == 2) {
                        b3.b(Math.round((-i3) * dVar.f15575b));
                    }
                }
                collapsingToolbarLayout.d();
                if (collapsingToolbarLayout.f10205p != null && d5 > 0) {
                    WeakHashMap weakHashMap = z0.f15748a;
                    h0.k(collapsingToolbarLayout);
                }
                int height = collapsingToolbarLayout.getHeight();
                WeakHashMap weakHashMap2 = z0.f15748a;
                int d8 = (height - h0.d(collapsingToolbarLayout)) - d5;
                float scrimVisibleHeightTrigger = height - collapsingToolbarLayout.getScrimVisibleHeightTrigger();
                float f2 = d8;
                float min = Math.min(1.0f, scrimVisibleHeightTrigger / f2);
                com.google.android.material.internal.b bVar = collapsingToolbarLayout.f10200k;
                bVar.e = min;
                bVar.f10567f = l0.a(1.0f, min, 0.5f, min);
                bVar.f10569g = collapsingToolbarLayout.f10211w + d8;
                bVar.n(Math.abs(i3) / f2);
                break;
        }
    }
}
