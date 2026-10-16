package pe;

import android.os.Handler;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.liulishuo.filedownloader.message.BlockCompleteMessage$BlockCompleteMessageImpl;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public b f17571a;

    /* renamed from: b, reason: collision with root package name */
    public c f17572b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedBlockingQueue f17573c;

    public final void a() {
        MessageSnapshot messageSnapshot = (MessageSnapshot) this.f17573c.poll();
        byte n4 = messageSnapshot.n();
        b bVar = this.f17571a;
        if (bVar == null) {
            int size = this.f17573c.size();
            int i3 = ye.e.f20123a;
            Locale locale = Locale.ENGLISH;
            throw new IllegalArgumentException(android.support.v4.media.session.e.g(n4, "can't handover the message, no master to receive this message(status[", size, "]) size[", "]"));
        }
        p pVar = bVar.f17550h;
        b(n4);
        if (pVar != null) {
            if (n4 == 4) {
                try {
                    MessageSnapshot r = ((BlockCompleteMessage$BlockCompleteMessageImpl) messageSnapshot).r();
                    this.f17572b.b();
                    c(r);
                    return;
                } catch (Throwable th2) {
                    MessageSnapshot d5 = bVar.f17545b.d(th2);
                    this.f17572b.b();
                    c(d5);
                    return;
                }
            }
            if (n4 == -4) {
                pVar.e(bVar);
                return;
            }
            if (n4 == -3) {
                pVar.a(bVar);
                return;
            }
            if (n4 == -2) {
                messageSnapshot.l();
                messageSnapshot.m();
                return;
            }
            if (n4 == -1) {
                pVar.b(bVar, messageSnapshot.o());
                return;
            }
            if (n4 == 1) {
                messageSnapshot.l();
                messageSnapshot.m();
                pVar.c(bVar);
                return;
            }
            c cVar = bVar.f17544a;
            if (n4 == 2) {
                messageSnapshot.b();
                messageSnapshot.p();
                long j4 = cVar.f17559f;
                messageSnapshot.m();
                return;
            }
            if (n4 == 3) {
                int l3 = messageSnapshot.l();
                long j10 = cVar.f17560g;
                pVar.d(l3, j10 > 2147483647L ? SubsamplingScaleImageView.TILE_SIZE_AUTO : (int) j10);
            } else {
                if (n4 != 5) {
                    return;
                }
                messageSnapshot.o();
                messageSnapshot.k();
                messageSnapshot.l();
            }
        }
    }

    public final void b(int i3) {
        if (i3 < 0) {
            if (!this.f17573c.isEmpty()) {
                MessageSnapshot messageSnapshot = (MessageSnapshot) this.f17573c.peek();
                o6.b(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(messageSnapshot.h()), Integer.valueOf(this.f17573c.size()), Byte.valueOf(messageSnapshot.n()));
            }
            this.f17571a = null;
        }
    }

    public final void c(MessageSnapshot messageSnapshot) {
        b bVar = this.f17571a;
        if (bVar == null) {
            return;
        }
        if (bVar.f17550h == null) {
            bVar.getClass();
            b(messageSnapshot.n());
            return;
        }
        this.f17573c.offer(messageSnapshot);
        ThreadPoolExecutor threadPoolExecutor = h.e;
        h hVar = f.f17563a;
        hVar.getClass();
        this.f17571a.getClass();
        if (h.a(this)) {
            return;
        }
        if (h.f17565f <= 0 && !hVar.f17568b.isEmpty()) {
            synchronized (hVar.f17569c) {
                try {
                    if (!hVar.f17568b.isEmpty()) {
                        Iterator it = hVar.f17568b.iterator();
                        while (it.hasNext()) {
                            i iVar = (i) it.next();
                            Handler handler = hVar.f17567a;
                            handler.sendMessage(handler.obtainMessage(1, iVar));
                        }
                    }
                    hVar.f17568b.clear();
                } finally {
                }
            }
        }
        if (h.f17565f <= 0) {
            Handler handler2 = hVar.f17567a;
            handler2.sendMessage(handler2.obtainMessage(1, this));
        } else {
            synchronized (hVar.f17569c) {
                hVar.f17568b.offer(this);
            }
            hVar.b();
        }
    }

    public final String toString() {
        int a3;
        b bVar = this.f17571a;
        if (bVar == null) {
            a3 = -1;
        } else {
            bVar.getClass();
            a3 = bVar.a();
        }
        String obj = super.toString();
        int i3 = ye.e.f20123a;
        Locale locale = Locale.ENGLISH;
        return a3 + ":" + obj;
    }
}
