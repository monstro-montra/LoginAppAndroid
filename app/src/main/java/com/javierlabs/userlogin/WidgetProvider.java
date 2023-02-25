package com.javierlabs.userlogin;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
        for (int appWidgetId : appWidgetIds){
            Intent intent = new Intent(context, LoginActivity.class); //create a new intent
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_provider);
            views.setOnClickPendingIntent(R.id.widget_btn, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}