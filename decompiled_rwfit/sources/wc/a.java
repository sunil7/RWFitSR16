package wc;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f19603b;

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f19605d;

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f19602a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f19604c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final char[] e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f19603b = cArr;
        f19605d = cArr;
    }

    public static void a(int[] iArr, int i3, int i10) {
        int i11 = ((i3 << 8) + i10) - 1;
        int i12 = i11 / 1600;
        iArr[0] = i12;
        int i13 = i11 - (i12 * 1600);
        int i14 = i13 / 40;
        iArr[1] = i14;
        iArr[2] = i13 - (i14 * 40);
    }

    public static int b(int i3, int i10) {
        int i11 = i3 - (((i10 * 149) % 255) + 1);
        return i11 >= 0 ? i11 : i11 + 256;
    }
}
