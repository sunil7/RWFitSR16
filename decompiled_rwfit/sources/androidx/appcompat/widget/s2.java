package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.example.test.ui.device.activity.ContactDetailActivity;
import com.example.test.ui.device.activity.ScheduleAddActivity;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes.dex */
public final class s2 implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1046a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1047b;

    public /* synthetic */ s2(Object obj, int i3) {
        this.f1046a = i3;
        this.f1047b = obj;
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void d(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void e(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void f(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void g(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void h(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void i(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void j(int i3, int i10, int i11, CharSequence charSequence) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        r0 = false;
        boolean z5 = false;
        Object obj = this.f1047b;
        switch (this.f1046a) {
            case 0:
            case 1:
                break;
            case 2:
                int i3 = ScheduleAddActivity.L;
                ((f6.p1) ((ScheduleAddActivity) obj).f7247z.getValue()).f13223c.setText(String.format(Locale.ENGLISH, "%d/250", Arrays.copyOf(new Object[]{Integer.valueOf(editable != null ? editable.length() : 0)}, 1)));
                break;
            case 3:
                com.google.android.material.textfield.e eVar = (com.google.android.material.textfield.e) obj;
                if (eVar.f10921a.getSuffixText() == null) {
                    if (eVar.f10921a.hasFocus() && editable.length() > 0) {
                        z5 = true;
                    }
                    eVar.d(z5);
                    break;
                }
                break;
            default:
                TextInputLayout textInputLayout = (TextInputLayout) obj;
                textInputLayout.s(true ^ textInputLayout.f10877u1, false);
                if (textInputLayout.f10853j) {
                    textInputLayout.n(editable.length());
                }
                if (textInputLayout.f10869q) {
                    textInputLayout.t(editable.length());
                    break;
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        int i12 = this.f1046a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        switch (this.f1046a) {
            case 0:
                SearchView searchView = (SearchView) this.f1047b;
                Editable text = searchView.f798p.getText();
                searchView.V = text;
                boolean isEmpty = TextUtils.isEmpty(text);
                searchView.x(!isEmpty);
                int i12 = 8;
                if (searchView.U && !searchView.N && isEmpty) {
                    searchView.f802u.setVisibility(8);
                    i12 = 0;
                }
                searchView.f804w.setVisibility(i12);
                searchView.t();
                searchView.w();
                charSequence.toString();
                break;
            case 1:
                if (kotlin.text.m.c(String.valueOf(charSequence), " ", false)) {
                    ContactDetailActivity contactDetailActivity = (ContactDetailActivity) this.f1047b;
                    ContactDetailActivity.R0(contactDetailActivity).f13288c.setText(kotlin.text.m.r(String.valueOf(charSequence), " ", ""));
                    ((f6.s) contactDetailActivity.f7247z.getValue()).f13288c.setSelection(i3);
                    break;
                }
                break;
        }
    }
}
