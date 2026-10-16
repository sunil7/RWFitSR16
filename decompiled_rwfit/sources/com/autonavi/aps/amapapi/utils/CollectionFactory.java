package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import com.autonavi.aps.amapapi.CollectionManager;
import com.autonavi.aps.amapapi.ICollectionManager;

/* loaded from: classes.dex */
public class CollectionFactory {
    public static ICollectionManager getCollectionManager(Context context) {
        return new CollectionManager(context);
    }
}
