package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class u2 implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1064a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1065b;

    public /* synthetic */ u2(Object obj, int i3) {
        this.f1064a = i3;
        this.f1065b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z5) {
        switch (this.f1064a) {
            case 0:
                SearchView searchView = (SearchView) this.f1065b;
                View.OnFocusChangeListener onFocusChangeListener = searchView.K;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z5);
                    break;
                }
                break;
            case 1:
                ((com.google.android.material.textfield.e) this.f1065b).d(!TextUtils.isEmpty(((EditText) view).getText()) && z5);
                break;
            default:
                com.google.android.material.textfield.l lVar = (com.google.android.material.textfield.l) this.f1065b;
                lVar.f10921a.setEndIconActivated(z5);
                if (!z5) {
                    lVar.g(false);
                    lVar.f10913i = false;
                    break;
                }
                break;
        }
    }
}
