package com.amap.api.col.p0003sl;

import com.amap.api.location.ILogCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static final List<ILogCallback> f5411a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5412b = 0;

    public static void a(ILogCallback iLogCallback) {
        List<ILogCallback> list = f5411a;
        if (list.contains(iLogCallback)) {
            return;
        }
        list.add(iLogCallback);
    }

    public static void b(ILogCallback iLogCallback) {
        f5411a.remove(iLogCallback);
    }
}
