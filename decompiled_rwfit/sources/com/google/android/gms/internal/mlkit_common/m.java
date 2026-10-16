package com.google.android.gms.internal.mlkit_common;

import android.graphics.Paint;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.p;
import androidx.core.widget.q;
import androidx.core.widget.r;
import androidx.core.widget.s;
import androidx.core.widget.t;
import androidx.core.widget.u;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static l f9181a;

    public static j1.d a(AppCompatTextView appCompatTextView) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            return new j1.d(t.b(appCompatTextView));
        }
        TextPaint textPaint = new TextPaint(appCompatTextView.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int a3 = r.a(appCompatTextView);
        int d5 = r.d(appCompatTextView);
        if (appCompatTextView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else {
            if (i3 < 28 || (appCompatTextView.getInputType() & 15) != 3) {
                boolean z5 = q.b(appCompatTextView) == 1;
                switch (q.c(appCompatTextView)) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        break;
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (z5) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        }
                        break;
                }
            } else {
                byte directionality = Character.getDirectionality(t.a(s.a(q.d(appCompatTextView)))[0].codePointAt(0));
                textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            }
        }
        return new j1.d(textPaint, textDirectionHeuristic, a3, d5);
    }

    public static void b(TextView textView, int i3) {
        pd.d(i3);
        if (Build.VERSION.SDK_INT >= 28) {
            t.c(textView, i3);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = p.a(textView) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i3 > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), i3 + i10, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void c(TextView textView, int i3) {
        pd.d(i3);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = p.a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i3 > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i3 - i10);
        }
    }

    public static ActionMode.Callback d(ActionMode.Callback callback) {
        return callback instanceof u ? ((u) callback).f1978a : callback;
    }

    public static ActionMode.Callback e(ActionMode.Callback callback, TextView textView) {
        return (Build.VERSION.SDK_INT > 27 || (callback instanceof u) || callback == null) ? callback : new u(callback, textView);
    }
}
