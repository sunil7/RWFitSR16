package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import com.autonavi.aps.amapapi.config.Const;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i implements g {

    /* renamed from: c, reason: collision with root package name */
    public static final h f6968c = new h(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6969a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6970b;

    public i() {
        this.f6969a = 0;
        this.f6970b = new HashMap();
    }

    private final void a() {
    }

    private final void c() {
    }

    @Override // com.bumptech.glide.load.data.g
    public void b() {
        switch (this.f6969a) {
            case 1:
            case 2:
                break;
            default:
                ((com.bumptech.glide.load.resource.bitmap.a) this.f6970b).c();
                break;
        }
    }

    public ParcelFileDescriptor d() {
        return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f6970b).rewind();
    }

    @Override // com.bumptech.glide.load.data.g
    public Object m() {
        switch (this.f6969a) {
            case 1:
                return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f6970b).rewind();
            case 2:
                return this.f6970b;
            default:
                com.bumptech.glide.load.resource.bitmap.a aVar = (com.bumptech.glide.load.resource.bitmap.a) this.f6970b;
                aVar.reset();
                return aVar;
        }
    }

    public i(InputStream inputStream, a4.g gVar) {
        this.f6969a = 3;
        com.bumptech.glide.load.resource.bitmap.a aVar = new com.bumptech.glide.load.resource.bitmap.a(inputStream, gVar);
        this.f6970b = aVar;
        aVar.mark(Const.MAX_SIZE_WRAPDATA);
    }

    public i(ParcelFileDescriptor parcelFileDescriptor) {
        this.f6969a = 1;
        this.f6970b = new ParcelFileDescriptorRewinder$InternalRewinder(parcelFileDescriptor);
    }

    public i(Object obj) {
        this.f6969a = 2;
        this.f6970b = obj;
    }
}
