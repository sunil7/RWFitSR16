package j7;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.widget.OverScroller;
import androidx.work.impl.foreground.SystemForegroundService;

/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15344a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f15345b;

    /* renamed from: c, reason: collision with root package name */
    public int f15346c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f15347d;
    public final /* synthetic */ Object e;

    public l(SystemForegroundService systemForegroundService, int i3, Notification notification, int i10) {
        this.e = systemForegroundService;
        this.f15345b = i3;
        this.f15347d = notification;
        this.f15346c = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15344a) {
            case 0:
                OverScroller overScroller = (OverScroller) this.f15347d;
                if (!overScroller.isFinished() && overScroller.computeScrollOffset()) {
                    int currX = overScroller.getCurrX();
                    int currY = overScroller.getCurrY();
                    m mVar = (m) this.e;
                    mVar.f15359m.postTranslate(this.f15345b - currX, this.f15346c - currY);
                    mVar.a();
                    this.f15345b = currX;
                    this.f15346c = currY;
                    mVar.f15354h.postOnAnimation(this);
                    break;
                }
                break;
            default:
                int i3 = Build.VERSION.SDK_INT;
                Notification notification = (Notification) this.f15347d;
                int i10 = this.f15345b;
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.e;
                if (i3 < 29) {
                    systemForegroundService.startForeground(i10, notification);
                    break;
                } else {
                    systemForegroundService.startForeground(i10, notification, this.f15346c);
                    break;
                }
        }
    }

    public l(m mVar, Context context) {
        this.e = mVar;
        this.f15347d = new OverScroller(context);
    }
}
