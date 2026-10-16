package c6;

import com.example.network.api.DataApi;
import com.example.network.base.HttpModel;
import java.util.ArrayList;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rg.l;

/* loaded from: classes.dex */
public final class a extends a6.c {

    /* renamed from: c, reason: collision with root package name */
    public static final a f3389c = new a();

    @Override // a6.c
    public final Object a() {
        Object create = b().create(DataApi.class);
        kotlin.jvm.internal.e.e(create, "create(...)");
        return (DataApi) create;
    }

    public final l d(ArrayList arrayList) {
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
        String z5 = com.example.baselibrary.utils.b.z(arrayList);
        kotlin.jvm.internal.e.e(z5, "toJson(...)");
        l<HttpModel<String>> uploadSteps = ((DataApi) this.f113a).uploadSteps(companion.create(parse, z5));
        kotlin.jvm.internal.e.e(uploadSteps, "uploadSteps(...)");
        return com.example.baselibrary.utils.b.u(uploadSteps);
    }
}
