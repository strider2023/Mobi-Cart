package com.touchmenotapps.mobicart.util;

import com.touchmenotapps.mobicart.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

public class NetworkUtil {

	/**
	 * 
	 * @param context
	 * @return
	 */
	public boolean isNetworkAvailable(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) 
				context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager
				.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
	
	/**
	 * 
	 * @param context
	 */
	public void showNetworkErrorDialog(final Context context) {
		final AlertDialog networkErrorAlertDialog = new AlertDialog.Builder(context, 
				AlertDialog.THEME_DEVICE_DEFAULT_DARK).create();
		networkErrorAlertDialog.setCanceledOnTouchOutside(false);
		networkErrorAlertDialog.setTitle(R.string.network_error);
		networkErrorAlertDialog.setButton(AlertDialog.BUTTON_POSITIVE, 
				context.getResources().getString(R.string.menu_settings), 
				new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				context.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
				networkErrorAlertDialog.dismiss();
			}
		});
		
		networkErrorAlertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, 
				context.getResources().getString(R.string.cancel), 
				new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				networkErrorAlertDialog.dismiss();
			}
		});
		networkErrorAlertDialog.show();
	}
}
