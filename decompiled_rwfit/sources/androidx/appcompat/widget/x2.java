package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class x2 implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f1108a;

    public x2(SearchView searchView) {
        this.f1108a = searchView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
        SearchView searchView = this.f1108a;
        if (searchView.f793b0 != null) {
            SearchView.SearchAutoComplete searchAutoComplete = searchView.f798p;
            if (!searchAutoComplete.isPopupShowing() || searchAutoComplete.getListSelection() == -1) {
                if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) != 0 && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i3 == 66) {
                    view.cancelLongPress();
                    searchView.getContext().startActivity(searchView.l("android.intent.action.SEARCH", null, null, searchAutoComplete.getText().toString()));
                    return true;
                }
            } else if (searchView.f793b0 != null && searchView.O != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
                if (i3 == 66 || i3 == 84 || i3 == 61) {
                    searchView.p(searchAutoComplete.getListSelection());
                    return true;
                }
                if (i3 == 21 || i3 == 22) {
                    searchAutoComplete.setSelection(i3 == 21 ? 0 : searchAutoComplete.length());
                    searchAutoComplete.setListSelection(0);
                    searchAutoComplete.clearListSelection();
                    searchAutoComplete.a();
                    return true;
                }
                if (i3 == 19) {
                    searchAutoComplete.getListSelection();
                    return false;
                }
            }
        }
        return false;
    }
}
