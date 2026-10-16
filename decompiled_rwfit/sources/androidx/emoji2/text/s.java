package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class s implements TextWatcher, SpanWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2066a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f2067b = new AtomicInteger(0);

    public s(Object obj) {
        this.f2066a = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f2066a).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        ((TextWatcher) this.f2066a).beforeTextChanged(charSequence, i3, i10, i11);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i3, int i10) {
        if (this.f2067b.get() <= 0 || !(obj instanceof u)) {
            ((SpanWatcher) this.f2066a).onSpanAdded(spannable, obj, i3, i10);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i3, int i10, int i11, int i12) {
        int i13;
        int i14;
        if (this.f2067b.get() <= 0 || !(obj instanceof u)) {
            if (Build.VERSION.SDK_INT < 28) {
                if (i3 > i10) {
                    i3 = 0;
                }
                if (i11 > i12) {
                    i13 = i3;
                    i14 = 0;
                    ((SpanWatcher) this.f2066a).onSpanChanged(spannable, obj, i13, i10, i14, i12);
                }
            }
            i13 = i3;
            i14 = i11;
            ((SpanWatcher) this.f2066a).onSpanChanged(spannable, obj, i13, i10, i14, i12);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i3, int i10) {
        if (this.f2067b.get() <= 0 || !(obj instanceof u)) {
            ((SpanWatcher) this.f2066a).onSpanRemoved(spannable, obj, i3, i10);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        ((TextWatcher) this.f2066a).onTextChanged(charSequence, i3, i10, i11);
    }
}
