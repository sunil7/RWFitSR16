package com.dh.imagepick.work;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import com.dh.imagepick.Configs;
import com.dh.imagepick.Utils;
import com.dh.imagepick.crop.ImageCropActivity;
import com.dh.imagepick.crop.bean.ImageItem;
import com.dh.imagepick.exception.BadConvertException;
import com.dh.imagepick.exception.BaseException;
import com.google.android.gms.internal.mlkit_vision_barcode.ec;
import de.o;
import eh.g;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.m;
import oh.q;

/* loaded from: classes.dex */
public final class b extends a {
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, z4.c] */
    @Override // com.dh.imagepick.work.a
    public final void a(ec ecVar, final o oVar) {
        a5.a aVar = (a5.a) oVar.f12379d;
        Configs.Builder builder = Configs.Builder;
        String cropsResultFile$imagepick_release = builder.getCropsResultFile$imagepick_release();
        Object obj = this.f7197b;
        if (cropsResultFile$imagepick_release != null) {
            new File(builder.getCropsResultFile$imagepick_release());
            ((f5.a) obj).getClass();
        }
        try {
            b(ecVar);
            f5.a aVar2 = (f5.a) obj;
            aVar2.getClass();
            if (aVar2.f12664b == null) {
                aVar.c(new BaseException("crop file is null"));
                return;
            }
            ?? r62 = this.f7196a;
            Activity u10 = r62.u();
            if (u10 == null) {
                return;
            }
            com.dh.imagepick.crop.b a3 = com.dh.imagepick.crop.b.a();
            a3.f7112d = false;
            a3.f7109a = false;
            a3.f7111c = true;
            a3.f7110b = 1;
            a3.f7117j = aVar2.e;
            int i3 = aVar2.f12665c;
            a3.f7115h = i3;
            int i10 = aVar2.f12666d;
            a3.f7116i = i10;
            a3.f7113f = i3;
            a3.f7114g = i10;
            ArrayList arrayList = a3.f7120m;
            if (arrayList != null) {
                arrayList.clear();
            }
            ImageItem imageItem = new ImageItem();
            File file = aVar2.f12664b;
            kotlin.jvm.internal.e.c(file);
            imageItem.path = file.getAbsolutePath();
            arrayList.add(imageItem);
            ArrayList arrayList2 = a3.f7121n;
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                if (it.hasNext()) {
                    throw android.support.v4.media.session.e.d(it);
                }
            }
            r62.v(new Intent(u10, (Class<?>) ImageCropActivity.class), 256, new q() { // from class: com.dh.imagepick.work.CropWorker$start$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // oh.q
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue(), (Intent) obj4);
                    return g.f12633a;
                }

                public final void invoke(int i11, int i12, Intent intent) {
                    b bVar = b.this;
                    a5.a aVar3 = oVar;
                    Object obj2 = bVar.f7197b;
                    if (i12 == 0) {
                        ((f5.a) obj2).getClass();
                        return;
                    }
                    if ((intent != null ? intent.getSerializableExtra("extra_result_items") : null) == null) {
                        return;
                    }
                    Serializable serializableExtra = intent != null ? intent.getSerializableExtra("extra_result_items") : null;
                    kotlin.jvm.internal.e.d(serializableExtra, "null cannot be cast to non-null type java.util.ArrayList<com.dh.imagepick.crop.bean.ImageItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.dh.imagepick.crop.bean.ImageItem> }");
                    ArrayList arrayList3 = (ArrayList) serializableExtra;
                    if (arrayList3.isEmpty()) {
                        return;
                    }
                    Object obj3 = arrayList3.get(0);
                    kotlin.jvm.internal.e.e(obj3, "get(...)");
                    ImageItem imageItem2 = (ImageItem) obj3;
                    g5.a aVar4 = new g5.a();
                    aVar4.f13868b = ((f5.a) obj2).f12664b;
                    aVar4.f13872a = new File(imageItem2.path);
                    Utils utils = Utils.INSTANCE;
                    String path = imageItem2.path;
                    kotlin.jvm.internal.e.e(path, "path");
                    Bitmap bitmapFromFile = utils.getBitmapFromFile(path);
                    kotlin.jvm.internal.e.c(bitmapFromFile);
                    aVar4.f13869c = bitmapFromFile;
                    aVar3.a(aVar4);
                }
            });
        } catch (Exception e) {
            aVar.c(e);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, z4.c] */
    public final void b(ec ecVar) {
        String uriToImagePath;
        if (ecVar == null) {
            return;
        }
        boolean z5 = ecVar instanceof g5.d;
        Object obj = this.f7197b;
        if (z5) {
            File file = ((g5.d) ecVar).f13872a;
            kotlin.jvm.internal.e.c(file);
            ((f5.a) obj).f12664b = file;
        }
        if (ecVar instanceof g5.b) {
            int i3 = Build.VERSION.SDK_INT;
            ?? r22 = this.f7196a;
            if (i3 >= 30) {
                Utils utils = Utils.INSTANCE;
                Activity u10 = r22.u();
                kotlin.jvm.internal.e.c(u10);
                uriToImagePath = utils.uriToImagePath2(u10, ((g5.b) ecVar).f13870a);
            } else {
                Utils utils2 = Utils.INSTANCE;
                Activity u11 = r22.u();
                kotlin.jvm.internal.e.c(u11);
                uriToImagePath = utils2.uriToImagePath(u11, ((g5.b) ecVar).f13870a);
            }
            if (uriToImagePath != null && !m.l(uriToImagePath)) {
                File file2 = new File(uriToImagePath);
                if (!file2.exists()) {
                    throw new BadConvertException((g5.b) ecVar);
                }
                ((f5.a) obj).f12664b = file2;
            }
            if (uriToImagePath == null || m.l(uriToImagePath)) {
                throw new BadConvertException((g5.b) ecVar);
            }
        }
    }
}
