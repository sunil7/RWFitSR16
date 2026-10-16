package n;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.Size;
import android.view.Display;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;
import androidx.camera.core.impl.SurfaceConfig$ConfigType;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.Locale;

/* loaded from: classes.dex */
public final class y {
    public static final Size e = new Size(1920, 1080);

    /* renamed from: f, reason: collision with root package name */
    public static final Size f16318f = new Size(GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 240);

    /* renamed from: g, reason: collision with root package name */
    public static final Size f16319g = new Size(GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);

    /* renamed from: h, reason: collision with root package name */
    public static final Object f16320h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static volatile y f16321i;

    /* renamed from: a, reason: collision with root package name */
    public final DisplayManager f16322a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Size f16323b = null;

    /* renamed from: c, reason: collision with root package name */
    public final m0 f16324c = new m0(11);

    /* renamed from: d, reason: collision with root package name */
    public final n6.a f16325d = new n6.a((byte) 0, 6);

    public y(Context context) {
        this.f16322a = (DisplayManager) context.getSystemService("display");
    }

    public static y b(Context context) {
        if (f16321i == null) {
            synchronized (f16320h) {
                try {
                    if (f16321i == null) {
                        f16321i = new y(context);
                    }
                } finally {
                }
            }
        }
        return f16321i;
    }

    public static Display d(Display[] displayArr, boolean z5) {
        Display display = null;
        int i3 = -1;
        for (Display display2 : displayArr) {
            if (!z5 || display2.getState() != 1) {
                Point point = new Point();
                display2.getRealSize(point);
                int i10 = point.x * point.y;
                if (i10 > i3) {
                    display = display2;
                    i3 = i10;
                }
            }
        }
        return display;
    }

    public final Size a() {
        Size b3;
        Point point = new Point();
        c(false).getRealSize(point);
        Size size = new Size(point.x, point.y);
        Size size2 = b0.a.f3041a;
        if (size.getHeight() * size.getWidth() < b0.a.a(f16318f)) {
            size = ((SmallDisplaySizeQuirk) this.f16325d.f16381b) != null ? (Size) SmallDisplaySizeQuirk.f1211a.get(Build.MODEL.toUpperCase(Locale.US)) : null;
            if (size == null) {
                size = f16319g;
            }
        }
        if (size.getHeight() > size.getWidth()) {
            size = new Size(size.getHeight(), size.getWidth());
        }
        int height = size.getHeight() * size.getWidth();
        Size size3 = e;
        if (height > size3.getHeight() * size3.getWidth()) {
            size = size3;
        }
        if (((ExtraCroppingQuirk) this.f16324c.f16254b) != null && (b3 = ExtraCroppingQuirk.b(SurfaceConfig$ConfigType.PRIV)) != null) {
            if (b3.getHeight() * b3.getWidth() > size.getHeight() * size.getWidth()) {
                return b3;
            }
        }
        return size;
    }

    public final Display c(boolean z5) {
        Display[] displays = this.f16322a.getDisplays();
        if (displays.length == 1) {
            return displays[0];
        }
        Display d5 = d(displays, z5);
        if (d5 == null && z5) {
            d5 = d(displays, false);
        }
        if (d5 != null) {
            return d5;
        }
        throw new IllegalArgumentException("No display can be found from the input display manager!");
    }

    public final Size e() {
        if (this.f16323b != null) {
            return this.f16323b;
        }
        this.f16323b = a();
        return this.f16323b;
    }
}
