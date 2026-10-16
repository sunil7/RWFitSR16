package d4;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class c0 implements r, x3.a {

    /* renamed from: b, reason: collision with root package name */
    public static final c0 f12247b = new c0(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12248a;

    public /* synthetic */ c0(int i3) {
        this.f12248a = i3;
    }

    public static ByteArrayInputStream a(String str) {
        if (!str.startsWith("data:image")) {
            throw new IllegalArgumentException("Not a valid image data URL.");
        }
        int indexOf = str.indexOf(44);
        if (indexOf == -1) {
            throw new IllegalArgumentException("Missing comma in data URL.");
        }
        if (str.substring(0, indexOf).endsWith(";base64")) {
            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
        }
        throw new IllegalArgumentException("Not a base64 image data URL.");
    }

    public Class b() {
        switch (this.f12248a) {
            case 1:
                return ByteBuffer.class;
            case 3:
                return InputStream.class;
            case 8:
                return ParcelFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    @Override // d4.r
    public q c(x xVar) {
        switch (this.f12248a) {
            case 0:
                return d0.f12251b;
            case 2:
                return new c(new c0(1), 0);
            case 4:
                return new c(new c0(3), 0);
            case 6:
                return new d0(1);
            case 11:
                return new b0(xVar.a(Uri.class, AssetFileDescriptor.class), 0);
            case 12:
                return new b0(xVar.a(Uri.class, ParcelFileDescriptor.class), 0);
            case 13:
                return new b0(xVar.a(Uri.class, InputStream.class), 0);
            default:
                return new g0(xVar.a(g.class, InputStream.class));
        }
    }

    @Override // x3.a
    public boolean e(Object obj, File file, x3.f fVar) {
        try {
            t4.b.b((ByteBuffer) obj, file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable("ByteBufferEncoder", 3)) {
                return false;
            }
            Log.d("ByteBufferEncoder", "Failed to write data", e);
            return false;
        }
    }
}
