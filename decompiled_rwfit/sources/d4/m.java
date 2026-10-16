package d4;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.internal.mlkit_vision_common.k6;

/* loaded from: classes.dex */
public final class m implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12276a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f12277b;

    public m(Context context, int i3) {
        this.f12276a = i3;
        switch (i3) {
            case 1:
                this.f12277b = context.getApplicationContext();
                break;
            case 2:
                this.f12277b = context.getApplicationContext();
                break;
            default:
                this.f12277b = context;
                break;
        }
    }

    @Override // d4.q
    public final p a(Object obj, int i3, int i10, x3.f fVar) {
        Long l3;
        switch (this.f12276a) {
            case 0:
                Uri uri = (Uri) obj;
                return new p(new s4.d(uri), new l(0, this.f12277b, uri));
            case 1:
                Uri uri2 = (Uri) obj;
                if (i3 == Integer.MIN_VALUE || i10 == Integer.MIN_VALUE || i3 > 512 || i10 > 384) {
                    return null;
                }
                s4.d dVar = new s4.d(uri2);
                Context context = this.f12277b;
                return new p(dVar, new e(2, uri2, new y3.c(com.bumptech.glide.b.b(context).f6911d.e(), new y3.a(context.getContentResolver(), 0), com.bumptech.glide.b.b(context).e, context.getContentResolver())));
            default:
                Uri uri3 = (Uri) obj;
                if (i3 == Integer.MIN_VALUE || i10 == Integer.MIN_VALUE || i3 > 512 || i10 > 384 || (l3 = (Long) fVar.c(com.bumptech.glide.load.resource.bitmap.b.f7026d)) == null || l3.longValue() != -1) {
                    return null;
                }
                s4.d dVar2 = new s4.d(uri3);
                Context context2 = this.f12277b;
                return new p(dVar2, new e(2, uri3, new y3.c(com.bumptech.glide.b.b(context2).f6911d.e(), new y3.a(context2.getContentResolver(), 1), com.bumptech.glide.b.b(context2).e, context2.getContentResolver())));
        }
    }

    @Override // d4.q
    public final boolean b(Object obj) {
        switch (this.f12276a) {
            case 0:
                return k6.a((Uri) obj);
            case 1:
                Uri uri = (Uri) obj;
                return k6.a(uri) && !uri.getPathSegments().contains("video");
            default:
                Uri uri2 = (Uri) obj;
                return k6.a(uri2) && uri2.getPathSegments().contains("video");
        }
    }
}
