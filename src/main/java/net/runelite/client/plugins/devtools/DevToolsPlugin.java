/*
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.devtools;

import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import java.awt.image.BufferedImage;

@PluginDescriptor(
	name = "Developer Tools",
	tags = {"panel"},
	loadWhenOutdated = true,
		developerPlugin = true
)
public class DevToolsPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private PluginToolbar clientToolbar;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private DevToolsOverlay overlay;

	@Inject
	private LocationOverlay locationOverlay;

	@Inject
	private SceneOverlay sceneOverlay;

	@Inject
	private CameraOverlay cameraOverlay;

	@Inject
	private WorldMapLocationOverlay worldMapLocationOverlay;

	@Inject
	private WorldMapRegionOverlay mapRegionOverlay;


	@Inject
	private EventBus eventBus;

	private DevToolsButton players;
	private DevToolsButton npcs;
	private DevToolsButton groundItems;
	private DevToolsButton groundObjects;
	private DevToolsButton gameObjects;
	private DevToolsButton graphicsObjects;
	private DevToolsButton walls;
	private DevToolsButton decorations;
	private DevToolsButton inventory;
	private DevToolsButton projectiles;
	private DevToolsButton location;
	@Getter
	private DevToolsButton overlays, underlays;

	public DevToolsButton getCutsceneCamera() {
		return cutsceneCamera;
	}

	private DevToolsButton cutsceneCamera;
	private DevToolsButton chunkBorders;
	private DevToolsButton mapSquares;
	private DevToolsButton validMovement;
	private DevToolsButton lineOfSight;
	private DevToolsButton cameraPosition;
	private DevToolsButton worldMapLocation;
	private DevToolsButton tileLocation;
	private DevToolsButton cursorPos;
	private DevToolsButton interacting;
	private DevToolsButton examine;
	private DevToolsButton detachedCamera;
	private DevToolsButton logMenuActions;
	private NavigationButton navButton;

	@Provides
	DevToolsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DevToolsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{

		players = new DevToolsButton("Players");
		npcs = new DevToolsButton("NPCs");

		groundItems = new DevToolsButton("Ground Items");
		groundObjects = new DevToolsButton("Ground Objects");
		gameObjects = new DevToolsButton("Game Objects");
		graphicsObjects = new DevToolsButton("Graphics Objects");
		walls = new DevToolsButton("Walls");
		decorations = new DevToolsButton("Decorations");

		inventory = new DevToolsButton("Inventory");
		projectiles = new DevToolsButton("Projectiles");

		location = new DevToolsButton("Location");
		cutsceneCamera = new DevToolsButton("Cutscene Camera");
		worldMapLocation = new DevToolsButton("World Map Location");

		tileLocation = new DevToolsButton("Tile Location");
		cursorPos = new DevToolsButton("Cursor Position");

		cameraPosition = new DevToolsButton("Camera Position");
		chunkBorders = new DevToolsButton("Chunk Borders");

		mapSquares = new DevToolsButton("Map Squares");
		lineOfSight = new DevToolsButton("Line Of Sight");

		validMovement = new DevToolsButton("Valid Movement");
		interacting = new DevToolsButton("Interacting");

		examine = new DevToolsButton("Examine");
		detachedCamera = new DevToolsButton("Detached Camera");
		logMenuActions = new DevToolsButton("Menu Actions");
		underlays = new DevToolsButton("Underlays");
		overlays = new DevToolsButton("Overlays");

		overlayManager.add(overlay);
		overlayManager.add(locationOverlay);
		overlayManager.add(sceneOverlay);
		overlayManager.add(cameraOverlay);
		overlayManager.add(worldMapLocationOverlay);
		overlayManager.add(mapRegionOverlay);

		final DevToolsPanel panel = injector.getInstance(DevToolsPanel.class);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "devtools_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Developer Tools")
			.icon(icon)
			.priority(1)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		overlayManager.remove(locationOverlay);
		overlayManager.remove(sceneOverlay);
		overlayManager.remove(cameraOverlay);
		overlayManager.remove(worldMapLocationOverlay);
		overlayManager.remove(mapRegionOverlay);
		clientToolbar.removeNavigation(navButton);
	}



	private void onCommandExecuted(CommandExecuted commandExecuted)
	{

	}

	private void onMenuEntryAdded(MenuEntryAdded event)
	{

	}

	private TileObject findTileObject(Tile tile, int id)
	{
		if (tile == null)
		{
			return null;
		}

		final GameObject[] tileGameObjects = tile.getGameObjects();
		final DecorativeObject tileDecorativeObject = tile.getDecorativeObject();

		if (tileDecorativeObject != null && tileDecorativeObject.getId() == id)
		{
			return tileDecorativeObject;
		}

		for (GameObject object : tileGameObjects)
		{
			if (object == null)
			{
				continue;
			}

			if (object.getId() == id)
			{
				return object;
			}

			// Check impostors
			final ObjectComposition comp = client.getObjectDefinition(object.getId());

			if (comp.getImpostorIds() != null)
			{
				for (int impostorId : comp.getImpostorIds())
				{
					if (impostorId == id)
					{
						return object;
					}
				}
			}
		}

		return null;
	}

	public Client getClient() {
		return this.client;
	}

	public PluginToolbar getClientToolbar() {
		return this.clientToolbar;
	}

	public OverlayManager getOverlayManager() {
		return this.overlayManager;
	}

	public DevToolsOverlay getOverlay() {
		return this.overlay;
	}

	public LocationOverlay getLocationOverlay() {
		return this.locationOverlay;
	}

	public SceneOverlay getSceneOverlay() {
		return this.sceneOverlay;
	}

	public CameraOverlay getCameraOverlay() {
		return this.cameraOverlay;
	}

	public WorldMapLocationOverlay getWorldMapLocationOverlay() {
		return this.worldMapLocationOverlay;
	}

	public WorldMapRegionOverlay getMapRegionOverlay() {
		return this.mapRegionOverlay;
	}

	public EventBus getEventBus() {
		return this.eventBus;
	}

	public DevToolsButton getPlayers() {
		return this.players;
	}

	public DevToolsButton getNpcs() {
		return this.npcs;
	}

	public DevToolsButton getGroundItems() {
		return this.groundItems;
	}

	public DevToolsButton getGroundObjects() {
		return this.groundObjects;
	}

	public DevToolsButton getGameObjects() {
		return this.gameObjects;
	}

	public DevToolsButton getGraphicsObjects() {
		return this.graphicsObjects;
	}

	public DevToolsButton getWalls() {
		return this.walls;
	}

	public DevToolsButton getDecorations() {
		return this.decorations;
	}

	public DevToolsButton getInventory() {
		return this.inventory;
	}

	public DevToolsButton getProjectiles() {
		return this.projectiles;
	}

	public DevToolsButton getLocation() {
		return this.location;
	}

	public DevToolsButton getChunkBorders() {
		return this.chunkBorders;
	}

	public DevToolsButton getMapSquares() {
		return this.mapSquares;
	}

	public DevToolsButton getValidMovement() {
		return this.validMovement;
	}

	public DevToolsButton getLineOfSight() {
		return this.lineOfSight;
	}

	public DevToolsButton getCameraPosition() {
		return this.cameraPosition;
	}

	public DevToolsButton getWorldMapLocation() {
		return this.worldMapLocation;
	}

	public DevToolsButton getTileLocation() {
		return this.tileLocation;
	}

	public DevToolsButton getCursorPos() {
		return this.cursorPos;
	}

	public DevToolsButton getInteracting() {
		return this.interacting;
	}

	public DevToolsButton getExamine() {
		return this.examine;
	}

	public DevToolsButton getDetachedCamera() {
		return this.detachedCamera;
	}

	public DevToolsButton getLogMenuActions() {
		return this.logMenuActions;
	}

	public NavigationButton getNavButton() {
		return this.navButton;
	}
}
