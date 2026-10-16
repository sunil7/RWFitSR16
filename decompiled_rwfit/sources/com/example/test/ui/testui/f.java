package com.example.test.ui.testui;

import android.widget.LinearLayout;

/* loaded from: classes.dex */
public final class f implements n2.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8272a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f8273b;

    public /* synthetic */ f(LinearLayout linearLayout, int i3) {
        this.f8272a = i3;
        this.f8273b = linearLayout;
    }

    private final void c(int i3) {
    }

    private final void e(int i3) {
    }

    private final void f(int i3) {
    }

    private final void g(int i3) {
    }

    @Override // n2.j
    public final void a(int i3) {
        int i10 = this.f8272a;
    }

    @Override // n2.j
    public final void b(int i3) {
        int i10 = this.f8272a;
    }

    @Override // n2.j
    public final void d(float f2, int i3) {
        switch (this.f8272a) {
            case 0:
                ((TMainBottomSleepTabView) this.f8273b).setTabPosition(i3);
                break;
            default:
                ((TMainBottomTabView) this.f8273b).setTabPosition(i3);
                break;
        }
    }
}
