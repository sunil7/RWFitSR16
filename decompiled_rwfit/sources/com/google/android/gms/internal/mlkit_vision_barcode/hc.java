package com.google.android.gms.internal.mlkit_vision_barcode;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;

/* loaded from: classes.dex */
public abstract class hc {
    public static void a(a4.a aVar) {
        aVar.getClass();
        CharSequence charSequence = (CharSequence) aVar.f78a;
        if (charSequence instanceof Spanned) {
            if (!(charSequence instanceof Spannable)) {
                aVar.f78a = SpannableString.valueOf(charSequence);
            }
            CharSequence charSequence2 = (CharSequence) aVar.f78a;
            charSequence2.getClass();
            Spannable spannable = (Spannable) charSequence2;
            for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                if ((obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan)) {
                    spannable.removeSpan(obj);
                }
            }
        }
    }

    public static float b(int i3, float f2, int i10, int i11) {
        float f10;
        if (f2 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i3 == 0) {
            f10 = i11;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    return -3.4028235E38f;
                }
                return f2;
            }
            f10 = i10;
        }
        return f2 * f10;
    }
}
