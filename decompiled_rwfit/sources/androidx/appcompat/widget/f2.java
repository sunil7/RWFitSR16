package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class f2 implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f898a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f899b;

    public /* synthetic */ f2(Object obj, int i3) {
        this.f898a = i3;
        this.f899b = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        c0 c0Var;
        switch (this.f898a) {
            case 0:
                int action = motionEvent.getAction();
                int x10 = (int) motionEvent.getX();
                int y4 = (int) motionEvent.getY();
                ListPopupWindow listPopupWindow = (ListPopupWindow) this.f899b;
                if (action == 0 && (c0Var = listPopupWindow.f779z) != null && c0Var.isShowing() && x10 >= 0 && x10 < listPopupWindow.f779z.getWidth() && y4 >= 0 && y4 < listPopupWindow.f779z.getHeight()) {
                    listPopupWindow.f775v.postDelayed(listPopupWindow.r, 250L);
                    break;
                } else if (action == 1) {
                    listPopupWindow.f775v.removeCallbacks(listPopupWindow.r);
                    break;
                }
                break;
            default:
                if (motionEvent.getAction() == 0) {
                    s3.c cVar = (s3.c) this.f899b;
                    if (cVar.c()) {
                        cVar.a();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
