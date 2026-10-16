package com.autonavi.extra;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f6849a = new ArrayList();

    public void a(a aVar) {
        synchronized (b.class) {
            try {
                List<a> list = this.f6849a;
                if (list != null) {
                    list.add(null);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b() {
        synchronized (b.class) {
            try {
                for (a aVar : this.f6849a) {
                    if (aVar != null) {
                        aVar.onDestroy();
                    }
                }
                this.f6849a.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(Context context, IAMapDelegate iAMapDelegate, boolean z5) {
        synchronized (b.class) {
            try {
                for (a aVar : this.f6849a) {
                    if (aVar != null) {
                        aVar.a(context, iAMapDelegate, z5);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(GL10 gl10, EGLConfig eGLConfig) {
        synchronized (b.class) {
            try {
                for (a aVar : this.f6849a) {
                    if (aVar != null) {
                        aVar.onSurfaceCreated(gl10, eGLConfig);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(GL10 gl10, int i3, int i10) {
        synchronized (b.class) {
            try {
                for (a aVar : this.f6849a) {
                    if (aVar != null) {
                        aVar.onSurfaceChanged(gl10, i3, i10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(IGLMapState iGLMapState, IMapConfig iMapConfig) {
        synchronized (b.class) {
            try {
                for (a aVar : this.f6849a) {
                    if (aVar != null) {
                        aVar.a(iGLMapState, iMapConfig);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String a() {
        String stringBuffer;
        synchronized (b.class) {
            try {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (a aVar : this.f6849a) {
                    if (aVar != null) {
                        String a3 = aVar.a();
                        if (!TextUtils.isEmpty(a3)) {
                            stringBuffer2.append(a3);
                            if (!a3.endsWith(Const.STR_MART_SEMICOLON)) {
                                stringBuffer2.append(Const.STR_MART_SEMICOLON);
                            }
                        }
                    }
                }
                stringBuffer = stringBuffer2.toString();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return stringBuffer;
    }

    public void a(JSONObject jSONObject) {
        synchronized (b.class) {
            try {
                for (a aVar : this.f6849a) {
                    if (aVar != null) {
                        aVar.a(jSONObject);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(String str, Object obj) {
        synchronized (b.class) {
            try {
                for (a aVar : this.f6849a) {
                    if (aVar != null) {
                        aVar.a(str, obj);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Object a(String str) {
        Object a3;
        synchronized (b.class) {
            try {
                for (a aVar : this.f6849a) {
                    if (aVar != null && (a3 = aVar.a(str)) != null) {
                        return a3;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
