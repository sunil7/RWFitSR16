package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

/* loaded from: classes.dex */
public final class z1 implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1129a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1130b;

    public /* synthetic */ z1(Object obj, int i3) {
        this.f1129a = i3;
        this.f1130b = obj;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i3, long j4) {
        t1 t1Var;
        switch (this.f1129a) {
            case 0:
                if (i3 != -1 && (t1Var = ((ListPopupWindow) this.f1130b).f758c) != null) {
                    t1Var.setListSelectionHidden(false);
                    break;
                }
                break;
            default:
                ((SearchView) this.f1130b).q(i3);
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i3 = this.f1129a;
    }
}
