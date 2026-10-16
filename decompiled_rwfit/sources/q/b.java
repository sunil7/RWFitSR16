package q;

import androidx.camera.core.impl.g0;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f17606a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17607b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17608c;

    public boolean a() {
        return (this.f17608c || this.f17607b) && this.f17606a;
    }

    public void b(ArrayList arrayList) {
        if ((this.f17606a || this.f17607b || this.f17608c) && arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((g0) obj).a();
            }
            a0.a("ForceCloseDeferrableSurface", "deferrableSurface closed");
        }
    }
}
