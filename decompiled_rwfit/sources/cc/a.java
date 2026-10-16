package cc;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import eb.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Reader;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a implements Closeable, AutoCloseable {

    /* renamed from: p, reason: collision with root package name */
    public static final char[] f3426p = ")]}'\n".toCharArray();

    /* renamed from: a, reason: collision with root package name */
    public final Reader f3427a;

    /* renamed from: i, reason: collision with root package name */
    public long f3434i;

    /* renamed from: j, reason: collision with root package name */
    public int f3435j;

    /* renamed from: k, reason: collision with root package name */
    public String f3436k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f3437l;

    /* renamed from: n, reason: collision with root package name */
    public String[] f3439n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f3440o;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3428b = false;

    /* renamed from: c, reason: collision with root package name */
    public final char[] f3429c = new char[1024];

    /* renamed from: d, reason: collision with root package name */
    public int f3430d = 0;
    public int e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f3431f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f3432g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f3433h = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f3438m = 1;

    static {
        e.f12485b = new e(4);
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f3437l = iArr;
        iArr[0] = 6;
        this.f3439n = new String[32];
        this.f3440o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f3427a = reader;
    }

    public final double A() {
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        if (i3 == 15) {
            this.f3433h = 0;
            int[] iArr = this.f3440o;
            int i10 = this.f3438m - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f3434i;
        }
        if (i3 == 16) {
            this.f3436k = new String(this.f3429c, this.f3430d, this.f3435j);
            this.f3430d += this.f3435j;
        } else if (i3 == 8 || i3 == 9) {
            this.f3436k = Y(i3 == 8 ? '\'' : '\"');
        } else if (i3 == 10) {
            this.f3436k = a0();
        } else if (i3 != 11) {
            throw new IllegalStateException("Expected a double but was " + b0() + l());
        }
        this.f3433h = 11;
        double parseDouble = Double.parseDouble(this.f3436k);
        if (!this.f3428b && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + l());
        }
        this.f3436k = null;
        this.f3433h = 0;
        int[] iArr2 = this.f3440o;
        int i11 = this.f3438m - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return parseDouble;
    }

    public final int F() {
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        if (i3 == 15) {
            long j4 = this.f3434i;
            int i10 = (int) j4;
            if (j4 != i10) {
                throw new NumberFormatException("Expected an int but was " + this.f3434i + l());
            }
            this.f3433h = 0;
            int[] iArr = this.f3440o;
            int i11 = this.f3438m - 1;
            iArr[i11] = iArr[i11] + 1;
            return i10;
        }
        if (i3 == 16) {
            this.f3436k = new String(this.f3429c, this.f3430d, this.f3435j);
            this.f3430d += this.f3435j;
        } else {
            if (i3 != 8 && i3 != 9 && i3 != 10) {
                throw new IllegalStateException("Expected an int but was " + b0() + l());
            }
            if (i3 == 10) {
                this.f3436k = a0();
            } else {
                this.f3436k = Y(i3 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.f3436k);
                this.f3433h = 0;
                int[] iArr2 = this.f3440o;
                int i12 = this.f3438m - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3433h = 11;
        double parseDouble = Double.parseDouble(this.f3436k);
        int i13 = (int) parseDouble;
        if (i13 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.f3436k + l());
        }
        this.f3436k = null;
        this.f3433h = 0;
        int[] iArr3 = this.f3440o;
        int i14 = this.f3438m - 1;
        iArr3[i14] = iArr3[i14] + 1;
        return i13;
    }

    public final long I() {
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        if (i3 == 15) {
            this.f3433h = 0;
            int[] iArr = this.f3440o;
            int i10 = this.f3438m - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f3434i;
        }
        if (i3 == 16) {
            this.f3436k = new String(this.f3429c, this.f3430d, this.f3435j);
            this.f3430d += this.f3435j;
        } else {
            if (i3 != 8 && i3 != 9 && i3 != 10) {
                throw new IllegalStateException("Expected a long but was " + b0() + l());
            }
            if (i3 == 10) {
                this.f3436k = a0();
            } else {
                this.f3436k = Y(i3 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.f3436k);
                this.f3433h = 0;
                int[] iArr2 = this.f3440o;
                int i11 = this.f3438m - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3433h = 11;
        double parseDouble = Double.parseDouble(this.f3436k);
        long j4 = (long) parseDouble;
        if (j4 != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f3436k + l());
        }
        this.f3436k = null;
        this.f3433h = 0;
        int[] iArr3 = this.f3440o;
        int i12 = this.f3438m - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return j4;
    }

    public final String O() {
        String Y;
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        if (i3 == 14) {
            Y = a0();
        } else if (i3 == 12) {
            Y = Y('\'');
        } else {
            if (i3 != 13) {
                throw new IllegalStateException("Expected a name but was " + b0() + l());
            }
            Y = Y('\"');
        }
        this.f3433h = 0;
        this.f3439n[this.f3438m - 1] = Y;
        return Y;
    }

    public final int W(boolean z5) {
        char c9;
        int i3 = this.f3430d;
        int i10 = this.e;
        while (true) {
            if (i3 == i10) {
                this.f3430d = i3;
                if (!i(1)) {
                    if (!z5) {
                        return -1;
                    }
                    throw new EOFException("End of input" + l());
                }
                i3 = this.f3430d;
                i10 = this.e;
            }
            int i11 = i3 + 1;
            char[] cArr = this.f3429c;
            c9 = cArr[i3];
            if (c9 == '\n') {
                this.f3431f++;
                this.f3432g = i11;
            } else if (c9 != ' ' && c9 != '\r' && c9 != '\t') {
                if (c9 == '/') {
                    this.f3430d = i11;
                    if (i11 == i10) {
                        this.f3430d = i3;
                        boolean i12 = i(2);
                        this.f3430d++;
                        if (!i12) {
                            break;
                        }
                    }
                    e();
                    int i13 = this.f3430d;
                    char c10 = cArr[i13];
                    if (c10 == '*') {
                        this.f3430d = i13 + 1;
                        while (true) {
                            if (this.f3430d + 2 > this.e && !i(2)) {
                                h0("Unterminated comment");
                                throw null;
                            }
                            int i14 = this.f3430d;
                            if (cArr[i14] != '\n') {
                                for (int i15 = 0; i15 < 2; i15++) {
                                    if (cArr[this.f3430d + i15] != "*/".charAt(i15)) {
                                        break;
                                    }
                                }
                                i3 = this.f3430d + 2;
                                i10 = this.e;
                                break;
                            }
                            this.f3431f++;
                            this.f3432g = i14 + 1;
                            this.f3430d++;
                        }
                    } else {
                        if (c10 != '/') {
                            break;
                        }
                        this.f3430d = i13 + 1;
                        f0();
                        i3 = this.f3430d;
                        i10 = this.e;
                    }
                } else {
                    if (c9 != '#') {
                        this.f3430d = i11;
                        return c9;
                    }
                    this.f3430d = i11;
                    e();
                    f0();
                    i3 = this.f3430d;
                    i10 = this.e;
                }
            }
            i3 = i11;
        }
        return c9;
    }

    public final void X() {
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        if (i3 != 7) {
            throw new IllegalStateException("Expected null but was " + b0() + l());
        }
        this.f3433h = 0;
        int[] iArr = this.f3440o;
        int i10 = this.f3438m - 1;
        iArr[i10] = iArr[i10] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r10.f3430d = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        r1.append(r5, r3, r2 - r3);
        r10.f3430d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String Y(char r11) {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r10.f3430d
            int r3 = r10.e
        L6:
            r4 = r3
            r3 = r2
        L8:
            char[] r5 = r10.f3429c
            r6 = 1
            r7 = 16
            if (r2 >= r4) goto L5b
            int r8 = r2 + 1
            char r2 = r5[r2]
            if (r2 != r11) goto L29
            r10.f3430d = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L21
            java.lang.String r11 = new java.lang.String
            r11.<init>(r5, r3, r8)
            return r11
        L21:
            r1.append(r5, r3, r8)
            java.lang.String r11 = r1.toString()
            return r11
        L29:
            r9 = 92
            if (r2 != r9) goto L4e
            r10.f3430d = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L3f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r7)
            r1.<init>(r4)
        L3f:
            r1.append(r5, r3, r2)
            char r2 = r10.d0()
            r1.append(r2)
            int r2 = r10.f3430d
            int r3 = r10.e
            goto L6
        L4e:
            r5 = 10
            if (r2 != r5) goto L59
            int r2 = r10.f3431f
            int r2 = r2 + r6
            r10.f3431f = r2
            r10.f3432g = r8
        L59:
            r2 = r8
            goto L8
        L5b:
            if (r1 != 0) goto L6b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r7)
            r4.<init>(r1)
            r1 = r4
        L6b:
            int r4 = r2 - r3
            r1.append(r5, r3, r4)
            r10.f3430d = r2
            boolean r2 = r10.i(r6)
            if (r2 == 0) goto L79
            goto L2
        L79:
            java.lang.String r11 = "Unterminated string"
            r10.h0(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.a.Y(char):java.lang.String");
    }

    public final String Z() {
        String str;
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        if (i3 == 10) {
            str = a0();
        } else if (i3 == 8) {
            str = Y('\'');
        } else if (i3 == 9) {
            str = Y('\"');
        } else if (i3 == 11) {
            str = this.f3436k;
            this.f3436k = null;
        } else if (i3 == 15) {
            str = Long.toString(this.f3434i);
        } else {
            if (i3 != 16) {
                throw new IllegalStateException("Expected a string but was " + b0() + l());
            }
            str = new String(this.f3429c, this.f3430d, this.f3435j);
            this.f3430d += this.f3435j;
        }
        this.f3433h = 0;
        int[] iArr = this.f3440o;
        int i10 = this.f3438m - 1;
        iArr[i10] = iArr[i10] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        e();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a0() {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r7.f3430d
            int r4 = r3 + r2
            int r5 = r7.e
            char[] r6 = r7.f3429c
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.e()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.i(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7a
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            int r3 = r7.f3430d
            r0.append(r6, r3, r2)
            int r3 = r7.f3430d
            int r3 = r3 + r2
            r7.f3430d = r3
            r2 = 1
            boolean r2 = r7.i(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.f3430d
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.f3430d
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.f3430d
            int r2 = r2 + r1
            r7.f3430d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.a.a0():java.lang.String");
    }

    public final void b() {
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        if (i3 == 3) {
            c0(1);
            this.f3440o[this.f3438m - 1] = 0;
            this.f3433h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + b0() + l());
        }
    }

    public final JsonToken b0() {
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        switch (i3) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void c() {
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        if (i3 == 1) {
            c0(3);
            this.f3433h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + b0() + l());
        }
    }

    public final void c0(int i3) {
        int i10 = this.f3438m;
        int[] iArr = this.f3437l;
        if (i10 == iArr.length) {
            int i11 = i10 * 2;
            this.f3437l = Arrays.copyOf(iArr, i11);
            this.f3440o = Arrays.copyOf(this.f3440o, i11);
            this.f3439n = (String[]) Arrays.copyOf(this.f3439n, i11);
        }
        int[] iArr2 = this.f3437l;
        int i12 = this.f3438m;
        this.f3438m = i12 + 1;
        iArr2[i12] = i3;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f3433h = 0;
        this.f3437l[0] = 8;
        this.f3438m = 1;
        this.f3427a.close();
    }

    public final char d0() {
        int i3;
        if (this.f3430d == this.e && !i(1)) {
            h0("Unterminated escape sequence");
            throw null;
        }
        int i10 = this.f3430d;
        int i11 = i10 + 1;
        this.f3430d = i11;
        char[] cArr = this.f3429c;
        char c9 = cArr[i10];
        if (c9 == '\n') {
            this.f3431f++;
            this.f3432g = i11;
            return c9;
        }
        if (c9 == '\"' || c9 == '\'' || c9 == '/' || c9 == '\\') {
            return c9;
        }
        if (c9 == 'b') {
            return '\b';
        }
        if (c9 == 'f') {
            return '\f';
        }
        if (c9 == 'n') {
            return '\n';
        }
        if (c9 == 'r') {
            return '\r';
        }
        if (c9 == 't') {
            return '\t';
        }
        if (c9 != 'u') {
            h0("Invalid escape sequence");
            throw null;
        }
        if (i10 + 5 > this.e && !i(4)) {
            h0("Unterminated escape sequence");
            throw null;
        }
        int i12 = this.f3430d;
        int i13 = i12 + 4;
        char c10 = 0;
        while (i12 < i13) {
            char c11 = cArr[i12];
            char c12 = (char) (c10 << 4);
            if (c11 >= '0' && c11 <= '9') {
                i3 = c11 - '0';
            } else if (c11 >= 'a' && c11 <= 'f') {
                i3 = c11 - 'W';
            } else {
                if (c11 < 'A' || c11 > 'F') {
                    throw new NumberFormatException("\\u".concat(new String(cArr, this.f3430d, 4)));
                }
                i3 = c11 - '7';
            }
            c10 = (char) (i3 + c12);
            i12++;
        }
        this.f3430d += 4;
        return c10;
    }

    public final void e() {
        if (this.f3428b) {
            return;
        }
        h0("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final void e0(char c9) {
        do {
            int i3 = this.f3430d;
            int i10 = this.e;
            while (i3 < i10) {
                int i11 = i3 + 1;
                char c10 = this.f3429c[i3];
                if (c10 == c9) {
                    this.f3430d = i11;
                    return;
                }
                if (c10 == '\\') {
                    this.f3430d = i11;
                    d0();
                    i3 = this.f3430d;
                    i10 = this.e;
                } else {
                    if (c10 == '\n') {
                        this.f3431f++;
                        this.f3432g = i11;
                    }
                    i3 = i11;
                }
            }
            this.f3430d = i3;
        } while (i(1));
        h0("Unterminated string");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x01b4, code lost:
    
        r22 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x020a, code lost:
    
        if (k(r15) != false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x020c, code lost:
    
        r6 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x020d, code lost:
    
        if (r4 != r6) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x020f, code lost:
    
        if (r13 == false) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0215, code lost:
    
        if (r22 != Long.MIN_VALUE) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0217, code lost:
    
        if (r14 == false) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x021e, code lost:
    
        if (r22 != 0) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0220, code lost:
    
        if (r14 != false) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0222, code lost:
    
        r10 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0224, code lost:
    
        if (r14 == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0227, code lost:
    
        r10 = -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0228, code lost:
    
        r24.f3434i = r10;
        r24.f3430d += r7;
        r15 = 15;
        r24.f3433h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0234, code lost:
    
        if (r4 == 2) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0237, code lost:
    
        if (r4 == 4) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x023a, code lost:
    
        if (r4 != 7) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x023c, code lost:
    
        r24.f3435j = r7;
        r15 = 16;
        r24.f3433h = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x016c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0269 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x026a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f() {
        /*
            Method dump skipped, instructions count: 791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.a.f():int");
    }

    public final void f0() {
        char c9;
        do {
            if (this.f3430d >= this.e && !i(1)) {
                return;
            }
            int i3 = this.f3430d;
            int i10 = i3 + 1;
            this.f3430d = i10;
            c9 = this.f3429c[i3];
            if (c9 == '\n') {
                this.f3431f++;
                this.f3432g = i10;
                return;
            }
        } while (c9 != '\r');
    }

    public final void g() {
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        if (i3 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + b0() + l());
        }
        int i10 = this.f3438m;
        this.f3438m = i10 - 1;
        int[] iArr = this.f3440o;
        int i11 = i10 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.f3433h = 0;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:65:0x009b. Please report as an issue. */
    public final void g0() {
        int i3 = 0;
        do {
            int i10 = this.f3433h;
            if (i10 == 0) {
                i10 = f();
            }
            if (i10 == 3) {
                c0(1);
            } else if (i10 == 1) {
                c0(3);
            } else {
                if (i10 == 4) {
                    this.f3438m--;
                } else if (i10 == 2) {
                    this.f3438m--;
                } else {
                    if (i10 == 14 || i10 == 10) {
                        do {
                            int i11 = 0;
                            while (true) {
                                int i12 = this.f3430d + i11;
                                if (i12 < this.e) {
                                    char c9 = this.f3429c[i12];
                                    if (c9 != '\t' && c9 != '\n' && c9 != '\f' && c9 != '\r' && c9 != ' ') {
                                        if (c9 != '#') {
                                            if (c9 != ',') {
                                                if (c9 != '/' && c9 != '=') {
                                                    if (c9 != '{' && c9 != '}' && c9 != ':') {
                                                        if (c9 != ';') {
                                                            switch (c9) {
                                                                case '[':
                                                                case ']':
                                                                    break;
                                                                case '\\':
                                                                    break;
                                                                default:
                                                                    i11++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    this.f3430d = i12;
                                }
                            }
                            e();
                            this.f3430d += i11;
                        } while (i(1));
                    } else if (i10 == 8 || i10 == 12) {
                        e0('\'');
                    } else if (i10 == 9 || i10 == 13) {
                        e0('\"');
                    } else if (i10 == 16) {
                        this.f3430d += this.f3435j;
                    }
                    this.f3433h = 0;
                }
                i3--;
                this.f3433h = 0;
            }
            i3++;
            this.f3433h = 0;
        } while (i3 != 0);
        int[] iArr = this.f3440o;
        int i13 = this.f3438m;
        int i14 = i13 - 1;
        iArr[i14] = iArr[i14] + 1;
        this.f3439n[i13 - 1] = "null";
    }

    public final void h() {
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        if (i3 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + b0() + l());
        }
        int i10 = this.f3438m;
        int i11 = i10 - 1;
        this.f3438m = i11;
        this.f3439n[i11] = null;
        int[] iArr = this.f3440o;
        int i12 = i10 - 2;
        iArr[i12] = iArr[i12] + 1;
        this.f3433h = 0;
    }

    public final void h0(String str) {
        StringBuilder t8 = l0.t(str);
        t8.append(l());
        throw new MalformedJsonException(t8.toString());
    }

    public final boolean i(int i3) {
        int i10;
        int i11;
        int i12 = this.f3432g;
        int i13 = this.f3430d;
        this.f3432g = i12 - i13;
        int i14 = this.e;
        char[] cArr = this.f3429c;
        if (i14 != i13) {
            int i15 = i14 - i13;
            this.e = i15;
            System.arraycopy(cArr, i13, cArr, 0, i15);
        } else {
            this.e = 0;
        }
        this.f3430d = 0;
        do {
            int i16 = this.e;
            int read = this.f3427a.read(cArr, i16, cArr.length - i16);
            if (read == -1) {
                return false;
            }
            i10 = this.e + read;
            this.e = i10;
            if (this.f3431f == 0 && (i11 = this.f3432g) == 0 && i10 > 0 && cArr[0] == 65279) {
                this.f3430d++;
                this.f3432g = i11 + 1;
                i3++;
            }
        } while (i10 < i3);
        return true;
    }

    public final boolean j() {
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        return (i3 == 2 || i3 == 4) ? false : true;
    }

    public final boolean k(char c9) {
        if (c9 == '\t' || c9 == '\n' || c9 == '\f' || c9 == '\r' || c9 == ' ') {
            return false;
        }
        if (c9 != '#') {
            if (c9 == ',') {
                return false;
            }
            if (c9 != '/' && c9 != '=') {
                if (c9 == '{' || c9 == '}' || c9 == ':') {
                    return false;
                }
                if (c9 != ';') {
                    switch (c9) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        e();
        return false;
    }

    public final String l() {
        StringBuilder s7 = l0.s(this.f3431f + 1, " at line ", (this.f3430d - this.f3432g) + 1, " column ", " path ");
        StringBuilder sb2 = new StringBuilder("$");
        int i3 = this.f3438m;
        for (int i10 = 0; i10 < i3; i10++) {
            int i11 = this.f3437l[i10];
            if (i11 == 1 || i11 == 2) {
                sb2.append('[');
                sb2.append(this.f3440o[i10]);
                sb2.append(']');
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                sb2.append('.');
                String str = this.f3439n[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        s7.append(sb2.toString());
        return s7.toString();
    }

    public final String toString() {
        return a.class.getSimpleName() + l();
    }

    public final boolean y() {
        int i3 = this.f3433h;
        if (i3 == 0) {
            i3 = f();
        }
        if (i3 == 5) {
            this.f3433h = 0;
            int[] iArr = this.f3440o;
            int i10 = this.f3438m - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (i3 != 6) {
            throw new IllegalStateException("Expected a boolean but was " + b0() + l());
        }
        this.f3433h = 0;
        int[] iArr2 = this.f3440o;
        int i11 = this.f3438m - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return false;
    }
}
