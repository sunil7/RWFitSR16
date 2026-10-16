package x2;

import androidx.work.BackoffPolicy;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import o2.m;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: s, reason: collision with root package name */
    public static final String f19748s = m.i("WorkSpec");

    /* renamed from: a, reason: collision with root package name */
    public String f19749a;

    /* renamed from: b, reason: collision with root package name */
    public WorkInfo$State f19750b = WorkInfo$State.ENQUEUED;

    /* renamed from: c, reason: collision with root package name */
    public String f19751c;

    /* renamed from: d, reason: collision with root package name */
    public String f19752d;
    public o2.f e;

    /* renamed from: f, reason: collision with root package name */
    public o2.f f19753f;

    /* renamed from: g, reason: collision with root package name */
    public long f19754g;

    /* renamed from: h, reason: collision with root package name */
    public long f19755h;

    /* renamed from: i, reason: collision with root package name */
    public long f19756i;

    /* renamed from: j, reason: collision with root package name */
    public o2.c f19757j;

    /* renamed from: k, reason: collision with root package name */
    public int f19758k;

    /* renamed from: l, reason: collision with root package name */
    public BackoffPolicy f19759l;

    /* renamed from: m, reason: collision with root package name */
    public long f19760m;

    /* renamed from: n, reason: collision with root package name */
    public long f19761n;

    /* renamed from: o, reason: collision with root package name */
    public long f19762o;

    /* renamed from: p, reason: collision with root package name */
    public long f19763p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f19764q;
    public OutOfQuotaPolicy r;

    public h(String str, String str2) {
        o2.f fVar = o2.f.f16710c;
        this.e = fVar;
        this.f19753f = fVar;
        this.f19757j = o2.c.f16698i;
        this.f19759l = BackoffPolicy.EXPONENTIAL;
        this.f19760m = 30000L;
        this.f19763p = -1L;
        this.r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f19749a = str;
        this.f19751c = str2;
    }

    public final long a() {
        int i3;
        if (this.f19750b == WorkInfo$State.ENQUEUED && (i3 = this.f19758k) > 0) {
            return Math.min(18000000L, this.f19759l == BackoffPolicy.LINEAR ? this.f19760m * i3 : (long) Math.scalb(this.f19760m, i3 - 1)) + this.f19761n;
        }
        if (!c()) {
            long j4 = this.f19761n;
            if (j4 == 0) {
                j4 = System.currentTimeMillis();
            }
            return j4 + this.f19754g;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.f19761n;
        if (j10 == 0) {
            j10 = this.f19754g + currentTimeMillis;
        }
        long j11 = this.f19756i;
        long j12 = this.f19755h;
        if (j11 != j12) {
            return j10 + j12 + (j10 == 0 ? j11 * (-1) : 0L);
        }
        return j10 + (j10 != 0 ? j12 : 0L);
    }

    public final boolean b() {
        return !o2.c.f16698i.equals(this.f19757j);
    }

    public final boolean c() {
        return this.f19755h != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h.class == obj.getClass()) {
            h hVar = (h) obj;
            if (this.f19754g != hVar.f19754g || this.f19755h != hVar.f19755h || this.f19756i != hVar.f19756i || this.f19758k != hVar.f19758k || this.f19760m != hVar.f19760m || this.f19761n != hVar.f19761n || this.f19762o != hVar.f19762o || this.f19763p != hVar.f19763p || this.f19764q != hVar.f19764q || !this.f19749a.equals(hVar.f19749a) || this.f19750b != hVar.f19750b || !this.f19751c.equals(hVar.f19751c)) {
                return false;
            }
            String str = this.f19752d;
            if (str == null ? hVar.f19752d != null : !str.equals(hVar.f19752d)) {
                return false;
            }
            if (this.e.equals(hVar.e) && this.f19753f.equals(hVar.f19753f) && this.f19757j.equals(hVar.f19757j) && this.f19759l == hVar.f19759l && this.r == hVar.r) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int d5 = l0.d((this.f19750b.hashCode() + (this.f19749a.hashCode() * 31)) * 31, 31, this.f19751c);
        String str = this.f19752d;
        int hashCode = (this.f19753f.hashCode() + ((this.e.hashCode() + ((d5 + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31;
        long j4 = this.f19754g;
        int i3 = (hashCode + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j10 = this.f19755h;
        int i10 = (i3 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f19756i;
        int hashCode2 = (this.f19759l.hashCode() + ((((this.f19757j.hashCode() + ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31)) * 31) + this.f19758k) * 31)) * 31;
        long j12 = this.f19760m;
        int i11 = (hashCode2 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
        long j13 = this.f19761n;
        int i12 = (i11 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
        long j14 = this.f19762o;
        int i13 = (i12 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
        long j15 = this.f19763p;
        return this.r.hashCode() + ((((i13 + ((int) (j15 ^ (j15 >>> 32)))) * 31) + (this.f19764q ? 1 : 0)) * 31);
    }

    public final String toString() {
        return r5.a.f(new StringBuilder("{WorkSpec: "), this.f19749a, "}");
    }
}
