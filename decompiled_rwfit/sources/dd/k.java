package dd;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.zxing.NotFoundException;
import com.tencent.connect.common.Constants;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f12338a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f12339b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f12340c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f12341d;

    static {
        HashMap hashMap = new HashMap();
        f12338a = hashMap;
        hashMap.put("00", j.a(18));
        hashMap.put("01", j.a(14));
        hashMap.put("02", j.a(14));
        hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, j.b(20));
        hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, j.a(6));
        hashMap.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, j.a(6));
        hashMap.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, j.a(6));
        hashMap.put(Constants.VIA_REPORT_TYPE_WPA_STATE, j.a(6));
        hashMap.put(Constants.VIA_REPORT_TYPE_START_GROUP, j.a(6));
        hashMap.put("20", j.a(2));
        hashMap.put("21", j.b(20));
        hashMap.put(Constants.VIA_REPORT_TYPE_DATALINE, j.b(29));
        hashMap.put("30", j.b(8));
        hashMap.put("37", j.b(8));
        for (int i3 = 90; i3 <= 99; i3++) {
            f12338a.put(String.valueOf(i3), j.b(30));
        }
        HashMap hashMap2 = new HashMap();
        f12339b = hashMap2;
        hashMap2.put("240", j.b(30));
        hashMap2.put("241", j.b(30));
        hashMap2.put("242", j.b(6));
        hashMap2.put("250", j.b(30));
        hashMap2.put("251", j.b(30));
        hashMap2.put("253", j.b(17));
        hashMap2.put("254", j.b(20));
        hashMap2.put("400", j.b(30));
        hashMap2.put("401", j.b(30));
        hashMap2.put("402", j.a(17));
        hashMap2.put("403", j.b(30));
        hashMap2.put("410", j.a(13));
        hashMap2.put("411", j.a(13));
        hashMap2.put("412", j.a(13));
        hashMap2.put("413", j.a(13));
        hashMap2.put("414", j.a(13));
        hashMap2.put("420", j.b(20));
        hashMap2.put("421", j.b(15));
        hashMap2.put("422", j.a(3));
        hashMap2.put("423", j.b(15));
        hashMap2.put("424", j.a(3));
        hashMap2.put("425", j.a(3));
        hashMap2.put("426", j.a(3));
        f12340c = new HashMap();
        for (int i10 = 310; i10 <= 316; i10++) {
            f12340c.put(String.valueOf(i10), j.a(6));
        }
        for (int i11 = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH; i11 <= 336; i11++) {
            f12340c.put(String.valueOf(i11), j.a(6));
        }
        for (int i12 = 340; i12 <= 357; i12++) {
            f12340c.put(String.valueOf(i12), j.a(6));
        }
        for (int i13 = 360; i13 <= 369; i13++) {
            f12340c.put(String.valueOf(i13), j.a(6));
        }
        HashMap hashMap3 = f12340c;
        hashMap3.put("390", j.b(15));
        hashMap3.put("391", j.b(18));
        hashMap3.put("392", j.b(15));
        hashMap3.put("393", j.b(18));
        hashMap3.put("703", j.b(30));
        HashMap hashMap4 = new HashMap();
        f12341d = hashMap4;
        hashMap4.put("7001", j.a(13));
        hashMap4.put("7002", j.b(30));
        hashMap4.put("7003", j.a(10));
        hashMap4.put("8001", j.a(14));
        hashMap4.put("8002", j.b(20));
        hashMap4.put("8003", j.b(30));
        hashMap4.put("8004", j.b(30));
        hashMap4.put("8005", j.a(6));
        hashMap4.put("8006", j.a(18));
        hashMap4.put("8007", j.b(30));
        hashMap4.put("8008", j.b(12));
        hashMap4.put("8018", j.a(18));
        hashMap4.put("8020", j.b(25));
        hashMap4.put("8100", j.a(6));
        hashMap4.put("8101", j.a(10));
        hashMap4.put("8102", j.a(2));
        hashMap4.put("8110", j.b(70));
        hashMap4.put("8200", j.b(70));
    }

    public static String a(String str) {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() < 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        j jVar = (j) f12338a.get(str.substring(0, 2));
        if (jVar != null) {
            boolean z5 = jVar.f12336a;
            int i3 = jVar.f12337b;
            return z5 ? c(2, i3, str) : b(2, i3, str);
        }
        if (str.length() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring = str.substring(0, 3);
        j jVar2 = (j) f12339b.get(substring);
        if (jVar2 != null) {
            boolean z6 = jVar2.f12336a;
            int i10 = jVar2.f12337b;
            return z6 ? c(3, i10, str) : b(3, i10, str);
        }
        if (str.length() < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        j jVar3 = (j) f12340c.get(substring);
        if (jVar3 != null) {
            boolean z8 = jVar3.f12336a;
            int i11 = jVar3.f12337b;
            return z8 ? c(4, i11, str) : b(4, i11, str);
        }
        j jVar4 = (j) f12341d.get(str.substring(0, 4));
        if (jVar4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z10 = jVar4.f12336a;
        int i12 = jVar4.f12337b;
        return z10 ? c(4, i12, str) : b(4, i12, str);
    }

    public static String b(int i3, int i10, String str) {
        if (str.length() < i3) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring = str.substring(0, i3);
        int i11 = i10 + i3;
        if (str.length() < i11) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring2 = str.substring(i3, i11);
        String str2 = "(" + substring + ')' + substring2;
        String a3 = a(str.substring(i11));
        return a3 == null ? str2 : android.support.v4.media.session.e.l(str2, a3);
    }

    public static String c(int i3, int i10, String str) {
        String substring = str.substring(0, i3);
        int min = Math.min(str.length(), i10 + i3);
        String substring2 = str.substring(i3, min);
        String str2 = "(" + substring + ')' + substring2;
        String a3 = a(str.substring(min));
        return a3 == null ? str2 : android.support.v4.media.session.e.l(str2, a3);
    }
}
