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
package com.roozen.SoundManager.utils;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Util {

	public static String padZero(int num){
		String str = Integer.toString(num);
		if(num < 10){
			str = "0" + str;
		}
		return str;
	}
	
	public static String padZero(String str){
		if(str.length() < 2){
			str = "0" + str;
		}
		return str;
	}
	
	public static Calendar getMyCalendar(int hour, int minute, int second, int milli){
		Calendar cal = Calendar.getInstance(TimeZone.getDefault(),	Locale.getDefault());
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, milli);
		return cal;
	}
	
}
