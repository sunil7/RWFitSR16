package p4;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Priority;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import g4.m;
import g4.r;
import okhttp3.internal.http2.Http2;
import t4.l;
import x3.i;
import z3.h;

/* loaded from: classes.dex */
public abstract class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f17451a;

    /* renamed from: d, reason: collision with root package name */
    public int f17454d;
    public int e;

    /* renamed from: j, reason: collision with root package name */
    public boolean f17459j;

    /* renamed from: n, reason: collision with root package name */
    public boolean f17463n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f17464o;

    /* renamed from: q, reason: collision with root package name */
    public boolean f17466q;

    /* renamed from: b, reason: collision with root package name */
    public h f17452b = h.f20241d;

    /* renamed from: c, reason: collision with root package name */
    public Priority f17453c = Priority.NORMAL;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17455f = true;

    /* renamed from: g, reason: collision with root package name */
    public int f17456g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f17457h = -1;

    /* renamed from: i, reason: collision with root package name */
    public x3.c f17458i = s4.c.f18208b;

    /* renamed from: k, reason: collision with root package name */
    public x3.f f17460k = new x3.f();

    /* renamed from: l, reason: collision with root package name */
    public t4.c f17461l = new t4.c();

    /* renamed from: m, reason: collision with root package name */
    public Class f17462m = Object.class;

    /* renamed from: p, reason: collision with root package name */
    public boolean f17465p = true;

    public static boolean f(int i3, int i10) {
        return (i3 & i10) != 0;
    }

    public a a(a aVar) {
        if (this.f17464o) {
            return clone().a(aVar);
        }
        int i3 = aVar.f17451a;
        if (f(aVar.f17451a, Const.I_MAX_OFFLINE_DATA_CACHE)) {
            this.f17466q = aVar.f17466q;
        }
        if (f(aVar.f17451a, 4)) {
            this.f17452b = aVar.f17452b;
        }
        if (f(aVar.f17451a, 8)) {
            this.f17453c = aVar.f17453c;
        }
        if (f(aVar.f17451a, 16)) {
            this.f17454d = 0;
            this.f17451a &= -33;
        }
        if (f(aVar.f17451a, 32)) {
            this.f17454d = aVar.f17454d;
            this.f17451a &= -17;
        }
        if (f(aVar.f17451a, 64)) {
            this.e = 0;
            this.f17451a &= -129;
        }
        if (f(aVar.f17451a, 128)) {
            this.e = aVar.e;
            this.f17451a &= -65;
        }
        if (f(aVar.f17451a, 256)) {
            this.f17455f = aVar.f17455f;
        }
        if (f(aVar.f17451a, 512)) {
            this.f17457h = aVar.f17457h;
            this.f17456g = aVar.f17456g;
        }
        if (f(aVar.f17451a, 1024)) {
            this.f17458i = aVar.f17458i;
        }
        if (f(aVar.f17451a, 4096)) {
            this.f17462m = aVar.f17462m;
        }
        if (f(aVar.f17451a, 8192)) {
            this.f17451a &= -16385;
        }
        if (f(aVar.f17451a, Http2.INITIAL_MAX_FRAME_SIZE)) {
            this.f17451a &= -8193;
        }
        if (f(aVar.f17451a, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)) {
            this.f17459j = aVar.f17459j;
        }
        if (f(aVar.f17451a, 2048)) {
            this.f17461l.putAll(aVar.f17461l);
            this.f17465p = aVar.f17465p;
        }
        this.f17451a |= aVar.f17451a;
        this.f17460k.f19776b.i(aVar.f17460k.f19776b);
        l();
        return this;
    }

    @Override // 
    /* renamed from: b */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            x3.f fVar = new x3.f();
            aVar.f17460k = fVar;
            fVar.f19776b.i(this.f17460k.f19776b);
            t4.c cVar = new t4.c();
            aVar.f17461l = cVar;
            cVar.putAll(this.f17461l);
            aVar.f17463n = false;
            aVar.f17464o = false;
            return aVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final a c(Class cls) {
        if (this.f17464o) {
            return clone().c(cls);
        }
        this.f17462m = cls;
        this.f17451a |= 4096;
        l();
        return this;
    }

    public final a d(h hVar) {
        if (this.f17464o) {
            return clone().d(hVar);
        }
        this.f17452b = hVar;
        this.f17451a |= 4;
        l();
        return this;
    }

    public final a e(int i3) {
        if (this.f17464o) {
            return clone().e(i3);
        }
        this.f17454d = i3;
        this.f17451a = (this.f17451a | 32) & (-17);
        l();
        return this;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        aVar.getClass();
        if (Float.compare(1.0f, 1.0f) != 0 || this.f17454d != aVar.f17454d) {
            return false;
        }
        char[] cArr = l.f18523a;
        return this.e == aVar.e && this.f17455f == aVar.f17455f && this.f17456g == aVar.f17456g && this.f17457h == aVar.f17457h && this.f17459j == aVar.f17459j && this.f17452b.equals(aVar.f17452b) && this.f17453c == aVar.f17453c && this.f17460k.equals(aVar.f17460k) && this.f17461l.equals(aVar.f17461l) && this.f17462m.equals(aVar.f17462m) && this.f17458i.equals(aVar.f17458i);
    }

    public final a g(m mVar, g4.d dVar) {
        if (this.f17464o) {
            return clone().g(mVar, dVar);
        }
        m(m.f13832g, mVar);
        return r(dVar, false);
    }

    public final a h(int i3, int i10) {
        if (this.f17464o) {
            return clone().h(i3, i10);
        }
        this.f17457h = i3;
        this.f17456g = i10;
        this.f17451a |= 512;
        l();
        return this;
    }

    public final int hashCode() {
        char[] cArr = l.f18523a;
        return l.g(l.g(l.g(l.g(l.g(l.g(l.g(l.f(0, l.f(0, l.f(1, l.f(this.f17459j ? 1 : 0, l.f(this.f17457h, l.f(this.f17456g, l.f(this.f17455f ? 1 : 0, l.g(l.f(0, l.g(l.f(this.e, l.g(l.f(this.f17454d, l.f(Float.floatToIntBits(1.0f), 17)), null)), null)), null)))))))), this.f17452b), this.f17453c), this.f17460k), this.f17461l), this.f17462m), this.f17458i), null);
    }

    public final a i(int i3) {
        if (this.f17464o) {
            return clone().i(i3);
        }
        this.e = i3;
        this.f17451a = (this.f17451a | 128) & (-65);
        l();
        return this;
    }

    public final a j(Priority priority) {
        if (this.f17464o) {
            return clone().j(priority);
        }
        t4.f.c(priority, "Argument must not be null");
        this.f17453c = priority;
        this.f17451a |= 8;
        l();
        return this;
    }

    public final a k(m mVar, g4.d dVar, boolean z5) {
        a p8 = z5 ? p(mVar, dVar) : g(mVar, dVar);
        p8.f17465p = true;
        return p8;
    }

    public final void l() {
        if (this.f17463n) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public final a m(x3.e eVar, m mVar) {
        if (this.f17464o) {
            return clone().m(eVar, mVar);
        }
        t4.f.b(eVar);
        this.f17460k.f19776b.put(eVar, mVar);
        l();
        return this;
    }

    public final a n(x3.c cVar) {
        if (this.f17464o) {
            return clone().n(cVar);
        }
        this.f17458i = cVar;
        this.f17451a |= 1024;
        l();
        return this;
    }

    public final a o(boolean z5) {
        if (this.f17464o) {
            return clone().o(true);
        }
        this.f17455f = !z5;
        this.f17451a |= 256;
        l();
        return this;
    }

    public final a p(m mVar, g4.d dVar) {
        if (this.f17464o) {
            return clone().p(mVar, dVar);
        }
        m(m.f13832g, mVar);
        return r(dVar, true);
    }

    public final a q(Class cls, i iVar, boolean z5) {
        if (this.f17464o) {
            return clone().q(cls, iVar, z5);
        }
        t4.f.b(iVar);
        this.f17461l.put(cls, iVar);
        int i3 = this.f17451a;
        this.f17451a = 67584 | i3;
        this.f17465p = false;
        if (z5) {
            this.f17451a = i3 | 198656;
            this.f17459j = true;
        }
        l();
        return this;
    }

    public final a r(i iVar, boolean z5) {
        if (this.f17464o) {
            return clone().r(iVar, z5);
        }
        r rVar = new r(iVar, z5);
        q(Bitmap.class, iVar, z5);
        q(Drawable.class, rVar, z5);
        q(BitmapDrawable.class, rVar, z5);
        q(k4.c.class, new k4.d(iVar), z5);
        l();
        return this;
    }

    public final a s() {
        if (this.f17464o) {
            return clone().s();
        }
        this.f17466q = true;
        this.f17451a |= Const.I_MAX_OFFLINE_DATA_CACHE;
        l();
        return this;
    }
}
