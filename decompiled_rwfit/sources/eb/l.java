package eb;

import com.google.android.gms.internal.mlkit_vision_barcode.qb;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public qb f12528a = new k();

    /* renamed from: b, reason: collision with root package name */
    public qb f12529b = new k();

    /* renamed from: c, reason: collision with root package name */
    public qb f12530c = new k();

    /* renamed from: d, reason: collision with root package name */
    public qb f12531d = new k();
    public c e = new a(0.0f);

    /* renamed from: f, reason: collision with root package name */
    public c f12532f = new a(0.0f);

    /* renamed from: g, reason: collision with root package name */
    public c f12533g = new a(0.0f);

    /* renamed from: h, reason: collision with root package name */
    public c f12534h = new a(0.0f);

    /* renamed from: i, reason: collision with root package name */
    public e f12535i = new e(0);

    /* renamed from: j, reason: collision with root package name */
    public e f12536j = new e(0);

    /* renamed from: k, reason: collision with root package name */
    public e f12537k = new e(0);

    /* renamed from: l, reason: collision with root package name */
    public e f12538l = new e(0);

    public static void b(qb qbVar) {
        if (qbVar instanceof k) {
            return;
        }
        boolean z5 = qbVar instanceof d;
    }

    public final m a() {
        m mVar = new m();
        mVar.f12540a = this.f12528a;
        mVar.f12541b = this.f12529b;
        mVar.f12542c = this.f12530c;
        mVar.f12543d = this.f12531d;
        mVar.e = this.e;
        mVar.f12544f = this.f12532f;
        mVar.f12545g = this.f12533g;
        mVar.f12546h = this.f12534h;
        mVar.f12547i = this.f12535i;
        mVar.f12548j = this.f12536j;
        mVar.f12549k = this.f12537k;
        mVar.f12550l = this.f12538l;
        return mVar;
    }

    public final void c(float f2) {
        this.e = new a(f2);
        this.f12532f = new a(f2);
        this.f12533g = new a(f2);
        this.f12534h = new a(f2);
    }
}
