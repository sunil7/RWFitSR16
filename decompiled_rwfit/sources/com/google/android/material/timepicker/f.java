package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* loaded from: classes.dex */
public final class f implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final int f10981a;

    public f(int i3) {
        this.f10981a = i3;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i3, int i10, Spanned spanned, int i11, int i12) {
        try {
            StringBuilder sb2 = new StringBuilder(spanned);
            sb2.replace(i11, i12, charSequence.subSequence(i3, i10).toString());
            if (Integer.parseInt(sb2.toString()) <= this.f10981a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
