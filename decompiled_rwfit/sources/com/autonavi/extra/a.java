package com.autonavi.extra;

import android.content.Context;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface a {
    Object a(String str);

    String a();

    void a(Context context, IAMapDelegate iAMapDelegate, boolean z5);

    void a(IGLMapState iGLMapState, IMapConfig iMapConfig);

    void a(String str, Object obj);

    void a(JSONObject jSONObject);

    void onDestroy();

    void onSurfaceChanged(GL10 gl10, int i3, int i10);

    void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
}
