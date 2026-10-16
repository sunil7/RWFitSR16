package c;

import androidx.activity.ComponentActivity;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f3277a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public volatile ComponentActivity f3278b;

    public void addOnContextAvailableListener(c cVar) {
        if (this.f3278b != null) {
            cVar.a();
        }
        this.f3277a.add(cVar);
    }

    public void removeOnContextAvailableListener(c cVar) {
        this.f3277a.remove(cVar);
    }
}
