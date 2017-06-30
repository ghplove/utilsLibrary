package net.sourceforge.simcpux.utilslibrary.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.widget.Toast;

/**
 * Created by huiping.guo on 17/6/29.
 * 获取电池信息
 */

public class BatterService {

    //注册电量监听的Broadcastreceiver  
    public void registBatter(Context context,BatteryChangedReceiver batteryChangedReceiver){
        IntentFilter intentFilter=getFilter();
        context.registerReceiver(batteryChangedReceiver,intentFilter);
        Toast.makeText(context,
                "电量变化的receiver已经注册成功"
                ,Toast.LENGTH_SHORT).show();
    }

    //取消注册电量监听的Broadcastreceiver  
    public void unRegistBatter(Context context,BatteryChangedReceiver batteryChangedReceiver){
        context.unregisterReceiver(batteryChangedReceiver);
        Toast.makeText(context,"电量变化的receiver已经取消注册",
                Toast.LENGTH_SHORT).show();
    }

    ///获取IntentFilter对象  
    private IntentFilter getFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction(Intent.ACTION_BATTERY_OKAY);
        return filter;
    }

    public class BatteryChangedReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (action.equalsIgnoreCase(Intent.ACTION_BATTERY_CHANGED)) {
                // 当前电池的电压  
                int voltage = intent.
                        getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
                // 电池的健康状态  
                int health = intent.
                        getIntExtra(BatteryManager.EXTRA_HEALTH, -1);

                // 电池当前的电量, 它介于0和 EXTRA_SCALE之间  
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                // 电池电量的最大值
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                // 当前手机使用的是哪里的电源
                int pluged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                switch (pluged) {
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        // 电源是AC charger.[应该是指充电器]  
                        break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        // 电源是USB port  
                        break;
                    default:
                        break;
                }
                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
                switch (status) {
                    case BatteryManager.BATTERY_STATUS_CHARGING:
                        // 正在充电  
                        break;
                    case BatteryManager.BATTERY_STATUS_DISCHARGING:
                        break;
                    case BatteryManager.BATTERY_STATUS_FULL:
                        // 充满  
                        break;
                    case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                        // 没有充电  
                        break;
                    case BatteryManager.BATTERY_STATUS_UNKNOWN:
                        // 未知状态  
                        break;
                    default:
                        break;
                }
                // 电池使用的技术。比如，对于锂电池是Li-ion  
                String technology = intent.
                        getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
                // 当前电池的温度  
                int temperature = intent.
                        getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
                String str= "voltage = " + voltage + " technology = "
                        + technology + " temperature = " + temperature;
            } else if (action.equalsIgnoreCase(Intent.ACTION_BATTERY_LOW)) {
                // 表示当前电池电量低  
            } else if (action.equalsIgnoreCase(Intent.ACTION_BATTERY_OKAY)) {
                // 表示当前电池已经从电量低恢复为正常  
                System.out.println(
                        "BatteryChangedReceiver ACTION_BATTERY_OKAY---");
            }
        }

    }

}
