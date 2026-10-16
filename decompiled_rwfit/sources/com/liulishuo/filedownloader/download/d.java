package com.liulishuo.filedownloader.download;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_common.o;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.n6;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadHttpException;
import com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import de.i;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import n.l;
import n.m0;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    /* renamed from: w, reason: collision with root package name */
    public static final ThreadPoolExecutor f11406w = new ThreadPoolExecutor(0, SubsamplingScaleImageView.TILE_SIZE_AUTO, 15, TimeUnit.SECONDS, new SynchronousQueue(), new ye.b("ConnectionBlock"));

    /* renamed from: a, reason: collision with root package name */
    public final f f11407a;

    /* renamed from: b, reason: collision with root package name */
    public final FileDownloadModel f11408b;

    /* renamed from: c, reason: collision with root package name */
    public final FileDownloadHeader f11409c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11410d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final re.a f11411f;

    /* renamed from: g, reason: collision with root package name */
    public final o4.c f11412g;

    /* renamed from: i, reason: collision with root package name */
    public int f11414i;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f11416k;

    /* renamed from: m, reason: collision with root package name */
    public e f11418m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11419n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f11420o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11421p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11422q;

    /* renamed from: t, reason: collision with root package name */
    public volatile boolean f11424t;

    /* renamed from: u, reason: collision with root package name */
    public volatile Exception f11425u;

    /* renamed from: v, reason: collision with root package name */
    public String f11426v;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11415j = false;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f11417l = new ArrayList(5);
    public final AtomicBoolean r = new AtomicBoolean(true);

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f11423s = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11413h = false;

    public d(FileDownloadModel fileDownloadModel, FileDownloadHeader fileDownloadHeader, o4.c cVar, int i3, int i10, boolean z5, boolean z6, int i11) {
        this.f11408b = fileDownloadModel;
        this.f11409c = fileDownloadHeader;
        this.f11410d = z5;
        this.e = z6;
        i iVar = c.f11405a;
        this.f11411f = iVar.e();
        iVar.h().getClass();
        this.f11416k = true;
        this.f11412g = cVar;
        this.f11414i = i11;
        this.f11407a = new f(fileDownloadModel, i11, i3, i10);
    }

    public final int a(long j4) {
        if ((!this.f11420o || this.f11408b.a() > 1) && this.f11421p && this.f11416k && !this.f11422q) {
            if (this.f11420o) {
                return this.f11408b.a();
            }
            i iVar = c.f11405a;
            this.f11408b.getClass();
            this.f11408b.getClass();
            this.f11408b.getClass();
            n9.e eVar = (n9.e) iVar.f12358c;
            if (eVar == null) {
                synchronized (iVar) {
                    try {
                        if (((n9.e) iVar.f12358c) == null) {
                            iVar.f12358c = ((eb.e) iVar.f().f16381b) == null ? new n9.e(18) : new n9.e(18);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                eVar = (n9.e) iVar.f12358c;
            }
            eVar.getClass();
            if (j4 >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                if (j4 < 5242880) {
                    return 2;
                }
                if (j4 < 52428800) {
                    return 3;
                }
                return j4 < 104857600 ? 4 : 5;
            }
        }
        return 1;
    }

    public final void b() {
        FileDownloadModel fileDownloadModel = this.f11408b;
        int h4 = fileDownloadModel.h();
        if (fileDownloadModel.s()) {
            String l3 = fileDownloadModel.l();
            String o3 = fileDownloadModel.o();
            c.f11405a.g().getClass();
            int i3 = 0;
            int a3 = o.a(o3, l3, false);
            boolean b3 = n6.b(h4, l3, this.f11410d, false);
            re.a aVar = this.f11411f;
            if (b3) {
                aVar.remove(h4);
                aVar.o(h4);
                throw new Throwable() { // from class: com.liulishuo.filedownloader.download.DownloadLaunchRunnable$DiscardSafely
                };
            }
            FileDownloadModel L = aVar.L(a3);
            if (L != null) {
                if (n6.c(h4, L, this.f11412g, false)) {
                    aVar.remove(h4);
                    aVar.o(h4);
                    throw new Throwable() { // from class: com.liulishuo.filedownloader.download.DownloadLaunchRunnable$DiscardSafely
                    };
                }
                ArrayList J = aVar.J(a3);
                aVar.remove(a3);
                aVar.o(a3);
                String l5 = fileDownloadModel.l();
                if (l5 != null) {
                    File file = new File(l5);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                if (L.m() == null ? false : ye.e.e(L, L.m())) {
                    fileDownloadModel.C(L.j());
                    fileDownloadModel.E(L.n());
                    fileDownloadModel.v(L.b());
                    fileDownloadModel.u(L.a());
                    aVar.B(fileDownloadModel);
                    int size = J.size();
                    while (i3 < size) {
                        Object obj = J.get(i3);
                        i3++;
                        ve.a aVar2 = (ve.a) obj;
                        aVar2.f19231a = h4;
                        aVar.v(aVar2);
                    }
                    throw new DownloadLaunchRunnable$RetryDirectly(this);
                }
            }
            if (n6.a(h4, fileDownloadModel.j(), fileDownloadModel.m(), l3, this.f11412g)) {
                aVar.remove(h4);
                aVar.o(h4);
                throw new Throwable() { // from class: com.liulishuo.filedownloader.download.DownloadLaunchRunnable$DiscardSafely
                };
            }
        }
    }

    public final void c() {
        boolean z5 = this.e;
        if (z5 && n6.f10047a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            int h4 = this.f11408b.h();
            Locale locale = Locale.ENGLISH;
            throw new FileDownloadGiveUpRetryException(l0.k(h4, "Task[", "] can't start the download runnable, because this task require wifi, but user application nor current process has android.permission.ACCESS_NETWORK_STATE, so we can't check whether the network type connection."));
        }
        if (z5 && ye.e.g()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    public final void d(List list, long j4) {
        int h4 = this.f11408b.h();
        String b3 = this.f11408b.b();
        String str = this.f11426v;
        if (str == null) {
            str = this.f11408b.o();
        }
        String str2 = str;
        String m10 = this.f11408b.m();
        boolean z5 = this.f11420o;
        Iterator it = list.iterator();
        long j10 = 0;
        while (it.hasNext()) {
            ve.a aVar = (ve.a) it.next();
            long j11 = aVar.e;
            long j12 = j11 == -1 ? j4 - aVar.f19234d : (j11 - aVar.f19234d) + 1;
            long j13 = aVar.f19234d;
            long j14 = aVar.f19233c;
            long j15 = (j13 - j14) + j10;
            if (j12 != 0) {
                b bVar = new b(j14, j13, j11, j12, false);
                int i3 = aVar.f19232b;
                String str3 = z5 ? b3 : null;
                FileDownloadHeader fileDownloadHeader = this.f11409c;
                boolean z6 = this.e;
                Boolean valueOf = Boolean.valueOf(z6);
                if (m10 == null) {
                    int i10 = ye.e.f20123a;
                    throw new IllegalArgumentException(String.format(Locale.ENGLISH, "%s %s %B", this, m10, valueOf));
                }
                if (str2 == null) {
                    throw new IllegalArgumentException();
                }
                a aVar2 = new a(bVar, h4, str2, str3, fileDownloadHeader);
                this.f11417l.add(new e(aVar2.f11394a, i3, aVar2, this, z6, m10));
            }
            j10 = j15;
        }
        boolean z8 = true;
        if (j10 != this.f11408b.j()) {
            o6.b(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.f11408b.j()), Long.valueOf(j10));
            this.f11408b.C(j10);
        }
        ArrayList arrayList = new ArrayList(this.f11417l.size());
        ArrayList arrayList2 = this.f11417l;
        int size = arrayList2.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList2.get(i11);
            i11++;
            e eVar = (e) obj;
            if (this.f11423s) {
                boolean z10 = z8;
                eVar.f11431f = z10;
                g gVar = eVar.e;
                if (gVar != null) {
                    gVar.f11460m = z10;
                }
                z8 = z10;
            } else {
                arrayList.add(Executors.callable(eVar));
            }
        }
        if (this.f11423s) {
            this.f11408b.D((byte) -2);
        } else {
            f11406w.invokeAll(arrayList);
        }
    }

    public final void e(long j4, String str) {
        l lVar = null;
        if (j4 != -1) {
            try {
                lVar = ye.e.a(this.f11408b.m());
                long length = new File(str).length();
                long j10 = j4 - length;
                long availableBytes = new StatFs(str).getAvailableBytes();
                if (availableBytes < j10) {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j10, length);
                }
                if (!ye.c.f20115a.f20120f) {
                    ((RandomAccessFile) lVar.f16247d).setLength(j4);
                }
            } finally {
            }
        }
        if (lVar != null) {
            lVar.g();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:110:0x0194
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x027e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.util.Map r27, com.liulishuo.filedownloader.download.a r28, n.m0 r29) {
        /*
            Method dump skipped, instructions count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.d.f(java.util.Map, com.liulishuo.filedownloader.download.a, n.m0):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(java.util.List r15) {
        /*
            r14 = this;
            com.liulishuo.filedownloader.model.FileDownloadModel r0 = r14.f11408b
            int r1 = r0.a()
            java.lang.String r2 = r0.m()
            java.lang.String r3 = r0.l()
            r4 = 0
            r5 = 1
            if (r1 <= r5) goto L14
            r6 = r5
            goto L15
        L14:
            r6 = r4
        L15:
            boolean r7 = r14.f11415j
            r8 = 0
            if (r7 == 0) goto L1d
        L1b:
            r6 = r8
            goto L67
        L1d:
            boolean r7 = r14.f11416k
            if (r6 == 0) goto L24
            if (r7 != 0) goto L24
            goto L1b
        L24:
            java.lang.String r10 = r0.m()
            if (r10 != 0) goto L2c
            r10 = r4
            goto L34
        L2c:
            java.lang.String r10 = r0.m()
            boolean r10 = ye.e.e(r0, r10)
        L34:
            if (r10 == 0) goto L1b
            if (r7 != 0) goto L42
            java.io.File r15 = new java.io.File
            r15.<init>(r2)
            long r6 = r15.length()
            goto L67
        L42:
            if (r6 == 0) goto L63
            int r6 = r15.size()
            if (r1 == r6) goto L4b
            goto L1b
        L4b:
            java.util.Iterator r15 = r15.iterator()
            r6 = r8
        L50:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L67
            java.lang.Object r1 = r15.next()
            ve.a r1 = (ve.a) r1
            long r10 = r1.f19234d
            long r12 = r1.f19233c
            long r10 = r10 - r12
            long r6 = r6 + r10
            goto L50
        L63:
            long r6 = r0.j()
        L67:
            r0.C(r6)
            int r15 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r15 <= 0) goto L6f
            r4 = r5
        L6f:
            r14.f11420o = r4
            if (r4 != 0) goto L7f
            re.a r15 = r14.f11411f
            int r0 = r0.h()
            r15.o(r0)
            ye.e.b(r3, r2)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.d.g(java.util.List):void");
    }

    public final boolean h() {
        if (this.r.get()) {
            return true;
        }
        HandlerThread handlerThread = this.f11407a.f11441i;
        return handlerThread != null && handlerThread.isAlive();
    }

    public final boolean i(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.f11419n && code == 416 && !this.f11413h) {
                FileDownloadModel fileDownloadModel = this.f11408b;
                ye.e.b(fileDownloadModel.l(), fileDownloadModel.m());
                this.f11413h = true;
                return true;
            }
        }
        return this.f11414i > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    public final void j(Exception exc) {
        this.f11424t = true;
        this.f11425u = exc;
        if (this.f11423s) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.f11417l.clone();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            e eVar = (e) obj;
            if (eVar != null) {
                eVar.f11431f = true;
                g gVar = eVar.e;
                if (gVar != null) {
                    gVar.f11460m = true;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
    
        if (r4 >= r0.e) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(long r11) {
        /*
            r10 = this;
            boolean r0 = r10.f11423s
            if (r0 == 0) goto L5
            goto L6a
        L5:
            com.liulishuo.filedownloader.download.f r0 = r10.f11407a
            java.util.concurrent.atomic.AtomicLong r1 = r0.f11445m
            r1.addAndGet(r11)
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r0.f11434a
            r1.p(r11)
            long r11 = android.os.SystemClock.elapsedRealtime()
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f11448p
            r2 = 1
            r3 = 0
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L20
            goto L3f
        L20:
            long r4 = r0.f11444l
            long r4 = r11 - r4
            long r6 = r0.f11439g
            r8 = -1
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L50
            java.util.concurrent.atomic.AtomicLong r1 = r0.f11445m
            long r6 = r1.get()
            long r8 = r0.f11439g
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L50
            int r1 = r0.e
            long r6 = (long) r1
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 < 0) goto L50
        L3f:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f11446n
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L50
            r0.f11444l = r11
            java.util.concurrent.atomic.AtomicLong r11 = r0.f11445m
            r1 = 0
            r11.set(r1)
        L50:
            android.os.Handler r11 = r0.f11440h
            if (r11 != 0) goto L58
            r0.c()
            return
        L58:
            java.util.concurrent.atomic.AtomicBoolean r11 = r0.f11446n
            boolean r11 = r11.get()
            if (r11 == 0) goto L6a
            android.os.Handler r11 = r0.f11440h
            r12 = 3
            android.os.Message r11 = r11.obtainMessage(r12)
            r0.j(r11)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.d.k(long):void");
    }

    public final void l(Exception exc) {
        if (this.f11423s) {
            return;
        }
        int i3 = this.f11414i;
        int i10 = i3 - 1;
        this.f11414i = i10;
        if (i3 < 0) {
            o6.a(6, this, null, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i10), Integer.valueOf(this.f11408b.h()));
        }
        f fVar = this.f11407a;
        int i11 = this.f11414i;
        fVar.f11445m.set(0L);
        Handler handler = fVar.f11440h;
        if (handler == null) {
            fVar.d(i11, exc);
        } else {
            fVar.j(handler.obtainMessage(5, i11, 0, exc));
        }
    }

    public final void m(int i3, long j4) {
        long j10 = j4 / i3;
        FileDownloadModel fileDownloadModel = this.f11408b;
        int h4 = fileDownloadModel.h();
        ArrayList arrayList = new ArrayList();
        long j11 = 0;
        int i10 = 0;
        while (true) {
            re.a aVar = this.f11411f;
            if (i10 >= i3) {
                fileDownloadModel.u(i3);
                aVar.N(h4, i3);
                d(arrayList, j4);
                return;
            }
            long j12 = i10 == i3 + (-1) ? -1L : (j11 + j10) - 1;
            ve.a aVar2 = new ve.a();
            aVar2.f19231a = h4;
            aVar2.f19232b = i10;
            aVar2.f19233c = j11;
            aVar2.f19234d = j11;
            aVar2.e = j12;
            arrayList.add(aVar2);
            aVar.v(aVar2);
            j11 += j10;
            i10++;
        }
    }

    public final void n(int i3, List list) {
        if (i3 <= 1 || list.size() != i3) {
            throw new IllegalArgumentException();
        }
        d(list, this.f11408b.n());
    }

    public final void o(long j4) {
        b bVar;
        if (this.f11421p) {
            bVar = new b(this.f11408b.j(), this.f11408b.j(), -1L, j4 - this.f11408b.j(), false);
        } else {
            this.f11408b.C(0L);
            bVar = new b(0L, 0L, -1L, j4, false);
        }
        int h4 = this.f11408b.h();
        String o3 = this.f11408b.o();
        String b3 = this.f11408b.b();
        FileDownloadHeader fileDownloadHeader = this.f11409c;
        boolean z5 = this.e;
        Boolean valueOf = Boolean.valueOf(z5);
        String m10 = this.f11408b.m();
        if (m10 == null) {
            int i3 = ye.e.f20123a;
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "%s %s %B", this, m10, valueOf));
        }
        if (o3 == null) {
            throw new IllegalArgumentException();
        }
        a aVar = new a(bVar, h4, o3, b3, fileDownloadHeader);
        this.f11418m = new e(aVar.f11394a, -1, aVar, this, z5, m10);
        this.f11408b.u(1);
        this.f11411f.N(this.f11408b.h(), 1);
        if (!this.f11423s) {
            this.f11418m.run();
            return;
        }
        this.f11408b.D((byte) -2);
        e eVar = this.f11418m;
        eVar.f11431f = true;
        g gVar = eVar.e;
        if (gVar != null) {
            gVar.f11460m = true;
        }
    }

    public final void p() {
        FileDownloadModel fileDownloadModel = this.f11408b;
        m0 m0Var = null;
        try {
            b bVar = this.f11415j ? new b(0L, 0L, 0L, 0L, true) : new b();
            int h4 = fileDownloadModel.h();
            String o3 = fileDownloadModel.o();
            String b3 = fileDownloadModel.b();
            FileDownloadHeader fileDownloadHeader = this.f11409c;
            if (o3 == null) {
                throw new IllegalArgumentException();
            }
            a aVar = new a(bVar, h4, o3, b3, fileDownloadHeader);
            m0 a3 = aVar.a();
            f(aVar.f11398f, aVar, a3);
            a3.z();
        } catch (Throwable th2) {
            if (0 != 0) {
                m0Var.z();
            }
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01b8 A[Catch: all -> 0x0077, TryCatch #13 {all -> 0x0077, blocks: (B:3:0x0007, B:5:0x0014, B:22:0x001d, B:23:0x007a, B:25:0x007e, B:27:0x0092, B:30:0x00ad, B:32:0x00c9, B:41:0x00f9, B:53:0x012f, B:55:0x0133, B:66:0x0158, B:68:0x015c, B:82:0x0160, B:84:0x0169, B:85:0x016d, B:87:0x0171, B:88:0x018e, B:101:0x01b2, B:103:0x01b8, B:106:0x01bd, B:97:0x018f), top: B:2:0x0007, inners: #17, #13, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01cf  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.d.run():void");
    }
}
