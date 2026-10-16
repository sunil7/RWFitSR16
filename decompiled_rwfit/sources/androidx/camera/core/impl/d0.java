package androidx.camera.core.impl;

import android.util.Range;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: h, reason: collision with root package name */
    public static final c f1363h = new c("camerax.core.captureConfig.rotation", Integer.TYPE, null);

    /* renamed from: i, reason: collision with root package name */
    public static final c f1364i = new c("camerax.core.captureConfig.jpegQuality", Integer.class, null);

    /* renamed from: j, reason: collision with root package name */
    public static final c f1365j = new c("camerax.core.captureConfig.resolvedFrameRate", Range.class, null);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1366a;

    /* renamed from: b, reason: collision with root package name */
    public final d1 f1367b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1368c;

    /* renamed from: d, reason: collision with root package name */
    public final List f1369d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final w1 f1370f;

    /* renamed from: g, reason: collision with root package name */
    public final n f1371g;

    public d0(ArrayList arrayList, d1 d1Var, int i3, ArrayList arrayList2, boolean z5, w1 w1Var, n nVar) {
        this.f1366a = arrayList;
        this.f1367b = d1Var;
        this.f1368c = i3;
        this.f1369d = Collections.unmodifiableList(arrayList2);
        this.e = z5;
        this.f1370f = w1Var;
        this.f1371g = nVar;
    }

    public final int a() {
        Object obj = 0;
        try {
            obj = this.f1367b.e(a2.L0);
        } catch (IllegalArgumentException unused) {
        }
        Integer num = (Integer) obj;
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public final int b() {
        Object obj = 0;
        try {
            obj = this.f1367b.e(a2.M0);
        } catch (IllegalArgumentException unused) {
        }
        Integer num = (Integer) obj;
        Objects.requireNonNull(num);
        return num.intValue();
    }
}
