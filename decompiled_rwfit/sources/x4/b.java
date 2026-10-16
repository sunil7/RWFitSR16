package x4;

import android.os.Handler;
import android.os.Message;
import com.contrarywind.view.WheelView;
import pe.o;

/* loaded from: classes.dex */
public final class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WheelView f19780a;

    public b(WheelView wheelView) {
        this.f19780a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i3 = message.what;
        WheelView wheelView = this.f19780a;
        if (i3 == 1000) {
            wheelView.invalidate();
            return;
        }
        if (i3 == 2000) {
            wheelView.f(WheelView.ACTION.FLING);
        } else if (i3 == 3000 && wheelView.e != null) {
            wheelView.postDelayed(new o(wheelView, 14), 200L);
        }
    }
}
