package okio;

import com.autonavi.base.amap.mapcore.AeUtil;
import com.google.android.gms.internal.mlkit_vision_common.d6;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.g;
import kotlin.jvm.internal.e;
import wh.a;
import wh.j;
import wh.m;
import xh.b;

/* loaded from: classes2.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final m Companion = new m();
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    public transient int f16952a;

    /* renamed from: b, reason: collision with root package name */
    public transient String f16953b;
    private final byte[] data;

    public ByteString(byte[] data) {
        e.f(data, "data");
        this.data = data;
    }

    public static final ByteString decodeBase64(String str) {
        Companion.getClass();
        return m.a(str);
    }

    public static final ByteString decodeHex(String str) {
        Companion.getClass();
        return m.b(str);
    }

    public static final ByteString encodeString(String encode, Charset charset) {
        Companion.getClass();
        e.f(encode, "$this$encode");
        e.f(charset, "charset");
        byte[] bytes = encode.getBytes(charset);
        e.e(bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteString(bytes);
    }

    public static final ByteString encodeUtf8(String str) {
        Companion.getClass();
        return m.c(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i3, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i10 & 2) != 0) {
            i3 = 0;
        }
        return byteString.indexOf(byteString2, i3);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i3, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i10 & 2) != 0) {
            i3 = byteString.size();
        }
        return byteString.lastIndexOf(byteString2, i3);
    }

    public static final ByteString of(ByteBuffer toByteString) {
        Companion.getClass();
        e.f(toByteString, "$this$toByteString");
        byte[] bArr = new byte[toByteString.remaining()];
        toByteString.get(bArr);
        return new ByteString(bArr);
    }

    public static final ByteString read(InputStream inputStream, int i3) throws IOException {
        Companion.getClass();
        return m.e(inputStream, i3);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        int readInt = objectInputStream.readInt();
        Companion.getClass();
        ByteString e = m.e(objectInputStream, readInt);
        Field field = ByteString.class.getDeclaredField(AeUtil.ROOT_DATA_PATH_OLD_NAME);
        e.e(field, "field");
        field.setAccessible(true);
        field.set(this, e.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i3, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i11 & 1) != 0) {
            i3 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = byteString.size();
        }
        return byteString.substring(i3, i10);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m219deprecated_getByte(int i3) {
        return getByte(i3);
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m220deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        e.e(asReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    public String base64() {
        return a.a(getData$okio(), a.f19635a);
    }

    public String base64Url() {
        return a.a(getData$okio(), a.f19636b);
    }

    public ByteString digest$okio(String algorithm) {
        e.f(algorithm, "algorithm");
        byte[] digest = MessageDigest.getInstance(algorithm).digest(this.data);
        e.e(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(digest);
    }

    public final boolean endsWith(ByteString suffix) {
        e.f(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int i3) {
        return internalGet$okio(i3);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.f16952a;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.f16953b;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode);
        return hashCode;
    }

    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i3 = 0;
        for (byte b3 : getData$okio()) {
            int i10 = i3 + 1;
            char[] cArr2 = b.f19828a;
            cArr[i3] = cArr2[(b3 >> 4) & 15];
            i3 += 2;
            cArr[i10] = cArr2[b3 & 15];
        }
        return new String(cArr);
    }

    public ByteString hmac$okio(String algorithm, ByteString key) {
        e.f(algorithm, "algorithm");
        e.f(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] doFinal = mac.doFinal(this.data);
            e.e(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ByteString hmacSha1(ByteString key) {
        e.f(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    public ByteString hmacSha256(ByteString key) {
        e.f(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    public ByteString hmacSha512(ByteString key) {
        e.f(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i3) {
        return getData$okio()[i3];
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i3, ByteString other, int i10, int i11) {
        e.f(other, "other");
        return other.rangeEquals(i10, getData$okio(), i3, i11);
    }

    public final void setHashCode$okio(int i3) {
        this.f16952a = i3;
    }

    public final void setUtf8$okio(String str) {
        this.f16953b = str;
    }

    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString prefix) {
        e.f(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    public String string(Charset charset) {
        e.f(charset, "charset");
        return new String(this.data, charset);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public ByteString toAsciiLowercase() {
        byte b3;
        for (int i3 = 0; i3 < getData$okio().length; i3++) {
            byte b10 = getData$okio()[i3];
            byte b11 = (byte) 65;
            if (b10 >= b11 && b10 <= (b3 = (byte) 90)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                e.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i3] = (byte) (b10 + 32);
                for (int i10 = i3 + 1; i10 < copyOf.length; i10++) {
                    byte b12 = copyOf[i10];
                    if (b12 >= b11 && b12 <= b3) {
                        copyOf[i10] = (byte) (b12 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        byte b3;
        for (int i3 = 0; i3 < getData$okio().length; i3++) {
            byte b10 = getData$okio()[i3];
            byte b11 = (byte) 97;
            if (b10 >= b11 && b10 <= (b3 = (byte) 122)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                e.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i3] = (byte) (b10 - 32);
                for (int i10 = i3 + 1; i10 < copyOf.length; i10++) {
                    byte b12 = copyOf[i10];
                    if (b12 >= b11 && b12 <= b3) {
                        copyOf[i10] = (byte) (b12 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        e.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x00ec, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0124, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0128, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00cc, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x016f, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x016a, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0160, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x019d, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x01a0, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x01a3, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0134, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x01a6, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0090, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ba, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x007f, code lost:
    
        if (r5 == 64) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00f5, code lost:
    
        if (r5 == 64) goto L181;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.toString():java.lang.String");
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        byte[] toUtf8String = internalArray$okio();
        e.f(toUtf8String, "$this$toUtf8String");
        String str = new String(toUtf8String, kotlin.text.a.f15656a);
        setUtf8$okio(str);
        return str;
    }

    public void write(OutputStream out) throws IOException {
        e.f(out, "out");
        out.write(this.data);
    }

    public void write$okio(j buffer, int i3, int i10) {
        e.f(buffer, "buffer");
        buffer.Y(getData$okio(), i3, i10);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i3, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i10 & 2) != 0) {
            i3 = 0;
        }
        return byteString.indexOf(bArr, i3);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i3, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i10 & 2) != 0) {
            i3 = byteString.size();
        }
        return byteString.lastIndexOf(bArr, i3);
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString other) {
        e.f(other, "other");
        int size = size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i3 = 0; i3 < min; i3++) {
            int i10 = getByte(i3) & 255;
            int i11 = other.getByte(i3) & 255;
            if (i10 != i11) {
                return i10 < i11 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public final boolean endsWith(byte[] suffix) {
        e.f(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public boolean rangeEquals(int i3, byte[] other, int i10, int i11) {
        e.f(other, "other");
        return i3 >= 0 && i3 <= getData$okio().length - i11 && i10 >= 0 && i10 <= other.length - i11 && d6.a(getData$okio(), i3, i10, other, i11);
    }

    public final boolean startsWith(byte[] prefix) {
        e.f(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    public final ByteString substring(int i3) {
        return substring$default(this, i3, 0, 2, null);
    }

    public final int indexOf(ByteString other, int i3) {
        e.f(other, "other");
        return indexOf(other.internalArray$okio(), i3);
    }

    public final int lastIndexOf(ByteString other, int i3) {
        e.f(other, "other");
        return lastIndexOf(other.internalArray$okio(), i3);
    }

    public ByteString substring(int i3, int i10) {
        if (i3 >= 0) {
            if (!(i10 <= getData$okio().length)) {
                throw new IllegalArgumentException(android.support.v4.media.session.e.m(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
            }
            if (i10 - i3 >= 0) {
                return (i3 == 0 && i10 == getData$okio().length) ? this : new ByteString(g.d(i3, i10, getData$okio()));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public int indexOf(byte[] other, int i3) {
        e.f(other, "other");
        int length = getData$okio().length - other.length;
        int max = Math.max(i3, 0);
        if (max > length) {
            return -1;
        }
        while (!d6.a(getData$okio(), max, 0, other, other.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    public int lastIndexOf(byte[] other, int i3) {
        e.f(other, "other");
        for (int min = Math.min(i3, getData$okio().length - other.length); min >= 0; min--) {
            if (d6.a(getData$okio(), min, 0, other, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final ByteString of(byte... data) {
        Companion.getClass();
        e.f(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        e.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final ByteString of(byte[] toByteString, int i3, int i10) {
        Companion.getClass();
        e.f(toByteString, "$this$toByteString");
        d6.b(toByteString.length, i3, i10);
        return new ByteString(g.d(i3, i10 + i3, toByteString));
    }
}
