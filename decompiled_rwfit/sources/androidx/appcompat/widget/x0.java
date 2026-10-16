package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.we;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f1088a;

    /* renamed from: b, reason: collision with root package name */
    public n3 f1089b;

    /* renamed from: c, reason: collision with root package name */
    public n3 f1090c;

    /* renamed from: d, reason: collision with root package name */
    public n3 f1091d;
    public n3 e;

    /* renamed from: f, reason: collision with root package name */
    public n3 f1092f;

    /* renamed from: g, reason: collision with root package name */
    public n3 f1093g;

    /* renamed from: h, reason: collision with root package name */
    public n3 f1094h;

    /* renamed from: i, reason: collision with root package name */
    public final h1 f1095i;

    /* renamed from: j, reason: collision with root package name */
    public int f1096j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f1097k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f1098l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1099m;

    public x0(TextView textView) {
        this.f1088a = textView;
        this.f1095i = new h1(textView);
    }

    public static n3 c(Context context, y yVar, int i3) {
        ColorStateList f2;
        synchronized (yVar) {
            f2 = yVar.f1125a.f(context, i3);
        }
        if (f2 == null) {
            return null;
        }
        n3 n3Var = new n3();
        n3Var.f1007d = true;
        n3Var.f1004a = f2;
        return n3Var;
    }

    public static void h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i3 >= 30) {
            n1.a.c(editorInfo, text);
            return;
        }
        text.getClass();
        if (i3 >= 30) {
            n1.a.c(editorInfo, text);
            return;
        }
        int i10 = editorInfo.initialSelStart;
        int i11 = editorInfo.initialSelEnd;
        int i12 = i10 > i11 ? i11 : i10;
        if (i10 <= i11) {
            i10 = i11;
        }
        int length = text.length();
        if (i12 < 0 || i10 > length) {
            we.a(editorInfo, null, 0, 0);
            return;
        }
        int i13 = editorInfo.inputType & 4095;
        if (i13 == 129 || i13 == 225 || i13 == 18) {
            we.a(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            we.a(editorInfo, text, i12, i10);
            return;
        }
        int i14 = i10 - i12;
        int i15 = i14 > 1024 ? 0 : i14;
        int i16 = 2048 - i15;
        int min = Math.min(text.length() - i10, i16 - Math.min(i12, (int) (i16 * 0.8d)));
        int min2 = Math.min(i12, i16 - min);
        int i17 = i12 - min2;
        if (Character.isLowSurrogate(text.charAt(i17))) {
            i17++;
            min2--;
        }
        if (Character.isHighSurrogate(text.charAt((i10 + min) - 1))) {
            min--;
        }
        int i18 = min2 + i15;
        we.a(editorInfo, i15 != i14 ? TextUtils.concat(text.subSequence(i17, i17 + min2), text.subSequence(i10, min + i10)) : text.subSequence(i17, i18 + min + i17), min2, i18);
    }

    public final void a(Drawable drawable, n3 n3Var) {
        if (drawable == null || n3Var == null) {
            return;
        }
        y.e(drawable, n3Var, this.f1088a.getDrawableState());
    }

    public final void b() {
        n3 n3Var = this.f1089b;
        TextView textView = this.f1088a;
        if (n3Var != null || this.f1090c != null || this.f1091d != null || this.e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f1089b);
            a(compoundDrawables[1], this.f1090c);
            a(compoundDrawables[2], this.f1091d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f1092f == null && this.f1093g == null) {
            return;
        }
        Drawable[] a3 = t0.a(textView);
        a(a3[0], this.f1092f);
        a(a3[2], this.f1093g);
    }

    public final ColorStateList d() {
        n3 n3Var = this.f1094h;
        if (n3Var != null) {
            return n3Var.f1004a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        n3 n3Var = this.f1094h;
        if (n3Var != null) {
            return n3Var.f1005b;
        }
        return null;
    }

    public final void f(AttributeSet attributeSet, int i3) {
        boolean z5;
        boolean z6;
        String str;
        String str2;
        float f2;
        int i10;
        ColorStateList colorStateList;
        int resourceId;
        int resourceId2;
        TextView textView = this.f1088a;
        Context context = textView.getContext();
        y a3 = y.a();
        de.o I = de.o.I(context, attributeSet, R$styleable.AppCompatTextHelper, i3);
        l1.z0.m(textView, textView.getContext(), R$styleable.AppCompatTextHelper, attributeSet, (TypedArray) I.f12378c, i3);
        int i11 = R$styleable.AppCompatTextHelper_android_textAppearance;
        TypedArray typedArray = (TypedArray) I.f12378c;
        int resourceId3 = typedArray.getResourceId(i11, -1);
        if (typedArray.hasValue(R$styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f1089b = c(context, a3, typedArray.getResourceId(R$styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (typedArray.hasValue(R$styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f1090c = c(context, a3, typedArray.getResourceId(R$styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (typedArray.hasValue(R$styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f1091d = c(context, a3, typedArray.getResourceId(R$styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (typedArray.hasValue(R$styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.e = c(context, a3, typedArray.getResourceId(R$styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (typedArray.hasValue(R$styleable.AppCompatTextHelper_android_drawableStart)) {
            this.f1092f = c(context, a3, typedArray.getResourceId(R$styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (typedArray.hasValue(R$styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.f1093g = c(context, a3, typedArray.getResourceId(R$styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        I.K();
        boolean z8 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (resourceId3 != -1) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId3, R$styleable.TextAppearance);
            de.o oVar = new de.o(context, obtainStyledAttributes);
            if (z8 || !obtainStyledAttributes.hasValue(R$styleable.TextAppearance_textAllCaps)) {
                z5 = false;
                z6 = false;
            } else {
                z5 = obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
                z6 = true;
            }
            n(context, oVar);
            str2 = obtainStyledAttributes.hasValue(R$styleable.TextAppearance_textLocale) ? obtainStyledAttributes.getString(R$styleable.TextAppearance_textLocale) : null;
            str = obtainStyledAttributes.hasValue(R$styleable.TextAppearance_fontVariationSettings) ? obtainStyledAttributes.getString(R$styleable.TextAppearance_fontVariationSettings) : null;
            oVar.K();
        } else {
            z5 = false;
            z6 = false;
            str = null;
            str2 = null;
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.TextAppearance, i3, 0);
        de.o oVar2 = new de.o(context, obtainStyledAttributes2);
        if (!z8 && obtainStyledAttributes2.hasValue(R$styleable.TextAppearance_textAllCaps)) {
            z5 = obtainStyledAttributes2.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
            z6 = true;
        }
        if (obtainStyledAttributes2.hasValue(R$styleable.TextAppearance_textLocale)) {
            str2 = obtainStyledAttributes2.getString(R$styleable.TextAppearance_textLocale);
        }
        if (obtainStyledAttributes2.hasValue(R$styleable.TextAppearance_fontVariationSettings)) {
            str = obtainStyledAttributes2.getString(R$styleable.TextAppearance_fontVariationSettings);
        }
        if (i12 >= 28 && obtainStyledAttributes2.hasValue(R$styleable.TextAppearance_android_textSize) && obtainStyledAttributes2.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, oVar2);
        oVar2.K();
        if (!z8 && z6) {
            textView.setAllCaps(z5);
        }
        Typeface typeface = this.f1098l;
        if (typeface != null) {
            if (this.f1097k == -1) {
                textView.setTypeface(typeface, this.f1096j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (str != null) {
            v0.d(textView, str);
        }
        if (str2 != null) {
            u0.b(textView, u0.a(str2));
        }
        int[] iArr = R$styleable.AppCompatTextView;
        h1 h1Var = this.f1095i;
        Context context2 = h1Var.f922j;
        TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        TextView textView2 = h1Var.f921i;
        l1.z0.m(textView2, textView2.getContext(), R$styleable.AppCompatTextView, attributeSet, obtainStyledAttributes3, i3);
        if (obtainStyledAttributes3.hasValue(R$styleable.AppCompatTextView_autoSizeTextType)) {
            h1Var.f914a = obtainStyledAttributes3.getInt(R$styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes3.hasValue(R$styleable.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes3.getDimension(R$styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes3.hasValue(R$styleable.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes3.getDimension(R$styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes3.hasValue(R$styleable.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes3.getDimension(R$styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (!obtainStyledAttributes3.hasValue(R$styleable.AppCompatTextView_autoSizePresetSizes) || (resourceId2 = obtainStyledAttributes3.getResourceId(R$styleable.AppCompatTextView_autoSizePresetSizes, 0)) <= 0) {
            f2 = -1.0f;
        } else {
            TypedArray obtainTypedArray = obtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = obtainTypedArray.length();
            int[] iArr2 = new int[length];
            if (length > 0) {
                f2 = -1.0f;
                for (int i13 = 0; i13 < length; i13++) {
                    iArr2[i13] = obtainTypedArray.getDimensionPixelSize(i13, -1);
                }
                h1Var.f918f = h1.b(iArr2);
                h1Var.i();
            } else {
                f2 = -1.0f;
            }
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes3.recycle();
        if (!h1Var.j()) {
            h1Var.f914a = 0;
        } else if (h1Var.f914a == 1) {
            if (!h1Var.f919g) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == f2) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == f2) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == f2) {
                    dimension = 1.0f;
                }
                h1Var.k(dimension2, dimension3, dimension);
            }
            h1Var.h();
        }
        if (b4.f876b && h1Var.f914a != 0) {
            int[] iArr3 = h1Var.f918f;
            if (iArr3.length > 0) {
                if (v0.a(textView) != f2) {
                    v0.b(textView, Math.round(h1Var.f917d), Math.round(h1Var.e), Math.round(h1Var.f916c), 0);
                } else {
                    v0.c(textView, iArr3, 0);
                }
            }
        }
        TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView);
        int resourceId4 = obtainStyledAttributes4.getResourceId(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable b3 = resourceId4 != -1 ? a3.b(context, resourceId4) : null;
        int resourceId5 = obtainStyledAttributes4.getResourceId(R$styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable b10 = resourceId5 != -1 ? a3.b(context, resourceId5) : null;
        int resourceId6 = obtainStyledAttributes4.getResourceId(R$styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable b11 = resourceId6 != -1 ? a3.b(context, resourceId6) : null;
        int resourceId7 = obtainStyledAttributes4.getResourceId(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable b12 = resourceId7 != -1 ? a3.b(context, resourceId7) : null;
        int resourceId8 = obtainStyledAttributes4.getResourceId(R$styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable b13 = resourceId8 != -1 ? a3.b(context, resourceId8) : null;
        int resourceId9 = obtainStyledAttributes4.getResourceId(R$styleable.AppCompatTextView_drawableEndCompat, -1);
        Drawable b14 = resourceId9 != -1 ? a3.b(context, resourceId9) : null;
        if (b13 != null || b14 != null) {
            Drawable[] a10 = t0.a(textView);
            if (b13 == null) {
                b13 = a10[0];
            }
            if (b10 == null) {
                b10 = a10[1];
            }
            if (b14 == null) {
                b14 = a10[2];
            }
            if (b12 == null) {
                b12 = a10[3];
            }
            t0.b(textView, b13, b10, b14, b12);
        } else if (b3 != null || b10 != null || b11 != null || b12 != null) {
            Drawable[] a11 = t0.a(textView);
            Drawable drawable = a11[0];
            if (drawable == null && a11[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (b3 == null) {
                    b3 = compoundDrawables[0];
                }
                if (b10 == null) {
                    b10 = compoundDrawables[1];
                }
                if (b11 == null) {
                    b11 = compoundDrawables[2];
                }
                if (b12 == null) {
                    b12 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(b3, b10, b11, b12);
            } else {
                if (b10 == null) {
                    b10 = a11[1];
                }
                Drawable drawable2 = a11[2];
                if (b12 == null) {
                    b12 = a11[3];
                }
                t0.b(textView, drawable, b10, drawable2, b12);
            }
        }
        if (obtainStyledAttributes4.hasValue(R$styleable.AppCompatTextView_drawableTint)) {
            int i14 = R$styleable.AppCompatTextView_drawableTint;
            if (!obtainStyledAttributes4.hasValue(i14) || (resourceId = obtainStyledAttributes4.getResourceId(i14, 0)) == 0 || (colorStateList = pb.a(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes4.getColorStateList(i14);
            }
            androidx.core.widget.r.f(textView, colorStateList);
        }
        if (obtainStyledAttributes4.hasValue(R$styleable.AppCompatTextView_drawableTintMode)) {
            i10 = -1;
            androidx.core.widget.r.g(textView, n1.c(obtainStyledAttributes4.getInt(R$styleable.AppCompatTextView_drawableTintMode, -1), null));
        } else {
            i10 = -1;
        }
        int dimensionPixelSize = obtainStyledAttributes4.getDimensionPixelSize(R$styleable.AppCompatTextView_firstBaselineToTopHeight, i10);
        int dimensionPixelSize2 = obtainStyledAttributes4.getDimensionPixelSize(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, i10);
        int dimensionPixelSize3 = obtainStyledAttributes4.getDimensionPixelSize(R$styleable.AppCompatTextView_lineHeight, i10);
        obtainStyledAttributes4.recycle();
        if (dimensionPixelSize != i10) {
            com.google.android.gms.internal.mlkit_common.m.b(textView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != i10) {
            com.google.android.gms.internal.mlkit_common.m.c(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != i10) {
            pd.d(dimensionPixelSize3);
            if (dimensionPixelSize3 != textView.getPaint().getFontMetricsInt(null)) {
                textView.setLineSpacing(dimensionPixelSize3 - r1, 1.0f);
            }
        }
    }

    public final void g(Context context, int i3) {
        String string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, R$styleable.TextAppearance);
        de.o oVar = new de.o(context, obtainStyledAttributes);
        boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.TextAppearance_textAllCaps);
        TextView textView = this.f1088a;
        if (hasValue) {
            textView.setAllCaps(obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.TextAppearance_android_textSize) && obtainStyledAttributes.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, oVar);
        if (obtainStyledAttributes.hasValue(R$styleable.TextAppearance_fontVariationSettings) && (string = obtainStyledAttributes.getString(R$styleable.TextAppearance_fontVariationSettings)) != null) {
            v0.d(textView, string);
        }
        oVar.K();
        Typeface typeface = this.f1098l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f1096j);
        }
    }

    public final void i(int i3, int i10, int i11, int i12) {
        h1 h1Var = this.f1095i;
        if (h1Var.j()) {
            DisplayMetrics displayMetrics = h1Var.f922j.getResources().getDisplayMetrics();
            h1Var.k(TypedValue.applyDimension(i12, i3, displayMetrics), TypedValue.applyDimension(i12, i10, displayMetrics), TypedValue.applyDimension(i12, i11, displayMetrics));
            if (h1Var.h()) {
                h1Var.a();
            }
        }
    }

    public final void j(int[] iArr, int i3) {
        h1 h1Var = this.f1095i;
        if (h1Var.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i3 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = h1Var.f922j.getResources().getDisplayMetrics();
                    for (int i10 = 0; i10 < length; i10++) {
                        iArr2[i10] = Math.round(TypedValue.applyDimension(i3, iArr[i10], displayMetrics));
                    }
                }
                h1Var.f918f = h1.b(iArr2);
                if (!h1Var.i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                h1Var.f919g = false;
            }
            if (h1Var.h()) {
                h1Var.a();
            }
        }
    }

    public final void k(int i3) {
        h1 h1Var = this.f1095i;
        if (h1Var.j()) {
            if (i3 == 0) {
                h1Var.f914a = 0;
                h1Var.f917d = -1.0f;
                h1Var.e = -1.0f;
                h1Var.f916c = -1.0f;
                h1Var.f918f = new int[0];
                h1Var.f915b = false;
                return;
            }
            if (i3 != 1) {
                throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = h1Var.f922j.getResources().getDisplayMetrics();
            h1Var.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (h1Var.h()) {
                h1Var.a();
            }
        }
    }

    public final void l(ColorStateList colorStateList) {
        if (this.f1094h == null) {
            this.f1094h = new n3();
        }
        n3 n3Var = this.f1094h;
        n3Var.f1004a = colorStateList;
        n3Var.f1007d = colorStateList != null;
        this.f1089b = n3Var;
        this.f1090c = n3Var;
        this.f1091d = n3Var;
        this.e = n3Var;
        this.f1092f = n3Var;
        this.f1093g = n3Var;
    }

    public final void m(PorterDuff.Mode mode) {
        if (this.f1094h == null) {
            this.f1094h = new n3();
        }
        n3 n3Var = this.f1094h;
        n3Var.f1005b = mode;
        n3Var.f1006c = mode != null;
        this.f1089b = n3Var;
        this.f1090c = n3Var;
        this.f1091d = n3Var;
        this.e = n3Var;
        this.f1092f = n3Var;
        this.f1093g = n3Var;
    }

    public final void n(Context context, de.o oVar) {
        String string;
        int i3 = R$styleable.TextAppearance_android_textStyle;
        int i10 = this.f1096j;
        TypedArray typedArray = (TypedArray) oVar.f12378c;
        this.f1096j = typedArray.getInt(i3, i10);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            int i12 = typedArray.getInt(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.f1097k = i12;
            if (i12 != -1) {
                this.f1096j &= 2;
            }
        }
        if (!typedArray.hasValue(R$styleable.TextAppearance_android_fontFamily) && !typedArray.hasValue(R$styleable.TextAppearance_fontFamily)) {
            if (typedArray.hasValue(R$styleable.TextAppearance_android_typeface)) {
                this.f1099m = false;
                int i13 = typedArray.getInt(R$styleable.TextAppearance_android_typeface, 1);
                if (i13 == 1) {
                    this.f1098l = Typeface.SANS_SERIF;
                    return;
                } else if (i13 == 2) {
                    this.f1098l = Typeface.SERIF;
                    return;
                } else {
                    if (i13 != 3) {
                        return;
                    }
                    this.f1098l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f1098l = null;
        int i14 = typedArray.hasValue(R$styleable.TextAppearance_fontFamily) ? R$styleable.TextAppearance_fontFamily : R$styleable.TextAppearance_android_fontFamily;
        int i15 = this.f1097k;
        int i16 = this.f1096j;
        if (!context.isRestricted()) {
            try {
                Typeface y4 = oVar.y(i14, this.f1096j, new s0(this, i15, i16, new WeakReference(this.f1088a)));
                if (y4 != null) {
                    if (i11 < 28 || this.f1097k == -1) {
                        this.f1098l = y4;
                    } else {
                        this.f1098l = w0.a(Typeface.create(y4, 0), this.f1097k, (this.f1096j & 2) != 0);
                    }
                }
                this.f1099m = this.f1098l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1098l != null || (string = typedArray.getString(i14)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1097k == -1) {
            this.f1098l = Typeface.create(string, this.f1096j);
        } else {
            this.f1098l = w0.a(Typeface.create(string, 0), this.f1097k, (this.f1096j & 2) != 0);
        }
    }
}
