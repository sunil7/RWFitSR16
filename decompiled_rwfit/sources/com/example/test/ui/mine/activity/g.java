package com.example.test.ui.mine.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.example.test.ui.XXBaseActivity;
import f6.f0;
import f6.l1;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes.dex */
public final class g implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8128a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XXBaseActivity f8129b;

    public /* synthetic */ g(XXBaseActivity xXBaseActivity, int i3) {
        this.f8128a = i3;
        this.f8129b = xXBaseActivity;
    }

    private final void a(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void b(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void c(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void d(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void e(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void f(int i3, int i10, int i11, CharSequence charSequence) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        XXBaseActivity xXBaseActivity = this.f8129b;
        switch (this.f8128a) {
            case 0:
                if (editable != null) {
                    int i3 = FeedBackActivity.G;
                    ((f0) ((FeedBackActivity) xXBaseActivity).f7247z.getValue()).f12846g.setText(editable.length() + "/400");
                    break;
                }
                break;
            case 1:
                InputActivity inputActivity = (InputActivity) xXBaseActivity;
                InputActivity.R0(inputActivity).f13162c.setText(String.format(Locale.ENGLISH, "%d/%d", Arrays.copyOf(new Object[]{Integer.valueOf(editable != null ? editable.length() : 0), Integer.valueOf(inputActivity.E)}, 2)));
                break;
            default:
                if (editable != null) {
                    int i10 = RingFeedBackActivity.I;
                    ((l1) ((RingFeedBackActivity) xXBaseActivity).f7247z.getValue()).f13091g.setText(editable.length() + "/400");
                    break;
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        int i12 = this.f8128a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        int i12 = this.f8128a;
    }
}
