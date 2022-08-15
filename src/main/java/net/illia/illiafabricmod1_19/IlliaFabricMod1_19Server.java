package net.illia.illiafabricmod1_19;

import net.fabricmc.api.DedicatedServerModInitializer;
import org.slf4j.Logger;

public class IlliaFabricMod1_19Server implements DedicatedServerModInitializer {
	static final String error = "THE SERVER HAS FAILED TO INITIALIZE";
	static final String souterror = "§4[ERROR]§r THE SERVER HAS FAILED TO INITIALIZE";
	public static Logger logger = IlliaFabricMod1_19.LOGGER;
	public static boolean failedInitializing;

	@Override
	public void onInitializeServer() {
		System.out.println("The Server Has Initialized");
		logger.warn("THE SERVER IS READY");
		failedInitializing = false;
	}

	public static void onFailInitialize() {
		if (failedInitializing) {
			System.out.println(souterror);
			logger.error(error);
		}
	}
}
