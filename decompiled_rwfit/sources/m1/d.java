package m1;

import android.R;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.example.test.ui.device.activity.i0;
import com.example.test.utils.q0;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http2.Http2;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f15938a;

    /* renamed from: b, reason: collision with root package name */
    public int f15939b = -1;

    public d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f15938a = accessibilityNodeInfo;
    }

    public final void a(int i3) {
        this.f15938a.addAction(i3);
    }

    public final void b(c cVar) {
        this.f15938a.addAction((AccessibilityNodeInfo.AccessibilityAction) cVar.f15934a);
    }

    public final ArrayList c(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f15938a;
        ArrayList<Integer> integerArrayList = accessibilityNodeInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        accessibilityNodeInfo.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public final void d(Rect rect) {
        this.f15938a.getBoundsInParent(rect);
    }

    public final CharSequence e() {
        boolean isEmpty = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo accessibilityNodeInfo = this.f15938a;
        if (isEmpty) {
            return accessibilityNodeInfo.getText();
        }
        ArrayList c9 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        ArrayList c10 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        ArrayList c11 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        ArrayList c12 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(accessibilityNodeInfo.getText(), 0, accessibilityNodeInfo.getText().length()));
        for (int i3 = 0; i3 < c9.size(); i3++) {
            spannableString.setSpan(new q0(((Integer) c12.get(i3)).intValue(), this, accessibilityNodeInfo.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) c9.get(i3)).intValue(), ((Integer) c10.get(i3)).intValue(), ((Integer) c11.get(i3)).intValue());
        }
        return spannableString;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = dVar.f15938a;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.f15938a;
        if (accessibilityNodeInfo2 == null) {
            if (accessibilityNodeInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo2.equals(accessibilityNodeInfo)) {
            return false;
        }
        return this.f15939b == dVar.f15939b;
    }

    public final void f(CharSequence charSequence) {
        this.f15938a.setClassName(charSequence);
    }

    public final void g(i0 i0Var) {
        this.f15938a.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) i0Var.f7866b);
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f15938a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList] */
    public final String toString() {
        ?? r32;
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        d(rect);
        sb2.append("; boundsInParent: " + rect);
        AccessibilityNodeInfo accessibilityNodeInfo = this.f15938a;
        accessibilityNodeInfo.getBoundsInScreen(rect);
        sb2.append("; boundsInScreen: " + rect);
        sb2.append("; packageName: ");
        sb2.append(accessibilityNodeInfo.getPackageName());
        sb2.append("; className: ");
        sb2.append(accessibilityNodeInfo.getClassName());
        sb2.append("; text: ");
        sb2.append(e());
        sb2.append("; contentDescription: ");
        sb2.append(accessibilityNodeInfo.getContentDescription());
        sb2.append("; viewId: ");
        sb2.append(accessibilityNodeInfo.getViewIdResourceName());
        sb2.append("; uniqueId: ");
        sb2.append(ic.b() ? accessibilityNodeInfo.getUniqueId() : accessibilityNodeInfo.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY"));
        sb2.append("; checkable: ");
        sb2.append(accessibilityNodeInfo.isCheckable());
        sb2.append("; checked: ");
        sb2.append(accessibilityNodeInfo.isChecked());
        sb2.append("; focusable: ");
        sb2.append(accessibilityNodeInfo.isFocusable());
        sb2.append("; focused: ");
        sb2.append(accessibilityNodeInfo.isFocused());
        sb2.append("; selected: ");
        sb2.append(accessibilityNodeInfo.isSelected());
        sb2.append("; clickable: ");
        sb2.append(accessibilityNodeInfo.isClickable());
        sb2.append("; longClickable: ");
        sb2.append(accessibilityNodeInfo.isLongClickable());
        sb2.append("; enabled: ");
        sb2.append(accessibilityNodeInfo.isEnabled());
        sb2.append("; password: ");
        sb2.append(accessibilityNodeInfo.isPassword());
        sb2.append("; scrollable: " + accessibilityNodeInfo.isScrollable());
        sb2.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo.getActionList();
        if (actionList != null) {
            r32 = new ArrayList();
            int size = actionList.size();
            for (int i3 = 0; i3 < size; i3++) {
                r32.add(new c(actionList.get(i3), 0, null, null, null));
            }
        } else {
            r32 = Collections.EMPTY_LIST;
        }
        for (int i10 = 0; i10 < r32.size(); i10++) {
            c cVar = (c) r32.get(i10);
            int a3 = cVar.a();
            if (a3 == 1) {
                str = "ACTION_FOCUS";
            } else if (a3 != 2) {
                switch (a3) {
                    case 4:
                        str = "ACTION_SELECT";
                        break;
                    case 8:
                        str = "ACTION_CLEAR_SELECTION";
                        break;
                    case 16:
                        str = "ACTION_CLICK";
                        break;
                    case 32:
                        str = "ACTION_LONG_CLICK";
                        break;
                    case 64:
                        str = "ACTION_ACCESSIBILITY_FOCUS";
                        break;
                    case 128:
                        str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                        break;
                    case 256:
                        str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                        break;
                    case 512:
                        str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                        break;
                    case 1024:
                        str = "ACTION_NEXT_HTML_ELEMENT";
                        break;
                    case 2048:
                        str = "ACTION_PREVIOUS_HTML_ELEMENT";
                        break;
                    case 4096:
                        str = "ACTION_SCROLL_FORWARD";
                        break;
                    case 8192:
                        str = "ACTION_SCROLL_BACKWARD";
                        break;
                    case Http2.INITIAL_MAX_FRAME_SIZE /* 16384 */:
                        str = "ACTION_COPY";
                        break;
                    case 32768:
                        str = "ACTION_PASTE";
                        break;
                    case WXMediaMessage.THUMB_LENGTH_LIMIT /* 65536 */:
                        str = "ACTION_CUT";
                        break;
                    case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /* 131072 */:
                        str = "ACTION_SET_SELECTION";
                        break;
                    case 262144:
                        str = "ACTION_EXPAND";
                        break;
                    case 524288:
                        str = "ACTION_COLLAPSE";
                        break;
                    case 2097152:
                        str = "ACTION_SET_TEXT";
                        break;
                    case R.id.accessibilityActionMoveWindow:
                        str = "ACTION_MOVE_WINDOW";
                        break;
                    default:
                        switch (a3) {
                            case R.id.accessibilityActionShowOnScreen:
                                str = "ACTION_SHOW_ON_SCREEN";
                                break;
                            case R.id.accessibilityActionScrollToPosition:
                                str = "ACTION_SCROLL_TO_POSITION";
                                break;
                            case R.id.accessibilityActionScrollUp:
                                str = "ACTION_SCROLL_UP";
                                break;
                            case R.id.accessibilityActionScrollLeft:
                                str = "ACTION_SCROLL_LEFT";
                                break;
                            case R.id.accessibilityActionScrollDown:
                                str = "ACTION_SCROLL_DOWN";
                                break;
                            case R.id.accessibilityActionScrollRight:
                                str = "ACTION_SCROLL_RIGHT";
                                break;
                            case R.id.accessibilityActionContextClick:
                                str = "ACTION_CONTEXT_CLICK";
                                break;
                            case R.id.accessibilityActionSetProgress:
                                str = "ACTION_SET_PROGRESS";
                                break;
                            default:
                                switch (a3) {
                                    case R.id.accessibilityActionShowTooltip:
                                        str = "ACTION_SHOW_TOOLTIP";
                                        break;
                                    case R.id.accessibilityActionHideTooltip:
                                        str = "ACTION_HIDE_TOOLTIP";
                                        break;
                                    case R.id.accessibilityActionPageUp:
                                        str = "ACTION_PAGE_UP";
                                        break;
                                    case R.id.accessibilityActionPageDown:
                                        str = "ACTION_PAGE_DOWN";
                                        break;
                                    case R.id.accessibilityActionPageLeft:
                                        str = "ACTION_PAGE_LEFT";
                                        break;
                                    case R.id.accessibilityActionPageRight:
                                        str = "ACTION_PAGE_RIGHT";
                                        break;
                                    case R.id.accessibilityActionPressAndHold:
                                        str = "ACTION_PRESS_AND_HOLD";
                                        break;
                                    default:
                                        switch (a3) {
                                            case R.id.accessibilityActionImeEnter:
                                                str = "ACTION_IME_ENTER";
                                                break;
                                            case R.id.accessibilityActionDragStart:
                                                str = "ACTION_DRAG_START";
                                                break;
                                            case R.id.accessibilityActionDragDrop:
                                                str = "ACTION_DRAG_DROP";
                                                break;
                                            case R.id.accessibilityActionDragCancel:
                                                str = "ACTION_DRAG_CANCEL";
                                                break;
                                            default:
                                                str = "ACTION_UNKNOWN";
                                                break;
                                        }
                                }
                        }
                }
            } else {
                str = "ACTION_CLEAR_FOCUS";
            }
            if (str.equals("ACTION_UNKNOWN")) {
                Object obj = cVar.f15934a;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    str = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb2.append(str);
            if (i10 != r32.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
