package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.map3d.R;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapStatus;

/* loaded from: classes.dex */
public class x5 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    private Context f5334b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f5335c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f5336d;
    private ImageView e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f5337f;

    /* renamed from: g, reason: collision with root package name */
    private OfflineMapManager f5338g;

    /* renamed from: h, reason: collision with root package name */
    private OfflineMapCity f5339h;

    /* renamed from: j, reason: collision with root package name */
    private View f5341j;

    /* renamed from: k, reason: collision with root package name */
    private DownloadProgressView f5342k;

    /* renamed from: a, reason: collision with root package name */
    private int f5333a = 0;

    /* renamed from: i, reason: collision with root package name */
    private Handler f5340i = new a();

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                x5.a(x5.this, message.arg1, message.arg2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public x5(Context context, OfflineMapManager offlineMapManager) {
        this.f5334b = context;
        e();
        this.f5338g = offlineMapManager;
    }

    public static void a(x5 x5Var, int i3, int i10) throws Exception {
        if (x5Var.f5333a != 2 || i10 <= 3 || i10 >= 100) {
            x5Var.f5342k.setVisibility(8);
        } else {
            x5Var.f5342k.setVisibility(0);
            x5Var.f5342k.setProgress(i10);
        }
        if (i3 == 6) {
            x5Var.f5337f.setVisibility(8);
            x5Var.e.setVisibility(0);
            x5Var.e.setImageResource(R.drawable.amap_map3d_down);
            return;
        }
        if (i3 == 7) {
            x5Var.f5337f.setVisibility(0);
            x5Var.e.setVisibility(0);
            x5Var.e.setImageResource(R.drawable.amap_map3d_down);
            x5Var.f5337f.setText(n1.a(R.string.O105492_80));
            return;
        }
        if (i3 == -1) {
            x5Var.a();
            return;
        }
        if (i3 == 0) {
            if (x5Var.f5333a == 1) {
                x5Var.e.setVisibility(8);
                x5Var.f5337f.setText(n1.a(R.string.O105492_29));
                x5Var.f5337f.setTextColor(Color.parseColor("#4287ff"));
                return;
            } else {
                if (x5Var.f5339h == null) {
                    return;
                }
                x5Var.f5337f.setVisibility(0);
                x5Var.f5337f.setText(n1.a(R.string.O105492_29));
                x5Var.e.setVisibility(8);
                x5Var.f5337f.setTextColor(Color.parseColor("#4287ff"));
                return;
            }
        }
        if (i3 == 1) {
            if (x5Var.f5333a == 1) {
                return;
            }
            x5Var.f5337f.setVisibility(0);
            x5Var.e.setVisibility(8);
            x5Var.f5337f.setText(n1.a(R.string.O105492_75));
            x5Var.f5337f.setTextColor(Color.parseColor("#898989"));
            return;
        }
        if (i3 == 2) {
            x5Var.c();
            return;
        }
        if (i3 == 3) {
            x5Var.b();
            return;
        }
        if (i3 != 4) {
            switch (i3) {
                case 101:
                case 102:
                case OfflineMapStatus.EXCEPTION_SDCARD /* 103 */:
                    x5Var.a();
                    break;
            }
        } else {
            x5Var.f5337f.setVisibility(0);
            x5Var.e.setVisibility(8);
            x5Var.f5337f.setText(n1.a(R.string.O105492_31));
            x5Var.f5337f.setTextColor(Color.parseColor("#898989"));
        }
    }

    private void b() {
        this.f5337f.setVisibility(0);
        this.e.setVisibility(8);
        this.f5337f.setTextColor(-7829368);
        this.f5337f.setText(n1.a(R.string.O105492_30));
    }

    private void c() {
        if (this.f5333a == 1) {
            this.e.setVisibility(8);
            this.f5337f.setVisibility(0);
            this.f5337f.setText(n1.a(R.string.O105492_28));
            this.f5337f.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.f5337f.setVisibility(0);
        this.e.setVisibility(8);
        this.f5337f.setTextColor(Color.parseColor("#4287ff"));
        this.f5337f.setText(n1.a(R.string.O105492_28));
    }

    private void e() {
        View a3 = a6.a(this.f5334b, R.layout.amap_map3d_offlinemap_child, null);
        this.f5341j = a3;
        this.f5342k = (DownloadProgressView) a3.findViewById(R.id.amap_map3d_progress);
        TextView textView = (TextView) this.f5341j.findViewById(R.id.amap_map3d_name);
        this.f5335c = textView;
        textView.setText(n1.a(R.string.O105492_76));
        TextView textView2 = (TextView) this.f5341j.findViewById(R.id.amap_map3d_name_size);
        this.f5336d = textView2;
        textView2.setText(n1.a(R.string.O105492_77));
        this.e = (ImageView) this.f5341j.findViewById(R.id.amap_map3d_download_status_image);
        this.f5337f = (TextView) this.f5341j.findViewById(R.id.amap_map3d_download_progress_status);
        this.e.setOnClickListener(this);
    }

    public View d() {
        return this.f5341j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z5;
        try {
            z5 = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!v4.d(this.f5334b)) {
            Toast.makeText(this.f5334b, n1.a(R.string.O105492_289), 0).show();
            return;
        }
        OfflineMapCity offlineMapCity = this.f5339h;
        if (offlineMapCity != null) {
            int state = offlineMapCity.getState();
            this.f5339h.getcompleteCode();
            if (state == 0) {
                synchronized (this) {
                    this.f5338g.pause();
                    this.f5338g.restart();
                }
                b();
                return;
            }
            if (state == 1 || state == 4) {
                return;
            }
            synchronized (this) {
                try {
                    this.f5338g.downloadByCityName(this.f5339h.getCity());
                    z5 = true;
                } catch (AMapException e10) {
                    e10.printStackTrace();
                    Toast.makeText(this.f5334b, e10.getErrorMessage(), 0).show();
                }
            }
            if (z5) {
                c();
                return;
            } else {
                a();
                return;
            }
            e.printStackTrace();
        }
    }

    public void a(int i3) {
        this.f5333a = i3;
    }

    public void a(OfflineMapCity offlineMapCity) {
        if (offlineMapCity != null) {
            this.f5339h = offlineMapCity;
            this.f5335c.setText(offlineMapCity.getCity());
            double size = ((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d;
            if (size != 0.0d) {
                this.f5336d.setText(String.valueOf(size) + " M");
                int state = this.f5339h.getState();
                int i3 = this.f5339h.getcompleteCode();
                OfflineMapCity offlineMapCity2 = this.f5339h;
                if (offlineMapCity2 != null) {
                    offlineMapCity2.setState(state);
                    this.f5339h.setCompleteCode(i3);
                }
                Message message = new Message();
                message.arg1 = state;
                message.arg2 = i3;
                this.f5340i.sendMessage(message);
                return;
            }
            this.f5336d.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    private void a() {
        this.f5337f.setVisibility(0);
        this.e.setVisibility(8);
        this.f5337f.setTextColor(-65536);
        this.f5337f.setText(n1.a(R.string.O105492_81));
    }
}
