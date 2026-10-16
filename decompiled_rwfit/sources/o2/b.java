package o2;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import n.m0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f16691a = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new a(false));

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f16692b = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new a(true));

    /* renamed from: c, reason: collision with root package name */
    public final v f16693c = new v();

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.internal.mlkit_common.o f16694d = new com.google.android.gms.internal.mlkit_common.o(17);
    public final m0 e = new m0(7);

    /* renamed from: f, reason: collision with root package name */
    public final int f16695f = 4;

    /* renamed from: g, reason: collision with root package name */
    public final int f16696g = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: h, reason: collision with root package name */
    public final int f16697h = 20;

    public b(n9.e eVar) {
    }
}
