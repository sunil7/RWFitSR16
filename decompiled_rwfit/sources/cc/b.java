package cc;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* loaded from: classes.dex */
public class b implements Closeable, Flushable, AutoCloseable {

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f3441i = new String[128];

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f3442j;

    /* renamed from: a, reason: collision with root package name */
    public final Writer f3443a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f3444b;

    /* renamed from: c, reason: collision with root package name */
    public int f3445c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3446d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3447f;

    /* renamed from: g, reason: collision with root package name */
    public String f3448g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3449h;

    static {
        for (int i3 = 0; i3 <= 31; i3++) {
            f3441i[i3] = String.format("\\u%04x", Integer.valueOf(i3));
        }
        String[] strArr = f3441i;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f3442j = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        int[] iArr = new int[32];
        this.f3444b = iArr;
        this.f3445c = 0;
        if (iArr.length == 0) {
            this.f3444b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f3444b;
        int i3 = this.f3445c;
        this.f3445c = i3 + 1;
        iArr2[i3] = 6;
        this.f3446d = ":";
        this.f3449h = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f3443a = writer;
    }

    public void A(long j4) {
        W();
        b();
        this.f3443a.write(Long.toString(j4));
    }

    public void F(Number number) {
        if (number == null) {
            k();
            return;
        }
        W();
        String obj = number.toString();
        if (this.e || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            b();
            this.f3443a.append((CharSequence) obj);
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
    }

    public void I(String str) {
        if (str == null) {
            k();
            return;
        }
        W();
        b();
        y(str);
    }

    public void O(boolean z5) {
        W();
        b();
        this.f3443a.write(z5 ? "true" : "false");
    }

    public final void W() {
        if (this.f3448g != null) {
            int l3 = l();
            if (l3 == 5) {
                this.f3443a.write(44);
            } else if (l3 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            j();
            this.f3444b[this.f3445c - 1] = 4;
            y(this.f3448g);
            this.f3448g = null;
        }
    }

    public final void b() {
        int l3 = l();
        if (l3 == 1) {
            this.f3444b[this.f3445c - 1] = 2;
            j();
            return;
        }
        Writer writer = this.f3443a;
        if (l3 == 2) {
            writer.append(',');
            j();
        } else {
            if (l3 == 4) {
                writer.append((CharSequence) this.f3446d);
                this.f3444b[this.f3445c - 1] = 5;
                return;
            }
            if (l3 != 6) {
                if (l3 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.e) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.f3444b[this.f3445c - 1] = 7;
        }
    }

    public void c() {
        W();
        b();
        int i3 = this.f3445c;
        int[] iArr = this.f3444b;
        if (i3 == iArr.length) {
            this.f3444b = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.f3444b;
        int i10 = this.f3445c;
        this.f3445c = i10 + 1;
        iArr2[i10] = 1;
        this.f3443a.write(91);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3443a.close();
        int i3 = this.f3445c;
        if (i3 > 1 || (i3 == 1 && this.f3444b[i3 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f3445c = 0;
    }

    public void e() {
        W();
        b();
        int i3 = this.f3445c;
        int[] iArr = this.f3444b;
        if (i3 == iArr.length) {
            this.f3444b = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.f3444b;
        int i10 = this.f3445c;
        this.f3445c = i10 + 1;
        iArr2[i10] = 3;
        this.f3443a.write(123);
    }

    public final void f(int i3, int i10, char c9) {
        int l3 = l();
        if (l3 != i10 && l3 != i3) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f3448g != null) {
            throw new IllegalStateException("Dangling name: " + this.f3448g);
        }
        this.f3445c--;
        if (l3 == i10) {
            j();
        }
        this.f3443a.write(c9);
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.f3445c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f3443a.flush();
    }

    public void g() {
        f(1, 2, ']');
    }

    public void h() {
        f(3, 5, '}');
    }

    public void i(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f3448g != null) {
            throw new IllegalStateException();
        }
        if (this.f3445c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f3448g = str;
    }

    public final void j() {
    }

    public b k() {
        if (this.f3448g != null) {
            if (!this.f3449h) {
                this.f3448g = null;
                return this;
            }
            W();
        }
        b();
        this.f3443a.write("null");
        return this;
    }

    public final int l() {
        int i3 = this.f3445c;
        if (i3 != 0) {
            return this.f3444b[i3 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.f3447f
            if (r0 == 0) goto L7
            java.lang.String[] r0 = cc.b.f3442j
            goto L9
        L7:
            java.lang.String[] r0 = cc.b.f3441i
        L9:
            java.io.Writer r1 = r8.f3443a
            r2 = 34
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = r4
        L16:
            if (r4 >= r3) goto L41
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.8E-43)
            if (r6 >= r7) goto L25
            r6 = r0[r6]
            if (r6 != 0) goto L32
            goto L3e
        L25:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L2c
            java.lang.String r6 = "\\u2028"
            goto L32
        L2c:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L3e
            java.lang.String r6 = "\\u2029"
        L32:
            if (r5 >= r4) goto L39
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L39:
            r1.write(r6)
            int r5 = r4 + 1
        L3e:
            int r4 = r4 + 1
            goto L16
        L41:
            if (r5 >= r3) goto L47
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L47:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.b.y(java.lang.String):void");
    }
}
