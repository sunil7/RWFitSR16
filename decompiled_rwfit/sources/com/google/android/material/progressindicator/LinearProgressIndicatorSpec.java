package com.google.android.material.progressindicator;

import ab.d;
import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;

/* loaded from: classes.dex */
public final class LinearProgressIndicatorSpec extends d {

    /* renamed from: g, reason: collision with root package name */
    public int f10721g;

    /* renamed from: h, reason: collision with root package name */
    public int f10722h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10723i;

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    @Override // ab.d
    public final void a() {
        if (this.f10721g == 0) {
            if (this.f152b > 0) {
                throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
            }
            if (this.f153c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public LinearProgressIndicatorSpec(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.progressindicator.LinearProgressIndicator.f10720m
            r6.<init>(r7, r8, r9, r4)
            int[] r2 = com.google.android.material.R$styleable.LinearProgressIndicator
            int r3 = com.google.android.material.R$attr.linearProgressIndicatorStyle
            r9 = 0
            int[] r5 = new int[r9]
            com.google.android.material.internal.w.a(r7, r8, r3, r4)
            r0 = r7
            r1 = r8
            com.google.android.material.internal.w.b(r0, r1, r2, r3, r4, r5)
            android.content.res.TypedArray r7 = r0.obtainStyledAttributes(r1, r2, r3, r4)
            int r8 = com.google.android.material.R$styleable.LinearProgressIndicator_indeterminateAnimationType
            r0 = 1
            int r8 = r7.getInt(r8, r0)
            r6.f10721g = r8
            int r8 = com.google.android.material.R$styleable.LinearProgressIndicator_indicatorDirectionLinear
            int r8 = r7.getInt(r8, r9)
            r6.f10722h = r8
            r7.recycle()
            r6.a()
            int r7 = r6.f10722h
            if (r7 != r0) goto L34
            r9 = r0
        L34:
            r6.f10723i = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.progressindicator.LinearProgressIndicatorSpec.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
