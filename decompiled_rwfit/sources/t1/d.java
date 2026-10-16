package t1;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.k;

/* loaded from: classes.dex */
public final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f18474a;

    /* renamed from: b, reason: collision with root package name */
    public c f18475b;

    public d(TextView textView) {
        this.f18474a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i3, int i10, Spanned spanned, int i11, int i12) {
        TextView textView = this.f18474a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int b3 = k.a().b();
        if (b3 != 0) {
            if (b3 == 1) {
                if ((i12 == 0 && i11 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i3 != 0 || i10 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i3, i10);
                }
                return k.a().e(charSequence, 0, charSequence.length());
            }
            if (b3 != 3) {
                return charSequence;
            }
        }
        k a3 = k.a();
        if (this.f18475b == null) {
            this.f18475b = new c(textView, this);
        }
        a3.f(this.f18475b);
        return charSequence;
    }
}
