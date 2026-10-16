package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class s0 extends b1.b {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f1041h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1042i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ WeakReference f1043j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ x0 f1044k;

    public s0(x0 x0Var, int i3, int i10, WeakReference weakReference) {
        this.f1044k = x0Var;
        this.f1041h = i3;
        this.f1042i = i10;
        this.f1043j = weakReference;
    }

    @Override // b1.b
    public final void d(int i3) {
    }

    @Override // b1.b
    public final void e(Typeface typeface) {
        int i3;
        int i10 = 2;
        if (Build.VERSION.SDK_INT >= 28 && (i3 = this.f1041h) != -1) {
            typeface = w0.a(typeface, i3, (this.f1042i & 2) != 0);
        }
        x0 x0Var = this.f1044k;
        if (x0Var.f1099m) {
            x0Var.f1098l = typeface;
            TextView textView = (TextView) this.f1043j.get();
            if (textView != null) {
                WeakHashMap weakHashMap = l1.z0.f15748a;
                if (l1.k0.b(textView)) {
                    textView.post(new androidx.activity.f(textView, typeface, x0Var.f1096j, i10));
                } else {
                    textView.setTypeface(typeface, x0Var.f1096j);
                }
            }
        }
    }
}
