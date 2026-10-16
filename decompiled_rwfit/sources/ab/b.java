package ab;

import android.os.SystemClock;
import com.google.android.material.progressindicator.BaseProgressIndicator;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f147a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseProgressIndicator f148b;

    public /* synthetic */ b(BaseProgressIndicator baseProgressIndicator, int i3) {
        this.f147a = i3;
        this.f148b = baseProgressIndicator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseProgressIndicator baseProgressIndicator = this.f148b;
        switch (this.f147a) {
            case 0:
                int i3 = BaseProgressIndicator.f10705l;
                if (baseProgressIndicator.f10709d > 0) {
                    SystemClock.uptimeMillis();
                }
                baseProgressIndicator.setVisibility(0);
                break;
            default:
                int i10 = BaseProgressIndicator.f10705l;
                ((l) baseProgressIndicator.getCurrentDrawable()).e(false, false, true);
                if ((baseProgressIndicator.getProgressDrawable() == null || !baseProgressIndicator.getProgressDrawable().isVisible()) && (baseProgressIndicator.getIndeterminateDrawable() == null || !baseProgressIndicator.getIndeterminateDrawable().isVisible())) {
                    baseProgressIndicator.setVisibility(4);
                }
                baseProgressIndicator.getClass();
                break;
        }
    }
}
