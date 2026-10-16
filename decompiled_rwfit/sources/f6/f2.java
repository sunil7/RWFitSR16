package f6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.amap.api.maps.MapView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.view.MapContainer;
import com.example.test.ui.view.TitleView;
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.gms.internal.mlkit_vision_barcode.he;

/* loaded from: classes.dex */
public final class f2 implements m2.a {
    public final TextView A;

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12854a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f12855b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f12856c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f12857d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final NestedScrollView f12858f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f12859g;

    /* renamed from: h, reason: collision with root package name */
    public final LinearLayout f12860h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f12861i;

    /* renamed from: j, reason: collision with root package name */
    public final LineChart f12862j;

    /* renamed from: k, reason: collision with root package name */
    public final LinearLayout f12863k;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayout f12864l;

    /* renamed from: m, reason: collision with root package name */
    public final MapContainer f12865m;

    /* renamed from: n, reason: collision with root package name */
    public final MapView f12866n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f12867o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f12868p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f12869q;
    public final TextView r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f12870s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f12871t;

    /* renamed from: u, reason: collision with root package name */
    public final LinearLayout f12872u;

    /* renamed from: v, reason: collision with root package name */
    public final ImageView f12873v;

    /* renamed from: w, reason: collision with root package name */
    public final LinearLayout f12874w;

    /* renamed from: x, reason: collision with root package name */
    public final LinearLayout f12875x;

    /* renamed from: y, reason: collision with root package name */
    public final TextView f12876y;

    /* renamed from: z, reason: collision with root package name */
    public final TitleView f12877z;

    public f2(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, NestedScrollView nestedScrollView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView5, LineChart lineChart, LinearLayout linearLayout4, LinearLayout linearLayout5, MapContainer mapContainer, MapView mapView, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, LinearLayout linearLayout6, ImageView imageView, LinearLayout linearLayout7, LinearLayout linearLayout8, TextView textView12, TitleView titleView, TextView textView13) {
        this.f12854a = linearLayout;
        this.f12855b = textView;
        this.f12856c = textView2;
        this.f12857d = textView3;
        this.e = textView4;
        this.f12858f = nestedScrollView;
        this.f12859g = linearLayout2;
        this.f12860h = linearLayout3;
        this.f12861i = textView5;
        this.f12862j = lineChart;
        this.f12863k = linearLayout4;
        this.f12864l = linearLayout5;
        this.f12865m = mapContainer;
        this.f12866n = mapView;
        this.f12867o = textView6;
        this.f12868p = textView7;
        this.f12869q = textView8;
        this.r = textView9;
        this.f12870s = textView10;
        this.f12871t = textView11;
        this.f12872u = linearLayout6;
        this.f12873v = imageView;
        this.f12874w = linearLayout7;
        this.f12875x = linearLayout8;
        this.f12876y = textView12;
        this.f12877z = titleView;
        this.A = textView13;
    }

    public static f2 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_sport_record_detail, (ViewGroup) null, false);
        int i3 = R$id.avgHr;
        TextView textView = (TextView) he.a(i3, inflate);
        if (textView != null) {
            i3 = R$id.avgPace;
            TextView textView2 = (TextView) he.a(i3, inflate);
            if (textView2 != null) {
                i3 = R$id.avgStep;
                TextView textView3 = (TextView) he.a(i3, inflate);
                if (textView3 != null) {
                    i3 = R$id.caloriesTv;
                    TextView textView4 = (TextView) he.a(i3, inflate);
                    if (textView4 != null) {
                        i3 = R$id.content;
                        NestedScrollView nestedScrollView = (NestedScrollView) he.a(i3, inflate);
                        if (nestedScrollView != null) {
                            i3 = R$id.distance_layout;
                            LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                            if (linearLayout != null) {
                                i3 = R$id.distance_step_layout;
                                LinearLayout linearLayout2 = (LinearLayout) he.a(i3, inflate);
                                if (linearLayout2 != null) {
                                    i3 = R$id.distanceTv;
                                    TextView textView5 = (TextView) he.a(i3, inflate);
                                    if (textView5 != null) {
                                        i3 = R$id.hrChart;
                                        LineChart lineChart = (LineChart) he.a(i3, inflate);
                                        if (lineChart != null) {
                                            i3 = R$id.hr_layout;
                                            LinearLayout linearLayout3 = (LinearLayout) he.a(i3, inflate);
                                            if (linearLayout3 != null) {
                                                i3 = R$id.hrLl;
                                                LinearLayout linearLayout4 = (LinearLayout) he.a(i3, inflate);
                                                if (linearLayout4 != null) {
                                                    i3 = R$id.mapContainer;
                                                    MapContainer mapContainer = (MapContainer) he.a(i3, inflate);
                                                    if (mapContainer != null) {
                                                        i3 = R$id.mapView;
                                                        MapView mapView = (MapView) he.a(i3, inflate);
                                                        if (mapView != null) {
                                                            i3 = R$id.maxHr;
                                                            TextView textView6 = (TextView) he.a(i3, inflate);
                                                            if (textView6 != null) {
                                                                i3 = R$id.maxPace;
                                                                TextView textView7 = (TextView) he.a(i3, inflate);
                                                                if (textView7 != null) {
                                                                    i3 = R$id.maxStep;
                                                                    TextView textView8 = (TextView) he.a(i3, inflate);
                                                                    if (textView8 != null) {
                                                                        i3 = R$id.minHr;
                                                                        TextView textView9 = (TextView) he.a(i3, inflate);
                                                                        if (textView9 != null) {
                                                                            i3 = R$id.minPace;
                                                                            TextView textView10 = (TextView) he.a(i3, inflate);
                                                                            if (textView10 != null) {
                                                                                i3 = R$id.minStep;
                                                                                TextView textView11 = (TextView) he.a(i3, inflate);
                                                                                if (textView11 != null) {
                                                                                    i3 = R$id.pace_layout;
                                                                                    LinearLayout linearLayout5 = (LinearLayout) he.a(i3, inflate);
                                                                                    if (linearLayout5 != null) {
                                                                                        i3 = R$id.sportIv;
                                                                                        ImageView imageView = (ImageView) he.a(i3, inflate);
                                                                                        if (imageView != null) {
                                                                                            i3 = R$id.step_count_layout;
                                                                                            LinearLayout linearLayout6 = (LinearLayout) he.a(i3, inflate);
                                                                                            if (linearLayout6 != null) {
                                                                                                i3 = R$id.step_layout;
                                                                                                LinearLayout linearLayout7 = (LinearLayout) he.a(i3, inflate);
                                                                                                if (linearLayout7 != null) {
                                                                                                    i3 = R$id.stepsTv;
                                                                                                    TextView textView12 = (TextView) he.a(i3, inflate);
                                                                                                    if (textView12 != null) {
                                                                                                        i3 = R$id.titleView;
                                                                                                        TitleView titleView = (TitleView) he.a(i3, inflate);
                                                                                                        if (titleView != null) {
                                                                                                            i3 = R$id.totalTimeTv;
                                                                                                            TextView textView13 = (TextView) he.a(i3, inflate);
                                                                                                            if (textView13 != null) {
                                                                                                                return new f2((LinearLayout) inflate, textView, textView2, textView3, textView4, nestedScrollView, linearLayout, linearLayout2, textView5, lineChart, linearLayout3, linearLayout4, mapContainer, mapView, textView6, textView7, textView8, textView9, textView10, textView11, linearLayout5, imageView, linearLayout6, linearLayout7, textView12, titleView, textView13);
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // m2.a
    public final View b() {
        return this.f12854a;
    }
}
