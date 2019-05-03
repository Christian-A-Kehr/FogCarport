/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.FogException;

/**
 *
 * @author Mkhansen
 */
abstract class Command {
    
    private static HashMap<String, Command> commands;
    private final static Command UNKNOWNCOMMAND = new UnknownCommand(); 

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "GoToOrderPage", new GoToOrderPage() );
//        commands.put( "login", new Login() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, UNKNOWNCOMMAND );
    }

   abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws FogException;

}