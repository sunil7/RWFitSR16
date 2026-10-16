package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import com.example.test.ui.device.activity.f0;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class h implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6967a;

    public /* synthetic */ h(int i3) {
        this.f6967a = i3;
    }

    @Override // com.bumptech.glide.load.data.f
    public final Class a() {
        switch (this.f6967a) {
            case 0:
                throw new UnsupportedOperationException("Not implemented");
            case 1:
                return ParcelFileDescriptor.class;
            default:
                return ByteBuffer.class;
        }
    }

    @Override // com.bumptech.glide.load.data.f
    public final g b(Object obj) {
        switch (this.f6967a) {
            case 0:
                return new i(obj);
            case 1:
                return new i((ParcelFileDescriptor) obj);
            default:
                return new f0((ByteBuffer) obj, 19);
        }
    }
}
