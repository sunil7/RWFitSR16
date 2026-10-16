package da;

import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f12314a;

    static {
        f12314a = Build.VERSION.SDK_INT >= 31 ? Const.FLAG_MUTABLE : 0;
    }
}
