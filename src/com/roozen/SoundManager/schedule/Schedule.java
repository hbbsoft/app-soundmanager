/**
 * Copyright 2009 Mike Partridge
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
package com.roozen.SoundManager.schedule;

/**
 * In-memory representation of a volume/vibrate schedule
 * 
 * @author Mike Partridge
 */
public class Schedule {

    private int id;
    private boolean mDay0;
    private boolean mDay1;
    private boolean mDay2;
    private boolean mDay3;
    private boolean mDay4;
    private boolean mDay5;
    private boolean mDay6;
    private int mStartHour;
    private int mStartMinute;
    private int mVolume;
    private int mVolumeType;
    private boolean mVibrate;
    private boolean mActive;
    
    /**
     * @param id
     * @param day0
     * @param day1
     * @param day2
     * @param day3
     * @param day4
     * @param day5
     * @param day6
     * @param endTime
     * @param startTime
     * @param vibrate
     * @param volume
     */
    public Schedule(int id, boolean day0, boolean day1, boolean day2, boolean day3, boolean day4, boolean day5,
                    boolean day6, int startHour, int startMinute, 
                    int volume, int volumeType, boolean vibrate, boolean active) {
        this.id = id;
        this.mDay0 = day0;
        this.mDay1 = day1;
        this.mDay2 = day2;
        this.mDay3 = day3;
        this.mDay4 = day4;
        this.mDay5 = day5;
        this.mDay6 = day6;
        this.mStartHour = startHour;
        this.mStartMinute = startMinute;
        this.mVolume = volume;
        this.mVolumeType = volumeType;
        this.mVibrate = vibrate;
        this.mActive = active;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the mDay0
     */
    public boolean isDay0() {
        return mDay0;
    }

    /**
     * @param mDay0 the mDay0 to set
     */
    public void setDay0(boolean day0) {
        this.mDay0 = day0;
    }

    /**
     * @return the day1
     */
    public boolean isDay1() {
        return mDay1;
    }

    /**
     * @param day1 the day1 to set
     */
    public void setDay1(boolean day1) {
        this.mDay1 = day1;
    }

    /**
     * @return the day2
     */
    public boolean isDay2() {
        return mDay2;
    }

    /**
     * @param day2 the day2 to set
     */
    public void setDay2(boolean day2) {
        this.mDay2 = day2;
    }

    /**
     * @return the day3
     */
    public boolean isDay3() {
        return mDay3;
    }

    /**
     * @param day3 the day3 to set
     */
    public void setDay3(boolean day3) {
        this.mDay3 = day3;
    }

    /**
     * @return the day4
     */
    public boolean isDay4() {
        return mDay4;
    }

    /**
     * @param day4 the day4 to set
     */
    public void setDay4(boolean day4) {
        this.mDay4 = day4;
    }

    /**
     * @return the day5
     */
    public boolean isDay5() {
        return mDay5;
    }

    /**
     * @param day5 the day5 to set
     */
    public void setDay5(boolean day5) {
        this.mDay5 = day5;
    }

    /**
     * @return the day6
     */
    public boolean isDay6() {
        return mDay6;
    }

    /**
     * @param day6 the day6 to set
     */
    public void setDay6(boolean day6) {
        this.mDay6 = day6;
    }

    /**
     * @return the startHour
     */
    public int getStartHour() {
        return mStartHour;
    }

    /**
     * @param startHour the startHour to set
     */
    public void setStartHour(int startHour) {
        this.mStartHour = startHour;
    }

    /**
     * @return the startMinute
     */
    public int getStartMinute() {
        return mStartMinute;
    }

    /**
     * @param startMinute the startMinute to set
     */
    public void setStartMinute(int startMinute) {
        this.mStartMinute = startMinute;
    }

    /**
     * @return the volume
     */
    public int getVolume() {
        return mVolume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        this.mVolume = volume;
    }

    /**
     * @return the volumeType
     */
    public int getVolumeType() {
        return mVolumeType;
    }

    /**
     * @param volumeType the volumeType to set
     */
    public void setVolumeType(int volumeType) {
        this.mVolumeType = volumeType;
    }

    /**
     * @return the vibrate
     */
    public boolean isVibrate() {
        return mVibrate;
    }

    /**
     * @param vibrate the vibrate to set
     */
    public void setVibrate(boolean vibrate) {
        this.mVibrate = vibrate;
    }

    /**
     * @param mActive the mActive to set
     */
    public void setActive(boolean mActive) {
        this.mActive = mActive;
    }
    
    /**
     * @return the mActive
     */
    public boolean isActive() {
        return mActive;
    }
    
    /**
     * Required for use in a ListAdapter; indicates that this is selectable and clickable
     * 
     * @return the mEnabled
     */
    public boolean isEnabled() {
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        
        if (o instanceof Schedule) {
            Schedule compare = (Schedule) o;
            result = (this.id > 0 && this.id == compare.getId());
        }
        
        return result;
    }

    /**
     * Compares all fields except schedule_id
     * 
     * @param s
     * @return
     */
    public boolean equalsSansId(Schedule s) {
        boolean result = false;
        
        result = (
                this.isActive() == s.isActive() &&
                this.isDay0() == s.isDay0() &&
                this.isDay1() == s.isDay1() &&
                this.isDay2() == s.isDay2() &&
                this.isDay3() == s.isDay3() &&
                this.isDay4() == s.isDay4() &&
                this.isDay5() == s.isDay5() &&
                this.isDay6() == s.isDay6() &&
                this.isVibrate() == s.isVibrate() &&
                this.getStartHour() == s.getStartHour() &&
                this.getStartMinute() == s.getStartMinute() &&
                this.getVolume() == s.getVolume() &&
                this.getVolumeType() == s.getVolumeType()
                );
    
        return result;
    }

}
