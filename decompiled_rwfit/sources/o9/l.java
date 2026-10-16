package o9;

/* loaded from: classes.dex */
public abstract class l extends com.google.android.gms.common.api.i {
    @Override // com.google.android.gms.common.api.i
    public final void registerConnectionFailedListener(com.google.android.gms.common.api.h hVar) {
        throw new UnsupportedOperationException("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    }

    @Override // com.google.android.gms.common.api.i
    public final void unregisterConnectionFailedListener(com.google.android.gms.common.api.h hVar) {
        throw new UnsupportedOperationException("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    }
}
