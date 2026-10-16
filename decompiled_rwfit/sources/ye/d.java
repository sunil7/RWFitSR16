package ye;

import com.google.android.gms.internal.mlkit_vision_common.o6;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f20116a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20117b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20118c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f20119d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f20120f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f20121g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f20122h;

    /* JADX WARN: Removed duplicated region for block: B:102:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0093 A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #8 {all -> 0x0054, blocks: (B:73:0x001e, B:76:0x0027, B:79:0x002d, B:82:0x0033, B:85:0x0039, B:88:0x003f, B:90:0x0045, B:93:0x004b, B:97:0x008e, B:107:0x0093), top: B:72:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d() {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ye.d.<init>():void");
    }

    public static int a(int i3) {
        if (i3 > 12) {
            o6.b(d.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i3), 12, 12);
            return 12;
        }
        if (i3 >= 1) {
            return i3;
        }
        o6.b(d.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i3), 1, 1);
        return 1;
    }
}
