package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
class zzbe extends zzbr implements z {
    public zzbe(Map map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbr
    public /* bridge */ /* synthetic */ Collection zza() {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbr
    public final /* synthetic */ Collection zzb() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbr
    public final Collection zzc(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbr
    public final Collection zzd(Object obj, Collection collection) {
        return zzm(obj, (List) collection, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.z
    public final List zze(Object obj) {
        return (List) zzj(obj);
    }

    public final List zzf(@CheckForNull Object obj) {
        return (List) zzk(obj);
    }
}
