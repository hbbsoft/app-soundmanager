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
package com.roozen.SoundManager;

import com.roozen.SoundManager.utils.DbUtil;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;

public class MuteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ContentResolver resolver = getContentResolver();
		AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		boolean muted = DbUtil.queryBoolean(resolver, getString(R.string.muted), false);

    	final int flagsNoUI = AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE |
    						  AudioManager.FLAG_VIBRATE;
    	
		if(muted){
		    int systemVol = DbUtil.queryInt(resolver, getString(R.string.SavedSystemVolume), -1);
		    int ringerVol = DbUtil.queryInt(resolver, getString(R.string.SavedRingerVolume), -1);
		    int alarmVol = DbUtil.queryInt(resolver, getString(R.string.SavedAlarmVolume), -1);
		    int mediaVol = DbUtil.queryInt(resolver, getString(R.string.SavedMediaVolume), -1);

		    RingmodeToggle.fixRingMode(audio, ringerVol);
		    if(systemVol != -1){
		        audio.setStreamVolume(AudioManager.STREAM_SYSTEM, systemVol, flagsNoUI);
		    }
		    if(ringerVol != -1){
		        audio.setStreamVolume(AudioManager.STREAM_RING, ringerVol, flagsNoUI);
		    }
		    if(alarmVol != -1){
		        audio.setStreamVolume(AudioManager.STREAM_ALARM, alarmVol, flagsNoUI);
		    }
		    if(mediaVol != -1){
		        audio.setStreamVolume(AudioManager.STREAM_MUSIC, mediaVol, flagsNoUI);
		    }

		    DbUtil.update(resolver, getString(R.string.muted), 0);
		} else {
		    DbUtil.update(resolver, getString(R.string.SavedSystemVolume), audio.getStreamVolume(AudioManager.STREAM_SYSTEM));
		    DbUtil.update(resolver, getString(R.string.SavedRingerVolume), audio.getStreamVolume(AudioManager.STREAM_RING));
		    DbUtil.update(resolver, getString(R.string.SavedAlarmVolume), audio.getStreamVolume(AudioManager.STREAM_ALARM));
		    DbUtil.update(resolver, getString(R.string.SavedMediaVolume), audio.getStreamVolume(AudioManager.STREAM_MUSIC));

		    DbUtil.update(resolver, getString(R.string.muted), 1);

		    RingmodeToggle.fixRingMode(audio, 0);
		    audio.setStreamVolume(AudioManager.STREAM_SYSTEM, 0, flagsNoUI);
		    audio.setStreamVolume(AudioManager.STREAM_RING, 0, flagsNoUI);
		    audio.setStreamVolume(AudioManager.STREAM_ALARM, 0, flagsNoUI);
		    audio.setStreamVolume(AudioManager.STREAM_MUSIC, 0, flagsNoUI);
		}

		finish();
	}
}
