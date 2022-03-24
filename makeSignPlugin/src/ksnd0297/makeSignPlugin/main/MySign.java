package ksnd0297.makeSignPlugin.main;

import org.bukkit.block.Sign;

public class MySign {
	public int x, y, z;
	public String item;
	public int buy;
	public int sell;
	public String matchItem;

	public MySign(Sign sign, String item, int buy, int sell, String matchItem) {
		this.x = sign.getX();
		this.y = sign.getY();
		this.z = sign.getZ();
		this.item = item;
		this.buy = buy;
		this.sell = sell;
		this.matchItem = matchItem;
	}

	public MySign(int x, int y, int z, String item, int buy, int sell, String matchItem) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.item = item;
		this.buy = buy;
		this.sell = sell;
		this.matchItem = matchItem;
	}
}
