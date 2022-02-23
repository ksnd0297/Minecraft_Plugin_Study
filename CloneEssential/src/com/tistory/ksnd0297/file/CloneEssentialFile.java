package com.tistory.ksnd0297.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class CloneEssentialFile extends JavaPlugin {

	public void makeFile(File f) {
		if (!f.exists() || !f.isFile()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void mapToFile(File f, HashMap<UUID, Location> map) {
		try {
			FileWriter writer = new FileWriter(f, false);
			for (UUID uuid : map.keySet()) {
				String X = Double.toString(map.get(uuid).getX());
				String Y = Double.toString(map.get(uuid).getY());
				String Z = Double.toString(map.get(uuid).getZ());

				String position = X + "," + Y + "," + Z;
				writer.write(uuid.toString() + "|" + position + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileToMap(File f, HashMap<UUID, Location> map) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String fileLine = null;
			while ((fileLine = reader.readLine()) != null) {
				UUID uuid = UUID.fromString(fileLine.split("\\|")[0]);
				String str = fileLine.split("\\|")[1];
			}
		} catch (FileNotFoundException e3) {
			e3.printStackTrace();
		} catch (IOException e4) {
			e4.printStackTrace();
		}
	}
}
