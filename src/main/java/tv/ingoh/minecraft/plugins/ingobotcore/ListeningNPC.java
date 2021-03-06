package tv.ingoh.minecraft.plugins.ingobotcore;

import com.mojang.authlib.GameProfile;

import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.WorldServer;
import tv.ingoh.minecraft.plugins.ingobotcore.discord.DiscordInterface;

public class ListeningNPC extends EntityPlayer {

    Main main;
    DiscordInterface discord;

    public ListeningNPC(MinecraftServer minecraftserver, WorldServer worldserver, GameProfile gameprofile, Main main, DiscordInterface discord) {
        super(minecraftserver, worldserver, gameprofile, null);
        this.main = main;
        this.discord = discord;
    }

    @Override
    public void a(IChatBaseComponent ichatbasecomponent, boolean a) {
        super.a(ichatbasecomponent, a);
        discord.sendChat(ichatbasecomponent.getString(), false);
    }
}
