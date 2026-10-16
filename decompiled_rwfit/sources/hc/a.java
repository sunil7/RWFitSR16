package hc;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Path;
import android.media.MediaMetadataRetriever;
import be.j;
import ca.b;
import com.example.test.service.r0;
import com.google.android.exoplayer2.o;
import com.google.android.gms.internal.mlkit_vision_barcode.n1;
import com.google.gson.internal.i;
import g4.b0;
import gc.e;
import gc.h;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import u4.c;
import vg.p;
import x3.d;
import xd.f;
import xd.k;

/* loaded from: classes.dex */
public class a implements b, o, t6.b, i, pb.b, td.a, b0, nd.a, c, d, p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14307a;

    public /* synthetic */ a(int i3) {
        this.f14307a = i3;
    }

    public static Path f(float f2, float f10, float f11, float f12) {
        Path path = new Path();
        path.moveTo(f2, f10);
        path.lineTo(f11, f12);
        return path;
    }

    @Override // u4.c
    public void a(Object obj) {
        ((List) obj).clear();
    }

    @Override // g4.b0
    public void b(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    @Override // ca.b
    public int c(Context context, String str) {
        return ca.d.a(context, str);
    }

    @Override // x3.d
    public void d(byte[] bArr, Object obj, MessageDigest messageDigest) {
    }

    @Override // ca.b
    public int e(Context context, String str, boolean z5) {
        return ca.d.d(context, str, z5);
    }

    public boolean g(CharSequence charSequence) {
        return false;
    }

    @Override // td.a
    public Object h(vd.b bVar) {
        switch (this.f14307a) {
            case 9:
                if (bVar instanceof k) {
                    return (j) ((k) bVar).f19230g;
                }
                return null;
            default:
                if (bVar instanceof f) {
                    return Integer.valueOf(((be.c) ((f) bVar).f19230g).f3229d);
                }
                return 1;
        }
    }

    @Override // pb.b
    public Object i(pb.p pVar) {
        switch (this.f14307a) {
            case 8:
                return new gc.d(pVar.b(gc.f.class));
            case 12:
                return new h((Context) pVar.a(Context.class));
            default:
                return new mc.b((mc.c) pVar.a(mc.c.class), (gc.d) pVar.a(gc.d.class), (e) pVar.a(e.class));
        }
    }

    @Override // vg.p
    public boolean l(Object obj) {
        return false;
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
        Object obj = r0.M;
        n1.a().f();
    }

    @Override // com.google.gson.internal.i
    public Object t() {
        switch (this.f14307a) {
            case 6:
                return new ConcurrentHashMap();
            default:
                return new ArrayDeque();
        }
    }

    public /* synthetic */ a(Object obj, int i3) {
        this.f14307a = i3;
    }
}
