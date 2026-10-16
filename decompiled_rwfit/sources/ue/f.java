package ue;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f19068a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ThreadPoolExecutor f19069b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o4.e f19070c;

    public f(o4.e eVar, int i3) {
        this.f19070c = eVar;
        String j4 = l0.j(i3, "Flow-");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ye.b(j4));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f19069b = threadPoolExecutor;
    }
}
