package hasherr.ghostly.main.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hasherr.ghostly.main.state.StateManager;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 2/10/14
 */
public class Game implements ApplicationListener
{
    OrthographicCamera camera;
    SpriteBatch batch;
    StateManager stateManager;

    @Override
    public void create()
    {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);
        camera.update();

        batch = new SpriteBatch();

        stateManager = new StateManager(camera);
        stateManager.updateBal();
    }

    @Override
    public void render()
    {
        clearScreen();

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        adjustCameraPosition();     // Set the camera's position as close to the rendering as
        stateManager.render(batch); // possible so that the camera doesn't lag behind the player.
        batch.end();

        stateManager.update();
    }

    private void clearScreen()
    {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    private void adjustCameraPosition()
    {
        float cameraPositionBuffer = 125f;
        camera.position.x = stateManager.getCorrectCameraPosition() + cameraPositionBuffer;
    }

    @Override
    public void dispose()
    {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {
        stateManager.switchToPauseState();
    }

    @Override
    public void resume()
    {
        Gdx.app.log("Debug1", "YEAH THIS JUST GOT CALLED");
    }
}
