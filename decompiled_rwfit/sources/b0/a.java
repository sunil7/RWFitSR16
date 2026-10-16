package b0;

import android.util.Size;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Size f3041a = new Size(0, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final Size f3042b;

    /* renamed from: c, reason: collision with root package name */
    public static final Size f3043c;

    /* renamed from: d, reason: collision with root package name */
    public static final Size f3044d;
    public static final Size e;

    /* renamed from: f, reason: collision with root package name */
    public static final Size f3045f;

    static {
        new Size(GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 240);
        f3042b = new Size(GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
        f3043c = new Size(720, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
        f3044d = new Size(1280, 720);
        e = new Size(1920, 1080);
        f3045f = new Size(1920, 1440);
    }

    public static int a(Size size) {
        return size.getHeight() * size.getWidth();
    }
}
