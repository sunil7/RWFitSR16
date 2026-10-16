package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.R$id;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public static final ab.g R = new ab.g(5, Float.class, "thumbPos");
    public static final int[] S = {R.attr.state_checked};
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public final TextPaint I;
    public final ColorStateList J;
    public StaticLayout K;
    public StaticLayout L;
    public final f.a M;
    public ObjectAnimator N;
    public a0 O;
    public k3 P;
    public final Rect Q;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f812a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f813b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f814c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f815d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f816f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f817g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f818h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f819i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f820j;

    /* renamed from: k, reason: collision with root package name */
    public int f821k;

    /* renamed from: l, reason: collision with root package name */
    public int f822l;

    /* renamed from: m, reason: collision with root package name */
    public int f823m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f824n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f825o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f826p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f827q;
    public CharSequence r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f828s;

    /* renamed from: t, reason: collision with root package name */
    public int f829t;

    /* renamed from: u, reason: collision with root package name */
    public final int f830u;

    /* renamed from: v, reason: collision with root package name */
    public float f831v;

    /* renamed from: w, reason: collision with root package name */
    public float f832w;

    /* renamed from: x, reason: collision with root package name */
    public final VelocityTracker f833x;

    /* renamed from: y, reason: collision with root package name */
    public final int f834y;

    /* renamed from: z, reason: collision with root package name */
    public float f835z;

    public SwitchCompat(Context context) {
        this(context, null);
    }

    private a0 getEmojiTextViewHelper() {
        if (this.O == null) {
            this.O = new a0(this);
        }
        return this.O;
    }

    private boolean getTargetCheckedState() {
        return this.f835z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((b4.a(this) ? 1.0f - this.f835z : this.f835z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f816f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.Q;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f812a;
        Rect b3 = drawable2 != null ? n1.b(drawable2) : n1.f1003c;
        return ((((this.A - this.C) - rect.left) - rect.right) - b3.left) - b3.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f827q = charSequence;
        a0 emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod e = ((com.google.android.gms.internal.mlkit_vision_common.b0) emojiTextViewHelper.f870b.f16254b).e(this.M);
        if (e != null) {
            charSequence = e.getTransformation(charSequence, this);
        }
        this.r = charSequence;
        this.L = null;
        if (this.f828s) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f825o = charSequence;
        a0 emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod e = ((com.google.android.gms.internal.mlkit_vision_common.b0) emojiTextViewHelper.f870b.f16254b).e(this.M);
        if (e != null) {
            charSequence = e.getTransformation(charSequence, this);
        }
        this.f826p = charSequence;
        this.K = null;
        if (this.f828s) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f812a;
        if (drawable != null) {
            if (this.f815d || this.e) {
                Drawable mutate = drawable.mutate();
                this.f812a = mutate;
                if (this.f815d) {
                    d1.b.h(mutate, this.f813b);
                }
                if (this.e) {
                    d1.b.i(this.f812a, this.f814c);
                }
                if (this.f812a.isStateful()) {
                    this.f812a.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f816f;
        if (drawable != null) {
            if (this.f819i || this.f820j) {
                Drawable mutate = drawable.mutate();
                this.f816f = mutate;
                if (this.f819i) {
                    d1.b.h(mutate, this.f817g);
                }
                if (this.f820j) {
                    d1.b.i(this.f816f, this.f818h);
                }
                if (this.f816f.isStateful()) {
                    this.f816f.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.f825o);
        setTextOffInternal(this.f827q);
        requestLayout();
    }

    public final void d() {
        if (this.P == null && ((com.google.android.gms.internal.mlkit_vision_common.b0) this.O.f870b.f16254b).b() && androidx.emoji2.text.k.f2036j != null) {
            androidx.emoji2.text.k a3 = androidx.emoji2.text.k.a();
            int b3 = a3.b();
            if (b3 == 3 || b3 == 0) {
                k3 k3Var = new k3(this);
                this.P = k3Var;
                a3.f(k3Var);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i3;
        int i10;
        int i11 = this.D;
        int i12 = this.E;
        int i13 = this.F;
        int i14 = this.G;
        int thumbOffset = getThumbOffset() + i11;
        Drawable drawable = this.f812a;
        Rect b3 = drawable != null ? n1.b(drawable) : n1.f1003c;
        Drawable drawable2 = this.f816f;
        Rect rect = this.Q;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i15 = rect.left;
            thumbOffset += i15;
            if (b3 != null) {
                int i16 = b3.left;
                if (i16 > i15) {
                    i11 += i16 - i15;
                }
                int i17 = b3.top;
                int i18 = rect.top;
                i3 = i17 > i18 ? (i17 - i18) + i12 : i12;
                int i19 = b3.right;
                int i20 = rect.right;
                if (i19 > i20) {
                    i13 -= i19 - i20;
                }
                int i21 = b3.bottom;
                int i22 = rect.bottom;
                if (i21 > i22) {
                    i10 = i14 - (i21 - i22);
                    this.f816f.setBounds(i11, i3, i13, i10);
                }
            } else {
                i3 = i12;
            }
            i10 = i14;
            this.f816f.setBounds(i11, i3, i13, i10);
        }
        Drawable drawable3 = this.f812a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i23 = thumbOffset - rect.left;
            int i24 = thumbOffset + this.C + rect.right;
            this.f812a.setBounds(i23, i12, i24, i14);
            Drawable background = getBackground();
            if (background != null) {
                d1.b.f(background, i23, i12, i24, i14);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f2, float f10) {
        super.drawableHotspotChanged(f2, f10);
        Drawable drawable = this.f812a;
        if (drawable != null) {
            d1.b.e(drawable, f2, f10);
        }
        Drawable drawable2 = this.f816f;
        if (drawable2 != null) {
            d1.b.e(drawable2, f2, f10);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f812a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f816f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!b4.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f823m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (b4.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f823m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return com.google.android.gms.internal.mlkit_common.m.d(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f828s;
    }

    public boolean getSplitTrack() {
        return this.f824n;
    }

    public int getSwitchMinWidth() {
        return this.f822l;
    }

    public int getSwitchPadding() {
        return this.f823m;
    }

    public CharSequence getTextOff() {
        return this.f827q;
    }

    public CharSequence getTextOn() {
        return this.f825o;
    }

    public Drawable getThumbDrawable() {
        return this.f812a;
    }

    public final float getThumbPosition() {
        return this.f835z;
    }

    public int getThumbTextPadding() {
        return this.f821k;
    }

    public ColorStateList getThumbTintList() {
        return this.f813b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f814c;
    }

    public Drawable getTrackDrawable() {
        return this.f816f;
    }

    public ColorStateList getTrackTintList() {
        return this.f817g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f818h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f812a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f816f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.N.end();
        this.N = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, S);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f816f;
        Rect rect = this.Q;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.E;
        int i10 = this.G;
        int i11 = i3 + rect.top;
        int i12 = i10 - rect.bottom;
        Drawable drawable2 = this.f812a;
        if (drawable != null) {
            if (!this.f824n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect b3 = n1.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += b3.left;
                rect.right -= b3.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.K : this.L;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.J;
            TextPaint textPaint = this.I;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i11 + i12) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f825o : this.f827q;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(text);
            sb2.append(' ');
            sb2.append(charSequence);
            accessibilityNodeInfo.setText(sb2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int i13;
        int width;
        int i14;
        int i15;
        int i16;
        super.onLayout(z5, i3, i10, i11, i12);
        int i17 = 0;
        if (this.f812a != null) {
            Drawable drawable = this.f816f;
            Rect rect = this.Q;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect b3 = n1.b(this.f812a);
            i13 = Math.max(0, b3.left - rect.left);
            i17 = Math.max(0, b3.right - rect.right);
        } else {
            i13 = 0;
        }
        if (b4.a(this)) {
            i14 = getPaddingLeft() + i13;
            width = ((this.A + i14) - i13) - i17;
        } else {
            width = (getWidth() - getPaddingRight()) - i17;
            i14 = (width - this.A) + i13 + i17;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i18 = this.B;
            int i19 = height - (i18 / 2);
            i15 = i18 + i19;
            i16 = i19;
        } else if (gravity != 80) {
            i16 = getPaddingTop();
            i15 = this.B + i16;
        } else {
            i15 = getHeight() - getPaddingBottom();
            i16 = i15 - this.B;
        }
        this.D = i14;
        this.E = i16;
        this.G = i15;
        this.F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i3, int i10) {
        int i11;
        int i12;
        int i13 = 0;
        if (this.f828s) {
            StaticLayout staticLayout = this.K;
            TextPaint textPaint = this.I;
            if (staticLayout == null) {
                CharSequence charSequence = this.f826p;
                this.K = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.L == null) {
                CharSequence charSequence2 = this.r;
                this.L = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f812a;
        Rect rect = this.Q;
        if (drawable != null) {
            drawable.getPadding(rect);
            i11 = (this.f812a.getIntrinsicWidth() - rect.left) - rect.right;
            i12 = this.f812a.getIntrinsicHeight();
        } else {
            i11 = 0;
            i12 = 0;
        }
        this.C = Math.max(this.f828s ? (this.f821k * 2) + Math.max(this.K.getWidth(), this.L.getWidth()) : 0, i11);
        Drawable drawable2 = this.f816f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i13 = this.f816f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i14 = rect.left;
        int i15 = rect.right;
        Drawable drawable3 = this.f812a;
        if (drawable3 != null) {
            Rect b3 = n1.b(drawable3);
            i14 = Math.max(i14, b3.left);
            i15 = Math.max(i15, b3.right);
        }
        int max = this.H ? Math.max(this.f822l, (this.C * 2) + i14 + i15) : this.f822l;
        int max2 = Math.max(i13, i12);
        this.A = max;
        this.B = max2;
        super.onMeasure(i3, i10);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f825o : this.f827q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r1 != 3) goto L82;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z5) {
        super.setAllCaps(z5);
        getEmojiTextViewHelper().c(z5);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z5) {
        super.setChecked(z5);
        boolean isChecked = isChecked();
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object obj = this.f825o;
                if (obj == null) {
                    obj = getResources().getString(R$string.abc_capital_on);
                }
                Object obj2 = obj;
                WeakHashMap weakHashMap = l1.z0.f15748a;
                new l1.d0(R$id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj2);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object obj3 = this.f827q;
            if (obj3 == null) {
                obj3 = getResources().getString(R$string.abc_capital_off);
            }
            Object obj4 = obj3;
            WeakHashMap weakHashMap2 = l1.z0.f15748a;
            new l1.d0(R$id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj4);
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap3 = l1.z0.f15748a;
            if (l1.k0.c(this)) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, R, isChecked ? 1.0f : 0.0f);
                this.N = ofFloat;
                ofFloat.setDuration(250L);
                j3.a(this.N, true);
                this.N.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        setThumbPosition(isChecked ? 1.0f : 0.0f);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(com.google.android.gms.internal.mlkit_common.m.e(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z5) {
        getEmojiTextViewHelper().d(z5);
        setTextOnInternal(this.f825o);
        setTextOffInternal(this.f827q);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z5) {
        this.H = z5;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z5) {
        if (this.f828s != z5) {
            this.f828s = z5;
            requestLayout();
            if (z5) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z5) {
        this.f824n = z5;
        invalidate();
    }

    public void setSwitchMinWidth(int i3) {
        this.f822l = i3;
        requestLayout();
    }

    public void setSwitchPadding(int i3) {
        this.f823m = i3;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.I;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object obj = this.f827q;
        if (obj == null) {
            obj = getResources().getString(R$string.abc_capital_off);
        }
        WeakHashMap weakHashMap = l1.z0.f15748a;
        new l1.d0(R$id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj);
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object obj = this.f825o;
        if (obj == null) {
            obj = getResources().getString(R$string.abc_capital_on);
        }
        WeakHashMap weakHashMap = l1.z0.f15748a;
        new l1.d0(R$id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f812a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f812a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f2) {
        this.f835z = f2;
        invalidate();
    }

    public void setThumbResource(int i3) {
        setThumbDrawable(pb.b(getContext(), i3));
    }

    public void setThumbTextPadding(int i3) {
        this.f821k = i3;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f813b = colorStateList;
        this.f815d = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f814c = mode;
        this.e = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f816f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f816f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i3) {
        setTrackDrawable(pb.b(getContext(), i3));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f817g = colorStateList;
        this.f819i = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f818h = mode;
        this.f820j = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f812a || drawable == this.f816f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Typeface typeface;
        Typeface create;
        int resourceId;
        this.f813b = null;
        this.f814c = null;
        this.f815d = false;
        this.e = false;
        this.f817g = null;
        this.f818h = null;
        this.f819i = false;
        this.f820j = false;
        this.f833x = VelocityTracker.obtain();
        this.H = true;
        this.Q = new Rect();
        l3.a(getContext(), this);
        TextPaint textPaint = new TextPaint(1);
        this.I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        de.o I = de.o.I(context, attributeSet, R$styleable.SwitchCompat, i3);
        l1.z0.m(this, context, R$styleable.SwitchCompat, attributeSet, (TypedArray) I.f12378c, i3);
        Drawable w8 = I.w(R$styleable.SwitchCompat_android_thumb);
        this.f812a = w8;
        if (w8 != null) {
            w8.setCallback(this);
        }
        Drawable w9 = I.w(R$styleable.SwitchCompat_track);
        this.f816f = w9;
        if (w9 != null) {
            w9.setCallback(this);
        }
        int i10 = R$styleable.SwitchCompat_android_textOn;
        TypedArray typedArray = (TypedArray) I.f12378c;
        setTextOnInternal(typedArray.getText(i10));
        setTextOffInternal(typedArray.getText(R$styleable.SwitchCompat_android_textOff));
        this.f828s = typedArray.getBoolean(R$styleable.SwitchCompat_showText, true);
        this.f821k = typedArray.getDimensionPixelSize(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.f822l = typedArray.getDimensionPixelSize(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.f823m = typedArray.getDimensionPixelSize(R$styleable.SwitchCompat_switchPadding, 0);
        this.f824n = typedArray.getBoolean(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList v6 = I.v(R$styleable.SwitchCompat_thumbTint);
        if (v6 != null) {
            this.f813b = v6;
            this.f815d = true;
        }
        PorterDuff.Mode c9 = n1.c(typedArray.getInt(R$styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f814c != c9) {
            this.f814c = c9;
            this.e = true;
        }
        if (this.f815d || this.e) {
            a();
        }
        ColorStateList v9 = I.v(R$styleable.SwitchCompat_trackTint);
        if (v9 != null) {
            this.f817g = v9;
            this.f819i = true;
        }
        PorterDuff.Mode c10 = n1.c(typedArray.getInt(R$styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f818h != c10) {
            this.f818h = c10;
            this.f820j = true;
        }
        if (this.f819i || this.f820j) {
            b();
        }
        int resourceId2 = typedArray.getResourceId(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId2 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId2, R$styleable.TextAppearance);
            int i11 = R$styleable.TextAppearance_android_textColor;
            ColorStateList colorStateList = (!obtainStyledAttributes.hasValue(i11) || (resourceId = obtainStyledAttributes.getResourceId(i11, 0)) == 0 || (colorStateList = pb.a(context, resourceId)) == null) ? obtainStyledAttributes.getColorStateList(i11) : colorStateList;
            if (colorStateList != null) {
                this.J = colorStateList;
            } else {
                this.J = getTextColors();
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, 0);
            if (dimensionPixelSize != 0) {
                float f2 = dimensionPixelSize;
                if (f2 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f2);
                    requestLayout();
                }
            }
            int i12 = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, -1);
            int i13 = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, -1);
            if (i12 == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (i12 != 2) {
                typeface = i12 != 3 ? null : Typeface.MONOSPACE;
            } else {
                typeface = Typeface.SERIF;
            }
            if (i13 > 0) {
                if (typeface == null) {
                    create = Typeface.defaultFromStyle(i13);
                } else {
                    create = Typeface.create(typeface, i13);
                }
                setSwitchTypeface(create);
                int i14 = (~(create != null ? create.getStyle() : 0)) & i13;
                textPaint.setFakeBoldText((i14 & 1) != 0);
                textPaint.setTextSkewX((i14 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false)) {
                Context context2 = getContext();
                f.a aVar = new f.a();
                aVar.f12634a = context2.getResources().getConfiguration().locale;
                this.M = aVar;
            } else {
                this.M = null;
            }
            setTextOnInternal(this.f825o);
            setTextOffInternal(this.f827q);
            obtainStyledAttributes.recycle();
        }
        new x0(this).f(attributeSet, i3);
        I.K();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f830u = viewConfiguration.getScaledTouchSlop();
        this.f834y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, i3);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
