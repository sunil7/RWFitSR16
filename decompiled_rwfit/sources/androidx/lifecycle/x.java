package androidx.lifecycle;

/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f2398a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2399b;

    /* renamed from: c, reason: collision with root package name */
    public int f2400c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ y f2401d;

    public x(y yVar, c0 c0Var) {
        this.f2401d = yVar;
        this.f2398a = c0Var;
    }

    public final void a(boolean z5) {
        if (z5 == this.f2399b) {
            return;
        }
        this.f2399b = z5;
        int i3 = z5 ? 1 : -1;
        y yVar = this.f2401d;
        int i10 = yVar.f2405c;
        yVar.f2405c = i3 + i10;
        if (!yVar.f2406d) {
            yVar.f2406d = true;
            while (true) {
                try {
                    int i11 = yVar.f2405c;
                    if (i10 == i11) {
                        break;
                    }
                    boolean z6 = i10 == 0 && i11 > 0;
                    boolean z8 = i10 > 0 && i11 == 0;
                    if (z6) {
                        yVar.g();
                    } else if (z8) {
                        yVar.h();
                    }
                    i10 = i11;
                } catch (Throwable th2) {
                    yVar.f2406d = false;
                    throw th2;
                }
            }
            yVar.f2406d = false;
        }
        if (this.f2399b) {
            yVar.c(this);
        }
    }

    public void b() {
    }

    public boolean d(s sVar) {
        return false;
    }

    public abstract boolean e();
}
