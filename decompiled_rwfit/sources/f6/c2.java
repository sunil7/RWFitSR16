package f6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.maps.MapView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.view.SportDataView;
import com.example.test.ui.view.SportNewDataView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;

/* loaded from: classes.dex */
public final class c2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f12762a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f12763b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f12764c;

    /* renamed from: d, reason: collision with root package name */
    public final MapView f12765d;
    public final SportDataView e;

    /* renamed from: f, reason: collision with root package name */
    public final SportNewDataView f12766f;

    public c2(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, MapView mapView, SportDataView sportDataView, SportNewDataView sportNewDataView) {
        this.f12762a = constraintLayout;
        this.f12763b = imageView;
        this.f12764c = imageView2;
        this.f12765d = mapView;
        this.e = sportDataView;
        this.f12766f = sportNewDataView;
    }

    public static c2 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_sport_map, (ViewGroup) null, false);
        int i3 = R$id.mapBackIv;
        ImageView imageView = (ImageView) he.a(i3, inflate);
        if (imageView != null) {
            i3 = R$id.mapLocationIv;
            ImageView imageView2 = (ImageView) he.a(i3, inflate);
            if (imageView2 != null) {
                i3 = R$id.mapView;
                MapView mapView = (MapView) he.a(i3, inflate);
                if (mapView != null) {
                    i3 = R$id.sportDataView;
                    SportDataView sportDataView = (SportDataView) he.a(i3, inflate);
                    if (sportDataView != null) {
                        i3 = R$id.sportNewDataView;
                        SportNewDataView sportNewDataView = (SportNewDataView) he.a(i3, inflate);
                        if (sportNewDataView != null) {
                            return new c2((ConstraintLayout) inflate, imageView, imageView2, mapView, sportDataView, sportNewDataView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // m2.a
    public final View b() {
        return this.f12762a;
    }
}
