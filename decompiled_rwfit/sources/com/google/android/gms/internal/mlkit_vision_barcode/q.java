package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class q implements Map.Entry {
    @Override // java.util.Map.Entry
    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (na.a(getKey(), entry.getKey()) && na.a(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        Object value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public final String toString() {
        return r5.a.c(String.valueOf(getKey()), "=", String.valueOf(getValue()));
    }
}
