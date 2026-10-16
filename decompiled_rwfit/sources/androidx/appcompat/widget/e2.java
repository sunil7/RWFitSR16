package androidx.appcompat.widget;

import android.os.Handler;
import android.widget.AbsListView;

/* loaded from: classes.dex */
public final class e2 implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListPopupWindow f890a;

    public e2(ListPopupWindow listPopupWindow) {
        this.f890a = listPopupWindow;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i3, int i10, int i11) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i3) {
        if (i3 == 1) {
            ListPopupWindow listPopupWindow = this.f890a;
            if (listPopupWindow.f779z.getInputMethodMode() == 2 || listPopupWindow.f779z.getContentView() == null) {
                return;
            }
            Handler handler = listPopupWindow.f775v;
            c2 c2Var = listPopupWindow.r;
            handler.removeCallbacks(c2Var);
            c2Var.run();
        }
    }
}
