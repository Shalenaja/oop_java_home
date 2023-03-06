package oop_java_home_6;

import java.util.Arrays;
import java.util.List;


final class CommandManager {

    private List<CommandHandler> handlers;

    CommandManager(List<CommandHandler> handlers) {
        this.handlers = handlers;  
    }

    public void acceptCommand(String command) {
        String[] split = command.split(" ");
        String commandName = split[0];
        String[] commandArgs = Arrays.copyOfRange(split, 1, split.length);
      
        boolean found = false;
        for (CommandHandler handler : handlers) {                
            if (commandName.equals(handler.name())) {
                found = true;
                try {
                    handler.runCommand(commandArgs);
                } catch (Exception e) {
                    System.err.println("Во время обработки команды \"" + commandName + "\" произошла ошибка: " + e.getMessage());
                }
            }
        }

        if (!found) {
            System.out.println("Команда не найдена");
        }
    }   
}