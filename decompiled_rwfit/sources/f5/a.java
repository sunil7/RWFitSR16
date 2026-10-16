package f5;

import com.dh.imagepick.crop.CropImageView;
import java.io.File;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class a extends a4.a {

    /* renamed from: b, reason: collision with root package name */
    public File f12664b;

    /* renamed from: c, reason: collision with root package name */
    public int f12665c;

    /* renamed from: d, reason: collision with root package name */
    public int f12666d;
    public CropImageView.Style e;

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, z4.c] */
    @Override // a4.a
    public final com.dh.imagepick.work.a d(Object obj) {
        a builder = (a) obj;
        e.f(builder, "builder");
        return new com.dh.imagepick.work.b(((com.dh.imagepick.work.c) this.f78a).f7198a, builder);
    }

    @Override // a4.a
    public final Object f() {
        return this;
    }
}
