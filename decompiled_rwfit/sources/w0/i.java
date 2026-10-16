package w0;

import android.util.Log;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.open.log.TraceLevel;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public int[] f19349a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f19350b;

    /* renamed from: c, reason: collision with root package name */
    public int f19351c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f19352d;
    public float[] e;

    /* renamed from: f, reason: collision with root package name */
    public int f19353f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f19354g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f19355h;

    /* renamed from: i, reason: collision with root package name */
    public int f19356i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f19357j;

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f19358k;

    /* renamed from: l, reason: collision with root package name */
    public int f19359l;

    public final void a(float f2, int i3) {
        int i10 = this.f19353f;
        int[] iArr = this.f19352d;
        if (i10 >= iArr.length) {
            this.f19352d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.e;
            this.e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f19352d;
        int i11 = this.f19353f;
        iArr2[i11] = i3;
        float[] fArr2 = this.e;
        this.f19353f = i11 + 1;
        fArr2[i11] = f2;
    }

    public final void b(int i3, int i10) {
        int i11 = this.f19351c;
        int[] iArr = this.f19349a;
        if (i11 >= iArr.length) {
            this.f19349a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f19350b;
            this.f19350b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f19349a;
        int i12 = this.f19351c;
        iArr3[i12] = i3;
        int[] iArr4 = this.f19350b;
        this.f19351c = i12 + 1;
        iArr4[i12] = i10;
    }

    public final void c(int i3, String str) {
        int i10 = this.f19356i;
        int[] iArr = this.f19354g;
        if (i10 >= iArr.length) {
            this.f19354g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f19355h;
            this.f19355h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f19354g;
        int i11 = this.f19356i;
        iArr2[i11] = i3;
        String[] strArr2 = this.f19355h;
        this.f19356i = i11 + 1;
        strArr2[i11] = str;
    }

    public final void d(int i3, boolean z5) {
        int i10 = this.f19359l;
        int[] iArr = this.f19357j;
        if (i10 >= iArr.length) {
            this.f19357j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f19358k;
            this.f19358k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f19357j;
        int i11 = this.f19359l;
        iArr2[i11] = i3;
        boolean[] zArr2 = this.f19358k;
        this.f19359l = i11 + 1;
        zArr2[i11] = z5;
    }

    public final void e(j jVar) {
        for (int i3 = 0; i3 < this.f19351c; i3++) {
            int i10 = this.f19349a[i3];
            int i11 = this.f19350b[i3];
            if (i10 == 6) {
                jVar.e.C = i11;
            } else if (i10 == 7) {
                jVar.e.D = i11;
            } else if (i10 == 8) {
                jVar.e.J = i11;
            } else if (i10 == 27) {
                jVar.e.E = i11;
            } else if (i10 == 28) {
                jVar.e.G = i11;
            } else if (i10 == 41) {
                jVar.e.V = i11;
            } else if (i10 == 42) {
                jVar.e.W = i11;
            } else if (i10 == 61) {
                jVar.e.f19405z = i11;
            } else if (i10 == 62) {
                jVar.e.A = i11;
            } else if (i10 == 72) {
                jVar.e.f19378f0 = i11;
            } else if (i10 == 73) {
                jVar.e.f19380g0 = i11;
            } else if (i10 == 2) {
                jVar.e.I = i11;
            } else if (i10 == 31) {
                jVar.e.K = i11;
            } else if (i10 == 34) {
                jVar.e.H = i11;
            } else if (i10 == 38) {
                jVar.f19360a = i11;
            } else if (i10 == 64) {
                jVar.f19363d.f19408b = i11;
            } else if (i10 == 66) {
                jVar.f19363d.f19411f = i11;
            } else if (i10 == 76) {
                jVar.f19363d.e = i11;
            } else if (i10 == 78) {
                jVar.f19362c.f19421c = i11;
            } else if (i10 == 97) {
                jVar.e.f19395o0 = i11;
            } else if (i10 == 93) {
                jVar.e.L = i11;
            } else if (i10 != 94) {
                switch (i10) {
                    case 11:
                        jVar.e.P = i11;
                        break;
                    case 12:
                        jVar.e.Q = i11;
                        break;
                    case 13:
                        jVar.e.M = i11;
                        break;
                    case 14:
                        jVar.e.O = i11;
                        break;
                    case 15:
                        jVar.e.R = i11;
                        break;
                    case 16:
                        jVar.e.N = i11;
                        break;
                    case 17:
                        jVar.e.e = i11;
                        break;
                    case 18:
                        jVar.e.f19377f = i11;
                        break;
                    default:
                        switch (i10) {
                            case 21:
                                jVar.e.f19374d = i11;
                                break;
                            case 22:
                                jVar.f19362c.f19420b = i11;
                                break;
                            case 23:
                                jVar.e.f19372c = i11;
                                break;
                            case 24:
                                jVar.e.F = i11;
                                break;
                            default:
                                switch (i10) {
                                    case 54:
                                        jVar.e.X = i11;
                                        break;
                                    case 55:
                                        jVar.e.Y = i11;
                                        break;
                                    case 56:
                                        jVar.e.Z = i11;
                                        break;
                                    case 57:
                                        jVar.e.f19369a0 = i11;
                                        break;
                                    case 58:
                                        jVar.e.f19371b0 = i11;
                                        break;
                                    case 59:
                                        jVar.e.f19373c0 = i11;
                                        break;
                                    default:
                                        switch (i10) {
                                            case 82:
                                                jVar.f19363d.f19409c = i11;
                                                break;
                                            case 83:
                                                jVar.f19364f.f19431i = i11;
                                                break;
                                            case 84:
                                                jVar.f19363d.f19415j = i11;
                                                break;
                                            default:
                                                switch (i10) {
                                                    case 87:
                                                        break;
                                                    case 88:
                                                        jVar.f19363d.f19417l = i11;
                                                        break;
                                                    case 89:
                                                        jVar.f19363d.f19418m = i11;
                                                        break;
                                                    default:
                                                        Log.w("ConstraintSet", "Unknown attribute 0x");
                                                        break;
                                                }
                                        }
                                }
                        }
                }
            } else {
                jVar.e.S = i11;
            }
        }
        for (int i12 = 0; i12 < this.f19353f; i12++) {
            int i13 = this.f19352d[i12];
            float f2 = this.e[i12];
            if (i13 == 19) {
                jVar.e.f19379g = f2;
            } else if (i13 == 20) {
                jVar.e.f19402w = f2;
            } else if (i13 == 37) {
                jVar.e.f19403x = f2;
            } else if (i13 == 60) {
                jVar.f19364f.f19425b = f2;
            } else if (i13 == 63) {
                jVar.e.B = f2;
            } else if (i13 == 79) {
                jVar.f19363d.f19412g = f2;
            } else if (i13 == 85) {
                jVar.f19363d.f19414i = f2;
            } else if (i13 != 87) {
                if (i13 == 39) {
                    jVar.e.U = f2;
                } else if (i13 != 40) {
                    switch (i13) {
                        case 43:
                            jVar.f19362c.f19422d = f2;
                            break;
                        case 44:
                            n nVar = jVar.f19364f;
                            nVar.f19436n = f2;
                            nVar.f19435m = true;
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_BUSINESS_CARD /* 45 */:
                            jVar.f19364f.f19426c = f2;
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /* 46 */:
                            jVar.f19364f.f19427d = f2;
                            break;
                        case 47:
                            jVar.f19364f.e = f2;
                            break;
                        case TraceLevel.ABOVE_WARN /* 48 */:
                            jVar.f19364f.f19428f = f2;
                            break;
                        case 49:
                            jVar.f19364f.f19429g = f2;
                            break;
                        case SpatialRelationUtil.MIN_OFFSET_DEGREE /* 50 */:
                            jVar.f19364f.f19430h = f2;
                            break;
                        case 51:
                            jVar.f19364f.f19432j = f2;
                            break;
                        case 52:
                            jVar.f19364f.f19433k = f2;
                            break;
                        case 53:
                            jVar.f19364f.f19434l = f2;
                            break;
                        default:
                            switch (i13) {
                                case 67:
                                    jVar.f19363d.f19413h = f2;
                                    break;
                                case 68:
                                    jVar.f19362c.e = f2;
                                    break;
                                case 69:
                                    jVar.e.f19375d0 = f2;
                                    break;
                                case 70:
                                    jVar.e.f19376e0 = f2;
                                    break;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x");
                                    break;
                            }
                    }
                } else {
                    jVar.e.T = f2;
                }
            }
        }
        for (int i14 = 0; i14 < this.f19356i; i14++) {
            int i15 = this.f19354g[i14];
            String str = this.f19355h[i14];
            if (i15 == 5) {
                jVar.e.f19404y = str;
            } else if (i15 == 65) {
                jVar.f19363d.f19410d = str;
            } else if (i15 == 74) {
                k kVar = jVar.e;
                kVar.f19385j0 = str;
                kVar.i0 = null;
            } else if (i15 == 77) {
                jVar.e.f19387k0 = str;
            } else if (i15 != 87) {
                if (i15 != 90) {
                    Log.w("ConstraintSet", "Unknown attribute 0x");
                } else {
                    jVar.f19363d.f19416k = str;
                }
            }
        }
        for (int i16 = 0; i16 < this.f19359l; i16++) {
            int i17 = this.f19357j[i16];
            boolean z5 = this.f19358k[i16];
            if (i17 == 44) {
                jVar.f19364f.f19435m = z5;
            } else if (i17 == 75) {
                jVar.e.f19393n0 = z5;
            } else if (i17 != 87) {
                if (i17 == 80) {
                    jVar.e.f19389l0 = z5;
                } else if (i17 != 81) {
                    Log.w("ConstraintSet", "Unknown attribute 0x");
                } else {
                    jVar.e.f19391m0 = z5;
                }
            }
        }
    }
}
