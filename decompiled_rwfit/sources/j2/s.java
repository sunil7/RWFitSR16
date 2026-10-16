package j2;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class s implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f15286a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f15287b;

    public s(View view, ArrayList arrayList) {
        this.f15286a = view;
        this.f15287b = arrayList;
    }

    @Override // j2.e0
    public final void a(f0 f0Var) {
        f0Var.w(this);
        f0Var.a(this);
    }

    @Override // j2.e0
    public final void b() {
    }

    @Override // j2.e0
    public final void c() {
    }

    @Override // j2.e0
    public final void d() {
    }

    @Override // j2.e0
    public final void e(f0 f0Var) {
        f0Var.w(this);
        this.f15286a.setVisibility(8);
        ArrayList arrayList = this.f15287b;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((View) arrayList.get(i3)).setVisibility(0);
        }
    }
}
