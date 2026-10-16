package ic;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;
import com.google.android.gms.common.api.j;
import java.io.Closeable;

/* loaded from: classes.dex */
public interface a extends Closeable, r, j {
    @d0(Lifecycle$Event.ON_DESTROY)
    void close();
}
