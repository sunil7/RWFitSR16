package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public abstract class e0 {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        l1.e eVar;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                eVar = new com.example.test.ui.device.activity.i0(clipData, 3);
            } else {
                l1.f fVar = new l1.f();
                fVar.f15690b = clipData;
                fVar.f15691c = 3;
                eVar = fVar;
            }
            l1.z0.i(textView, eVar.b());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th2) {
            textView.endBatchEdit();
            throw th2;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        l1.e eVar;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            eVar = new com.example.test.ui.device.activity.i0(clipData, 3);
        } else {
            l1.f fVar = new l1.f();
            fVar.f15690b = clipData;
            fVar.f15691c = 3;
            eVar = fVar;
        }
        l1.z0.i(view, eVar.b());
        return true;
    }
}
