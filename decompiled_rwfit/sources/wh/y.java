package wh;

/* loaded from: classes2.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f19681a;

    /* renamed from: b, reason: collision with root package name */
    public int f19682b;

    /* renamed from: c, reason: collision with root package name */
    public int f19683c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19684d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public y f19685f;

    /* renamed from: g, reason: collision with root package name */
    public y f19686g;

    public y() {
        this.f19681a = new byte[8192];
        this.e = true;
        this.f19684d = false;
    }

    public final y a() {
        y yVar = this.f19685f;
        if (yVar == this) {
            yVar = null;
        }
        y yVar2 = this.f19686g;
        kotlin.jvm.internal.e.c(yVar2);
        yVar2.f19685f = this.f19685f;
        y yVar3 = this.f19685f;
        kotlin.jvm.internal.e.c(yVar3);
        yVar3.f19686g = this.f19686g;
        this.f19685f = null;
        this.f19686g = null;
        return yVar;
    }

    public final void b(y segment) {
        kotlin.jvm.internal.e.f(segment, "segment");
        segment.f19686g = this;
        segment.f19685f = this.f19685f;
        y yVar = this.f19685f;
        kotlin.jvm.internal.e.c(yVar);
        yVar.f19686g = segment;
        this.f19685f = segment;
    }

    public final y c() {
        this.f19684d = true;
        return new y(this.f19681a, this.f19682b, this.f19683c, true, false);
    }

    public final void d(y sink, int i3) {
        kotlin.jvm.internal.e.f(sink, "sink");
        if (!sink.e) {
            throw new IllegalStateException("only owner can write");
        }
        int i10 = sink.f19683c;
        int i11 = i10 + i3;
        byte[] bArr = sink.f19681a;
        if (i11 > 8192) {
            if (sink.f19684d) {
                throw new IllegalArgumentException();
            }
            int i12 = sink.f19682b;
            if (i11 - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            kotlin.collections.g.c(bArr, 0, i12, bArr, i10);
            sink.f19683c -= sink.f19682b;
            sink.f19682b = 0;
        }
        int i13 = sink.f19683c;
        int i14 = this.f19682b;
        kotlin.collections.g.c(this.f19681a, i13, i14, bArr, i14 + i3);
        sink.f19683c += i3;
        this.f19682b += i3;
    }

    public y(byte[] data, int i3, int i10, boolean z5, boolean z6) {
        kotlin.jvm.internal.e.f(data, "data");
        this.f19681a = data;
        this.f19682b = i3;
        this.f19683c = i10;
        this.f19684d = z5;
        this.e = z6;
    }
}
