package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.FogException;

/**
 *
 * @author Mkhansen
 */
public class UnknownCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        String msg = "Something went wrong";
        throw new FogException( msg );
    }
}
