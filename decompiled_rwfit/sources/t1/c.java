package t1;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.k;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class c extends androidx.emoji2.text.h {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f18472a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f18473b;

    public c(TextView textView, d dVar) {
        this.f18472a = new WeakReference(textView);
        this.f18473b = new WeakReference(dVar);
    }

    @Override // androidx.emoji2.text.h
    public final void b() {
        InputFilter[] filters;
        int length;
        TextView textView = (TextView) this.f18472a.get();
        InputFilter inputFilter = (InputFilter) this.f18473b.get();
        if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
            return;
        }
        for (InputFilter inputFilter2 : filters) {
            if (inputFilter2 == inputFilter) {
                if (textView.isAttachedToWindow()) {
                    CharSequence text = textView.getText();
                    k a3 = k.a();
                    if (text == null) {
                        length = 0;
                    } else {
                        a3.getClass();
                        length = text.length();
                    }
                    CharSequence e = a3.e(text, 0, length);
                    if (text == e) {
                        return;
                    }
                    int selectionStart = Selection.getSelectionStart(e);
                    int selectionEnd = Selection.getSelectionEnd(e);
                    textView.setText(e);
                    if (e instanceof Spannable) {
                        Spannable spannable = (Spannable) e;
                        if (selectionStart >= 0 && selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionStart, selectionEnd);
                            return;
                        } else if (selectionStart >= 0) {
                            Selection.setSelection(spannable, selectionStart);
                            return;
                        } else {
                            if (selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionEnd);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
    }
}
