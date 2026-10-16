package yh;

import com.example.test.ui.device.activity.ScreenLedLevelActivity;
import java.util.List;

/* loaded from: classes2.dex */
public final class h implements t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f20162a;

    public /* synthetic */ h(Object obj) {
        this.f20162a = obj;
    }

    @Override // t6.a
    public void v(String data) {
        kotlin.jvm.internal.e.f(data, "data");
        int i3 = ScreenLedLevelActivity.H;
        ScreenLedLevelActivity screenLedLevelActivity = (ScreenLedLevelActivity) this.f20162a;
        int indexOf = ((List) screenLedLevelActivity.F.getValue()).indexOf(data);
        if (indexOf == 0) {
            screenLedLevelActivity.S0().setOpen(false);
        } else {
            screenLedLevelActivity.S0().setOpen(true);
            screenLedLevelActivity.S0().setLcdLevel(indexOf);
        }
        screenLedLevelActivity.R0();
    }
}
