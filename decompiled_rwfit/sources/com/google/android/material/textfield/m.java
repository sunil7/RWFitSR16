package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f10921a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f10922b;

    /* renamed from: c, reason: collision with root package name */
    public final CheckableImageButton f10923c;

    public m(TextInputLayout textInputLayout) {
        this.f10921a = textInputLayout;
        this.f10922b = textInputLayout.getContext();
        this.f10923c = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public boolean b(int i3) {
        return true;
    }

    public void c(boolean z5) {
    }
}
