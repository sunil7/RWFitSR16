package d4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class l implements com.bumptech.glide.load.data.e {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f12272d = {"_data"};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12273a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12274b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f12275c;

    public /* synthetic */ l(int i3, Object obj, Object obj2) {
        this.f12273a = i3;
        this.f12274b = obj;
        this.f12275c = obj2;
    }

    private final void c() {
    }

    private final void d() {
    }

    private final void g() {
    }

    private final void h() {
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f12273a) {
            case 0:
                return File.class;
            default:
                return ((c0) this.f12275c).b();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        int i3 = this.f12273a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i3 = this.f12273a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource e() {
        switch (this.f12273a) {
        }
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void f(Priority priority, com.bumptech.glide.load.data.d dVar) {
        Object wrap;
        switch (this.f12273a) {
            case 0:
                Cursor query = ((Context) this.f12274b).getContentResolver().query((Uri) this.f12275c, f12272d, null, null, null);
                if (query != null) {
                    try {
                        r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                        query.close();
                    } catch (Throwable th2) {
                        query.close();
                        throw th2;
                    }
                }
                if (!TextUtils.isEmpty(r0)) {
                    dVar.d(new File(r0));
                    return;
                }
                dVar.c(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.f12275c)));
                return;
            default:
                c0 c0Var = (c0) this.f12275c;
                byte[] bArr = (byte[]) this.f12274b;
                switch (c0Var.f12248a) {
                    case 1:
                        wrap = ByteBuffer.wrap(bArr);
                        break;
                    default:
                        wrap = new ByteArrayInputStream(bArr);
                        break;
                }
                dVar.d(wrap);
                return;
        }
    }
}
