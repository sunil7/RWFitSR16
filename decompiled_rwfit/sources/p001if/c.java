package p001if;

import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.controls.a;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static c f14426a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f14427b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f14428c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f14429d;

    static {
        HashMap hashMap = new HashMap();
        f14427b = hashMap;
        HashMap hashMap2 = new HashMap();
        f14428c = hashMap2;
        HashMap hashMap3 = new HashMap();
        f14429d = hashMap3;
        hashMap.put(Facing.BACK, 1);
        hashMap.put(Facing.FRONT, 0);
        hashMap2.put(WhiteBalance.AUTO, 1);
        hashMap2.put(WhiteBalance.CLOUDY, 6);
        hashMap2.put(WhiteBalance.DAYLIGHT, 5);
        hashMap2.put(WhiteBalance.FLUORESCENT, 3);
        hashMap2.put(WhiteBalance.INCANDESCENT, 2);
        hashMap3.put(Hdr.OFF, 0);
        hashMap3.put(Hdr.ON, 18);
    }

    public static a a(HashMap hashMap, Integer num) {
        for (a aVar : hashMap.keySet()) {
            if (num.equals(hashMap.get(aVar))) {
                return aVar;
            }
        }
        return null;
    }
}
