package qf;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final ef.b f17936a = ef.b.a(b.class.getSimpleName());

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f17937b;

    static {
        HashMap hashMap = new HashMap();
        f17937b = hashMap;
        hashMap.put(new wf.b(176, 144), 2);
        hashMap.put(new wf.b(GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 240), 7);
        hashMap.put(new wf.b(352, 288), 3);
        hashMap.put(new wf.b(720, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH), 4);
        hashMap.put(new wf.b(1280, 720), 5);
        hashMap.put(new wf.b(1920, 1080), 6);
        hashMap.put(new wf.b(3840, 2160), 8);
    }
}
