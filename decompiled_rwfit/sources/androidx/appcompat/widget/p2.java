package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class p2 extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1024a = 1;

    /* renamed from: b, reason: collision with root package name */
    public Object f1025b;

    public /* synthetic */ p2() {
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        switch (this.f1024a) {
            case 0:
                return ((ScrollingTabContainerView) this.f1025b).f785b.getChildCount();
            default:
                return 7;
        }
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i3) {
        switch (this.f1024a) {
            case 0:
                ((q2) ((ScrollingTabContainerView) this.f1025b).f785b.getChildAt(i3)).getClass();
                return null;
            default:
                return ((ArrayList) this.f1025b).get(i3);
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        switch (this.f1024a) {
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        switch (this.f1024a) {
            case 0:
                if (view != null) {
                    getItem(i3);
                    throw null;
                }
                getItem(i3);
                ScrollingTabContainerView scrollingTabContainerView = (ScrollingTabContainerView) this.f1025b;
                new q2(scrollingTabContainerView, scrollingTabContainerView.getContext());
                throw null;
            default:
                throw null;
        }
    }

    public p2(ScrollingTabContainerView scrollingTabContainerView) {
        this.f1025b = scrollingTabContainerView;
    }
}
