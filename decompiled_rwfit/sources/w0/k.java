package w0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.open.log.TraceLevel;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: p0, reason: collision with root package name */
    public static final SparseIntArray f19367p0;
    public int A;
    public float B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public float T;
    public float U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19368a;

    /* renamed from: a0, reason: collision with root package name */
    public int f19369a0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19370b;

    /* renamed from: b0, reason: collision with root package name */
    public int f19371b0;

    /* renamed from: c, reason: collision with root package name */
    public int f19372c;

    /* renamed from: c0, reason: collision with root package name */
    public int f19373c0;

    /* renamed from: d, reason: collision with root package name */
    public int f19374d;

    /* renamed from: d0, reason: collision with root package name */
    public float f19375d0;
    public int e;

    /* renamed from: e0, reason: collision with root package name */
    public float f19376e0;

    /* renamed from: f, reason: collision with root package name */
    public int f19377f;

    /* renamed from: f0, reason: collision with root package name */
    public int f19378f0;

    /* renamed from: g, reason: collision with root package name */
    public float f19379g;

    /* renamed from: g0, reason: collision with root package name */
    public int f19380g0;

    /* renamed from: h, reason: collision with root package name */
    public int f19381h;

    /* renamed from: h0, reason: collision with root package name */
    public int f19382h0;

    /* renamed from: i, reason: collision with root package name */
    public int f19383i;
    public int[] i0;

    /* renamed from: j, reason: collision with root package name */
    public int f19384j;

    /* renamed from: j0, reason: collision with root package name */
    public String f19385j0;

    /* renamed from: k, reason: collision with root package name */
    public int f19386k;

    /* renamed from: k0, reason: collision with root package name */
    public String f19387k0;

    /* renamed from: l, reason: collision with root package name */
    public int f19388l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f19389l0;

    /* renamed from: m, reason: collision with root package name */
    public int f19390m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f19391m0;

    /* renamed from: n, reason: collision with root package name */
    public int f19392n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f19393n0;

    /* renamed from: o, reason: collision with root package name */
    public int f19394o;

    /* renamed from: o0, reason: collision with root package name */
    public int f19395o0;

    /* renamed from: p, reason: collision with root package name */
    public int f19396p;

    /* renamed from: q, reason: collision with root package name */
    public int f19397q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f19398s;

    /* renamed from: t, reason: collision with root package name */
    public int f19399t;

    /* renamed from: u, reason: collision with root package name */
    public int f19400u;

    /* renamed from: v, reason: collision with root package name */
    public int f19401v;

    /* renamed from: w, reason: collision with root package name */
    public float f19402w;

    /* renamed from: x, reason: collision with root package name */
    public float f19403x;

    /* renamed from: y, reason: collision with root package name */
    public String f19404y;

    /* renamed from: z, reason: collision with root package name */
    public int f19405z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19367p0 = sparseIntArray;
        sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
        sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
        sparseIntArray.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
        sparseIntArray.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
        sparseIntArray.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
        sparseIntArray.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
        sparseIntArray.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
        sparseIntArray.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
        sparseIntArray.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
        sparseIntArray.append(R$styleable.Layout_layout_editor_absoluteX, 6);
        sparseIntArray.append(R$styleable.Layout_layout_editor_absoluteY, 7);
        sparseIntArray.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
        sparseIntArray.append(R$styleable.Layout_layout_constraintGuide_end, 18);
        sparseIntArray.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
        sparseIntArray.append(R$styleable.Layout_android_orientation, 26);
        sparseIntArray.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
        sparseIntArray.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
        sparseIntArray.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
        sparseIntArray.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
        sparseIntArray.append(R$styleable.Layout_layout_goneMarginLeft, 13);
        sparseIntArray.append(R$styleable.Layout_layout_goneMarginTop, 16);
        sparseIntArray.append(R$styleable.Layout_layout_goneMarginRight, 14);
        sparseIntArray.append(R$styleable.Layout_layout_goneMarginBottom, 11);
        sparseIntArray.append(R$styleable.Layout_layout_goneMarginStart, 15);
        sparseIntArray.append(R$styleable.Layout_layout_goneMarginEnd, 12);
        sparseIntArray.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
        sparseIntArray.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
        sparseIntArray.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
        sparseIntArray.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
        sparseIntArray.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
        sparseIntArray.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
        sparseIntArray.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
        sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_creator, 76);
        sparseIntArray.append(R$styleable.Layout_layout_constraintTop_creator, 76);
        sparseIntArray.append(R$styleable.Layout_layout_constraintRight_creator, 76);
        sparseIntArray.append(R$styleable.Layout_layout_constraintBottom_creator, 76);
        sparseIntArray.append(R$styleable.Layout_layout_constraintBaseline_creator, 76);
        sparseIntArray.append(R$styleable.Layout_android_layout_marginLeft, 23);
        sparseIntArray.append(R$styleable.Layout_android_layout_marginRight, 27);
        sparseIntArray.append(R$styleable.Layout_android_layout_marginStart, 30);
        sparseIntArray.append(R$styleable.Layout_android_layout_marginEnd, 8);
        sparseIntArray.append(R$styleable.Layout_android_layout_marginTop, 33);
        sparseIntArray.append(R$styleable.Layout_android_layout_marginBottom, 2);
        sparseIntArray.append(R$styleable.Layout_android_layout_width, 22);
        sparseIntArray.append(R$styleable.Layout_android_layout_height, 21);
        sparseIntArray.append(R$styleable.Layout_layout_constraintWidth, 41);
        sparseIntArray.append(R$styleable.Layout_layout_constraintHeight, 42);
        sparseIntArray.append(R$styleable.Layout_layout_constrainedWidth, 41);
        sparseIntArray.append(R$styleable.Layout_layout_constrainedHeight, 42);
        sparseIntArray.append(R$styleable.Layout_layout_wrapBehaviorInParent, 97);
        sparseIntArray.append(R$styleable.Layout_layout_constraintCircle, 61);
        sparseIntArray.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
        sparseIntArray.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
        sparseIntArray.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
        sparseIntArray.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
        sparseIntArray.append(R$styleable.Layout_chainUseRtl, 71);
        sparseIntArray.append(R$styleable.Layout_barrierDirection, 72);
        sparseIntArray.append(R$styleable.Layout_barrierMargin, 73);
        sparseIntArray.append(R$styleable.Layout_constraint_referenced_ids, 74);
        sparseIntArray.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
    }

    public final void a(k kVar) {
        this.f19368a = kVar.f19368a;
        this.f19372c = kVar.f19372c;
        this.f19370b = kVar.f19370b;
        this.f19374d = kVar.f19374d;
        this.e = kVar.e;
        this.f19377f = kVar.f19377f;
        this.f19379g = kVar.f19379g;
        this.f19381h = kVar.f19381h;
        this.f19383i = kVar.f19383i;
        this.f19384j = kVar.f19384j;
        this.f19386k = kVar.f19386k;
        this.f19388l = kVar.f19388l;
        this.f19390m = kVar.f19390m;
        this.f19392n = kVar.f19392n;
        this.f19394o = kVar.f19394o;
        this.f19396p = kVar.f19396p;
        this.f19397q = kVar.f19397q;
        this.r = kVar.r;
        this.f19398s = kVar.f19398s;
        this.f19399t = kVar.f19399t;
        this.f19400u = kVar.f19400u;
        this.f19401v = kVar.f19401v;
        this.f19402w = kVar.f19402w;
        this.f19403x = kVar.f19403x;
        this.f19404y = kVar.f19404y;
        this.f19405z = kVar.f19405z;
        this.A = kVar.A;
        this.B = kVar.B;
        this.C = kVar.C;
        this.D = kVar.D;
        this.E = kVar.E;
        this.F = kVar.F;
        this.G = kVar.G;
        this.H = kVar.H;
        this.I = kVar.I;
        this.J = kVar.J;
        this.K = kVar.K;
        this.L = kVar.L;
        this.M = kVar.M;
        this.N = kVar.N;
        this.O = kVar.O;
        this.P = kVar.P;
        this.Q = kVar.Q;
        this.R = kVar.R;
        this.S = kVar.S;
        this.T = kVar.T;
        this.U = kVar.U;
        this.V = kVar.V;
        this.W = kVar.W;
        this.X = kVar.X;
        this.Y = kVar.Y;
        this.Z = kVar.Z;
        this.f19369a0 = kVar.f19369a0;
        this.f19371b0 = kVar.f19371b0;
        this.f19373c0 = kVar.f19373c0;
        this.f19375d0 = kVar.f19375d0;
        this.f19376e0 = kVar.f19376e0;
        this.f19378f0 = kVar.f19378f0;
        this.f19380g0 = kVar.f19380g0;
        this.f19382h0 = kVar.f19382h0;
        this.f19387k0 = kVar.f19387k0;
        int[] iArr = kVar.i0;
        if (iArr == null || kVar.f19385j0 != null) {
            this.i0 = null;
        } else {
            this.i0 = Arrays.copyOf(iArr, iArr.length);
        }
        this.f19385j0 = kVar.f19385j0;
        this.f19389l0 = kVar.f19389l0;
        this.f19391m0 = kVar.f19391m0;
        this.f19393n0 = kVar.f19393n0;
        this.f19395o0 = kVar.f19395o0;
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
        this.f19370b = true;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            SparseIntArray sparseIntArray = f19367p0;
            int i10 = sparseIntArray.get(index);
            if (i10 == 80) {
                this.f19389l0 = obtainStyledAttributes.getBoolean(index, this.f19389l0);
            } else if (i10 == 81) {
                this.f19391m0 = obtainStyledAttributes.getBoolean(index, this.f19391m0);
            } else if (i10 != 97) {
                switch (i10) {
                    case 1:
                        this.f19396p = o.l(obtainStyledAttributes, index, this.f19396p);
                        break;
                    case 2:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 3:
                        this.f19394o = o.l(obtainStyledAttributes, index, this.f19394o);
                        break;
                    case 4:
                        this.f19392n = o.l(obtainStyledAttributes, index, this.f19392n);
                        break;
                    case 5:
                        this.f19404y = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.C = obtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                        break;
                    case 7:
                        this.D = obtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                        break;
                    case 8:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 9:
                        this.f19401v = o.l(obtainStyledAttributes, index, this.f19401v);
                        break;
                    case 10:
                        this.f19400u = o.l(obtainStyledAttributes, index, this.f19400u);
                        break;
                    case 11:
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 12:
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 13:
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 14:
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 15:
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 16:
                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case 17:
                        this.e = obtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                        break;
                    case 18:
                        this.f19377f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f19377f);
                        break;
                    case 19:
                        this.f19379g = obtainStyledAttributes.getFloat(index, this.f19379g);
                        break;
                    case 20:
                        this.f19402w = obtainStyledAttributes.getFloat(index, this.f19402w);
                        break;
                    case 21:
                        this.f19374d = obtainStyledAttributes.getLayoutDimension(index, this.f19374d);
                        break;
                    case 22:
                        this.f19372c = obtainStyledAttributes.getLayoutDimension(index, this.f19372c);
                        break;
                    case 23:
                        this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                        break;
                    case 24:
                        this.f19381h = o.l(obtainStyledAttributes, index, this.f19381h);
                        break;
                    case 25:
                        this.f19383i = o.l(obtainStyledAttributes, index, this.f19383i);
                        break;
                    case 26:
                        this.E = obtainStyledAttributes.getInt(index, this.E);
                        break;
                    case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                        this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case Const.ANDROID_VERSION_28 /* 28 */:
                        this.f19384j = o.l(obtainStyledAttributes, index, this.f19384j);
                        break;
                    case Const.ANDROID_VERSION_29 /* 29 */:
                        this.f19386k = o.l(obtainStyledAttributes, index, this.f19386k);
                        break;
                    case 30:
                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 31:
                        this.f19398s = o.l(obtainStyledAttributes, index, this.f19398s);
                        break;
                    case 32:
                        this.f19399t = o.l(obtainStyledAttributes, index, this.f19399t);
                        break;
                    case 33:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 34:
                        this.f19390m = o.l(obtainStyledAttributes, index, this.f19390m);
                        break;
                    case 35:
                        this.f19388l = o.l(obtainStyledAttributes, index, this.f19388l);
                        break;
                    case 36:
                        this.f19403x = obtainStyledAttributes.getFloat(index, this.f19403x);
                        break;
                    case 37:
                        this.U = obtainStyledAttributes.getFloat(index, this.U);
                        break;
                    case WXMediaMessage.IMediaObject.TYPE_VIDEO_FILE /* 38 */:
                        this.T = obtainStyledAttributes.getFloat(index, this.T);
                        break;
                    case WXMediaMessage.IMediaObject.TYPE_GAME_VIDEO_FILE /* 39 */:
                        this.V = obtainStyledAttributes.getInt(index, this.V);
                        break;
                    case 40:
                        this.W = obtainStyledAttributes.getInt(index, this.W);
                        break;
                    case 41:
                        o.m(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        o.m(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i10) {
                            case 54:
                                this.X = obtainStyledAttributes.getInt(index, this.X);
                                break;
                            case 55:
                                this.Y = obtainStyledAttributes.getInt(index, this.Y);
                                break;
                            case 56:
                                this.Z = obtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                break;
                            case 57:
                                this.f19369a0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f19369a0);
                                break;
                            case 58:
                                this.f19371b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f19371b0);
                                break;
                            case 59:
                                this.f19373c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f19373c0);
                                break;
                            default:
                                switch (i10) {
                                    case 61:
                                        this.f19405z = o.l(obtainStyledAttributes, index, this.f19405z);
                                        break;
                                    case 62:
                                        this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                                        break;
                                    case TraceLevel.ALL /* 63 */:
                                        this.B = obtainStyledAttributes.getFloat(index, this.B);
                                        break;
                                    default:
                                        switch (i10) {
                                            case 69:
                                                this.f19375d0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case 70:
                                                this.f19376e0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case 71:
                                                Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                break;
                                            case 72:
                                                this.f19378f0 = obtainStyledAttributes.getInt(index, this.f19378f0);
                                                break;
                                            case 73:
                                                this.f19380g0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f19380g0);
                                                break;
                                            case 74:
                                                this.f19385j0 = obtainStyledAttributes.getString(index);
                                                break;
                                            case 75:
                                                this.f19393n0 = obtainStyledAttributes.getBoolean(index, this.f19393n0);
                                                break;
                                            case 76:
                                                String hexString = Integer.toHexString(index);
                                                int i11 = sparseIntArray.get(index);
                                                StringBuilder sb2 = new StringBuilder(r5.a.a(33, hexString));
                                                sb2.append("unused attribute 0x");
                                                sb2.append(hexString);
                                                sb2.append("   ");
                                                sb2.append(i11);
                                                Log.w("ConstraintSet", sb2.toString());
                                                break;
                                            case 77:
                                                this.f19387k0 = obtainStyledAttributes.getString(index);
                                                break;
                                            default:
                                                switch (i10) {
                                                    case 91:
                                                        this.f19397q = o.l(obtainStyledAttributes, index, this.f19397q);
                                                        break;
                                                    case 92:
                                                        this.r = o.l(obtainStyledAttributes, index, this.r);
                                                        break;
                                                    case 93:
                                                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                                        break;
                                                    case 94:
                                                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                                                        break;
                                                    default:
                                                        String hexString2 = Integer.toHexString(index);
                                                        int i12 = sparseIntArray.get(index);
                                                        StringBuilder sb3 = new StringBuilder(r5.a.a(34, hexString2));
                                                        sb3.append("Unknown attribute 0x");
                                                        sb3.append(hexString2);
                                                        sb3.append("   ");
                                                        sb3.append(i12);
                                                        Log.w("ConstraintSet", sb3.toString());
                                                        break;
                                                }
                                        }
                                }
                        }
                }
            } else {
                this.f19395o0 = obtainStyledAttributes.getInt(index, this.f19395o0);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
