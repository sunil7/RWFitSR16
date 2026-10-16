package g4;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f13849g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f13850h;

    /* renamed from: i, reason: collision with root package name */
    public static final File f13851i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile u f13852j;

    /* renamed from: k, reason: collision with root package name */
    public static volatile int f13853k;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f13854a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13855b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13856c;

    /* renamed from: d, reason: collision with root package name */
    public int f13857d;
    public boolean e = true;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f13858f = new AtomicBoolean(false);

    static {
        f13849g = Build.VERSION.SDK_INT < 29;
        f13850h = true;
        f13851i = new File("/proc/self/fd");
        f13853k = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x009e, code lost:
    
        r26.f13854a = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00a4, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 28) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x00a6, code lost:
    
        r26.f13855b = com.autonavi.aps.amapapi.config.Const.I_CITY_TILE_LEN;
        r26.f13856c = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00ac, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ad, code lost:
    
        r26.f13855b = com.autonavi.base.ae.gmap.glyph.FontStyle.WEIGHT_BOLD;
        r26.f13856c = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00b5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT != 27 ? false : java.util.Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(android.os.Build.MODEL)) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x009d, code lost:
    
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public u() {
        /*
            r26 = this;
            r0 = r26
            r0.<init>()
            r1 = 1
            r0.e = r1
            java.util.concurrent.atomic.AtomicBoolean r2 = new java.util.concurrent.atomic.AtomicBoolean
            r3 = 0
            r2.<init>(r3)
            r0.f13858f = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 26
            if (r2 == r4) goto L17
            goto L5a
        L17:
            java.lang.String r20 = "moto g(6) forge"
            java.lang.String r21 = "moto g(6) play"
            java.lang.String r5 = "SC-04J"
            java.lang.String r6 = "SM-N935"
            java.lang.String r7 = "SM-J720"
            java.lang.String r8 = "SM-G570F"
            java.lang.String r9 = "SM-G570M"
            java.lang.String r10 = "SM-G960"
            java.lang.String r11 = "SM-G965"
            java.lang.String r12 = "SM-G935"
            java.lang.String r13 = "SM-G930"
            java.lang.String r14 = "SM-A520"
            java.lang.String r15 = "SM-A720F"
            java.lang.String r16 = "moto e5"
            java.lang.String r17 = "moto e5 play"
            java.lang.String r18 = "moto e5 plus"
            java.lang.String r19 = "moto e5 cruise"
            java.lang.String[] r2 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}
            java.util.List r2 = java.util.Arrays.asList(r2)
            java.util.Iterator r2 = r2.iterator()
        L45:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L5a
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = android.os.Build.MODEL
            boolean r4 = r5.startsWith(r4)
            if (r4 == 0) goto L45
            goto L9d
        L5a:
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 27
            if (r2 == r4) goto L62
            r2 = r3
            goto L9a
        L62:
            java.lang.String r24 = "LM-X220QMA"
            java.lang.String r25 = "LM-X410PM"
            java.lang.String r5 = "LG-M250"
            java.lang.String r6 = "LG-M320"
            java.lang.String r7 = "LG-Q710AL"
            java.lang.String r8 = "LG-Q710PL"
            java.lang.String r9 = "LGM-K121K"
            java.lang.String r10 = "LGM-K121L"
            java.lang.String r11 = "LGM-K121S"
            java.lang.String r12 = "LGM-X320K"
            java.lang.String r13 = "LGM-X320L"
            java.lang.String r14 = "LGM-X320S"
            java.lang.String r15 = "LGM-X401L"
            java.lang.String r16 = "LGM-X401S"
            java.lang.String r17 = "LM-Q610.FG"
            java.lang.String r18 = "LM-Q610.FGN"
            java.lang.String r19 = "LM-Q617.FG"
            java.lang.String r20 = "LM-Q617.FGN"
            java.lang.String r21 = "LM-Q710.FG"
            java.lang.String r22 = "LM-Q710.FGN"
            java.lang.String r23 = "LM-X220PM"
            java.lang.String[] r2 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25}
            java.util.List r2 = java.util.Arrays.asList(r2)
            java.lang.String r4 = android.os.Build.MODEL
            boolean r2 = r2.contains(r4)
        L9a:
            if (r2 != 0) goto L9d
            goto L9e
        L9d:
            r1 = r3
        L9e:
            r0.f13854a = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto Lad
            r1 = 20000(0x4e20, float:2.8026E-41)
            r0.f13855b = r1
            r0.f13856c = r3
            return
        Lad:
            r1 = 700(0x2bc, float:9.81E-43)
            r0.f13855b = r1
            r1 = 128(0x80, float:1.8E-43)
            r0.f13856c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.u.<init>():void");
    }

    public static u a() {
        if (f13852j == null) {
            synchronized (u.class) {
                try {
                    if (f13852j == null) {
                        f13852j = new u();
                    }
                } finally {
                }
            }
        }
        return f13852j;
    }

    public final boolean b(int i3, int i10, boolean z5, boolean z6) {
        boolean z8;
        if (z5) {
            if (this.f13854a) {
                if (f13850h) {
                    if (!f13849g || this.f13858f.get()) {
                        if (!z6) {
                            int i11 = this.f13856c;
                            if (i3 < i11) {
                                if (Log.isLoggable("HardwareConfig", 2)) {
                                    Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
                                    return false;
                                }
                            } else if (i10 >= i11) {
                                synchronized (this) {
                                    try {
                                        int i12 = this.f13857d + 1;
                                        this.f13857d = i12;
                                        if (i12 >= 50) {
                                            this.f13857d = 0;
                                            int length = f13851i.list().length;
                                            long j4 = f13853k != -1 ? f13853k : this.f13855b;
                                            boolean z10 = ((long) length) < j4;
                                            this.e = z10;
                                            if (!z10 && Log.isLoggable("Downsampler", 5)) {
                                                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + j4);
                                            }
                                        }
                                        z8 = this.e;
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                if (z8) {
                                    return true;
                                }
                                if (Log.isLoggable("HardwareConfig", 2)) {
                                    Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                                }
                            } else if (Log.isLoggable("HardwareConfig", 2)) {
                                Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
                                return false;
                            }
                        } else if (Log.isLoggable("HardwareConfig", 2)) {
                            Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
                            return false;
                        }
                    } else if (Log.isLoggable("HardwareConfig", 2)) {
                        Log.v("HardwareConfig", "Hardware config disallowed by app state");
                        return false;
                    }
                } else if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed by sdk");
                    return false;
                }
            } else if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
                return false;
            }
        } else if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed by caller");
            return false;
        }
        return false;
    }
}
