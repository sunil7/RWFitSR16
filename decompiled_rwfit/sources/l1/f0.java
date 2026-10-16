package l1;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public int f15694a;

    /* renamed from: b, reason: collision with root package name */
    public int f15695b;

    /* renamed from: c, reason: collision with root package name */
    public int f15696c;

    /* renamed from: d, reason: collision with root package name */
    public Object f15697d;

    public f0() {
        if (ec.a.f12586b == null) {
            ec.a.f12586b = new ec.a(19);
        }
    }

    public int a(int i3) {
        if (i3 < this.f15696c) {
            return ((ByteBuffer) this.f15697d).getShort(this.f15695b + i3);
        }
        return 0;
    }

    public abstract Object b(View view);

    public abstract void c(View view, Object obj);

    public void d(View view, Object obj) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.f15695b) {
            c(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f15695b) {
            tag = b(view);
        } else {
            tag = view.getTag(this.f15694a);
            if (!((Class) this.f15697d).isInstance(tag)) {
                tag = null;
            }
        }
        if (e(tag, obj)) {
            View.AccessibilityDelegate d5 = z0.d(view);
            c cVar = d5 == null ? null : d5 instanceof a ? ((a) d5).f15676a : new c(d5);
            if (cVar == null) {
                cVar = new c();
            }
            z0.n(view, cVar);
            view.setTag(this.f15694a, obj);
            z0.g(this.f15696c, view);
        }
    }

    public abstract boolean e(Object obj, Object obj2);
}
