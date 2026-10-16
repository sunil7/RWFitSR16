package c6;

import com.example.network.api.WxAuthApi;

/* loaded from: classes.dex */
public final class e extends a6.c {

    /* renamed from: c, reason: collision with root package name */
    public static final e f3393c = new e();

    @Override // a6.c
    public final Object a() {
        Object create = b().create(WxAuthApi.class);
        kotlin.jvm.internal.e.e(create, "create(...)");
        return (WxAuthApi) create;
    }

    @Override // a6.c
    public final String c() {
        return "https://api.weixin.qq.com/sns/";
    }
}
