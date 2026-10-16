package c6;

import com.example.network.api.FileApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.FileBean;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rg.l;

/* loaded from: classes.dex */
public final class c extends a6.c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f3391c = new c();

    @Override // a6.c
    public final Object a() {
        Object create = b().create(FileApi.class);
        kotlin.jvm.internal.e.e(create, "create(...)");
        return (FileApi) create;
    }

    public final l d(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            File file = new File((String) obj);
            hashMap.put("file\"; filename=\"" + file.getName(), RequestBody.Companion.create(MediaType.Companion.parse("*/*"), file));
        }
        l<HttpModel<FileBean>> uploadFile = ((FileApi) this.f113a).uploadFile(hashMap);
        kotlin.jvm.internal.e.e(uploadFile, "uploadFile(...)");
        return com.example.baselibrary.utils.b.w(uploadFile);
    }
}
