package p001if;

import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f14421a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f14422b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f14423c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f14424d;
    public static final HashMap e;

    static {
        HashMap hashMap = new HashMap();
        f14422b = hashMap;
        HashMap hashMap2 = new HashMap();
        f14423c = hashMap2;
        HashMap hashMap3 = new HashMap();
        f14424d = hashMap3;
        HashMap hashMap4 = new HashMap();
        e = hashMap4;
        hashMap.put(Flash.OFF, "off");
        hashMap.put(Flash.ON, "on");
        hashMap.put(Flash.AUTO, "auto");
        hashMap.put(Flash.TORCH, "torch");
        hashMap3.put(Facing.BACK, 0);
        hashMap3.put(Facing.FRONT, 1);
        hashMap2.put(WhiteBalance.AUTO, "auto");
        hashMap2.put(WhiteBalance.INCANDESCENT, "incandescent");
        hashMap2.put(WhiteBalance.FLUORESCENT, "fluorescent");
        hashMap2.put(WhiteBalance.DAYLIGHT, "daylight");
        hashMap2.put(WhiteBalance.CLOUDY, "cloudy-daylight");
        hashMap4.put(Hdr.OFF, "auto");
        hashMap4.put(Hdr.ON, "hdr");
    }

    public static com.otaliastudios.cameraview.controls.a a(HashMap hashMap, Object obj) {
        for (com.otaliastudios.cameraview.controls.a aVar : hashMap.keySet()) {
            if (obj.equals(hashMap.get(aVar))) {
                return aVar;
            }
        }
        return null;
    }
}
