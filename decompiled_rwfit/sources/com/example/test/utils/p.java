package com.example.test.utils;

import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode.ec;
import java.io.File;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class p implements a5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8740a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lambda f8741b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Lambda f8742c;

    /* JADX WARN: Multi-variable type inference failed */
    public p(oh.l lVar, oh.l lVar2, int i3) {
        this.f8740a = i3;
        switch (i3) {
            case 1:
                this.f8741b = (Lambda) lVar;
                this.f8742c = (Lambda) lVar2;
                break;
            default:
                this.f8741b = (Lambda) lVar;
                this.f8742c = (Lambda) lVar2;
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.jvm.internal.Lambda, oh.l] */
    /* JADX WARN: Type inference failed for: r0v7, types: [kotlin.jvm.internal.Lambda, oh.l] */
    /* JADX WARN: Type inference failed for: r3v12, types: [kotlin.jvm.internal.Lambda, oh.l] */
    /* JADX WARN: Type inference failed for: r3v5, types: [kotlin.jvm.internal.Lambda, oh.l] */
    @Override // a5.a
    public final void a(ec ecVar) {
        eh.g gVar;
        eh.g gVar2;
        switch (this.f8740a) {
            case 0:
                Log.e("qob", "pickImageCrop 22222 onSuccess ");
                File file = ((g5.a) ecVar).f13872a;
                if (file != null) {
                    String absolutePath = file.getAbsolutePath();
                    kotlin.jvm.internal.e.e(absolutePath, "getAbsolutePath(...)");
                    this.f8742c.invoke(absolutePath);
                    gVar = eh.g.f12633a;
                } else {
                    gVar = null;
                }
                if (gVar == null) {
                    this.f8741b.invoke("file path is null");
                    break;
                }
                break;
            default:
                File file2 = ((g5.a) ecVar).f13872a;
                if (file2 != null) {
                    String absolutePath2 = file2.getAbsolutePath();
                    kotlin.jvm.internal.e.e(absolutePath2, "getAbsolutePath(...)");
                    this.f8742c.invoke(absolutePath2);
                    gVar2 = eh.g.f12633a;
                } else {
                    gVar2 = null;
                }
                if (gVar2 == null) {
                    this.f8741b.invoke("file path is null");
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.jvm.internal.Lambda, oh.l] */
    /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.jvm.internal.Lambda, oh.l] */
    @Override // a5.a
    public final void c(Exception exc) {
        switch (this.f8740a) {
            case 0:
                Log.e("qob", "pickImageCrop 2222 onFailed " + exc);
                String message = exc.getMessage();
                if (message == null) {
                    message = "pickImage unknown error";
                }
                this.f8741b.invoke(message);
                break;
            default:
                String message2 = exc.getMessage();
                if (message2 == null) {
                    message2 = "pickImage unknown error";
                }
                this.f8741b.invoke(message2);
                break;
        }
    }
}
