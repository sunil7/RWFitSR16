package ob;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public interface a extends Future {
    void a(Runnable runnable, Executor executor);
}
