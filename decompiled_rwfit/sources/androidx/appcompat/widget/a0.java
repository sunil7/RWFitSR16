package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f869a;

    /* renamed from: b, reason: collision with root package name */
    public final n.m0 f870b;

    public a0(TextView textView) {
        this.f869a = textView;
        this.f870b = new n.m0(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((com.google.android.gms.internal.mlkit_vision_common.b0) this.f870b.f16254b).a(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = this.f869a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i3, 0);
        try {
            boolean z5 = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_emojiCompatEnabled) ? obtainStyledAttributes.getBoolean(R$styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            obtainStyledAttributes.recycle();
            d(z5);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public final void c(boolean z5) {
        ((com.google.android.gms.internal.mlkit_vision_common.b0) this.f870b.f16254b).c(z5);
    }

    public final void d(boolean z5) {
        ((com.google.android.gms.internal.mlkit_vision_common.b0) this.f870b.f16254b).d(z5);
    }
}
