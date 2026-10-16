package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: i, reason: collision with root package name */
    public static final Object f2035i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static volatile k f2036j;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f2037a;

    /* renamed from: b, reason: collision with root package name */
    public final m0.c f2038b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f2039c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f2040d;
    public final f e;

    /* renamed from: f, reason: collision with root package name */
    public final j f2041f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2042g;

    /* renamed from: h, reason: collision with root package name */
    public final d f2043h;

    public k(q qVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f2037a = reentrantReadWriteLock;
        this.f2039c = 3;
        j jVar = (j) qVar.f2030b;
        this.f2041f = jVar;
        int i3 = qVar.f2029a;
        this.f2042g = i3;
        this.f2043h = (d) qVar.f2031c;
        this.f2040d = new Handler(Looper.getMainLooper());
        this.f2038b = new m0.c(0);
        f fVar = new f(this);
        this.e = fVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i3 == 0) {
            try {
                this.f2039c = 0;
            } catch (Throwable th2) {
                this.f2037a.writeLock().unlock();
                throw th2;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                jVar.a(new e(fVar));
            } catch (Throwable th3) {
                d(th3);
            }
        }
    }

    public static k a() {
        k kVar;
        synchronized (f2035i) {
            kVar = f2036j;
            pd.f("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.", kVar != null);
        }
        return kVar;
    }

    public final int b() {
        this.f2037a.readLock().lock();
        try {
            return this.f2039c;
        } finally {
            this.f2037a.readLock().unlock();
        }
    }

    public final void c() {
        pd.f("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading", this.f2042g == 1);
        if (b() == 1) {
            return;
        }
        this.f2037a.writeLock().lock();
        try {
            if (this.f2039c == 0) {
                return;
            }
            this.f2039c = 0;
            this.f2037a.writeLock().unlock();
            f fVar = this.e;
            k kVar = fVar.f2026a;
            try {
                kVar.f2041f.a(new e(fVar));
            } catch (Throwable th2) {
                kVar.d(th2);
            }
        } finally {
            this.f2037a.writeLock().unlock();
        }
    }

    public final void d(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        this.f2037a.writeLock().lock();
        try {
            this.f2039c = 2;
            arrayList.addAll(this.f2038b);
            this.f2038b.clear();
            this.f2037a.writeLock().unlock();
            this.f2040d.post(new i(arrayList, this.f2039c, th2));
        } catch (Throwable th3) {
            this.f2037a.writeLock().unlock();
            throw th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x016c, code lost:
    
        if (r4 != false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x016e, code lost:
    
        ((androidx.emoji2.text.t) r12).b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0174, code lost:
    
        return r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0162 A[Catch: all -> 0x0079, TRY_LEAVE, TryCatch #0 {all -> 0x0079, blocks: (B:116:0x005d, B:119:0x0062, B:121:0x0066, B:123:0x0073, B:29:0x0086, B:31:0x0090, B:33:0x0093, B:35:0x0097, B:37:0x00a7, B:39:0x00aa, B:43:0x00b7, B:46:0x00bf, B:51:0x00de, B:75:0x00ea, B:79:0x00f6, B:80:0x0100, B:63:0x010f, B:66:0x0116, B:54:0x011b, B:56:0x0126, B:85:0x012d, B:87:0x0131, B:89:0x0137, B:91:0x013b, B:94:0x0143, B:97:0x014f, B:98:0x0154, B:100:0x0162, B:27:0x007c), top: B:115:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097 A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:116:0x005d, B:119:0x0062, B:121:0x0066, B:123:0x0073, B:29:0x0086, B:31:0x0090, B:33:0x0093, B:35:0x0097, B:37:0x00a7, B:39:0x00aa, B:43:0x00b7, B:46:0x00bf, B:51:0x00de, B:75:0x00ea, B:79:0x00f6, B:80:0x0100, B:63:0x010f, B:66:0x0116, B:54:0x011b, B:56:0x0126, B:85:0x012d, B:87:0x0131, B:89:0x0137, B:91:0x013b, B:94:0x0143, B:97:0x014f, B:98:0x0154, B:100:0x0162, B:27:0x007c), top: B:115:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014f A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:116:0x005d, B:119:0x0062, B:121:0x0066, B:123:0x0073, B:29:0x0086, B:31:0x0090, B:33:0x0093, B:35:0x0097, B:37:0x00a7, B:39:0x00aa, B:43:0x00b7, B:46:0x00bf, B:51:0x00de, B:75:0x00ea, B:79:0x00f6, B:80:0x0100, B:63:0x010f, B:66:0x0116, B:54:0x011b, B:56:0x0126, B:85:0x012d, B:87:0x0131, B:89:0x0137, B:91:0x013b, B:94:0x0143, B:97:0x014f, B:98:0x0154, B:100:0x0162, B:27:0x007c), top: B:115:0x005d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence e(java.lang.CharSequence r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.k.e(java.lang.CharSequence, int, int):java.lang.CharSequence");
    }

    public final void f(h hVar) {
        pd.e(hVar, "initCallback cannot be null");
        this.f2037a.writeLock().lock();
        try {
            if (this.f2039c != 1 && this.f2039c != 2) {
                this.f2038b.add(hVar);
                this.f2037a.writeLock().unlock();
            }
            this.f2040d.post(new i(Arrays.asList(hVar), this.f2039c, (Throwable) null));
            this.f2037a.writeLock().unlock();
        } catch (Throwable th2) {
            this.f2037a.writeLock().unlock();
            throw th2;
        }
    }
}
