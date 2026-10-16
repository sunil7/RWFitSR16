package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R$attr;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;

/* loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: a, reason: collision with root package name */
    public final x f689a;

    /* renamed from: b, reason: collision with root package name */
    public final w f690b;

    /* renamed from: c, reason: collision with root package name */
    public final x0 f691c;

    /* renamed from: d, reason: collision with root package name */
    public a0 f692d;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    private a0 getEmojiTextViewHelper() {
        if (this.f692d == null) {
            this.f692d = new a0(this);
        }
        return this.f692d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        x0 x0Var = this.f691c;
        if (x0Var != null) {
            x0Var.b();
        }
        w wVar = this.f690b;
        if (wVar != null) {
            wVar.a();
        }
        x xVar = this.f689a;
        if (xVar != null) {
            xVar.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return com.google.android.gms.internal.mlkit_common.m.d(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f690b;
        if (wVar != null) {
            return wVar.i();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f690b;
        if (wVar != null) {
            return wVar.j();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        x xVar = this.f689a;
        if (xVar != null) {
            return xVar.f1083a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        x xVar = this.f689a;
        if (xVar != null) {
            return xVar.f1084b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f691c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f691c.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        ca.f.a(editorInfo, onCreateInputConnection, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z5) {
        super.setAllCaps(z5);
        getEmojiTextViewHelper().c(z5);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f690b;
        if (wVar != null) {
            wVar.n();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        w wVar = this.f690b;
        if (wVar != null) {
            wVar.o(i3);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        x xVar = this.f689a;
        if (xVar != null) {
            if (xVar.e) {
                xVar.e = false;
            } else {
                xVar.e = true;
                xVar.b();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        x0 x0Var = this.f691c;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        x0 x0Var = this.f691c;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(com.google.android.gms.internal.mlkit_common.m.e(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z5) {
        getEmojiTextViewHelper().d(z5);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        w wVar = this.f690b;
        if (wVar != null) {
            wVar.t(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        w wVar = this.f690b;
        if (wVar != null) {
            wVar.u(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        x xVar = this.f689a;
        if (xVar != null) {
            xVar.f1083a = colorStateList;
            xVar.f1085c = true;
            xVar.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        x xVar = this.f689a;
        if (xVar != null) {
            xVar.f1084b = mode;
            xVar.f1086d = true;
            xVar.b();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        x0 x0Var = this.f691c;
        x0Var.l(colorStateList);
        x0Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        x0 x0Var = this.f691c;
        x0Var.m(mode);
        x0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        x0 x0Var = this.f691c;
        if (x0Var != null) {
            x0Var.g(context, i3);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkedTextViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x008d A[Catch: all -> 0x0067, TryCatch #1 {all -> 0x0067, blocks: (B:3:0x004a, B:5:0x0053, B:8:0x005b, B:9:0x0085, B:11:0x008d, B:12:0x0096, B:14:0x009e, B:21:0x006a, B:23:0x0072, B:25:0x007a), top: B:2:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009e A[Catch: all -> 0x0067, TRY_LEAVE, TryCatch #1 {all -> 0x0067, blocks: (B:3:0x004a, B:5:0x0053, B:8:0x005b, B:9:0x0085, B:11:0x008d, B:12:0x0096, B:14:0x009e, B:21:0x006a, B:23:0x0072, B:25:0x007a), top: B:2:0x004a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatCheckedTextView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            androidx.appcompat.widget.m3.a(r8)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            androidx.appcompat.widget.l3.a(r8, r7)
            androidx.appcompat.widget.x0 r8 = new androidx.appcompat.widget.x0
            r8.<init>(r7)
            r7.f691c = r8
            r8.f(r9, r10)
            r8.b()
            androidx.appcompat.widget.w r8 = new androidx.appcompat.widget.w
            r8.<init>(r7)
            r7.f690b = r8
            r8.l(r9, r10)
            androidx.appcompat.widget.x r8 = new androidx.appcompat.widget.x
            r8.<init>(r7)
            r7.f689a = r8
            android.content.Context r8 = r7.getContext()
            int[] r0 = androidx.appcompat.R$styleable.CheckedTextView
            de.o r8 = de.o.I(r8, r9, r0, r10)
            java.lang.Object r0 = r8.f12378c
            android.content.res.TypedArray r0 = (android.content.res.TypedArray) r0
            android.content.Context r2 = r7.getContext()
            int[] r3 = androidx.appcompat.R$styleable.CheckedTextView
            java.lang.Object r1 = r8.f12378c
            r5 = r1
            android.content.res.TypedArray r5 = (android.content.res.TypedArray) r5
            r1 = r7
            r4 = r9
            r6 = r10
            l1.z0.m(r1, r2, r3, r4, r5, r6)
            int r9 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkCompat     // Catch: java.lang.Throwable -> L67
            boolean r9 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L67
            r10 = 0
            if (r9 == 0) goto L6a
            int r9 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkCompat     // Catch: java.lang.Throwable -> L67
            int r9 = r0.getResourceId(r9, r10)     // Catch: java.lang.Throwable -> L67
            if (r9 == 0) goto L6a
            android.content.Context r2 = r7.getContext()     // Catch: java.lang.Throwable -> L67 android.content.res.Resources.NotFoundException -> L6a
            android.graphics.drawable.Drawable r9 = com.google.android.gms.internal.mlkit_vision_barcode.pb.b(r2, r9)     // Catch: java.lang.Throwable -> L67 android.content.res.Resources.NotFoundException -> L6a
            r7.setCheckMarkDrawable(r9)     // Catch: java.lang.Throwable -> L67 android.content.res.Resources.NotFoundException -> L6a
            goto L85
        L67:
            r0 = move-exception
            r9 = r0
            goto Lb8
        L6a:
            int r9 = androidx.appcompat.R$styleable.CheckedTextView_android_checkMark     // Catch: java.lang.Throwable -> L67
            boolean r9 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L67
            if (r9 == 0) goto L85
            int r9 = androidx.appcompat.R$styleable.CheckedTextView_android_checkMark     // Catch: java.lang.Throwable -> L67
            int r9 = r0.getResourceId(r9, r10)     // Catch: java.lang.Throwable -> L67
            if (r9 == 0) goto L85
            android.content.Context r10 = r7.getContext()     // Catch: java.lang.Throwable -> L67
            android.graphics.drawable.Drawable r9 = com.google.android.gms.internal.mlkit_vision_barcode.pb.b(r10, r9)     // Catch: java.lang.Throwable -> L67
            r7.setCheckMarkDrawable(r9)     // Catch: java.lang.Throwable -> L67
        L85:
            int r9 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkTint     // Catch: java.lang.Throwable -> L67
            boolean r9 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L67
            if (r9 == 0) goto L96
            int r9 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkTint     // Catch: java.lang.Throwable -> L67
            android.content.res.ColorStateList r9 = r8.v(r9)     // Catch: java.lang.Throwable -> L67
            r7.setCheckMarkTintList(r9)     // Catch: java.lang.Throwable -> L67
        L96:
            int r9 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkTintMode     // Catch: java.lang.Throwable -> L67
            boolean r9 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L67
            if (r9 == 0) goto Lad
            int r9 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkTintMode     // Catch: java.lang.Throwable -> L67
            r10 = -1
            int r9 = r0.getInt(r9, r10)     // Catch: java.lang.Throwable -> L67
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = androidx.appcompat.widget.n1.c(r9, r10)     // Catch: java.lang.Throwable -> L67
            r7.setCheckMarkTintMode(r9)     // Catch: java.lang.Throwable -> L67
        Lad:
            r8.K()
            androidx.appcompat.widget.a0 r8 = r7.getEmojiTextViewHelper()
            r8.b(r4, r6)
            return
        Lb8:
            r8.K()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCheckedTextView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i3) {
        setCheckMarkDrawable(pb.b(getContext(), i3));
    }
}
