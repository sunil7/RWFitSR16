package j2;

import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.transition.R$id;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k extends g0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15243a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Object f15244b;

    /* renamed from: c, reason: collision with root package name */
    public Object f15245c;

    public /* synthetic */ k() {
    }

    @Override // j2.g0, j2.e0
    public void b() {
        switch (this.f15243a) {
            case 0:
                ((w) this.f15245c).setVisibility(4);
                break;
        }
    }

    @Override // j2.g0, j2.e0
    public void c() {
        switch (this.f15243a) {
            case 0:
                ((w) this.f15245c).setVisibility(0);
                break;
        }
    }

    @Override // j2.e0
    public final void e(f0 f0Var) {
        switch (this.f15243a) {
            case 0:
                f0Var.w(this);
                int i3 = Build.VERSION.SDK_INT;
                View view = (View) this.f15244b;
                if (i3 == 28) {
                    if (!g9.a.f13902g) {
                        try {
                            g9.a.b();
                            Method declaredMethod = g9.a.f13898b.getDeclaredMethod("removeGhost", View.class);
                            g9.a.f13901f = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e);
                        }
                        g9.a.f13902g = true;
                    }
                    Method method = g9.a.f13901f;
                    if (method != null) {
                        try {
                            method.invoke(null, view);
                        } catch (IllegalAccessException unused) {
                        } catch (InvocationTargetException e10) {
                            throw new RuntimeException(e10.getCause());
                        }
                    }
                } else {
                    int i10 = z.f15311g;
                    z zVar = (z) view.getTag(R$id.ghost_view);
                    if (zVar != null) {
                        int i11 = zVar.f15315d - 1;
                        zVar.f15315d = i11;
                        if (i11 <= 0) {
                            ((x) zVar.getParent()).removeView(zVar);
                        }
                    }
                }
                view.setTag(R$id.transition_transform, null);
                view.setTag(R$id.parent_matrix, null);
                return;
            default:
                ((ArrayList) ((m0.b) this.f15244b).getOrDefault(((h0) this.f15245c).f15226b, null)).remove(f0Var);
                f0Var.w(this);
                return;
        }
    }

    public k(h0 h0Var, m0.b bVar) {
        this.f15245c = h0Var;
        this.f15244b = bVar;
    }
}
