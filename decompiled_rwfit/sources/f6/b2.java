package f6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.view.LongClickView;
import com.example.test.ui.view.ToolBarView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;

/* loaded from: classes.dex */
public final class b2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f12716a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f12717b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f12718c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f12719d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f12720f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f12721g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f12722h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f12723i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f12724j;

    /* renamed from: k, reason: collision with root package name */
    public final LongClickView f12725k;

    /* renamed from: l, reason: collision with root package name */
    public final LongClickView f12726l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayout f12727m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f12728n;

    /* renamed from: o, reason: collision with root package name */
    public final ToolBarView f12729o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f12730p;

    /* renamed from: q, reason: collision with root package name */
    public final ImageView f12731q;

    public b2(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, LinearLayout linearLayout, TextView textView5, ImageView imageView2, ImageView imageView3, LongClickView longClickView, LongClickView longClickView2, LinearLayout linearLayout2, ImageView imageView4, ToolBarView toolBarView, TextView textView6, ImageView imageView5) {
        this.f12716a = constraintLayout;
        this.f12717b = textView;
        this.f12718c = textView2;
        this.f12719d = textView3;
        this.e = textView4;
        this.f12720f = imageView;
        this.f12721g = linearLayout;
        this.f12722h = textView5;
        this.f12723i = imageView2;
        this.f12724j = imageView3;
        this.f12725k = longClickView;
        this.f12726l = longClickView2;
        this.f12727m = linearLayout2;
        this.f12728n = imageView4;
        this.f12729o = toolBarView;
        this.f12730p = textView6;
        this.f12731q = imageView5;
    }

    public static b2 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_sport_detail, (ViewGroup) null, false);
        int i3 = R$id.caloriesTv;
        TextView textView = (TextView) he.a(i3, inflate);
        if (textView != null) {
            i3 = R$id.cancelTips;
            if (((TextView) he.a(i3, inflate)) != null) {
                i3 = R$id.continueTips;
                if (((TextView) he.a(i3, inflate)) != null) {
                    i3 = R$id.currentPaceTv;
                    TextView textView2 = (TextView) he.a(i3, inflate);
                    if (textView2 != null) {
                        i3 = R$id.data;
                        if (((ConstraintLayout) he.a(i3, inflate)) != null) {
                            i3 = R$id.distanceTv;
                            TextView textView3 = (TextView) he.a(i3, inflate);
                            if (textView3 != null) {
                                i3 = R$id.distanceUnitTv;
                                TextView textView4 = (TextView) he.a(i3, inflate);
                                if (textView4 != null) {
                                    i3 = R$id.ivLock;
                                    ImageView imageView = (ImageView) he.a(i3, inflate);
                                    if (imageView != null) {
                                        i3 = R$id.ll_data;
                                        if (((LinearLayout) he.a(i3, inflate)) != null) {
                                            i3 = R$id.ll_kcal;
                                            if (((LinearLayout) he.a(i3, inflate)) != null) {
                                                i3 = R$id.ll_pics;
                                                if (((LinearLayout) he.a(i3, inflate)) != null) {
                                                    i3 = R$id.ll_time;
                                                    if (((LinearLayout) he.a(i3, inflate)) != null) {
                                                        i3 = R$id.llTips;
                                                        LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                                                        if (linearLayout != null) {
                                                            i3 = R$id.longTips;
                                                            TextView textView5 = (TextView) he.a(i3, inflate);
                                                            if (textView5 != null) {
                                                                i3 = R$id.pauseBtn;
                                                                ImageView imageView2 = (ImageView) he.a(i3, inflate);
                                                                if (imageView2 != null) {
                                                                    i3 = R$id.playBtn;
                                                                    ImageView imageView3 = (ImageView) he.a(i3, inflate);
                                                                    if (imageView3 != null) {
                                                                        i3 = R$id.progressView;
                                                                        LongClickView longClickView = (LongClickView) he.a(i3, inflate);
                                                                        if (longClickView != null) {
                                                                            i3 = R$id.progressViewCancel;
                                                                            LongClickView longClickView2 = (LongClickView) he.a(i3, inflate);
                                                                            if (longClickView2 != null) {
                                                                                i3 = R$id.sportPauseLl;
                                                                                LinearLayout linearLayout2 = (LinearLayout) he.a(i3, inflate);
                                                                                if (linearLayout2 != null) {
                                                                                    i3 = R$id.stopBtn;
                                                                                    ImageView imageView4 = (ImageView) he.a(i3, inflate);
                                                                                    if (imageView4 != null) {
                                                                                        i3 = R$id.toolbar;
                                                                                        ToolBarView toolBarView = (ToolBarView) he.a(i3, inflate);
                                                                                        if (toolBarView != null) {
                                                                                            i3 = R$id.totalTimeTv;
                                                                                            TextView textView6 = (TextView) he.a(i3, inflate);
                                                                                            if (textView6 != null) {
                                                                                                i3 = R$id.tvMap;
                                                                                                ImageView imageView5 = (ImageView) he.a(i3, inflate);
                                                                                                if (imageView5 != null) {
                                                                                                    return new b2((ConstraintLayout) inflate, textView, textView2, textView3, textView4, imageView, linearLayout, textView5, imageView2, imageView3, longClickView, longClickView2, linearLayout2, imageView4, toolBarView, textView6, imageView5);
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
        return this.f12716a;
    }
}
