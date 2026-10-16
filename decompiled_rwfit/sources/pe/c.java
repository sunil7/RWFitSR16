package pe;

import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.core.impl.i1;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.n6;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final i f17555a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f17556b;

    /* renamed from: c, reason: collision with root package name */
    public final b f17557c;

    /* renamed from: d, reason: collision with root package name */
    public volatile byte f17558d = 0;
    public final a e = new a();

    /* renamed from: f, reason: collision with root package name */
    public long f17559f;

    /* renamed from: g, reason: collision with root package name */
    public long f17560g;

    public c(b bVar, Object obj) {
        this.f17556b = obj;
        this.f17557c = bVar;
        bVar.getClass();
        i iVar = new i();
        iVar.f17571a = bVar;
        iVar.f17572b = this;
        iVar.f17573c = new LinkedBlockingQueue();
        this.f17555a = iVar;
    }

    public final int a() {
        b bVar = this.f17557c;
        bVar.getClass();
        return bVar.a();
    }

    public final void b() {
        b bVar = this.f17557c;
        bVar.getClass();
        long j4 = this.f17559f;
        a aVar = this.e;
        if (aVar.f17543d > 0) {
            long j10 = j4 - aVar.f17542c;
            aVar.f17540a = 0L;
            long uptimeMillis = SystemClock.uptimeMillis() - aVar.f17543d;
            if (uptimeMillis <= 0) {
                aVar.e = (int) j10;
            } else {
                aVar.e = (int) (j10 / uptimeMillis);
            }
        }
        bVar.getClass();
        s c9 = p.f17581a.c();
        bVar.getClass();
        c9.b(bVar);
    }

    public final void c() {
        File file;
        b bVar = this.f17557c;
        bVar.getClass();
        if (bVar.e == null) {
            int i3 = ye.e.f20123a;
            bVar.c(ye.e.c(TextUtils.isEmpty(null) ? (n6.f10047a.getExternalCacheDir() == null || !Environment.getExternalStorageState().equals("mounted") || Environment.getExternalStorageDirectory().getFreeSpace() <= 0) ? n6.f10047a.getCacheDir().getAbsolutePath() : n6.f10047a.getExternalCacheDir().getAbsolutePath() : null, ye.e.i(bVar.f17547d)), false);
        }
        if (bVar.f17549g) {
            file = new File(bVar.e);
        } else {
            String d5 = ye.e.d(bVar.e);
            if (d5 == null) {
                String str = bVar.e;
                Locale locale = Locale.ENGLISH;
                throw new InvalidParameterException(l0.o("the provided mPath[", str, "] is invalid, can't find its directory"));
            }
            file = new File(d5);
        }
        if (file.exists() || file.mkdirs() || file.exists()) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        int i10 = ye.e.f20123a;
        Locale locale2 = Locale.ENGLISH;
        throw new IOException(l0.n("Create parent directory failed, please make sure you have permission to create file or directory on the path: ", absolutePath));
    }

    public final MessageSnapshot d(Throwable th2) {
        this.f17558d = (byte) -1;
        int a3 = a();
        long j4 = this.f17559f;
        return j4 > 2147483647L ? new LargeMessageSnapshot.ErrorMessageSnapshot(a3, j4, th2) : new SmallMessageSnapshot.ErrorMessageSnapshot(a3, (int) j4, th2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(MessageSnapshot messageSnapshot) {
        b bVar = this.f17557c;
        bVar.getClass();
        byte n4 = messageSnapshot.n();
        this.f17558d = n4;
        int i3 = 0;
        if (n4 == -4) {
            a aVar = this.e;
            aVar.e = 0;
            aVar.f17540a = 0L;
            i1 i1Var = e.f17562a;
            int e = i1Var.e(bVar.a());
            if (e <= 1 && bVar.f17549g) {
                String str = bVar.f17547d;
                String b3 = bVar.b();
                com.liulishuo.filedownloader.download.c.f11405a.g().getClass();
                i3 = i1Var.e(com.google.android.gms.internal.mlkit_common.o.a(str, b3, false));
            }
            if (e + i3 <= 1) {
                byte a3 = ((r) j.f17574a.f16254b).a(bVar.a());
                o6.b(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(bVar.a()), Integer.valueOf(a3));
                if (a3 > 0) {
                    this.f17558d = (byte) 1;
                    this.f17560g = messageSnapshot.j();
                    long i10 = messageSnapshot.i();
                    this.f17559f = i10;
                    a aVar2 = this.e;
                    aVar2.f17543d = SystemClock.uptimeMillis();
                    aVar2.f17542c = i10;
                    i iVar = this.f17555a;
                    MessageSnapshot a10 = ((ue.b) messageSnapshot).a();
                    iVar.f17572b.getClass();
                    iVar.c(a10);
                    return;
                }
            }
            b bVar2 = this.f17557c;
            bVar2.getClass();
            i1Var.i(bVar2, messageSnapshot);
            return;
        }
        if (n4 == -3) {
            messageSnapshot.q();
            this.f17559f = messageSnapshot.j();
            this.f17560g = messageSnapshot.j();
            i1 i1Var2 = e.f17562a;
            b bVar3 = this.f17557c;
            bVar3.getClass();
            i1Var2.i(bVar3, messageSnapshot);
            return;
        }
        if (n4 == -1) {
            messageSnapshot.o();
            this.f17559f = messageSnapshot.i();
            i1 i1Var3 = e.f17562a;
            b bVar4 = this.f17557c;
            bVar4.getClass();
            i1Var3.i(bVar4, messageSnapshot);
            return;
        }
        if (n4 == 1) {
            this.f17559f = messageSnapshot.i();
            this.f17560g = messageSnapshot.j();
            i iVar2 = this.f17555a;
            iVar2.f17572b.getClass();
            iVar2.c(messageSnapshot);
            return;
        }
        if (n4 == 2) {
            this.f17560g = messageSnapshot.j();
            messageSnapshot.p();
            messageSnapshot.b();
            String d5 = messageSnapshot.d();
            if (d5 != null) {
                String str2 = bVar.f17548f;
                if (str2 != null) {
                    o6.b(this, "already has mFilename[%s], but assign mFilename[%s] again", str2, d5);
                }
                this.f17557c.f17548f = d5;
            }
            a aVar3 = this.e;
            long j4 = this.f17559f;
            aVar3.f17543d = SystemClock.uptimeMillis();
            aVar3.f17542c = j4;
            i iVar3 = this.f17555a;
            iVar3.f17572b.getClass();
            iVar3.c(messageSnapshot);
            return;
        }
        if (n4 != 3) {
            if (n4 != 5) {
                if (n4 != 6) {
                    return;
                }
                i iVar4 = this.f17555a;
                iVar4.f17572b.getClass();
                iVar4.c(messageSnapshot);
                return;
            }
            this.f17559f = messageSnapshot.i();
            messageSnapshot.o();
            messageSnapshot.k();
            a aVar4 = this.e;
            aVar4.e = 0;
            aVar4.f17540a = 0L;
            i iVar5 = this.f17555a;
            iVar5.f17572b.getClass();
            iVar5.c(messageSnapshot);
            return;
        }
        this.f17559f = messageSnapshot.i();
        a aVar5 = this.e;
        long i11 = messageSnapshot.i();
        if (aVar5.f17540a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - aVar5.f17540a;
            if (uptimeMillis >= 1000 || (aVar5.e == 0 && uptimeMillis > 0)) {
                int i12 = (int) ((i11 - aVar5.f17541b) / uptimeMillis);
                aVar5.e = i12;
                aVar5.e = Math.max(0, i12);
            }
            i iVar6 = this.f17555a;
            iVar6.f17571a.getClass();
            iVar6.f17572b.getClass();
            iVar6.c(messageSnapshot);
        }
        aVar5.f17541b = i11;
        aVar5.f17540a = SystemClock.uptimeMillis();
        i iVar62 = this.f17555a;
        iVar62.f17571a.getClass();
        iVar62.f17572b.getClass();
        iVar62.c(messageSnapshot);
    }
}
