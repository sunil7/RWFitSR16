package x4;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class a extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public float f19777a = 2.1474836E9f;

    /* renamed from: b, reason: collision with root package name */
    public final float f19778b;

    /* renamed from: c, reason: collision with root package name */
    public final WheelView f19779c;

    public a(WheelView wheelView, float f2) {
        this.f19779c = wheelView;
        this.f19778b = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f19777a == 2.1474836E9f) {
            float f2 = this.f19778b;
            if (Math.abs(f2) > 2000.0f) {
                this.f19777a = f2 <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f19777a = f2;
            }
        }
        float abs = Math.abs(this.f19777a);
        WheelView wheelView = this.f19779c;
        if (abs >= 0.0f && Math.abs(this.f19777a) <= 20.0f) {
            wheelView.a();
            wheelView.getHandler().sendEmptyMessage(2000);
            return;
        }
        float f10 = (int) (this.f19777a / 100.0f);
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f10);
        if (!wheelView.f7080z) {
            float itemHeight = wheelView.getItemHeight();
            float f11 = (-wheelView.getInitPosition()) * itemHeight;
            float itemsCount = ((wheelView.getItemsCount() - 1) - wheelView.getInitPosition()) * itemHeight;
            double d5 = itemHeight * 0.25d;
            if (wheelView.getTotalScrollY() - d5 < f11) {
                f11 = wheelView.getTotalScrollY() + f10;
            } else if (wheelView.getTotalScrollY() + d5 > itemsCount) {
                itemsCount = wheelView.getTotalScrollY() + f10;
            }
            if (wheelView.getTotalScrollY() <= f11) {
                this.f19777a = 40.0f;
                wheelView.setTotalScrollY((int) f11);
            } else if (wheelView.getTotalScrollY() >= itemsCount) {
                wheelView.setTotalScrollY((int) itemsCount);
                this.f19777a = -40.0f;
            }
        }
        float f12 = this.f19777a;
        if (f12 < 0.0f) {
            this.f19777a = f12 + 20.0f;
        } else {
            this.f19777a = f12 - 20.0f;
        }
        wheelView.getHandler().sendEmptyMessage(1000);
    }
}
