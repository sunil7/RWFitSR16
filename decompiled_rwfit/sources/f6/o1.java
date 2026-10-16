package f6;

import android.view.View;
import android.widget.RelativeLayout;
import com.bingoogolapple.qrcode.zxing.ZXingView;
import com.example.test.ui.view.TitleView;

/* loaded from: classes.dex */
public final class o1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f13164a;

    /* renamed from: b, reason: collision with root package name */
    public final TitleView f13165b;

    /* renamed from: c, reason: collision with root package name */
    public final ZXingView f13166c;

    public o1(RelativeLayout relativeLayout, TitleView titleView, ZXingView zXingView) {
        this.f13164a = relativeLayout;
        this.f13165b = titleView;
        this.f13166c = zXingView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13164a;
    }
}
