package r6;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.database.table.User;
import com.example.network.bean.DialBean;
import com.example.test.R$array;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.device.model.DeviceOptionModel;
import com.example.test.ui.device.model.DialInfoModel;
import com.example.test.ui.device.model.DialModel;
import com.example.test.ui.sport.model.SportRecordModel;
import com.example.test.ui.view.DialItemView;
import com.example.test.ui.view.DialMarketView;
import com.example.test.utils.k;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import java.util.List;
import java.util.Locale;
import kotlin.collections.i;

/* loaded from: classes.dex */
public final class a extends BaseItemProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18092a;

    public /* synthetic */ a(int i3) {
        this.f18092a = i3;
    }

    private final void b(BaseViewHolder baseViewHolder, Object obj) {
        float f2;
        User d5;
        long j4;
        double d8;
        String string;
        User d10;
        double b3;
        String string2;
        h6.b detailBean = ((SportRecordModel) obj).getDetailBean();
        if (detailBean != null) {
            Log.e("qob", "convert getFrom " + detailBean.f14287x + " getSportType " + detailBean.f14267b);
            int i3 = detailBean.f14287x;
            if (i3 <= 0 || i3 >= 9) {
                f2 = 100.0f;
                int i10 = detailBean.f14267b;
                if (i10 == 5) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_run);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_running_outdoor);
                    baseViewHolder.setVisible(R$id.tv_distance, true);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                } else if (i10 == 7) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_walk);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_walking);
                    baseViewHolder.setVisible(R$id.tv_distance, true);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                } else if (i10 == 2) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_bike);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_biking);
                    baseViewHolder.setVisible(R$id.tv_distance, true);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                } else if (i10 == 14) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_clim);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_climing);
                    baseViewHolder.setVisible(R$id.tv_distance, true);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                } else if (i10 == 6) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_tennis);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_tennis);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 9) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_yoga);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_yoga);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 11) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_basketball);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_basketball);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 13) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_football);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_football);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 10) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_badminton);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_badminton);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 12) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_skipping_rope);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_jumprope);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 16) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_free_exercise);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_free_exercise);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 17) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_ballet);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_ballet);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 18) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_golf);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_golf);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 19) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_square_dance);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_square_dance);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 20) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_baseball);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_baseball);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 21) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_rugby);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_rugby);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 22) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_poppy_jump);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_poppy_jump);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 23) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_elliptical_machine);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_elliptical_machine);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 24) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_fitness);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_fitness);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 25) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_kayak);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_kayak);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 26) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_on_foot);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_on_foot);
                    baseViewHolder.setVisible(R$id.tv_distance, true);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                } else if (i10 == 27) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_water_sports);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_snow_sports);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 28) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_paddle_board);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_paddle_board);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 29) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_pilates);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_pilates);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 30) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_roller_skating);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_roller_skating);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 31) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_boating);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_boating);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 32) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_sailboat);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sailboat);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 33) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_skateboard);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_skateboard);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 34) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_strench);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_stretch);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else if (i10 == 35) {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_water_polo);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_water_polo);
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                    baseViewHolder.setVisible(R$id.ll_pace, false);
                } else {
                    baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_run);
                    baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_running_indoor);
                    baseViewHolder.setVisible(R$id.tv_distance, true);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                }
            } else {
                baseViewHolder.setImageResource(R$id.sport_icon, ca.d(this.context, detailBean.f14267b));
                int i11 = R$id.tv_sport_type;
                int i12 = detailBean.f14267b;
                Context context = this.context;
                kotlin.jvm.internal.e.f(context, "context");
                String[] stringArray = context.getResources().getStringArray(R$array.jlrunning_string_array);
                kotlin.jvm.internal.e.e(stringArray, "getStringArray(...)");
                String str = stringArray[i12];
                kotlin.jvm.internal.e.e(str, "get(...)");
                baseViewHolder.setText(i11, str);
                if (detailBean.f14288y < 4) {
                    baseViewHolder.setVisible(R$id.tv_distance, true);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                    if (k.f8731b == null) {
                        synchronized (k.class) {
                            k.f8731b = new k();
                        }
                    }
                    k kVar = k.f8731b;
                    if (kVar == null || (d10 = kVar.d()) == null) {
                        f2 = 100.0f;
                    } else {
                        if (d10.getMeterUnit() == 0) {
                            b3 = detailBean.f14268c / 1000.0d;
                            string2 = this.context.getString(R$string.str_km);
                        } else {
                            b3 = v1.b((float) detailBean.f14268c);
                            string2 = this.context.getString(R$string.str_mile);
                        }
                        f2 = 100.0f;
                        baseViewHolder.setText(R$id.tv_distance, String.format(Locale.ENGLISH, "%.2f", Float.valueOf(((int) (((float) b3) * 100)) / 100.0f)));
                        baseViewHolder.setText(R$id.tv_distance_unit, string2);
                    }
                } else {
                    f2 = 100.0f;
                    baseViewHolder.setVisible(R$id.tv_distance, false);
                    baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                }
                baseViewHolder.setImageResource(R$id.sport_icon, this.context.getResources().getIdentifier("jlrunning_" + detailBean.f14267b, "mipmap", this.context.getPackageName()));
            }
            baseViewHolder.setText(R$id.tv_date, ca.i(detailBean.f14269d * 1000, "yyyy/MM/dd HH:mm:ss"));
            int i13 = R$id.tv_calorie;
            Locale locale = Locale.ENGLISH;
            baseViewHolder.setText(i13, String.format(locale, "%.1f KCAL", Float.valueOf(((int) ((((float) detailBean.f14271g) / 1000.0f) * 10)) / 10.0f)));
            baseViewHolder.setText(R$id.tv_time, String.format(locale, "%02d:%02d:%02d", Long.valueOf(detailBean.e / 3600), Long.valueOf((detailBean.e % 3600) / 60), Long.valueOf((detailBean.e % 3600) % 60)));
            baseViewHolder.setImageResource(R$id.sport_from_type, detailBean.f14287x == 9 ? R$mipmap.ic_sport_app : R$mipmap.ic_sport_device);
            int i14 = detailBean.f14287x;
            if (i14 > 0 && i14 < 9) {
                if (detailBean.f14288y >= 4) {
                    baseViewHolder.setImageResource(R$id.iv_item_pace, R$mipmap.ic_history_item_heart);
                    baseViewHolder.setText(R$id.tv_pace, android.support.v4.media.session.e.h(detailBean.f14282s, " ", this.context.getString(R$string.str_hr_unit)));
                    return;
                }
                baseViewHolder.setImageResource(R$id.iv_item_pace, R$mipmap.ic_pics);
                long j10 = detailBean.f14277m;
                if (k.f8731b == null) {
                    synchronized (k.class) {
                        k.f8731b = new k();
                    }
                }
                if (k.f8731b.d().getMeterUnit() == 1) {
                    j10 = (long) (j10 * 1.609d);
                }
                baseViewHolder.setText(R$id.tv_pace, String.format(locale, "%d′%02d″", Long.valueOf(j10 / 60), Long.valueOf(j10 % 60)));
                return;
            }
            if (k.f8731b == null) {
                synchronized (k.class) {
                    k.f8731b = new k();
                }
            }
            k kVar2 = k.f8731b;
            if (kVar2 == null || (d5 = kVar2.d()) == null) {
                return;
            }
            if (d5.getMeterUnit() == 0) {
                d8 = detailBean.f14268c / 1000.0d;
                j4 = d8 > 0.0d ? (long) (detailBean.e / d8) : 0L;
                string = this.context.getString(R$string.str_km);
            } else {
                float b10 = v1.b((float) detailBean.f14268c);
                j4 = b10 > 0.0f ? (long) (detailBean.e / b10) : 0L;
                d8 = b10;
                string = this.context.getString(R$string.str_mile);
            }
            baseViewHolder.setText(R$id.tv_distance, String.format(locale, "%.2f", Float.valueOf(((int) (((float) d8) * 100)) / f2)));
            baseViewHolder.setText(R$id.tv_distance_unit, string);
            baseViewHolder.setText(R$id.tv_pace, String.format(locale, "%d′%02d″", Long.valueOf(j4 / 60), Long.valueOf(j4 % 60)));
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final void convert(BaseViewHolder baseViewHolder, Object obj) {
        DialBean dialBean;
        DialBean dialBean2;
        DialBean dialBean3;
        float f2;
        User d5;
        long j4;
        double d8;
        CharSequence string;
        User d10;
        double b3;
        CharSequence string2;
        switch (this.f18092a) {
            case 0:
                return;
            case 1:
                DialInfoModel dialInfoModel = (DialInfoModel) ((DeviceOptionModel) obj);
                DialMarketView dialMarketView = (DialMarketView) baseViewHolder.getView(R$id.dial_market);
                dialMarketView.getClass();
                kotlin.jvm.internal.e.f(dialInfoModel, "dialInfoModel");
                dialInfoModel.toString();
                DialInfoBean dialInfoBean = dialInfoModel.getDialInfoBean();
                if (dialInfoBean != null) {
                    DialItemView dialItemView = dialMarketView.f8409d;
                    if (dialItemView == null) {
                        kotlin.jvm.internal.e.m("dialFirstItemView");
                        throw null;
                    }
                    dialItemView.a(dialInfoBean);
                    DialItemView dialItemView2 = dialMarketView.e;
                    if (dialItemView2 == null) {
                        kotlin.jvm.internal.e.m("dialSecItemView");
                        throw null;
                    }
                    dialItemView2.a(dialInfoBean);
                    DialItemView dialItemView3 = dialMarketView.f8410f;
                    if (dialItemView3 == null) {
                        kotlin.jvm.internal.e.m("dialThItemView");
                        throw null;
                    }
                    dialItemView3.a(dialInfoBean);
                }
                List<DialModel> dialModels = dialInfoModel.getDialModels();
                if (dialModels != null) {
                    int i3 = 0;
                    for (Object obj2 : dialModels) {
                        int i10 = i3 + 1;
                        if (i3 < 0) {
                            i.f();
                            throw null;
                        }
                        DialModel dialModel = (DialModel) obj2;
                        if (i3 == 0) {
                            DialItemView dialItemView4 = dialMarketView.f8409d;
                            if (dialItemView4 == null) {
                                kotlin.jvm.internal.e.m("dialFirstItemView");
                                throw null;
                            }
                            dialItemView4.setData(dialModel);
                            if (dialModel != null && (dialBean3 = dialModel.getDialBean()) != null) {
                                DialItemView dialItemView5 = dialMarketView.f8409d;
                                if (dialItemView5 == null) {
                                    kotlin.jvm.internal.e.m("dialFirstItemView");
                                    throw null;
                                }
                                String previewUrl = dialBean3.getPreviewUrl();
                                kotlin.jvm.internal.e.e(previewUrl, "getPreviewUrl(...)");
                                String name = dialBean3.getName();
                                kotlin.jvm.internal.e.e(name, "getName(...)");
                                dialItemView5.b(previewUrl, name);
                            }
                        }
                        if (i3 == 1) {
                            DialItemView dialItemView6 = dialMarketView.e;
                            if (dialItemView6 == null) {
                                kotlin.jvm.internal.e.m("dialSecItemView");
                                throw null;
                            }
                            dialItemView6.setData(dialModel);
                            if (dialModel != null && (dialBean2 = dialModel.getDialBean()) != null) {
                                DialItemView dialItemView7 = dialMarketView.e;
                                if (dialItemView7 == null) {
                                    kotlin.jvm.internal.e.m("dialSecItemView");
                                    throw null;
                                }
                                String previewUrl2 = dialBean2.getPreviewUrl();
                                kotlin.jvm.internal.e.e(previewUrl2, "getPreviewUrl(...)");
                                String name2 = dialBean2.getName();
                                kotlin.jvm.internal.e.e(name2, "getName(...)");
                                dialItemView7.b(previewUrl2, name2);
                            }
                        }
                        if (i3 == 2) {
                            DialItemView dialItemView8 = dialMarketView.f8410f;
                            if (dialItemView8 == null) {
                                kotlin.jvm.internal.e.m("dialThItemView");
                                throw null;
                            }
                            dialItemView8.setData(dialModel);
                            if (dialModel != null && (dialBean = dialModel.getDialBean()) != null) {
                                DialItemView dialItemView9 = dialMarketView.f8410f;
                                if (dialItemView9 == null) {
                                    kotlin.jvm.internal.e.m("dialThItemView");
                                    throw null;
                                }
                                String previewUrl3 = dialBean.getPreviewUrl();
                                kotlin.jvm.internal.e.e(previewUrl3, "getPreviewUrl(...)");
                                String name3 = dialBean.getName();
                                kotlin.jvm.internal.e.e(name3, "getName(...)");
                                dialItemView9.b(previewUrl3, name3);
                            }
                        }
                        i3 = i10;
                    }
                    return;
                }
                return;
            case 2:
                return;
            case 3:
                return;
            case 4:
                return;
            case 5:
                SportRecordModel sportRecordModel = (SportRecordModel) obj;
                baseViewHolder.setText(R$id.tv_date, sportRecordModel.getDate());
                View view = baseViewHolder.getView(R$id.iv_arrow);
                if (sportRecordModel.isExpand()) {
                    view.setRotation(90.0f);
                    return;
                } else {
                    view.setRotation(270.0f);
                    return;
                }
            case 6:
                b(baseViewHolder, obj);
                return;
            default:
                h6.b detailBean = ((SportRecordModel) obj).getDetailBean();
                if (detailBean != null) {
                    Log.e("qob", "convert getFrom " + detailBean.f14287x + " getSportType " + detailBean.f14267b);
                    int i11 = detailBean.f14287x;
                    if (i11 <= 0 || i11 >= 9) {
                        f2 = 100.0f;
                        int i12 = detailBean.f14267b;
                        if (i12 == 5) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_run);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_running_outdoor);
                            baseViewHolder.setVisible(R$id.tv_distance, true);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                        } else if (i12 == 7) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_walk);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_walking);
                            baseViewHolder.setVisible(R$id.tv_distance, true);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                        } else if (i12 == 2) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_bike);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_biking);
                            baseViewHolder.setVisible(R$id.tv_distance, true);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                        } else if (i12 == 14) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_clim);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_climing);
                            baseViewHolder.setVisible(R$id.tv_distance, true);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                        } else if (i12 == 6) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_tennis);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_tennis);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 9) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_yoga);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_yoga);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 11) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_basketball);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_basketball);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 13) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_football);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_football);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 10) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_badminton);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_badminton);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 12) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_skipping_rope);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_jumprope);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 16) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_free_exercise);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_free_exercise);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 17) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_ballet);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_ballet);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 18) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_golf);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_golf);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 19) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_square_dance);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_square_dance);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 20) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_baseball);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_baseball);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 21) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_rugby);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_rugby);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 22) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_poppy_jump);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_poppy_jump);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 23) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_elliptical_machine);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_elliptical_machine);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 24) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_fitness);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_fitness);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 25) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_kayak);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_kayak);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 26) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_on_foot);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_on_foot);
                            baseViewHolder.setVisible(R$id.tv_distance, true);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                        } else if (i12 == 27) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_water_sports);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_snow_sports);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 28) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_paddle_board);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_paddle_board);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 29) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_pilates);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_pilates);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 30) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_roller_skating);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_roller_skating);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 31) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_boating);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_boating);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 32) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_sailboat);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sailboat);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 33) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_skateboard);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_skateboard);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 34) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_strench);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_stretch);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else if (i12 == 35) {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_water_polo);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_water_polo);
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                            baseViewHolder.setVisible(R$id.ll_pace, false);
                        } else {
                            baseViewHolder.setImageResource(R$id.sport_icon, R$mipmap.ic_sport_item_run);
                            baseViewHolder.setText(R$id.tv_sport_type, R$string.str_tab_sport_running_indoor);
                            baseViewHolder.setVisible(R$id.tv_distance, true);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                        }
                    } else {
                        baseViewHolder.setImageResource(R$id.sport_icon, ca.d(this.context, detailBean.f14267b));
                        int i13 = detailBean.f14267b;
                        Context context = this.context;
                        kotlin.jvm.internal.e.f(context, "context");
                        String[] stringArray = context.getResources().getStringArray(R$array.jlrunning_string_array);
                        kotlin.jvm.internal.e.e(stringArray, "getStringArray(...)");
                        String str = stringArray[i13];
                        kotlin.jvm.internal.e.e(str, "get(...)");
                        if (str.contains("GPS")) {
                            str = str.replace("GPS", "").trim();
                        }
                        baseViewHolder.setText(R$id.tv_sport_type, str);
                        if (detailBean.f14288y < 4) {
                            baseViewHolder.setVisible(R$id.tv_distance, true);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, true);
                            if (k.f8731b == null) {
                                synchronized (k.class) {
                                    k.f8731b = new k();
                                }
                            }
                            k kVar = k.f8731b;
                            if (kVar == null || (d10 = kVar.d()) == null) {
                                f2 = 100.0f;
                            } else {
                                if (d10.getMeterUnit() == 0) {
                                    b3 = detailBean.f14268c / 1000.0d;
                                    string2 = this.context.getString(R$string.str_km);
                                } else {
                                    b3 = v1.b((float) detailBean.f14268c);
                                    string2 = this.context.getString(R$string.str_mile);
                                }
                                f2 = 100.0f;
                                baseViewHolder.setText(R$id.tv_distance, String.format(Locale.ENGLISH, "%.2f", Float.valueOf(((int) (((float) b3) * 100)) / 100.0f)));
                                baseViewHolder.setText(R$id.tv_distance_unit, string2);
                            }
                        } else {
                            f2 = 100.0f;
                            baseViewHolder.setVisible(R$id.tv_distance, false);
                            baseViewHolder.setVisible(R$id.tv_distance_unit, false);
                        }
                    }
                    baseViewHolder.setText(R$id.tv_date, ca.i(detailBean.f14269d * 1000, "yyyy/MM/dd HH:mm:ss"));
                    int i14 = R$id.tv_calorie;
                    Locale locale = Locale.ENGLISH;
                    baseViewHolder.setText(i14, String.format(locale, "%.1f KCAL", Float.valueOf(((int) ((((float) detailBean.f14271g) / 1000.0f) * 10)) / 10.0f)));
                    baseViewHolder.setText(R$id.tv_time, String.format(locale, "%02d:%02d:%02d", Long.valueOf(detailBean.e / 3600), Long.valueOf((detailBean.e % 3600) / 60), Long.valueOf((detailBean.e % 3600) % 60)));
                    baseViewHolder.setImageResource(R$id.sport_from_type, detailBean.f14287x == 9 ? R$mipmap.ic_sport_app : R$mipmap.ic_sport_device);
                    int i15 = detailBean.f14287x;
                    if (i15 <= 0 || i15 >= 9) {
                        if (k.f8731b == null) {
                            synchronized (k.class) {
                                k.f8731b = new k();
                            }
                        }
                        k kVar2 = k.f8731b;
                        if (kVar2 == null || (d5 = kVar2.d()) == null) {
                            return;
                        }
                        if (d5.getMeterUnit() == 0) {
                            d8 = detailBean.f14268c / 1000.0d;
                            j4 = d8 > 0.0d ? (long) (detailBean.e / d8) : 0L;
                            string = this.context.getString(R$string.str_km);
                        } else {
                            float b10 = v1.b((float) detailBean.f14268c);
                            j4 = b10 > 0.0f ? (long) (detailBean.e / b10) : 0L;
                            d8 = b10;
                            string = this.context.getString(R$string.str_mile);
                        }
                        baseViewHolder.setText(R$id.tv_distance, String.format(locale, "%.2f", Float.valueOf(((int) (((float) d8) * 100)) / f2)));
                        baseViewHolder.setText(R$id.tv_distance_unit, string);
                        baseViewHolder.setText(R$id.tv_pace, String.format(locale, "%d′%02d″", Long.valueOf(j4 / 60), Long.valueOf(j4 % 60)));
                        return;
                    }
                    baseViewHolder.setText(R$id.tv_calorie, (((int) detailBean.f14271g) / 1000) + " KCAL");
                    if (detailBean.f14288y >= 4) {
                        baseViewHolder.setImageResource(R$id.iv_item_pace, R$mipmap.ic_history_item_heart);
                        baseViewHolder.setText(R$id.tv_pace, android.support.v4.media.session.e.h(detailBean.f14282s, " ", this.context.getString(R$string.str_hr_unit)));
                        return;
                    }
                    baseViewHolder.setImageResource(R$id.iv_item_pace, R$mipmap.ic_pics);
                    long j10 = detailBean.f14277m;
                    if (k.f8731b == null) {
                        synchronized (k.class) {
                            k.f8731b = new k();
                        }
                    }
                    if (k.f8731b.d().getMeterUnit() == 1) {
                        j10 = (long) (j10 * 1.609d);
                    }
                    baseViewHolder.setText(R$id.tv_pace, String.format(locale, "%d′%02d″", Long.valueOf(j10 / 60), Long.valueOf(j10 % 60)));
                    return;
                }
                return;
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getItemViewType() {
        switch (this.f18092a) {
        }
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getLayoutId() {
        switch (this.f18092a) {
        }
        return R$layout.item_sport_record;
    }
}
