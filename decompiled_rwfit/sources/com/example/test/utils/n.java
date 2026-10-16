package com.example.test.utils;

import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public final class n extends q4.e {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f8736d;
    public final /* synthetic */ ConstraintLayout e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(ConstraintLayout constraintLayout, int i3) {
        super(constraintLayout);
        this.f8736d = i3;
        this.e = constraintLayout;
    }

    @Override // q4.g
    public final void b(Drawable drawable) {
        switch (this.f8736d) {
            case 0:
                this.e.setBackground(drawable);
                break;
            default:
                this.e.setBackground(drawable);
                break;
        }
    }

    @Override // q4.g
    public final void h(Object obj) {
        switch (this.f8736d) {
            case 0:
                this.e.setBackground((Drawable) obj);
                break;
            default:
                this.e.setBackground((Drawable) obj);
                break;
        }
    }

    @Override // q4.e
    public final void j(Drawable drawable) {
        switch (this.f8736d) {
            case 0:
                this.e.setBackground(drawable);
                break;
            default:
                this.e.setBackground(drawable);
                break;
        }
    }
}
