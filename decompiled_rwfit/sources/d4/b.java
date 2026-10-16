package d4;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12240a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12241b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f12242c;

    public /* synthetic */ b(int i3, Object obj, Object obj2) {
        this.f12240a = i3;
        this.f12241b = obj;
        this.f12242c = obj2;
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [d4.a, java.lang.Object] */
    @Override // d4.q
    public final p a(Object obj, int i3, int i10, x3.f fVar) {
        p a3;
        Uri uri;
        switch (this.f12240a) {
            case 0:
                Uri uri2 = (Uri) obj;
                return new p(new s4.d(uri2), this.f12242c.i((AssetManager) this.f12241b, uri2.toString().substring(22)));
            case 1:
                ArrayList arrayList = (ArrayList) this.f12241b;
                int size = arrayList.size();
                ArrayList arrayList2 = new ArrayList(size);
                x3.c cVar = null;
                for (int i11 = 0; i11 < size; i11++) {
                    q qVar = (q) arrayList.get(i11);
                    if (qVar.b(obj) && (a3 = qVar.a(obj, i3, i10, fVar)) != null) {
                        arrayList2.add(a3.f12282c);
                        cVar = a3.f12280a;
                    }
                }
                if (arrayList2.isEmpty() || cVar == null) {
                    return null;
                }
                return new p(cVar, new v(arrayList2, (n.l) this.f12242c));
            default:
                Integer num = (Integer) obj;
                Resources resources = (Resources) this.f12242c;
                try {
                    uri = Uri.parse("android.resource://" + resources.getResourcePackageName(num.intValue()) + '/' + resources.getResourceTypeName(num.intValue()) + '/' + resources.getResourceEntryName(num.intValue()));
                } catch (Resources.NotFoundException e) {
                    if (Log.isLoggable("ResourceLoader", 5)) {
                        Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
                    }
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((q) this.f12241b).a(uri, i3, i10, fVar);
        }
    }

    @Override // d4.q
    public final boolean b(Object obj) {
        switch (this.f12240a) {
            case 0:
                Uri uri = (Uri) obj;
                return Const.STR_FILE.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
            case 1:
                ArrayList arrayList = (ArrayList) this.f12241b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    if (((q) obj2).b(obj)) {
                        return true;
                    }
                }
                return false;
            default:
                return true;
        }
    }

    public String toString() {
        switch (this.f12240a) {
            case 1:
                return "MultiModelLoader{modelLoaders=" + Arrays.toString(((ArrayList) this.f12241b).toArray()) + '}';
            default:
                return super.toString();
        }
    }

    public b(Resources resources, q qVar) {
        this.f12240a = 2;
        this.f12242c = resources;
        this.f12241b = qVar;
    }
}
