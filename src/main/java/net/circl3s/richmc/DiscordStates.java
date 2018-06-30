package net.circl3s.richmc;

import net.minecraft.client.Minecraft;
import java.time.Instant;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordRPC;

public class DiscordStates {

  public static void inMenu() {
    DiscordRichPresence drp = new DiscordRichPresence();

    drp.details = "In Menu";
    drp.state = "Just chillin'";
    drp.largeImageKey = "logo_large";
    drp.largeImageText = "Made possible by RichMC!";
    DiscordRPC.discordUpdatePresence(drp);
  }

  public static void inGame() {
    DiscordRichPresence drp = new DiscordRichPresence();

    boolean isOffline = Minecraft.getMinecraft().isIntegratedServerRunning();
    String ign = Minecraft.getMinecraft().player.getDisplayNameString();
    String gamemode = Minecraft.getMinecraft().playerController.getCurrentGameType().getName();

    drp.details = "IGN: " + ign;
    drp.state = "Playing " + gamemode;
    if(isOffline == true) {
      drp.largeImageKey = "sp";
      drp.largeImageText = "Playing Singleplayer";
    } else {
      drp.largeImageKey = "mp";
      drp.largeImageText = "Playing Multiplayer";
    }
    drp.smallImageKey = "logo_small";
    drp.smallImageText = "Made possible by RichMC!";
    Instant instant = Instant.now();
    long timeStampSeconds = instant.getEpochSecond();
    drp.startTimestamp = timeStampSeconds;
    DiscordRPC.discordUpdatePresence(drp);
  }

}