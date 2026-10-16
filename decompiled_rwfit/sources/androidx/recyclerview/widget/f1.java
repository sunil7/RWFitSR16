package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class f1 {

    /* renamed from: a, reason: collision with root package name */
    public x0 f2561a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f2562b;

    /* renamed from: c, reason: collision with root package name */
    public long f2563c;

    /* renamed from: d, reason: collision with root package name */
    public long f2564d;
    public long e;

    /* renamed from: f, reason: collision with root package name */
    public long f2565f;

    public static void b(z1 z1Var) {
        int i3 = z1Var.mFlags;
        if (!z1Var.isInvalid() && (i3 & 4) == 0) {
            z1Var.getOldPosition();
            z1Var.getAbsoluteAdapterPosition();
        }
    }

    public abstract boolean a(z1 z1Var, z1 z1Var2, e1 e1Var, e1 e1Var2);

    public final void c(z1 z1Var) {
        x0 x0Var = this.f2561a;
        if (x0Var != null) {
            boolean z5 = true;
            z1Var.setIsRecyclable(true);
            if (z1Var.mShadowedHolder != null && z1Var.mShadowingHolder == null) {
                z1Var.mShadowedHolder = null;
            }
            z1Var.mShadowingHolder = null;
            if (z1Var.shouldBeKeptAsChild()) {
                return;
            }
            View view = z1Var.itemView;
            RecyclerView recyclerView = x0Var.f2801a;
            recyclerView.j0();
            de.o oVar = recyclerView.e;
            x0 x0Var2 = (x0) oVar.f12377b;
            int indexOfChild = x0Var2.f2801a.indexOfChild(view);
            if (indexOfChild == -1) {
                oVar.M(view);
            } else {
                e eVar = (e) oVar.f12378c;
                if (eVar.d(indexOfChild)) {
                    eVar.f(indexOfChild);
                    oVar.M(view);
                    x0Var2.g(indexOfChild);
                } else {
                    z5 = false;
                }
            }
            if (z5) {
                z1 L = RecyclerView.L(view);
                q1 q1Var = recyclerView.f2446b;
                q1Var.j(L);
                q1Var.g(L);
            }
            recyclerView.k0(!z5);
            if (z5 || !z1Var.isTmpDetached()) {
                return;
            }
            recyclerView.removeDetachedView(z1Var.itemView, false);
        }
    }

    public abstract void d(z1 z1Var);

    public abstract void e();

    public abstract boolean f();
}
