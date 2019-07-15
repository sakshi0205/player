package dao;

import java.util.HashMap;

import bean.Player;

public class PlayerDaoImpl implements PlayerDao {
	HashMap<String,Player> map=new HashMap<String,Player>();

	@Override
	public void putPlayer(String countryName, Player player) {
		// TODO Auto-generated method stub
		map.put(countryName, player);
	}

	@Override
	public HashMap<String, Player> getPlayer() {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public void updatePlayer(String countryName, String playerName) {
		// TODO Auto-generated method stub
		for(Player player: map.values())
		{
			if(player.getCountryName().equals(countryName))
			{
				player.setPlayerName(playerName);
			}
		}
	}

	@Override
	public void deletePlayer(String countryName) {
		// TODO Auto-generated method stub
		for(Player player: map.values())
		{
			if(player.getCountryName().equals(countryName))
			{
				map.remove(countryName);
			}
		}
	}

}
