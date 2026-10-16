package okhttp3.internal.publicsuffix;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.wd;
import com.google.android.gms.internal.mlkit_vision_barcode.yd;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import kotlin.collections.h;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import vh.a;
import wh.d;
import wh.f0;
import wh.r;
import wh.t;
import wh.x;

/* loaded from: classes2.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final Companion Companion = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {(byte) 42};
    private static final List<String> PREVAILING_RULE = wd.a("*");
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i3) {
            int i10;
            int and;
            boolean z5;
            int and2;
            int length = bArr.length;
            int i11 = 0;
            while (i11 < length) {
                int i12 = (i11 + length) / 2;
                while (i12 > -1 && bArr[i12] != ((byte) 10)) {
                    i12--;
                }
                int i13 = i12 + 1;
                int i14 = 1;
                while (true) {
                    i10 = i13 + i14;
                    if (bArr[i10] == ((byte) 10)) {
                        break;
                    }
                    i14++;
                }
                int i15 = i10 - i13;
                int i16 = i3;
                boolean z6 = false;
                int i17 = 0;
                int i18 = 0;
                while (true) {
                    if (z6) {
                        and = 46;
                        z5 = false;
                    } else {
                        boolean z8 = z6;
                        and = Util.and(bArr2[i16][i17], 255);
                        z5 = z8;
                    }
                    and2 = and - Util.and(bArr[i13 + i18], 255);
                    if (and2 != 0) {
                        break;
                    }
                    i18++;
                    i17++;
                    if (i18 == i15) {
                        break;
                    }
                    if (bArr2[i16].length != i17) {
                        z6 = z5;
                    } else {
                        if (i16 == bArr2.length - 1) {
                            break;
                        }
                        i16++;
                        z6 = true;
                        i17 = -1;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i19 = i15 - i18;
                        int length2 = bArr2[i16].length - i17;
                        int length3 = bArr2.length;
                        for (int i20 = i16 + 1; i20 < length3; i20++) {
                            length2 += bArr2[i20].length;
                        }
                        if (length2 >= i19) {
                            if (length2 <= i19) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                e.e(UTF_8, "UTF_8");
                                return new String(bArr, i13, i15, UTF_8);
                            }
                        }
                    }
                    i11 = i10 + 1;
                }
                length = i12;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public static final /* synthetic */ byte[] access$getPublicSuffixListBytes$p(PublicSuffixDatabase publicSuffixDatabase) {
        byte[] bArr = publicSuffixDatabase.publicSuffixListBytes;
        if (bArr != null) {
            return bArr;
        }
        e.m("publicSuffixListBytes");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        if (r0 <= 1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        r12 = (byte[][]) r3.clone();
        r7 = r12.length - 1;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
    
        if (r8 >= r7) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        r12[r8] = okhttp3.internal.publicsuffix.PublicSuffixDatabase.WILDCARD_LABEL;
        r9 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion;
        r10 = r11.publicSuffixListBytes;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
    
        if (r10 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
    
        r9 = r9.binarySearch(r10, r12, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0089, code lost:
    
        if (r9 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008c, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0093, code lost:
    
        if (r9 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0095, code lost:
    
        r0 = r0 - 1;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0097, code lost:
    
        if (r12 >= r0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0099, code lost:
    
        r5 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion;
        r7 = r11.publicSuffixExceptionListBytes;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009d, code lost:
    
        if (r7 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009f, code lost:
    
        r5 = r5.binarySearch(r7, r3, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a3, code lost:
    
        if (r5 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a7, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a5, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a9, code lost:
    
        kotlin.jvm.internal.e.m("publicSuffixExceptionListBytes");
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ae, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b1, code lost:
    
        if (r4 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c1, code lost:
    
        return kotlin.text.m.v("!".concat(r4), new char[]{'.'});
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c2, code lost:
    
        if (r6 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c4, code lost:
    
        if (r9 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c8, code lost:
    
        return okhttp3.internal.publicsuffix.PublicSuffixDatabase.PREVAILING_RULE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c9, code lost:
    
        if (r6 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cb, code lost:
    
        r0 = kotlin.text.m.v(r6, new char[]{'.'});
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d6, code lost:
    
        if (r9 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d8, code lost:
    
        r12 = kotlin.text.m.v(r9, new char[]{'.'});
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00eb, code lost:
    
        if (r0.size() <= r12.size()) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ef, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e1, code lost:
    
        r12 = kotlin.collections.EmptyList.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d4, code lost:
    
        r0 = kotlin.collections.EmptyList.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x008e, code lost:
    
        kotlin.jvm.internal.e.m("publicSuffixListBytes");
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0091, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0092, code lost:
    
        r9 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<java.lang.String> findMatchingRule(java.util.List<java.lang.String> r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.findMatchingRule(java.util.List):java.util.List");
    }

    private final void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        Logger logger = t.f19667a;
        x b3 = e6.b(new r(new d(1, resourceAsStream, new f0())));
        try {
            long readInt = b3.readInt();
            b3.P(readInt);
            byte[] l3 = b3.f19678a.l(readInt);
            long readInt2 = b3.readInt();
            b3.P(readInt2);
            byte[] l5 = b3.f19678a.l(readInt2);
            b3.close();
            synchronized (this) {
                this.publicSuffixListBytes = l3;
                this.publicSuffixExceptionListBytes = l5;
            }
            this.readCompleteLatch.countDown();
        } finally {
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z5 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z5 = true;
                } catch (IOException e) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e);
                    if (!z5) {
                        return;
                    }
                }
            } finally {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private final List<String> splitDomain(String str) {
        List<String> v6 = m.v(str, new char[]{'.'});
        if (!e.a((String) h.q(v6), "")) {
            return v6;
        }
        List<String> list = v6;
        int size = v6.size() - 1;
        return h.t(list, size >= 0 ? size : 0);
    }

    public final String getEffectiveTldPlusOne(String domain) {
        int size;
        int size2;
        e.f(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        e.e(unicodeDomain, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicodeDomain);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        int i3 = 0;
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            size = splitDomain.size();
            size2 = findMatchingRule.size();
        } else {
            size = splitDomain.size();
            size2 = findMatchingRule.size() + 1;
        }
        int i10 = size - size2;
        List<String> splitDomain2 = splitDomain(domain);
        e.f(splitDomain2, "<this>");
        vh.c f0Var = new com.example.test.ui.device.activity.f0(splitDomain2, 23);
        if (i10 < 0) {
            throw new IllegalArgumentException(l0.k(i10, "Requested element count ", " is less than zero.").toString());
        }
        if (i10 != 0) {
            f0Var = new a(f0Var, i10);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        for (Object obj : f0Var) {
            i3++;
            if (i3 > 1) {
                sb2.append((CharSequence) ".");
            }
            yd.a(sb2, obj, null);
        }
        sb2.append((CharSequence) "");
        String sb3 = sb2.toString();
        e.e(sb3, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb3;
    }

    public final void setListBytes(byte[] publicSuffixListBytes, byte[] publicSuffixExceptionListBytes) {
        e.f(publicSuffixListBytes, "publicSuffixListBytes");
        e.f(publicSuffixExceptionListBytes, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = publicSuffixListBytes;
        this.publicSuffixExceptionListBytes = publicSuffixExceptionListBytes;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
