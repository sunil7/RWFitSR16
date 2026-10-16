package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;

/* loaded from: classes.dex */
public final class m0 implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f989a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f990b;

    public /* synthetic */ m0(Object obj, int i3) {
        this.f989a = i3;
        this.f990b = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j4) {
        switch (this.f989a) {
            case 0:
                o0 o0Var = (o0) this.f990b;
                o0Var.G.setSelection(i3);
                AppCompatSpinner appCompatSpinner = o0Var.G;
                if (appCompatSpinner.getOnItemClickListener() != null) {
                    appCompatSpinner.performItemClick(view, i3, o0Var.D.getItemId(i3));
                }
                o0Var.dismiss();
                break;
            case 1:
                ((SearchView) this.f990b).p(i3);
                break;
            default:
                MaterialAutoCompleteTextView materialAutoCompleteTextView = (MaterialAutoCompleteTextView) this.f990b;
                ListPopupWindow listPopupWindow = materialAutoCompleteTextView.e;
                MaterialAutoCompleteTextView.a(materialAutoCompleteTextView, i3 < 0 ? !listPopupWindow.f779z.isShowing() ? null : listPopupWindow.f758c.getSelectedItem() : materialAutoCompleteTextView.getAdapter().getItem(i3));
                AdapterView.OnItemClickListener onItemClickListener = materialAutoCompleteTextView.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i3 < 0) {
                        view = !listPopupWindow.f779z.isShowing() ? null : listPopupWindow.f758c.getSelectedView();
                        i3 = !listPopupWindow.f779z.isShowing() ? -1 : listPopupWindow.f758c.getSelectedItemPosition();
                        j4 = !listPopupWindow.f779z.isShowing() ? Long.MIN_VALUE : listPopupWindow.f758c.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(listPopupWindow.f758c, view, i3, j4);
                }
                listPopupWindow.dismiss();
                break;
        }
    }
}
