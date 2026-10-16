package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.ke;
import com.google.android.gms.internal.mlkit_vision_barcode.vb;
import com.google.android.gms.internal.mlkit_vision_common.f0;
import com.google.android.gms.internal.mlkit_vision_common.f6;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.collections.EmptyList;
import kotlin.collections.h;
import kotlin.collections.p;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
import oh.a;
import oh.l;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.ByteString;
import th.b;
import th.c;
import wh.a0;
import wh.c0;
import wh.j;
import wh.k;
import wh.m;
import wh.u;

/* loaded from: classes2.dex */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final u UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final Regex VERIFY_AS_IP_ADDRESS;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;
    public static final String userAgent = "okhttp/4.9.1";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        ByteString.Companion.getClass();
        UNICODE_BOMS = f6.b(m.b("efbbbf"), m.b("feff"), m.b("fffe"), m.b("0000ffff"), m.b("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        e.c(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String q5 = kotlin.text.m.q(OkHttpClient.class.getName(), "okhttp3.");
        if (kotlin.text.m.e(q5, "Client")) {
            q5 = q5.substring(0, q5.length() - 6);
            e.e(q5, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        okHttpName = q5;
    }

    public static final <E> void addIfAbsent(List<E> addIfAbsent, E e) {
        e.f(addIfAbsent, "$this$addIfAbsent");
        if (addIfAbsent.contains(e)) {
            return;
        }
        addIfAbsent.add(e);
    }

    public static final int and(byte b3, int i3) {
        return b3 & i3;
    }

    public static final EventListener.Factory asFactory(final EventListener asFactory) {
        e.f(asFactory, "$this$asFactory");
        return new EventListener.Factory() { // from class: okhttp3.internal.Util$asFactory$1
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call it) {
                e.f(it, "it");
                return EventListener.this;
            }
        };
    }

    public static final void assertThreadDoesntHoldLock(Object assertThreadDoesntHoldLock) {
        e.f(assertThreadDoesntHoldLock, "$this$assertThreadDoesntHoldLock");
        if (assertionsEnabled && Thread.holdsLock(assertThreadDoesntHoldLock)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(assertThreadDoesntHoldLock);
            throw new AssertionError(sb2.toString());
        }
    }

    public static final void assertThreadHoldsLock(Object assertThreadHoldsLock) {
        e.f(assertThreadHoldsLock, "$this$assertThreadHoldsLock");
        if (!assertionsEnabled || Thread.holdsLock(assertThreadHoldsLock)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder("Thread ");
        Thread currentThread = Thread.currentThread();
        e.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(assertThreadHoldsLock);
        throw new AssertionError(sb2.toString());
    }

    public static final boolean canParseAsIpAddress(String canParseAsIpAddress) {
        e.f(canParseAsIpAddress, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.matches(canParseAsIpAddress);
    }

    public static final boolean canReuseConnectionFor(HttpUrl canReuseConnectionFor, HttpUrl other) {
        e.f(canReuseConnectionFor, "$this$canReuseConnectionFor");
        e.f(other, "other");
        return e.a(canReuseConnectionFor.host(), other.host()) && canReuseConnectionFor.port() == other.port() && e.a(canReuseConnectionFor.scheme(), other.scheme());
    }

    public static final int checkDuration(String name, long j4, TimeUnit timeUnit) {
        e.f(name, "name");
        if (!(j4 >= 0)) {
            throw new IllegalStateException(name.concat(" < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j4);
        if (!(millis <= ((long) SubsamplingScaleImageView.TILE_SIZE_AUTO))) {
            throw new IllegalArgumentException(name.concat(" too large.").toString());
        }
        if (millis != 0 || j4 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(name.concat(" too small.").toString());
    }

    public static final void checkOffsetAndCount(long j4, long j10, long j11) {
        if ((j10 | j11) < 0 || j10 > j4 || j4 - j10 < j11) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeQuietly) {
        e.f(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] concat, String value) {
        e.f(concat, "$this$concat");
        e.f(value, "value");
        Object[] copyOf = Arrays.copyOf(concat, concat.length + 1);
        e.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr = (String[]) copyOf;
        strArr[strArr.length - 1] = value;
        return strArr;
    }

    public static final int delimiterOffset(String delimiterOffset, String delimiters, int i3, int i10) {
        e.f(delimiterOffset, "$this$delimiterOffset");
        e.f(delimiters, "delimiters");
        while (i3 < i10) {
            if (kotlin.text.m.d(delimiters, delimiterOffset.charAt(i3))) {
                return i3;
            }
            i3++;
        }
        return i10;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i3, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i3 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = str.length();
        }
        return delimiterOffset(str, str2, i3, i10);
    }

    public static final boolean discard(c0 discard, int i3, TimeUnit timeUnit) {
        e.f(discard, "$this$discard");
        e.f(timeUnit, "timeUnit");
        try {
            return skipAll(discard, i3, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final <T> List<T> filterList(Iterable<? extends T> filterList, l predicate) {
        e.f(filterList, "$this$filterList");
        e.f(predicate, "predicate");
        ArrayList arrayList = EmptyList.INSTANCE;
        for (T t8 : filterList) {
            if (((Boolean) predicate.invoke(t8)).booleanValue()) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                i.b(arrayList).add(t8);
            }
        }
        return arrayList;
    }

    public static final String format(String format, Object... args) {
        e.f(format, "format");
        e.f(args, "args");
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        return String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
    }

    public static final boolean hasIntersection(String[] hasIntersection, String[] strArr, Comparator<? super String> comparator) {
        e.f(hasIntersection, "$this$hasIntersection");
        e.f(comparator, "comparator");
        if (hasIntersection.length != 0 && strArr != null && strArr.length != 0) {
            for (String str : hasIntersection) {
                for (String str2 : strArr) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response headersContentLength) {
        e.f(headersContentLength, "$this$headersContentLength");
        String str = headersContentLength.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(a block) {
        e.f(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... elements) {
        e.f(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(kotlin.collections.i.d(Arrays.copyOf(objArr, objArr.length)));
        e.e(unmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(String[] indexOf, String value, Comparator<String> comparator) {
        e.f(indexOf, "$this$indexOf");
        e.f(value, "value");
        e.f(comparator, "comparator");
        int length = indexOf.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (comparator.compare(indexOf[i3], value) == 0) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String indexOfControlOrNonAscii) {
        e.f(indexOfControlOrNonAscii, "$this$indexOfControlOrNonAscii");
        int length = indexOfControlOrNonAscii.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = indexOfControlOrNonAscii.charAt(i3);
            if (e.h(charAt, 31) <= 0 || e.h(charAt, 127) >= 0) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String indexOfFirstNonAsciiWhitespace, int i3, int i10) {
        e.f(indexOfFirstNonAsciiWhitespace, "$this$indexOfFirstNonAsciiWhitespace");
        while (i3 < i10) {
            char charAt = indexOfFirstNonAsciiWhitespace.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3;
            }
            i3++;
        }
        return i10;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i3, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i3 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i3, i10);
    }

    public static final int indexOfLastNonAsciiWhitespace(String indexOfLastNonAsciiWhitespace, int i3, int i10) {
        e.f(indexOfLastNonAsciiWhitespace, "$this$indexOfLastNonAsciiWhitespace");
        int i11 = i10 - 1;
        if (i11 >= i3) {
            while (true) {
                char charAt = indexOfLastNonAsciiWhitespace.charAt(i11);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i11 + 1;
                }
                if (i11 == i3) {
                    break;
                }
                i11--;
            }
        }
        return i3;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i3, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i3 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i3, i10);
    }

    public static final int indexOfNonWhitespace(String indexOfNonWhitespace, int i3) {
        e.f(indexOfNonWhitespace, "$this$indexOfNonWhitespace");
        int length = indexOfNonWhitespace.length();
        while (i3 < length) {
            char charAt = indexOfNonWhitespace.charAt(i3);
            if (charAt != ' ' && charAt != '\t') {
                return i3;
            }
            i3++;
        }
        return indexOfNonWhitespace.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i3 = 0;
        }
        return indexOfNonWhitespace(str, i3);
    }

    public static final String[] intersect(String[] intersect, String[] other, Comparator<? super String> comparator) {
        e.f(intersect, "$this$intersect");
        e.f(other, "other");
        e.f(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            int length = other.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (comparator.compare(str, other[i3]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i3++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean isCivilized(FileSystem isCivilized, File file) {
        e.f(isCivilized, "$this$isCivilized");
        e.f(file, "file");
        a0 sink = isCivilized.sink(file);
        try {
            isCivilized.delete(file);
            ke.a(sink, null);
            return true;
        } catch (IOException unused) {
            ke.a(sink, null);
            isCivilized.delete(file);
            return false;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                ke.a(sink, th2);
                throw th3;
            }
        }
    }

    public static final boolean isHealthy(Socket isHealthy, wh.l source) {
        e.f(isHealthy, "$this$isHealthy");
        e.f(source, "source");
        try {
            int soTimeout = isHealthy.getSoTimeout();
            try {
                isHealthy.setSoTimeout(1);
                return !source.D();
            } finally {
                isHealthy.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final void notify(Object notify) {
        e.f(notify, "$this$notify");
        notify.notify();
    }

    public static final void notifyAll(Object notifyAll) {
        e.f(notifyAll, "$this$notifyAll");
        notifyAll.notifyAll();
    }

    public static final int parseHexDigit(char c9) {
        if ('0' <= c9 && '9' >= c9) {
            return c9 - '0';
        }
        if ('a' <= c9 && 'f' >= c9) {
            return c9 - 'W';
        }
        if ('A' <= c9 && 'F' >= c9) {
            return c9 - '7';
        }
        return -1;
    }

    public static final String peerName(Socket peerName) {
        e.f(peerName, "$this$peerName");
        SocketAddress remoteSocketAddress = peerName.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        e.e(hostName, "address.hostName");
        return hostName;
    }

    public static final Charset readBomAsCharset(wh.l readBomAsCharset, Charset charset) throws IOException {
        e.f(readBomAsCharset, "$this$readBomAsCharset");
        e.f(charset, "default");
        int L = readBomAsCharset.L(UNICODE_BOMS);
        if (L == -1) {
            return charset;
        }
        if (L == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            e.e(UTF_8, "UTF_8");
            return UTF_8;
        }
        if (L == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            e.e(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        }
        if (L == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            e.e(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        }
        if (L == 3) {
            Charset charset2 = kotlin.text.a.f15656a;
            Charset charset3 = kotlin.text.a.f15658c;
            if (charset3 != null) {
                return charset3;
            }
            Charset forName = Charset.forName("UTF-32BE");
            e.e(forName, "forName(\"UTF-32BE\")");
            kotlin.text.a.f15658c = forName;
            return forName;
        }
        if (L != 4) {
            throw new AssertionError();
        }
        Charset charset4 = kotlin.text.a.f15656a;
        Charset charset5 = kotlin.text.a.f15657b;
        if (charset5 != null) {
            return charset5;
        }
        Charset forName2 = Charset.forName("UTF-32LE");
        e.e(forName2, "forName(\"UTF-32LE\")");
        kotlin.text.a.f15657b = forName2;
        return forName2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> T readFieldOrNull(java.lang.Object r4, java.lang.Class<T> r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "instance"
            kotlin.jvm.internal.e.f(r4, r0)
            java.lang.String r0 = "fieldType"
            kotlin.jvm.internal.e.f(r5, r0)
            java.lang.String r0 = "fieldName"
            kotlin.jvm.internal.e.f(r6, r0)
            java.lang.Class r0 = r4.getClass()
        L13:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            boolean r2 = r0.equals(r1)
            r3 = 0
            if (r2 != 0) goto L43
            java.lang.reflect.Field r1 = r0.getDeclaredField(r6)     // Catch: java.lang.NoSuchFieldException -> L39
            java.lang.String r2 = "field"
            kotlin.jvm.internal.e.e(r1, r2)     // Catch: java.lang.NoSuchFieldException -> L39
            r2 = 1
            r1.setAccessible(r2)     // Catch: java.lang.NoSuchFieldException -> L39
            java.lang.Object r1 = r1.get(r4)     // Catch: java.lang.NoSuchFieldException -> L39
            boolean r2 = r5.isInstance(r1)     // Catch: java.lang.NoSuchFieldException -> L39
            if (r2 != 0) goto L34
            goto L38
        L34:
            java.lang.Object r3 = r5.cast(r1)     // Catch: java.lang.NoSuchFieldException -> L39
        L38:
            return r3
        L39:
            java.lang.Class r0 = r0.getSuperclass()
            java.lang.String r1 = "c.superclass"
            kotlin.jvm.internal.e.e(r0, r1)
            goto L13
        L43:
            java.lang.String r0 = "delegate"
            boolean r2 = r6.equals(r0)
            if (r2 != 0) goto L56
            java.lang.Object r4 = readFieldOrNull(r4, r1, r0)
            if (r4 == 0) goto L56
            java.lang.Object r4 = readFieldOrNull(r4, r5, r6)
            return r4
        L56:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.readFieldOrNull(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }

    public static final int readMedium(wh.l readMedium) throws IOException {
        e.f(readMedium, "$this$readMedium");
        return and(readMedium.readByte(), 255) | (and(readMedium.readByte(), 255) << 16) | (and(readMedium.readByte(), 255) << 8);
    }

    public static final boolean skipAll(c0 skipAll, int i3, TimeUnit timeUnit) throws IOException {
        e.f(skipAll, "$this$skipAll");
        e.f(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = skipAll.timeout().hasDeadline() ? skipAll.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        skipAll.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i3)) + nanoTime);
        try {
            j jVar = new j();
            while (skipAll.read(jVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                jVar.b();
            }
            if (deadlineNanoTime == Format.OFFSET_SAMPLE_RELATIVE) {
                skipAll.timeout().clearDeadline();
                return true;
            }
            skipAll.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == Format.OFFSET_SAMPLE_RELATIVE) {
                skipAll.timeout().clearDeadline();
                return false;
            }
            skipAll.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return false;
        } catch (Throwable th2) {
            if (deadlineNanoTime == Format.OFFSET_SAMPLE_RELATIVE) {
                skipAll.timeout().clearDeadline();
            } else {
                skipAll.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th2;
        }
    }

    public static final ThreadFactory threadFactory(final String name, final boolean z5) {
        e.f(name, "name");
        return new ThreadFactory() { // from class: okhttp3.internal.Util$threadFactory$1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, name);
                thread.setDaemon(z5);
                return thread;
            }
        };
    }

    public static final void threadName(String name, a block) {
        e.f(name, "name");
        e.f(block, "block");
        Thread currentThread = Thread.currentThread();
        e.e(currentThread, "currentThread");
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            currentThread.setName(name2);
        }
    }

    public static final List<Header> toHeaderList(Headers toHeaderList) {
        e.f(toHeaderList, "$this$toHeaderList");
        c b3 = f0.b(0, toHeaderList.size());
        ArrayList arrayList = new ArrayList(kotlin.collections.j.g(b3));
        Iterator it = b3.iterator();
        while (((b) it).f18638c) {
            int a3 = ((b) it).a();
            arrayList.add(new Header(toHeaderList.name(a3), toHeaderList.value(a3)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> toHeaders) {
        e.f(toHeaders, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : toHeaders) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    public static final String toHexString(long j4) {
        String hexString = Long.toHexString(j4);
        e.e(hexString, "java.lang.Long.toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl toHostHeader, boolean z5) {
        String host;
        e.f(toHostHeader, "$this$toHostHeader");
        if (kotlin.text.m.c(toHostHeader.host(), ":", false)) {
            host = "[" + toHostHeader.host() + ']';
        } else {
            host = toHostHeader.host();
        }
        if (!z5 && toHostHeader.port() == HttpUrl.Companion.defaultPort(toHostHeader.scheme())) {
            return host;
        }
        return host + ':' + toHostHeader.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z5 = false;
        }
        return toHostHeader(httpUrl, z5);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> toImmutableList) {
        e.f(toImmutableList, "$this$toImmutableList");
        List<T> unmodifiableList = Collections.unmodifiableList(h.w(toImmutableList));
        e.e(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> toImmutableMap) {
        e.f(toImmutableMap, "$this$toImmutableMap");
        if (toImmutableMap.isEmpty()) {
            return p.a();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
        e.e(unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(String toLongOrDefault, long j4) {
        e.f(toLongOrDefault, "$this$toLongOrDefault");
        try {
            return Long.parseLong(toLongOrDefault);
        } catch (NumberFormatException unused) {
            return j4;
        }
    }

    public static final int toNonNegativeInt(String str, int i3) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > SubsamplingScaleImageView.TILE_SIZE_AUTO) {
                    return SubsamplingScaleImageView.TILE_SIZE_AUTO;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i3;
    }

    public static final String trimSubstring(String trimSubstring, int i3, int i10) {
        e.f(trimSubstring, "$this$trimSubstring");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(trimSubstring, i3, i10);
        String substring = trimSubstring.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(trimSubstring, indexOfFirstNonAsciiWhitespace, i10));
        e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i3, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i3 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        return trimSubstring(str, i3, i10);
    }

    public static final void wait(Object wait) {
        e.f(wait, "$this$wait");
        wait.wait();
    }

    public static final Throwable withSuppressed(Exception withSuppressed, List<? extends Exception> suppressed) {
        e.f(withSuppressed, "$this$withSuppressed");
        e.f(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            vb.a(withSuppressed, it.next());
        }
        return withSuppressed;
    }

    public static final void writeMedium(k writeMedium, int i3) throws IOException {
        e.f(writeMedium, "$this$writeMedium");
        writeMedium.E((i3 >>> 16) & 255);
        writeMedium.E((i3 >>> 8) & 255);
        writeMedium.E(i3 & 255);
    }

    public static final int and(short s7, int i3) {
        return s7 & i3;
    }

    public static final int delimiterOffset(String delimiterOffset, char c9, int i3, int i10) {
        e.f(delimiterOffset, "$this$delimiterOffset");
        while (i3 < i10) {
            if (delimiterOffset.charAt(i3) == c9) {
                return i3;
            }
            i3++;
        }
        return i10;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c9, int i3, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i3 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = str.length();
        }
        return delimiterOffset(str, c9, i3, i10);
    }

    public static final String toHexString(int i3) {
        String hexString = Integer.toHexString(i3);
        e.e(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    public static final long and(int i3, long j4) {
        return i3 & j4;
    }

    public static final void closeQuietly(Socket closeQuietly) {
        e.f(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e10) {
            if (!e.a(e10.getMessage(), "bio == null")) {
                throw e10;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket closeQuietly) {
        e.f(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(j skipAll, byte b3) {
        e.f(skipAll, "$this$skipAll");
        int i3 = 0;
        while (!skipAll.D() && skipAll.g(0L) == b3) {
            i3++;
            skipAll.readByte();
        }
        return i3;
    }
}
