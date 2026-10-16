package m0;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f15893a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Object[] f15894b = new Object[0];

    public static int a(int[] iArr, int i3, int i10) {
        int i11 = i3 - 1;
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) >>> 1;
            int i14 = iArr[i13];
            if (i14 < i10) {
                i12 = i13 + 1;
            } else {
                if (i14 <= i10) {
                    return i13;
                }
                i11 = i13 - 1;
            }
        }
        return ~i12;
    }

    public static int b(long[] jArr, int i3, long j4) {
        int i10 = i3 - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            long j10 = jArr[i12];
            if (j10 < j4) {
                i11 = i12 + 1;
            } else {
                if (j10 <= j4) {
                    return i12;
                }
                i10 = i12 - 1;
            }
        }
        return ~i11;
    }
}
