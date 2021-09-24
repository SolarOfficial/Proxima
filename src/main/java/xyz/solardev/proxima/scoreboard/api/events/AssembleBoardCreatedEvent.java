package xyz.solardev.proxima.scoreboard.api.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.solardev.proxima.scoreboard.api.AssembleBoard;

@Getter @Setter
public class AssembleBoardCreatedEvent extends Event {

    @Getter public static HandlerList handlerList = new HandlerList();

    private boolean cancelled = false;
    private final AssembleBoard board;

    /**
     * Assemble Board Created Event.
     *
     * @param board of player.
     */
    public AssembleBoardCreatedEvent(AssembleBoard board) {
        this.board = board;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
