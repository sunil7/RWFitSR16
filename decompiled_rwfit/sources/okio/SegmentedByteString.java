package okio;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.vd;
import com.google.android.gms.internal.mlkit_vision_common.d6;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.g;
import kotlin.jvm.internal.e;
import wh.j;
import wh.y;
import xh.b;

/* loaded from: classes2.dex */
public final class SegmentedByteString extends ByteString {

    /* renamed from: c, reason: collision with root package name */
    public final transient byte[][] f16954c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int[] f16955d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.EMPTY.getData$okio());
        e.f(segments, "segments");
        e.f(directory, "directory");
        this.f16954c = segments;
        this.f16955d = directory;
    }

    private final Object writeReplace() {
        return a();
    }

    public final ByteString a() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        e.e(asReadOnlyBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    public String base64() {
        return a().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return a().base64Url();
    }

    @Override // okio.ByteString
    public ByteString digest$okio(String algorithm) {
        e.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments$okio().length;
        int i3 = 0;
        int i10 = 0;
        while (i3 < length) {
            int i11 = getDirectory$okio()[length + i3];
            int i12 = getDirectory$okio()[i3];
            messageDigest.update(getSegments$okio()[i3], i11, i12 - i10);
            i3++;
            i10 = i12;
        }
        byte[] digest = messageDigest.digest();
        e.e(digest, "digest.digest()");
        return new ByteString(digest);
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.f16955d;
    }

    public final byte[][] getSegments$okio() {
        return this.f16954c;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i3 = 0;
        int i10 = 1;
        int i11 = 0;
        while (i3 < length) {
            int i12 = getDirectory$okio()[length + i3];
            int i13 = getDirectory$okio()[i3];
            byte[] bArr = getSegments$okio()[i3];
            int i14 = (i13 - i11) + i12;
            while (i12 < i14) {
                i10 = (i10 * 31) + bArr[i12];
                i12++;
            }
            i3++;
            i11 = i13;
        }
        setHashCode$okio(i10);
        return i10;
    }

    @Override // okio.ByteString
    public String hex() {
        return a().hex();
    }

    @Override // okio.ByteString
    public ByteString hmac$okio(String algorithm, ByteString key) {
        e.f(algorithm, "algorithm");
        e.f(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments$okio().length;
            int i3 = 0;
            int i10 = 0;
            while (i3 < length) {
                int i11 = getDirectory$okio()[length + i3];
                int i12 = getDirectory$okio()[i3];
                mac.update(getSegments$okio()[i3], i11, i12 - i10);
                i3++;
                i10 = i12;
            }
            byte[] doFinal = mac.doFinal();
            e.e(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // okio.ByteString
    public int indexOf(byte[] other, int i3) {
        e.f(other, "other");
        return a().indexOf(other, i3);
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i3) {
        d6.b(getDirectory$okio()[getSegments$okio().length - 1], i3, 1L);
        int b3 = b.b(this, i3);
        return getSegments$okio()[b3][(i3 - (b3 == 0 ? 0 : getDirectory$okio()[b3 - 1])) + getDirectory$okio()[getSegments$okio().length + b3]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] other, int i3) {
        e.f(other, "other");
        return a().lastIndexOf(other, i3);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i3, ByteString other, int i10, int i11) {
        e.f(other, "other");
        if (i3 < 0 || i3 > size() - i11) {
            return false;
        }
        int i12 = i11 + i3;
        int b3 = b.b(this, i3);
        while (i3 < i12) {
            int i13 = b3 == 0 ? 0 : getDirectory$okio()[b3 - 1];
            int i14 = getDirectory$okio()[b3] - i13;
            int i15 = getDirectory$okio()[getSegments$okio().length + b3];
            int min = Math.min(i12, i14 + i13) - i3;
            if (!other.rangeEquals(i10, getSegments$okio()[b3], (i3 - i13) + i15, min)) {
                return false;
            }
            i10 += min;
            i3 += min;
            b3++;
        }
        return true;
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        e.f(charset, "charset");
        return a().string(charset);
    }

    @Override // okio.ByteString
    public ByteString substring(int i3, int i10) {
        if (!(i3 >= 0)) {
            throw new IllegalArgumentException(l0.k(i3, "beginIndex=", " < 0").toString());
        }
        if (!(i10 <= size())) {
            StringBuilder q5 = android.support.v4.media.session.e.q(i10, "endIndex=", " > length(");
            q5.append(size());
            q5.append(')');
            throw new IllegalArgumentException(q5.toString().toString());
        }
        int i11 = i10 - i3;
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(l0.i(i10, i3, "endIndex=", " < beginIndex=").toString());
        }
        if (i3 == 0 && i10 == size()) {
            return this;
        }
        if (i3 == i10) {
            return ByteString.EMPTY;
        }
        int b3 = b.b(this, i3);
        int b10 = b.b(this, i10 - 1);
        byte[][] segments$okio = getSegments$okio();
        int i12 = b10 + 1;
        e.f(segments$okio, "<this>");
        vd.a(i12, segments$okio.length);
        Object[] copyOfRange = Arrays.copyOfRange(segments$okio, b3, i12);
        e.e(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        byte[][] bArr = (byte[][]) copyOfRange;
        int[] iArr = new int[bArr.length * 2];
        if (b3 <= b10) {
            int i13 = 0;
            int i14 = b3;
            while (true) {
                iArr[i13] = Math.min(getDirectory$okio()[i14] - i3, i11);
                int i15 = i13 + 1;
                iArr[i13 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i14];
                if (i14 == b10) {
                    break;
                }
                i14++;
                i13 = i15;
            }
        }
        int i16 = b3 != 0 ? getDirectory$okio()[b3 - 1] : 0;
        int length = bArr.length;
        iArr[length] = (i3 - i16) + iArr[length];
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i3 < length) {
            int i12 = getDirectory$okio()[length + i3];
            int i13 = getDirectory$okio()[i3];
            int i14 = i13 - i10;
            g.c(getSegments$okio()[i3], i11, i12, bArr, i12 + i14);
            i11 += i14;
            i3++;
            i10 = i13;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return a().toString();
    }

    @Override // okio.ByteString
    public void write(OutputStream out) throws IOException {
        e.f(out, "out");
        int length = getSegments$okio().length;
        int i3 = 0;
        int i10 = 0;
        while (i3 < length) {
            int i11 = getDirectory$okio()[length + i3];
            int i12 = getDirectory$okio()[i3];
            out.write(getSegments$okio()[i3], i11, i12 - i10);
            i3++;
            i10 = i12;
        }
    }

    @Override // okio.ByteString
    public void write$okio(j buffer, int i3, int i10) {
        e.f(buffer, "buffer");
        int i11 = i10 + i3;
        int b3 = b.b(this, i3);
        while (i3 < i11) {
            int i12 = b3 == 0 ? 0 : getDirectory$okio()[b3 - 1];
            int i13 = getDirectory$okio()[b3] - i12;
            int i14 = getDirectory$okio()[getSegments$okio().length + b3];
            int min = Math.min(i11, i13 + i12) - i3;
            int i15 = (i3 - i12) + i14;
            y yVar = new y(getSegments$okio()[b3], i15, i15 + min, true, false);
            y yVar2 = buffer.f19653a;
            if (yVar2 == null) {
                yVar.f19686g = yVar;
                yVar.f19685f = yVar;
                buffer.f19653a = yVar;
            } else {
                y yVar3 = yVar2.f19686g;
                e.c(yVar3);
                yVar3.b(yVar);
            }
            i3 += min;
            b3++;
        }
        buffer.f19654b += size();
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i3, byte[] other, int i10, int i11) {
        e.f(other, "other");
        if (i3 < 0 || i3 > size() - i11 || i10 < 0 || i10 > other.length - i11) {
            return false;
        }
        int i12 = i11 + i3;
        int b3 = b.b(this, i3);
        while (i3 < i12) {
            int i13 = b3 == 0 ? 0 : getDirectory$okio()[b3 - 1];
            int i14 = getDirectory$okio()[b3] - i13;
            int i15 = getDirectory$okio()[getSegments$okio().length + b3];
            int min = Math.min(i12, i14 + i13) - i3;
            if (!d6.a(getSegments$okio()[b3], (i3 - i13) + i15, i10, other, min)) {
                return false;
            }
            i10 += min;
            i3 += min;
            b3++;
        }
        return true;
    }
}
