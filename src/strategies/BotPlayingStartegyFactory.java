package strategies;

import models.BotLevel;

public class BotPlayingStartegyFactory {
    public static BotPlayingStrategy getBotPlayingStartegy(BotLevel botLevel){
        if(botLevel == BotLevel.EASY){
            return new EasyBotPlayingStartegy();
        }
        return null;
    }
}
