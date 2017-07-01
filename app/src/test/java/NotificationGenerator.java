import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.example.faiz.coinflipapp.MainActivity;
import com.example.faiz.coinflipapp.R;

/**
 * Created by Faiz on 7/1/2017.
 */
public class NotificationGenerator {
    private static final int NOTIFICATION_ID_OPEN_ACTIVITY =9;
    public static void openActivtyNotification(Context context){
        NotificationCompat.Builder nc =new NotificationCompat.Builder(context);
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notifyIntent= new Intent(context, MainActivity.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,notifyIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        nc.setContentIntent(pendingIntent);

        nc.setSmallIcon(R.drawable.abc);
        nc.setAutoCancel(true);
        nc.setContentTitle("Flip app notification");
        nc.setContentText("Click Please");
        nm.notify(NOTIFICATION_ID_OPEN_ACTIVITY,nc.build());
    }
}
