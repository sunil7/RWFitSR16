package g4;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import java.io.InputStream;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class a implements x3.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13808a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13809b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13810c;

    public /* synthetic */ a(int i3, Object obj, Object obj2) {
        this.f13808a = i3;
        this.f13809b = obj;
        this.f13810c = obj2;
    }

    @Override // x3.g
    public final boolean a(Object obj, x3.f fVar) {
        switch (this.f13808a) {
            case 0:
                return ((x3.g) this.f13809b).a(obj, fVar);
            case 1:
                androidx.emoji2.text.v.v(obj);
                return true;
            case 2:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                return true;
        }
    }

    @Override // x3.g
    public final z3.s b(Object obj, int i3, int i10, x3.f fVar) {
        boolean z5;
        com.bumptech.glide.load.resource.bitmap.a aVar;
        t4.e eVar;
        switch (this.f13808a) {
            case 0:
                z3.s b3 = ((x3.g) this.f13809b).b(obj, i3, i10, fVar);
                if (b3 == null) {
                    return null;
                }
                return new c((Resources) this.f13810c, b3);
            case 1:
                return c(androidx.emoji2.text.v.f(obj), i3, i10, fVar);
            case 2:
                z3.s c9 = ((i4.b) this.f13809b).c((Uri) obj);
                if (c9 == null) {
                    return null;
                }
                return q.a((a4.b) this.f13810c, (Drawable) ((i4.a) c9).get(), i3, i10);
            default:
                InputStream inputStream = (InputStream) obj;
                if (inputStream instanceof com.bumptech.glide.load.resource.bitmap.a) {
                    aVar = (com.bumptech.glide.load.resource.bitmap.a) inputStream;
                    z5 = false;
                } else {
                    z5 = true;
                    aVar = new com.bumptech.glide.load.resource.bitmap.a(inputStream, (a4.g) this.f13810c);
                }
                ArrayDeque arrayDeque = t4.e.f18509c;
                synchronized (arrayDeque) {
                    eVar = (t4.e) arrayDeque.poll();
                }
                if (eVar == null) {
                    eVar = new t4.e();
                }
                t4.e eVar2 = eVar;
                eVar2.f18510a = aVar;
                t4.i iVar = new t4.i(eVar2);
                ef.i iVar2 = new ef.i(18, aVar, eVar2);
                try {
                    o oVar = (o) this.f13809b;
                    c a3 = oVar.a(new de.o(oVar.f13843c, iVar, oVar.f13844d), i3, i10, fVar, iVar2);
                    eVar2.f18511b = null;
                    eVar2.f18510a = null;
                    synchronized (arrayDeque) {
                        arrayDeque.offer(eVar2);
                    }
                    if (z5) {
                        aVar.c();
                    }
                    return a3;
                } catch (Throwable th2) {
                    eVar2.f18511b = null;
                    eVar2.f18510a = null;
                    ArrayDeque arrayDeque2 = t4.e.f18509c;
                    synchronized (arrayDeque2) {
                        arrayDeque2.offer(eVar2);
                        if (!z5) {
                            throw th2;
                        }
                        aVar.c();
                        throw th2;
                    }
                }
        }
    }

    public c c(ImageDecoder.Source source, int i3, int i10, x3.f fVar) {
        Bitmap decodeBitmap;
        DecodeFormat decodeFormat = (DecodeFormat) fVar.c(o.f13835f);
        m mVar = (m) fVar.c(m.f13832g);
        x3.e eVar = o.f13838i;
        decodeBitmap = ImageDecoder.decodeBitmap(source, new f4.b(this, i3, i10, fVar.c(eVar) != null && ((Boolean) fVar.c(eVar)).booleanValue(), decodeFormat, mVar, (PreferredColorSpace) fVar.c(o.f13836g)));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i3 + "x" + i10 + "]");
        }
        return new c((eb.e) this.f13810c, decodeBitmap);
    }

    public a() {
        this.f13808a = 1;
        this.f13809b = u.a();
        this.f13810c = new eb.e(1);
    }

    public a(Resources resources, x3.g gVar) {
        this.f13808a = 0;
        this.f13810c = resources;
        this.f13809b = gVar;
    }
}
