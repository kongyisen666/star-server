package com.star.util;

import io.ebean.Ebean;
import io.ebean.EbeanServer;

public class EbeanServerUtil {
	public static EbeanServer getScrmServer() {
		EbeanServer server = Ebean.getServer("scrm");
		return server;
	}
}
