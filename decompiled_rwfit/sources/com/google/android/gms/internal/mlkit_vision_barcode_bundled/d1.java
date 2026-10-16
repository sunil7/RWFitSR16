package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.open.log.TraceLevel;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class d1 implements m1 {

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f9761l = new int[0];

    /* renamed from: m, reason: collision with root package name */
    public static final Unsafe f9762m = x1.h();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f9763a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f9764b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9765c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9766d;
    public final a1 e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f9767f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f9768g;

    /* renamed from: h, reason: collision with root package name */
    public final int f9769h;

    /* renamed from: i, reason: collision with root package name */
    public final int f9770i;

    /* renamed from: j, reason: collision with root package name */
    public final g0 f9771j;

    /* renamed from: k, reason: collision with root package name */
    public final g0 f9772k;

    public d1(int[] iArr, Object[] objArr, int i3, int i10, a1 a1Var, int[] iArr2, int i11, int i12, g0 g0Var, g0 g0Var2) {
        this.f9763a = iArr;
        this.f9764b = objArr;
        this.f9765c = i3;
        this.f9766d = i10;
        boolean z5 = false;
        if (g0Var2 != null && (a1Var instanceof i0)) {
            z5 = true;
        }
        this.f9767f = z5;
        this.f9768g = iArr2;
        this.f9769h = i11;
        this.f9770i = i12;
        this.f9771j = g0Var;
        this.f9772k = g0Var2;
        this.e = a1Var;
    }

    public static long A(long j4, Object obj) {
        return ((Long) x1.g(j4, obj)).longValue();
    }

    public static Field F(String str, Class cls) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder v6 = com.google.android.gms.internal.mlkit_vision_barcode.l0.v("Field ", str, " for ", name, " not found. Known fields are ");
            v6.append(arrays);
            throw new RuntimeException(v6.toString());
        }
    }

    public static boolean r(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof l0) {
            return ((l0) obj).k();
        }
        return true;
    }

    public static s1 u(Object obj) {
        l0 l0Var = (l0) obj;
        s1 s1Var = l0Var.zzc;
        if (s1Var != s1.f9829f) {
            return s1Var;
        }
        s1 b3 = s1.b();
        l0Var.zzc = b3;
        return b3;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0277  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.mlkit_vision_barcode_bundled.d1 v(com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1 r34, com.google.android.gms.internal.mlkit_vision_barcode_bundled.g0 r35, com.google.android.gms.internal.mlkit_vision_barcode_bundled.g0 r36) {
        /*
            Method dump skipped, instructions count: 1048
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.d1.v(com.google.android.gms.internal.mlkit_vision_barcode_bundled.i1, com.google.android.gms.internal.mlkit_vision_barcode_bundled.g0, com.google.android.gms.internal.mlkit_vision_barcode_bundled.g0):com.google.android.gms.internal.mlkit_vision_barcode_bundled.d1");
    }

    public static int w(long j4, Object obj) {
        return ((Integer) x1.g(j4, obj)).intValue();
    }

    public static int y(int i3) {
        return (i3 >>> 20) & 255;
    }

    public final o0 B(int i3) {
        int i10 = i3 / 3;
        return (o0) this.f9764b[i10 + i10 + 1];
    }

    public final m1 C(int i3) {
        int i10 = i3 / 3;
        int i11 = i10 + i10;
        Object[] objArr = this.f9764b;
        m1 m1Var = (m1) objArr[i11];
        if (m1Var != null) {
            return m1Var;
        }
        m1 a3 = g1.f9786c.a((Class) objArr[i11 + 1]);
        objArr[i11] = a3;
        return a3;
    }

    public final Object D(int i3, Object obj) {
        m1 C = C(i3);
        int z5 = z(i3) & 1048575;
        if (!p(i3, obj)) {
            return C.e();
        }
        Object object = f9762m.getObject(obj, z5);
        if (r(object)) {
            return object;
        }
        Object e = C.e();
        if (object != null) {
            C.c(e, object);
        }
        return e;
    }

    public final Object E(int i3, int i10, Object obj) {
        m1 C = C(i10);
        if (!s(i3, i10, obj)) {
            return C.e();
        }
        Object object = f9762m.getObject(obj, z(i10) & 1048575);
        if (r(object)) {
            return object;
        }
        Object e = C.e();
        if (object != null) {
            C.c(e, object);
        }
        return e;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final void a(Object obj) {
        if (!r(obj)) {
            return;
        }
        if (obj instanceof l0) {
            l0 l0Var = (l0) obj;
            l0Var.i();
            l0Var.zza = 0;
            l0Var.g();
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.f9763a;
            if (i3 >= iArr.length) {
                this.f9771j.getClass();
                s1 s1Var = ((l0) obj).zzc;
                if (s1Var.e) {
                    s1Var.e = false;
                }
                if (this.f9767f) {
                    this.f9772k.getClass();
                    ((i0) obj).zzb.d();
                    return;
                }
                return;
            }
            int z5 = z(i3);
            int i10 = 1048575 & z5;
            int y4 = y(z5);
            long j4 = i10;
            if (y4 != 9) {
                if (y4 != 60 && y4 != 68) {
                    switch (y4) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                        case Const.ANDROID_VERSION_28 /* 28 */:
                        case Const.ANDROID_VERSION_29 /* 29 */:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case WXMediaMessage.IMediaObject.TYPE_VIDEO_FILE /* 38 */:
                        case WXMediaMessage.IMediaObject.TYPE_GAME_VIDEO_FILE /* 39 */:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case WXMediaMessage.IMediaObject.TYPE_BUSINESS_CARD /* 45 */:
                        case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /* 46 */:
                        case 47:
                        case TraceLevel.ABOVE_WARN /* 48 */:
                        case 49:
                            q qVar = (q) ((r0) x1.g(j4, obj));
                            if (!qVar.f9816a) {
                                break;
                            } else {
                                qVar.f9816a = false;
                                break;
                            }
                        case SpatialRelationUtil.MIN_OFFSET_DEGREE /* 50 */:
                            Unsafe unsafe = f9762m;
                            Object object = unsafe.getObject(obj, j4);
                            if (object == null) {
                                break;
                            } else {
                                ((zzfg) object).zzc();
                                unsafe.putObject(obj, j4, object);
                                break;
                            }
                    }
                } else if (s(iArr[i3], i3, obj)) {
                    C(i3).a(f9762m.getObject(obj, j4));
                }
                i3 += 3;
            }
            if (p(i3, obj)) {
                C(i3).a(f9762m.getObject(obj, j4));
            }
            i3 += 3;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final void b(Object obj, byte[] bArr, int i3, int i10, s sVar) {
        t(obj, bArr, i3, i10, 0, sVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final void c(Object obj, Object obj2) {
        Object obj3;
        if (!r(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
        obj2.getClass();
        int i3 = 0;
        while (true) {
            int[] iArr = this.f9763a;
            if (i3 >= iArr.length) {
                Object obj4 = obj;
                n1.q(obj4, obj2);
                if (this.f9767f) {
                    n1.p(obj4, obj2);
                    return;
                }
                return;
            }
            int z5 = z(i3);
            int i10 = z5 & 1048575;
            int y4 = y(z5);
            int i11 = iArr[i3];
            long j4 = i10;
            switch (y4) {
                case 0:
                    if (p(i3, obj2)) {
                        w1 w1Var = x1.f9843c;
                        obj3 = obj;
                        w1Var.e(obj3, j4, w1Var.a(j4, obj2));
                        l(i3, obj3);
                        break;
                    }
                    obj3 = obj;
                    break;
                case 1:
                    if (p(i3, obj2)) {
                        w1 w1Var2 = x1.f9843c;
                        w1Var2.f(obj, j4, w1Var2.b(j4, obj2));
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 2:
                    if (p(i3, obj2)) {
                        x1.j(obj, j4, x1.e(j4, obj2));
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 3:
                    if (p(i3, obj2)) {
                        x1.j(obj, j4, x1.e(j4, obj2));
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 4:
                    if (p(i3, obj2)) {
                        x1.i(x1.d(j4, obj2), obj, j4);
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 5:
                    if (p(i3, obj2)) {
                        x1.j(obj, j4, x1.e(j4, obj2));
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 6:
                    if (p(i3, obj2)) {
                        x1.i(x1.d(j4, obj2), obj, j4);
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 7:
                    if (p(i3, obj2)) {
                        w1 w1Var3 = x1.f9843c;
                        w1Var3.c(obj, j4, w1Var3.g(j4, obj2));
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 8:
                    if (p(i3, obj2)) {
                        x1.k(obj, j4, x1.g(j4, obj2));
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 9:
                    j(i3, obj, obj2);
                    obj3 = obj;
                    break;
                case 10:
                    if (p(i3, obj2)) {
                        x1.k(obj, j4, x1.g(j4, obj2));
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 11:
                    if (p(i3, obj2)) {
                        x1.i(x1.d(j4, obj2), obj, j4);
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 12:
                    if (p(i3, obj2)) {
                        x1.i(x1.d(j4, obj2), obj, j4);
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 13:
                    if (p(i3, obj2)) {
                        x1.i(x1.d(j4, obj2), obj, j4);
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 14:
                    if (p(i3, obj2)) {
                        x1.j(obj, j4, x1.e(j4, obj2));
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 15:
                    if (p(i3, obj2)) {
                        x1.i(x1.d(j4, obj2), obj, j4);
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 16:
                    if (p(i3, obj2)) {
                        x1.j(obj, j4, x1.e(j4, obj2));
                        l(i3, obj);
                    }
                    obj3 = obj;
                    break;
                case 17:
                    j(i3, obj, obj2);
                    obj3 = obj;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                case Const.ANDROID_VERSION_28 /* 28 */:
                case Const.ANDROID_VERSION_29 /* 29 */:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case WXMediaMessage.IMediaObject.TYPE_VIDEO_FILE /* 38 */:
                case WXMediaMessage.IMediaObject.TYPE_GAME_VIDEO_FILE /* 39 */:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case WXMediaMessage.IMediaObject.TYPE_BUSINESS_CARD /* 45 */:
                case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /* 46 */:
                case 47:
                case TraceLevel.ABOVE_WARN /* 48 */:
                case 49:
                    r0 r0Var = (r0) x1.g(j4, obj);
                    r0 r0Var2 = (r0) x1.g(j4, obj2);
                    int size = r0Var.size();
                    int size2 = r0Var2.size();
                    if (size > 0 && size2 > 0) {
                        if (!((q) r0Var).f9816a) {
                            r0Var = r0Var.b(size2 + size);
                        }
                        r0Var.addAll(r0Var2);
                    }
                    if (size > 0) {
                        r0Var2 = r0Var;
                    }
                    x1.k(obj, j4, r0Var2);
                    obj3 = obj;
                    break;
                case SpatialRelationUtil.MIN_OFFSET_DEGREE /* 50 */:
                    g0 g0Var = n1.f9806a;
                    zzfg zzfgVar = (zzfg) x1.g(j4, obj);
                    zzfg zzfgVar2 = (zzfg) x1.g(j4, obj2);
                    if (!zzfgVar2.isEmpty()) {
                        if (!zzfgVar.zze()) {
                            zzfgVar = zzfgVar.zzb();
                        }
                        zzfgVar.zzd(zzfgVar2);
                    }
                    x1.k(obj, j4, zzfgVar);
                    obj3 = obj;
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (s(i11, i3, obj2)) {
                        x1.k(obj, j4, x1.g(j4, obj2));
                        x1.i(i11, obj, iArr[i3 + 2] & 1048575);
                    }
                    obj3 = obj;
                    break;
                case 60:
                    k(i3, obj, obj2);
                    obj3 = obj;
                    break;
                case 61:
                case 62:
                case TraceLevel.ALL /* 63 */:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (s(i11, i3, obj2)) {
                        x1.k(obj, j4, x1.g(j4, obj2));
                        x1.i(i11, obj, iArr[i3 + 2] & 1048575);
                    }
                    obj3 = obj;
                    break;
                case 68:
                    k(i3, obj, obj2);
                    obj3 = obj;
                    break;
                default:
                    obj3 = obj;
                    break;
            }
            i3 += 3;
            obj = obj3;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final int d(l0 l0Var) {
        int i3;
        int a3;
        int b3;
        int i10;
        int b10;
        int h4;
        int a10;
        int size;
        int n4;
        int a11;
        int a12;
        int a13;
        int i11;
        int a14;
        int b11;
        d1 d1Var = this;
        l0 l0Var2 = l0Var;
        Unsafe unsafe = f9762m;
        int i12 = 1048575;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            int[] iArr = d1Var.f9763a;
            if (i14 < iArr.length) {
                int z5 = d1Var.z(i14);
                int y4 = y(z5);
                int i17 = iArr[i14];
                int i18 = iArr[i14 + 2];
                int i19 = i18 & i12;
                if (y4 <= 17) {
                    if (i19 != i13) {
                        i15 = i19 == i12 ? 0 : unsafe.getInt(l0Var2, i19);
                        i13 = i19;
                    }
                    i3 = 1 << (i18 >>> 20);
                } else {
                    i3 = 0;
                }
                int i20 = z5 & i12;
                if (y4 >= zzdy.zzJ.zza()) {
                    zzdy.zzW.zza();
                }
                long j4 = i20;
                switch (y4) {
                    case 0:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 8, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 1:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 4, i16);
                        }
                        d1Var = this;
                        l0Var2 = l0Var;
                        i14 += 3;
                        i12 = 1048575;
                    case 2:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            long j10 = unsafe.getLong(l0Var2, j4);
                            a3 = z.a(i17 << 3);
                            b3 = z.b(j10);
                            i16 += b3 + a3;
                        }
                        d1Var = this;
                        i14 += 3;
                        i12 = 1048575;
                    case 3:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            long j11 = unsafe.getLong(l0Var2, j4);
                            a3 = z.a(i17 << 3);
                            b3 = z.b(j11);
                            i16 += b3 + a3;
                        }
                        d1Var = this;
                        i14 += 3;
                        i12 = 1048575;
                    case 4:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            long j12 = unsafe.getInt(l0Var2, j4);
                            a3 = z.a(i17 << 3);
                            b3 = z.b(j12);
                            i16 += b3 + a3;
                        }
                        d1Var = this;
                        i14 += 3;
                        i12 = 1048575;
                    case 5:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 8, i16);
                        }
                        d1Var = this;
                        l0Var2 = l0Var;
                        i14 += 3;
                        i12 = 1048575;
                    case 6:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 4, i16);
                        }
                        d1Var = this;
                        l0Var2 = l0Var;
                        i14 += 3;
                        i12 = 1048575;
                    case 7:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 1, i16);
                        }
                        d1Var = this;
                        l0Var2 = l0Var;
                        i14 += 3;
                        i12 = 1048575;
                    case 8:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            int i21 = i17 << 3;
                            Object object = unsafe.getObject(l0Var2, j4);
                            if (object instanceof zzdf) {
                                int a15 = z.a(i21);
                                int zzd = ((zzdf) object).zzd();
                                i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(zzd, zzd, a15, i16);
                            } else {
                                a3 = z.a(i21);
                                b3 = z.r((String) object);
                                i16 += b3 + a3;
                            }
                        }
                        d1Var = this;
                        i14 += 3;
                        i12 = 1048575;
                    case 9:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            Object object2 = unsafe.getObject(l0Var2, j4);
                            m1 C = d1Var.C(i14);
                            g0 g0Var = n1.f9806a;
                            int a16 = z.a(i17 << 3);
                            int b12 = ((p) ((a1) object2)).b(C);
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(b12, b12, a16, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 10:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            zzdf zzdfVar = (zzdf) unsafe.getObject(l0Var2, j4);
                            int a17 = z.a(i17 << 3);
                            int zzd2 = zzdfVar.zzd();
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(zzd2, zzd2, a17, i16);
                        }
                        d1Var = this;
                        i14 += 3;
                        i12 = 1048575;
                    case 11:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(unsafe.getInt(l0Var2, j4), z.a(i17 << 3), i16);
                        }
                        d1Var = this;
                        i14 += 3;
                        i12 = 1048575;
                    case 12:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            long j13 = unsafe.getInt(l0Var2, j4);
                            a3 = z.a(i17 << 3);
                            b3 = z.b(j13);
                            i16 += b3 + a3;
                        }
                        d1Var = this;
                        i14 += 3;
                        i12 = 1048575;
                    case 13:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 4, i16);
                        }
                        d1Var = this;
                        l0Var2 = l0Var;
                        i14 += 3;
                        i12 = 1048575;
                    case 14:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 8, i16);
                        }
                        d1Var = this;
                        l0Var2 = l0Var;
                        i14 += 3;
                        i12 = 1048575;
                    case 15:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            int i22 = unsafe.getInt(l0Var2, j4);
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b((i22 >> 31) ^ (i22 + i22), z.a(i17 << 3), i16);
                        }
                        d1Var = this;
                        i14 += 3;
                        i12 = 1048575;
                    case 16:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            long j14 = unsafe.getLong(l0Var2, j4);
                            a3 = z.a(i17 << 3);
                            b3 = z.b((j14 >> 63) ^ (j14 + j14));
                            i16 += b3 + a3;
                        }
                        d1Var = this;
                        i14 += 3;
                        i12 = 1048575;
                    case 17:
                        if (d1Var.q(l0Var2, i14, i13, i15, i3)) {
                            a1 a1Var = (a1) unsafe.getObject(l0Var2, j4);
                            m1 C2 = d1Var.C(i14);
                            int a18 = z.a(i17 << 3);
                            i10 = a18 + a18;
                            b10 = ((p) a1Var).b(C2);
                            h4 = b10 + i10;
                            i16 += h4;
                            i14 += 3;
                            i12 = 1048575;
                        } else {
                            i14 += 3;
                            i12 = 1048575;
                        }
                    case 18:
                        h4 = n1.h(i17, (List) unsafe.getObject(l0Var2, j4));
                        i16 += h4;
                        i14 += 3;
                        i12 = 1048575;
                    case 19:
                        h4 = n1.g(i17, (List) unsafe.getObject(l0Var2, j4));
                        i16 += h4;
                        i14 += 3;
                        i12 = 1048575;
                    case 20:
                        List list = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var2 = n1.f9806a;
                        if (list.size() != 0) {
                            a10 = (z.a(i17 << 3) * list.size()) + n1.j(list);
                            i16 += a10;
                            i14 += 3;
                            i12 = 1048575;
                        }
                        a10 = 0;
                        i16 += a10;
                        i14 += 3;
                        i12 = 1048575;
                    case 21:
                        List list2 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var3 = n1.f9806a;
                        size = list2.size();
                        if (size != 0) {
                            n4 = n1.n(list2);
                            a11 = z.a(i17 << 3);
                            a12 = (a11 * size) + n4;
                            i16 += a12;
                            i14 += 3;
                            i12 = 1048575;
                        }
                        a12 = 0;
                        i16 += a12;
                        i14 += 3;
                        i12 = 1048575;
                    case 22:
                        List list3 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var4 = n1.f9806a;
                        size = list3.size();
                        if (size != 0) {
                            n4 = n1.i(list3);
                            a11 = z.a(i17 << 3);
                            a12 = (a11 * size) + n4;
                            i16 += a12;
                            i14 += 3;
                            i12 = 1048575;
                        }
                        a12 = 0;
                        i16 += a12;
                        i14 += 3;
                        i12 = 1048575;
                    case 23:
                        h4 = n1.h(i17, (List) unsafe.getObject(l0Var2, j4));
                        i16 += h4;
                        i14 += 3;
                        i12 = 1048575;
                    case 24:
                        h4 = n1.g(i17, (List) unsafe.getObject(l0Var2, j4));
                        i16 += h4;
                        i14 += 3;
                        i12 = 1048575;
                    case 25:
                        List list4 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var5 = n1.f9806a;
                        int size2 = list4.size();
                        if (size2 != 0) {
                            a10 = (z.a(i17 << 3) + 1) * size2;
                            i16 += a10;
                            i14 += 3;
                            i12 = 1048575;
                        }
                        a10 = 0;
                        i16 += a10;
                        i14 += 3;
                        i12 = 1048575;
                    case 26:
                        List list5 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var6 = n1.f9806a;
                        int size3 = list5.size();
                        if (size3 != 0) {
                            a12 = z.a(i17 << 3) * size3;
                            if (list5 instanceof t0) {
                                t0 t0Var = (t0) list5;
                                for (int i23 = 0; i23 < size3; i23++) {
                                    Object zza = t0Var.zza();
                                    if (zza instanceof zzdf) {
                                        int zzd3 = ((zzdf) zza).zzd();
                                        a12 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(zzd3, zzd3, a12);
                                    } else {
                                        a12 = z.r((String) zza) + a12;
                                    }
                                }
                            } else {
                                for (int i24 = 0; i24 < size3; i24++) {
                                    Object obj = list5.get(i24);
                                    if (obj instanceof zzdf) {
                                        int zzd4 = ((zzdf) obj).zzd();
                                        a12 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(zzd4, zzd4, a12);
                                    } else {
                                        a12 = z.r((String) obj) + a12;
                                    }
                                }
                            }
                            i16 += a12;
                            i14 += 3;
                            i12 = 1048575;
                        }
                        a12 = 0;
                        i16 += a12;
                        i14 += 3;
                        i12 = 1048575;
                    case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                        List list6 = (List) unsafe.getObject(l0Var2, j4);
                        m1 C3 = d1Var.C(i14);
                        g0 g0Var7 = n1.f9806a;
                        int size4 = list6.size();
                        if (size4 == 0) {
                            a13 = 0;
                        } else {
                            a13 = z.a(i17 << 3) * size4;
                            for (int i25 = 0; i25 < size4; i25++) {
                                int b13 = ((p) ((a1) list6.get(i25))).b(C3);
                                a13 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(b13, b13, a13);
                            }
                        }
                        i16 += a13;
                        i14 += 3;
                        i12 = 1048575;
                    case Const.ANDROID_VERSION_28 /* 28 */:
                        List list7 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var8 = n1.f9806a;
                        int size5 = list7.size();
                        if (size5 != 0) {
                            a12 = z.a(i17 << 3) * size5;
                            for (int i26 = 0; i26 < list7.size(); i26++) {
                                int zzd5 = ((zzdf) list7.get(i26)).zzd();
                                a12 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(zzd5, zzd5, a12);
                            }
                            i16 += a12;
                            i14 += 3;
                            i12 = 1048575;
                        }
                        a12 = 0;
                        i16 += a12;
                        i14 += 3;
                        i12 = 1048575;
                    case Const.ANDROID_VERSION_29 /* 29 */:
                        List list8 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var9 = n1.f9806a;
                        size = list8.size();
                        if (size != 0) {
                            n4 = n1.m(list8);
                            a11 = z.a(i17 << 3);
                            a12 = (a11 * size) + n4;
                            i16 += a12;
                            i14 += 3;
                            i12 = 1048575;
                        }
                        a12 = 0;
                        i16 += a12;
                        i14 += 3;
                        i12 = 1048575;
                    case 30:
                        List list9 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var10 = n1.f9806a;
                        size = list9.size();
                        if (size != 0) {
                            n4 = n1.f(list9);
                            a11 = z.a(i17 << 3);
                            a12 = (a11 * size) + n4;
                            i16 += a12;
                            i14 += 3;
                            i12 = 1048575;
                        }
                        a12 = 0;
                        i16 += a12;
                        i14 += 3;
                        i12 = 1048575;
                    case 31:
                        h4 = n1.g(i17, (List) unsafe.getObject(l0Var2, j4));
                        i16 += h4;
                        i14 += 3;
                        i12 = 1048575;
                    case 32:
                        h4 = n1.h(i17, (List) unsafe.getObject(l0Var2, j4));
                        i16 += h4;
                        i14 += 3;
                        i12 = 1048575;
                    case 33:
                        List list10 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var11 = n1.f9806a;
                        size = list10.size();
                        if (size != 0) {
                            n4 = n1.k(list10);
                            a11 = z.a(i17 << 3);
                            a12 = (a11 * size) + n4;
                            i16 += a12;
                            i14 += 3;
                            i12 = 1048575;
                        }
                        a12 = 0;
                        i16 += a12;
                        i14 += 3;
                        i12 = 1048575;
                    case 34:
                        List list11 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var12 = n1.f9806a;
                        size = list11.size();
                        if (size != 0) {
                            n4 = n1.l(list11);
                            a11 = z.a(i17 << 3);
                            a12 = (a11 * size) + n4;
                            i16 += a12;
                            i14 += 3;
                            i12 = 1048575;
                        }
                        a12 = 0;
                        i16 += a12;
                        i14 += 3;
                        i12 = 1048575;
                    case 35:
                        List list12 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var13 = n1.f9806a;
                        int size6 = list12.size() * 8;
                        if (size6 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(size6, z.a(i17 << 3), size6, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 36:
                        List list13 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var14 = n1.f9806a;
                        int size7 = list13.size() * 4;
                        if (size7 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(size7, z.a(i17 << 3), size7, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 37:
                        int j15 = n1.j((List) unsafe.getObject(l0Var2, j4));
                        if (j15 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(j15, z.a(i17 << 3), j15, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case WXMediaMessage.IMediaObject.TYPE_VIDEO_FILE /* 38 */:
                        int n8 = n1.n((List) unsafe.getObject(l0Var2, j4));
                        if (n8 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(n8, z.a(i17 << 3), n8, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case WXMediaMessage.IMediaObject.TYPE_GAME_VIDEO_FILE /* 39 */:
                        int i27 = n1.i((List) unsafe.getObject(l0Var2, j4));
                        if (i27 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(i27, z.a(i17 << 3), i27, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 40:
                        List list14 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var15 = n1.f9806a;
                        int size8 = list14.size() * 8;
                        if (size8 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(size8, z.a(i17 << 3), size8, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 41:
                        List list15 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var16 = n1.f9806a;
                        int size9 = list15.size() * 4;
                        if (size9 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(size9, z.a(i17 << 3), size9, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 42:
                        List list16 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var17 = n1.f9806a;
                        int size10 = list16.size();
                        if (size10 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(size10, z.a(i17 << 3), size10, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 43:
                        int m10 = n1.m((List) unsafe.getObject(l0Var2, j4));
                        if (m10 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(m10, z.a(i17 << 3), m10, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 44:
                        int f2 = n1.f((List) unsafe.getObject(l0Var2, j4));
                        if (f2 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(f2, z.a(i17 << 3), f2, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case WXMediaMessage.IMediaObject.TYPE_BUSINESS_CARD /* 45 */:
                        List list17 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var18 = n1.f9806a;
                        int size11 = list17.size() * 4;
                        if (size11 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(size11, z.a(i17 << 3), size11, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /* 46 */:
                        List list18 = (List) unsafe.getObject(l0Var2, j4);
                        g0 g0Var19 = n1.f9806a;
                        int size12 = list18.size() * 8;
                        if (size12 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(size12, z.a(i17 << 3), size12, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 47:
                        int k10 = n1.k((List) unsafe.getObject(l0Var2, j4));
                        if (k10 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(k10, z.a(i17 << 3), k10, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case TraceLevel.ABOVE_WARN /* 48 */:
                        int l3 = n1.l((List) unsafe.getObject(l0Var2, j4));
                        if (l3 > 0) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(l3, z.a(i17 << 3), l3, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 49:
                        List list19 = (List) unsafe.getObject(l0Var2, j4);
                        m1 C4 = d1Var.C(i14);
                        g0 g0Var20 = n1.f9806a;
                        int size13 = list19.size();
                        if (size13 == 0) {
                            i11 = 0;
                        } else {
                            i11 = 0;
                            for (int i28 = 0; i28 < size13; i28++) {
                                a1 a1Var2 = (a1) list19.get(i28);
                                int a19 = z.a(i17 << 3);
                                i11 += ((p) a1Var2).b(C4) + a19 + a19;
                            }
                        }
                        i16 += i11;
                        i14 += 3;
                        i12 = 1048575;
                    case SpatialRelationUtil.MIN_OFFSET_DEGREE /* 50 */:
                        Object object3 = unsafe.getObject(l0Var2, j4);
                        int i29 = i14 / 3;
                        zzfg zzfgVar = (zzfg) object3;
                        if (d1Var.f9764b[i29 + i29] != null) {
                            throw new ClassCastException();
                        }
                        if (zzfgVar.isEmpty()) {
                            continue;
                        } else {
                            Iterator it = zzfgVar.entrySet().iterator();
                            if (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                entry.getKey();
                                entry.getValue();
                                throw null;
                            }
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 51:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 8, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 52:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 4, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 53:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            long A = A(j4, l0Var2);
                            a14 = z.a(i17 << 3);
                            b11 = z.b(A);
                            i16 += b11 + a14;
                            i14 += 3;
                            i12 = 1048575;
                        } else {
                            i14 += 3;
                            i12 = 1048575;
                        }
                    case 54:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            long A2 = A(j4, l0Var2);
                            a14 = z.a(i17 << 3);
                            b11 = z.b(A2);
                            i16 += b11 + a14;
                            i14 += 3;
                            i12 = 1048575;
                        } else {
                            i14 += 3;
                            i12 = 1048575;
                        }
                    case 55:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            long w8 = w(j4, l0Var2);
                            a14 = z.a(i17 << 3);
                            b11 = z.b(w8);
                            i16 += b11 + a14;
                            i14 += 3;
                            i12 = 1048575;
                        } else {
                            i14 += 3;
                            i12 = 1048575;
                        }
                    case 56:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 8, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 57:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 4, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 58:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 1, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 59:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            int i30 = i17 << 3;
                            Object object4 = unsafe.getObject(l0Var2, j4);
                            if (object4 instanceof zzdf) {
                                int a20 = z.a(i30);
                                int zzd6 = ((zzdf) object4).zzd();
                                i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(zzd6, zzd6, a20, i16);
                            } else {
                                a14 = z.a(i30);
                                b11 = z.r((String) object4);
                                i16 += b11 + a14;
                            }
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 60:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            Object object5 = unsafe.getObject(l0Var2, j4);
                            m1 C5 = d1Var.C(i14);
                            g0 g0Var21 = n1.f9806a;
                            int a21 = z.a(i17 << 3);
                            int b14 = ((p) ((a1) object5)).b(C5);
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(b14, b14, a21, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 61:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            zzdf zzdfVar2 = (zzdf) unsafe.getObject(l0Var2, j4);
                            int a22 = z.a(i17 << 3);
                            int zzd7 = zzdfVar2.zzd();
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.c(zzd7, zzd7, a22, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 62:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(w(j4, l0Var2), z.a(i17 << 3), i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case TraceLevel.ALL /* 63 */:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            long w9 = w(j4, l0Var2);
                            a14 = z.a(i17 << 3);
                            b11 = z.b(w9);
                            i16 += b11 + a14;
                            i14 += 3;
                            i12 = 1048575;
                        } else {
                            i14 += 3;
                            i12 = 1048575;
                        }
                    case 64:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 4, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 65:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b(i17 << 3, 8, i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 66:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            int w10 = w(j4, l0Var2);
                            i16 = com.google.android.gms.internal.mlkit_vision_barcode.l0.b((w10 >> 31) ^ (w10 + w10), z.a(i17 << 3), i16);
                        }
                        i14 += 3;
                        i12 = 1048575;
                    case 67:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            long A3 = A(j4, l0Var2);
                            a14 = z.a(i17 << 3);
                            b11 = z.b((A3 >> 63) ^ (A3 + A3));
                            i16 += b11 + a14;
                            i14 += 3;
                            i12 = 1048575;
                        } else {
                            i14 += 3;
                            i12 = 1048575;
                        }
                    case 68:
                        if (d1Var.s(i17, i14, l0Var2)) {
                            a1 a1Var3 = (a1) unsafe.getObject(l0Var2, j4);
                            m1 C6 = d1Var.C(i14);
                            int a23 = z.a(i17 << 3);
                            i10 = a23 + a23;
                            b10 = ((p) a1Var3).b(C6);
                            h4 = b10 + i10;
                            i16 += h4;
                            i14 += 3;
                            i12 = 1048575;
                        } else {
                            i14 += 3;
                            i12 = 1048575;
                        }
                    default:
                        i14 += 3;
                        i12 = 1048575;
                }
            } else {
                int a24 = l0Var2.zzc.a() + i16;
                if (!d1Var.f9767f) {
                    return a24;
                }
                e0 e0Var = ((i0) l0Var2).zzb;
                int i31 = e0Var.f9774a.f9809b;
                int i32 = 0;
                int i33 = 0;
                while (true) {
                    o1 o1Var = e0Var.f9774a;
                    if (i32 >= i31) {
                        for (Map.Entry entry2 : o1Var.a()) {
                            i33 = e0.a((j0) entry2.getKey(), entry2.getValue()) + i33;
                        }
                        return a24 + i33;
                    }
                    p1 c9 = o1Var.c(i32);
                    i33 = e0.a((j0) c9.f9813a, c9.f9814b) + i33;
                    i32++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final Object e() {
        return (l0) ((l0) this.e).m(4, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final boolean f(l0 l0Var, l0 l0Var2) {
        boolean e;
        int i3 = 0;
        while (true) {
            int[] iArr = this.f9763a;
            if (i3 < iArr.length) {
                int z5 = z(i3);
                long j4 = z5 & 1048575;
                switch (y(z5)) {
                    case 0:
                        if (!o(l0Var, l0Var2, i3)) {
                            break;
                        } else {
                            w1 w1Var = x1.f9843c;
                            if (Double.doubleToLongBits(w1Var.a(j4, l0Var)) != Double.doubleToLongBits(w1Var.a(j4, l0Var2))) {
                                break;
                            } else {
                                continue;
                                i3 += 3;
                            }
                        }
                    case 1:
                        if (!o(l0Var, l0Var2, i3)) {
                            break;
                        } else {
                            w1 w1Var2 = x1.f9843c;
                            if (Float.floatToIntBits(w1Var2.b(j4, l0Var)) != Float.floatToIntBits(w1Var2.b(j4, l0Var2))) {
                                break;
                            } else {
                                continue;
                                i3 += 3;
                            }
                        }
                    case 2:
                        if (o(l0Var, l0Var2, i3) && x1.e(j4, l0Var) == x1.e(j4, l0Var2)) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 3:
                        if (o(l0Var, l0Var2, i3) && x1.e(j4, l0Var) == x1.e(j4, l0Var2)) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 4:
                        if (o(l0Var, l0Var2, i3) && x1.d(j4, l0Var) == x1.d(j4, l0Var2)) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 5:
                        if (o(l0Var, l0Var2, i3) && x1.e(j4, l0Var) == x1.e(j4, l0Var2)) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 6:
                        if (o(l0Var, l0Var2, i3) && x1.d(j4, l0Var) == x1.d(j4, l0Var2)) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 7:
                        if (!o(l0Var, l0Var2, i3)) {
                            break;
                        } else {
                            w1 w1Var3 = x1.f9843c;
                            if (w1Var3.g(j4, l0Var) != w1Var3.g(j4, l0Var2)) {
                                break;
                            } else {
                                continue;
                                i3 += 3;
                            }
                        }
                    case 8:
                        if (o(l0Var, l0Var2, i3) && n1.e(x1.g(j4, l0Var), x1.g(j4, l0Var2))) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 9:
                        if (o(l0Var, l0Var2, i3) && n1.e(x1.g(j4, l0Var), x1.g(j4, l0Var2))) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 10:
                        if (o(l0Var, l0Var2, i3) && n1.e(x1.g(j4, l0Var), x1.g(j4, l0Var2))) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 11:
                        if (o(l0Var, l0Var2, i3) && x1.d(j4, l0Var) == x1.d(j4, l0Var2)) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 12:
                        if (o(l0Var, l0Var2, i3) && x1.d(j4, l0Var) == x1.d(j4, l0Var2)) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 13:
                        if (o(l0Var, l0Var2, i3) && x1.d(j4, l0Var) == x1.d(j4, l0Var2)) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 14:
                        if (o(l0Var, l0Var2, i3) && x1.e(j4, l0Var) == x1.e(j4, l0Var2)) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 15:
                        if (o(l0Var, l0Var2, i3) && x1.d(j4, l0Var) == x1.d(j4, l0Var2)) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 16:
                        if (o(l0Var, l0Var2, i3) && x1.e(j4, l0Var) == x1.e(j4, l0Var2)) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 17:
                        if (o(l0Var, l0Var2, i3) && n1.e(x1.g(j4, l0Var), x1.g(j4, l0Var2))) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                    case Const.ANDROID_VERSION_28 /* 28 */:
                    case Const.ANDROID_VERSION_29 /* 29 */:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case WXMediaMessage.IMediaObject.TYPE_VIDEO_FILE /* 38 */:
                    case WXMediaMessage.IMediaObject.TYPE_GAME_VIDEO_FILE /* 39 */:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case WXMediaMessage.IMediaObject.TYPE_BUSINESS_CARD /* 45 */:
                    case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /* 46 */:
                    case 47:
                    case TraceLevel.ABOVE_WARN /* 48 */:
                    case 49:
                        e = n1.e(x1.g(j4, l0Var), x1.g(j4, l0Var2));
                        break;
                    case SpatialRelationUtil.MIN_OFFSET_DEGREE /* 50 */:
                        e = n1.e(x1.g(j4, l0Var), x1.g(j4, l0Var2));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case TraceLevel.ALL /* 63 */:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long j10 = iArr[i3 + 2] & 1048575;
                        if (x1.d(j10, l0Var) == x1.d(j10, l0Var2) && n1.e(x1.g(j4, l0Var), x1.g(j4, l0Var2))) {
                            continue;
                            i3 += 3;
                        }
                        break;
                    default:
                        i3 += 3;
                }
                if (e) {
                    i3 += 3;
                }
            } else if (l0Var.zzc.equals(l0Var2.zzc)) {
                if (this.f9767f) {
                    return ((i0) l0Var).zzb.equals(((i0) l0Var2).zzb);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x01ea, code lost:
    
        if (r2 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d9, code lost:
    
        if (r2 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00db, code lost:
    
        r6 = 1231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00dc, code lost:
    
        r1 = r6 + r1;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0 r11) {
        /*
            Method dump skipped, instructions count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.d1.g(com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00ee, code lost:
    
        return false;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.d1.h(java.lang.Object):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x05f6  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0622  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0646 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.Object r22, com.google.android.gms.internal.mlkit_vision_barcode_bundled.x0 r23) {
        /*
            Method dump skipped, instructions count: 1784
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.d1.i(java.lang.Object, com.google.android.gms.internal.mlkit_vision_barcode_bundled.x0):void");
    }

    public final void j(int i3, Object obj, Object obj2) {
        if (p(i3, obj2)) {
            int z5 = z(i3) & 1048575;
            Unsafe unsafe = f9762m;
            long j4 = z5;
            Object object = unsafe.getObject(obj2, j4);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f9763a[i3] + " is present but null: " + obj2.toString());
            }
            m1 C = C(i3);
            if (!p(i3, obj)) {
                if (r(object)) {
                    Object e = C.e();
                    C.c(e, object);
                    unsafe.putObject(obj, j4, e);
                } else {
                    unsafe.putObject(obj, j4, object);
                }
                l(i3, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j4);
            if (!r(object2)) {
                Object e10 = C.e();
                C.c(e10, object2);
                unsafe.putObject(obj, j4, e10);
                object2 = e10;
            }
            C.c(object2, object);
        }
    }

    public final void k(int i3, Object obj, Object obj2) {
        int[] iArr = this.f9763a;
        int i10 = iArr[i3];
        if (s(i10, i3, obj2)) {
            int z5 = z(i3) & 1048575;
            Unsafe unsafe = f9762m;
            long j4 = z5;
            Object object = unsafe.getObject(obj2, j4);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i3] + " is present but null: " + obj2.toString());
            }
            m1 C = C(i3);
            if (!s(i10, i3, obj)) {
                if (r(object)) {
                    Object e = C.e();
                    C.c(e, object);
                    unsafe.putObject(obj, j4, e);
                } else {
                    unsafe.putObject(obj, j4, object);
                }
                x1.i(i10, obj, iArr[i3 + 2] & 1048575);
                return;
            }
            Object object2 = unsafe.getObject(obj, j4);
            if (!r(object2)) {
                Object e10 = C.e();
                C.c(e10, object2);
                unsafe.putObject(obj, j4, e10);
                object2 = e10;
            }
            C.c(object2, object);
        }
    }

    public final void l(int i3, Object obj) {
        int i10 = this.f9763a[i3 + 2];
        long j4 = 1048575 & i10;
        if (j4 == 1048575) {
            return;
        }
        x1.i((1 << (i10 >>> 20)) | x1.d(j4, obj), obj, j4);
    }

    public final void m(int i3, Object obj, Object obj2) {
        f9762m.putObject(obj, z(i3) & 1048575, obj2);
        l(i3, obj);
    }

    public final void n(int i3, Object obj, Object obj2, int i10) {
        f9762m.putObject(obj, z(i10) & 1048575, obj2);
        x1.i(i3, obj, this.f9763a[i10 + 2] & 1048575);
    }

    public final boolean o(l0 l0Var, l0 l0Var2, int i3) {
        return p(i3, l0Var) == p(i3, l0Var2);
    }

    public final boolean p(int i3, Object obj) {
        int i10 = this.f9763a[i3 + 2];
        long j4 = i10 & 1048575;
        if (j4 == 1048575) {
            int z5 = z(i3);
            long j10 = z5 & 1048575;
            switch (y(z5)) {
                case 0:
                    if (Double.doubleToRawLongBits(x1.f9843c.a(j10, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(x1.f9843c.b(j10, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (x1.e(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (x1.e(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (x1.d(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (x1.e(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (x1.d(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return x1.f9843c.g(j10, obj);
                case 8:
                    Object g10 = x1.g(j10, obj);
                    if (g10 instanceof String) {
                        if (((String) g10).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(g10 instanceof zzdf)) {
                            throw new IllegalArgumentException();
                        }
                        if (zzdf.zzb.equals(g10)) {
                            return false;
                        }
                    }
                    break;
                case 9:
                    if (x1.g(j10, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (zzdf.zzb.equals(x1.g(j10, obj))) {
                        return false;
                    }
                    break;
                case 11:
                    if (x1.d(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (x1.d(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (x1.d(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (x1.e(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (x1.d(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (x1.e(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (x1.g(j10, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i10 >>> 20)) & x1.d(j4, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean q(Object obj, int i3, int i10, int i11, int i12) {
        return i10 == 1048575 ? p(i3, obj) : (i11 & i12) != 0;
    }

    public final boolean s(int i3, int i10, Object obj) {
        return x1.d((long) (this.f9763a[i10 + 2] & 1048575), obj) == i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x0d77, code lost:
    
        r36 = r10;
        r17 = r12;
        r3 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x06cc, code lost:
    
        r10 = r44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x10ac, code lost:
    
        if (r2 == 1048575) goto L628;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x10ae, code lost:
    
        r34.putInt(r14, r2, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x10b4, code lost:
    
        r1 = r0.f9769h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x10b8, code lost:
    
        if (r1 >= r0.f9770i) goto L766;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x10ba, code lost:
    
        r2 = r0.f9768g[r1];
        r3 = r21[r2];
        r3 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.x1.g(r0.z(r2) & 1048575, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x10ce, code lost:
    
        if (r3 != null) goto L634;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x10da, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x10d7, code lost:
    
        if (r0.B(r2) != null) goto L765;
     */
    /* JADX WARN: Code restructure failed: missing block: B:576:0x05e7, code lost:
    
        r19 = r15;
        r22 = r31;
        r7 = r32;
        r21 = r35;
        r17 = 2;
        r18 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:579:0x05b4, code lost:
    
        r10 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x10dd, code lost:
    
        r3 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfg) r3;
        r2 = r2 / 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x012a, code lost:
    
        r14 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x06bb, code lost:
    
        r3 = r4;
        r11 = r9;
        r34 = r10;
        r17 = r12;
        r36 = r13;
        r33 = r22;
        r8 = r31;
        r13 = r32;
        r31 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x10ea, code lost:
    
        throw com.google.android.gms.internal.mlkit_vision_barcode.l0.f(r19[r2 + r2]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:601:0x04ca, code lost:
    
        r5 = r3;
        r3 = r1;
        r1 = r5;
        r14 = r42;
        r5 = r43;
        r6 = r2;
        r2 = r8;
        r8 = r9;
        r19 = r15;
        r22 = r31;
        r7 = r32;
        r21 = r35;
        r17 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x10ed, code lost:
    
        if (r10 != 0) goto L646;
     */
    /* JADX WARN: Code restructure failed: missing block: B:632:0x03ed, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer(r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x10ef, code lost:
    
        if (r4 != r5) goto L644;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x10f7, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:664:0x0465, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer(r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x10fc, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x10f8, code lost:
    
        if (r4 > r5) goto L649;
     */
    /* JADX WARN: Code restructure failed: missing block: B:680:0x0385, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer(r34);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x10fa, code lost:
    
        if (r8 != r10) goto L649;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x1102, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:715:0x04ec, code lost:
    
        r14 = r8;
        r10 = r9;
        r8 = r1;
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:755:0x0234, code lost:
    
        r10 = r5;
        r31 = r6;
        r32 = r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0cf1  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0d0f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x1001  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x1022 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int t(java.lang.Object r40, byte[] r41, int r42, int r43, int r44, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s r45) {
        /*
            Method dump skipped, instructions count: 4516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.d1.t(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s):int");
    }

    public final int x(int i3, int i10) {
        int[] iArr = this.f9763a;
        int length = (iArr.length / 3) - 1;
        while (i10 <= length) {
            int i11 = (length + i10) >>> 1;
            int i12 = i11 * 3;
            int i13 = iArr[i12];
            if (i3 == i13) {
                return i12;
            }
            if (i3 < i13) {
                length = i11 - 1;
            } else {
                i10 = i11 + 1;
            }
        }
        return -1;
    }

    public final int z(int i3) {
        return this.f9763a[i3 + 1];
    }
}
