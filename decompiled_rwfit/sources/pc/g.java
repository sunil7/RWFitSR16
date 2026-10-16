package pc;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.o0;

/* loaded from: classes.dex */
public final class g implements o0 {

    /* renamed from: b, reason: collision with root package name */
    public static final g f17532b = new g(0);

    /* renamed from: c, reason: collision with root package name */
    public static final g f17533c = new g(1);

    /* renamed from: d, reason: collision with root package name */
    public static final g f17534d = new g(2);
    public static final g e = new g(3);

    /* renamed from: f, reason: collision with root package name */
    public static final g f17535f = new g(4);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17536a;

    public /* synthetic */ g(int i3) {
        this.f17536a = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.o0
    public final boolean a(int i3) {
        switch (this.f17536a) {
            case 0:
                if (i3 == 0 || i3 == 1 || i3 == 2) {
                }
                break;
            case 1:
                if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
                }
                break;
            case 2:
                if (com.google.android.gms.internal.mlkit_vision_common.k.a(i3) != 0) {
                }
                break;
            case 3:
                if (com.google.android.gms.internal.mlkit_vision_common.l.a(i3) != 0) {
                }
                break;
            default:
                if (i3 == 0 || i3 == 1 || i3 == 2) {
                }
                break;
        }
        return true;
    }
}
