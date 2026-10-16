package h3;

import android.util.Base64;
import c3.b;
import c3.c;
import com.google.android.gms.internal.mlkit_vision_barcode.de;
import com.google.android.gms.internal.mlkit_vision_barcode.mc;
import g3.e;
import g3.f;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Can't wrap try/catch for region: R(22:22|(1:24)(7:126|(3:128|(3:130|(1:(2:140|141))(2:134|135)|136)|144)|145|(1:147)|148|(5:151|(4:153|(1:155)(2:162|(1:164)(1:165))|156|(2:158|(1:160)))|166|101|185)|150)|25|(4:75|(1:77)(1:125)|78|(6:85|(5:87|(1:89)(2:120|(1:122)(1:123))|90|(1:92)(1:119)|(2:(1:95)(10:97|(1:99)(1:117)|100|(1:102)|103|104|(3:106|(2:108|109)(1:111)|110)|112|113|(1:115)(1:116))|96)(1:118))(1:124)|(3:30|(8:32|(2:35|33)|36|37|(1:39)|40|(1:42)|43)|44)(1:74)|(11:50|51|52|(1:72)(1:58)|(1:62)|63|(1:65)|(1:67)|68|69|70)(1:47)|48|49))|27|28|(0)(0)|(0)|50|51|52|(1:54)|72|(2:60|62)|63|(0)|(0)|68|69|70|48|49) */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x00e4, code lost:
    
        if (d3.a.b(((d3.a) r6.f12238d).e, (com.amap.location.support.bean.cell.AmapCell) r6.f12237c) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0311, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02f9 A[Catch: all -> 0x0311, TryCatch #0 {all -> 0x0311, blocks: (B:52:0x02ca, B:54:0x02d1, B:56:0x02d5, B:58:0x02db, B:60:0x02e3, B:62:0x02e9, B:63:0x02ed, B:65:0x02f9, B:67:0x02ff, B:68:0x0304), top: B:51:0x02ca }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02ff A[Catch: all -> 0x0311, TryCatch #0 {all -> 0x0311, blocks: (B:52:0x02ca, B:54:0x02d1, B:56:0x02d5, B:58:0x02db, B:60:0x02e3, B:62:0x02e9, B:63:0x02ed, B:65:0x02f9, B:67:0x02ff, B:68:0x0304), top: B:51:0x02ca }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x028a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static e3.a a(d3.b r20) {
        /*
            Method dump skipped, instructions count: 798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.a.a(d3.b):e3.a");
    }

    public static byte[] b() {
        c cVar = c.f3374c;
        ((b) cVar.f36a).m((ByteBuffer) cVar.f37b);
        try {
            ((b) cVar.f36a).l(f3.a.a((b) cVar.f36a, de.f9264a, ((b) cVar.f36a).i(de.e), ((b) cVar.f36a).i(de.f9265b), (byte) de.f9273k, ((b) cVar.f36a).i(de.f9270h), ((b) cVar.f36a).i(de.f9269g), ((b) cVar.f36a).i(de.f9268f), ((b) cVar.f36a).i(""), k3.a.b(de.f9274l), ((b) cVar.f36a).i(de.f9272j), ((b) cVar.f36a).i(de.f9271i), ((b) cVar.f36a).i(de.f9266c), ((b) cVar.f36a).i(de.f9267d)));
            return ((b) cVar.f36a).p();
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] c(byte[] bArr, byte[] bArr2, List list) {
        int i3;
        c cVar = c.f3374c;
        b bVar = (b) cVar.f36a;
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            ((b) cVar.f36a).m((ByteBuffer) cVar.f37b);
            int i10 = f3.a.f12656n;
            bVar.s(1, bArr.length, 1);
            for (int length = bArr.length - 1; length >= 0; length--) {
                bVar.a(bArr[length]);
            }
            int k10 = bVar.k();
            int[] iArr = new int[size];
            for (int i11 = 0; i11 < size; i11++) {
                e3.a aVar = (e3.a) list.get(i11);
                byte[] bArr3 = aVar.f12446b;
                int i12 = f3.a.f12656n;
                bVar.s(1, bArr3.length, 1);
                for (int length2 = bArr3.length - 1; length2 >= 0; length2--) {
                    bVar.a(bArr3[length2]);
                }
                int k11 = bVar.k();
                byte b3 = (byte) aVar.f12445a;
                bVar.r(2);
                bVar.f(1, k11);
                bVar.b(b3, 0);
                iArr[i11] = bVar.j();
            }
            bVar.s(4, size, 4);
            for (int i13 = size - 1; i13 >= 0; i13--) {
                bVar.e(iArr[i13]);
            }
            int k12 = bVar.k();
            if (bArr2 != null) {
                bVar.s(1, bArr2.length, 1);
                for (int length3 = bArr2.length - 1; length3 >= 0; length3--) {
                    bVar.a(bArr2[length3]);
                }
                i3 = bVar.k();
            } else {
                i3 = 0;
            }
            bVar.r(3);
            bVar.f(2, k12);
            bVar.f(1, i3);
            bVar.f(0, k10);
            bVar.l(bVar.j());
            return bVar.p();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean d(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            m3.a aVar = new m3.a();
            HashMap hashMap = new HashMap();
            aVar.f15942b = hashMap;
            hashMap.put("Content-Type", "application/octet-stream");
            hashMap.put("aps_c_src", Base64.encodeToString(("lc_" + ((int) de.f9264a)).getBytes(), 2));
            hashMap.put("aps_c_key", Base64.encodeToString((de.f9265b + "*" + de.e).getBytes(), 2));
            aVar.f15943c = bArr;
            aVar.f15941a = "https://".concat("cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&");
            m3.b post = mc.f9435a.post(aVar);
            byte[] bArr2 = (post == null || post.f15944a != 200) ? null : post.f15945b;
            if (bArr2 != null) {
                return "true".equals(new String(bArr2, StandardCharsets.UTF_8));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void e(ArrayList arrayList) {
        synchronized (f.class) {
            if (arrayList != null) {
                try {
                    if (!arrayList.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList(arrayList.size());
                        int size = arrayList.size();
                        int i3 = 0;
                        while (i3 < size) {
                            Object obj = arrayList.get(i3);
                            i3++;
                            k3.a aVar = (k3.a) obj;
                            long j4 = aVar.f15455a;
                            int i10 = aVar.f15457c;
                            e eVar = new e();
                            eVar.f13806a = j4;
                            eVar.f13807b = i10;
                            arrayList2.add(eVar);
                        }
                        g3.c.c().e(arrayList2);
                    }
                } finally {
                }
            }
        }
    }
}
