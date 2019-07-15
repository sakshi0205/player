package dao;

import java.util.HashMap;

import bean.Player;

public interface PlayerDao {

	public void putPlayer(String countryName,Player player);
	public HashMap<String,Player>getPlayer();
	public void updatePlayer(String countryName,String playerName);
	public void deletePlayer(String countryName);
}
