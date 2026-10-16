package pe;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final q f17561a;

    static {
        q qVar = new q();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ye.b("EventPool"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        qVar.f17584a = threadPoolExecutor;
        qVar.f17585b = new HashMap();
        f17561a = qVar;
    }
}
