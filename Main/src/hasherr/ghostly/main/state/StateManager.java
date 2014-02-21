package hasherr.ghostly.main.state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hasherr.ghostly.main.entity.Ghost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 2/10/14
 */
public class StateManager
{
    List<State> currentStates;
    public StateManager(OrthographicCamera camera)
    {
        currentStates = new ArrayList<State>();
        currentStates.add(new PauseState(camera)); // temporary.
    }

    public void render(SpriteBatch batch)
    {
        getCurrentState().render(batch);
    }

    public void update()
    {
        getCurrentState().update();
    }

    public Ghost getPlayerIfCorrectState() throws IllegalStateException
    {
        if (getCurrentState() instanceof GameState)
        {
            return ((GameState) getCurrentState()).playerGhost;
        }
        else
        {
            return null;
        }
    }

    public State getCurrentState()
    {
        State currentState = currentStates.get(currentStates.size() - 1);
        return currentState;
    }

}

