package u9;

import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import java.util.Comparator;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ a f19024a = new a();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Feature feature = (Feature) obj;
        Feature feature2 = (Feature) obj2;
        Parcelable.Creator<ApiFeatureRequest> creator = ApiFeatureRequest.CREATOR;
        return !feature.b().equals(feature2.b()) ? feature.b().compareTo(feature2.b()) : (feature.h() > feature2.h() ? 1 : (feature.h() == feature2.h() ? 0 : -1));
    }
}
