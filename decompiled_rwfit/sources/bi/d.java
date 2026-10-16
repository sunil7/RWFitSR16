package bi;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final b[] f3267a;

    /* renamed from: b, reason: collision with root package name */
    public c[] f3268b = new c[16];

    public d(b[] bVarArr) {
        this.f3267a = bVarArr;
    }

    public final d a(int i3) {
        b[] bVarArr = this.f3267a;
        int length = bVarArr.length;
        if (i3 >= length) {
            throw new IndexOutOfBoundsException();
        }
        b[] bVarArr2 = new b[length - 1];
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 != i3) {
                bVarArr2[i10] = bVarArr[i11];
                i10++;
            }
        }
        return new d(bVarArr2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x000e, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00fb, code lost:
    
        r6 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final bi.b b(java.lang.Class r14) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bi.d.b(java.lang.Class):bi.b");
    }
}
