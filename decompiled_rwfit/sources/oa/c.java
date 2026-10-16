package oa;

import android.view.View;

/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.example.test.ui.dialog.c f16907a;

    public c(com.example.test.ui.dialog.c cVar) {
        this.f16907a = cVar;
    }

    @Override // oa.b
    public final void a(View view) {
    }

    @Override // oa.b
    public final void b(int i3, View view) {
        if (i3 == 5) {
            this.f16907a.cancel();
        }
    }
}
