package ka;

import android.view.View;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final View f15587a;

    /* renamed from: b, reason: collision with root package name */
    public int f15588b;

    /* renamed from: c, reason: collision with root package name */
    public int f15589c;

    /* renamed from: d, reason: collision with root package name */
    public int f15590d;

    public h(View view) {
        this.f15587a = view;
    }

    public final void a() {
        int i3 = this.f15590d;
        View view = this.f15587a;
        int top = i3 - (view.getTop() - this.f15588b);
        WeakHashMap weakHashMap = z0.f15748a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f15589c));
    }

    public final boolean b(int i3) {
        if (this.f15590d == i3) {
            return false;
        }
        this.f15590d = i3;
        a();
        return true;
    }
}
