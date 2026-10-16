package androidx.activity;

import android.os.Bundle;
import androidx.lifecycle.h0;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements e2.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f356a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f357b;

    public /* synthetic */ c(Object obj, int i3) {
        this.f356a = i3;
        this.f357b = obj;
    }

    @Override // e2.c
    public final Bundle a() {
        Object obj = this.f357b;
        switch (this.f356a) {
            case 0:
                int i3 = ComponentActivity.r;
                Bundle bundle = new Bundle();
                g gVar = ((ComponentActivity) obj).f338j;
                gVar.getClass();
                HashMap hashMap = gVar.f392c;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(hashMap.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(hashMap.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(gVar.e));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) gVar.f396h.clone());
                bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", gVar.f390a);
                return bundle;
            default:
                return h0.a((h0) obj);
        }
    }
}
