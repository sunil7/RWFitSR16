package androidx.appcompat.widget;

import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class c2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f879a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ListPopupWindow f880b;

    public /* synthetic */ c2(ListPopupWindow listPopupWindow, int i3) {
        this.f879a = i3;
        this.f880b = listPopupWindow;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListPopupWindow listPopupWindow = this.f880b;
        switch (this.f879a) {
            case 0:
                t1 t1Var = listPopupWindow.f758c;
                if (t1Var != null) {
                    t1Var.setListSelectionHidden(true);
                    t1Var.requestLayout();
                    break;
                }
                break;
            default:
                t1 t1Var2 = listPopupWindow.f758c;
                if (t1Var2 != null) {
                    WeakHashMap weakHashMap = l1.z0.f15748a;
                    if (l1.k0.b(t1Var2) && listPopupWindow.f758c.getCount() > listPopupWindow.f758c.getChildCount() && listPopupWindow.f758c.getChildCount() <= listPopupWindow.f767m) {
                        listPopupWindow.f779z.setInputMethodMode(2);
                        listPopupWindow.d();
                        break;
                    }
                }
                break;
        }
    }
}
