package com.oracle.education.coherence.examples;

import com.tangosol.util.MapTrigger;
import com.tangosol.util.MapTriggerListener;

public class MTFactory {

	public static MapTriggerListener createTriggerListener() {
		MapTrigger trigger = new ToUpperMapTrigger();
		return new MapTriggerListener(trigger);
	}
}