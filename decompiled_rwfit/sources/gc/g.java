package gc;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.internal.mlkit_common.zzai;
import com.google.android.gms.internal.mlkit_vision_barcode.xc;
import ia.m;
import java.util.ArrayList;
import java.util.List;
import q9.n;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Feature[] f14033a = new Feature[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Feature f14034b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzai f14035c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzai f14036d;

    static {
        Feature feature = new Feature("vision.barcode", 1L);
        f14034b = feature;
        Feature feature2 = new Feature("vision.custom.ica", 1L);
        Feature feature3 = new Feature("vision.face", 1L);
        Feature feature4 = new Feature("vision.ica", 1L);
        Feature feature5 = new Feature("vision.ocr", 1L);
        Feature feature6 = new Feature("mlkit.langid", 1L);
        Feature feature7 = new Feature("mlkit.nlclassifier", 1L);
        Feature feature8 = new Feature("tflite_dynamite", 1L);
        Feature feature9 = new Feature("mlkit.barcode.ui", 1L);
        Feature feature10 = new Feature("mlkit.smartreply", 1L);
        com.google.android.gms.internal.mlkit_common.c cVar = new com.google.android.gms.internal.mlkit_common.c();
        cVar.a("barcode", feature);
        cVar.a("custom_ica", feature2);
        cVar.a("face", feature3);
        cVar.a("ica", feature4);
        cVar.a("ocr", feature5);
        cVar.a("langid", feature6);
        cVar.a("nlclassifier", feature7);
        cVar.a("tflite_dynamite", feature8);
        cVar.a("barcode_ui", feature9);
        cVar.a("smart_reply", feature10);
        f14035c = cVar.b();
        com.google.android.gms.internal.mlkit_common.c cVar2 = new com.google.android.gms.internal.mlkit_common.c();
        cVar2.a("com.google.android.gms.vision.barcode", feature);
        cVar2.a("com.google.android.gms.vision.custom.ica", feature2);
        cVar2.a("com.google.android.gms.vision.face", feature3);
        cVar2.a("com.google.android.gms.vision.ica", feature4);
        cVar2.a("com.google.android.gms.vision.ocr", feature5);
        cVar2.a("com.google.android.gms.mlkit.langid", feature6);
        cVar2.a("com.google.android.gms.mlkit.nlclassifier", feature7);
        cVar2.a("com.google.android.gms.tflite_dynamite", feature8);
        cVar2.a("com.google.android.gms.mlkit_smartreply", feature10);
        f14036d = cVar2.b();
    }

    public static void a(Context context, List list) {
        m b3;
        n9.c.f16440b.getClass();
        if (n9.c.a(context) < 221500000) {
            Intent intent = new Intent();
            intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
            intent.setAction("com.google.android.gms.vision.DEPENDENCY");
            intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(Const.STR_MART_COMMA, list));
            intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
            context.sendBroadcast(intent);
            return;
        }
        Feature[] b10 = b(f14035c, list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new k(b10, 0));
        n.a("APIs must not be empty.", !arrayList.isEmpty());
        u9.f fVar = new u9.f(context, u9.f.f19027i, com.google.android.gms.common.api.b.N0, com.google.android.gms.common.api.e.f9078b);
        ApiFeatureRequest h4 = ApiFeatureRequest.h(arrayList, true);
        if (h4.b().isEmpty()) {
            b3 = xc.c(new ModuleInstallResponse(0, false));
        } else {
            o9.j jVar = new o9.j();
            jVar.f16864a = new Feature[]{da.b.f12312c};
            jVar.f16865b = true;
            jVar.f16866c = 27304;
            jVar.f16867d = new n6.a(fVar, h4);
            b3 = fVar.b(0, jVar.a());
        }
        ec.a aVar = new ec.a(12);
        b3.getClass();
        b3.a(ia.h.f14383a, aVar);
    }

    public static Feature[] b(zzai zzaiVar, List list) {
        Feature[] featureArr = new Feature[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            Feature feature = (Feature) zzaiVar.get(list.get(i3));
            n.e(feature);
            featureArr[i3] = feature;
        }
        return featureArr;
    }
}
