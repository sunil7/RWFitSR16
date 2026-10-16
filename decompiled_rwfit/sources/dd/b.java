package dd;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12327c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(sc.a aVar, int i3) {
        super(aVar);
        this.f12327c = i3;
    }

    @Override // a2.h
    public final String B() {
        switch (this.f12327c) {
            case 0:
                if (((sc.a) this.f36a).f18220b < 48) {
                    throw NotFoundException.getNotFoundInstance();
                }
                StringBuilder sb2 = new StringBuilder();
                D(sb2, 8);
                com.google.zxing.oned.rss.expanded.decoders.b bVar = (com.google.zxing.oned.rss.expanded.decoders.b) this.f37b;
                int c9 = com.google.zxing.oned.rss.expanded.decoders.b.c(48, 2, bVar.f11252a);
                sb2.append("(392");
                sb2.append(c9);
                sb2.append(')');
                sb2.append(bVar.b(50, null).f12331b);
                return sb2.toString();
            case 1:
                if (((sc.a) this.f36a).f18220b < 48) {
                    throw NotFoundException.getNotFoundInstance();
                }
                StringBuilder sb3 = new StringBuilder();
                D(sb3, 8);
                com.google.zxing.oned.rss.expanded.decoders.b bVar2 = (com.google.zxing.oned.rss.expanded.decoders.b) this.f37b;
                int c10 = com.google.zxing.oned.rss.expanded.decoders.b.c(48, 2, bVar2.f11252a);
                sb3.append("(393");
                sb3.append(c10);
                sb3.append(')');
                int c11 = com.google.zxing.oned.rss.expanded.decoders.b.c(50, 10, bVar2.f11252a);
                if (c11 / 100 == 0) {
                    sb3.append('0');
                }
                if (c11 / 10 == 0) {
                    sb3.append('0');
                }
                sb3.append(c11);
                sb3.append(bVar2.b(60, null).f12331b);
                return sb3.toString();
            default:
                StringBuilder t8 = l0.t("(01)");
                int length = t8.length();
                com.google.zxing.oned.rss.expanded.decoders.b bVar3 = (com.google.zxing.oned.rss.expanded.decoders.b) this.f37b;
                t8.append(com.google.zxing.oned.rss.expanded.decoders.b.c(4, 4, bVar3.f11252a));
                E(t8, 8, length);
                return bVar3.a(t8, 48);
        }
    }
}
