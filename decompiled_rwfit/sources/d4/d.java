package d4;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class d implements com.bumptech.glide.load.data.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12249a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12250b;

    public /* synthetic */ d(Object obj, int i3) {
        this.f12249a = i3;
        this.f12250b = obj;
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
        switch (this.f12249a) {
            case 0:
                return ByteBuffer.class;
            default:
                return this.f12250b.getClass();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        int i3 = this.f12249a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i3 = this.f12249a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource e() {
        switch (this.f12249a) {
        }
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void f(Priority priority, com.bumptech.glide.load.data.d dVar) {
        switch (this.f12249a) {
            case 0:
                try {
                    dVar.d(t4.b.a((File) this.f12250b));
                    break;
                } catch (IOException e) {
                    if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                        Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                    }
                    dVar.c(e);
                    return;
                }
            default:
                dVar.d(this.f12250b);
                break;
        }
    }
}
