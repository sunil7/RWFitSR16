package com.dh.imagepick.work;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.dh.imagepick.DevUtil;
import com.dh.imagepick.Utils;
import com.dh.imagepick.exception.BaseException;
import com.google.android.gms.internal.mlkit_vision_barcode.ec;
import de.o;
import eh.g;
import oh.q;

/* loaded from: classes.dex */
public final class d extends a {
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, z4.c] */
    @Override // com.dh.imagepick.work.a
    public final void a(ec ecVar, final o oVar) {
        ?? r52 = this.f7196a;
        if (r52.u() == null) {
            return;
        }
        f5.b bVar = (f5.b) this.f7197b;
        bVar.getClass();
        Intent intent = new Intent("android.intent.action.GET_CONTENT", (Uri) null);
        bVar.getClass();
        intent.setType("image/*");
        intent.addCategory("android.intent.category.OPENABLE");
        try {
            r52.v(intent, 1024, new q() { // from class: com.dh.imagepick.work.PickPhotoWorker$pickPhoto$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // oh.q
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Intent) obj3);
                    return g.f12633a;
                }

                /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object, z4.c] */
                public final void invoke(int i3, int i10, Intent intent2) {
                    String str;
                    d dVar = d.this;
                    a5.a aVar = oVar;
                    Object obj = dVar.f7197b;
                    if (i10 == 0) {
                        ((f5.b) obj).getClass();
                        return;
                    }
                    if (intent2 == null || intent2.getData() == null) {
                        aVar.c(new BaseException("null result intentData"));
                        return;
                    }
                    g5.b bVar2 = new g5.b();
                    Uri data = intent2.getData();
                    kotlin.jvm.internal.e.c(data);
                    bVar2.f13870a = data;
                    try {
                        int i11 = Build.VERSION.SDK_INT;
                        ?? r53 = dVar.f7196a;
                        if (i11 >= 30) {
                            Utils utils = Utils.INSTANCE;
                            Activity u10 = r53.u();
                            kotlin.jvm.internal.e.c(u10);
                            Uri data2 = intent2.getData();
                            kotlin.jvm.internal.e.c(data2);
                            str = utils.uriToImagePath2(u10, data2);
                        } else {
                            Utils utils2 = Utils.INSTANCE;
                            Activity u11 = r53.u();
                            kotlin.jvm.internal.e.c(u11);
                            Uri data3 = intent2.getData();
                            kotlin.jvm.internal.e.c(data3);
                            str = utils2.uriToImagePath(u11, data3);
                        }
                    } catch (Exception e) {
                        DevUtil.INSTANCE.e("ImagePick", e.toString());
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        kotlin.jvm.internal.e.c(str);
                        bVar2.f13871b = str;
                    }
                    ((f5.b) obj).getClass();
                    aVar.a(bVar2);
                }
            });
        } catch (Exception e) {
            ((a5.a) oVar.f12379d).c(e);
        }
    }
}
