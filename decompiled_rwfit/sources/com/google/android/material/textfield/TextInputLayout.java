package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.n1;
import androidx.appcompat.widget.s2;
import androidx.appcompat.widget.y;
import androidx.customview.view.AbsSavedState;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.s0;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import l1.g0;
import l1.h0;
import l1.i0;
import l1.k0;
import l1.z0;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: v1, reason: collision with root package name */
    public static final int f10828v1 = R$style.Widget_Design_TextInputLayout;
    public boolean A;
    public CharSequence B;
    public boolean C;
    public eb.h D;
    public eb.h E;
    public final eb.m F;
    public final int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public final Rect P;
    public final Rect Q;
    public final RectF R;
    public Typeface S;
    public final CheckableImageButton T;
    public ColorStateList U;
    public PorterDuff.Mode U0;
    public boolean V;
    public boolean V0;
    public PorterDuff.Mode W;
    public ColorDrawable W0;
    public int X0;
    public Drawable Y0;
    public View.OnLongClickListener Z0;

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f10829a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f10830a0;

    /* renamed from: a1, reason: collision with root package name */
    public View.OnLongClickListener f10831a1;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f10832b;

    /* renamed from: b0, reason: collision with root package name */
    public ColorDrawable f10833b0;

    /* renamed from: b1, reason: collision with root package name */
    public final CheckableImageButton f10834b1;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f10835c;

    /* renamed from: c0, reason: collision with root package name */
    public int f10836c0;

    /* renamed from: c1, reason: collision with root package name */
    public ColorStateList f10837c1;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f10838d;

    /* renamed from: d0, reason: collision with root package name */
    public View.OnLongClickListener f10839d0;

    /* renamed from: d1, reason: collision with root package name */
    public ColorStateList f10840d1;
    public EditText e;

    /* renamed from: e0, reason: collision with root package name */
    public final LinkedHashSet f10841e0;

    /* renamed from: e1, reason: collision with root package name */
    public ColorStateList f10842e1;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f10843f;

    /* renamed from: f0, reason: collision with root package name */
    public int f10844f0;
    public int f1;

    /* renamed from: g, reason: collision with root package name */
    public int f10845g;

    /* renamed from: g0, reason: collision with root package name */
    public final SparseArray f10846g0;

    /* renamed from: g1, reason: collision with root package name */
    public int f10847g1;

    /* renamed from: h, reason: collision with root package name */
    public int f10848h;

    /* renamed from: h0, reason: collision with root package name */
    public final CheckableImageButton f10849h0;

    /* renamed from: h1, reason: collision with root package name */
    public int f10850h1;

    /* renamed from: i, reason: collision with root package name */
    public final o f10851i;
    public final LinkedHashSet i0;

    /* renamed from: i1, reason: collision with root package name */
    public ColorStateList f10852i1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10853j;

    /* renamed from: j0, reason: collision with root package name */
    public ColorStateList f10854j0;

    /* renamed from: j1, reason: collision with root package name */
    public int f10855j1;

    /* renamed from: k, reason: collision with root package name */
    public int f10856k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f10857k0;

    /* renamed from: k1, reason: collision with root package name */
    public int f10858k1;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10859l;

    /* renamed from: l1, reason: collision with root package name */
    public int f10860l1;

    /* renamed from: m, reason: collision with root package name */
    public AppCompatTextView f10861m;

    /* renamed from: m1, reason: collision with root package name */
    public int f10862m1;

    /* renamed from: n, reason: collision with root package name */
    public int f10863n;

    /* renamed from: n1, reason: collision with root package name */
    public int f10864n1;

    /* renamed from: o, reason: collision with root package name */
    public int f10865o;

    /* renamed from: o1, reason: collision with root package name */
    public boolean f10866o1;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f10867p;

    /* renamed from: p1, reason: collision with root package name */
    public final com.google.android.material.internal.b f10868p1;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10869q;

    /* renamed from: q1, reason: collision with root package name */
    public boolean f10870q1;
    public AppCompatTextView r;

    /* renamed from: r1, reason: collision with root package name */
    public boolean f10871r1;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f10872s;

    /* renamed from: s1, reason: collision with root package name */
    public ValueAnimator f10873s1;

    /* renamed from: t, reason: collision with root package name */
    public int f10874t;

    /* renamed from: t1, reason: collision with root package name */
    public boolean f10875t1;

    /* renamed from: u, reason: collision with root package name */
    public ColorStateList f10876u;

    /* renamed from: u1, reason: collision with root package name */
    public boolean f10877u1;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f10878v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f10879w;

    /* renamed from: x, reason: collision with root package name */
    public final AppCompatTextView f10880x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f10881y;

    /* renamed from: z, reason: collision with root package name */
    public final AppCompatTextView f10882z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new u();

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f10883a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10884b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f10885c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f10886d;
        public CharSequence e;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.f10883a = (CharSequence) creator.createFromParcel(parcel);
            this.f10884b = parcel.readInt() == 1;
            this.f10885c = (CharSequence) creator.createFromParcel(parcel);
            this.f10886d = (CharSequence) creator.createFromParcel(parcel);
            this.e = (CharSequence) creator.createFromParcel(parcel);
        }

        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f10883a) + " hint=" + ((Object) this.f10885c) + " helperText=" + ((Object) this.f10886d) + " placeholderText=" + ((Object) this.e) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            TextUtils.writeToParcel(this.f10883a, parcel, i3);
            parcel.writeInt(this.f10884b ? 1 : 0);
            TextUtils.writeToParcel(this.f10885c, parcel, i3);
            TextUtils.writeToParcel(this.f10886d, parcel, i3);
            TextUtils.writeToParcel(this.e, parcel, i3);
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public static void d(CheckableImageButton checkableImageButton, boolean z5, ColorStateList colorStateList, boolean z6, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z5 || z6)) {
            drawable = drawable.mutate();
            if (z5) {
                d1.b.h(drawable, colorStateList);
            }
            if (z6) {
                d1.b.i(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private m getEndIconDelegate() {
        SparseArray sparseArray = this.f10846g0;
        m mVar = (m) sparseArray.get(this.f10844f0);
        return mVar != null ? mVar : (m) sparseArray.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        CheckableImageButton checkableImageButton = this.f10834b1;
        if (checkableImageButton.getVisibility() == 0) {
            return checkableImageButton;
        }
        if (this.f10844f0 == 0 || !g()) {
            return null;
        }
        return this.f10849h0;
    }

    public static void j(ViewGroup viewGroup, boolean z5) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            childAt.setEnabled(z5);
            if (childAt instanceof ViewGroup) {
                j((ViewGroup) childAt, z5);
            }
        }
    }

    public static void l(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = z0.f15748a;
        boolean a3 = g0.a(checkableImageButton);
        boolean z5 = onLongClickListener != null;
        boolean z6 = a3 || z5;
        checkableImageButton.setFocusable(z6);
        checkableImageButton.setClickable(a3);
        checkableImageButton.setPressable(a3);
        checkableImageButton.setLongClickable(z5);
        h0.s(checkableImageButton, z6 ? 1 : 2);
    }

    private void setEditText(EditText editText) {
        boolean z5;
        boolean z6;
        if (this.e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.f10844f0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.e = editText;
        setMinWidth(this.f10845g);
        setMaxWidth(this.f10848h);
        h();
        setTextInputAccessibilityDelegate(new r(this));
        Typeface typeface = this.e.getTypeface();
        com.google.android.material.internal.b bVar = this.f10868p1;
        bb.b bVar2 = bVar.A;
        if (bVar2 != null) {
            bVar2.f3184c = true;
        }
        if (bVar.f10585w != typeface) {
            bVar.f10585w = typeface;
            z5 = true;
        } else {
            z5 = false;
        }
        bb.b bVar3 = bVar.f10588z;
        if (bVar3 != null) {
            bVar3.f3184c = true;
        }
        if (bVar.f10586x != typeface) {
            bVar.f10586x = typeface;
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 || z6) {
            bVar.i(false);
        }
        float textSize = this.e.getTextSize();
        if (bVar.f10576m != textSize) {
            bVar.f10576m = textSize;
            bVar.i(false);
        }
        int gravity = this.e.getGravity();
        bVar.l((gravity & Const.I_DEF_CGI_SIG) | 48);
        if (bVar.f10574k != gravity) {
            bVar.f10574k = gravity;
            bVar.i(false);
        }
        this.e.addTextChangedListener(new s2(this, 4));
        if (this.f10840d1 == null) {
            this.f10840d1 = this.e.getHintTextColors();
        }
        if (this.A) {
            if (TextUtils.isEmpty(this.B)) {
                CharSequence hint = this.e.getHint();
                this.f10843f = hint;
                setHint(hint);
                this.e.setHint((CharSequence) null);
            }
            this.C = true;
        }
        if (this.f10861m != null) {
            n(this.e.getText().length());
        }
        q();
        this.f10851i.b();
        this.f10832b.bringToFront();
        this.f10835c.bringToFront();
        this.f10838d.bringToFront();
        this.f10834b1.bringToFront();
        Iterator it = this.f10841e0.iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(this);
        }
        u();
        x();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        s(false, true);
    }

    private void setErrorIconVisible(boolean z5) {
        this.f10834b1.setVisibility(z5 ? 0 : 8);
        this.f10838d.setVisibility(z5 ? 8 : 0);
        x();
        if (this.f10844f0 != 0) {
            return;
        }
        p();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.B)) {
            return;
        }
        this.B = charSequence;
        com.google.android.material.internal.b bVar = this.f10868p1;
        if (charSequence == null || !TextUtils.equals(bVar.B, charSequence)) {
            bVar.B = charSequence;
            bVar.C = null;
            Bitmap bitmap = bVar.F;
            if (bitmap != null) {
                bitmap.recycle();
                bVar.F = null;
            }
            bVar.i(false);
        }
        if (this.f10866o1) {
            return;
        }
        i();
    }

    private void setPlaceholderTextEnabled(boolean z5) {
        if (this.f10869q == z5) {
            return;
        }
        if (z5) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.r = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_placeholder);
            AppCompatTextView appCompatTextView2 = this.r;
            WeakHashMap weakHashMap = z0.f15748a;
            k0.f(appCompatTextView2, 1);
            setPlaceholderTextAppearance(this.f10874t);
            setPlaceholderTextColor(this.f10872s);
            AppCompatTextView appCompatTextView3 = this.r;
            if (appCompatTextView3 != null) {
                this.f10829a.addView(appCompatTextView3);
                this.r.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView4 = this.r;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setVisibility(8);
            }
            this.r = null;
        }
        this.f10869q = z5;
    }

    public final void a(float f2) {
        int i3 = 2;
        com.google.android.material.internal.b bVar = this.f10868p1;
        if (bVar.f10562c == f2) {
            return;
        }
        if (this.f10873s1 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f10873s1 = valueAnimator;
            valueAnimator.setInterpolator(ja.a.f15384b);
            this.f10873s1.setDuration(167L);
            this.f10873s1.addUpdateListener(new com.google.android.material.internal.t(this, i3));
        }
        this.f10873s1.setFloatValues(bVar.f10562c, f2);
        this.f10873s1.start();
    }

    public void addOnEditTextAttachedListener(s sVar) {
        this.f10841e0.add(sVar);
        if (this.e != null) {
            sVar.a(this);
        }
    }

    public void addOnEndIconChangedListener(t tVar) {
        this.i0.add(tVar);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i3, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & Const.I_DEF_CGI_SIG) | 16;
        FrameLayout frameLayout = this.f10829a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        r();
        setEditText((EditText) view);
    }

    public final void b() {
        int i3;
        int i10;
        int i11;
        eb.h hVar = this.D;
        if (hVar == null) {
            return;
        }
        hVar.setShapeAppearanceModel(this.F);
        if (this.I == 2 && (i10 = this.K) > -1 && (i11 = this.N) != 0) {
            eb.h hVar2 = this.D;
            hVar2.f12505a.f12496j = i10;
            hVar2.invalidateSelf();
            hVar2.q(ColorStateList.valueOf(i11));
        }
        int i12 = this.O;
        if (this.I == 1) {
            TypedValue a3 = s0.a(getContext(), R$attr.colorSurface);
            i12 = c1.a.c(this.O, a3 != null ? a3.data : 0);
        }
        this.O = i12;
        this.D.l(ColorStateList.valueOf(i12));
        if (this.f10844f0 == 3) {
            this.e.getBackground().invalidateSelf();
        }
        eb.h hVar3 = this.E;
        if (hVar3 != null) {
            if (this.K > -1 && (i3 = this.N) != 0) {
                hVar3.l(ColorStateList.valueOf(i3));
            }
            invalidate();
        }
        invalidate();
    }

    public final void c() {
        d(this.f10849h0, this.f10857k0, this.f10854j0, this.V0, this.U0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i3) {
        EditText editText = this.e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i3);
            return;
        }
        if (this.f10843f != null) {
            boolean z5 = this.C;
            this.C = false;
            CharSequence hint = editText.getHint();
            this.e.setHint(this.f10843f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i3);
                return;
            } finally {
                this.e.setHint(hint);
                this.C = z5;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i3);
        onProvideAutofillVirtualStructure(viewStructure, i3);
        FrameLayout frameLayout = this.f10829a;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i10 = 0; i10 < frameLayout.getChildCount(); i10++) {
            View childAt = frameLayout.getChildAt(i10);
            ViewStructure newChild = viewStructure.newChild(i10);
            childAt.dispatchProvideAutofillStructure(newChild, i3);
            if (childAt == this.e) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.f10877u1 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f10877u1 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.A) {
            this.f10868p1.e(canvas);
        }
        eb.h hVar = this.E;
        if (hVar != null) {
            Rect bounds = hVar.getBounds();
            bounds.top = bounds.bottom - this.K;
            this.E.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.f10875t1
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.f10875t1 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            com.google.android.material.internal.b r3 = r4.f10868p1
            if (r3 == 0) goto L2f
            r3.I = r1
            android.content.res.ColorStateList r1 = r3.f10579p
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f10578o
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.i(r2)
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            android.widget.EditText r3 = r4.e
            if (r3 == 0) goto L47
            java.util.WeakHashMap r3 = l1.z0.f15748a
            boolean r3 = l1.k0.c(r4)
            if (r3 == 0) goto L43
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L43
            goto L44
        L43:
            r0 = r2
        L44:
            r4.s(r0, r2)
        L47:
            r4.q()
            r4.z()
            if (r1 == 0) goto L52
            r4.invalidate()
        L52:
            r4.f10875t1 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final int e() {
        if (!this.A) {
            return 0;
        }
        int i3 = this.I;
        com.google.android.material.internal.b bVar = this.f10868p1;
        if (i3 == 0 || i3 == 1) {
            TextPaint textPaint = bVar.L;
            textPaint.setTextSize(bVar.f10577n);
            textPaint.setTypeface(bVar.f10585w);
            textPaint.setLetterSpacing(bVar.W);
            return (int) (-textPaint.ascent());
        }
        if (i3 != 2) {
            return 0;
        }
        TextPaint textPaint2 = bVar.L;
        textPaint2.setTextSize(bVar.f10577n);
        textPaint2.setTypeface(bVar.f10585w);
        textPaint2.setLetterSpacing(bVar.W);
        return (int) ((-textPaint2.ascent()) / 2.0f);
    }

    public final boolean f() {
        return this.A && !TextUtils.isEmpty(this.B) && (this.D instanceof g);
    }

    public final boolean g() {
        return this.f10838d.getVisibility() == 0 && this.f10849h0.getVisibility() == 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.e;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    public eb.h getBoxBackground() {
        int i3 = this.I;
        if (i3 == 1 || i3 == 2) {
            return this.D;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.O;
    }

    public int getBoxBackgroundMode() {
        return this.I;
    }

    public float getBoxCornerRadiusBottomEnd() {
        eb.h hVar = this.D;
        return hVar.f12505a.f12488a.f12546h.a(hVar.f());
    }

    public float getBoxCornerRadiusBottomStart() {
        eb.h hVar = this.D;
        return hVar.f12505a.f12488a.f12545g.a(hVar.f());
    }

    public float getBoxCornerRadiusTopEnd() {
        eb.h hVar = this.D;
        return hVar.f12505a.f12488a.f12544f.a(hVar.f());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.D.h();
    }

    public int getBoxStrokeColor() {
        return this.f10850h1;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f10852i1;
    }

    public int getBoxStrokeWidth() {
        return this.L;
    }

    public int getBoxStrokeWidthFocused() {
        return this.M;
    }

    public int getCounterMaxLength() {
        return this.f10856k;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.f10853j && this.f10859l && (appCompatTextView = this.f10861m) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f10876u;
    }

    public ColorStateList getCounterTextColor() {
        return this.f10876u;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f10840d1;
    }

    public EditText getEditText() {
        return this.e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f10849h0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f10849h0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f10844f0;
    }

    public CheckableImageButton getEndIconView() {
        return this.f10849h0;
    }

    public CharSequence getError() {
        o oVar = this.f10851i;
        if (oVar.f10937k) {
            return oVar.f10936j;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f10851i.f10939m;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.f10851i.f10938l;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f10834b1.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        AppCompatTextView appCompatTextView = this.f10851i.f10938l;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHelperText() {
        o oVar = this.f10851i;
        if (oVar.f10943q) {
            return oVar.f10942p;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.f10851i.r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.A) {
            return this.B;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        com.google.android.material.internal.b bVar = this.f10868p1;
        TextPaint textPaint = bVar.L;
        textPaint.setTextSize(bVar.f10577n);
        textPaint.setTypeface(bVar.f10585w);
        textPaint.setLetterSpacing(bVar.W);
        return -textPaint.ascent();
    }

    public final int getHintCurrentCollapsedTextColor() {
        com.google.android.material.internal.b bVar = this.f10868p1;
        return bVar.f(bVar.f10579p);
    }

    public ColorStateList getHintTextColor() {
        return this.f10842e1;
    }

    public int getMaxWidth() {
        return this.f10848h;
    }

    public int getMinWidth() {
        return this.f10845g;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f10849h0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f10849h0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f10869q) {
            return this.f10867p;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f10874t;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f10872s;
    }

    public CharSequence getPrefixText() {
        return this.f10879w;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f10880x.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f10880x;
    }

    public CharSequence getStartIconContentDescription() {
        return this.T.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.T.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.f10881y;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f10882z.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f10882z;
    }

    public Typeface getTypeface() {
        return this.S;
    }

    public final void h() {
        int i3 = this.I;
        if (i3 != 0) {
            eb.m mVar = this.F;
            if (i3 == 1) {
                this.D = new eb.h(mVar);
                this.E = new eb.h();
            } else {
                if (i3 != 2) {
                    throw new IllegalArgumentException(r5.a.e(new StringBuilder(), this.I, " is illegal; only @BoxBackgroundMode constants are supported."));
                }
                if (!this.A || (this.D instanceof g)) {
                    this.D = new eb.h(mVar);
                } else {
                    this.D = new g(mVar);
                }
                this.E = null;
            }
        } else {
            this.D = null;
            this.E = null;
        }
        EditText editText = this.e;
        if (editText != null && this.D != null && editText.getBackground() == null && this.I != 0) {
            EditText editText2 = this.e;
            eb.h hVar = this.D;
            WeakHashMap weakHashMap = z0.f15748a;
            h0.q(editText2, hVar);
        }
        z();
        if (this.I == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.J = getResources().getDimensionPixelSize(R$dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (t0.e(getContext())) {
                this.J = getResources().getDimensionPixelSize(R$dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.e != null && this.I == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText3 = this.e;
                WeakHashMap weakHashMap2 = z0.f15748a;
                i0.k(editText3, i0.f(editText3), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top), i0.e(this.e), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (t0.e(getContext())) {
                EditText editText4 = this.e;
                WeakHashMap weakHashMap3 = z0.f15748a;
                i0.k(editText4, i0.f(editText4), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top), i0.e(this.e), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.I != 0) {
            r();
        }
    }

    public final void i() {
        float f2;
        float b3;
        float f10;
        float b10;
        int i3;
        float b11;
        int i10;
        if (f()) {
            RectF rectF = this.R;
            int width = this.e.getWidth();
            int gravity = this.e.getGravity();
            com.google.android.material.internal.b bVar = this.f10868p1;
            boolean c9 = bVar.c(bVar.B);
            bVar.D = c9;
            Rect rect = bVar.f10572i;
            if (gravity != 17 && (gravity & 7) != 1) {
                if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (c9) {
                        i10 = rect.left;
                        f10 = i10;
                    } else {
                        f2 = rect.right;
                        b3 = bVar.b();
                    }
                } else if (c9) {
                    f2 = rect.right;
                    b3 = bVar.b();
                } else {
                    i10 = rect.left;
                    f10 = i10;
                }
                rectF.left = f10;
                rectF.top = rect.top;
                if (gravity != 17 || (gravity & 7) == 1) {
                    b10 = (width / 2.0f) + (bVar.b() / 2.0f);
                } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (bVar.D) {
                        b11 = bVar.b();
                        b10 = b11 + f10;
                    } else {
                        i3 = rect.right;
                        b10 = i3;
                    }
                } else if (bVar.D) {
                    i3 = rect.right;
                    b10 = i3;
                } else {
                    b11 = bVar.b();
                    b10 = b11 + f10;
                }
                rectF.right = b10;
                TextPaint textPaint = bVar.L;
                textPaint.setTextSize(bVar.f10577n);
                textPaint.setTypeface(bVar.f10585w);
                textPaint.setLetterSpacing(bVar.W);
                textPaint.ascent();
                float f11 = rectF.left;
                float f12 = this.G;
                rectF.left = f11 - f12;
                rectF.right += f12;
                int i11 = this.K;
                this.H = i11;
                rectF.top = 0.0f;
                rectF.bottom = i11;
                rectF.offset(-getPaddingLeft(), 0.0f);
                g gVar = (g) this.D;
                gVar.getClass();
                gVar.u(rectF.left, rectF.top, rectF.right, rectF.bottom);
            }
            f2 = width / 2.0f;
            b3 = bVar.b() / 2.0f;
            f10 = f2 - b3;
            rectF.left = f10;
            rectF.top = rect.top;
            if (gravity != 17) {
            }
            b10 = (width / 2.0f) + (bVar.b() / 2.0f);
            rectF.right = b10;
            TextPaint textPaint2 = bVar.L;
            textPaint2.setTextSize(bVar.f10577n);
            textPaint2.setTypeface(bVar.f10585w);
            textPaint2.setLetterSpacing(bVar.W);
            textPaint2.ascent();
            float f112 = rectF.left;
            float f122 = this.G;
            rectF.left = f112 - f122;
            rectF.right += f122;
            int i112 = this.K;
            this.H = i112;
            rectF.top = 0.0f;
            rectF.bottom = i112;
            rectF.offset(-getPaddingLeft(), 0.0f);
            g gVar2 = (g) this.D;
            gVar2.getClass();
            gVar2.u(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public final void k(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
        Drawable mutate = drawable.mutate();
        d1.b.h(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    public final void m(AppCompatTextView appCompatTextView, int i3) {
        try {
            appCompatTextView.setTextAppearance(i3);
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        appCompatTextView.setTextAppearance(R$style.TextAppearance_AppCompat_Caption);
        appCompatTextView.setTextColor(a1.d.a(getContext(), R$color.design_error));
    }

    public final void n(int i3) {
        boolean z5 = this.f10859l;
        int i10 = this.f10856k;
        String str = null;
        if (i10 == -1) {
            this.f10861m.setText(String.valueOf(i3));
            this.f10861m.setContentDescription(null);
            this.f10859l = false;
        } else {
            this.f10859l = i3 > i10;
            Context context = getContext();
            this.f10861m.setContentDescription(context.getString(this.f10859l ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i3), Integer.valueOf(this.f10856k)));
            if (z5 != this.f10859l) {
                o();
            }
            String str2 = j1.b.f15168b;
            Locale locale = Locale.getDefault();
            int i11 = j1.i.f15181a;
            j1.b bVar = j1.h.a(locale) == 1 ? j1.b.e : j1.b.f15170d;
            AppCompatTextView appCompatTextView = this.f10861m;
            String string = getContext().getString(R$string.character_counter_pattern, Integer.valueOf(i3), Integer.valueOf(this.f10856k));
            if (string == null) {
                bVar.getClass();
            } else {
                bVar.getClass();
                com.example.test.utils.s0 s0Var = j1.g.f15177a;
                str = bVar.c(string).toString();
            }
            appCompatTextView.setText(str);
        }
        if (this.e == null || z5 == this.f10859l) {
            return;
        }
        s(false, false);
        z();
        q();
    }

    public final void o() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.f10861m;
        if (appCompatTextView != null) {
            m(appCompatTextView, this.f10859l ? this.f10863n : this.f10865o);
            if (!this.f10859l && (colorStateList2 = this.f10876u) != null) {
                this.f10861m.setTextColor(colorStateList2);
            }
            if (!this.f10859l || (colorStateList = this.f10878v) == null) {
                return;
            }
            this.f10861m.setTextColor(colorStateList);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        EditText editText = this.e;
        if (editText != null) {
            Rect rect = this.P;
            com.google.android.material.internal.c.a(this, editText, rect);
            eb.h hVar = this.E;
            if (hVar != null) {
                int i13 = rect.bottom;
                hVar.setBounds(rect.left, i13 - this.M, rect.right, i13);
            }
            if (this.A) {
                float textSize = this.e.getTextSize();
                com.google.android.material.internal.b bVar = this.f10868p1;
                if (bVar.f10576m != textSize) {
                    bVar.f10576m = textSize;
                    bVar.i(false);
                }
                int gravity = this.e.getGravity();
                bVar.l((gravity & Const.I_DEF_CGI_SIG) | 48);
                if (bVar.f10574k != gravity) {
                    bVar.f10574k = gravity;
                    bVar.i(false);
                }
                if (this.e == null) {
                    throw new IllegalStateException();
                }
                WeakHashMap weakHashMap = z0.f15748a;
                boolean z6 = i0.d(this) == 1;
                int i14 = rect.bottom;
                Rect rect2 = this.Q;
                rect2.bottom = i14;
                int i15 = this.I;
                AppCompatTextView appCompatTextView = this.f10880x;
                if (i15 == 1) {
                    int compoundPaddingLeft = this.e.getCompoundPaddingLeft() + rect.left;
                    if (this.f10879w != null && !z6) {
                        compoundPaddingLeft = (compoundPaddingLeft - appCompatTextView.getMeasuredWidth()) + appCompatTextView.getPaddingLeft();
                    }
                    rect2.left = compoundPaddingLeft;
                    rect2.top = rect.top + this.J;
                    int compoundPaddingRight = rect.right - this.e.getCompoundPaddingRight();
                    if (this.f10879w != null && z6) {
                        compoundPaddingRight += appCompatTextView.getMeasuredWidth() - appCompatTextView.getPaddingRight();
                    }
                    rect2.right = compoundPaddingRight;
                } else if (i15 != 2) {
                    int compoundPaddingLeft2 = this.e.getCompoundPaddingLeft() + rect.left;
                    if (this.f10879w != null && !z6) {
                        compoundPaddingLeft2 = (compoundPaddingLeft2 - appCompatTextView.getMeasuredWidth()) + appCompatTextView.getPaddingLeft();
                    }
                    rect2.left = compoundPaddingLeft2;
                    rect2.top = getPaddingTop();
                    int compoundPaddingRight2 = rect.right - this.e.getCompoundPaddingRight();
                    if (this.f10879w != null && z6) {
                        compoundPaddingRight2 += appCompatTextView.getMeasuredWidth() - appCompatTextView.getPaddingRight();
                    }
                    rect2.right = compoundPaddingRight2;
                } else {
                    rect2.left = this.e.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - e();
                    rect2.right = rect.right - this.e.getPaddingRight();
                }
                int i16 = rect2.left;
                int i17 = rect2.top;
                int i18 = rect2.right;
                int i19 = rect2.bottom;
                Rect rect3 = bVar.f10572i;
                if (rect3.left != i16 || rect3.top != i17 || rect3.right != i18 || rect3.bottom != i19) {
                    rect3.set(i16, i17, i18, i19);
                    bVar.J = true;
                    bVar.h();
                }
                if (this.e == null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint = bVar.L;
                textPaint.setTextSize(bVar.f10576m);
                textPaint.setTypeface(bVar.f10586x);
                textPaint.setLetterSpacing(bVar.X);
                float f2 = -textPaint.ascent();
                rect2.left = this.e.getCompoundPaddingLeft() + rect.left;
                rect2.top = (this.I != 1 || this.e.getMinLines() > 1) ? rect.top + this.e.getCompoundPaddingTop() : (int) (rect.centerY() - (f2 / 2.0f));
                rect2.right = rect.right - this.e.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.I != 1 || this.e.getMinLines() > 1) ? rect.bottom - this.e.getCompoundPaddingBottom() : (int) (rect2.top + f2);
                rect2.bottom = compoundPaddingBottom;
                int i20 = rect2.left;
                int i21 = rect2.top;
                int i22 = rect2.right;
                Rect rect4 = bVar.f10571h;
                if (rect4.left != i20 || rect4.top != i21 || rect4.right != i22 || rect4.bottom != compoundPaddingBottom) {
                    rect4.set(i20, i21, i22, compoundPaddingBottom);
                    bVar.J = true;
                    bVar.h();
                }
                bVar.i(false);
                if (!f() || this.f10866o1) {
                    return;
                }
                i();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        EditText editText;
        int max;
        super.onMeasure(i3, i10);
        boolean z5 = false;
        if (this.e != null && this.e.getMeasuredHeight() < (max = Math.max(this.f10835c.getMeasuredHeight(), this.f10832b.getMeasuredHeight()))) {
            this.e.setMinimumHeight(max);
            z5 = true;
        }
        boolean p8 = p();
        if (z5 || p8) {
            this.e.post(new q(this, 1));
        }
        if (this.r != null && (editText = this.e) != null) {
            this.r.setGravity(editText.getGravity());
            this.r.setPadding(this.e.getCompoundPaddingLeft(), this.e.getCompoundPaddingTop(), this.e.getCompoundPaddingRight(), this.e.getCompoundPaddingBottom());
        }
        u();
        x();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.f10883a);
        if (savedState.f10884b) {
            this.f10849h0.post(new q(this, 0));
        }
        setHint(savedState.f10885c);
        setHelperText(savedState.f10886d);
        setPlaceholderText(savedState.e);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f10851i.e()) {
            savedState.f10883a = getError();
        }
        savedState.f10884b = this.f10844f0 != 0 && this.f10849h0.f10532d;
        savedState.f10885c = getHint();
        savedState.f10886d = getHelperText();
        savedState.e = getPlaceholderText();
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p() {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.p():boolean");
    }

    public final void q() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.e;
        if (editText == null || this.I != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = n1.f1001a;
        Drawable mutate = background.mutate();
        o oVar = this.f10851i;
        if (oVar.e()) {
            AppCompatTextView appCompatTextView2 = oVar.f10938l;
            mutate.setColorFilter(y.c(appCompatTextView2 != null ? appCompatTextView2.getCurrentTextColor() : -1, PorterDuff.Mode.SRC_IN));
        } else if (this.f10859l && (appCompatTextView = this.f10861m) != null) {
            mutate.setColorFilter(y.c(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            mutate.clearColorFilter();
            this.e.refreshDrawableState();
        }
    }

    public final void r() {
        if (this.I != 1) {
            FrameLayout frameLayout = this.f10829a;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int e = e();
            if (e != layoutParams.topMargin) {
                layoutParams.topMargin = e;
                frameLayout.requestLayout();
            }
        }
    }

    public void removeOnEditTextAttachedListener(s sVar) {
        this.f10841e0.remove(sVar);
    }

    public void removeOnEndIconChangedListener(t tVar) {
        this.i0.remove(tVar);
    }

    public final void s(boolean z5, boolean z6) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean isEnabled = isEnabled();
        EditText editText = this.e;
        boolean z8 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.e;
        boolean z10 = editText2 != null && editText2.hasFocus();
        o oVar = this.f10851i;
        boolean e = oVar.e();
        ColorStateList colorStateList2 = this.f10840d1;
        com.google.android.material.internal.b bVar = this.f10868p1;
        if (colorStateList2 != null) {
            bVar.k(colorStateList2);
            ColorStateList colorStateList3 = this.f10840d1;
            if (bVar.f10578o != colorStateList3) {
                bVar.f10578o = colorStateList3;
                bVar.i(false);
            }
        }
        if (!isEnabled) {
            ColorStateList colorStateList4 = this.f10840d1;
            int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(new int[]{-16842910}, this.f10864n1) : this.f10864n1;
            bVar.k(ColorStateList.valueOf(colorForState));
            ColorStateList valueOf = ColorStateList.valueOf(colorForState);
            if (bVar.f10578o != valueOf) {
                bVar.f10578o = valueOf;
                bVar.i(false);
            }
        } else if (e) {
            AppCompatTextView appCompatTextView2 = oVar.f10938l;
            bVar.k(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.f10859l && (appCompatTextView = this.f10861m) != null) {
            bVar.k(appCompatTextView.getTextColors());
        } else if (z10 && (colorStateList = this.f10842e1) != null) {
            bVar.k(colorStateList);
        }
        if (z8 || !this.f10870q1 || (isEnabled() && z10)) {
            if (z6 || this.f10866o1) {
                ValueAnimator valueAnimator = this.f10873s1;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f10873s1.cancel();
                }
                if (z5 && this.f10871r1) {
                    a(1.0f);
                } else {
                    bVar.n(1.0f);
                }
                this.f10866o1 = false;
                if (f()) {
                    i();
                }
                EditText editText3 = this.e;
                t(editText3 != null ? editText3.getText().length() : 0);
                v();
                y();
                return;
            }
            return;
        }
        if (z6 || !this.f10866o1) {
            ValueAnimator valueAnimator2 = this.f10873s1;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f10873s1.cancel();
            }
            if (z5 && this.f10871r1) {
                a(0.0f);
            } else {
                bVar.n(0.0f);
            }
            if (f() && !((g) this.D).f10902y.isEmpty() && f()) {
                ((g) this.D).u(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.f10866o1 = true;
            AppCompatTextView appCompatTextView3 = this.r;
            if (appCompatTextView3 != null && this.f10869q) {
                appCompatTextView3.setText((CharSequence) null);
                this.r.setVisibility(4);
            }
            v();
            y();
        }
    }

    public void setBoxBackgroundColor(int i3) {
        if (this.O != i3) {
            this.O = i3;
            this.f10855j1 = i3;
            this.f10860l1 = i3;
            this.f10862m1 = i3;
            b();
        }
    }

    public void setBoxBackgroundColorResource(int i3) {
        setBoxBackgroundColor(a1.d.a(getContext(), i3));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f10855j1 = defaultColor;
        this.O = defaultColor;
        this.f10858k1 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f10860l1 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f10862m1 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i3) {
        if (i3 == this.I) {
            return;
        }
        this.I = i3;
        if (this.e != null) {
            h();
        }
    }

    public void setBoxStrokeColor(int i3) {
        if (this.f10850h1 != i3) {
            this.f10850h1 = i3;
            z();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f1 = colorStateList.getDefaultColor();
            this.f10864n1 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f10847g1 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f10850h1 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f10850h1 != colorStateList.getDefaultColor()) {
            this.f10850h1 = colorStateList.getDefaultColor();
        }
        z();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f10852i1 != colorStateList) {
            this.f10852i1 = colorStateList;
            z();
        }
    }

    public void setBoxStrokeWidth(int i3) {
        this.L = i3;
        z();
    }

    public void setBoxStrokeWidthFocused(int i3) {
        this.M = i3;
        z();
    }

    public void setBoxStrokeWidthFocusedResource(int i3) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i3));
    }

    public void setBoxStrokeWidthResource(int i3) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i3));
    }

    public void setCounterEnabled(boolean z5) {
        if (this.f10853j != z5) {
            o oVar = this.f10851i;
            if (z5) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f10861m = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.S;
                if (typeface != null) {
                    this.f10861m.setTypeface(typeface);
                }
                this.f10861m.setMaxLines(1);
                oVar.a(this.f10861m, 2);
                l1.p.h((ViewGroup.MarginLayoutParams) this.f10861m.getLayoutParams(), getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                o();
                if (this.f10861m != null) {
                    EditText editText = this.e;
                    n(editText == null ? 0 : editText.getText().length());
                }
            } else {
                oVar.h(this.f10861m, 2);
                this.f10861m = null;
            }
            this.f10853j = z5;
        }
    }

    public void setCounterMaxLength(int i3) {
        if (this.f10856k != i3) {
            if (i3 > 0) {
                this.f10856k = i3;
            } else {
                this.f10856k = -1;
            }
            if (!this.f10853j || this.f10861m == null) {
                return;
            }
            EditText editText = this.e;
            n(editText == null ? 0 : editText.getText().length());
        }
    }

    public void setCounterOverflowTextAppearance(int i3) {
        if (this.f10863n != i3) {
            this.f10863n = i3;
            o();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f10878v != colorStateList) {
            this.f10878v = colorStateList;
            o();
        }
    }

    public void setCounterTextAppearance(int i3) {
        if (this.f10865o != i3) {
            this.f10865o = i3;
            o();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f10876u != colorStateList) {
            this.f10876u = colorStateList;
            o();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f10840d1 = colorStateList;
        this.f10842e1 = colorStateList;
        if (this.e != null) {
            s(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        j(this, z5);
        super.setEnabled(z5);
    }

    public void setEndIconActivated(boolean z5) {
        this.f10849h0.setActivated(z5);
    }

    public void setEndIconCheckable(boolean z5) {
        this.f10849h0.setCheckable(z5);
    }

    public void setEndIconContentDescription(int i3) {
        setEndIconContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setEndIconDrawable(int i3) {
        setEndIconDrawable(i3 != 0 ? pb.b(getContext(), i3) : null);
    }

    public void setEndIconMode(int i3) {
        int i10 = this.f10844f0;
        this.f10844f0 = i3;
        Iterator it = this.i0.iterator();
        while (it.hasNext()) {
            ((t) it.next()).a(this, i10);
        }
        setEndIconVisible(i3 != 0);
        if (getEndIconDelegate().b(this.I)) {
            getEndIconDelegate().a();
            c();
        } else {
            throw new IllegalStateException("The current box background mode " + this.I + " is not supported by the end icon mode " + i3);
        }
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener = this.Z0;
        CheckableImageButton checkableImageButton = this.f10849h0;
        checkableImageButton.setOnClickListener(onClickListener);
        l(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Z0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.f10849h0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        l(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.f10854j0 != colorStateList) {
            this.f10854j0 = colorStateList;
            this.f10857k0 = true;
            c();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.U0 != mode) {
            this.U0 = mode;
            this.V0 = true;
            c();
        }
    }

    public void setEndIconVisible(boolean z5) {
        if (g() != z5) {
            this.f10849h0.setVisibility(z5 ? 0 : 8);
            x();
            p();
        }
    }

    public void setError(CharSequence charSequence) {
        o oVar = this.f10851i;
        if (!oVar.f10937k) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            oVar.g();
            return;
        }
        oVar.c();
        oVar.f10936j = charSequence;
        oVar.f10938l.setText(charSequence);
        int i3 = oVar.f10934h;
        if (i3 != 1) {
            oVar.f10935i = 1;
        }
        oVar.j(i3, oVar.f10935i, oVar.i(oVar.f10938l, charSequence));
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        o oVar = this.f10851i;
        oVar.f10939m = charSequence;
        AppCompatTextView appCompatTextView = oVar.f10938l;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z5) {
        o oVar = this.f10851i;
        if (oVar.f10937k == z5) {
            return;
        }
        oVar.c();
        TextInputLayout textInputLayout = oVar.f10929b;
        if (z5) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(oVar.f10928a);
            oVar.f10938l = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_error);
            oVar.f10938l.setTextAlignment(5);
            Typeface typeface = oVar.f10946u;
            if (typeface != null) {
                oVar.f10938l.setTypeface(typeface);
            }
            int i3 = oVar.f10940n;
            oVar.f10940n = i3;
            AppCompatTextView appCompatTextView2 = oVar.f10938l;
            if (appCompatTextView2 != null) {
                textInputLayout.m(appCompatTextView2, i3);
            }
            ColorStateList colorStateList = oVar.f10941o;
            oVar.f10941o = colorStateList;
            AppCompatTextView appCompatTextView3 = oVar.f10938l;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = oVar.f10939m;
            oVar.f10939m = charSequence;
            AppCompatTextView appCompatTextView4 = oVar.f10938l;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            oVar.f10938l.setVisibility(4);
            AppCompatTextView appCompatTextView5 = oVar.f10938l;
            WeakHashMap weakHashMap = z0.f15748a;
            k0.f(appCompatTextView5, 1);
            oVar.a(oVar.f10938l, 0);
        } else {
            oVar.g();
            oVar.h(oVar.f10938l, 0);
            oVar.f10938l = null;
            textInputLayout.q();
            textInputLayout.z();
        }
        oVar.f10937k = z5;
    }

    public void setErrorIconDrawable(int i3) {
        setErrorIconDrawable(i3 != 0 ? pb.b(getContext(), i3) : null);
        k(this.f10834b1, this.f10837c1);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener = this.f10831a1;
        CheckableImageButton checkableImageButton = this.f10834b1;
        checkableImageButton.setOnClickListener(onClickListener);
        l(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f10831a1 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.f10834b1;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        l(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f10837c1 = colorStateList;
        CheckableImageButton checkableImageButton = this.f10834b1;
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            d1.b.h(drawable, colorStateList);
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        CheckableImageButton checkableImageButton = this.f10834b1;
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            d1.b.i(drawable, mode);
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i3) {
        o oVar = this.f10851i;
        oVar.f10940n = i3;
        AppCompatTextView appCompatTextView = oVar.f10938l;
        if (appCompatTextView != null) {
            oVar.f10929b.m(appCompatTextView, i3);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        o oVar = this.f10851i;
        oVar.f10941o = colorStateList;
        AppCompatTextView appCompatTextView = oVar.f10938l;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z5) {
        if (this.f10870q1 != z5) {
            this.f10870q1 = z5;
            s(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        o oVar = this.f10851i;
        if (isEmpty) {
            if (oVar.f10943q) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!oVar.f10943q) {
            setHelperTextEnabled(true);
        }
        oVar.c();
        oVar.f10942p = charSequence;
        oVar.r.setText(charSequence);
        int i3 = oVar.f10934h;
        if (i3 != 2) {
            oVar.f10935i = 2;
        }
        oVar.j(i3, oVar.f10935i, oVar.i(oVar.r, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        o oVar = this.f10851i;
        oVar.f10945t = colorStateList;
        AppCompatTextView appCompatTextView = oVar.r;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z5) {
        o oVar = this.f10851i;
        if (oVar.f10943q == z5) {
            return;
        }
        oVar.c();
        if (z5) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(oVar.f10928a);
            oVar.r = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_helper_text);
            oVar.r.setTextAlignment(5);
            Typeface typeface = oVar.f10946u;
            if (typeface != null) {
                oVar.r.setTypeface(typeface);
            }
            oVar.r.setVisibility(4);
            AppCompatTextView appCompatTextView2 = oVar.r;
            WeakHashMap weakHashMap = z0.f15748a;
            k0.f(appCompatTextView2, 1);
            int i3 = oVar.f10944s;
            oVar.f10944s = i3;
            AppCompatTextView appCompatTextView3 = oVar.r;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTextAppearance(i3);
            }
            ColorStateList colorStateList = oVar.f10945t;
            oVar.f10945t = colorStateList;
            AppCompatTextView appCompatTextView4 = oVar.r;
            if (appCompatTextView4 != null && colorStateList != null) {
                appCompatTextView4.setTextColor(colorStateList);
            }
            oVar.a(oVar.r, 1);
        } else {
            oVar.c();
            int i10 = oVar.f10934h;
            if (i10 == 2) {
                oVar.f10935i = 0;
            }
            oVar.j(i10, oVar.f10935i, oVar.i(oVar.r, null));
            oVar.h(oVar.r, 1);
            oVar.r = null;
            TextInputLayout textInputLayout = oVar.f10929b;
            textInputLayout.q();
            textInputLayout.z();
        }
        oVar.f10943q = z5;
    }

    public void setHelperTextTextAppearance(int i3) {
        o oVar = this.f10851i;
        oVar.f10944s = i3;
        AppCompatTextView appCompatTextView = oVar.r;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i3);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.A) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z5) {
        this.f10871r1 = z5;
    }

    public void setHintEnabled(boolean z5) {
        if (z5 != this.A) {
            this.A = z5;
            if (z5) {
                CharSequence hint = this.e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.B)) {
                        setHint(hint);
                    }
                    this.e.setHint((CharSequence) null);
                }
                this.C = true;
            } else {
                this.C = false;
                if (!TextUtils.isEmpty(this.B) && TextUtils.isEmpty(this.e.getHint())) {
                    this.e.setHint(this.B);
                }
                setHintInternal(null);
            }
            if (this.e != null) {
                r();
            }
        }
    }

    public void setHintTextAppearance(int i3) {
        com.google.android.material.internal.b bVar = this.f10868p1;
        bVar.j(i3);
        this.f10842e1 = bVar.f10579p;
        if (this.e != null) {
            s(false, false);
            r();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f10842e1 != colorStateList) {
            if (this.f10840d1 == null) {
                this.f10868p1.k(colorStateList);
            }
            this.f10842e1 = colorStateList;
            if (this.e != null) {
                s(false, false);
            }
        }
    }

    public void setMaxWidth(int i3) {
        this.f10848h = i3;
        EditText editText = this.e;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMaxWidth(i3);
    }

    public void setMaxWidthResource(int i3) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    public void setMinWidth(int i3) {
        this.f10845g = i3;
        EditText editText = this.e;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMinWidth(i3);
    }

    public void setMinWidthResource(int i3) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i3) {
        setPasswordVisibilityToggleContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i3) {
        setPasswordVisibilityToggleDrawable(i3 != 0 ? pb.b(getContext(), i3) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z5) {
        if (z5 && this.f10844f0 != 1) {
            setEndIconMode(1);
        } else {
            if (z5) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f10854j0 = colorStateList;
        this.f10857k0 = true;
        c();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.U0 = mode;
        this.V0 = true;
        c();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f10869q && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f10869q) {
                setPlaceholderTextEnabled(true);
            }
            this.f10867p = charSequence;
        }
        EditText editText = this.e;
        t(editText != null ? editText.getText().length() : 0);
    }

    public void setPlaceholderTextAppearance(int i3) {
        this.f10874t = i3;
        AppCompatTextView appCompatTextView = this.r;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i3);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f10872s != colorStateList) {
            this.f10872s = colorStateList;
            AppCompatTextView appCompatTextView = this.r;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f10879w = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f10880x.setText(charSequence);
        v();
    }

    public void setPrefixTextAppearance(int i3) {
        this.f10880x.setTextAppearance(i3);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f10880x.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z5) {
        this.T.setCheckable(z5);
    }

    public void setStartIconContentDescription(int i3) {
        setStartIconContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setStartIconDrawable(int i3) {
        setStartIconDrawable(i3 != 0 ? pb.b(getContext(), i3) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener = this.f10839d0;
        CheckableImageButton checkableImageButton = this.T;
        checkableImageButton.setOnClickListener(onClickListener);
        l(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f10839d0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.T;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        l(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            this.V = true;
            d(this.T, true, colorStateList, this.f10830a0, this.W);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.W != mode) {
            this.W = mode;
            this.f10830a0 = true;
            d(this.T, this.V, this.U, true, mode);
        }
    }

    public void setStartIconVisible(boolean z5) {
        CheckableImageButton checkableImageButton = this.T;
        if ((checkableImageButton.getVisibility() == 0) != z5) {
            checkableImageButton.setVisibility(z5 ? 0 : 8);
            u();
            p();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f10881y = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f10882z.setText(charSequence);
        y();
    }

    public void setSuffixTextAppearance(int i3) {
        this.f10882z.setTextAppearance(i3);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f10882z.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(r rVar) {
        EditText editText = this.e;
        if (editText != null) {
            z0.n(editText, rVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        boolean z5;
        if (typeface != this.S) {
            this.S = typeface;
            com.google.android.material.internal.b bVar = this.f10868p1;
            bb.b bVar2 = bVar.A;
            boolean z6 = true;
            if (bVar2 != null) {
                bVar2.f3184c = true;
            }
            if (bVar.f10585w != typeface) {
                bVar.f10585w = typeface;
                z5 = true;
            } else {
                z5 = false;
            }
            bb.b bVar3 = bVar.f10588z;
            if (bVar3 != null) {
                bVar3.f3184c = true;
            }
            if (bVar.f10586x != typeface) {
                bVar.f10586x = typeface;
            } else {
                z6 = false;
            }
            if (z5 || z6) {
                bVar.i(false);
            }
            o oVar = this.f10851i;
            if (typeface != oVar.f10946u) {
                oVar.f10946u = typeface;
                AppCompatTextView appCompatTextView = oVar.f10938l;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = oVar.r;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.f10861m;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void t(int i3) {
        if (i3 != 0 || this.f10866o1) {
            AppCompatTextView appCompatTextView = this.r;
            if (appCompatTextView == null || !this.f10869q) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            this.r.setVisibility(4);
            return;
        }
        AppCompatTextView appCompatTextView2 = this.r;
        if (appCompatTextView2 == null || !this.f10869q) {
            return;
        }
        appCompatTextView2.setText(this.f10867p);
        this.r.setVisibility(0);
        this.r.bringToFront();
    }

    public final void u() {
        int f2;
        if (this.e == null) {
            return;
        }
        if (this.T.getVisibility() == 0) {
            f2 = 0;
        } else {
            EditText editText = this.e;
            WeakHashMap weakHashMap = z0.f15748a;
            f2 = i0.f(editText);
        }
        AppCompatTextView appCompatTextView = this.f10880x;
        int compoundPaddingTop = this.e.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = this.e.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = z0.f15748a;
        i0.k(appCompatTextView, f2, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void v() {
        this.f10880x.setVisibility((this.f10879w == null || this.f10866o1) ? 8 : 0);
        p();
    }

    public final void w(boolean z5, boolean z6) {
        int defaultColor = this.f10852i1.getDefaultColor();
        int colorForState = this.f10852i1.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f10852i1.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z5) {
            this.N = colorForState2;
        } else if (z6) {
            this.N = colorForState;
        } else {
            this.N = defaultColor;
        }
    }

    public final void x() {
        int i3;
        if (this.e == null) {
            return;
        }
        if (g() || this.f10834b1.getVisibility() == 0) {
            i3 = 0;
        } else {
            EditText editText = this.e;
            WeakHashMap weakHashMap = z0.f15748a;
            i3 = i0.e(editText);
        }
        AppCompatTextView appCompatTextView = this.f10882z;
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = this.e.getPaddingTop();
        int paddingBottom = this.e.getPaddingBottom();
        WeakHashMap weakHashMap2 = z0.f15748a;
        i0.k(appCompatTextView, dimensionPixelSize, paddingTop, i3, paddingBottom);
    }

    public final void y() {
        AppCompatTextView appCompatTextView = this.f10882z;
        int visibility = appCompatTextView.getVisibility();
        boolean z5 = (this.f10881y == null || this.f10866o1) ? false : true;
        appCompatTextView.setVisibility(z5 ? 0 : 8);
        if (visibility != appCompatTextView.getVisibility()) {
            getEndIconDelegate().c(z5);
        }
        p();
    }

    public final void z() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.D == null || this.I == 0) {
            return;
        }
        boolean z5 = false;
        boolean z6 = isFocused() || ((editText2 = this.e) != null && editText2.hasFocus());
        boolean z8 = isHovered() || ((editText = this.e) != null && editText.isHovered());
        boolean isEnabled = isEnabled();
        o oVar = this.f10851i;
        if (!isEnabled) {
            this.N = this.f10864n1;
        } else if (oVar.e()) {
            if (this.f10852i1 != null) {
                w(z6, z8);
            } else {
                AppCompatTextView appCompatTextView2 = oVar.f10938l;
                this.N = appCompatTextView2 != null ? appCompatTextView2.getCurrentTextColor() : -1;
            }
        } else if (!this.f10859l || (appCompatTextView = this.f10861m) == null) {
            if (z6) {
                this.N = this.f10850h1;
            } else if (z8) {
                this.N = this.f10847g1;
            } else {
                this.N = this.f1;
            }
        } else if (this.f10852i1 != null) {
            w(z6, z8);
        } else {
            this.N = appCompatTextView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null && oVar.f10937k && oVar.e()) {
            z5 = true;
        }
        setErrorIconVisible(z5);
        k(this.f10834b1, this.f10837c1);
        k(this.T, this.U);
        ColorStateList colorStateList = this.f10854j0;
        CheckableImageButton checkableImageButton = this.f10849h0;
        k(checkableImageButton, colorStateList);
        m endIconDelegate = getEndIconDelegate();
        endIconDelegate.getClass();
        if (endIconDelegate instanceof l) {
            if (!oVar.e() || getEndIconDrawable() == null) {
                c();
            } else {
                Drawable mutate = getEndIconDrawable().mutate();
                AppCompatTextView appCompatTextView3 = oVar.f10938l;
                d1.b.g(mutate, appCompatTextView3 != null ? appCompatTextView3.getCurrentTextColor() : -1);
                checkableImageButton.setImageDrawable(mutate);
            }
        }
        if (z6 && isEnabled()) {
            this.K = this.M;
        } else {
            this.K = this.L;
        }
        if (this.I == 2 && f() && !this.f10866o1 && this.H != this.K) {
            if (f()) {
                ((g) this.D).u(0.0f, 0.0f, 0.0f, 0.0f);
            }
            i();
        }
        if (this.I == 1) {
            if (!isEnabled()) {
                this.O = this.f10858k1;
            } else if (z8 && !z6) {
                this.O = this.f10862m1;
            } else if (z6) {
                this.O = this.f10860l1;
            } else {
                this.O = this.f10855j1;
            }
        }
        b();
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f10849h0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f10849h0;
        checkableImageButton.setImageDrawable(drawable);
        k(checkableImageButton, this.f10854j0);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.T.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.T;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            k(checkableImageButton, this.U);
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TextInputLayout(android.content.Context r27, android.util.AttributeSet r28, int r29) {
        /*
            Method dump skipped, instructions count: 1607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f10834b1.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f10851i.f10937k);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f10849h0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f10849h0.setImageDrawable(drawable);
    }

    public void setHint(int i3) {
        setHint(i3 != 0 ? getResources().getText(i3) : null);
    }
}
