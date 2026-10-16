package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class v implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityChooserView f1066a;

    public v(ActivityChooserView activityChooserView) {
        this.f1066a = activityChooserView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityChooserView activityChooserView = this.f1066a;
        u uVar = activityChooserView.f667a;
        if (view == activityChooserView.f671f) {
            activityChooserView.a();
            uVar.getClass();
            throw null;
        }
        if (view != activityChooserView.f670d) {
            throw new IllegalArgumentException();
        }
        uVar.getClass();
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        l lVar;
        h.k kVar;
        ActivityChooserView activityChooserView = this.f1066a;
        PopupWindow.OnDismissListener onDismissListener = activityChooserView.f675j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        l1.d dVar = activityChooserView.f672g;
        if (dVar == null || (lVar = dVar.f15684a) == null || (kVar = lVar.f955c) == null) {
            return;
        }
        kVar.c(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j4) {
        ((u) adapterView.getAdapter()).getClass();
        ActivityChooserView activityChooserView = this.f1066a;
        activityChooserView.a();
        activityChooserView.f667a.getClass();
        throw null;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ActivityChooserView activityChooserView = this.f1066a;
        if (view != activityChooserView.f671f) {
            throw new IllegalArgumentException();
        }
        activityChooserView.f667a.getClass();
        throw null;
    }
}
