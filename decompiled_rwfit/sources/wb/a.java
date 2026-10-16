package wb;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: n, reason: collision with root package name */
    public static final Charset f19589n = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f19590a;

    /* renamed from: b, reason: collision with root package name */
    public int f19591b;

    /* renamed from: c, reason: collision with root package name */
    public int f19592c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f19593d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19594f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19595g;

    /* renamed from: h, reason: collision with root package name */
    public int f19596h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f19597i;

    /* renamed from: j, reason: collision with root package name */
    public int f19598j;

    /* renamed from: k, reason: collision with root package name */
    public int f19599k;

    /* renamed from: l, reason: collision with root package name */
    public CharsetEncoder f19600l;

    /* renamed from: m, reason: collision with root package name */
    public ByteBuffer f19601m;

    public final void a(byte b3) {
        o(1, 0);
        ByteBuffer byteBuffer = this.f19590a;
        int i3 = this.f19591b - 1;
        this.f19591b = i3;
        byteBuffer.put(i3, b3);
    }

    public final void b(byte b3, int i3) {
        if (b3 != 0) {
            a(b3);
            q(i3);
        }
    }

    public final void c(int i3, int i10) {
        if (i10 != 0) {
            o(4, 0);
            ByteBuffer byteBuffer = this.f19590a;
            int i11 = this.f19591b - 4;
            this.f19591b = i11;
            byteBuffer.putInt(i11, i10);
            q(i3);
        }
    }

    public final void d(int i3, long j4) {
        if (j4 != 0) {
            o(8, 0);
            ByteBuffer byteBuffer = this.f19590a;
            int i10 = this.f19591b - 8;
            this.f19591b = i10;
            byteBuffer.putLong(i10, j4);
            q(i3);
        }
    }

    public final void e(int i3) {
        o(4, 0);
        int n4 = (n() - i3) + 4;
        ByteBuffer byteBuffer = this.f19590a;
        int i10 = this.f19591b - 4;
        this.f19591b = i10;
        byteBuffer.putInt(i10, n4);
    }

    public final void f(int i3, int i10) {
        if (i10 != 0) {
            e(i10);
            q(i3);
        }
    }

    public final void g(short s7) {
        o(2, 0);
        ByteBuffer byteBuffer = this.f19590a;
        int i3 = this.f19591b - 2;
        this.f19591b = i3;
        byteBuffer.putShort(i3, s7);
    }

    public final void h(short s7, int i3) {
        if (s7 != 0) {
            g(s7);
            q(i3);
        }
    }

    public int i(CharSequence charSequence) {
        float length = charSequence.length();
        CharsetEncoder charsetEncoder = this.f19600l;
        int maxBytesPerChar = (int) (charsetEncoder.maxBytesPerChar() * length);
        ByteBuffer byteBuffer = this.f19601m;
        if (byteBuffer == null || byteBuffer.capacity() < maxBytesPerChar) {
            this.f19601m = ByteBuffer.allocate(Math.max(128, maxBytesPerChar));
        }
        this.f19601m.clear();
        CoderResult encode = charsetEncoder.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), this.f19601m, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e) {
                throw new Error(e);
            }
        }
        this.f19601m.flip();
        ByteBuffer byteBuffer2 = this.f19601m;
        int remaining = byteBuffer2.remaining();
        a((byte) 0);
        s(1, remaining, 1);
        ByteBuffer byteBuffer3 = this.f19590a;
        int i3 = this.f19591b - remaining;
        this.f19591b = i3;
        byteBuffer3.position(i3);
        this.f19590a.put(byteBuffer2);
        return k();
    }

    public final int j() {
        int i3;
        if (this.f19593d == null || !this.f19594f) {
            throw new AssertionError("FlatBuffers: endObject called without startObject");
        }
        o(4, 0);
        ByteBuffer byteBuffer = this.f19590a;
        int i10 = this.f19591b - 4;
        this.f19591b = i10;
        byteBuffer.putInt(i10, 0);
        int n4 = n();
        for (int i11 = this.e - 1; i11 >= 0; i11--) {
            int i12 = this.f19593d[i11];
            g((short) (i12 != 0 ? n4 - i12 : 0));
        }
        g((short) (n4 - this.f19596h));
        g((short) ((this.e + 2) * 2));
        int i13 = 0;
        loop1: while (true) {
            if (i13 >= this.f19598j) {
                i3 = 0;
                break;
            }
            int capacity = this.f19590a.capacity() - this.f19597i[i13];
            int i14 = this.f19591b;
            short s7 = this.f19590a.getShort(capacity);
            if (s7 == this.f19590a.getShort(i14)) {
                for (int i15 = 2; i15 < s7; i15 += 2) {
                    if (this.f19590a.getShort(capacity + i15) != this.f19590a.getShort(i14 + i15)) {
                        break;
                    }
                }
                i3 = this.f19597i[i13];
                break loop1;
            }
            i13++;
        }
        if (i3 != 0) {
            int capacity2 = this.f19590a.capacity() - n4;
            this.f19591b = capacity2;
            this.f19590a.putInt(capacity2, i3 - n4);
        } else {
            int i16 = this.f19598j;
            int[] iArr = this.f19597i;
            if (i16 == iArr.length) {
                this.f19597i = Arrays.copyOf(iArr, i16 * 2);
            }
            int[] iArr2 = this.f19597i;
            int i17 = this.f19598j;
            this.f19598j = i17 + 1;
            iArr2[i17] = n();
            ByteBuffer byteBuffer2 = this.f19590a;
            byteBuffer2.putInt(byteBuffer2.capacity() - n4, n() - n4);
        }
        this.f19594f = false;
        return n4;
    }

    public final int k() {
        if (!this.f19594f) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.f19594f = false;
        int i3 = this.f19599k;
        ByteBuffer byteBuffer = this.f19590a;
        int i10 = this.f19591b - 4;
        this.f19591b = i10;
        byteBuffer.putInt(i10, i3);
        return n();
    }

    public final void l(int i3) {
        o(this.f19592c, 4);
        e(i3);
        this.f19590a.position(this.f19591b);
        this.f19595g = true;
    }

    public final void m(ByteBuffer byteBuffer) {
        this.f19590a = byteBuffer;
        byteBuffer.clear();
        this.f19590a.order(ByteOrder.LITTLE_ENDIAN);
        this.f19592c = 1;
        this.f19591b = this.f19590a.capacity();
        this.e = 0;
        this.f19594f = false;
        this.f19595g = false;
        this.f19596h = 0;
        this.f19598j = 0;
        this.f19599k = 0;
    }

    public final int n() {
        return this.f19590a.capacity() - this.f19591b;
    }

    public final void o(int i3, int i10) {
        if (i3 > this.f19592c) {
            this.f19592c = i3;
        }
        int i11 = ((~((this.f19590a.capacity() - this.f19591b) + i10)) + 1) & (i3 - 1);
        while (this.f19591b < i11 + i3 + i10) {
            int capacity = this.f19590a.capacity();
            ByteBuffer byteBuffer = this.f19590a;
            int capacity2 = byteBuffer.capacity();
            if (((-1073741824) & capacity2) != 0) {
                throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
            }
            int i12 = capacity2 << 1;
            byteBuffer.position(0);
            ByteBuffer allocate = ByteBuffer.allocate(i12);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.position(i12 - capacity2);
            allocate.put(byteBuffer);
            this.f19590a = allocate;
            this.f19591b = (allocate.capacity() - capacity) + this.f19591b;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            ByteBuffer byteBuffer2 = this.f19590a;
            int i14 = this.f19591b - 1;
            this.f19591b = i14;
            byteBuffer2.put(i14, (byte) 0);
        }
    }

    public final byte[] p() {
        int i3 = this.f19591b;
        int capacity = this.f19590a.capacity() - this.f19591b;
        if (!this.f19595g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
        byte[] bArr = new byte[capacity];
        this.f19590a.position(i3);
        this.f19590a.get(bArr);
        return bArr;
    }

    public final void q(int i3) {
        this.f19593d[i3] = n();
    }

    public final void r(int i3) {
        if (this.f19594f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
        int[] iArr = this.f19593d;
        if (iArr == null || iArr.length < i3) {
            this.f19593d = new int[i3];
        }
        this.e = i3;
        Arrays.fill(this.f19593d, 0, i3, 0);
        this.f19594f = true;
        this.f19596h = n();
    }

    public final void s(int i3, int i10, int i11) {
        if (this.f19594f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
        this.f19599k = i10;
        int i12 = i3 * i10;
        o(4, i12);
        o(i11, i12);
        this.f19594f = true;
    }
}
