package androidx.work.impl;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import b2.a;
import b2.k;
import java.util.HashMap;
import mc.g;
import n.l;
import o4.c;
import o4.e;
import p0.f;

/* loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f3007s = 0;

    /* renamed from: l, reason: collision with root package name */
    public volatile f f3008l;

    /* renamed from: m, reason: collision with root package name */
    public volatile e f3009m;

    /* renamed from: n, reason: collision with root package name */
    public volatile c f3010n;

    /* renamed from: o, reason: collision with root package name */
    public volatile l f3011o;

    /* renamed from: p, reason: collision with root package name */
    public volatile e f3012p;

    /* renamed from: q, reason: collision with root package name */
    public volatile l f3013q;
    public volatile c r;

    @Override // b2.i
    public final b2.e d() {
        return new b2.e(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // b2.i
    public final SupportSQLiteOpenHelper e(a aVar) {
        return aVar.f3089a.create(SupportSQLiteOpenHelper.Configuration.builder(aVar.f3090b).name(aVar.f3091c).callback(new k(aVar, new g(this, 8))).build());
    }

    @Override // androidx.work.impl.WorkDatabase
    public final e i() {
        e eVar;
        if (this.f3009m != null) {
            return this.f3009m;
        }
        synchronized (this) {
            try {
                if (this.f3009m == null) {
                    this.f3009m = new e(this, 8);
                }
                eVar = this.f3009m;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final c j() {
        c cVar;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new c(this, 12);
                }
                cVar = this.r;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final l k() {
        l lVar;
        if (this.f3011o != null) {
            return this.f3011o;
        }
        synchronized (this) {
            try {
                if (this.f3011o == null) {
                    this.f3011o = new l(this, 11);
                }
                lVar = this.f3011o;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return lVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final e l() {
        e eVar;
        if (this.f3012p != null) {
            return this.f3012p;
        }
        synchronized (this) {
            try {
                if (this.f3012p == null) {
                    this.f3012p = new e(this, 9);
                }
                eVar = this.f3012p;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final l m() {
        l lVar;
        if (this.f3013q != null) {
            return this.f3013q;
        }
        synchronized (this) {
            try {
                if (this.f3013q == null) {
                    this.f3013q = new l(this, 12);
                }
                lVar = this.f3013q;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return lVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final f n() {
        f fVar;
        if (this.f3008l != null) {
            return this.f3008l;
        }
        synchronized (this) {
            try {
                if (this.f3008l == null) {
                    this.f3008l = new f(this);
                }
                fVar = this.f3008l;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final c o() {
        c cVar;
        if (this.f3010n != null) {
            return this.f3010n;
        }
        synchronized (this) {
            try {
                if (this.f3010n == null) {
                    this.f3010n = new c(this, 13);
                }
                cVar = this.f3010n;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }
}
