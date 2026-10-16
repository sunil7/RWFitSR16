package z3;

import java.io.File;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final y2.f f20243a;

    /* renamed from: b, reason: collision with root package name */
    public volatile b4.a f20244b;

    public i(y2.f fVar) {
        this.f20243a = fVar;
    }

    public final b4.a a() {
        if (this.f20244b == null) {
            synchronized (this) {
                try {
                    if (this.f20244b == null) {
                        File cacheDir = ((b4.d) this.f20243a.f19953b).f3152a.getCacheDir();
                        b4.c cVar = null;
                        File file = cacheDir == null ? null : new File(cacheDir, "image_manager_disk_cache");
                        if (file != null && (file.isDirectory() || file.mkdirs())) {
                            cVar = new b4.c(file);
                        }
                        this.f20244b = cVar;
                    }
                    if (this.f20244b == null) {
                        this.f20244b = new n9.e(2);
                    }
                } finally {
                }
            }
        }
        return this.f20244b;
    }
}
