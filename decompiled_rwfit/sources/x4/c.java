package x4;

import com.contrarywind.view.WheelView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class c extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public int f19781a = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: b, reason: collision with root package name */
    public int f19782b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f19783c;

    /* renamed from: d, reason: collision with root package name */
    public final WheelView f19784d;

    public c(WheelView wheelView, int i3) {
        this.f19784d = wheelView;
        this.f19783c = i3;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f19781a == Integer.MAX_VALUE) {
            this.f19781a = this.f19783c;
        }
        int i3 = this.f19781a;
        int i10 = (int) (i3 * 0.1f);
        this.f19782b = i10;
        if (i10 == 0) {
            if (i3 < 0) {
                this.f19782b = -1;
            } else {
                this.f19782b = 1;
            }
        }
        int abs = Math.abs(i3);
        WheelView wheelView = this.f19784d;
        if (abs <= 1) {
            wheelView.a();
            wheelView.getHandler().sendEmptyMessage(3000);
            return;
        }
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f19782b);
        if (!wheelView.f7080z) {
            float itemHeight = wheelView.getItemHeight();
            float itemsCount = ((wheelView.getItemsCount() - 1) - wheelView.getInitPosition()) * itemHeight;
            if (wheelView.getTotalScrollY() <= (-wheelView.getInitPosition()) * itemHeight || wheelView.getTotalScrollY() >= itemsCount) {
                wheelView.setTotalScrollY(wheelView.getTotalScrollY() - this.f19782b);
                wheelView.a();
                wheelView.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        wheelView.getHandler().sendEmptyMessage(1000);
        this.f19781a -= this.f19782b;
    }
}
