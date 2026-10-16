package z3;

import com.bumptech.glide.load.DataSource;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final h f20239b = new h(0);

    /* renamed from: c, reason: collision with root package name */
    public static final h f20240c = new h(1);

    /* renamed from: d, reason: collision with root package name */
    public static final h f20241d = new h(2);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20242a;

    public /* synthetic */ h(int i3) {
        this.f20242a = i3;
    }

    public final boolean a(DataSource dataSource) {
        switch (this.f20242a) {
            case 0:
                break;
            case 1:
                if (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) {
                }
                break;
            default:
                if (dataSource == DataSource.REMOTE) {
                }
                break;
        }
        return false;
    }
}
