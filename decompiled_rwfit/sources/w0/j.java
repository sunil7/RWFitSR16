package w0;

import android.view.ViewGroup;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public int f19360a;

    /* renamed from: b, reason: collision with root package name */
    public String f19361b;

    /* renamed from: c, reason: collision with root package name */
    public final m f19362c;

    /* renamed from: d, reason: collision with root package name */
    public final l f19363d;
    public final k e;

    /* renamed from: f, reason: collision with root package name */
    public final n f19364f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap f19365g;

    /* renamed from: h, reason: collision with root package name */
    public i f19366h;

    public j() {
        m mVar = new m();
        mVar.f19419a = false;
        mVar.f19420b = 0;
        mVar.f19421c = 0;
        mVar.f19422d = 1.0f;
        mVar.e = Float.NaN;
        this.f19362c = mVar;
        l lVar = new l();
        lVar.f19407a = false;
        lVar.f19408b = -1;
        lVar.f19409c = 0;
        lVar.f19410d = null;
        lVar.e = -1;
        lVar.f19411f = 0;
        lVar.f19412g = Float.NaN;
        lVar.f19413h = Float.NaN;
        lVar.f19414i = Float.NaN;
        lVar.f19415j = -1;
        lVar.f19416k = null;
        lVar.f19417l = -3;
        lVar.f19418m = -1;
        this.f19363d = lVar;
        k kVar = new k();
        kVar.f19368a = false;
        kVar.f19370b = false;
        kVar.e = -1;
        kVar.f19377f = -1;
        kVar.f19379g = -1.0f;
        kVar.f19381h = -1;
        kVar.f19383i = -1;
        kVar.f19384j = -1;
        kVar.f19386k = -1;
        kVar.f19388l = -1;
        kVar.f19390m = -1;
        kVar.f19392n = -1;
        kVar.f19394o = -1;
        kVar.f19396p = -1;
        kVar.f19397q = -1;
        kVar.r = -1;
        kVar.f19398s = -1;
        kVar.f19399t = -1;
        kVar.f19400u = -1;
        kVar.f19401v = -1;
        kVar.f19402w = 0.5f;
        kVar.f19403x = 0.5f;
        kVar.f19404y = null;
        kVar.f19405z = -1;
        kVar.A = 0;
        kVar.B = 0.0f;
        kVar.C = -1;
        kVar.D = -1;
        kVar.E = -1;
        kVar.F = 0;
        kVar.G = 0;
        kVar.H = 0;
        kVar.I = 0;
        kVar.J = 0;
        kVar.K = 0;
        kVar.L = 0;
        kVar.M = Integer.MIN_VALUE;
        kVar.N = Integer.MIN_VALUE;
        kVar.O = Integer.MIN_VALUE;
        kVar.P = Integer.MIN_VALUE;
        kVar.Q = Integer.MIN_VALUE;
        kVar.R = Integer.MIN_VALUE;
        kVar.S = Integer.MIN_VALUE;
        kVar.T = -1.0f;
        kVar.U = -1.0f;
        kVar.V = 0;
        kVar.W = 0;
        kVar.X = 0;
        kVar.Y = 0;
        kVar.Z = 0;
        kVar.f19369a0 = 0;
        kVar.f19371b0 = 0;
        kVar.f19373c0 = 0;
        kVar.f19375d0 = 1.0f;
        kVar.f19376e0 = 1.0f;
        kVar.f19378f0 = -1;
        kVar.f19380g0 = 0;
        kVar.f19382h0 = -1;
        kVar.f19389l0 = false;
        kVar.f19391m0 = false;
        kVar.f19393n0 = true;
        kVar.f19395o0 = 0;
        this.e = kVar;
        n nVar = new n();
        nVar.f19424a = false;
        nVar.f19425b = 0.0f;
        nVar.f19426c = 0.0f;
        nVar.f19427d = 0.0f;
        nVar.e = 1.0f;
        nVar.f19428f = 1.0f;
        nVar.f19429g = Float.NaN;
        nVar.f19430h = Float.NaN;
        nVar.f19431i = -1;
        nVar.f19432j = 0.0f;
        nVar.f19433k = 0.0f;
        nVar.f19434l = 0.0f;
        nVar.f19435m = false;
        nVar.f19436n = 0.0f;
        this.f19364f = nVar;
        this.f19365g = new HashMap();
    }

    public final void a(e eVar) {
        k kVar = this.e;
        eVar.f19300d = kVar.f19381h;
        eVar.e = kVar.f19383i;
        eVar.f19303f = kVar.f19384j;
        eVar.f19305g = kVar.f19386k;
        eVar.f19307h = kVar.f19388l;
        eVar.f19309i = kVar.f19390m;
        eVar.f19310j = kVar.f19392n;
        eVar.f19312k = kVar.f19394o;
        eVar.f19314l = kVar.f19396p;
        eVar.f19316m = kVar.f19397q;
        eVar.f19318n = kVar.r;
        eVar.r = kVar.f19398s;
        eVar.f19325s = kVar.f19399t;
        eVar.f19326t = kVar.f19400u;
        eVar.f19327u = kVar.f19401v;
        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = kVar.F;
        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = kVar.G;
        ((ViewGroup.MarginLayoutParams) eVar).topMargin = kVar.H;
        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = kVar.I;
        eVar.f19332z = kVar.R;
        eVar.A = kVar.Q;
        eVar.f19329w = kVar.N;
        eVar.f19331y = kVar.P;
        eVar.D = kVar.f19402w;
        eVar.E = kVar.f19403x;
        eVar.f19320o = kVar.f19405z;
        eVar.f19322p = kVar.A;
        eVar.f19324q = kVar.B;
        eVar.F = kVar.f19404y;
        eVar.S = kVar.C;
        eVar.T = kVar.D;
        eVar.H = kVar.T;
        eVar.G = kVar.U;
        eVar.J = kVar.W;
        eVar.I = kVar.V;
        eVar.V = kVar.f19389l0;
        eVar.W = kVar.f19391m0;
        eVar.K = kVar.X;
        eVar.L = kVar.Y;
        eVar.O = kVar.Z;
        eVar.P = kVar.f19369a0;
        eVar.M = kVar.f19371b0;
        eVar.N = kVar.f19373c0;
        eVar.Q = kVar.f19375d0;
        eVar.R = kVar.f19376e0;
        eVar.U = kVar.E;
        eVar.f19298c = kVar.f19379g;
        eVar.f19294a = kVar.e;
        eVar.f19296b = kVar.f19377f;
        ((ViewGroup.MarginLayoutParams) eVar).width = kVar.f19372c;
        ((ViewGroup.MarginLayoutParams) eVar).height = kVar.f19374d;
        String str = kVar.f19387k0;
        if (str != null) {
            eVar.X = str;
        }
        eVar.Y = kVar.f19395o0;
        eVar.setMarginStart(kVar.K);
        eVar.setMarginEnd(kVar.J);
        eVar.a();
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final j clone() {
        j jVar = new j();
        jVar.e.a(this.e);
        jVar.f19363d.a(this.f19363d);
        m mVar = jVar.f19362c;
        m mVar2 = this.f19362c;
        mVar.f19419a = mVar2.f19419a;
        mVar.f19420b = mVar2.f19420b;
        mVar.f19422d = mVar2.f19422d;
        mVar.e = mVar2.e;
        mVar.f19421c = mVar2.f19421c;
        jVar.f19364f.a(this.f19364f);
        jVar.f19360a = this.f19360a;
        jVar.f19366h = this.f19366h;
        return jVar;
    }

    public final void c(int i3, e eVar) {
        this.f19360a = i3;
        int i10 = eVar.f19300d;
        k kVar = this.e;
        kVar.f19381h = i10;
        kVar.f19383i = eVar.e;
        kVar.f19384j = eVar.f19303f;
        kVar.f19386k = eVar.f19305g;
        kVar.f19388l = eVar.f19307h;
        kVar.f19390m = eVar.f19309i;
        kVar.f19392n = eVar.f19310j;
        kVar.f19394o = eVar.f19312k;
        kVar.f19396p = eVar.f19314l;
        kVar.f19397q = eVar.f19316m;
        kVar.r = eVar.f19318n;
        kVar.f19398s = eVar.r;
        kVar.f19399t = eVar.f19325s;
        kVar.f19400u = eVar.f19326t;
        kVar.f19401v = eVar.f19327u;
        kVar.f19402w = eVar.D;
        kVar.f19403x = eVar.E;
        kVar.f19404y = eVar.F;
        kVar.f19405z = eVar.f19320o;
        kVar.A = eVar.f19322p;
        kVar.B = eVar.f19324q;
        kVar.C = eVar.S;
        kVar.D = eVar.T;
        kVar.E = eVar.U;
        kVar.f19379g = eVar.f19298c;
        kVar.e = eVar.f19294a;
        kVar.f19377f = eVar.f19296b;
        kVar.f19372c = ((ViewGroup.MarginLayoutParams) eVar).width;
        kVar.f19374d = ((ViewGroup.MarginLayoutParams) eVar).height;
        kVar.F = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
        kVar.G = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
        kVar.H = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        kVar.I = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
        kVar.L = eVar.C;
        kVar.T = eVar.H;
        kVar.U = eVar.G;
        kVar.W = eVar.J;
        kVar.V = eVar.I;
        kVar.f19389l0 = eVar.V;
        kVar.f19391m0 = eVar.W;
        kVar.X = eVar.K;
        kVar.Y = eVar.L;
        kVar.Z = eVar.O;
        kVar.f19369a0 = eVar.P;
        kVar.f19371b0 = eVar.M;
        kVar.f19373c0 = eVar.N;
        kVar.f19375d0 = eVar.Q;
        kVar.f19376e0 = eVar.R;
        kVar.f19387k0 = eVar.X;
        kVar.N = eVar.f19329w;
        kVar.P = eVar.f19331y;
        kVar.M = eVar.f19328v;
        kVar.O = eVar.f19330x;
        kVar.R = eVar.f19332z;
        kVar.Q = eVar.A;
        kVar.S = eVar.B;
        kVar.f19395o0 = eVar.Y;
        kVar.J = eVar.getMarginEnd();
        kVar.K = eVar.getMarginStart();
    }

    public final void d(int i3, p pVar) {
        c(i3, pVar);
        this.f19362c.f19422d = pVar.f19445q0;
        float f2 = pVar.f19448t0;
        n nVar = this.f19364f;
        nVar.f19425b = f2;
        nVar.f19426c = pVar.f19449u0;
        nVar.f19427d = pVar.f19450v0;
        nVar.e = pVar.f19451w0;
        nVar.f19428f = pVar.f19452x0;
        nVar.f19429g = pVar.f19453y0;
        nVar.f19430h = pVar.f19454z0;
        nVar.f19432j = pVar.A0;
        nVar.f19433k = pVar.B0;
        nVar.f19434l = pVar.C0;
        nVar.f19436n = pVar.f19447s0;
        nVar.f19435m = pVar.f19446r0;
    }
}
