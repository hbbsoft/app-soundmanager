/**
 * Copyright 2009 Daniel Roozen
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed 
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language 
 * governing permissions and limitations under the License. 
 */
package com.roozen.SoundManagerv2.receivers;

import com.roozen.SoundManagerv2.R;
import com.roozen.SoundManagerv2.services.BootupService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.roozen.SoundManagerv2.utils.Util;

public class Bootup extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		Intent i = new Intent(context, BootupService.class);
		context.startService(i);
        Util.putBooleanPref(context, context.getString(R.string.muted), false);
	}

}
