package d2;

/* loaded from: classes.dex */
public final class c implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final int f12207a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12208b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12209c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12210d;

    public c(int i3, int i10, String str, String str2) {
        this.f12207a = i3;
        this.f12208b = i10;
        this.f12209c = str;
        this.f12210d = str2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        c cVar = (c) obj;
        int i3 = this.f12207a - cVar.f12207a;
        return i3 == 0 ? this.f12208b - cVar.f12208b : i3;
    }
}
