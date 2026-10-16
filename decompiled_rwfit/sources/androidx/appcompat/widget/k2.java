package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class k2 extends ListPopupWindow implements g2 {
    public static final Method D;
    public com.example.test.ui.device.activity.i0 C;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                D = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // androidx.appcompat.widget.g2
    public final void m(h.k kVar, h.m mVar) {
        com.example.test.ui.device.activity.i0 i0Var = this.C;
        if (i0Var != null) {
            i0Var.m(kVar, mVar);
        }
    }

    @Override // androidx.appcompat.widget.g2
    public final void n(h.k kVar, h.m mVar) {
        com.example.test.ui.device.activity.i0 i0Var = this.C;
        if (i0Var != null) {
            i0Var.n(kVar, mVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.MenuPopupWindow$MenuDropDownListView, androidx.appcompat.widget.t1] */
    @Override // androidx.appcompat.widget.ListPopupWindow
    public final t1 q(final Context context, final boolean z5) {
        ?? r02 = new t1(context, z5) { // from class: androidx.appcompat.widget.MenuPopupWindow$MenuDropDownListView

            /* renamed from: m, reason: collision with root package name */
            public final int f780m;

            /* renamed from: n, reason: collision with root package name */
            public final int f781n;

            /* renamed from: o, reason: collision with root package name */
            public g2 f782o;

            /* renamed from: p, reason: collision with root package name */
            public h.m f783p;

            {
                super(context, z5);
                if (1 == j2.a(context.getResources().getConfiguration())) {
                    this.f780m = 21;
                    this.f781n = 22;
                } else {
                    this.f780m = 22;
                    this.f781n = 21;
                }
            }

            @Override // androidx.appcompat.widget.t1, android.view.View
            public final boolean onHoverEvent(MotionEvent motionEvent) {
                h.h hVar;
                int i3;
                int pointToPosition;
                int i10;
                if (this.f782o != null) {
                    ListAdapter adapter = getAdapter();
                    if (adapter instanceof HeaderViewListAdapter) {
                        HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                        i3 = headerViewListAdapter.getHeadersCount();
                        hVar = (h.h) headerViewListAdapter.getWrappedAdapter();
                    } else {
                        hVar = (h.h) adapter;
                        i3 = 0;
                    }
                    h.m b3 = (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i10 = pointToPosition - i3) < 0 || i10 >= hVar.getCount()) ? null : hVar.b(i10);
                    h.m mVar = this.f783p;
                    if (mVar != b3) {
                        h.k kVar = hVar.f14138a;
                        if (mVar != null) {
                            this.f782o.n(kVar, mVar);
                        }
                        this.f783p = b3;
                        if (b3 != null) {
                            this.f782o.m(kVar, b3);
                        }
                    }
                }
                return super.onHoverEvent(motionEvent);
            }

            @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
            public final boolean onKeyDown(int i3, KeyEvent keyEvent) {
                ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
                if (listMenuItemView != null && i3 == this.f780m) {
                    if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                        performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                    }
                    return true;
                }
                if (listMenuItemView == null || i3 != this.f781n) {
                    return super.onKeyDown(i3, keyEvent);
                }
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                (adapter instanceof HeaderViewListAdapter ? (h.h) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (h.h) adapter).f14138a.c(false);
                return true;
            }

            public void setHoverListener(g2 g2Var) {
                this.f782o = g2Var;
            }

            @Override // androidx.appcompat.widget.t1, android.widget.AbsListView
            public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
                super.setSelector(drawable);
            }
        };
        r02.setHoverListener(this);
        return r02;
    }
}
