package h;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public abstract class s implements b0, x, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Rect f14203a;

    public static int o(ListAdapter listAdapter, Context context, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i10 = 0;
        int i11 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i12 = 0; i12 < count; i12++) {
            int itemViewType = listAdapter.getItemViewType(i12);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i12, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i3) {
                return i3;
            }
            if (measuredWidth > i10) {
                i10 = measuredWidth;
            }
        }
        return i10;
    }

    public static boolean v(k kVar) {
        int size = kVar.f14148f.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = kVar.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // h.x
    public final int getId() {
        return 0;
    }

    @Override // h.x
    public final void h(Context context, k kVar) {
    }

    @Override // h.x
    public final boolean k(m mVar) {
        return false;
    }

    @Override // h.x
    public final boolean l(m mVar) {
        return false;
    }

    public abstract void n(k kVar);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j4) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (h) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (h) listAdapter).f14138a.q((MenuItem) listAdapter.getItem(i3), this, !(this instanceof e) ? 0 : 4);
    }

    public abstract void p(View view);

    public abstract void q(boolean z5);

    public abstract void r(int i3);

    public abstract void s(int i3);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener);

    public abstract void t(boolean z5);

    public abstract void u(int i3);
}
