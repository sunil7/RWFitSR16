package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.be;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public final class n0 extends be {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f524a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p0 f525b;

    public /* synthetic */ n0(p0 p0Var, int i3) {
        this.f524a = i3;
        this.f525b = p0Var;
    }

    @Override // l1.h1
    public final void onAnimationEnd() {
        View view;
        p0 p0Var = this.f525b;
        switch (this.f524a) {
            case 0:
                if (p0Var.f553o && (view = p0Var.f545g) != null) {
                    view.setTranslationY(0.0f);
                    p0Var.f543d.setTranslationY(0.0f);
                }
                p0Var.f543d.setVisibility(8);
                p0Var.f543d.setTransitioning(false);
                p0Var.f556s = null;
                com.example.test.utils.y yVar = p0Var.f549k;
                if (yVar != null) {
                    yVar.B(p0Var.f548j);
                    p0Var.f548j = null;
                    p0Var.f549k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = p0Var.f542c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = z0.f15748a;
                    l1.l0.c(actionBarOverlayLayout);
                    break;
                }
                break;
            default:
                p0Var.f556s = null;
                p0Var.f543d.requestLayout();
                break;
        }
    }
}
