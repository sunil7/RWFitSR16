package w0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R$styleable;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.open.log.TraceLevel;

/* loaded from: classes.dex */
public class e extends ViewGroup.MarginLayoutParams {
    public int A;
    public final int B;
    public final int C;
    public float D;
    public float E;
    public String F;
    public float G;
    public float H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public float R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;
    public String X;
    public int Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public int f19294a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f19295a0;

    /* renamed from: b, reason: collision with root package name */
    public int f19296b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f19297b0;

    /* renamed from: c, reason: collision with root package name */
    public float f19298c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f19299c0;

    /* renamed from: d, reason: collision with root package name */
    public int f19300d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f19301d0;
    public int e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f19302e0;

    /* renamed from: f, reason: collision with root package name */
    public int f19303f;

    /* renamed from: f0, reason: collision with root package name */
    public int f19304f0;

    /* renamed from: g, reason: collision with root package name */
    public int f19305g;

    /* renamed from: g0, reason: collision with root package name */
    public int f19306g0;

    /* renamed from: h, reason: collision with root package name */
    public int f19307h;

    /* renamed from: h0, reason: collision with root package name */
    public int f19308h0;

    /* renamed from: i, reason: collision with root package name */
    public int f19309i;
    public int i0;

    /* renamed from: j, reason: collision with root package name */
    public int f19310j;

    /* renamed from: j0, reason: collision with root package name */
    public int f19311j0;

    /* renamed from: k, reason: collision with root package name */
    public int f19312k;

    /* renamed from: k0, reason: collision with root package name */
    public int f19313k0;

    /* renamed from: l, reason: collision with root package name */
    public int f19314l;

    /* renamed from: l0, reason: collision with root package name */
    public float f19315l0;

    /* renamed from: m, reason: collision with root package name */
    public int f19316m;

    /* renamed from: m0, reason: collision with root package name */
    public int f19317m0;

    /* renamed from: n, reason: collision with root package name */
    public int f19318n;

    /* renamed from: n0, reason: collision with root package name */
    public int f19319n0;

    /* renamed from: o, reason: collision with root package name */
    public int f19320o;

    /* renamed from: o0, reason: collision with root package name */
    public float f19321o0;

    /* renamed from: p, reason: collision with root package name */
    public int f19322p;

    /* renamed from: p0, reason: collision with root package name */
    public q0.f f19323p0;

    /* renamed from: q, reason: collision with root package name */
    public float f19324q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f19325s;

    /* renamed from: t, reason: collision with root package name */
    public int f19326t;

    /* renamed from: u, reason: collision with root package name */
    public int f19327u;

    /* renamed from: v, reason: collision with root package name */
    public final int f19328v;

    /* renamed from: w, reason: collision with root package name */
    public int f19329w;

    /* renamed from: x, reason: collision with root package name */
    public final int f19330x;

    /* renamed from: y, reason: collision with root package name */
    public int f19331y;

    /* renamed from: z, reason: collision with root package name */
    public int f19332z;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19294a = -1;
        this.f19296b = -1;
        this.f19298c = -1.0f;
        this.f19300d = -1;
        this.e = -1;
        this.f19303f = -1;
        this.f19305g = -1;
        this.f19307h = -1;
        this.f19309i = -1;
        this.f19310j = -1;
        this.f19312k = -1;
        this.f19314l = -1;
        this.f19316m = -1;
        this.f19318n = -1;
        this.f19320o = -1;
        this.f19322p = 0;
        this.f19324q = 0.0f;
        this.r = -1;
        this.f19325s = -1;
        this.f19326t = -1;
        this.f19327u = -1;
        this.f19328v = Integer.MIN_VALUE;
        this.f19329w = Integer.MIN_VALUE;
        this.f19330x = Integer.MIN_VALUE;
        this.f19331y = Integer.MIN_VALUE;
        this.f19332z = Integer.MIN_VALUE;
        this.A = Integer.MIN_VALUE;
        this.B = Integer.MIN_VALUE;
        this.C = 0;
        this.D = 0.5f;
        this.E = 0.5f;
        this.F = null;
        this.G = -1.0f;
        this.H = -1.0f;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 1.0f;
        this.R = 1.0f;
        this.S = -1;
        this.T = -1;
        this.U = -1;
        this.V = false;
        this.W = false;
        this.X = null;
        this.Y = 0;
        this.Z = true;
        this.f19295a0 = true;
        this.f19297b0 = false;
        this.f19299c0 = false;
        this.f19301d0 = false;
        this.f19302e0 = false;
        this.f19304f0 = -1;
        this.f19306g0 = -1;
        this.f19308h0 = -1;
        this.i0 = -1;
        this.f19311j0 = Integer.MIN_VALUE;
        this.f19313k0 = Integer.MIN_VALUE;
        this.f19315l0 = 0.5f;
        this.f19323p0 = new q0.f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            int i10 = d.f19293a.get(index);
            switch (i10) {
                case 1:
                    this.U = obtainStyledAttributes.getInt(index, this.U);
                    break;
                case 2:
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f19320o);
                    this.f19320o = resourceId;
                    if (resourceId == -1) {
                        this.f19320o = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    this.f19322p = obtainStyledAttributes.getDimensionPixelSize(index, this.f19322p);
                    break;
                case 4:
                    float f2 = obtainStyledAttributes.getFloat(index, this.f19324q) % 360.0f;
                    this.f19324q = f2;
                    if (f2 < 0.0f) {
                        this.f19324q = (360.0f - f2) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    this.f19294a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f19294a);
                    break;
                case 6:
                    this.f19296b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f19296b);
                    break;
                case 7:
                    this.f19298c = obtainStyledAttributes.getFloat(index, this.f19298c);
                    break;
                case 8:
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f19300d);
                    this.f19300d = resourceId2;
                    if (resourceId2 == -1) {
                        this.f19300d = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, this.e);
                    this.e = resourceId3;
                    if (resourceId3 == -1) {
                        this.e = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f19303f);
                    this.f19303f = resourceId4;
                    if (resourceId4 == -1) {
                        this.f19303f = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f19305g);
                    this.f19305g = resourceId5;
                    if (resourceId5 == -1) {
                        this.f19305g = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f19307h);
                    this.f19307h = resourceId6;
                    if (resourceId6 == -1) {
                        this.f19307h = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f19309i);
                    this.f19309i = resourceId7;
                    if (resourceId7 == -1) {
                        this.f19309i = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f19310j);
                    this.f19310j = resourceId8;
                    if (resourceId8 == -1) {
                        this.f19310j = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f19312k);
                    this.f19312k = resourceId9;
                    if (resourceId9 == -1) {
                        this.f19312k = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f19314l);
                    this.f19314l = resourceId10;
                    if (resourceId10 == -1) {
                        this.f19314l = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, this.r);
                    this.r = resourceId11;
                    if (resourceId11 == -1) {
                        this.r = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 18:
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f19325s);
                    this.f19325s = resourceId12;
                    if (resourceId12 == -1) {
                        this.f19325s = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 19:
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f19326t);
                    this.f19326t = resourceId13;
                    if (resourceId13 == -1) {
                        this.f19326t = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 20:
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f19327u);
                    this.f19327u = resourceId14;
                    if (resourceId14 == -1) {
                        this.f19327u = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 21:
                    this.f19328v = obtainStyledAttributes.getDimensionPixelSize(index, this.f19328v);
                    break;
                case 22:
                    this.f19329w = obtainStyledAttributes.getDimensionPixelSize(index, this.f19329w);
                    break;
                case 23:
                    this.f19330x = obtainStyledAttributes.getDimensionPixelSize(index, this.f19330x);
                    break;
                case 24:
                    this.f19331y = obtainStyledAttributes.getDimensionPixelSize(index, this.f19331y);
                    break;
                case 25:
                    this.f19332z = obtainStyledAttributes.getDimensionPixelSize(index, this.f19332z);
                    break;
                case 26:
                    this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                    break;
                case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                    this.V = obtainStyledAttributes.getBoolean(index, this.V);
                    break;
                case Const.ANDROID_VERSION_28 /* 28 */:
                    this.W = obtainStyledAttributes.getBoolean(index, this.W);
                    break;
                case Const.ANDROID_VERSION_29 /* 29 */:
                    this.D = obtainStyledAttributes.getFloat(index, this.D);
                    break;
                case 30:
                    this.E = obtainStyledAttributes.getFloat(index, this.E);
                    break;
                case 31:
                    int i11 = obtainStyledAttributes.getInt(index, 0);
                    this.K = i11;
                    if (i11 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 32:
                    int i12 = obtainStyledAttributes.getInt(index, 0);
                    this.L = i12;
                    if (i12 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 33:
                    try {
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    } catch (Exception unused) {
                        if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                            this.M = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 34:
                    try {
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    } catch (Exception unused2) {
                        if (obtainStyledAttributes.getInt(index, this.O) == -2) {
                            this.O = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 35:
                    this.Q = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.Q));
                    this.K = 2;
                    break;
                case 36:
                    try {
                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    } catch (Exception unused3) {
                        if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                            this.N = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 37:
                    try {
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    } catch (Exception unused4) {
                        if (obtainStyledAttributes.getInt(index, this.P) == -2) {
                            this.P = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case WXMediaMessage.IMediaObject.TYPE_VIDEO_FILE /* 38 */:
                    this.R = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.R));
                    this.L = 2;
                    break;
                default:
                    switch (i10) {
                        case 44:
                            o.n(this, obtainStyledAttributes.getString(index));
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_BUSINESS_CARD /* 45 */:
                            this.G = obtainStyledAttributes.getFloat(index, this.G);
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /* 46 */:
                            this.H = obtainStyledAttributes.getFloat(index, this.H);
                            break;
                        case 47:
                            this.I = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case TraceLevel.ABOVE_WARN /* 48 */:
                            this.J = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            this.S = obtainStyledAttributes.getDimensionPixelOffset(index, this.S);
                            break;
                        case SpatialRelationUtil.MIN_OFFSET_DEGREE /* 50 */:
                            this.T = obtainStyledAttributes.getDimensionPixelOffset(index, this.T);
                            break;
                        case 51:
                            this.X = obtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = obtainStyledAttributes.getResourceId(index, this.f19316m);
                            this.f19316m = resourceId15;
                            if (resourceId15 == -1) {
                                this.f19316m = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            int resourceId16 = obtainStyledAttributes.getResourceId(index, this.f19318n);
                            this.f19318n = resourceId16;
                            if (resourceId16 == -1) {
                                this.f19318n = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                            break;
                        case 55:
                            this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                            break;
                        default:
                            switch (i10) {
                                case 64:
                                    o.m(this, obtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    o.m(this, obtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    this.Y = obtainStyledAttributes.getInt(index, this.Y);
                                    break;
                            }
                    }
            }
        }
        obtainStyledAttributes.recycle();
        a();
    }

    public final void a() {
        this.f19299c0 = false;
        this.Z = true;
        this.f19295a0 = true;
        int i3 = ((ViewGroup.MarginLayoutParams) this).width;
        if (i3 == -2 && this.V) {
            this.Z = false;
            if (this.K == 0) {
                this.K = 1;
            }
        }
        int i10 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i10 == -2 && this.W) {
            this.f19295a0 = false;
            if (this.L == 0) {
                this.L = 1;
            }
        }
        if (i3 == 0 || i3 == -1) {
            this.Z = false;
            if (i3 == 0 && this.K == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.V = true;
            }
        }
        if (i10 == 0 || i10 == -1) {
            this.f19295a0 = false;
            if (i10 == 0 && this.L == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.W = true;
            }
        }
        if (this.f19298c == -1.0f && this.f19294a == -1 && this.f19296b == -1) {
            return;
        }
        this.f19299c0 = true;
        this.Z = true;
        this.f19295a0 = true;
        if (!(this.f19323p0 instanceof q0.k)) {
            this.f19323p0 = new q0.k();
        }
        ((q0.k) this.f19323p0).O(this.U);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resolveLayoutDirection(int r11) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.e.resolveLayoutDirection(int):void");
    }

    public e() {
        super(-2, -2);
        this.f19294a = -1;
        this.f19296b = -1;
        this.f19298c = -1.0f;
        this.f19300d = -1;
        this.e = -1;
        this.f19303f = -1;
        this.f19305g = -1;
        this.f19307h = -1;
        this.f19309i = -1;
        this.f19310j = -1;
        this.f19312k = -1;
        this.f19314l = -1;
        this.f19316m = -1;
        this.f19318n = -1;
        this.f19320o = -1;
        this.f19322p = 0;
        this.f19324q = 0.0f;
        this.r = -1;
        this.f19325s = -1;
        this.f19326t = -1;
        this.f19327u = -1;
        this.f19328v = Integer.MIN_VALUE;
        this.f19329w = Integer.MIN_VALUE;
        this.f19330x = Integer.MIN_VALUE;
        this.f19331y = Integer.MIN_VALUE;
        this.f19332z = Integer.MIN_VALUE;
        this.A = Integer.MIN_VALUE;
        this.B = Integer.MIN_VALUE;
        this.C = 0;
        this.D = 0.5f;
        this.E = 0.5f;
        this.F = null;
        this.G = -1.0f;
        this.H = -1.0f;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 1.0f;
        this.R = 1.0f;
        this.S = -1;
        this.T = -1;
        this.U = -1;
        this.V = false;
        this.W = false;
        this.X = null;
        this.Y = 0;
        this.Z = true;
        this.f19295a0 = true;
        this.f19297b0 = false;
        this.f19299c0 = false;
        this.f19301d0 = false;
        this.f19302e0 = false;
        this.f19304f0 = -1;
        this.f19306g0 = -1;
        this.f19308h0 = -1;
        this.i0 = -1;
        this.f19311j0 = Integer.MIN_VALUE;
        this.f19313k0 = Integer.MIN_VALUE;
        this.f19315l0 = 0.5f;
        this.f19323p0 = new q0.f();
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f19294a = -1;
        this.f19296b = -1;
        this.f19298c = -1.0f;
        this.f19300d = -1;
        this.e = -1;
        this.f19303f = -1;
        this.f19305g = -1;
        this.f19307h = -1;
        this.f19309i = -1;
        this.f19310j = -1;
        this.f19312k = -1;
        this.f19314l = -1;
        this.f19316m = -1;
        this.f19318n = -1;
        this.f19320o = -1;
        this.f19322p = 0;
        this.f19324q = 0.0f;
        this.r = -1;
        this.f19325s = -1;
        this.f19326t = -1;
        this.f19327u = -1;
        this.f19328v = Integer.MIN_VALUE;
        this.f19329w = Integer.MIN_VALUE;
        this.f19330x = Integer.MIN_VALUE;
        this.f19331y = Integer.MIN_VALUE;
        this.f19332z = Integer.MIN_VALUE;
        this.A = Integer.MIN_VALUE;
        this.B = Integer.MIN_VALUE;
        this.C = 0;
        this.D = 0.5f;
        this.E = 0.5f;
        this.F = null;
        this.G = -1.0f;
        this.H = -1.0f;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 1.0f;
        this.R = 1.0f;
        this.S = -1;
        this.T = -1;
        this.U = -1;
        this.V = false;
        this.W = false;
        this.X = null;
        this.Y = 0;
        this.Z = true;
        this.f19295a0 = true;
        this.f19297b0 = false;
        this.f19299c0 = false;
        this.f19301d0 = false;
        this.f19302e0 = false;
        this.f19304f0 = -1;
        this.f19306g0 = -1;
        this.f19308h0 = -1;
        this.i0 = -1;
        this.f19311j0 = Integer.MIN_VALUE;
        this.f19313k0 = Integer.MIN_VALUE;
        this.f19315l0 = 0.5f;
        this.f19323p0 = new q0.f();
    }
}
