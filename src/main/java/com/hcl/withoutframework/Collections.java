package com.hcl.withoutframework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(0, "Hello");
		hm.put(1, "Good Morning");
		hm.put(2, "Good Evening");
		System.out.println(hm);
		// System.out.println(hm.get(2));
		Set sn = hm.entrySet();
		Iterator it = sn.iterator();

		while (it.hasNext()) {
			// System.out.println(it.next());
			Map.Entry mp = (Map.Entry) it.next();
			System.out.println(mp.getKey());
			System.out.println(mp.getValue());
		}

	}

}
