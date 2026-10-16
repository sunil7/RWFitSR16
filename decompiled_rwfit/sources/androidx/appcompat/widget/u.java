package androidx.appcompat.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;

/* loaded from: classes.dex */
public final class u extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityChooserView f1063a;

    public u(ActivityChooserView activityChooserView) {
        this.f1063a = activityChooserView;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        throw null;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i3) {
        throw null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i3) {
        return 0;
    }

    @Override // android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        ActivityChooserView activityChooserView = this.f1063a;
        if (view == null || view.getId() != R$id.list_item) {
            view = LayoutInflater.from(activityChooserView.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
        }
        activityChooserView.getContext().getPackageManager();
        throw null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 3;
    }
}
