package a1;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class f {
    public static Executor a(Context context) {
        return context.getMainExecutor();
    }
}
