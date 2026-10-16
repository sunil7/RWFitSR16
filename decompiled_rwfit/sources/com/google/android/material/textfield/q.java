package com.google.android.material.textfield;

/* loaded from: classes.dex */
public final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10949a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f10950b;

    public /* synthetic */ q(TextInputLayout textInputLayout, int i3) {
        this.f10949a = i3;
        this.f10950b = textInputLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10949a) {
            case 0:
                TextInputLayout textInputLayout = this.f10950b;
                textInputLayout.f10849h0.performClick();
                textInputLayout.f10849h0.jumpDrawablesToCurrentState();
                break;
            default:
                this.f10950b.e.requestLayout();
                break;
        }
    }
}
