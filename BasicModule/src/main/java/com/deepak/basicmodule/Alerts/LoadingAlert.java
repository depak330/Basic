package com.deepak.basicmodule.Alerts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.deepak.basicmodule.R;


/**
 * Created by amit.singh on 13-Dec-17.
 */

public class LoadingAlert {

    PopupWindow popupWindow;
     View view;

    public LoadingAlert(Activity activity) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.activity_alertdialog, null, false);
        Display display = activity.getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int hight = displayMetrics.heightPixels;
        popupWindow = new PopupWindow(view, width, hight, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        alertHide();
    }



    public void alertShow(){
        if(!popupWindow.isShowing()){
                try {
                    popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }

    public void alertHide(){
        if(popupWindow.isShowing()){
                try {
                    popupWindow.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }


}
