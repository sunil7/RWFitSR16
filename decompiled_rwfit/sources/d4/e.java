package d4;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class e implements com.bumptech.glide.load.data.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12253a;

    /* renamed from: b, reason: collision with root package name */
    public final Comparable f12254b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f12255c;

    /* renamed from: d, reason: collision with root package name */
    public Object f12256d;

    public /* synthetic */ e(int i3, Comparable comparable, Object obj) {
        this.f12253a = i3;
        this.f12254b = comparable;
        this.f12255c = obj;
    }

    private final void c() {
    }

    private final void d() {
    }

    private final void g() {
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f12253a) {
            case 0:
                ((c0) this.f12255c).getClass();
                return InputStream.class;
            case 1:
                return ((c0) this.f12255c).b();
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        switch (this.f12253a) {
            case 0:
                try {
                    ((ByteArrayInputStream) this.f12256d).close();
                    break;
                } catch (IOException unused) {
                    return;
                }
            case 1:
                Object obj = this.f12256d;
                if (obj != null) {
                    try {
                        switch (((c0) this.f12255c).f12248a) {
                            case 8:
                                ((ParcelFileDescriptor) obj).close();
                                break;
                            default:
                                ((InputStream) obj).close();
                                break;
                        }
                        break;
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
            default:
                InputStream inputStream = (InputStream) this.f12256d;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        break;
                    } catch (IOException unused3) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i3 = this.f12253a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource e() {
        switch (this.f12253a) {
        }
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void f(Priority priority, com.bumptech.glide.load.data.d dVar) {
        Object open;
        switch (this.f12253a) {
            case 0:
                try {
                    ByteArrayInputStream a3 = c0.a((String) this.f12254b);
                    this.f12256d = a3;
                    dVar.d(a3);
                    break;
                } catch (IllegalArgumentException e) {
                    dVar.c(e);
                }
            case 1:
                try {
                    c0 c0Var = (c0) this.f12255c;
                    File file = (File) this.f12254b;
                    switch (c0Var.f12248a) {
                        case 8:
                            open = ParcelFileDescriptor.open(file, AMapEngineUtils.MAX_P20_WIDTH);
                            break;
                        default:
                            open = new FileInputStream(file);
                            break;
                    }
                    this.f12256d = open;
                    dVar.d(open);
                    break;
                } catch (FileNotFoundException e10) {
                    if (Log.isLoggable("FileLoader", 3)) {
                        Log.d("FileLoader", "Failed to open file", e10);
                    }
                    dVar.c(e10);
                    return;
                }
            default:
                try {
                    InputStream h4 = h();
                    this.f12256d = h4;
                    dVar.d(h4);
                    break;
                } catch (FileNotFoundException e11) {
                    if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e11);
                    }
                    dVar.c(e11);
                    return;
                }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x002b, code lost:
    
        if (r6 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x004c, code lost:
    
        if (r6 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002d, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0026: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:68:0x0026 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e3  */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream h() {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.e.h():java.io.InputStream");
    }
}
