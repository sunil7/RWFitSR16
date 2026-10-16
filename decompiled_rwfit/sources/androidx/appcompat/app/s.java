package androidx.appcompat.app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.google.android.gms.internal.mlkit_vision_barcode.be;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public final class s extends be {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f565a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f566b;

    public /* synthetic */ s(Object obj, int i3) {
        this.f565a = i3;
        this.f566b = obj;
    }

    @Override // l1.h1
    public final void onAnimationEnd() {
        Object obj = this.f566b;
        switch (this.f565a) {
            case 0:
                c0 c0Var = ((q) obj).f563b;
                c0Var.f442v.setAlpha(1.0f);
                c0Var.f445y.d(null);
                c0Var.f445y = null;
                break;
            case 1:
                c0 c0Var2 = (c0) obj;
                c0Var2.f442v.setAlpha(1.0f);
                c0Var2.f445y.d(null);
                c0Var2.f445y = null;
                break;
            default:
                com.example.test.utils.y yVar = (com.example.test.utils.y) obj;
                ((c0) yVar.f8774c).f442v.setVisibility(8);
                c0 c0Var3 = (c0) yVar.f8774c;
                PopupWindow popupWindow = c0Var3.f443w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (c0Var3.f442v.getParent() instanceof View) {
                    View view = (View) c0Var3.f442v.getParent();
                    WeakHashMap weakHashMap = z0.f15748a;
                    l1.l0.c(view);
                }
                c0Var3.f442v.e();
                c0Var3.f445y.d(null);
                c0Var3.f445y = null;
                ViewGroup viewGroup = c0Var3.A;
                WeakHashMap weakHashMap2 = z0.f15748a;
                l1.l0.c(viewGroup);
                break;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.be, l1.h1
    public void onAnimationStart() {
        Object obj = this.f566b;
        switch (this.f565a) {
            case 0:
                ((q) obj).f563b.f442v.setVisibility(0);
                break;
            case 1:
                c0 c0Var = (c0) obj;
                c0Var.f442v.setVisibility(0);
                if (c0Var.f442v.getParent() instanceof View) {
                    View view = (View) c0Var.f442v.getParent();
                    WeakHashMap weakHashMap = z0.f15748a;
                    l1.l0.c(view);
                    break;
                }
                break;
        }
    }
}
