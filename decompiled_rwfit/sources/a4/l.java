package a4;

import android.graphics.Bitmap;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f106d;
    public static final Bitmap.Config[] e;

    /* renamed from: f, reason: collision with root package name */
    public static final Bitmap.Config[] f107f;

    /* renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f108g;

    /* renamed from: h, reason: collision with root package name */
    public static final Bitmap.Config[] f109h;

    /* renamed from: a, reason: collision with root package name */
    public final f f110a = new f(1);

    /* renamed from: b, reason: collision with root package name */
    public final y f111b = new y(1);

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f112c = new HashMap();

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        f106d = configArr;
        e = configArr;
        f107f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f108g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f109h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String c(int i3, Bitmap.Config config) {
        return "[" + i3 + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap d5 = d(bitmap.getConfig());
        Integer num2 = (Integer) d5.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                d5.remove(num);
                return;
            } else {
                d5.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(t4.l.c(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    public final Bitmap b(int i3, int i10, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int b3 = t4.l.b(i3, i10, config);
        f fVar = this.f110a;
        i iVar = (i) ((ArrayDeque) fVar.f78a).poll();
        if (iVar == null) {
            iVar = fVar.j();
        }
        k kVar = (k) iVar;
        kVar.f104b = b3;
        kVar.f105c = config;
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            configArr = e;
        } else {
            int i11 = j.f102a[config.ordinal()];
            configArr = i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? new Bitmap.Config[]{config} : f109h : f108g : f107f : f106d;
        }
        int length = configArr.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i12];
            Integer num = (Integer) d(config2).ceilingKey(Integer.valueOf(b3));
            if (num == null || num.intValue() > b3 * 8) {
                i12++;
            } else if (num.intValue() != b3 || (config2 != null ? !config2.equals(config) : config != null)) {
                fVar.g(kVar);
                int intValue = num.intValue();
                i iVar2 = (i) ((ArrayDeque) fVar.f78a).poll();
                if (iVar2 == null) {
                    iVar2 = fVar.j();
                }
                kVar = (k) iVar2;
                kVar.f104b = intValue;
                kVar.f105c = config2;
            }
        }
        Bitmap bitmap = (Bitmap) this.f111b.n(kVar);
        if (bitmap != null) {
            a(Integer.valueOf(kVar.f104b), bitmap);
            bitmap.reconfigure(i3, i10, config);
        }
        return bitmap;
    }

    public final NavigableMap d(Bitmap.Config config) {
        HashMap hashMap = this.f112c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        hashMap.put(config, treeMap);
        return treeMap;
    }

    public final void e(Bitmap bitmap) {
        int c9 = t4.l.c(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        f fVar = this.f110a;
        i iVar = (i) ((ArrayDeque) fVar.f78a).poll();
        if (iVar == null) {
            iVar = fVar.j();
        }
        k kVar = (k) iVar;
        kVar.f104b = c9;
        kVar.f105c = config;
        this.f111b.E(kVar, bitmap);
        NavigableMap d5 = d(bitmap.getConfig());
        Integer num = (Integer) d5.get(Integer.valueOf(kVar.f104b));
        d5.put(Integer.valueOf(kVar.f104b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final String toString() {
        StringBuilder t8 = l0.t("SizeConfigStrategy{groupedMap=");
        t8.append(this.f111b);
        t8.append(", sortedSizes=(");
        HashMap hashMap = this.f112c;
        for (Map.Entry entry : hashMap.entrySet()) {
            t8.append(entry.getKey());
            t8.append('[');
            t8.append(entry.getValue());
            t8.append("], ");
        }
        if (!hashMap.isEmpty()) {
            t8.replace(t8.length() - 2, t8.length(), "");
        }
        t8.append(")}");
        return t8.toString();
    }
}
