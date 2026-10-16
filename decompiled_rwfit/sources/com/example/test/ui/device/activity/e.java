package com.example.test.ui.device.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.camera.core.impl.i1;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.test.R$drawable;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.device.model.ContactModel;
import com.google.android.gms.internal.mlkit_vision_barcode.ke;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.Iterator;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements androidx.activity.result.a, og.n, og.k, OnItemClickListener, nd.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ContactActivity f7853a;

    @Override // og.n
    public void a(i1 i1Var, i1 i1Var2) {
        int i3 = ContactActivity.I;
        ContactActivity this$0 = this.f7853a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        og.o oVar = new og.o();
        oVar.f16946a = this$0.getResources().getDrawable(R$drawable.bg_right_red);
        oVar.f16949d = -1;
        oVar.f16948c = com.example.baselibrary.utils.b.f(this$0, 70.0f);
        oVar.f16947b = this$0.getResources().getDrawable(R$mipmap.ic_delect);
        i1Var2.b(oVar);
    }

    @Override // androidx.activity.result.a
    public void b(Object obj) {
        Cursor query;
        String str;
        Object obj2;
        String r;
        ActivityResult activityResult = (ActivityResult) obj;
        int i3 = ContactActivity.I;
        ContactActivity this$0 = this.f7853a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (activityResult.b() == -1) {
            Intent a3 = activityResult.a();
            Uri data = a3 != null ? a3.getData() : null;
            ContentResolver contentResolver = this$0.getContentResolver();
            if (data == null || (query = contentResolver.query(data, null, null, null, null)) == null) {
                return;
            }
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                while (cursor2.moveToNext()) {
                    String string = cursor2.getString(cursor2.getColumnIndex("display_name"));
                    String string2 = cursor2.getString(cursor2.getColumnIndex(FileDownloadModel.ID));
                    ContentResolver contentResolver2 = contentResolver;
                    Cursor query2 = contentResolver2.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=" + string2, null, null);
                    if (query2 != null) {
                        String str2 = "";
                        if (query2.moveToNext()) {
                            str = query2.getString(query2.getColumnIndex("data1"));
                            kotlin.jvm.internal.e.e(str, "getString(...)");
                        } else {
                            str = "";
                        }
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "contact data " + string + " phone " + ((Object) str));
                        Iterator it = this$0.S0().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            ContactModel contactModel = (ContactModel) obj2;
                            String contactType = contactModel.getContactType();
                            kotlin.jvm.internal.e.e(contactType, "getContactType(...)");
                            if (contactType.length() == 0) {
                                r = "";
                            } else {
                                String contactType2 = contactModel.getContactType();
                                kotlin.jvm.internal.e.e(contactType2, "getContactType(...)");
                                r = kotlin.text.m.r(contactType2, " ", "");
                            }
                            if (r.equals(str.length() == 0 ? "" : kotlin.text.m.r(str, " ", "")) && kotlin.jvm.internal.e.a(string, contactModel.getContactName())) {
                                break;
                            }
                        }
                        if (((ContactModel) obj2) != null) {
                            this$0.w0(R$string.str_contact_already_exists);
                        } else {
                            ContactModel contactModel2 = new ContactModel();
                            contactModel2.setContactName(string);
                            if (str.length() != 0) {
                                str2 = kotlin.text.m.r(str, " ", "");
                            }
                            contactModel2.setContactType(str2);
                            this$0.S0().add(contactModel2);
                            this$0.R0().notifyItemInserted(this$0.S0().size() - 1);
                            this$0.R0().notifyDataSetChanged();
                            query2.close();
                        }
                    }
                    contentResolver = contentResolver2;
                }
                cursor.close();
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    ke.a(cursor, th2);
                    throw th3;
                }
            }
        }
    }

    @Override // og.k
    public void d(og.m mVar, int i3) {
        int i10 = ContactActivity.I;
        ContactActivity this$0 = this.f7853a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        mVar.a();
        this$0.S0().remove(i3);
        this$0.R0().notifyItemRemoved(i3);
    }

    @Override // nd.b
    public void h(boolean z5) {
        int i3 = ContactActivity.I;
        ContactActivity this$0 = this.f7853a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (z5) {
            if (this$0.S0().size() >= this$0.G) {
                Toast.makeText(this$0, R$string.str_max_contact_count, 0).show();
                return;
            }
            Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
            androidx.activity.result.c cVar = this$0.H;
            if (cVar != null) {
                cVar.a(intent);
            }
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        int i10 = ContactActivity.I;
        ContactActivity this$0 = this.f7853a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        ContactModel contactModel = (ContactModel) this$0.S0().get(i3);
        kotlin.jvm.internal.e.f(contactModel, "contactModel");
        Intent intent = new Intent(this$0, (Class<?>) ContactDetailActivity.class);
        intent.putExtra("contact_position", i3);
        Bundle bundle = new Bundle();
        bundle.putSerializable(AeUtil.ROOT_DATA_PATH_OLD_NAME, contactModel);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }
}
