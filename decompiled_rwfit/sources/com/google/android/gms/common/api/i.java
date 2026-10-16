package com.google.android.gms.common.api;

import java.util.Collections;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class i {
    static {
        Collections.newSetFromMap(new WeakHashMap());
    }

    public abstract void registerConnectionFailedListener(h hVar);

    public abstract void unregisterConnectionFailedListener(h hVar);
}
