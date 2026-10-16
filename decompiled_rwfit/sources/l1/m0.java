package l1;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class m0 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public x1 f15712a = null;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f15713b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f15714c;

    public m0(View view, w wVar) {
        this.f15713b = view;
        this.f15714c = wVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        x1 h4 = x1.h(windowInsets, view);
        int i3 = Build.VERSION.SDK_INT;
        w wVar = this.f15714c;
        if (i3 < 30) {
            n0.a(windowInsets, this.f15713b);
            if (h4.equals(this.f15712a)) {
                return wVar.P(view, h4).g();
            }
        }
        this.f15712a = h4;
        x1 P = wVar.P(view, h4);
        if (i3 >= 30) {
            return P.g();
        }
        WeakHashMap weakHashMap = z0.f15748a;
        l0.c(view);
        return P.g();
    }
}
