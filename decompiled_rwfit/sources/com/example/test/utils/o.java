package com.example.test.utils;

import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode.ec;
import java.io.File;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class o implements a5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8737a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lambda f8738b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Lambda f8739c;

    /* JADX WARN: Multi-variable type inference failed */
    public o(oh.l lVar, oh.l lVar2, int i3) {
        this.f8737a = i3;
        switch (i3) {
            case 1:
                this.f8738b = (Lambda) lVar;
                this.f8739c = (Lambda) lVar2;
                break;
            default:
                this.f8738b = (Lambda) lVar;
                this.f8739c = (Lambda) lVar2;
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.jvm.internal.Lambda, oh.l] */
    /* JADX WARN: Type inference failed for: r0v7, types: [kotlin.jvm.internal.Lambda, oh.l] */
    /* JADX WARN: Type inference failed for: r3v11, types: [kotlin.jvm.internal.Lambda, oh.l] */
    /* JADX WARN: Type inference failed for: r3v5, types: [kotlin.jvm.internal.Lambda, oh.l] */
    @Override // a5.a
    public final void a(ec ecVar) {
        eh.g gVar;
        eh.g gVar2;
        switch (this.f8737a) {
            case 0:
                Log.e("qob", "pickImageCrop onSuccess 3333333 ");
                String str = ((g5.b) ecVar).f13871b;
                if (str != null) {
                    this.f8739c.invoke(str);
                    gVar = eh.g.f12633a;
                } else {
                    gVar = null;
                }
                if (gVar == null) {
                    this.f8738b.invoke("file path is null");
                    break;
                }
                break;
            default:
                Log.e("qob", "pickImageCrop onSuccess 11111 ");
                File file = ((g5.a) ecVar).f13872a;
                if (file != null) {
                    String absolutePath = file.getAbsolutePath();
                    kotlin.jvm.internal.e.e(absolutePath, "getAbsolutePath(...)");
                    this.f8739c.invoke(absolutePath);
                    gVar2 = eh.g.f12633a;
                } else {
                    gVar2 = null;
                }
                if (gVar2 == null) {
                    this.f8738b.invoke("file path is null");
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.jvm.internal.Lambda, oh.l] */
    /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.jvm.internal.Lambda, oh.l] */
    @Override // a5.a
    public final void c(Exception exc) {
        switch (this.f8737a) {
            case 0:
                Log.e("qob", "pickImageCrop onFailed 3333333 ");
                String message = exc.getMessage();
                if (message == null) {
                    message = "pickImage unknown error";
                }
                this.f8738b.invoke(message);
                break;
            default:
                Log.e("qob", "onFailed 1111 " + exc);
                String message2 = exc.getMessage();
                if (message2 == null) {
                    message2 = "pickImage unknown error";
                }
                this.f8738b.invoke(message2);
                break;
        }
    }
}
