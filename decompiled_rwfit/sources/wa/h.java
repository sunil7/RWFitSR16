package wa;

import com.example.test.ui.device.activity.i0;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final i0 f19550a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FloatingActionButton f19551b;

    public h(FloatingActionButton floatingActionButton, i0 i0Var) {
        this.f19551b = floatingActionButton;
        this.f19550a = i0Var;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof h) && ((h) obj).f19550a.equals(this.f19550a);
    }

    public final int hashCode() {
        return this.f19550a.hashCode();
    }
}
