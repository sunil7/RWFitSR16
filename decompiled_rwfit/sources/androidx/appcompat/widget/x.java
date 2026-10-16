package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public ColorStateList f1083a = null;

    /* renamed from: b, reason: collision with root package name */
    public PorterDuff.Mode f1084b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1085c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1086d = false;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f1087f;

    public /* synthetic */ x(TextView textView) {
        this.f1087f = textView;
    }

    public void a() {
        CompoundButton compoundButton = (CompoundButton) this.f1087f;
        Drawable a3 = androidx.core.widget.c.a(compoundButton);
        if (a3 != null) {
            if (this.f1085c || this.f1086d) {
                Drawable mutate = a3.mutate();
                if (this.f1085c) {
                    d1.b.h(mutate, this.f1083a);
                }
                if (this.f1086d) {
                    d1.b.i(mutate, this.f1084b);
                }
                if (mutate.isStateful()) {
                    mutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(mutate);
            }
        }
    }

    public void b() {
        AppCompatCheckedTextView appCompatCheckedTextView = (AppCompatCheckedTextView) this.f1087f;
        Drawable checkMarkDrawable = appCompatCheckedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f1085c || this.f1086d) {
                Drawable mutate = checkMarkDrawable.mutate();
                if (this.f1085c) {
                    d1.b.h(mutate, this.f1083a);
                }
                if (this.f1086d) {
                    d1.b.i(mutate, this.f1084b);
                }
                if (mutate.isStateful()) {
                    mutate.setState(appCompatCheckedTextView.getDrawableState());
                }
                appCompatCheckedTextView.setCheckMarkDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0023, B:5:0x002c, B:8:0x0034, B:9:0x005e, B:11:0x0066, B:12:0x006f, B:14:0x0077, B:21:0x0043, B:23:0x004b, B:25:0x0053), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0023, B:5:0x002c, B:8:0x0034, B:9:0x005e, B:11:0x0066, B:12:0x006f, B:14:0x0077, B:21:0x0043, B:23:0x004b, B:25:0x0053), top: B:2:0x0023 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            android.widget.TextView r0 = r8.f1087f
            r1 = r0
            android.widget.CompoundButton r1 = (android.widget.CompoundButton) r1
            android.content.Context r0 = r1.getContext()
            int[] r2 = androidx.appcompat.R$styleable.CompoundButton
            de.o r7 = de.o.I(r0, r9, r2, r10)
            java.lang.Object r0 = r7.f12378c
            android.content.res.TypedArray r0 = (android.content.res.TypedArray) r0
            android.content.Context r2 = r1.getContext()
            int[] r3 = androidx.appcompat.R$styleable.CompoundButton
            java.lang.Object r4 = r7.f12378c
            r5 = r4
            android.content.res.TypedArray r5 = (android.content.res.TypedArray) r5
            r4 = r9
            r6 = r10
            l1.z0.m(r1, r2, r3, r4, r5, r6)
            int r9 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L40
            boolean r9 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L40
            r10 = 0
            if (r9 == 0) goto L43
            int r9 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L40
            int r9 = r0.getResourceId(r9, r10)     // Catch: java.lang.Throwable -> L40
            if (r9 == 0) goto L43
            android.content.Context r2 = r1.getContext()     // Catch: java.lang.Throwable -> L40 android.content.res.Resources.NotFoundException -> L43
            android.graphics.drawable.Drawable r9 = com.google.android.gms.internal.mlkit_vision_barcode.pb.b(r2, r9)     // Catch: java.lang.Throwable -> L40 android.content.res.Resources.NotFoundException -> L43
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L40 android.content.res.Resources.NotFoundException -> L43
            goto L5e
        L40:
            r0 = move-exception
            r9 = r0
            goto L8a
        L43:
            int r9 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch: java.lang.Throwable -> L40
            boolean r9 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L40
            if (r9 == 0) goto L5e
            int r9 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch: java.lang.Throwable -> L40
            int r9 = r0.getResourceId(r9, r10)     // Catch: java.lang.Throwable -> L40
            if (r9 == 0) goto L5e
            android.content.Context r10 = r1.getContext()     // Catch: java.lang.Throwable -> L40
            android.graphics.drawable.Drawable r9 = com.google.android.gms.internal.mlkit_vision_barcode.pb.b(r10, r9)     // Catch: java.lang.Throwable -> L40
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L40
        L5e:
            int r9 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L40
            boolean r9 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L40
            if (r9 == 0) goto L6f
            int r9 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L40
            android.content.res.ColorStateList r9 = r7.v(r9)     // Catch: java.lang.Throwable -> L40
            androidx.core.widget.b.c(r1, r9)     // Catch: java.lang.Throwable -> L40
        L6f:
            int r9 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L40
            boolean r9 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L40
            if (r9 == 0) goto L86
            int r9 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L40
            r10 = -1
            int r9 = r0.getInt(r9, r10)     // Catch: java.lang.Throwable -> L40
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = androidx.appcompat.widget.n1.c(r9, r10)     // Catch: java.lang.Throwable -> L40
            androidx.core.widget.b.d(r1, r9)     // Catch: java.lang.Throwable -> L40
        L86:
            r7.K()
            return
        L8a:
            r7.K()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.x.c(android.util.AttributeSet, int):void");
    }
}
