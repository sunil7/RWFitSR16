package com.liulishuo.filedownloader.download;

import android.content.Intent;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.StatFs;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.n6;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes2.dex */
public final class f implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final FileDownloadModel f11434a;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.appcompat.widget.a f11436c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11437d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11438f;

    /* renamed from: g, reason: collision with root package name */
    public long f11439g;

    /* renamed from: h, reason: collision with root package name */
    public Handler f11440h;

    /* renamed from: i, reason: collision with root package name */
    public HandlerThread f11441i;

    /* renamed from: k, reason: collision with root package name */
    public volatile Thread f11443k;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f11442j = false;

    /* renamed from: l, reason: collision with root package name */
    public volatile long f11444l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicLong f11445m = new AtomicLong();

    /* renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f11446n = new AtomicBoolean(false);

    /* renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f11447o = new AtomicBoolean(false);

    /* renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f11448p = new AtomicBoolean(true);

    /* renamed from: b, reason: collision with root package name */
    public final re.a f11435b = c.f11405a.e();

    public f(FileDownloadModel fileDownloadModel, int i3, int i10, int i11) {
        this.f11434a = fileDownloadModel;
        this.e = i10 < 5 ? 5 : i10;
        this.f11438f = i11;
        this.f11436c = new androidx.appcompat.widget.a();
        this.f11437d = i3;
    }

    public final void a() {
        Handler handler = this.f11440h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f11441i.quit();
            this.f11443k = Thread.currentThread();
            while (this.f11442j) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.f11443k = null;
        }
    }

    public final Exception b(Exception exc) {
        long length;
        FileDownloadModel fileDownloadModel = this.f11434a;
        String m10 = fileDownloadModel.m();
        if ((fileDownloadModel.q() || ye.c.f20115a.f20120f) && (exc instanceof IOException) && new File(m10).exists()) {
            long availableBytes = new StatFs(m10).getAvailableBytes();
            if (availableBytes <= 4096) {
                File file = new File(m10);
                if (file.exists()) {
                    length = file.length();
                } else {
                    o6.a(6, this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
                    length = 0;
                }
                return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc);
            }
        }
        return exc;
    }

    public final void c() {
        FileDownloadModel fileDownloadModel = this.f11434a;
        if (fileDownloadModel.j() == fileDownloadModel.n()) {
            this.f11435b.H(fileDownloadModel.h(), fileDownloadModel.j());
        } else {
            if (this.f11447o.compareAndSet(true, false)) {
                fileDownloadModel.D((byte) 3);
            }
            if (this.f11446n.compareAndSet(true, false)) {
                i((byte) 3);
            }
        }
    }

    public final void d(int i3, Exception exc) {
        Exception b3 = b(exc);
        androidx.appcompat.widget.a aVar = this.f11436c;
        aVar.f868c = b3;
        aVar.f866a = this.f11437d - i3;
        FileDownloadModel fileDownloadModel = this.f11434a;
        fileDownloadModel.D((byte) 5);
        fileDownloadModel.w(b3.toString());
        this.f11435b.r(fileDownloadModel.h(), b3);
        i((byte) 5);
    }

    public final void e() {
        FileDownloadModel fileDownloadModel = this.f11434a;
        if (fileDownloadModel.q()) {
            fileDownloadModel.E(fileDownloadModel.j());
        } else if (fileDownloadModel.j() != fileDownloadModel.n()) {
            long j4 = fileDownloadModel.j();
            long n4 = fileDownloadModel.n();
            int i3 = ye.e.f20123a;
            Locale locale = Locale.ENGLISH;
            StringBuilder sb2 = new StringBuilder("sofar[");
            sb2.append(j4);
            sb2.append("] not equal total[");
            f(new FileDownloadGiveUpRetryException(android.support.v4.media.session.e.n(sb2, n4, "]")));
            return;
        }
        String m10 = fileDownloadModel.m();
        String l3 = fileDownloadModel.l();
        File file = new File(m10);
        try {
            File file2 = new File(l3);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    Locale locale2 = Locale.ENGLISH;
                    throw new IOException("Can't delete the old file([" + l3 + "], [" + length + "]), so can't replace it with the new downloaded one.");
                }
                o6.b(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", l3, Long.valueOf(length), Long.valueOf(file.length()));
            }
            boolean renameTo = file.renameTo(file2);
            boolean z5 = true ^ renameTo;
            if (!renameTo) {
                Locale locale3 = Locale.ENGLISH;
                throw new IOException("Can't rename the  temp downloaded file(" + m10 + ") to the target file(" + l3 + ")");
            }
            if (!renameTo && file.exists() && !file.delete()) {
                o6.b(this, "delete the temp file(%s) failed, on completed downloading.", m10);
            }
            fileDownloadModel.D((byte) -3);
            int h4 = fileDownloadModel.h();
            re.a aVar = this.f11435b;
            aVar.F(h4);
            aVar.o(fileDownloadModel.h());
            i((byte) -3);
            if (ye.c.f20115a.f20121g) {
                if (fileDownloadModel.k() != -3) {
                    throw new IllegalStateException();
                }
                Intent intent = new Intent("filedownloader.intent.action.completed");
                intent.putExtra("model", fileDownloadModel);
                n6.f10047a.sendBroadcast(intent);
            }
        } catch (Throwable th2) {
            if (1 != 0 && file.exists() && !file.delete()) {
                o6.b(this, "delete the temp file(%s) failed, on completed downloading.", m10);
            }
            throw th2;
        }
    }

    public final void f(Exception exc) {
        Exception b3 = b(exc);
        boolean z5 = b3 instanceof SQLiteFullException;
        re.a aVar = this.f11435b;
        FileDownloadModel fileDownloadModel = this.f11434a;
        if (z5) {
            int h4 = fileDownloadModel.h();
            fileDownloadModel.w(((SQLiteFullException) b3).toString());
            fileDownloadModel.D((byte) -1);
            aVar.remove(h4);
            aVar.o(h4);
        } else {
            try {
                fileDownloadModel.D((byte) -1);
                fileDownloadModel.w(exc.toString());
                aVar.m(fileDownloadModel.h(), b3, fileDownloadModel.j());
            } catch (SQLiteFullException e) {
                b3 = e;
                int h10 = fileDownloadModel.h();
                fileDownloadModel.w(b3.toString());
                fileDownloadModel.D((byte) -1);
                aVar.remove(h10);
                aVar.o(h10);
            }
        }
        this.f11436c.f868c = b3;
        i((byte) -1);
    }

    public final void g() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback");
        this.f11441i = handlerThread;
        handlerThread.start();
        this.f11440h = new Handler(this.f11441i.getLooper(), this);
    }

    public final void h() {
        FileDownloadModel fileDownloadModel = this.f11434a;
        fileDownloadModel.D((byte) -2);
        this.f11435b.O(fileDownloadModel.h(), fileDownloadModel.j());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            r0 = 1
            r4.f11442j = r0
            int r1 = r5.what
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L19
            r2 = 5
            if (r1 == r2) goto Ld
            goto L1c
        Ld:
            java.lang.Object r1 = r5.obj     // Catch: java.lang.Throwable -> L17
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch: java.lang.Throwable -> L17
            int r5 = r5.arg1     // Catch: java.lang.Throwable -> L17
            r4.d(r5, r1)     // Catch: java.lang.Throwable -> L17
            goto L1c
        L17:
            r5 = move-exception
            goto L28
        L19:
            r4.c()     // Catch: java.lang.Throwable -> L17
        L1c:
            r4.f11442j = r3
            java.lang.Thread r5 = r4.f11443k
            if (r5 == 0) goto L27
            java.lang.Thread r5 = r4.f11443k
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L27:
            return r0
        L28:
            r4.f11442j = r3
            java.lang.Thread r0 = r4.f11443k
            if (r0 == 0) goto L33
            java.lang.Thread r0 = r4.f11443k
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L33:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.f.handleMessage(android.os.Message):boolean");
    }

    public final void i(byte b3) {
        MessageSnapshot completedSnapshot;
        if (b3 == -2) {
            return;
        }
        ue.e eVar = ue.c.f19065a;
        FileDownloadModel fileDownloadModel = this.f11434a;
        int h4 = fileDownloadModel.h();
        if (b3 == -4) {
            int i3 = ye.e.f20123a;
            Locale locale = Locale.ENGLISH;
            throw new IllegalStateException(l0.j(h4, "please use #catchWarn instead "));
        }
        if (b3 != -3) {
            androidx.appcompat.widget.a aVar = this.f11436c;
            if (b3 == -1) {
                completedSnapshot = fileDownloadModel.r() ? new LargeMessageSnapshot.ErrorMessageSnapshot(h4, fileDownloadModel.j(), (Exception) aVar.f868c) : new SmallMessageSnapshot.ErrorMessageSnapshot(h4, (int) fileDownloadModel.j(), (Exception) aVar.f868c);
            } else if (b3 == 1) {
                completedSnapshot = fileDownloadModel.r() ? new LargeMessageSnapshot.PendingMessageSnapshot(h4, fileDownloadModel.j(), fileDownloadModel.n()) : new SmallMessageSnapshot.PendingMessageSnapshot(h4, (int) fileDownloadModel.j(), (int) fileDownloadModel.n());
            } else if (b3 == 2) {
                String d5 = fileDownloadModel.s() ? fileDownloadModel.d() : null;
                completedSnapshot = fileDownloadModel.r() ? new LargeMessageSnapshot.ConnectedMessageSnapshot(h4, aVar.f867b, fileDownloadModel.n(), fileDownloadModel.b(), d5) : new SmallMessageSnapshot.ConnectedMessageSnapshot(fileDownloadModel.b(), d5, h4, aVar.f867b, (int) fileDownloadModel.n());
            } else if (b3 == 3) {
                completedSnapshot = fileDownloadModel.r() ? new LargeMessageSnapshot.ProgressMessageSnapshot(h4, fileDownloadModel.j()) : new SmallMessageSnapshot.ProgressMessageSnapshot(h4, (int) fileDownloadModel.j());
            } else if (b3 == 5) {
                completedSnapshot = fileDownloadModel.r() ? new LargeMessageSnapshot.RetryMessageSnapshot(h4, fileDownloadModel.j(), (Exception) aVar.f868c, aVar.f866a) : new SmallMessageSnapshot.RetryMessageSnapshot(h4, (int) fileDownloadModel.j(), (Exception) aVar.f868c, aVar.f866a);
            } else if (b3 != 6) {
                Object[] objArr = {fileDownloadModel, Byte.valueOf(b3)};
                int i10 = ye.e.f20123a;
                String format = String.format(Locale.ENGLISH, "it can't takes a snapshot for the task(%s) when its status is %d,", objArr);
                o6.b(com.liulishuo.filedownloader.message.b.class, "it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, Byte.valueOf(b3));
                IllegalStateException illegalStateException = ((Exception) aVar.f868c) != null ? new IllegalStateException(format, (Exception) aVar.f868c) : new IllegalStateException(format);
                completedSnapshot = fileDownloadModel.r() ? new LargeMessageSnapshot.ErrorMessageSnapshot(h4, fileDownloadModel.j(), illegalStateException) : new SmallMessageSnapshot.ErrorMessageSnapshot(h4, (int) fileDownloadModel.j(), illegalStateException);
            } else {
                completedSnapshot = new MessageSnapshot.StartedMessageSnapshot(h4);
            }
        } else {
            completedSnapshot = fileDownloadModel.r() ? new LargeMessageSnapshot.CompletedSnapshot(h4, fileDownloadModel.n(), false) : new SmallMessageSnapshot.CompletedSnapshot(h4, (int) fileDownloadModel.n(), false);
        }
        eVar.a(completedSnapshot);
    }

    public final synchronized void j(Message message) {
        if (this.f11441i.isAlive()) {
            try {
                this.f11440h.sendMessage(message);
            } catch (IllegalStateException e) {
                if (this.f11441i.isAlive()) {
                    throw e;
                }
            }
        }
    }
}
