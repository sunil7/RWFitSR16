package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amap.api.map3d.R;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* loaded from: classes.dex */
public class v5 extends w5 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private OfflineMapManager f5182a;

    /* renamed from: b, reason: collision with root package name */
    private View f5183b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f5184c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f5185d;
    private TextView e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f5186f;

    /* renamed from: g, reason: collision with root package name */
    private int f5187g;

    /* renamed from: h, reason: collision with root package name */
    private String f5188h;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v5.this.dismiss();
        }
    }

    public v5(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.f5182a = offlineMapManager;
    }

    public void a(int i3, String str) {
        this.f5184c.setText(str);
        if (i3 == 0) {
            this.f5185d.setText(n1.a(R.string.O105492_25));
            this.f5185d.setVisibility(0);
            this.e.setText(n1.a(R.string.O105492_24));
        }
        if (i3 == 2) {
            this.f5185d.setVisibility(8);
            this.e.setText(n1.a(R.string.O105492_24));
        } else if (i3 == -1 || i3 == 101 || i3 == 102 || i3 == 103) {
            this.f5185d.setText(n1.a(R.string.O105492_27));
            this.f5185d.setVisibility(0);
        } else if (i3 == 3) {
            this.f5185d.setVisibility(0);
            this.f5185d.setText(n1.a(R.string.O105492_27));
            this.e.setText(n1.a(R.string.O105492_24));
        } else if (i3 == 4) {
            this.e.setText(n1.a(R.string.O105492_23));
            this.f5185d.setVisibility(8);
        }
        this.f5187g = i3;
        this.f5188h = str;
    }

    @Override // com.amap.api.col.p0003sl.w5
    public void b() {
        View a3 = a6.a(getContext(), R.layout.amap_map3d_mapdialog_layout, null);
        this.f5183b = a3;
        setContentView(a3);
        this.f5183b.setOnClickListener(new a());
        TextView textView = (TextView) this.f5183b.findViewById(R.id.amap_map3d_dialog_title);
        this.f5184c = textView;
        textView.setText(n1.a(R.string.O105492_83));
        TextView textView2 = (TextView) this.f5183b.findViewById(R.id.amap_map3d_dialog_status);
        this.f5185d = textView2;
        textView2.setText(n1.a(R.string.O105492_30));
        TextView textView3 = (TextView) this.f5183b.findViewById(R.id.amap_map3d_dialog_delete);
        this.e = textView3;
        textView3.setText(n1.a(R.string.O105492_24));
        TextView textView4 = (TextView) this.f5183b.findViewById(R.id.amap_map3d_dialog_cancle);
        this.f5186f = textView4;
        textView4.setText(n1.a(R.string.O105492_22));
        this.f5185d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f5186f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            int id2 = view.getId();
            if (id2 != R.id.amap_map3d_dialog_status) {
                if (id2 != R.id.amap_map3d_dialog_delete) {
                    if (id2 == R.id.amap_map3d_dialog_cancle) {
                        dismiss();
                        return;
                    }
                    return;
                } else {
                    if (TextUtils.isEmpty(this.f5188h)) {
                        return;
                    }
                    this.f5182a.remove(this.f5188h);
                    dismiss();
                    return;
                }
            }
            int i3 = this.f5187g;
            if (i3 == 0) {
                this.f5185d.setText(n1.a(R.string.O105492_27));
                this.f5182a.pauseByName(this.f5188h);
            } else if (i3 == 3 || i3 == -1 || i3 == 101 || i3 == 102 || i3 == 103) {
                this.f5185d.setText(n1.a(R.string.O105492_25));
                this.f5182a.downloadByCityName(this.f5188h);
            }
            dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
