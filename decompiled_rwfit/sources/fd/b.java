package fd;

import com.google.zxing.NotFoundException;
import com.google.zxing.h;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final sc.b f13560a;

    /* renamed from: b, reason: collision with root package name */
    public final h f13561b;

    /* renamed from: c, reason: collision with root package name */
    public final h f13562c;

    /* renamed from: d, reason: collision with root package name */
    public final h f13563d;
    public final h e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13564f;

    /* renamed from: g, reason: collision with root package name */
    public final int f13565g;

    /* renamed from: h, reason: collision with root package name */
    public final int f13566h;

    /* renamed from: i, reason: collision with root package name */
    public final int f13567i;

    public b(sc.b bVar, h hVar, h hVar2, h hVar3, h hVar4) {
        boolean z5 = hVar == null || hVar2 == null;
        boolean z6 = hVar3 == null || hVar4 == null;
        if (z5 && z6) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (z5) {
            hVar = new h(0.0f, hVar3.f11248b);
            hVar2 = new h(0.0f, hVar4.f11248b);
        } else if (z6) {
            int i3 = bVar.f18221a;
            hVar3 = new h(i3 - 1, hVar.f11248b);
            hVar4 = new h(i3 - 1, hVar2.f11248b);
        }
        this.f13560a = bVar;
        this.f13561b = hVar;
        this.f13562c = hVar2;
        this.f13563d = hVar3;
        this.e = hVar4;
        this.f13564f = (int) Math.min(hVar.f11247a, hVar2.f11247a);
        this.f13565g = (int) Math.max(hVar3.f11247a, hVar4.f11247a);
        this.f13566h = (int) Math.min(hVar.f11248b, hVar3.f11248b);
        this.f13567i = (int) Math.max(hVar2.f11248b, hVar4.f11248b);
    }

    public b(b bVar) {
        this.f13560a = bVar.f13560a;
        this.f13561b = bVar.f13561b;
        this.f13562c = bVar.f13562c;
        this.f13563d = bVar.f13563d;
        this.e = bVar.e;
        this.f13564f = bVar.f13564f;
        this.f13565g = bVar.f13565g;
        this.f13566h = bVar.f13566h;
        this.f13567i = bVar.f13567i;
    }
}
