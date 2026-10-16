package p2;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.ListenableWorker;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import de.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: l, reason: collision with root package name */
    public static final String f17390l = o2.m.i("Processor");

    /* renamed from: b, reason: collision with root package name */
    public final Context f17392b;

    /* renamed from: c, reason: collision with root package name */
    public final o2.b f17393c;

    /* renamed from: d, reason: collision with root package name */
    public final o f17394d;
    public final WorkDatabase e;

    /* renamed from: h, reason: collision with root package name */
    public final List f17397h;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f17396g = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f17395f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f17398i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f17399j = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f17391a = null;

    /* renamed from: k, reason: collision with root package name */
    public final Object f17400k = new Object();

    public b(Context context, o2.b bVar, o oVar, WorkDatabase workDatabase, List list) {
        this.f17392b = context;
        this.f17393c = bVar;
        this.f17394d = oVar;
        this.e = workDatabase;
        this.f17397h = list;
    }

    public static boolean c(String str, m mVar) {
        boolean z5;
        if (mVar == null) {
            o2.m.g().d(f17390l, l0.n("WorkerWrapper could not be found for ", str), new Throwable[0]);
            return false;
        }
        mVar.r = true;
        mVar.i();
        ob.a aVar = mVar.f17449q;
        if (aVar != null) {
            z5 = aVar.isDone();
            mVar.f17449q.cancel(true);
        } else {
            z5 = false;
        }
        ListenableWorker listenableWorker = mVar.e;
        if (listenableWorker == null || z5) {
            o2.m.g().d(m.f17433s, "WorkSpec " + mVar.f17437d + " is already done. Not interrupting.", new Throwable[0]);
        } else {
            listenableWorker.f();
        }
        o2.m.g().d(f17390l, l0.n("WorkerWrapper interrupted for ", str), new Throwable[0]);
        return true;
    }

    @Override // p2.a
    public final void a(String str, boolean z5) {
        synchronized (this.f17400k) {
            try {
                this.f17396g.remove(str);
                int i3 = 0;
                o2.m.g().d(f17390l, b.class.getSimpleName() + " " + str + " executed; reschedule = " + z5, new Throwable[0]);
                ArrayList arrayList = this.f17399j;
                int size = arrayList.size();
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((a) obj).a(str, z5);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b(a aVar) {
        synchronized (this.f17400k) {
            this.f17399j.add(aVar);
        }
    }

    public final boolean d(String str) {
        boolean z5;
        synchronized (this.f17400k) {
            try {
                z5 = this.f17396g.containsKey(str) || this.f17395f.containsKey(str);
            } finally {
            }
        }
        return z5;
    }

    public final void e(a aVar) {
        synchronized (this.f17400k) {
            this.f17399j.remove(aVar);
        }
    }

    public final void f(String str, o2.g gVar) {
        synchronized (this.f17400k) {
            try {
                o2.m.g().h(f17390l, "Moving WorkSpec (" + str + ") to the foreground", new Throwable[0]);
                m mVar = (m) this.f17396g.remove(str);
                if (mVar != null) {
                    if (this.f17391a == null) {
                        PowerManager.WakeLock a3 = y2.k.a(this.f17392b, "ProcessorForegroundLck");
                        this.f17391a = a3;
                        a3.acquire();
                    }
                    this.f17395f.put(str, mVar);
                    a1.e.b(this.f17392b, w2.a.d(this.f17392b, str, gVar));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean g(String str, eb.e eVar) {
        synchronized (this.f17400k) {
            try {
                if (d(str)) {
                    o2.m.g().d(f17390l, "Work " + str + " is already enqueued for processing", new Throwable[0]);
                    return false;
                }
                Context context = this.f17392b;
                o2.b bVar = this.f17393c;
                o oVar = this.f17394d;
                WorkDatabase workDatabase = this.e;
                List list = Collections.EMPTY_LIST;
                Context applicationContext = context.getApplicationContext();
                List list2 = this.f17397h;
                m mVar = new m();
                mVar.f17439g = new o2.i();
                mVar.f17448p = new androidx.work.impl.utils.futures.b();
                mVar.f17449q = null;
                mVar.f17434a = applicationContext;
                mVar.f17438f = oVar;
                mVar.f17441i = this;
                mVar.f17435b = str;
                mVar.f17436c = list2;
                mVar.e = null;
                mVar.f17440h = bVar;
                mVar.f17442j = workDatabase;
                mVar.f17443k = workDatabase.n();
                mVar.f17444l = workDatabase.i();
                mVar.f17445m = workDatabase.o();
                androidx.work.impl.utils.futures.b bVar2 = mVar.f17448p;
                e8.a aVar = new e8.a(6);
                aVar.f12474b = this;
                aVar.f12475c = str;
                aVar.f12476d = bVar2;
                bVar2.a(aVar, (w.d) this.f17394d.f12379d);
                this.f17396g.put(str, mVar);
                ((y2.i) this.f17394d.f12377b).execute(mVar);
                o2.m.g().d(f17390l, r5.a.c(b.class.getSimpleName(), ": processing ", str), new Throwable[0]);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void h() {
        synchronized (this.f17400k) {
            try {
                if (this.f17395f.isEmpty()) {
                    Context context = this.f17392b;
                    String str = w2.a.f19467j;
                    Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                    intent.setAction("ACTION_STOP_FOREGROUND");
                    try {
                        this.f17392b.startService(intent);
                    } catch (Throwable th2) {
                        o2.m.g().f(f17390l, "Unable to stop foreground service", th2);
                    }
                    PowerManager.WakeLock wakeLock = this.f17391a;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.f17391a = null;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final boolean i(String str) {
        boolean c9;
        synchronized (this.f17400k) {
            o2.m.g().d(f17390l, "Processor stopping foreground work " + str, new Throwable[0]);
            c9 = c(str, (m) this.f17395f.remove(str));
        }
        return c9;
    }

    public final boolean j(String str) {
        boolean c9;
        synchronized (this.f17400k) {
            o2.m.g().d(f17390l, "Processor stopping background work " + str, new Throwable[0]);
            c9 = c(str, (m) this.f17396g.remove(str));
        }
        return c9;
    }
}
