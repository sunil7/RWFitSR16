package androidx.activity.result;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f382a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f383b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d.a f384c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f385d;

    public /* synthetic */ c(f fVar, String str, d.a aVar, int i3) {
        this.f382a = i3;
        this.f385d = fVar;
        this.f383b = str;
        this.f384c = aVar;
    }

    public final void a(Object obj) {
        switch (this.f382a) {
            case 0:
                f fVar = this.f385d;
                HashMap hashMap = fVar.f392c;
                String str = this.f383b;
                Integer num = (Integer) hashMap.get(str);
                d.a aVar = this.f384c;
                if (num != null) {
                    fVar.e.add(str);
                    try {
                        fVar.b(num.intValue(), aVar, obj);
                        return;
                    } catch (Exception e) {
                        fVar.e.remove(str);
                        throw e;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + aVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            default:
                f fVar2 = this.f385d;
                HashMap hashMap2 = fVar2.f392c;
                String str2 = this.f383b;
                Integer num2 = (Integer) hashMap2.get(str2);
                d.a aVar2 = this.f384c;
                if (num2 != null) {
                    fVar2.e.add(str2);
                    try {
                        fVar2.b(num2.intValue(), aVar2, obj);
                        return;
                    } catch (Exception e10) {
                        fVar2.e.remove(str2);
                        throw e10;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + aVar2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }
    }

    public void b() {
        this.f385d.f(this.f383b);
    }
}
