package org.mad.app.hokiehelper;

import java.util.Calendar;


public class Dining_DiningHall_Deets extends Dining_DiningHall {

	public Dining_DiningHall_Deets() {
		super("Deet's Place");
	}

	@Override
	public DiningHallState getDiningHallState() {
		state = DiningHallState.CLOSED;

		Calendar today = Calendar.getInstance();
		// MONDAY THRU FRIDAY
		if (today.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY || today.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY
				|| today.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY || today.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY
				|| today.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			if ((today.get(Calendar.HOUR_OF_DAY) == 6 && today.get(Calendar.MINUTE) >= 30)
					|| (today.get(Calendar.HOUR_OF_DAY) == 7 && today.get(Calendar.MINUTE) < 30)) {
				state = DiningHallState.CLOSED_OPENING_SOON;
			}
			if ((today.get(Calendar.HOUR_OF_DAY) == 7 && today.get(Calendar.MINUTE) >= 30)
					|| (today.get(Calendar.HOUR_OF_DAY) >= 8 && today.get(Calendar.HOUR_OF_DAY) < 23)) {
				state = DiningHallState.OPEN;
			}
			if (today.get(Calendar.HOUR_OF_DAY) >= 23) {
				state = DiningHallState.OPEN_CLOSING_SOON;
			}
		}

		// SATURDAY & SUNDAY
		if (today.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || today.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			if (today.get(Calendar.HOUR_OF_DAY) >= 9 && today.get(Calendar.HOUR_OF_DAY) < 10) {
				state = DiningHallState.CLOSED_OPENING_SOON;
			}
			if (today.get(Calendar.HOUR_OF_DAY) >= 10 && today.get(Calendar.HOUR_OF_DAY) < 23) {
				state = DiningHallState.OPEN;
			}
			if (today.get(Calendar.HOUR_OF_DAY) >= 23) {
				state = DiningHallState.OPEN_CLOSING_SOON;
			}
		}

		return state;
	}

	@Override
	public int getIconId() {
		state = getDiningHallState();
		if (state == DiningHallState.CLOSED || state == DiningHallState.OPEN) {
			return R.drawable.logo_deets;
		} else {
			return R.drawable.logo_deets_ex;
		}
	}

	@Override
	public int getHallId() {
		return 4;
	}
}
