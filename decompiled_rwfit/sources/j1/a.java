package j1;

/* loaded from: classes.dex */
public final class a {
    public static final byte[] e = new byte[1792];

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f15164a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15165b;

    /* renamed from: c, reason: collision with root package name */
    public int f15166c;

    /* renamed from: d, reason: collision with root package name */
    public char f15167d;

    static {
        for (int i3 = 0; i3 < 1792; i3++) {
            e[i3] = Character.getDirectionality(i3);
        }
    }

    public a(CharSequence charSequence) {
        this.f15164a = charSequence;
        this.f15165b = charSequence.length();
    }

    public final byte a() {
        int i3 = this.f15166c - 1;
        CharSequence charSequence = this.f15164a;
        char charAt = charSequence.charAt(i3);
        this.f15167d = charAt;
        if (Character.isLowSurrogate(charAt)) {
            int codePointBefore = Character.codePointBefore(charSequence, this.f15166c);
            this.f15166c -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.f15166c--;
        char c9 = this.f15167d;
        return c9 < 1792 ? e[c9] : Character.getDirectionality(c9);
    }
}
