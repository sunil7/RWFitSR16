package com.dh.imagepick.work;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.dh.imagepick.DevUtil;
import com.dh.imagepick.Utils;
import com.google.android.gms.internal.mlkit_vision_barcode.ec;
import de.o;
import eh.g;
import java.io.File;
import oh.q;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: c, reason: collision with root package name */
    public Uri f7200c;

    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, z4.c] */
    @Override // com.dh.imagepick.work.a
    public final void a(ec ecVar, final o oVar) {
        ?? r72 = this.f7196a;
        Activity u10 = r72.u();
        if (u10 == null) {
            return;
        }
        f5.c cVar = (f5.c) this.f7197b;
        cVar.getClass();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        cVar.getClass();
        File file = cVar.f12667b;
        if (file != null) {
            Utils utils = Utils.INSTANCE;
            kotlin.jvm.internal.e.c(file);
            Uri createUriFromFile$imagepick_release = utils.createUriFromFile$imagepick_release(u10, file);
            this.f7200c = createUriFromFile$imagepick_release;
            DevUtil.INSTANCE.d("ImagePick", " uri:" + createUriFromFile$imagepick_release);
            intent.addFlags(1);
            u10.grantUriPermission(u10.getPackageName(), this.f7200c, 3);
            u10.revokeUriPermission(this.f7200c, 3);
            intent.putExtra("output", this.f7200c);
        }
        try {
            r72.v(intent, 512, new q() { // from class: com.dh.imagepick.work.TakePhotoWorker$takePhoto$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // oh.q
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Intent) obj3);
                    return g.f12633a;
                }

                public final void invoke(int i3, int i10, Intent intent2) {
                    e eVar = e.this;
                    a5.a aVar = oVar;
                    Object obj = eVar.f7197b;
                    if (i10 == 0) {
                        ((f5.c) obj).getClass();
                        return;
                    }
                    File file2 = ((f5.c) obj).f12667b;
                    if (file2 != null) {
                        g5.d dVar = new g5.d();
                        dVar.f13872a = file2;
                        aVar.a(dVar);
                    }
                }
            });
        } catch (Exception e) {
            ((a5.a) oVar.f12379d).c(e);
        }
    }
}
