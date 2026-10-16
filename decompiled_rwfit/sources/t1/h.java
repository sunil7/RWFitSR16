package t1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.widget.k3;
import androidx.emoji2.text.k;

/* loaded from: classes.dex */
public final class h implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f18482a;

    /* renamed from: b, reason: collision with root package name */
    public k3 f18483b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18484c = true;

    public h(EditText editText) {
        this.f18482a = editText;
    }

    public static void a(EditText editText, int i3) {
        int length;
        if (i3 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            k a3 = k.a();
            if (editableText == null) {
                length = 0;
            } else {
                a3.getClass();
                length = editableText.length();
            }
            a3.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        EditText editText = this.f18482a;
        if (editText.isInEditMode() || !this.f18484c || k.f2036j == null || i10 > i11 || !(charSequence instanceof Spannable)) {
            return;
        }
        int b3 = k.a().b();
        if (b3 != 0) {
            if (b3 == 1) {
                k.a().e((Spannable) charSequence, i3, i11 + i3);
                return;
            } else if (b3 != 3) {
                return;
            }
        }
        k a3 = k.a();
        if (this.f18483b == null) {
            this.f18483b = new k3(editText);
        }
        a3.f(this.f18483b);
    }
}
