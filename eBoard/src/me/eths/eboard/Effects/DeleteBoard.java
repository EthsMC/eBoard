package me.eths.eboard.Effects;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.eths.eboard.Util.LunarBoard;

public class DeleteBoard extends Effect {
	private Expression<Player> players;
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
		this.players = (Expression<Player>)expressions[0];
		return true;
	}
	
	public String toString(Event event, boolean debug) {
		return "";
	}
	
	protected void execute(Event event) {
		if (this.players == null)
			return;
		for (Player p : players.getArray(event)) {
			LunarBoard.deleteAllLines(p);
		}
	}
}
