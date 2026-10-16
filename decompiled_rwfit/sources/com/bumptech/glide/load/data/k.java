package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class k extends b {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(AssetManager assetManager, String str, int i3) {
        super(0, str, assetManager);
        this.e = i3;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.e) {
            case 0:
                return ParcelFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.b
    public final void g(Object obj) {
        switch (this.e) {
            case 0:
                ((ParcelFileDescriptor) obj).close();
                break;
            default:
                ((InputStream) obj).close();
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.b
    public final Object i(AssetManager assetManager, String str) {
        switch (this.e) {
            case 0:
                return assetManager.openFd(str).getParcelFileDescriptor();
            default:
                return assetManager.open(str);
        }
    }
}
