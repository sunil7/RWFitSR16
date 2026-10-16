package com.example.test.ui.model;

import com.example.blesdk.bean.function.AlarmRemainderBean;
import com.example.blesdk.bean.function.BrightScreenBean;
import com.example.blesdk.bean.function.BrightScreenTimeBean;
import com.example.blesdk.bean.function.DNDModelBean;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.blesdk.bean.function.HrBoActualReminderBean;
import com.example.blesdk.bean.function.HrMonitorBean;
import com.example.blesdk.bean.function.PowerBean;
import com.example.blesdk.bean.function.ReminderModeBean;
import com.example.blesdk.bean.function.SedentaryReminderBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.blesdk.bean.function.VaperPowerBean;
import com.example.blesdk.bean.sync.SportDataPushBean;
import com.example.network.bean.FirmwareInfoBean;
import com.example.test.ui.device.model.AlarmModel;
import com.example.test.ui.device.model.ContactModel;
import com.example.test.ui.device.model.MessageModel;
import com.example.test.ui.device.model.ScheduleModel;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class EventBusBeans {

    public static class AlarmChangeEvent {
        private List<AlarmRemainderBean> alarmRemainderBeans;

        public AlarmChangeEvent(List<AlarmRemainderBean> list) {
            this.alarmRemainderBeans = list;
        }

        public List<AlarmRemainderBean> getAlarmRemainderBeans() {
            return this.alarmRemainderBeans;
        }

        public void setAlarmRemainderBeans(List<AlarmRemainderBean> list) {
            this.alarmRemainderBeans = list;
        }
    }

    public static class AlarmEvent {
        private AlarmModel alarmModel;
        private boolean isEdit;
        private int position;

        public AlarmEvent(int i3, boolean z5, AlarmModel alarmModel) {
            this.position = i3;
            this.alarmModel = alarmModel;
            this.isEdit = z5;
        }

        public AlarmModel getAlarmModel() {
            return this.alarmModel;
        }

        public int getPosition() {
            return this.position;
        }

        public boolean isEdit() {
            return this.isEdit;
        }

        public void setAlarmModel(AlarmModel alarmModel) {
            this.alarmModel = alarmModel;
        }

        public void setEdit(boolean z5) {
            this.isEdit = z5;
        }

        public void setPosition(int i3) {
            this.position = i3;
        }
    }

    public static class BrightScreenEvent {
        private BrightScreenBean brightScreenBean;

        public BrightScreenEvent(BrightScreenBean brightScreenBean) {
            this.brightScreenBean = brightScreenBean;
        }

        public BrightScreenBean getBrightScreenBean() {
            return this.brightScreenBean;
        }

        public void setBrightScreenBean(BrightScreenBean brightScreenBean) {
            this.brightScreenBean = brightScreenBean;
        }
    }

    public static class BrightTimeEvent {
        private BrightScreenTimeBean brightScreenTimeBean;

        public BrightTimeEvent(BrightScreenTimeBean brightScreenTimeBean) {
            this.brightScreenTimeBean = brightScreenTimeBean;
        }

        public BrightScreenTimeBean getBrightScreenTimeBean() {
            return this.brightScreenTimeBean;
        }

        public void setBrightScreenTimeBean(BrightScreenTimeBean brightScreenTimeBean) {
            this.brightScreenTimeBean = brightScreenTimeBean;
        }
    }

    public static class ChangeBackToFrontEvent {
    }

    public static class ChangeThemeEvent {
    }

    public static class ContactEvent {
        private ContactModel contactModel;
        private int position;

        public ContactEvent(int i3, ContactModel contactModel) {
            this.position = i3;
            this.contactModel = contactModel;
        }

        public ContactModel getContactModel() {
            return this.contactModel;
        }

        public int getPosition() {
            return this.position;
        }

        public void setContactModel(ContactModel contactModel) {
            this.contactModel = contactModel;
        }

        public void setPosition(int i3) {
            this.position = i3;
        }
    }

    public static class CustomDialChangeEvent {
        private String customDialPath;

        public CustomDialChangeEvent(String str) {
            this.customDialPath = str;
        }

        public String getCustomDialPath() {
            return this.customDialPath;
        }

        public void setCustomDialPath(String str) {
            this.customDialPath = str;
        }
    }

    public static class DNDModelEvent {
        private DNDModelBean dndModelBean;

        public DNDModelEvent(DNDModelBean dNDModelBean) {
            this.dndModelBean = dNDModelBean;
        }

        public DNDModelBean getDndModelBean() {
            return this.dndModelBean;
        }

        public void setDndModelBean(DNDModelBean dNDModelBean) {
            this.dndModelBean = dNDModelBean;
        }
    }

    public static class DateValueEvent {
        private Date date;

        public DateValueEvent(Date date) {
            this.date = date;
        }

        public Date getDate() {
            return this.date;
        }
    }

    public static class DeviceConnectEvent {
    }

    public static class DeviceDialInfoEvent {
        private DialInfoBean dialInfoBean;

        public DeviceDialInfoEvent(DialInfoBean dialInfoBean) {
            this.dialInfoBean = dialInfoBean;
        }

        public DialInfoBean getDialInfoBean() {
            return this.dialInfoBean;
        }

        public void setDialInfoBean(DialInfoBean dialInfoBean) {
            this.dialInfoBean = dialInfoBean;
        }
    }

    public static class DeviceDrinkEvent {
        private DrinkReminderBean drinkReminderBean;

        public DeviceDrinkEvent(DrinkReminderBean drinkReminderBean) {
            this.drinkReminderBean = drinkReminderBean;
        }

        public DrinkReminderBean getDrinkReminderBean() {
            return this.drinkReminderBean;
        }

        public void setDrinkReminderBean(DrinkReminderBean drinkReminderBean) {
            this.drinkReminderBean = drinkReminderBean;
        }
    }

    public static class DeviceFunEvent {
        private int deviceFunType;

        public DeviceFunEvent(int i3) {
            this.deviceFunType = i3;
        }

        public int getDeviceFunType() {
            return this.deviceFunType;
        }

        public void setDeviceFunType(int i3) {
            this.deviceFunType = i3;
        }
    }

    public static class DevicePair {
        public static int PAIR = 1;
        public static int UNPAIR;
        private int pairStatus;

        public DevicePair(int i3) {
            this.pairStatus = i3;
        }

        public int getPairStatus() {
            return this.pairStatus;
        }

        public void setPairStatus(int i3) {
            this.pairStatus = i3;
        }
    }

    public static class DevicePowerEvent {
        private PowerBean powerBean;

        public DevicePowerEvent(PowerBean powerBean) {
            this.powerBean = powerBean;
        }

        public PowerBean getPowerBean() {
            return this.powerBean;
        }

        public void setPowerBean(PowerBean powerBean) {
            this.powerBean = powerBean;
        }
    }

    public static class DeviceReminderModelEvent {
        private ReminderModeBean reminderModeBean;

        public DeviceReminderModelEvent(ReminderModeBean reminderModeBean) {
            this.reminderModeBean = reminderModeBean;
        }

        public ReminderModeBean getReminderModeBean() {
            return this.reminderModeBean;
        }

        public void setReminderModeBean(ReminderModeBean reminderModeBean) {
            this.reminderModeBean = reminderModeBean;
        }
    }

    public static class DeviceSedentaryEvent {
        private SedentaryReminderBean sedentaryReminderBean;

        public DeviceSedentaryEvent(SedentaryReminderBean sedentaryReminderBean) {
            this.sedentaryReminderBean = sedentaryReminderBean;
        }

        public SedentaryReminderBean getSedentaryReminderBean() {
            return this.sedentaryReminderBean;
        }

        public void setSedentaryReminderBean(SedentaryReminderBean sedentaryReminderBean) {
            this.sedentaryReminderBean = sedentaryReminderBean;
        }
    }

    public static class DeviceStatusEvent {
        private int status;

        public DeviceStatusEvent(int i3) {
            this.status = i3;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int i3) {
            this.status = i3;
        }
    }

    public static class DeviceSupportEvent {
        private SupportMenuBean supportMenuBean;

        public DeviceSupportEvent(SupportMenuBean supportMenuBean) {
            this.supportMenuBean = supportMenuBean;
        }

        public SupportMenuBean getSupportMenuBean() {
            return this.supportMenuBean;
        }

        public void setSupportMenuBean(SupportMenuBean supportMenuBean) {
            this.supportMenuBean = supportMenuBean;
        }
    }

    public static class DeviceSwitchStatus {
        private List<MessageModel> switchList;

        public DeviceSwitchStatus(List<MessageModel> list) {
            this.switchList = list;
        }

        public List<MessageModel> getSwitchList() {
            return this.switchList;
        }

        public void setSwitchList(List<MessageModel> list) {
            this.switchList = list;
        }
    }

    public static class FirmwareEvent {
        private FirmwareInfoBean firmwareInfoBean;
        private int status;

        public FirmwareEvent(int i3, FirmwareInfoBean firmwareInfoBean) {
            this.status = i3;
            this.firmwareInfoBean = firmwareInfoBean;
        }

        public FirmwareInfoBean getFirmwareInfoBean() {
            return this.firmwareInfoBean;
        }

        public int getStatus() {
            return this.status;
        }

        public void setFirmwareInfoBean(FirmwareInfoBean firmwareInfoBean) {
            this.firmwareInfoBean = firmwareInfoBean;
        }

        public void setStatus(int i3) {
            this.status = i3;
        }
    }

    public static class HomeDialEvent {
        private int dialId;

        public HomeDialEvent(int i3) {
            this.dialId = i3;
        }

        public int getDialId() {
            return this.dialId;
        }

        public void setDialId(int i3) {
            this.dialId = i3;
        }
    }

    public static class HrBoActualReminderEvent {
        private HrBoActualReminderBean HrBoActualReminderBean;

        public HrBoActualReminderEvent(HrBoActualReminderBean hrBoActualReminderBean) {
            this.HrBoActualReminderBean = hrBoActualReminderBean;
        }

        public HrBoActualReminderBean getHrBoActualReminderBean() {
            return this.HrBoActualReminderBean;
        }

        public void setHrBoActualReminderBean(HrBoActualReminderBean hrBoActualReminderBean) {
            this.HrBoActualReminderBean = hrBoActualReminderBean;
        }
    }

    public static class HrMonitorEvent {
        private HrMonitorBean hrMonitorBean;

        public HrMonitorEvent(HrMonitorBean hrMonitorBean) {
            this.hrMonitorBean = hrMonitorBean;
        }

        public HrMonitorBean getHrMonitorBean() {
            return this.hrMonitorBean;
        }

        public void setHrMonitorBean(HrMonitorBean hrMonitorBean) {
            this.hrMonitorBean = hrMonitorBean;
        }
    }

    public static class IncomingCallEvent {
        private boolean isOpen;

        public IncomingCallEvent(boolean z5) {
            this.isOpen = z5;
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        public void setOpen(boolean z5) {
            this.isOpen = z5;
        }
    }

    public static class MuslimCountSwitchSettingEvent {
        private int settingChangeType = 0;

        public int getSettingChangeType() {
            return this.settingChangeType;
        }

        public void setSettingChangeType(int i3) {
            this.settingChangeType = i3;
        }
    }

    public static class OptionEvent {
        private int[] selectValue;

        public OptionEvent(int[] iArr) {
            this.selectValue = iArr;
        }

        public int[] getSelectValue() {
            return this.selectValue;
        }

        public void setSelectValue(int[] iArr) {
            this.selectValue = iArr;
        }
    }

    public static class ScheduleEvent {
        private boolean isEdit;
        private int position;
        private ScheduleModel scheduleModel;

        public ScheduleEvent(int i3, boolean z5, ScheduleModel scheduleModel) {
            this.position = i3;
            this.scheduleModel = scheduleModel;
            this.isEdit = z5;
        }

        public int getPosition() {
            return this.position;
        }

        public ScheduleModel getScheduleModel() {
            return this.scheduleModel;
        }

        public boolean isEdit() {
            return this.isEdit;
        }

        public void setEdit(boolean z5) {
            this.isEdit = z5;
        }

        public void setPosition(int i3) {
            this.position = i3;
        }

        public void setScheduleModel(ScheduleModel scheduleModel) {
            this.scheduleModel = scheduleModel;
        }
    }

    public static class SportDataPushEvent {
        private SportDataPushBean sportDataPushBean;

        public SportDataPushEvent(SportDataPushBean sportDataPushBean) {
            this.sportDataPushBean = sportDataPushBean;
        }

        public SportDataPushBean getSportDataPushBean() {
            return this.sportDataPushBean;
        }

        public void setSportDataPushBean(SportDataPushBean sportDataPushBean) {
            this.sportDataPushBean = sportDataPushBean;
        }
    }

    public static class SportFinish {
        private int sportStatus;

        public int getSportStatus() {
            return this.sportStatus;
        }

        public void setSportStatus(int i3) {
            this.sportStatus = i3;
        }
    }

    public static class SportMapDataPushEvent {
        private SportDataPushBean sportDataPushBean;

        public SportMapDataPushEvent(SportDataPushBean sportDataPushBean) {
            this.sportDataPushBean = sportDataPushBean;
        }

        public SportDataPushBean getSportDataPushBean() {
            return this.sportDataPushBean;
        }

        public void setSportDataPushBean(SportDataPushBean sportDataPushBean) {
            this.sportDataPushBean = sportDataPushBean;
        }
    }

    public static class SyncEvent {
        private int syncType;

        public SyncEvent(int i3) {
            this.syncType = i3;
        }

        public int getSyncType() {
            return this.syncType;
        }

        public void setSyncType(int i3) {
            this.syncType = i3;
        }
    }

    public static class SyncSportEvent {

        /* renamed from: id, reason: collision with root package name */
        private long f8153id;

        public SyncSportEvent(long j4) {
            this.f8153id = j4;
        }

        public long getId() {
            return this.f8153id;
        }

        public void setId(long j4) {
            this.f8153id = j4;
        }
    }

    public static class SyncStatusEvent {
        private int syncStatus;

        public SyncStatusEvent(int i3) {
            this.syncStatus = i3;
        }

        public int getSyncStatus() {
            return this.syncStatus;
        }

        public void setSyncStatus(int i3) {
            this.syncStatus = i3;
        }
    }

    public static class TakePhotoEvent {
        private int event;

        public TakePhotoEvent(int i3) {
            this.event = i3;
        }

        public int getEvent() {
            return this.event;
        }

        public void setEvent(int i3) {
            this.event = i3;
        }
    }

    public static class TextEditEvent {
        public String text;

        public TextEditEvent(String str) {
            this.text = str;
        }

        public String getText() {
            return this.text;
        }
    }

    public static class UnitEvent {
        private int unitType;

        public UnitEvent(int i3) {
            this.unitType = i3;
        }

        public int getUnitType() {
            return this.unitType;
        }

        public void setUnitType(int i3) {
            this.unitType = i3;
        }
    }

    public static class VaperPowerLevelEvent {
        private VaperPowerBean vaperPowerLevelBean;

        public VaperPowerLevelEvent(VaperPowerBean vaperPowerBean) {
            this.vaperPowerLevelBean = vaperPowerBean;
        }

        public VaperPowerBean getVaperPowerLevelBean() {
            return this.vaperPowerLevelBean;
        }

        public void setVaperPowerLevelBean(VaperPowerBean vaperPowerBean) {
            this.vaperPowerLevelBean = vaperPowerBean;
        }
    }

    public static class WXLoginInfo {
        private String action;
        private String errStr;
        private String extMsg;
        private String openId;
        private String reserved;
        private int scene;
        private String templateId;

        public String getAction() {
            return this.action;
        }

        public String getErrStr() {
            return this.errStr;
        }

        public String getExtMsg() {
            return this.extMsg;
        }

        public String getOpenId() {
            return this.openId;
        }

        public String getReserved() {
            return this.reserved;
        }

        public int getScene() {
            return this.scene;
        }

        public String getTemplateId() {
            return this.templateId;
        }

        public void setAction(String str) {
            this.action = str;
        }

        public void setErrStr(String str) {
            this.errStr = str;
        }

        public void setExtMsg(String str) {
            this.extMsg = str;
        }

        public void setOpenId(String str) {
            this.openId = str;
        }

        public void setReserved(String str) {
            this.reserved = str;
        }

        public void setScene(int i3) {
            this.scene = i3;
        }

        public void setTemplateId(String str) {
            this.templateId = str;
        }
    }

    public static class WomenHealthRemindEvent {
        private boolean isMensRemind;
        private boolean isOvulHighRemind;
        private boolean isOvulOverRemind;
        private boolean isOvulRemid;

        public WomenHealthRemindEvent(boolean z5, boolean z6, boolean z8, boolean z10) {
            this.isMensRemind = z5;
            this.isOvulRemid = z6;
            this.isOvulHighRemind = z8;
            this.isOvulOverRemind = z10;
        }

        public boolean isMensRemind() {
            return this.isMensRemind;
        }

        public boolean isOvulHighRemind() {
            return this.isOvulHighRemind;
        }

        public boolean isOvulOverRemind() {
            return this.isOvulOverRemind;
        }

        public boolean isOvulRemid() {
            return this.isOvulRemid;
        }

        public void setMensRemind(boolean z5) {
            this.isMensRemind = z5;
        }

        public void setOvulHighRemind(boolean z5) {
            this.isOvulHighRemind = z5;
        }

        public void setOvulOverRemind(boolean z5) {
            this.isOvulOverRemind = z5;
        }

        public void setOvulRemid(boolean z5) {
            this.isOvulRemid = z5;
        }
    }

    public static class WomenHealthRemindSettingEvent {
        private int settingChangeType = 0;

        public int getSettingChangeType() {
            return this.settingChangeType;
        }

        public void setSettingChangeType(int i3) {
            this.settingChangeType = i3;
        }
    }

    public static class WxCode {
        private String code;

        public WxCode(String str) {
            this.code = str;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String str) {
            this.code = str;
        }
    }

    public static class IntegerValueEvent {
        public int value;
        public int value2;
        public int valueType;

        public IntegerValueEvent(int i3, int i10) {
            this.value = i3;
            this.valueType = i10;
        }

        public int getValue() {
            return this.value;
        }

        public int getValue2() {
            return this.value2;
        }

        public int getValueType() {
            return this.valueType;
        }

        public IntegerValueEvent(int i3, int i10, int i11) {
            this.value = i3;
            this.value2 = i10;
            this.valueType = i11;
        }
    }

    public static class SyncDataEvent {
        private int data;
        private int dp;
        private int sp;
        private int syncType;

        public SyncDataEvent(int i3, int i10) {
            this.syncType = i3;
            this.data = i10;
        }

        public int getData() {
            return this.data;
        }

        public int getDp() {
            return this.dp;
        }

        public int getSp() {
            return this.sp;
        }

        public int getSyncType() {
            return this.syncType;
        }

        public void setData(int i3) {
            this.data = i3;
        }

        public void setDp(int i3) {
            this.dp = i3;
        }

        public void setSp(int i3) {
            this.sp = i3;
        }

        public void setSyncType(int i3) {
            this.syncType = i3;
        }

        public SyncDataEvent(int i3, int i10, int i11) {
            this.syncType = i3;
            this.sp = i10;
            this.dp = i11;
        }
    }
}
