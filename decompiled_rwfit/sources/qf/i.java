package qf;

import android.os.Handler;
import ia.l;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import pe.o;

/* loaded from: classes2.dex */
public final class i {
    public static final ef.b e = ef.b.a(i.class.getSimpleName());

    /* renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap f17953f = new ConcurrentHashMap(4);

    /* renamed from: a, reason: collision with root package name */
    public String f17954a;

    /* renamed from: b, reason: collision with root package name */
    public h f17955b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f17956c;

    /* renamed from: d, reason: collision with root package name */
    public l f17957d;

    public static i a(String str) {
        ConcurrentHashMap concurrentHashMap = f17953f;
        boolean containsKey = concurrentHashMap.containsKey(str);
        ef.b bVar = e;
        if (containsKey) {
            i iVar = (i) ((WeakReference) concurrentHashMap.get(str)).get();
            if (iVar != null) {
                h hVar = iVar.f17955b;
                if (hVar.isAlive() && !hVar.isInterrupted()) {
                    bVar.b(2, "get:", "Reusing cached worker handler.", str);
                    return iVar;
                }
                h hVar2 = iVar.f17955b;
                if (hVar2.isAlive()) {
                    hVar2.interrupt();
                    hVar2.quit();
                }
                concurrentHashMap.remove(iVar.f17954a);
                bVar.b(2, "get:", "Thread reference found, but not alive or interrupted.", "Removing.", str);
                concurrentHashMap.remove(str);
            } else {
                bVar.b(2, "get:", "Thread reference died. Removing.", str);
                concurrentHashMap.remove(str);
            }
        }
        bVar.b(1, "get:", "Creating new handler.", str);
        i iVar2 = new i();
        iVar2.f17954a = str;
        h hVar3 = new h(str);
        iVar2.f17955b = hVar3;
        hVar3.setDaemon(true);
        hVar3.start();
        iVar2.f17956c = new Handler(hVar3.getLooper());
        iVar2.f17957d = new l(iVar2);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        iVar2.f17956c.post(new o(countDownLatch, 2));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        concurrentHashMap.put(str, new WeakReference(iVar2));
        return iVar2;
    }
}
